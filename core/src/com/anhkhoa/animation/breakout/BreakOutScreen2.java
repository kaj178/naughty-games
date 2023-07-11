package com.anhkhoa.animation.breakout;

import com.anhkhoa.animation.breakout.entity.Ball2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class BreakOutScreen2 extends ScreenAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Ball2 ball;

    float xSpeed, ySpeed;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        ball = new Ball2(100, 200);
        xSpeed = MathUtils.random(-300, 300);
        ySpeed = 300;
        checkWallCollision();
        ball.setVelocity(xSpeed, ySpeed);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.disableBlending();

        ball.render(batch);
        ball.update(Gdx.graphics.getDeltaTime());


        batch.enableBlending();
        batch.end();
    }

    public void checkWallCollision() {
        if (ball.getBounds().x <= 0) {
            xSpeed *= -1;
        }
        if (ball.getBounds().x >= Gdx.graphics.getWidth()) {
            xSpeed *= -1;
        }
        if (ball.getBounds().y <= 0) {
            ySpeed *= -1;
        }
        if (ball.getBounds().y >= Gdx.graphics.getHeight()) {
            ySpeed *= -1;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
