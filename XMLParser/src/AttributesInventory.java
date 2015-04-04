/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
public class AttributesInventory {

    private String inventoryUnitType;
    private String id;
    private String vendorUnitFamilyType;
    private String vendorUnitTypeNumber;
    private String vendorName;
    private String serialNumber;
    private String dateOfManufacture;
    private String unitPosition;
    private String manufacturerData;

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInventoryUnitType() {
        return inventoryUnitType;
    }

    public void setInventoryUnitType(String inventoryUnitType) {
        this.inventoryUnitType = inventoryUnitType;
    }

    public String getManufacturerData() {
        return manufacturerData;
    }

    public void setManufacturerData(String manufacturerData) {
        this.manufacturerData = manufacturerData;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUnitPosition() {
        return unitPosition;
    }

    public void setUnitPosition(String unitPosition) {
        this.unitPosition = unitPosition;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorUnitFamilyType() {
        return vendorUnitFamilyType;
    }

    public void setVendorUnitFamilyType(String vendorUnitFamilyType) {
        this.vendorUnitFamilyType = vendorUnitFamilyType;
    }

    public String getVendorUnitTypeNumber() {
        return vendorUnitTypeNumber;
    }

    public void setVendorUnitTypeNumber(String vendorUnitTypeNumber) {
        this.vendorUnitTypeNumber = vendorUnitTypeNumber;
    }
}
