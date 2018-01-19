package com.example.glynkassign.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.glynkassign.R;
import com.example.glynkassign.constant.Constants;
import com.example.glynkassign.util.Fonts;
import com.example.glynkassign.util.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by chitra on 19/1/18.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    private View mView;
    private TabsAdapter mAdapter;

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //adding tabs to the view pager
        setTabs();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setTabs(){
        String tabTitles[] = Constants.tabTitles;
        List<Fragment> fragmentList = new ArrayList<>();
        for(int i = 0; i < tabTitles.length; i++){
            fragmentList.add(ArticleFragment.newInstance((i+1)));

        }

        //setting animation for view pager
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mAdapter = new TabsAdapter(getChildFragmentManager(), fragmentList, tabTitles);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        changeTabsFont();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAdapter.notifyDataSetChanged();
    }

    //change tabs font
    public void changeTabsFont(){
        ViewGroup vg = (ViewGroup) mTabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for(int i = 0; i < tabsCount; i++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(i);
            int tabChildCount = vgTab.getChildCount();
            for(int j = 0; j < tabChildCount; j++){
                View tabView = vgTab.getChildAt(j);
                if(tabView instanceof TextView){
                    ((TextView) tabView).setTypeface(Fonts.getBentonsans_medium());
                }
            }
        }

    }
}
