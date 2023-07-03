package com.anhkhoa.animation.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class HuntingCircleScreen extends ScreenAdapter {
    private ShapeRenderer shapeRenderer;
    private Circle player;
    private Circle[] enemies;
    private static final int NUMBER_OF_ENEMIES = 10;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        player = new Circle(100, 100, 30);
        enemies = new Circle[NUMBER_OF_ENEMIES];
        for (int index = 0; index < NUMBER_OF_ENEMIES; index++) {
            // Keep enemies at the screen limit
            float x =(float) (Math.random() * Gdx.graphics.getWidth());
            float y = (float) (Math.random() * Gdx.graphics.getHeight());
            float radius = 10f;
            enemies[index] = new Circle(x, y, radius);
        }
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += 4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= 4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.y += 4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.y -= 4;
        }
    }

    public void checkCollision() {
        for (Circle enemy : enemies) {
            if (player.overlaps(enemy)) {
                Vector2 vector = new Vector2(-100, -100);
                enemy.setPosition(vector);
            }
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(player.x, player.y, player.radius);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        for (Circle enemy : enemies) {
            shapeRenderer.circle(enemy.x, enemy.y, enemy.radius);
        }
        shapeRenderer.end();

        handleInput();
        checkCollision();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
