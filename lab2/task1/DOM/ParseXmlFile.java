package first_file;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseXmlFile {

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\zveri\\IdeaProjects\\dom\\bouquet.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("flower");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Flower name : "
                            + eElement.getAttribute("name"));
                    System.out.println("Color : "
                            + eElement
                            .getElementsByTagName("color")
                            .item(0)
                            .getTextContent());
                    System.out.println("Feeling : "
                            + eElement
                            .getElementsByTagName("feeling")
                            .item(0)
                            .getTextContent());
                    System.out.println("Origin : "
                            + eElement
                            .getElementsByTagName("origin")
                            .item(0)
                            .getTextContent());
                    System.out.println("Symbol : "
                            + eElement
                            .getElementsByTagName("symbol")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : "
                            + eElement
                            .getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}