package com.ron.sell.online.controller;

import com.ron.sell.online.domain.RonsResponse;

public class RonsResponseData<T>  extends RonsResponse{
    private T data;

    public RonsResponseData(){
        super();
    }

    public RonsResponseData(T data){
        this.data = data;
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
