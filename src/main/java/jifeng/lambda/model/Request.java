package jifeng.lambda.model;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Jifeng Zhang on 25/04/17.
 */
public class Request {
    private String httpMethod;
    private Map<String, String> headers = Collections.emptyMap();
    private Map<String, String> queryStringParameters = Collections.emptyMap();
    private Map<String, String> pathParameters = Collections.emptyMap();
    private Map<String, String> stageVariables = Collections.emptyMap();

    public Request(String httpMethod, Map<String, String> headers, Map<String, String> queryStringParameters, Map<String, String> pathParameters, Map<String, String> stageVariables) {
        this.httpMethod = httpMethod;
        this.headers = headers;
        this.queryStringParameters = queryStringParameters;
        this.pathParameters = pathParameters;
        this.stageVariables = stageVariables;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, String> getStageVariables() {
        return stageVariables;
    }

    public void setStageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
    }
}
