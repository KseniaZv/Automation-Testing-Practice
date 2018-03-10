package task3;

import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SerializeToXML {

    private static final String SERIALIZED_FILE_NAME = "pizza.xml";

    public static void main(String[] args) throws IOException {
        Pizza pizza = new Pizza();
        pizza.setName("Capricciosa");
        pizza.setWeight(350);
        pizza.setCooking(new Price(6, "dollar"));
        pizza.setDelivery(new Price(1, "dollar"));

        String[] ingredients2 = {"slices of ham", "artichoke", "basil", "black olives", "tomato sauce", "baked pizza crust"};
        pizza.setIngredients(ingredients2);

        XStream xStream = getXstreamObject();
        String xml = xStream.toXML(pizza);
        System.out.println(xml);

        try {
            FileOutputStream fs = new FileOutputStream(SERIALIZED_FILE_NAME);
            xStream.toXML(pizza, fs);
            System.out.println();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    private static XStream getXstreamObject() {
        XStream xstream = new XStream();
        return xstream;
    }
}