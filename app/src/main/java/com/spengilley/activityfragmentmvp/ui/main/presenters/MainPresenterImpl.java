package com.spengilley.activityfragmentmvp.ui.main.presenters;


import com.spengilley.activityfragmentmvp.ui.main.views.MainView;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;

    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }


    @Override
    public void getImaginaryString() {
        // Could connect to our models to get stuff here
        String message = "Hello world, from Presenter";
        view.showToast(message);
    }
}
