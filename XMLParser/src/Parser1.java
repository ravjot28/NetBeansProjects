/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Parser1 {

    static List list2 = null;

    public static void main(String[] args) throws JDOMException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("RNC_adjust_28thFeb_HW.xml");
        System.out.println(xmlFile);
        abc n1 = null;
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            System.out.println(rootNode);

            System.out.println("####");
            System.out.println(rootNode.getValue());
            System.out.println("$$$$");

            /*List list = rootNode.getChildren("fileHeader");
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                Element abc = (Element) list.get(i);
                n1 = new abc();
                n1.setId("id");
                System.out.println(n1);
            }*/
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
