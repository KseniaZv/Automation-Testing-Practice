package second_file;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.*;

public class StaxCreateXML {

    public static void main(String[] args){
        Eurovision winner1 = new Eurovision(2009, "Norway", "Alexander Rybak", "Fairytale", 387, "Moscow");
        Eurovision winner2 = new Eurovision(2010, "Germany", "Lena", "Satellite", 246, "Oslo");
        Eurovision winner3 = new Eurovision(2011, "Azerbaijan", "Ell &amp; Nikki", "Running Scared", 221, "Düsseldorf");
        Eurovision winner4 = new Eurovision(2012, "Sweden", "Loreen", "Euphoria", 372, "Baku");
        Eurovision winner5 = new Eurovision(2013, "Denmark", "Emmelie de Forest", "Only Teardrops", 281, "Malmö");
        Eurovision winner6 = new Eurovision(2014, "Austria", "Conchita Wurst", "Rise Like a Phoenix", 290, "Copenhagen");
        Eurovision winner7 = new Eurovision(2015, "Sweden", "Måns Zelmerlöw", "Heroes", 365, "Vienna");
        Eurovision winner8 = new Eurovision(2016, "Ukraine", "Jamala", "1944", 534, "Stockholm");
        Eurovision winner9 = new Eurovision(2017, "Portugal", "Salvador Sobral", "Amar pelos dois", 758, "Kiev");

        ArrayList<Eurovision> eurovision_list = new ArrayList<Eurovision>();
        eurovision_list.add(winner1);
        eurovision_list.add(winner2);
        eurovision_list.add(winner3);
        eurovision_list.add(winner4);
        eurovision_list.add(winner5);
        eurovision_list.add(winner6);
        eurovision_list.add(winner7);
        eurovision_list.add(winner8);
        eurovision_list.add(winner9);

        stAXToXml(eurovision_list);
    }

    public static void stAXToXml(List<Eurovision> list) {

        try {
            if (null != list && !list.isEmpty()) {
                XMLOutputFactory xof = XMLOutputFactory.newInstance();
                XMLStreamWriter xmlsw = new IndentingXMLStreamWriter(xof.createXMLStreamWriter(new FileWriter("C:\\Users\\zveri\\IdeaProjects\\sax\\eurovision.xml")));

                xmlsw.writeStartDocument("UTF-8", "1.0");
                xmlsw.writeStartElement("eurovision");

                for (Eurovision po : list) {

                    xmlsw.writeStartElement("winner");
                    xmlsw.writeAttribute("year", String.valueOf(po.getYear()));

                    xmlsw.writeStartElement("country");
                    xmlsw.writeCharacters(po.getCountry());
                    xmlsw.writeEndElement();

                    xmlsw.writeStartElement("artist");
                    xmlsw.writeCharacters(po.getArtist());
                    xmlsw.writeEndElement();

                    xmlsw.writeStartElement("song");
                    xmlsw.writeCharacters(po.getSong());
                    xmlsw.writeEndElement();

                    xmlsw.writeStartElement("points");
                    xmlsw.writeCharacters(String.valueOf(po.getPoints()));
                    xmlsw.writeEndElement();

                    xmlsw.writeStartElement("hostcity");
                    xmlsw.writeCharacters(po.getHostcity());
                    xmlsw.writeEndElement();

                    xmlsw.writeEndElement();
                }

                xmlsw.writeEndElement();
                xmlsw.writeEndDocument();
                xmlsw.flush();
                xmlsw.close();
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}