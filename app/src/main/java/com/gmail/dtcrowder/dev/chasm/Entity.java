package com.gmail.dtcrowder.dev.chasm;

/**
 * Created by David Crowder on 12/4/2016.
 */

public abstract class Entity {

    private MoveCommand mMoveCommand;
    private Position mCurrentPosition;

    public void setCurrentPosition(Position position) {
        mCurrentPosition = position;
    }

    public Position getCurrentPosition() {
        return mCurrentPosition;
    }
}
