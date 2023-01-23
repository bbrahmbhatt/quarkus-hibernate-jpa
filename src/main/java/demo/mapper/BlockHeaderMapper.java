package demo.mapper;

import demo.database.BlockHeader;
import demo.rest.controllers.BlockHeaderDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class BlockHeaderMapper {

    public abstract BlockHeaderDTO toBlockDTO(BlockHeader entity);

    public abstract BlockHeader toEntity(BlockHeaderDTO blockDTO);

}
