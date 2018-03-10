package task3;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeFromJson  {

        public static void main(String[] args) {
            DeserializeFromJson obj = new DeserializeFromJson();
            obj.run();
        }

        private void run() {
            ObjectMapper mapper = new ObjectMapper();

            try {
                // Convert JSON string from file to Object
                Pizza pizza = mapper.readValue(new File("C:\\Users\\zveri\\IdeaProjects\\jsontask2\\pizza.json"), Pizza.class);

                //Pretty print
                String prettyPizza = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pizza);
                System.out.println(prettyPizza);

            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

