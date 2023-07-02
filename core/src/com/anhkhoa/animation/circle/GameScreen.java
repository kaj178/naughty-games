package com.anhkhoa.animation.circle;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class GameScreen extends ScreenAdapter {
    private ShapeRenderer shapeRenderer;
    private Circle player;
    private Circle[] enemies;
    private static final int NUMBER_OF_ENEMIES = 10;

    @Override
    public void show() {
        
    }
}
