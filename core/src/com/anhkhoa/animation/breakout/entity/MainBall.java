package com.anhkhoa.animation.breakout.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class MainBall {
    private Vector2 velocity;
    private Sprite ballSprite;
    private Circle bounds;
    private float xSpeed, ySpeed;

    public MainBall(float x, float y) {
        init(x, y);
    }

    private void init(float x, float y) {
        xSpeed = 0;
        ySpeed = 0;
        velocity = new Vector2(xSpeed, ySpeed);
        ballSprite = new Sprite(new Texture(Gdx.files.internal("breakout/ball.png")));
        ballSprite.setPosition(x, y);
        bounds = new Circle(ballSprite.getX(), ballSprite.getY(), ballSprite.getWidth() / 2);
    }

    public void update(float delta) {
        ballSprite.translate(velocity.x * delta, velocity.y * delta);
        bounds.setPosition(ballSprite.getX(), ballSprite.getY());
        checkWallCollision();
    }

    public void checkWallCollision() {
        if (this.getBounds().x <= 0) {
            velocity.x *= -1;
        }
        if (this.getBounds().x >= Gdx.graphics.getWidth() - this.getBounds().radius) {
            velocity.x *= -1;
        }
        if (this.getBounds().y <= 0) {
            velocity.y *= -1;
        }
        if (this.getBounds().y >= Gdx.graphics.getHeight() - this.getBounds().radius) {
            velocity.y *= -1;
        }
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

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
}
