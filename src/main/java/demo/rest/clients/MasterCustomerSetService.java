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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RegisterRestClient(configKey="MasterCustomerSetService-api")
@AccessToken
public interface MasterCustomerSetService  {

    default String getCustomerSetApiPlatformFromProperties() {
        return ConfigProvider.getConfig().getValue("customer_set.api.platform",String.class);
    }

    default String getPharmacySecurtiyResourceFromProperties() {
        return ConfigProvider.getConfig().getValue("pharmacy.security.resource",String.class);
    }

    // WebClient Call by Quarkus Framework ( client is defined in application.properties )
    @GET
    Response getMasterCustomerSetByTypeAndResourceWebClientCall(
            @HeaderParam("platform") String customerSetApiPlatformFromProperties,
            @QueryParam("type") String queryCustomerSetTypeName,
            @QueryParam("resource") String pharmacySecurtiyResourceFromProperties);

    default List<CustomerSet> getMasterCustomerSetByTypeAndResource(String queryCustomerSetTypeName) {

        Response response = getMasterCustomerSetByTypeAndResourceWebClientCall(getCustomerSetApiPlatformFromProperties(),
                                                                               queryCustomerSetTypeName,
                                                                               getPharmacySecurtiyResourceFromProperties());
        return obtainPojoFromResponse(response, new CustomerSet());
    }

    default Optional<CustomerSet> getMasterCustomerSetByName(String queryMasterCustomerSetName,
                                                             String queryCustomerSetTypeName) {

        List<CustomerSet> list = this.getMasterCustomerSetByTypeAndResource(queryCustomerSetTypeName);
        if (!CollectionUtils.isEmpty(list)) {
            List<CustomerSet> filteredList = (List)list.stream().filter((rec) -> {
                return rec.getCustomerName().equals(queryMasterCustomerSetName) && "A".equals(rec.getCustSetStatusCd());
            }).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(filteredList)) {
                return Optional.of((CustomerSet)filteredList.get(0));
            }
        }

        return Optional.empty();
    }

    default Optional<CustomerSet> getMasterCustomerSetById(long queryMasteCustomerSetId) {
        List<CustomerSet> list = this.getMasterCustomerSetByTypeAndResource("master");
        if (!CollectionUtils.isEmpty(list)) {
            List<CustomerSet> filteredList = (List)list.stream().filter((rec) -> {
                return rec.getCustomerSetId().equals(queryMasteCustomerSetId) && "A".equals(rec.getCustSetStatusCd());
            }).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(filteredList)) {
                return Optional.of((CustomerSet)filteredList.get(0));
            }
        }

        return Optional.empty();
    }

    default List<CustomerSet> obtainPojoFromResponse(Response response, CustomerSet type) {
        List<CustomerSet> finalResultSet = new ArrayList<CustomerSet>();
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
                CustomerSet foundObject = (CustomerSet) mapper2.convertValue(currentMap, type.getClass());
                finalResultSet.add(foundObject);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return finalResultSet;

    }


}
