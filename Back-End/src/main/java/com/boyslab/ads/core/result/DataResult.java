package com.boyslab.ads.core.result;

public class DataResult<T> extends  Result {
    private  T data;

    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(String message, boolean success) {
        super(message, success);
    }

    public DataResult(String message, boolean success, T data){
        super(message,success);
        this.data=data;
    }

    public  DataResult(boolean success, T data){
        super(success);
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
