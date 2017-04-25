package jifeng.lambda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNoteTest {
    @Test
    public void testJson() throws JsonProcessingException {
        ReleaseNote note = new ReleaseNote("Title", "http://","Desc", "2000-01-01");
        System.out.println(note.toJson());
        Assert.assertEquals(note.toJson(), "{\"title\":\"Title\",\"url\":\"http://\",\"desc\":\"Desc\",\"lastMod\":\"2000-01-01\"}");
    }
}
