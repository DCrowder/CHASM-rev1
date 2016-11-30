package com.gmail.dtcrowder.dev.chasm;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.text.Layout;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by David Crowder on 10/28/2016.
 */
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameFragment extends Fragment {

    private Hero mMainHero;
    private LevelEngineer mEngineer;
    private ArrayMap<Position, Integer> mGrid;
    private GridLayout mGridLayout;
    private Integer mCurrentTile;
    private Level mCurrentLevel;
    private int mIndex = 0;

    public final String TAG = "Grid";
    //private ImageView mTile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Load initial level view
        mMainHero = new Hero(UUID.randomUUID());
        mCurrentLevel = new Level(mIndex);

        View v = inflater.inflate(R.layout.fragment_game, container, false);
        mEngineer = new LevelEngineer(mCurrentLevel, mMainHero);
        mEngineer.orderGrid();
        //mEngineer.orderHeroes();
        //mEngineer.orderEnemies();
        mGrid = mEngineer.getGrid();
        GridLayout mGridLayout = (GridLayout) v.findViewById(R.id.LevelGrid);
        Position pos = mMainHero.getCurrentPosition();
        pos.setX(pos.getX()-4);
        pos.setY(pos.getY()-4);
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                // TODO: 11/27/2016 mGrid.get(pos) is only returning tile3
                ImageView mTile = (ImageView) inflater.inflate(R.layout.tile, container, false);
                Log.d(TAG, "Current tile: " + mGrid.get(pos));
                mCurrentTile = mGrid.get(pos);

                mTile.setImageResource(mCurrentTile);
                mGridLayout.addView(mTile);
                Log.d(TAG, "Before X+ " + pos.toString());
                pos.setX(pos.getX()+1);
                Log.d(TAG, "After X+ " + pos.toString());

            }
            pos.setY(pos.getY()+1);
            pos.setX(pos.getX()-9);
        }

        return v;
    }

}
