package com.example.glynkassign.util;

import android.content.Context;
import android.graphics.Typeface;

import com.example.glynkassign.GlynkAssignApp;

/**
 * Created by chitra on 19/1/18.
 */

public class Fonts {

    /** Bentonsans Medium**/
    public static Typeface getBentonsans_medium() {
        return Typeface.createFromAsset(GlynkAssignApp.getInstance().getAssets(),
                "fonts/BENTONSANS-MEDIUM.OTF");
    }
}
