package com.accountProServer.AccountProServer.adapter;


public interface ResponseModel {
    public void setIsSucceed(boolean isSucceed);


    public void setResponseData(Object responseData);


    public void setErrorCode(String errorCode);


    public void setErrorMessage(String errorMessage);

}
