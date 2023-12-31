package com.anhkhoa.animation.breakout.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    private float WIDTH = 150f, HEIGHT = 10f;
    private float x = Gdx.graphics.getWidth() / 2 - WIDTH / 2;
    private float y = 20;
    private Rectangle paddle;

    public Paddle() {
        init(x, y, WIDTH, HEIGHT);
    }

    private void init(float x, float y, float WIDTH, float HEIGHT) {
        paddle = new Rectangle(x, y, WIDTH, HEIGHT);
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

    public float getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(float WIDTH) {
        this.WIDTH = WIDTH;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Rectangle getPaddle() {
        return paddle;
    }

    public void setPaddle(Rectangle paddle) {
        this.paddle = paddle;
    }
}
