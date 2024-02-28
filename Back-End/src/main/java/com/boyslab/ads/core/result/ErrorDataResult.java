package com.boyslab.ads.core.result;

public class ErrorDataResult<T> extends  DataResult<T> {


    public ErrorDataResult() {
        super(false);
    }

    public ErrorDataResult(String message) {
        super(message, false);
    }

    public ErrorDataResult(String message, T data) {
        super(message, false, data);
    }

    public ErrorDataResult( T data) {
        super(false, data);
    }

}
