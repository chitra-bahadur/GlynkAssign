package com.example.glynkassign.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.glynkassign.R;
import com.example.glynkassign.constant.Constants;

import butterknife.BindView;

/**
 * Created by chitra on 19/1/18.
 */

public class ArticleFragment extends BaseFragment{

    @BindView(R.id.screenName)
    TextView screenName;

    private View mView;

    private int screenNumber;

    public static ArticleFragment newInstance(int i){
        ArticleFragment fragment = new ArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.SCREEN_NUMBER, i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null){
            screenNumber = getArguments().getInt(Constants.SCREEN_NUMBER);
        }

        screenName.setText("Screen Name " + screenNumber);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_article, container, false);
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
