package demo.rest.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BlockHeaderDTO   {

    @JsonProperty("blockHeaderId")
    private Long blockHeaderId = null;
    public BlockHeaderDTO blockHeaderId(Long blockHeaderId) {
        this.blockHeaderId = blockHeaderId;
        return this;
    }
    public Long getBlockHeaderId() {
        return blockHeaderId;
    }
    public void setBlockHeaderId(Long blockHeaderId) {
        this.blockHeaderId = blockHeaderId;
    }

    @JsonProperty("blockTypeCategoryId")
    private Long blockTypeCategoryId = null;

    @JsonProperty("longName")
    private String longName = null;

    @JsonProperty("statusCode")
    private String statusCode = null;

    @JsonProperty("identifyingName")
    private String identifyingName = null;

    @JsonProperty("masterCustomerSetId")
    private Long masterCustomerSetId = null;

    @JsonProperty("notes")
    private String notes = null;

    @JsonProperty("trackingId")
    private String trackingId = null;

    @JsonProperty("masterCustomerSetLongNm")
    private String masterCustomerSetLongNm = null;

    @JsonProperty("blockTypeCode")
    private String blockTypeCode = null;

    public BlockHeaderDTO blockTypeCategoryId(Long blockTypeCategoryId) {
        this.blockTypeCategoryId = blockTypeCategoryId;
        return this;
    }

    public Long getBlockTypeCategoryId() {
        return blockTypeCategoryId;
    }

    public void setBlockTypeCategoryId(Long blockTypeCategoryId) {
        this.blockTypeCategoryId = blockTypeCategoryId;
    }

    public BlockHeaderDTO longName(String longName) {
        this.longName = longName;
        return this;
    }

    @NotEmpty(message = "Name is required field")
    @Size(max = 35, message = "35 bytes are allowed in Name")
    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public BlockHeaderDTO statusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    @NotEmpty(message = "Status is required")
    @Pattern(regexp = "[NRI]", message = "Invalid Status (valid values of N, R, I)")
    @Size(max=1)
    public String getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public BlockHeaderDTO identifyingName(String identifyingName) {
        this.identifyingName = identifyingName;
        return this;
    }

    @NotEmpty(message = "ID is required field")
    @Size( max = 12, message = "12 bytes allowed in ID field")
    public String getIdentifyingName() {
        return identifyingName;
    }

    public void setIdentifyingName(String identifyingName) {
        this.identifyingName = identifyingName;
    }

    public BlockHeaderDTO masterCustomerSetId(Long masterCustomerSetId) {
        this.masterCustomerSetId = masterCustomerSetId;
        return this;
    }

    public Long getMasterCustomerSetId() {
        return masterCustomerSetId;
    }

    public void setMasterCustomerSetId(Long masterCustomerSetId) {
        this.masterCustomerSetId = masterCustomerSetId;
    }

    public BlockHeaderDTO notes(String notes) {
        this.notes = notes;
        return this;
    }

    @Size(max = 255, message = "255 bytes allowed in Notes field")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BlockHeaderDTO trackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    @NotEmpty(message = "Tracking ID is required")
    @Size( max = 20, message = " 20 bytes allowed in Tracking ID")
    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public BlockHeaderDTO masterCustomerSetLongNm(String masterCustomerSetLongNm) {
        this.masterCustomerSetLongNm = masterCustomerSetLongNm;
        return this;
    }

    @NotNull(message = "Master customer set Name is required")
    public String getMasterCustomerSetLongNm() {
        return masterCustomerSetLongNm;
    }

    public void setMasterCustomerSetLongNm(String masterCustomerSetLongNm) {
        this.masterCustomerSetLongNm = masterCustomerSetLongNm;
    }

    public BlockHeaderDTO blockTypeCode(String blockTypeCode) {
        this.blockTypeCode = blockTypeCode;
        return this;
    }

    @NotNull(message = "Tracking ID is required")
    @Size(min = 4, max = 4, message = "Block Type should be 4 characters")
    public String getBlockTypeCode() {
        return blockTypeCode;
    }

    public void setBlockTypeCode(String blockTypeCode) {
        this.blockTypeCode = blockTypeCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BlockHeaderDTO blockHeaderDTO = (BlockHeaderDTO) o;
        return Objects.equals(this.blockHeaderId, blockHeaderDTO.blockHeaderId) &&
                Objects.equals(this.blockTypeCategoryId, blockHeaderDTO.blockTypeCategoryId) &&
                Objects.equals(this.longName, blockHeaderDTO.longName) &&
                Objects.equals(this.statusCode, blockHeaderDTO.statusCode) &&
                Objects.equals(this.identifyingName, blockHeaderDTO.identifyingName) &&
                Objects.equals(this.masterCustomerSetId, blockHeaderDTO.masterCustomerSetId) &&
                Objects.equals(this.notes, blockHeaderDTO.notes) &&
                Objects.equals(this.trackingId, blockHeaderDTO.trackingId) &&
                Objects.equals(this.masterCustomerSetLongNm, blockHeaderDTO.masterCustomerSetLongNm) &&
                Objects.equals(this.blockTypeCode, blockHeaderDTO.blockTypeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockHeaderId, blockTypeCategoryId, longName, statusCode, identifyingName, masterCustomerSetId, notes, trackingId, masterCustomerSetLongNm, blockTypeCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BlockHeaderDTO {\n");

        sb.append("    blockHeaderId: ").append(toIndentedString(blockHeaderId)).append("\n");
        sb.append("    blockTypeCategoryId: ").append(toIndentedString(blockTypeCategoryId)).append("\n");
        sb.append("    longName: ").append(toIndentedString(longName)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
        sb.append("    identifyingName: ").append(toIndentedString(identifyingName)).append("\n");
        sb.append("    masterCustomerSetId: ").append(toIndentedString(masterCustomerSetId)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    trackingId: ").append(toIndentedString(trackingId)).append("\n");
        sb.append("    masterCustomerSetLongNm: ").append(toIndentedString(masterCustomerSetLongNm)).append("\n");
        sb.append("    blockTypeCode: ").append(toIndentedString(blockTypeCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
