package zvercova;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonCreateFile {

    public static void main(String[] args) {

        //First Stadium
        JSONObject footballDetails = new JSONObject();
        footballDetails.put("name", "Luzhniki Stadium");

        JSONArray teamArray1_1 = new JSONArray();
        teamArray1_1.add("Russia");
        teamArray1_1.add("Germany");
        teamArray1_1.add("Portugal");
        teamArray1_1.add("Denmark");

        footballDetails.put("team1", teamArray1_1);

        JSONArray teamArray1_2 = new JSONArray();
        teamArray1_2.add("Saudi Arabia");
        teamArray1_2.add("Mexico");
        teamArray1_2.add("Morocco");
        teamArray1_2.add("France");

        footballDetails.put("team2", teamArray1_2);

        footballDetails.put("city", "Moscow");
        footballDetails.put("capacity", 81000);

        JSONObject footballObject = new JSONObject();
        footballObject.put("stadium", footballDetails);

        //Second Stadium
        JSONObject footballDetails2 = new JSONObject();
        footballDetails2.put("name", "Otkritie Arena");

        JSONArray teamArray2_1 = new JSONArray();
        teamArray2_1.add("Argentina");
        teamArray2_1.add("Poland");
        teamArray2_1.add("Belgium");
        teamArray2_1.add("Serbia");

        footballDetails2.put("team1", teamArray2_1);

        JSONArray teamArray2_2 = new JSONArray();
        teamArray2_2.add("Iceland");
        teamArray2_2.add("Senegal");
        teamArray2_2.add("Tunisia");
        teamArray2_2.add("Brazil");

        footballDetails2.put("team2", teamArray2_2);

        footballDetails2.put("city", "Moscow");
        footballDetails2.put("capacity", 45360);

        JSONObject footballObject2 = new JSONObject();
        footballObject2.put("stadium", footballDetails2);

        //Third Stadium
        JSONObject footballDetails3 = new JSONObject();
        footballDetails3.put("name", "Kaliningrad Stadium");

        JSONArray teamArray3_1 = new JSONArray();
        teamArray3_1.add("Croatia");
        teamArray3_1.add("Serbia");
        teamArray3_1.add("Spain");
        teamArray3_1.add("England");

        footballDetails3.put("team1", teamArray3_1);

        JSONArray teamArray3_2 = new JSONArray();
        teamArray3_2.add("Nigeria");
        teamArray3_2.add("Switzerland");
        teamArray3_2.add("Morocco");
        teamArray3_2.add("Belgium");

        footballDetails3.put("team2", teamArray3_2);

        footballDetails3.put("city", "Kaliningrad");
        footballDetails3.put("capacity", 35212);

        JSONObject footballObject3 = new JSONObject();
        footballObject3.put("stadium", footballDetails3);

        //Fourth Stadium
        JSONObject footballDetails4 = new JSONObject();
        footballDetails4.put("name", "Kazan Arena");

        JSONArray teamArray4_1 = new JSONArray();
        teamArray4_1.add("South Korea");
        teamArray4_1.add("France");
        teamArray4_1.add("Iran");
        teamArray4_1.add("Poland");

        footballDetails4.put("team1", teamArray4_1);

        JSONArray teamArray4_2 = new JSONArray();
        teamArray4_2.add("Australia");
        teamArray4_2.add("Spain");
        teamArray4_2.add("Colombia");
        teamArray4_2.add("Germany");

        footballDetails4.put("team2", teamArray4_2);

        footballDetails4.put("city", "Kazan");
        footballDetails4.put("capacity", 45379);

        JSONObject footballObject4 = new JSONObject();
        footballObject4.put("stadium", footballDetails4);

        //Fifth Stadium
        JSONObject footballDetails5 = new JSONObject();
        footballDetails5.put("name", "Mordovia Arena");

        JSONArray teamArray5_1 = new JSONArray();
        teamArray5_1.add("Peru");
        teamArray5_1.add("Colombia");
        teamArray5_1.add("Iran");
        teamArray5_1.add("Panama");

        footballDetails5.put("team1", teamArray5_1);

        JSONArray teamArray5_2 = new JSONArray();
        teamArray5_2.add("Denmark");
        teamArray5_2.add("Japan");
        teamArray5_2.add("Portugal");
        teamArray5_2.add("Tunisia");

        footballDetails5.put("team2", teamArray5_2);

        footballDetails5.put("city", "Saransk");
        footballDetails5.put("capacity", 44442);

        JSONObject footballObject5 = new JSONObject();
        footballObject5.put("stadium", footballDetails5);

        //Sixth Stadium
        JSONObject footballDetails6 = new JSONObject();
        footballDetails6.put("name", "Central Stadium");

        JSONArray teamArray6_1 = new JSONArray();
        teamArray6_1.add("Egypt");
        teamArray6_1.add("France");
        teamArray6_1.add("Japan");
        teamArray6_1.add("Mexico");

        footballDetails6.put("team1", teamArray6_1);

        JSONArray teamArray6_2 = new JSONArray();
        teamArray6_2.add("Uruguay");
        teamArray6_2.add("Peru");
        teamArray6_2.add("Senegal");
        teamArray6_2.add("Sweden");

        footballDetails6.put("team2", teamArray6_2);

        footballDetails6.put("city", "Yekaterinburg");
        footballDetails6.put("capacity", 35696);

        JSONObject footballObject6 = new JSONObject();
        footballObject6.put("stadium", footballDetails6);

        //Seventh Stadium
        JSONObject footballDetails7 = new JSONObject();
        footballDetails7.put("name", "Krestovsky Stadium");

        JSONArray teamArray7_1 = new JSONArray();
        teamArray7_1.add("Morocco");
        teamArray7_1.add("Russia");
        teamArray7_1.add("Brazil");
        teamArray7_1.add("Nigeria");

        footballDetails7.put("team1", teamArray7_1);

        JSONArray teamArray7_2 = new JSONArray();
        teamArray7_2.add("Iran");
        teamArray7_2.add("Egypt");
        teamArray7_2.add("Costa Rica");
        teamArray7_2.add("Argentina");

        footballDetails7.put("team2", teamArray7_2);

        footballDetails7.put("city", "Saint Petersburg");
        footballDetails7.put("capacity", 68134);

        JSONObject footballObject7 = new JSONObject();
        footballObject7.put("stadium", footballDetails7);

        //Add stadiums to list
        JSONArray footballList = new JSONArray();
        footballList.add(footballObject);
        footballList.add(footballObject2);
        footballList.add(footballObject3);
        footballList.add(footballObject4);
        footballList.add(footballObject5);
        footballList.add(footballObject6);
        footballList.add(footballObject7);

        //Write JSON file
        try (FileWriter file = new FileWriter("C:\\Users\\zveri\\IdeaProjects\\jsontask2\\worldcup2018.json")) {

            file.write(footballList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}