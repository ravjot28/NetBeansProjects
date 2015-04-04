
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
public class InventoryUnit {

    private String Id;
    private List<AttributesInventory> attributes;
    private AttributesInventory internalAttributes;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<AttributesInventory> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributesInventory> attributes) {
        this.attributes = attributes;
    }

    public AttributesInventory getInternalAttributes() {
        return internalAttributes;
    }

    public void setInternalAttributes(AttributesInventory internalAttributes) {
        this.internalAttributes = internalAttributes;
    }
}
