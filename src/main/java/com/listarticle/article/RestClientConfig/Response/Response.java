package com.listarticle.article.RestClientConfig.Response;

import com.listarticle.article.RestClientConfig.Status.StatusCodes;

public interface Response {
    public StatusCodes getStatusCode();
    public void setStatusCode(StatusCodes statusCode);
    public String getMessage();
    public void setMessage(String message);
}
