package com.web.financeprocess;

public class EditModel {
     String editTextValue,mobile_no,beneficiary,amount;

    public EditModel(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    public EditModel(String editTextValue, String mobile_no, String beneficiary, String amount) {
        this.editTextValue = editTextValue;
        this.mobile_no = mobile_no;
        this.beneficiary = beneficiary;
        this.amount = amount;
    }

    public String getEditTextValue() {
        return editTextValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
