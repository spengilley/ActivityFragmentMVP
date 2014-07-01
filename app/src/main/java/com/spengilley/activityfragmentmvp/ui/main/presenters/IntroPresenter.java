package com.spengilley.activityfragmentmvp.ui.main.presenters;


import com.spengilley.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.spengilley.activityfragmentmvp.ui.main.views.IntroView;

public interface IntroPresenter extends BaseFragmentPresenter<IntroView> {

    public void getDetails();
}
