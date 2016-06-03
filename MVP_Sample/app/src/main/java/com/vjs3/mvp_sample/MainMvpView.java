package com.vjs3.mvp_sample;

import java.util.List;

/**
 * Created by vjs3 on 31/5/16.
 */

public interface MainMvpView extends MvpView {

    void showToast(Movie movie);

    void setData(List<Movie> list);

}
