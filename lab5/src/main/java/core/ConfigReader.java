package core;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigReader {
    private static final Logger log = LogManager.getLogger(ConfigReader.class);
    private String userName;
    private String password;
    private String startURL;
    private String browser;

    public ConfigReader() {
        {
            try {
                File file = new File("Config.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("TestData");
                Node nNode = nList.item(0);
                log.debug("\nCurrent Element : " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    userName = eElement
                            .getElementsByTagName("Username")
                            .item(0)
                            .getTextContent();
                    log.debug("Username : "
                            + userName);

                    password = eElement
                            .getElementsByTagName("Password")
                            .item(0)
                            .getTextContent();
                    log.debug("Password : "
                            + password);

                    startURL = eElement
                            .getElementsByTagName("URL")
                            .item(0)
                            .getTextContent();
                    log.debug("URL : "
                            + startURL);
                    browser = eElement
                            .getElementsByTagName("Browser")
                            .item(0)
                            .getTextContent();
                    log.debug("Browser : "
                            + browser);
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();

            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getStartURL() {
        return startURL;
    }

    public String getBrowser() {
        return browser;
    }
}
