package com.example.glynkassign;

import android.app.Application;

/**
 * Created by chitra on 19/1/18.
 */

public class GlynkAssignApp extends Application {

    private static GlynkAssignApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static GlynkAssignApp getInstance(){
        return mInstance;
    }
}
