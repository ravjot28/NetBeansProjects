import java.util.ArrayList;


public class Board {
	ArrayList<ProductData> product;
public String Name;
public String SlotPosition;
public String Type;
public String getName() {
	return Name;
}


public ArrayList<ProductData> getProduct() {
	return product;
}


public void setProduct(ArrayList<ProductData> product) {
	this.product = product;
}


public void setName(String name) {
	Name = name;
}

public String getSlotPosition() {
	return SlotPosition;
}

public void setSlotPosition(String slotPosition) {
	SlotPosition = slotPosition;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

@Override
public String toString() {
	return "Board_new [product=" + product + ", Name=" + Name
			+ ", SlotPosition=" + SlotPosition + ", Type=" + Type + "]";
}

}
