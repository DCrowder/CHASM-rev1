package com.gmail.dtcrowder.dev.chasm;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by David Crowder on 10/28/2016.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {

    private LevelEngineer mEngineer;
    private ArrayList mGrid;
    private GridLayout mGridLayout;

    public final String TAG = "Grid";
    //private ImageView mTile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_game, container, false);
        mEngineer = new LevelEngineer(getContext());
        mEngineer.setGrid();
        mGrid = mEngineer.getGrid();
        GridLayout mGridLayout = (GridLayout) v.findViewById(R.id.LevelGrid);

/** TODO: 10/31/2016 Encapsulate Grid build in LevelBuilder
 *  It's important that the fragment knows nothing about how a level is built.
 *  This allows for the builder to be used in any class.
 */

        for (int i = 0; i < 81; i++) {
            View mTile = inflater.inflate(R.layout.tile, null);
            mGridLayout.addView(mTile);
        }

        return v;
    }

}