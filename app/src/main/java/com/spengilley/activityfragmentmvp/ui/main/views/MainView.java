package com.spengilley.activityfragmentmvp.ui.main.views;


public interface MainView {

    // Fairly un necessary interface but if we wanted our
    // MainActivity to actually do anything we would use this view in combination
    // with a presenter

    public void showToast(String message);
}
