package demo.rest.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

public class BlockTypeCategoryDTO   {

    public BlockTypeCategoryDTO() {

    }

    public BlockTypeCategoryDTO(Long blockTypeCategoryId, String blockType, String categoryName, String description) {
        this.blockTypeCategoryId = blockTypeCategoryId;
        this.blockType = blockType;
        this.categoryName = categoryName;
        this.description = description;
    }

    private Long blockTypeCategoryId;

    private String blockType;

    private String categoryName;

    private String description;

    public Long getBlockTypeCategoryId() {
        return blockTypeCategoryId;
    }

    public void setBlockTypeCategoryId(Long blockTypeCategoryId) {
        this.blockTypeCategoryId = blockTypeCategoryId;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
