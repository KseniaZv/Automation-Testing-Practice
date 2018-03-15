package csv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CSVReaderExample {

    static ArrayList<String> CSVRead() {
        String csvFile = "C:\\Users\\zveri\\IdeaProjects\\jsontask2\\set_of_dates.csv";

        CSVReader reader = null;
        ArrayList<String> dateList = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            dateList = new ArrayList<>();
            while ((line = reader.readNext()) != null) {
                dateList.add(line[2]);
                //System.out.println("Dates [date = " + line[2] + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateList;
    }

}