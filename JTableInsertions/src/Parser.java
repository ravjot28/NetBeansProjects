
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

public class Parser {

    static List list2 = null;
    static List list3 = null;
    static List list4 = null;
    static List list5 = null;

    public static void main(String[] args) {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("KBEMSS1_hw_sw_adjust.xml");
        Node n1 = null;
        Equipment e1 = null;
        Cabinet e2 = null;
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("Node");
            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);
                n1 = new Node();
                n1.setAdjustDate(node.getAttributeValue("AdjustDate"));
                n1.setName(node.getAttributeValue("Name"));
                n1.setType(node.getAttributeValue("Type"));

                List list1 = node.getChildren("Equipment");
                n1.setEquip(new ArrayList<Equipment>());
                for (int i1 = 0; i1 < list1.size(); i1++) {
                    Element node1 = (Element) list1.get(i1);
                    e1 = new Equipment();
                    e1.setBuildingPractice(node1.getAttributeValue("BuildingPractice"));

                    list2 = node1.getChildren("Cabinet");
                    e1.setCabinet(new ArrayList<Cabinet>());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        Element node2 = (Element) list2.get(i2);
                        e2 = new Cabinet();

                        e2.setPosition(node2.getAttributeValue("Position"));
                        e2.setSubracks(new ArrayList<Subrack>());
                        list3 = node2.getChildren("Subrack");
                        for (int i3 = 0; i3 < list3.size(); i3++) {
                            Element node3 = (Element) list3.get(i3);
                            Subrack e3 = new Subrack();

                            e3.setName(node3.getAttributeValue("Name"));
                            e3.setPosition(node3.getAttributeValue("Position"));
                            e3.setType(node3.getAttributeValue("Type"));
                            e2.getSubracks().add(e3);

                            list4 = node3.getChildren("Board");
                            e3.setBoards(new ArrayList<Board>());
                            for (int i4 = 0; i4 < list4.size(); i4++) {

                                Element node4 = (Element) list4.get(i4);
                                Board e4 = new Board();
                                e4.setName(node4.getAttributeValue("Name"));
                                e4.setSlotPosition(node4.getAttributeValue(" Slot Position"));
                                e4.setType(node4.getAttributeValue("Type"));
                                e3.getBoards().add(e4);

                                //Product

                                list5 = node4.getChildren("ProductData");
                                e4.setProduct(new ArrayList<ProductData>());

                                for (int i5 = 0; i5 < list5.size(); i5++) {
                                    Element node5 = (Element) list5.get(i5);
                                    ProductData e5 = new ProductData();
                                    e5.setFirstOperationDate(node5.getAttributeValue("FirstOperationDate"));
                                    e4.getProduct().add(e5);
                                }
                            }
                        }
                        e1.getCabinet().add(e2);
                    }
                }

                n1.getEquip().add(e1);
            }
            String cabinetInfo[][] = new String[e1.getCabinet().size()][2];
            int i = 0;
            for (Cabinet c : e1.getCabinet()) {
                int size = 0;
                List<Subrack> subRacks = c.getSubracks();
                for (Subrack sr : subRacks) {
                    List<Board> boards = sr.getBoards();
                    for (Board b : boards) {
                        List<ProductData> productData = b.getProduct();
                        size += productData.size();
                    }
                }
               
                cabinetInfo[i][0] = c.getPosition();
                cabinetInfo[i][1] = "" + size;
                i++;
                //cabinet.getSubracks();
            }

            MultiSpanCellTableMain frame = new MultiSpanCellTableMain(cabinetInfo);

            frame.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }
}
