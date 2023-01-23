package demo.rest.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.oidc.token.propagation.AccessToken;
import org.eclipse.microprofile.config.ConfigProvider;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.client.impl.ClientResponseImpl;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RegisterRestClient(configKey="BlockTypeCategoryService-api")
@AccessToken
public interface BlockTypeCategoryService  {

    default String getBlockTypeApiPlatformFromProperties() {
        return ConfigProvider.getConfig().getValue("block_type.api.platform",String.class);
    }

    // WebClient Call by Quarkus Framework ( client is defined in application.properties )
    @GET
    Response getAllBlockTypesWebClientCall(@HeaderParam("platform") String blockTypeApiPlatformFromProperties);

    default boolean isValidBlockType(String queryBlockTypeApiPlatform) {
        return getAllBlockTypes().stream()
                .filter(rec -> rec.getBlockType().equals(queryBlockTypeApiPlatform)).count() >= 1;
    }

    default Optional<BlockTypeCategoryDTO> getBlockTypeByCategoryAndType(String queryBlockTypeApiPlatform,
                                                                         String queryCategory){
        List<BlockTypeCategoryDTO> retrievedList =
                getAllBlockTypes().stream()
                        .filter(
                                rec ->
                                        rec.getBlockType().equals(queryBlockTypeApiPlatform)
                                                && rec.getCategoryName().equalsIgnoreCase(queryCategory))
                        .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(retrievedList)) return Optional.empty();
        return Optional.of(retrievedList.get(0));
    }

    default Optional<BlockTypeCategoryDTO> getBlockTypeByType(String queryBlockTypeApiPlatform) {
        List<BlockTypeCategoryDTO> retrievedList =
                getAllBlockTypes().stream()
                        .filter(rec -> rec.getBlockType().equals(queryBlockTypeApiPlatform))
                        .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(retrievedList)) return Optional.empty();
        return Optional.of(retrievedList.get(0));
    }

    default List<BlockTypeCategoryDTO> getAllBlockTypes() {
        Response response = getAllBlockTypesWebClientCall(getBlockTypeApiPlatformFromProperties());
        return obtainPojoFromResponse(response, new BlockTypeCategoryDTO());
    }

    default List<BlockTypeCategoryDTO> obtainPojoFromResponse(Response response, BlockTypeCategoryDTO type) {
        List<BlockTypeCategoryDTO> finalResultSet = new ArrayList<BlockTypeCategoryDTO>();
        ByteArrayInputStream bis = (ByteArrayInputStream) ((ClientResponseImpl) response).getEntityStream();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            byte b = (byte) result;
            buf.write(b);
            result = bis.read();
        }
        String resultString = buf.toString();

        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String,Object> map = mapper.readValue(resultString, Map.class);
            List<Map> dataList = (List<Map>) map.get("data");
            for (Map currentMap : dataList){
                ObjectMapper mapper2 = new ObjectMapper();
                mapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                BlockTypeCategoryDTO foundObject = (BlockTypeCategoryDTO) mapper2.convertValue(currentMap, type.getClass());
                finalResultSet.add(foundObject);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return finalResultSet;

    }
}
