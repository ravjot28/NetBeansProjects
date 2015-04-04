package com.rvp.dto;

public class ProofDetailsDTO {

    private String idProof;
    private String incomeProof;
    private String ageProof;
    private String addressProof;
    private String panNumber;

    public String getAddressProof() {
        return addressProof;
    }

    public void setAddressProof(String addressProof) {
        this.addressProof = addressProof;
    }

    public String getAgeProof() {
        return ageProof;
    }

    public void setAgeProof(String ageProof) {
        this.ageProof = ageProof;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getIncomeProof() {
        return incomeProof;
    }

    public void setIncomeProof(String incomeProof) {
        this.incomeProof = incomeProof;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
