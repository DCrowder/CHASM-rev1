package com.gmail.dtcrowder.dev.chasm;

import android.content.Context;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Crowder on 10/30/2016.
 */

public class CurrentLevelBuilder implements LevelBuilder {

    private static final String TAG = "Builder";

    private Context mContext;
    private GridLayout mGrid;
    private ArrayList<ImageView> tiles;
    private final int GRID_SIZE;       // Currently unchanging.  Change to gridlayout's current value later.

    public CurrentLevelBuilder(Context context) {
        Log.d(TAG, "Builder constructor called");
        mContext = context;
        tiles = new ArrayList<>();                 // Create a new ArrayList of tiles for the builder
        GRID_SIZE = 81;
    }


    @Override
    public ArrayList<ImageView> buildGrid() {

        float density = mContext.getResources().getDisplayMetrics().density;
        int dpTile = 40;
        int pxTile = dpTile * (int) density;

        ImageView tile;       // For every space on the GridLayout, create an ImageView

        Log.d(TAG, "Before tile constructor");
        tile = new ImageView(mContext);

        Log.d(TAG, "After tile constructor");

        tile.setImageResource(R.drawable.tile);         // Set the ImageView to the basic tile

        for (int i = 0; i < GRID_SIZE; i++) {
            tiles.add(tile);                                // Add the basic ImageView tile to the ArrayList tiles
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
