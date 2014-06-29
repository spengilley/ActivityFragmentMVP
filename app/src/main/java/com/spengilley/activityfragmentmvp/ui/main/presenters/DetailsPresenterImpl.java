package com.spengilley.activityfragmentmvp.ui.main.presenters;


import com.spengilley.activityfragmentmvp.ui.main.views.DetailsView;

import javax.inject.Inject;

public class DetailsPresenterImpl implements DetailsPresenter {
    private DetailsView view;


    @Inject
    public DetailsPresenterImpl() {
    }

    @Override
    public void getDetails() {
        String details = "Details from some database or something";
        view.showDetails(details);
    }

    @Override
    public void doStuffThenFinish() {
        view.finish();
    }

    @Override
    public void init(DetailsView view) {
        this.view=view;
    }
}
