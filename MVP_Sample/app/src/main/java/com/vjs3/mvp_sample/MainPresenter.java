package com.vjs3.mvp_sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vjs3 on 31/5/16.
 */

public class MainPresenter extends BasePresenter<MainMvpView> {
    private ItemInteractor findItemsInteractor;

    public MainPresenter(){
        findItemsInteractor = new ItemInteractor();
        findItemsInteractor.prepareMovieData();
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
        findItemsInteractor.getMovieData();
        mvpView.setData(findItemsInteractor.getMovieData());
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void clickOperation(List<Movie> movieList, int position) {

        Movie movie = movieList.get(position);
        getMvpView().showToast(movie);
    }



}
