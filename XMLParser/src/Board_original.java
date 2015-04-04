
public class Board_original {
ProductData pd;
public String Name;
public String SlotPosition;
public String Type;
public String getName() {
	return Name;
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

public ProductData getPd() {
	return pd;
}

public void setPd(ProductData pd) {
	this.pd = pd;
}

@Override
public String toString() {
	return "Board [pd=" + pd + ", Name=" + Name + ", SlotPosition="
			+ SlotPosition + ", Type=" + Type + "]";
}

}
