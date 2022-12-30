package com.listarticle.article.RestClientConfig.Status;

import org.springframework.http.HttpStatus;

public enum StatusCodes {
    SUCCESS(HttpStatus.OK), CREATED(HttpStatus.CREATED), ACCEPTED(HttpStatus.ACCEPTED), NO_CONTENT(HttpStatus.NO_CONTENT),
    BAD_REQUEST(HttpStatus.BAD_REQUEST), UNAUTHORIZED(HttpStatus.UNAUTHORIZED), FORBIDDEN(HttpStatus.FORBIDDEN), NOT_FOUND(HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR), SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE);

    private final HttpStatus status;

    StatusCodes(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return status.value();
    }
}
