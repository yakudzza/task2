package com.example.task2.model;

import java.util.Map;

public class HttpLog {
    private String method;
    private String uriEndpoint;
    private int status;
    private Map<String, String> requestHeaders;
    private Map<String, String> responseHeaders;
    private long executionTime;

    public HttpLog(String method, String uriEndpoint, int status, Map<String, String> requestHeaders, Map<String, String> responseHeaders, long executionTime) {
        this.method = method;
        this.uriEndpoint = uriEndpoint;
        this.status = status;
        this.requestHeaders = requestHeaders;
        this.responseHeaders = responseHeaders;
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "\n=========================================\n" +
                "Тип запроса: " + method + "\n" +
                "URI эндпоинта: " + uriEndpoint + "\n" +
                "Статус: " + status + "\n" +
                "Заголовки запроса: " + requestHeaders + "\n" +
                "Заголовки ответа: " + responseHeaders + "\n" +
                "Время выполнения запроса: " + executionTime + " мс" + "\n" +
                "=========================================";
    }
}
