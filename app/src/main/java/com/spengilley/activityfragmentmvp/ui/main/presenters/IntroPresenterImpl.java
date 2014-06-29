package com.spengilley.activityfragmentmvp.ui.main.presenters;


import com.spengilley.activityfragmentmvp.ui.main.views.IntroView;

import javax.inject.Inject;

public class IntroPresenterImpl implements IntroPresenter {
    private IntroView view;

    @Inject
    public IntroPresenterImpl() {

    }

    public void init(IntroView view) {
        this.view = view;
    }


    @Override
    public void getDetails() {
        // Do stuff to get details
        // then report back to view
        view.loadDetailsFragment();
    }
}
