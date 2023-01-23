package demo.rest.controllers;

import demo.database.BlockHeader;
import demo.database.BlockHeaderRepository;
import demo.rest.clients.CustomerSet;
import demo.mapper.BlockHeaderMapper;
import demo.rest.clients.BlockTypeCategoryDTO;
import demo.rest.clients.BlockTypeCategoryService;
import demo.rest.clients.MasterCustomerSetService;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/quarkus/benefit/api/costshare",
                produces = MediaType.APPLICATION_JSON_VALUE)
@Authenticated
public class BlockHeaderController {
    @Inject
    BlockHeaderRepository blockHeaderRepository;

    @Inject
    BlockHeaderMapper blockHeaderMapper;

    @Inject
    @RestClient
    MasterCustomerSetService masterCustomerSetService;

    @Inject
    @RestClient
    BlockTypeCategoryService blockTypeCategoryService;

    @GetMapping("/masterCustomerSetService")
    public List<CustomerSet> getMasterCustomerSetByTypeAndResource(@RequestParam("type") String customerSetType) {
        return masterCustomerSetService
                .getMasterCustomerSetByTypeAndResource(customerSetType);
    }

    @GetMapping("/blockTypeCategoryService")
    public List<BlockTypeCategoryDTO> getAllBlockTypes() {
        return blockTypeCategoryService.getAllBlockTypes();
    }

    @PostMapping("/blockheader")
public BlockHeaderDTO addBlockHeader(BlockHeaderDTO dto) throws Exception {
	BlockHeader inputEntity = blockHeaderMapper.toEntity(dto);

	Optional<BlockHeader> entityFound = blockHeaderRepository
			.findByBlockTypeCategoryIdAndLongName(
					inputEntity.getBlockTypeCategoryId(),
					inputEntity.getLongName());

	BlockHeader blockHeader = entityFound.isPresent() ? entityFound.get() : null;
	if(blockHeader != null) {
		BlockHeaderDTO blockHeaderDTO = blockHeaderMapper.toBlockDTO(blockHeader);
		return blockHeaderDTO;
	} else {
		throw new Exception("No Block Header Found!");
	}

}

}
