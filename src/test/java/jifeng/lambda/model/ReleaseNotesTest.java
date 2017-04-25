package jifeng.lambda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNotesTest {
    static ReleaseNotes releaseNotes;
    @BeforeClass
    public static void init(){
        List<ReleaseNote> releaseNotesList = new ArrayList<>();
        releaseNotesList.add(new ReleaseNote("Title1", "http://","Desc1", "2010-01-01"));
        releaseNotesList.add(new ReleaseNote("Title2", "http://","Desc2", "2010-01-01"));
        releaseNotes = new ReleaseNotes(releaseNotesList);
    }

    @Test
    public void testJson() throws JsonProcessingException {
        System.out.println(releaseNotes.toJson());
        Assert.assertEquals(releaseNotes.toJson(), "{\"releaseNotes\":[{\"title\":\"Title1\",\"url\":\"http://\",\"desc\":\"Desc1\",\"lastMod\":\"2010-01-01\"},{\"title\":\"Title2\",\"url\":\"http://\",\"desc\":\"Desc2\",\"lastMod\":\"2010-01-01\"}]}");
    }

    @Test
    public void testRss() {
        String correctResult = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<rss version=\"2.0\">\n" +
                "\n" +
                "<channel>\n" +
                "  <title>AWS Release Notes</title>\n" +
                "  <link>https://api.gateway.url/rss.xml</link>\n" +
                "  <description>AWS Release Notes RSS</description>\n" +
                "  <item>\n" +
                "    <title>Title1</title>\n" +
                "    <link>http://</link>\n" +
                "    <description>Desc1</description>\n" +
                "    <pubDate>2010-01-01</pubDate>\n" +
                "  </item>\n" +
                "  <item>\n" +
                "    <title>Title2</title>\n" +
                "    <link>http://</link>\n" +
                "    <description>Desc2</description>\n" +
                "    <pubDate>2010-01-01</pubDate>\n" +
                "  </item>\n" +
                "</channel>\n" +
                "\n" +
                "</rss>\n";
        System.out.println(releaseNotes.toRss());
        Assert.assertEquals(releaseNotes.toRss(), correctResult);
    }
}
