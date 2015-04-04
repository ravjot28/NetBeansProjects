import java.util.ArrayList;


public class Node {
ArrayList<Equipment> equip;

public ArrayList<Equipment> getEquip() {
	return equip;
}

public void setEquip(ArrayList<Equipment> equip) {
	this.equip = equip;
}
private String AdjustDate;
//private String FunctionType;
private String Name;
//private String Site;
private String Type;
//private String UserLabel;

public String getAdjustDate() {
	return AdjustDate;
}

public void setAdjustDate(String adjustDate) {
	AdjustDate = adjustDate;
}

@Override
public String toString() {
	return "Node [equip=" + equip + ", AdjustDate=" + AdjustDate + ", Name="
			+ Name + ", Type=" + Type + "]";
}

/*public void setFunctionType(String functionType) {
	FunctionType = functionType;
}
*/
public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

/*public String getSite() {
	return Site;
}
*/
/*public void setSite(String site) {
	Site = site;
}
*/
public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

/*public String getUserLabel() {
	return UserLabel;
}

public void setUserLabel(String userLabel) {
	UserLabel = userLabel;
}
*/
}
