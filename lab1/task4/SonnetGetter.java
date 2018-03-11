package task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SonnetGetter {
    List<Sonnet> sonnetList = new ArrayList<>();
    File input;

    SonnetGetter() {
    }

    public Sonnet getRandomSonnet() {
        input = new File("C:\\Users\\zveri\\IdeaProjects\\task4\\src\\task4\\sonnets.htm");
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            for (Element element : doc.select("ul")) // Select all the ul tags
            {
                TextNode next = (TextNode) element.nextSibling(); // Get the next node of each ul as a TextNode
                sonnetList.add(new Sonnet("", next.text()));
            }
            int i = 0;
            for (Element element :
                    doc.getElementsByTag("h2")) {
                sonnetList.get(i).setSonnetName(element.text());
                i++;
            }
            sonnetList.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sonnetList.get((int) (Math.random() * sonnetList.size()));
    }
}
