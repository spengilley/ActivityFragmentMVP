package com.spengilley.activityfragmentmvp.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.spengilley.activityfragmentmvp.R;
import com.spengilley.activityfragmentmvp.ui.common.BaseActivity;
import com.spengilley.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.views.MainView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView, FragmentCallback {
    @Inject
    MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load IntroFragment
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, IntroFragment.newInstance()).commit();


        // Just for fun, display a delayed toast using presenter
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getImaginaryString();
            }
        }, 2000);


    }


    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    /**
     * FragmentCallback implementation
     */
    @Override
    public void loadDetailFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailsFragment.newInstance()).commit();
    }

    @Override
    public void finishProcess() {
        finish();
    }

    // View method
    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
