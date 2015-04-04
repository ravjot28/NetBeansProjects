
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXMLFile extends DefaultHandler {

       private attribute acct;
       private String temp;
       private ArrayList<attribute> accList = new ArrayList<attribute>();

       /** The main method sets things up for parsing */
       public static void main(String[] args) throws IOException, SAXException,
                     ParserConfigurationException {

              //Create a "parser factory" for creating SAX parsers
              SAXParserFactory spfac = SAXParserFactory.newInstance();

              //Now use the parser factory to create a SAXParser object
              SAXParser sp = spfac.newSAXParser();

              //Create an instance of this class; it defineRs all the handler methods
              ParseXMLFile handler = new ParseXMLFile();
              //Finally, tell the parser to parse the input and notify the handler
              sp.parse("RNC_adjust_28thFeb_HW.xml", handler);
              handler.readList();

       }


       /*
        * When the parser encounters plain text (not XML elements),
        * it calls(this method, which accumulates them in a string buffer
        */
       public void characters(char[] buffer, int start, int length) {
              temp = new String(buffer, start, length);
       }


       /*
        * Every time the parser encounters the beginning of a new element,
        * it calls this method, which resets the string buffer
        */
       public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
              temp = "";
              if (qName.equals("in:InventoryUnit")) {
            	  System.out.println(attributes.getValue("id"));
                     acct = new attribute();
                     acct.setId(attributes.getValue("id"));

              }
       }

       /*
        * When the parser encounters the end of an element, it calls this method
        */
       public void endElement(String uri, String localName, String qName)
                     throws SAXException {

              if (qName.equals("in:InventoryUnit"))
              {
                     // add it to the list
                     accList.add(acct);

              } else if (qName.equals("in:inventoryUnitType")) {
                     acct.setInventoryUnitType(temp);
              } else if (qName.equals("in:vendorUnitFamilyType")) {
                     acct.setVendorUnitFamilyType((temp));
              } else if (qName.equalsIgnoreCase("in:vendorUnitTypeNumber")) {
                     acct.setVendorUnitTypeNumber((temp));
              }else if (qName.equalsIgnoreCase("in:vendorName")) {
                  acct.setVendorName((temp));
              }else if (qName.equalsIgnoreCase("in:serialNumber")) {
                  acct.setSerialNumber((temp));
              }
              else if (qName.equalsIgnoreCase("in:dateOfManufacture")) {
                  acct.setDateOfManufacture((temp));
              }
              else if (qName.equalsIgnoreCase("in:unitPosition")) {
                  acct.setUnitPosition((temp));
              }
              else if (qName.equalsIgnoreCase("in:manufacturerData")) {
                  acct.setManufacturerData((temp));
              }
       }

       private void readList() {
              /*System.out.println("No of different id '" + accList.size()  + "'.");
              Iterator<attribute> it = accList.iterator();
              while (it.hasNext()) {
                     System.out.println(it.next().toString());
              }*/
       }

}

