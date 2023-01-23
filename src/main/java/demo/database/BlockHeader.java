package demo.database;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pp_block_header")
public class BlockHeader implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pp_block_header_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockHeaderId;

    @Column(name = "block_type_category_id")
    private Long blockTypeCategoryId;

    @Column(name = "status_cd")
    private String statusCode;

    @Column(name = "long_nm")
    private String longName;

    @Column(name = "identifying_nm")
    private String identifyingName;

    @Column(name = "master_customer_set_id")
    private Long masterCustomerSetId;

    @Column(name = "notes_txt")
    private String notes;

    @Column(name = "tracking_id")
    private String trackingId;


    // Not Related to DB columns
    @Transient
    private String blockTypeCode;

    @Transient
    private String masterCustomerSetLongNm;

    public Long getBlockHeaderId() {
        return blockHeaderId;
    }

    public void setBlockHeaderId(Long blockHeaderId) {
        this.blockHeaderId = blockHeaderId;
    }

    public Long getBlockTypeCategoryId() {
        return blockTypeCategoryId;
    }

    public void setBlockTypeCategoryId(Long blockTypeCategoryId) {
        this.blockTypeCategoryId = blockTypeCategoryId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getIdentifyingName() {
        return identifyingName;
    }

    public void setIdentifyingName(String identifyingName) {
        this.identifyingName = identifyingName;
    }

    public Long getMasterCustomerSetId() {
        return masterCustomerSetId;
    }

    public void setMasterCustomerSetId(Long masterCustomerSetId) {
        this.masterCustomerSetId = masterCustomerSetId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getBlockTypeCode() {
        return blockTypeCode;
    }

    public void setBlockTypeCode(String blockTypeCode) {
        this.blockTypeCode = blockTypeCode;
    }

    public String getMasterCustomerSetLongNm() {
        return masterCustomerSetLongNm;
    }

    public void setMasterCustomerSetLongNm(String masterCustomerSetLongNm) {
        this.masterCustomerSetLongNm = masterCustomerSetLongNm;
    }

    // Audit Fields
    @Column(name = "process_create_ts")
    private OffsetDateTime processCreateTs;

    @Column(name = "process_create_by_user_id")
    private String processCreateByUserId;

    @Column(name = "process_create_by_program_id")
    private String processCreateByProgramId;

    @Column(name = "process_update_ts")
    private OffsetDateTime processUpdateTs;

    @Column(name = "process_update_by_user_id")
    private String processUpdateByUserId;

    @Column(name = "process_update_by_program_id")
    private String processUpdateByProgramId;

    public OffsetDateTime getProcessCreateTs() {
        return processCreateTs;
    }

    public void setProcessCreateTs(OffsetDateTime processCreateTs) {
        this.processCreateTs = processCreateTs;
    }

    public String getProcessCreateByUserId() {
        return processCreateByUserId;
    }

    public void setProcessCreateByUserId(String processCreateByUserId) {
        this.processCreateByUserId = processCreateByUserId;
    }

    public String getProcessCreateByProgramId() {
        return processCreateByProgramId;
    }

    public void setProcessCreateByProgramId(String processCreateByProgramId) {
        this.processCreateByProgramId = processCreateByProgramId;
    }

    public OffsetDateTime getProcessUpdateTs() {
        return processUpdateTs;
    }

    public void setProcessUpdateTs(OffsetDateTime processUpdateTs) {
        this.processUpdateTs = processUpdateTs;
    }

    public String getProcessUpdateByUserId() {
        return processUpdateByUserId;
    }

    public void setProcessUpdateByUserId(String processUpdateByUserId) {
        this.processUpdateByUserId = processUpdateByUserId;
    }

    public String getProcessUpdateByProgramId() {
        return processUpdateByProgramId;
    }

    public void setProcessUpdateByProgramId(String processUpdateByProgramId) {
        this.processUpdateByProgramId = processUpdateByProgramId;
    }


}
