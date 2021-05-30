package com.accountProServer.AccountProServer.adapter;

public  class ResponseModelImp implements ResponseModel {
    // must be public
    public  boolean isSucceed;
    public Object responseData;
    public String errorCode;
    public String errorMessage;

    public void setIsSucceed(boolean isSucceed) {
        this.isSucceed = isSucceed;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}