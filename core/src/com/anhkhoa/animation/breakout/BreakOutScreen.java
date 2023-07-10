package com.anhkhoa.animation.breakout;

import com.anhkhoa.animation.breakout.entity.Ball;
import com.anhkhoa.animation.breakout.entity.Paddle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class BreakOutScreen extends ScreenAdapter {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private Texture ballTex;
    private Texture paddleTex;
    private Paddle paddle;
    private Ball ball;
    private Paddle[] enemyPaddle;
    private OrthographicCamera camera;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch = new SpriteBatch();
        ballTex = new Texture(Gdx.files.internal("breakout/ball.png"));
        paddleTex = new Texture(Gdx.files.internal("breakout/paddle.png"));
        ball = new Ball();
        paddle = new Paddle();

//        sprite = new Sprite(ballTex);
//        sprite.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.WHITE);
//        shapeRenderer.rect(paddle.getX(), paddle.getY(), paddle.getWIDTH(), paddle.getHEIGHT());
//        paddle.setX(Gdx.input.getX() - paddle.getWIDTH() / 2);
//        shapeRenderer.end();
//
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.WHITE);
//        shapeRenderer.circle(ball.getX(), ball.getY(), ball.getRadius());
//        shapeRenderer.end();
//
//        ball.update();
//        ball.checkCollision(paddle);
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(ballTex, ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius());
        spriteBatch.draw(paddleTex, paddle.getX(), paddle.getY());
        paddle.setX(Gdx.input.getX() - paddle.getWIDTH() / 2);
        // sprite.draw(spriteBatch);
        spriteBatch.end();

        ball.update();
        ball.checkCollision(paddle);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        spriteBatch.dispose();
        ballTex.dispose();
        paddleTex.dispose();
    }
}
