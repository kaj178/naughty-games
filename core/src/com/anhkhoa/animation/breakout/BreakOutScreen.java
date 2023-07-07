package com.anhkhoa.animation.breakout;

import com.anhkhoa.animation.breakout.entity.Ball;
import com.anhkhoa.animation.breakout.entity.Paddle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class BreakOutScreen extends ScreenAdapter {
    private ShapeRenderer shapeRenderer;
    private Paddle paddle;
    private Ball ball;
    private Paddle[] enemyPaddle;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        paddle = new Paddle();
        ball = new Ball();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(paddle.getX(), paddle.getY(), paddle.getWIDTH(), paddle.getHEIGHT());
        paddle.setX(Gdx.input.getX() - paddle.getWIDTH() / 2);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(ball.getX(), ball.getY(), ball.getRadius());
        shapeRenderer.end();

        ball.update();
        ball.checkCollision(paddle.getPaddle());
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
