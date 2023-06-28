package com.anhkhoa.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DemoAnimation implements ApplicationListener {
	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

	// Object used
	Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion ... )
	SpriteBatch spriteBatch;
	Texture walkSheet;

	// A variable for tracking elapsed time for the animation
	float stateTime;
	
	@Override
	public void create () {
		// Load the sprite sheet as a Texture
		walkSheet = new Texture(Gdx.files.internal("sprite-animation1.png"));

		// Split the sprite sheet into a 2D array of frames
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
									walkSheet.getWidth() / FRAME_COLS,
									walkSheet.getHeight() / FRAME_ROWS);
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}

		// Constructor: (Time per frame, array of frames)
		// FPS: 30 => TPF: 0.03
		walkAnimation = new Animation<TextureRegion>(0.03f, walkFrames);

		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();

		TextureRegion currentTime = walkAnimation.getKeyFrame(stateTime, true);
		spriteBatch.begin();
		spriteBatch.draw(currentTime, 100, 200);
		spriteBatch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		spriteBatch.dispose();
		walkSheet.dispose();
	}
}
