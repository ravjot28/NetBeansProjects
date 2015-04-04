public class attribute {

       private String inventoryUnitType;
       private String id;
       private String vendorUnitFamilyType;
       private String vendorUnitTypeNumber;
       private String vendorName;
       private String serialNumber;
       private String dateOfManufacture;
       private String unitPosition;
       private String manufacturerData;

       public attribute() {
       }

       public attribute(String inventoryUnitType, String id, String vendorUnitFamilyType,String vendorUnitTypeNumber, String vendorName, String serialNumber, String dateOfManufacture, String unitPosition, String manufacturerData)
       {
              this.inventoryUnitType = inventoryUnitType;
              this.id = id;
              this.vendorUnitFamilyType = vendorUnitFamilyType;
              this.vendorUnitTypeNumber= vendorUnitTypeNumber;
              this.vendorName= vendorName;
              this.serialNumber=serialNumber;
              this.dateOfManufacture=dateOfManufacture;
              this.unitPosition=unitPosition;
              this.manufacturerData=manufacturerData;
       }

	@Override
	public String toString() {
		return "attribute [inventoryUnitType=" + inventoryUnitType + ", id="
				+ id + ", vendorUnitFamilyType=" + vendorUnitFamilyType
				+ ", vendorUnitTypeNumber=" + vendorUnitTypeNumber
				+ ", vendorName=" + vendorName + ", serialNumber="
				+ serialNumber + ", dateOfManufacture=" + dateOfManufacture
				+ ", unitPosition=" + unitPosition + ", manufacturerData="
				+ manufacturerData + "]";
	}

	public String getInventoryUnitType() {
		return inventoryUnitType;
	}

	public void setInventoryUnitType(String inventoryUnitType) {
		this.inventoryUnitType = inventoryUnitType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getUnitPosition() {
		return unitPosition;
	}

	public void setUnitPosition(String unitPosition) {
		this.unitPosition = unitPosition;
	}

	public String getManufacturerData() {
		return manufacturerData;
	}

	public void setManufacturerData(String manufacturerData) {
		this.manufacturerData = manufacturerData;
	}
}
      