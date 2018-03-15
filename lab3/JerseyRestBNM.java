package csv;

import java.util.ArrayList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thoughtworks.xstream.XStream;

import static csv.CSVReaderExample.CSVRead;

class JerseyRestBNM {

    static ArrayList<ArrayList<Valute>> BNM() {

        ArrayList<String> dateList = CSVRead();

        ArrayList<ArrayList<Valute>> valuteListOuter = new ArrayList<ArrayList<Valute>> ();

        try {
            for (String date : dateList) {
                Client client = Client.create();

                WebResource webResource = client.resource("https://bnm.md/en/official_exchange_rates?get_xml=1&date=" + date);

                ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                }

                String output = response.getEntity(String.class);

                XStream xstream = new XStream();
                xstream.processAnnotations(Valute.class);
                xstream.processAnnotations(ValCurs.class);

                ArrayList<Valute> valuteListInner = new ArrayList<Valute>();
                ValCurs valCurs = (ValCurs) xstream.fromXML(output);

                valuteListInner.addAll(valCurs.getCur());
                valuteListOuter.add(valuteListInner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valuteListOuter;
    }
}