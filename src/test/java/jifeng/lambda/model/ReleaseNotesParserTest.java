package jifeng.lambda.model;

import jifeng.lambda.logic.ReleaseNotesParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class ReleaseNotesParserTest {
    @Test
    public void testParser() throws IOException {
        ReleaseNotesParser parser = new ReleaseNotesParser();
        ReleaseNotes notes = parser.parse();
        Assert.assertTrue(notes.getReleaseNotes().size() > 1);
        System.out.println(notes.toRss());
    }
}
