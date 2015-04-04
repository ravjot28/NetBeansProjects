package com.rvp.dto;

public class StaffDetailsDTO {

    private String BankMgr;
    private int staffCode;
    private String branchAsst;

    public String getBankMgr() {
        return BankMgr;
    }

    public void setBankMgr(String BankMgr) {
        this.BankMgr = BankMgr;
    }

    public String getBranchAsst() {
        return branchAsst;
    }

    public void setBranchAsst(String branchAsst) {
        this.branchAsst = branchAsst;
    }

    public int getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(int staffCode) {
        this.staffCode = staffCode;
    }
}
