package demo.mapper;

import demo.database.BlockHeader;
import demo.rest.controllers.BlockHeaderDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class BlockHeaderMapperImpl extends BlockHeaderMapper {

    @Override
    public BlockHeaderDTO toBlockDTO(BlockHeader entity) {
        if ( entity == null ) {
            return null;
        }

        BlockHeaderDTO blockHeaderDTO = new BlockHeaderDTO();

        blockHeaderDTO.setBlockHeaderId( entity.getBlockHeaderId() );
        blockHeaderDTO.setBlockTypeCategoryId( entity.getBlockTypeCategoryId() );
        blockHeaderDTO.setLongName( entity.getLongName() );
        blockHeaderDTO.setStatusCode( entity.getStatusCode() );
        blockHeaderDTO.setIdentifyingName( entity.getIdentifyingName() );
        blockHeaderDTO.setMasterCustomerSetId( entity.getMasterCustomerSetId() );
        blockHeaderDTO.setNotes( entity.getNotes() );
        blockHeaderDTO.setTrackingId( entity.getTrackingId() );
        blockHeaderDTO.setMasterCustomerSetLongNm( entity.getMasterCustomerSetLongNm() );
        blockHeaderDTO.setBlockTypeCode( entity.getBlockTypeCode() );

        return blockHeaderDTO;
    }

    @Override
    public BlockHeader toEntity(BlockHeaderDTO blockDTO) {
        if ( blockDTO == null ) {
            return null;
        }

        BlockHeader blockHeader = new BlockHeader();

        blockHeader.setBlockHeaderId( blockDTO.getBlockHeaderId() );
        blockHeader.setBlockTypeCategoryId( blockDTO.getBlockTypeCategoryId() );
        blockHeader.setStatusCode( blockDTO.getStatusCode() );
        blockHeader.setLongName( blockDTO.getLongName() );
        blockHeader.setIdentifyingName( blockDTO.getIdentifyingName() );
        blockHeader.setMasterCustomerSetId( blockDTO.getMasterCustomerSetId() );
        blockHeader.setNotes( blockDTO.getNotes() );
        blockHeader.setTrackingId( blockDTO.getTrackingId() );
        blockHeader.setBlockTypeCode( blockDTO.getBlockTypeCode() );
        blockHeader.setMasterCustomerSetLongNm( blockDTO.getMasterCustomerSetLongNm() );

        if (StringUtils.isNotEmpty(blockDTO.getBlockTypeCode())
                && StringUtils.isNotEmpty(blockDTO.getIdentifyingName())) {
            blockHeader.setIdentifyingName(blockDTO.getBlockTypeCode() + blockDTO.getIdentifyingName());
        }

        return blockHeader;
    }

}
