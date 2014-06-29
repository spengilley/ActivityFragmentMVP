package com.spengilley.activityfragmentmvp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                App.class
        },
        library = true
)
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }


    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }
}
