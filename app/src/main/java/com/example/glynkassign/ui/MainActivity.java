package com.example.glynkassign.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.glynkassign.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(HomeFragment.newInstance(), "HomeFragment");
    }

    private void setFragment(Fragment fragment, String fragmentTag){
        FragmentManager mManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mManager.beginTransaction();
        //mTransaction.add(fragment, fragmentTag);
        mTransaction.replace(R.id.content_frame, fragment, fragmentTag);
        mTransaction.addToBackStack(fragmentTag);
        mTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
