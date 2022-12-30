package com.listarticle.article.RestClientConfig.Status;

import org.springframework.http.HttpStatus;

public enum StatusCodeMessage {
    SUCCESS("OK"), CREATED("CREATED"), ACCEPTED("ACCEPTED"), NO_CONTENT("NO_CONTENT"),
    BAD_REQUEST("BAD_REQUEST"), UNAUTHORIZED("UNAUTHORIZED"), FORBIDDEN("FORBIDDEN"), NOT_FOUND("NOT_FOUND"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"), SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE");

    private final String statusCodeMessage;

    StatusCodeMessage(String statusCodeMessage) {
        this.statusCodeMessage = statusCodeMessage;
    }

    public String getStatusCodeMessage() {
        return statusCodeMessage;
    }

}
