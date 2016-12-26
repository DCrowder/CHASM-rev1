package com.gmail.dtcrowder.dev.chasm;


import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by David Crowder on 10/30/2016.
 */

public class LevelEngineer {

    private CurrentLevelBuilder mBuilder;
    private ArrayMap<Position, Integer> mGrid;
    private ArrayMap mHeroes;
    private ArrayMap mEnemies;


    public static final String TAG = "Engineer";

    public LevelEngineer(Level level, Hero hero) {
        Log.d(TAG, "LevelEngineer constructor called");

        mBuilder = new CurrentLevelBuilder(hero);
    }

    public ArrayMap<Position, Integer> getGrid() {
        return mGrid;
    }

    public void orderGrid() {
        Log.d(TAG, "orderGrid() called");
        mGrid = new ArrayMap<>();
        mGrid = mBuilder.buildGrid();
    }


    /**
     * Created by David Crowder on 10/30/2016.
     */

    private static class CurrentLevelBuilder implements LevelBuilder {

        private static final String TAG = "Builder";

        private Hero mHero;

        private ArrayMap<Position, Integer> tiles;
        private final int LENGTH;       // Currently unchanging.
        private final int WIDTH;       // Currently unchanging.
        private final int HEIGHT;       // Currently unchanging.
        private final int GRID_SIZE;       // Currently unchanging.

        CurrentLevelBuilder(Hero hero) {
            Log.d(TAG, "Builder constructor called");
            mHero = hero;
            tiles = new ArrayMap<>();                 // Create a new ArrayMap of tiles for the builder
            LENGTH = 200;
            WIDTH = 200;
            HEIGHT = 1;
            GRID_SIZE = LENGTH * WIDTH * HEIGHT;
        }


        @Override
        public ArrayMap<Position, Integer> buildGrid() {

            Log.d(TAG, "Inside buildGrid()");

            for (int l = 0; l < LENGTH; l++) {
                for (int w = 0; w < WIDTH; w++) {

                    Position pos = new Position(w, l, 0);
                    Integer tile = R.drawable.tile;


                    if (w*l % 5 == 0) {
                        tile = R.drawable.tile2;
                    } else if (w*l % 7 == 0) {
                        tile = R.drawable.tile3;
                    }


                    tiles.put(pos, tile);

                    if (w == 50 && l == 50) {
                        mHero.setCurrentPosition(pos);
                    }
                }
            }

            return tiles;

        }

        @Override
        public ArrayMap<Position, Hero[]> buildHeroes() {
            ArrayMap mHeroes;

            mHeroes = new ArrayMap();
            return mHeroes;
        }

        @Override
        public ArrayMap<Position, Enemy> buildEnemies() {
            ArrayMap mEnemies;

            mEnemies = new ArrayMap();
            return mEnemies;
        }
    }
}
