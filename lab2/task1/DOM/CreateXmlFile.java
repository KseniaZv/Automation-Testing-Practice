package first_file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CreateXmlFile {

    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement = doc.createElement("bouquet");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getFlower(doc, "Lily", "white", "admiration", "Greece",
                    "innocence", "4$"));

            //append second child
            rootElement.appendChild(getFlower(doc, "Rose", "red", "love", "Rome",
                    "heart", "11$"));

            //append third child
            rootElement.appendChild(getFlower(doc, "Tulip", "yellow", "happiness", "Iran",
                    "beauty", "7$"));

            //append fourth child
            rootElement.appendChild(getFlower(doc, "Chrysanthemum", "pink", "affection", "Japan",
                    "well-being", "5$"));

            //append fifth child
            rootElement.appendChild(getFlower(doc, "Peony", "crimson", "tenderness", "China",
                    "passion", "9$"));

            //append sixth child
            rootElement.appendChild(getFlower(doc, "Iris", "violet", "sincerity", "Greece",
                    "friendship", "11$"));

            //append seventh child
            rootElement.appendChild(getFlower(doc, "Lilac", "purple", "reciprocity", "Balkans",
                    "first love", "8$"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("C:\\Users\\zveri\\IdeaProjects\\dom\\bouquet.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getFlower(Document doc, String name, String color, String feeling, String origin,
                                    String symbol, String price) {
        Element flower = doc.createElement("flower");

        //set name attribute
        flower.setAttribute("name", name);

        //create color element
        flower.appendChild(getFlowerElements(doc, flower, "color", color));

        //create feeling element
        flower.appendChild(getFlowerElements(doc, flower, "feeling", feeling));

        //create origin element
        flower.appendChild(getFlowerElements(doc, flower, "origin", origin));

        //create symbol element
        flower.appendChild(getFlowerElements(doc, flower, "symbol", symbol));

        //create price element
        flower.appendChild(getFlowerElements(doc, flower, "price", price));

        return flower;
    }


    //utility method to create text node
    private static Node getFlowerElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
