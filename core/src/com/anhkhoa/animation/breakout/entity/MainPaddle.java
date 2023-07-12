package com.anhkhoa.animation.breakout.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MainPaddle {
    private Vector2 velocity;
    private float x, y, width, height;
    private Sprite paddleSprite;
    private Rectangle bounds;

    public MainPaddle(float x, float y) {
        init(x, y);
    }

    private void init(float x, float y) {
        paddleSprite = new Sprite(new Texture(Gdx.files.internal("breakout/paddle.png")));
        paddleSprite.setPosition(x, y);
        bounds = new Rectangle(paddleSprite.getX(), paddleSprite.getY(), paddleSprite.getWidth(), paddleSprite.getHeight());
    }

    public void setPosition(float x, float y) {
        paddleSprite.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
        paddleSprite.draw(batch);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Sprite getPaddleSprite() {
        return paddleSprite;
    }

    public void setPaddleSprite(Sprite paddleSprite) {
        this.paddleSprite = paddleSprite;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
