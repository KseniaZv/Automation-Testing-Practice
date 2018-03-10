package task3;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SerializeToJson {

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        Pizza pizza = new Pizza();
        pizza.setName("Margarita");
        pizza.setWeight(300);
        pizza.setCooking(new Price(5, "dollar"));
        pizza.setDelivery(new Price(1, "dollar"));

        String[] ingredients = {"tomatoes", "cheese", "basil leaves", "garlic", "baked pizza crust"};
        pizza.setIngredients(ingredients);

        //Convert object to JSON string and save into file directly
        mapper.writeValue(new File("pizza.json"), pizza);

        //Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(pizza);
        System.out.println(jsonInString+"\n");

        //Convert object to JSON string and pretty print
        jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pizza);
        System.out.println(jsonInString);

    }
}