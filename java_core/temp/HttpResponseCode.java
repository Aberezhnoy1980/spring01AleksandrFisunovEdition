package ru.aberezhnoy.domain;

public enum HttpResponseCode {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");

    final int code;

    final String status;

    HttpResponseCode(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
