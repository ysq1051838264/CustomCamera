package com.example.ysq.customcamera;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by hdr on 15/9/6.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {
    Context context;

    public DefaultSubscriber() {
    }

    public DefaultSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {

    }
}
