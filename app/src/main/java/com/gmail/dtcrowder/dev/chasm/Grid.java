package com.gmail.dtcrowder.dev.chasm;

import android.support.v4.util.ArrayMap;
import android.util.SparseIntArray;

import java.util.ArrayList;

/**
 * Created by David Crowder on 11/13/2016.
 */

public class Grid {

    private static Grid sGrid;
    private Position mTilePosition;
    private ArrayMap<Position, Integer> mTileId;

    public static Grid get(Position pos) {
        if (sGrid == null) {
            sGrid = new Grid(pos);
        }
        return sGrid;
    }

    private Grid(Position pos) {



    }

}
