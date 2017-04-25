package jifeng.lambda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class GatewayResponse {
    private final String body;
    private final Map<String, String> headers;
    private final int statusCode;

    static ObjectMapper mapper = new ObjectMapper();

    public GatewayResponse(String body, Map<String, String> headers, int statusCode) {
        this.body = body;
        this.headers = headers;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String toJson() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }
}
