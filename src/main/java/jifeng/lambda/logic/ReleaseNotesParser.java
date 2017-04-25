package jifeng.lambda.logic;

import jifeng.lambda.model.ReleaseNote;
import jifeng.lambda.model.ReleaseNotes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNotesParser {

    public ReleaseNotes parse() throws IOException {
        List<ReleaseNote> releaseNotesList = new ArrayList<>();

        Document doc = Jsoup.connect("https://aws.amazon.com/releasenotes?c=50&p=1&sm=dD").get();
        Element itemsTable = doc.getElementById("itemsTable");
        if(itemsTable!=null){
            Elements items = itemsTable.getElementsByClass("item");
            for(Element item: items){
                Element title = item.getElementsByClass("title").get(0);
                String url = title.getElementsByTag("a").get(0).attr("href");
                String titleText = title.text();

                String desc = item.getElementsByClass("desc").get(0).text();
                String lastMod = item.getElementsByClass("lastMod").get(0).text();
                releaseNotesList.add(new ReleaseNote(titleText, url, desc, lastMod));
            }
        }
        return new ReleaseNotes(releaseNotesList);
    }

    public static void main(String[] args) throws IOException {

    }
}
