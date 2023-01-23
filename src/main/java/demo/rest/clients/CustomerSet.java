package demo.rest.clients;

import java.util.Date;

public class CustomerSet {

    public CustomerSet() {
    }

    public CustomerSet(Long customerSetId,
                       String customerName,
                       Long masterCustSetId,
                       Long custSetTypeId,
                       Date custSetEffectiveDate,
                       String custSetStatusCd,
                       Long customerId,
                       Long benefitCustomerSetId) {
        this.customerSetId = customerSetId;
        this.customerName = customerName;
        this.masterCustSetId = masterCustSetId;
        this.custSetTypeId = custSetTypeId;
        this.custSetEffectiveDate = custSetEffectiveDate;
        this.custSetStatusCd = custSetStatusCd;
        this.customerId = customerId;
        this.benefitCustomerSetId = benefitCustomerSetId;
    }

    private static final Integer argusMasterCustomerSetId = 1;
    private Long customerSetId;
    private String customerName;
    private Long masterCustSetId;
    private Long custSetTypeId;
    private Date custSetEffectiveDate;
    private String custSetStatusCd;
    private Long customerId;
    private Long benefitCustomerSetId;

    public Long getCustomerSetId() {
        return this.customerSetId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Long getMasterCustSetId() {
        return this.masterCustSetId;
    }

    public Long getCustSetTypeId() {
        return this.custSetTypeId;
    }

    public Date getCustSetEffectiveDate() {
        return this.custSetEffectiveDate;
    }

    public String getCustSetStatusCd() {
        return this.custSetStatusCd;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public Long getBenefitCustomerSetId() {
        return this.benefitCustomerSetId;
    }

    public void setCustomerSetId(Long customerSetId) {
        this.customerSetId = customerSetId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMasterCustSetId(Long masterCustSetId) {
        this.masterCustSetId = masterCustSetId;
    }

    public void setCustSetTypeId(Long custSetTypeId) {
        this.custSetTypeId = custSetTypeId;
    }

    public void setCustSetEffectiveDate(Date custSetEffectiveDate) {
        this.custSetEffectiveDate = custSetEffectiveDate;
    }

    public void setCustSetStatusCd(String custSetStatusCd) {
        this.custSetStatusCd = custSetStatusCd;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setBenefitCustomerSetId(Long benefitCustomerSetId) {
        this.benefitCustomerSetId = benefitCustomerSetId;
    }


}
