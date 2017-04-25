package jifeng.lambda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNote {
    String title;
    String url;
    String desc;
    String lastMod;
    static ObjectMapper mapper = new ObjectMapper();

    public ReleaseNote(String title, String url, String desc, String lastMod) {
        this.title = title;
        this.url = url;
        this.desc = desc;
        this.lastMod = lastMod;
    }

    public String toJson() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
