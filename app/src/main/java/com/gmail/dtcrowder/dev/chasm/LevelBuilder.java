package com.gmail.dtcrowder.dev.chasm;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.SparseIntArray;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * Created by David Crowder on 10/29/2016.
 *
 * This class is intended to build the level for CHASM.
 *
 *
 */
public interface LevelBuilder {

    ArrayMap<Position, Integer> buildGrid();           // Only one grid per position

    // TODO: 11/27/2016 Hero[] and Enemy
    ArrayMap<Position, Hero[]> buildHeroes();       // No collision on heroes


    ArrayMap<Position, Enemy> buildEnemies();       // Enemies have collision

}
