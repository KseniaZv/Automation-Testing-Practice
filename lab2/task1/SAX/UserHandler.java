package second_file;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

    boolean bCountry = false;
    boolean bArtist = false;
    boolean bSong = false;
    boolean bPoint = false;
    boolean bHostcity = false;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("winner")) {
            String year = attributes.getValue("year");
            System.out.println("Year : " + year);
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        } else if (qName.equalsIgnoreCase("artist")) {
            bArtist = true;
        } else if (qName.equalsIgnoreCase("song")) {
            bSong = true;
        } else if (qName.equalsIgnoreCase("point")) {
            bPoint = true;
        } else if (qName.equalsIgnoreCase("hostcity")) {
            bHostcity = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("flower")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bCountry) {
            System.out.println("Country: " + new String(ch, start, length));
            bCountry = false;
        } else if (bArtist) {
            System.out.println("Artist: " + new String(ch, start, length));
            bArtist = false;
        } else if (bSong) {
            System.out.println("Song: " + new String(ch, start, length));
            bSong = false;
        } else if (bPoint) {
            System.out.println("Points: " + new String(ch, start, length));
            bPoint = false;
        } else if (bHostcity) {
            System.out.println("Host city: " + new String(ch, start, length));
            bHostcity = false;
        }
    }
}