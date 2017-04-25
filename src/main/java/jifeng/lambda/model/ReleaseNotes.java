package jifeng.lambda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNotes {
    List<ReleaseNote> releaseNotes;
    static ObjectMapper mapper = new ObjectMapper();


    public ReleaseNotes(List<ReleaseNote> releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public List<ReleaseNote> getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(List<ReleaseNote> releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public String toJson() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }

    public String toRss(){
        String xmlHeader =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<rss version=\"2.0\">\n" +
                "\n" +
                "<channel>\n" +
                "  <title>AWS Release Notes</title>\n" +
                "  <link>https://api.gateway.url/rss.xml</link>\n" +
                "  <description>AWS Release Notes RSS</description>\n";
        String xmlFooter =
                "</channel>\n" +
                "\n" +
                "</rss>\n";
        String itemTemplate =
                "  <item>\n" +
                "    <title>${TITLE}</title>\n" +
                "    <link>${LINK}</link>\n" +
                "    <description>${DESC}</description>\n" +
                "    <pubDate>${PUBDATE}</pubDate>\n" +
                "  </item>\n";

        StringBuilder sb = new StringBuilder();
        sb.append(xmlHeader);

        for(ReleaseNote note: releaseNotes){
            sb.append(itemTemplate
                    .replace("${TITLE}", note.getTitle())
                    .replace("${LINK}", note.getUrl())
                    .replace("${PUBDATE}", note.getLastMod().replace("Last Modified: ",""))
                    .replace("${DESC}", note.getDesc()));
        }
        sb.append(xmlFooter);

        return sb.toString();

    }

}
