package com.anhkhoa.animation.breakout;

import com.anhkhoa.animation.breakout.entity.Ball2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class BreakOutScreen2 extends ScreenAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Ball2 ball;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        ball = new Ball2(100, 200);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        ball.update(5);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
