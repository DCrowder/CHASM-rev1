package com.gmail.dtcrowder.dev.chasm;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by David Crowder on 10/29/2016.
 *
 * This class is intended to build the level for CHASM.
 *
 *
 */
public interface LevelBuilder {

    List<ImageView> buildGrid();

    void buildHeroes();

    void buildEnemies();

}
