package com.anhkhoa.animation.breakout.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball2 {
    private Vector2 velocity;
    private Sprite ballSprite;
    private Circle bounds;

    public Ball2(float x, float y) {
        init(x, y);
    }

    private void init(float x, float y) {
        velocity = new Vector2(0, 0);
        ballSprite = new Sprite(new Texture(Gdx.files.internal("breakout/ball.png")));
        ballSprite.setPosition(x, y);
        bounds = new Circle(ballSprite.getX(), ballSprite.getY(), ballSprite.getWidth() / 2);
    }

    public void update(float delta) {
        ballSprite.translate(velocity.x * delta, velocity.y * delta);
        bounds.setPosition(ballSprite.getX(), ballSprite.getY());
    }

    public void setVelocity(float x, float y) {
        velocity.x = x;
        velocity.y = y;
    }

    public void render(SpriteBatch batch) {
        ballSprite.draw(batch);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Sprite getBallSprite() {
        return ballSprite;
    }

    public void setBallSprite(Sprite ballSprite) {
        this.ballSprite = ballSprite;
    }

    public Circle getBounds() {
        return bounds;
    }

    public void setBounds(Circle bounds) {
        this.bounds = bounds;
    }
}