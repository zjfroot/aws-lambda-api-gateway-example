package jifeng.lambda;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import jifeng.lambda.logic.ReleaseNotesParser;
import jifeng.lambda.model.GatewayResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Hello implements RequestStreamHandler {
//    public String myHandler(int myCount, Context context) throws IOException {
//        return "OK";
//    }

    public GatewayResponse myHandler(InputStream input, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);
        ReleaseNotesParser parser = new ReleaseNotesParser();

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/xml");

        return new GatewayResponse(parser.parse().toRss(), headers, 200);
    }

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);
        ReleaseNotesParser parser = new ReleaseNotesParser();

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/xml");
        GatewayResponse response = new GatewayResponse(parser.parse().toRss(), headers, 200);

        output.write(response.toJson().getBytes());
    }
}
