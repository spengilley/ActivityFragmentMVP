package com.spengilley.activityfragmentmvp.ui.main;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.spengilley.activityfragmentmvp.R;
import com.spengilley.activityfragmentmvp.ui.common.BaseFragment;
import com.spengilley.activityfragmentmvp.ui.main.presenters.IntroPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.views.IntroView;

import javax.inject.Inject;

public class IntroFragment extends BaseFragment implements IntroView {
    @Inject
    IntroPresenterImpl presenter;
    private FragmentCallback callback;
    private View view;
    private Button loadDetails;

    public static IntroFragment newInstance() {
        return new IntroFragment();
    }

    public IntroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_intro, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize button with listener
        loadDetails = (Button) view.findViewById(R.id.load_details);
        loadDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDetails();
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Bit naughty but we know it will work!
        callback = (FragmentCallback) activity;
    }

    /**
     * View implementation
     */
    @Override
    public void loadDetailsFragment() {
        // Ask callback to load details fragment
        callback.loadDetailFragment();
    }
}
