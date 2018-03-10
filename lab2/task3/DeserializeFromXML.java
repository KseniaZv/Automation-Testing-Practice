package task3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class DeserializeFromXML {

    private static final String SERIALIZED_FILE_NAME = "pizza.xml";

    public static void main(String[] args) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        Pizza pizza = new Pizza();

        try {
            FileInputStream fs = new FileInputStream(SERIALIZED_FILE_NAME);
            xStream.fromXML(fs, pizza);
            System.out.println(pizza.toString());

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}