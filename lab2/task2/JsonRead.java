package zvercova;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonRead {

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:\\Users\\zveri\\IdeaProjects\\jsontask2\\worldcup2018.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray stadiumList = (JSONArray) obj;
            System.out.println(stadiumList);

            //Iterate over stadium array
            stadiumList.forEach( emp -> parseStadiumObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseStadiumObject(JSONObject employee)
    {
        //Get stadium object within list
        JSONObject stadiumObject = (JSONObject) employee.get("stadium");

        //Get stadium name
        String name = (String) stadiumObject.get("name");
        System.out.println(name);

        // loop array
        JSONArray msg1 = (JSONArray) stadiumObject.get("team1");
        Iterator<String> iterator1 = msg1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        JSONArray msg2 = (JSONArray) stadiumObject.get("team2");
        Iterator<String> iterator2 = msg2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        String city = (String) stadiumObject.get("city");
        System.out.println(city);

        long capacity = (Long) stadiumObject.get("capacity");
        System.out.println(capacity);
    }
}