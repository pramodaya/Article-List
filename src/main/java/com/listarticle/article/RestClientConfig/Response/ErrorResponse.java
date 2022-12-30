package com.listarticle.article.RestClientConfig.Response;

import com.listarticle.article.RestClientConfig.Status.StatusCodes;

public class ErrorResponse implements Response{

    private StatusCodes statusCode;
    private String message;

    public ErrorResponse(StatusCodes statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    @Override
    public StatusCodes getStatusCode() {return this.statusCode; }

    @Override
    public void setStatusCode(StatusCodes statusCode) { this.statusCode = statusCode;}

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
