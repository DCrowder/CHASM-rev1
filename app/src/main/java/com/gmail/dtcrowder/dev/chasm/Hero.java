package com.gmail.dtcrowder.dev.chasm;

import java.util.UUID;

/**
 * Created by David Crowder on 11/27/2016.
 */

public class Hero {

    // TODO: 11/27/2016
    private Position mCurrentPosition;
    private UUID mHeroId;

    public Hero (UUID uuid) {

        mHeroId = uuid;

    }

    public void setCurrentPosition(Position position) {
        mCurrentPosition = position;
    }

    public Position getCurrentPosition() {
        return mCurrentPosition;
    }
}
