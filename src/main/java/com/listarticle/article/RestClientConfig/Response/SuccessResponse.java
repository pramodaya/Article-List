package com.listarticle.article.RestClientConfig.Response;

import com.listarticle.article.RestClientConfig.Status.StatusCodes;

public class SuccessResponse<Data> implements Response{

    /**
     * Any type data object
     */
    private Data data;
    private StatusCodes statusCode;
    private String message;

    public SuccessResponse(Data data, StatusCodes statusCode, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public StatusCodes getStatusCode() {
        return statusCode;
    }
    @Override
    public void setStatusCode(StatusCodes statusCode) {
        this.statusCode = statusCode;
    }
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
