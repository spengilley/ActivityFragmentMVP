package com.spengilley.activityfragmentmvp.ui.main.presenters;


import com.spengilley.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.spengilley.activityfragmentmvp.ui.main.views.DetailsView;

public interface DetailsPresenter extends BaseFragmentPresenter<DetailsView> {

    public void getDetails();
    public void doStuffThenFinish();

}
