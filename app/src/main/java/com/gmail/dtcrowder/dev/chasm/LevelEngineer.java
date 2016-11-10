package com.gmail.dtcrowder.dev.chasm;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by David Crowder on 10/30/2016.
 */

public class LevelEngineer {

    private CurrentLevelBuilder mBuilder;
    private SparseIntArray mGrid;
    private SparseIntArray mHeroes;
    private SparseIntArray mEnemies;
    private Context mContext;
    public static final String TAG = "Engineer";

    public LevelEngineer(Context context) {
        Log.d(TAG, "LevelEngineer constructor called");
        mContext = context;
        mBuilder = new CurrentLevelBuilder(mContext);
    }

    public SparseIntArray getGrid() {
        return mGrid;
    }

    public void orderGrid() {
        Log.d(TAG, "setGrid() called");
        mGrid = mBuilder.buildGrid();


    }


    /**
     * Created by David Crowder on 10/30/2016.
     */

    private static class CurrentLevelBuilder implements LevelBuilder {

        private static final String TAG = "Builder";

        private Context mContext;
        private GridLayout mGrid;
        private SparseIntArray tiles;
        private final int GRID_SIZE;       // Currently unchanging.  Change to gridlayout's current value later.

        public CurrentLevelBuilder(Context context) {
            Log.d(TAG, "Builder constructor called");
            mContext = context;
            tiles = new SparseIntArray();                 // Create a new ArrayList of tiles for the builder
            GRID_SIZE = 81;
        }


        @Override
        public SparseIntArray buildGrid() {

            float density = mContext.getResources().getDisplayMetrics().density;
            int dpTile = 40;
            int pxTile = dpTile * (int) density;

            int tile;       // For every space on the GridLayout, create an ImageView

            for (int i = 0; i < GRID_SIZE; i++) {       // i is the model id
                int j =R.drawable.tile;      // j is the view value
                if (i%5 == 0) {
                    j = R.drawable.tile2;
                }
                else if (i%7 == 0) {
                    j = R.drawable.tile3;
                }
                tiles.append(i, j);                                // Adds a random tile to the sparsearray
                Log.d(TAG, "Inside buildGrid()");
            }

            return tiles;

        }

        @Override
        public void buildHeroes() {
            // To-do
        }

        @Override
        public void buildEnemies() {
            // To-do
        }
    }
}
