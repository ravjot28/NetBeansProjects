public class Product_new {

public String FirstOperationDate;
public String LastChangedDate;
public String ManufacturedDate;
public String ProductName;
public String ProductNumber;
public String ProductRevision;
public String SerialNumber; 
public String Supplier;
public String getFirstOperationDate() {
	return FirstOperationDate;
}
public void setFirstOperationDate(String firstOperationDate) {
	FirstOperationDate = firstOperationDate;
}
public String getLastChangedDate() {
	return LastChangedDate;
}
public void setLastChangedDate(String lastChangedDate) {
	LastChangedDate = lastChangedDate;
}
public String getManufacturedDate() {
	return ManufacturedDate;
}
@Override
public String toString() {
	return "Product_new [FirstOperationDate=" + FirstOperationDate
			+ ", LastChangedDate=" + LastChangedDate + ", ManufacturedDate="
			+ ManufacturedDate + ", ProductName=" + ProductName
			+ ", ProductNumber=" + ProductNumber + ", ProductRevision="
			+ ProductRevision + ", SerialNumber=" + SerialNumber
			+ ", Supplier=" + Supplier + "]";
}
public void setManufacturedDate(String manufacturedDate) {
	ManufacturedDate = manufacturedDate;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public String getProductNumber() {
	return ProductNumber;
}
public void setProductNumber(String productNumber) {
	ProductNumber = productNumber;
}
public String getProductRevision() {
	return ProductRevision;
}
public void setProductRevision(String productRevision) {
	ProductRevision = productRevision;
}
public String getSerialNumber() {
	return SerialNumber;
}
public void setSerialNumber(String serialNumber) {
	SerialNumber = serialNumber;
}
public String getSupplier() {
	return Supplier;
}
public void setSupplier(String supplier) {
	Supplier = supplier;
}
}