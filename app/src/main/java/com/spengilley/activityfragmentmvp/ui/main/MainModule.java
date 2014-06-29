package com.spengilley.activityfragmentmvp.ui.main;

import com.spengilley.activityfragmentmvp.AppModule;
import com.spengilley.activityfragmentmvp.ui.main.presenters.DetailsPresenter;
import com.spengilley.activityfragmentmvp.ui.main.presenters.DetailsPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.presenters.IntroPresenter;
import com.spengilley.activityfragmentmvp.ui.main.presenters.IntroPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.presenters.MainPresenter;
import com.spengilley.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.views.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        addsTo = AppModule.class,
        injects = {
                MainActivity.class,
                IntroFragment.class,
                DetailsFragment.class
        },
        complete = false,
        library = true
)
public class MainModule {
    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }


    /**
     * Provide MainView
     */
    @Provides
    @Singleton
    public MainView provideMainView() {
        return (MainView) activity;
    }


    /**
     * Provide MainPresenter
     */
    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainView view) {
        return new MainPresenterImpl(view);
    }

    /**
     * Provide IntroPresenter
     */
    @Provides
    @Singleton
    public IntroPresenter provideIntroPresenter() {
        return new IntroPresenterImpl();
    }


    /**
     * Provide DetailsPresenter
     */
    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenterImpl();
    }

}
