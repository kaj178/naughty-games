package com.anhkhoa.animation.breakout;

import com.anhkhoa.animation.breakout.entity.MainBall;
import com.anhkhoa.animation.breakout.entity.MainPaddle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class MainBreakOutScreen extends ScreenAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private MainBall ball;
    private MainPaddle paddle;
    float xSpeed, ySpeed;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        ball = new MainBall(100, 200);
        xSpeed = MathUtils.random(-300, 300);
        ySpeed = 300;
        ball.setVelocity(xSpeed, ySpeed);
        paddle = new MainPaddle(Gdx.graphics.getWidth() / 2, 20);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        ball.render(batch);
        ball.update(Gdx.graphics.getDeltaTime());
        paddle.render(batch);
        paddle.setPosition(Gdx.input.getX() - paddle.getBounds().getWidth()/2, paddle.getBounds().getY());
        ball.checkPaddleCollision(paddle.getBounds());
        batch.end();
    }



    @Override
    public void dispose() {
        batch.dispose();
    }
}
