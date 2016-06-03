package com.vjs3.mvp_sample;

/**
 * Created by vjs3 on 31/5/16.
 */

public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);

    void detachView();
}