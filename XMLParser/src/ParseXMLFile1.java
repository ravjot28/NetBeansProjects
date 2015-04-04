/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXMLFile1 {

    static List<InventoryUnit> inventoryUnitList = new ArrayList<InventoryUnit>();
    static List<AttributesInventory> attributesInventory = null;
    static AttributesInventory attribute = null;
    static InventoryUnit iu = null;

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean inventoryUnitType = false;
                boolean vendorUnitFamilyType = false;
                boolean vendorUnitTypeNumber = false;
                boolean vendorName = false;
                boolean serialNumber = false;
                boolean dateOfManufacture = false;
                boolean unitPosition = false;
                boolean manufacturerData = false;
                boolean inventoryUnit = false;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    //System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("in:inventoryUnitType")) {
                        inventoryUnitType = true;
                    }

                    if (qName.equalsIgnoreCase("in:vendorUnitFamilyType")) {
                        vendorUnitFamilyType = true;
                    }

                    if (qName.equalsIgnoreCase("in:vendorUnitTypeNumber")) {
                        vendorUnitTypeNumber = true;
                    }

                    if (qName.equalsIgnoreCase("in:vendorName")) {
                        vendorName = true;
                    }

                    if (qName.equalsIgnoreCase("in:serialNumber")) {
                        serialNumber = true;
                    }

                    if (qName.equalsIgnoreCase("in:dateOfManufacture")) {
                        dateOfManufacture = true;
                    }

                    if (qName.equalsIgnoreCase("in:unitPosition")) {
                        unitPosition = true;
                    }

                    if (qName.equalsIgnoreCase("in:manufacturerData")) {
                        manufacturerData = true;
                    }

                    if (qName.equalsIgnoreCase("in:InventoryUnit")) {
                        int length = attributes.getLength();
                        //Each attribute
                        String value = null;
                        for (int i = 0; i < length; i++) {
                            value = attributes.getValue(i);

                        }
                        inventoryUnit = true;
                        try {
                            Integer.parseInt(value);

                            if (iu.getAttributes() == null) {
                                attributesInventory = new ArrayList<AttributesInventory>();
                            } else {
                                iu.setAttributes(attributesInventory);
                            }
                        } catch (Exception e) {
                            if (iu != null) {
                                inventoryUnitList.add(iu);
                            }
                            iu = new InventoryUnit();
                            iu.setId(value);

                        }


                    }

                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("in:manufacturerData")) {
                        attributesInventory = iu.getAttributes();
                        if (attributesInventory != null) {
                            attributesInventory.add(attribute);
                        } else {
                            attributesInventory = new ArrayList<AttributesInventory>();
                            attributesInventory.add(attribute);
                        }
                        iu.setAttributes(attributesInventory);
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    if (inventoryUnitType) {
                        inventoryUnitType = false;
                        //System.out.println("inventoryUnitType : " + new String(ch, start, length));

                        if (iu.getAttributes() == null) {
                            iu.setInternalAttributes(new AttributesInventory());
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setInventoryUnitType(value);
                        } else {
                            attribute = new AttributesInventory();
                            attribute.setInventoryUnitType(value);
                        }

                    }

                    if (vendorUnitFamilyType) {
                        //System.out.println("vendorUnitFamilyType : " + new String(ch, start, length));
                        vendorUnitFamilyType = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setVendorUnitFamilyType(value);
                        } else {
                            attribute.setVendorUnitFamilyType(value);
                        }
                    }

                    if (vendorUnitTypeNumber) {
                        //System.out.println("vendorUnitTypeNumber : " + new String(ch, start, length));
                        vendorUnitTypeNumber = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setVendorUnitTypeNumber(value);
                        } else {
                            attribute.setVendorUnitTypeNumber(value);
                        }
                    }

                    if (vendorName) {
                        //System.out.println("vendorName : " + new String(ch, start, length));
                        vendorName = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setVendorName(value);
                        } else {
                            attribute.setVendorName(value);
                        }
                    }

                    if (serialNumber) {
                        //System.out.println("serialNumber : " + new String(ch, start, length));
                        serialNumber = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setSerialNumber(value);
                        } else {
                            attribute.setSerialNumber(value);
                        }
                    }

                    if (dateOfManufacture) {
                        //System.out.println("dateOfManufacture : " + new String(ch, start, length));
                        dateOfManufacture = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setDateOfManufacture(value);
                        } else {
                            attribute.setDateOfManufacture(value);
                        }
                    }

                    if (unitPosition) {
                        //System.out.println("unitPosition : " + new String(ch, start, length));
                        unitPosition = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setUnitPosition(value);
                        } else {
                            attribute.setUnitPosition(value);
                        }
                    }

                    if (manufacturerData) {
                        //System.out.println("manufacturerData : " + new String(ch, start, length));
                        manufacturerData = false;
                        if (iu.getAttributes() == null) {
                            AttributesInventory temp = iu.getInternalAttributes();
                            temp.setManufacturerData(value);
                        } else {
                            attribute.setManufacturerData(value);
                        }
                    }


                }
            };

            saxParser.parse("RNC_adjust_28thFeb_HW.xml", handler);

            inventoryUnitList.add(iu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("End");
        print();
    }

    public static void print() {
        System.out.println("Inventory List size " + inventoryUnitList.size());
        for (InventoryUnit iu : inventoryUnitList) {
            System.out.println("Inventory List Id " + iu.getId());
            System.out.println("Inventory List Id " + iu.getInternalAttributes().getInventoryUnitType());
            for (AttributesInventory ai : iu.getAttributes()) {
                if (ai != null) {
                    System.out.println(ai.getInventoryUnitType());
                }
            }
        }
    }
}
