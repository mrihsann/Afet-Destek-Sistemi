package com.boyslab.ads.core.result;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(message, false);
    }


}
