package first_file;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class QueryXmlFile {

    public static void main(String argv[]) {

        try {
            File inputFile = new File("C:\\Users\\zveri\\IdeaProjects\\dom\\bouquet.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("flower");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :");
                System.out.print(nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("name : ");
                    System.out.println(eElement.getAttribute("name"));
                    NodeList flowerColorList = eElement.getElementsByTagName("color");
                    NodeList flowerSymbolList = eElement.getElementsByTagName("symbol");

                    for (int count = 0; count < flowerColorList.getLength(); count++) {
                        Node node = flowerColorList.item(count);

                        if (node.getNodeType() == node.ELEMENT_NODE) {
                            Element flower = (Element) node;
                            System.out.print("Color : ");
                            System.out.println(flower.getTextContent());
                        }
                    }

                    for (int count = 0; count < flowerSymbolList.getLength(); count++) {
                        Node node = flowerSymbolList.item(count);

                        if (node.getNodeType() == node.ELEMENT_NODE) {
                            Element flower = (Element) node;
                            System.out.print("Symbol : ");
                            System.out.println(flower.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}