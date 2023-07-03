package com.anhkhoa.animation.breakout;

import com.badlogic.gdx.Game;

public class BreakOut extends Game {
    @Override
    public void create() {
        setScreen(new BreakOutScreen());
    }
}
