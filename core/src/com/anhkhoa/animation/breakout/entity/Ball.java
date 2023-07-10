package com.anhkhoa.animation.breakout.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Ball {
    // private float x = 50f, y = 30f, radius = 20f, xSpeed = 5f, ySpeed = 5f;
    private float x = 50f, y = 30f, width = 22f, height = 22f, xSpeed = 5f, ySpeed = 5f;
    private Rectangle ball;

    public Ball() {
        init(x, y, width, height);
    }

    private void init(float x, float y, float width, float height) {
        ball = new Rectangle(x, y, width, height);
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x <= 0 || x >= Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        } else if (y <= 0 || y >= Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Paddle paddle) {
//        if (Intersector.overlaps(ball, paddle)) {
//            tmpPaddle.set(paddle.getX(), paddle.getY() + paddle.getHeight()/2, paddle.getWidth(), paddle.getHeight()/2);
//            if (Intersector.overlaps(this.getBall(), tmpPaddle.)) {
//                ySpeed = -ySpeed;
//            }
//        }
//        if (Intersector.overlaps(this.getBall(), paddle.getPaddle())) {
//            ySpeed = -ySpeed;
//        }
        if (this.getBall().overlaps(paddle.getPaddle())) {
            ySpeed = -ySpeed;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }



    public Rectangle getBall() {
        return ball;
    }

    public void setBall(Rectangle ball) {
        this.ball = ball;
    }
}
