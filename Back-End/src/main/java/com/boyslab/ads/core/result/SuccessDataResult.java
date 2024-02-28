package com.boyslab.ads.core.result;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(boolean success) {
        super(success);
    }

    public SuccessDataResult(String message) {
        super(message, true);
    }

    public SuccessDataResult(String message, T data) {
        super(message, true, data);
    }

    public SuccessDataResult( T data) {
        super(true, data);
    }

}
