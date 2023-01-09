package ru.aberezhnoy.service;

import ru.aberezhnoy.domain.HttpResponse;

public class ResponseSerializer1 {

    public String serializeResponse(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ")
                .append(httpResponse.getHttpResponseCode().getCode())
                .append(" ")
                .append(httpResponse.getHttpResponseCode().getStatus())
                .append("\n");
        httpResponse.getHeaders().forEach((header, value) -> sb
                .append(header)
                .append(": ")
                .append(value)
                .append("\n\n"));
        sb.append(httpResponse.getBody());
        return sb.toString();
    }
}
