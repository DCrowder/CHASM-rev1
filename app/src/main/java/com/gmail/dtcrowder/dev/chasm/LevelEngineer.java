package com.gmail.dtcrowder.dev.chasm;

import android.content.Context;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Crowder on 10/30/2016.
 */

public class LevelEngineer {

    private CurrentLevelBuilder mBuilder;
    private ArrayList<ImageView> mGrid;
    private Context mContext;
    public static final String TAG = "Engineer";

    public LevelEngineer(Context context) {
        Log.d(TAG, "LevelEngineer constructor called");
        mContext = context;
        mBuilder = new CurrentLevelBuilder(mContext);
    }

    public ArrayList getGrid() {
        return mGrid;
    }

    public void setGrid() {
        Log.d(TAG, "setGrid() called");
        mGrid = mBuilder.buildGrid();

    }



}
