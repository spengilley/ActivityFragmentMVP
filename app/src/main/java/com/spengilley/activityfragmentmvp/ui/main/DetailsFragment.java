package com.spengilley.activityfragmentmvp.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.spengilley.activityfragmentmvp.R;
import com.spengilley.activityfragmentmvp.ui.common.BaseFragment;
import com.spengilley.activityfragmentmvp.ui.main.presenters.DetailsPresenterImpl;
import com.spengilley.activityfragmentmvp.ui.main.views.DetailsView;

import javax.inject.Inject;


public class DetailsFragment extends BaseFragment implements DetailsView {
    @Inject
    DetailsPresenterImpl presenter;
    private FragmentCallback callback;
    private View view;
    private Button getDetails, finishThis;
    private TextView detailsText;


    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();

        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailsText = (TextView) view.findViewById(R.id.details);

        getDetails = (Button) view.findViewById(R.id.get_details);
        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDetails();
            }
        });

        finishThis = (Button) view.findViewById(R.id.finish);
        finishThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doStuffThenFinish();
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (FragmentCallback) activity;
    }


    /**
     * View implementation
     */
    @Override
    public void finish() {
        callback.finishProcess();
    }

    @Override
    public void showDetails(String details) {
        detailsText.setText(details);
    }
}
