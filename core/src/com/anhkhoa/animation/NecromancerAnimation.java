package com.anhkhoa.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class NecromancerAnimation extends ApplicationAdapter {
    private static final int FRAME_COLS = 17, FRAME_ROWS = 7;
    private static float x = 100, y = 200;
    private Texture necromancerImage;
    private SpriteBatch spriteBatch;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> walkAnimation;
    private Animation<TextureRegion> skillAnimation;
    private float stateTime;
    private boolean idleFlipState;
    private boolean isWalking;

    private void addFrames(TextureRegion[][] tmp, Array<TextureRegion> frames, int i, int numberOfFrames) {
        for (int j = 0; j < numberOfFrames; j++) {
            frames.add(tmp[i][j]);
        }
    }

    @Override
    public void create() {
        necromancerImage = new Texture(Gdx.files.internal("Necromancer.png"));

        TextureRegion[][] tmp = TextureRegion.split(necromancerImage,
                                        necromancerImage.getWidth() / FRAME_COLS,
                                        necromancerImage.getHeight() / FRAME_ROWS);
        Array<TextureRegion> idleFrames = new Array<>();
        Array<TextureRegion> walkFrames = new Array<>();
        Array<TextureRegion> skillFrames = new Array<>();
        for (int i = 0; i < FRAME_ROWS; i++) {
            switch (i) {
                case 0:
                    addFrames(tmp, idleFrames, i, 8);
                    break;
                case 1:
                    addFrames(tmp, walkFrames, i, 8);
                    break;
                case 2:
                    addFrames(tmp, skillFrames, i, 13);
                    break;
            }
        }

        idleAnimation = new Animation<TextureRegion>(1/8f, idleFrames);
        walkAnimation = new Animation<TextureRegion>(1/8f, walkFrames);
        skillAnimation = new Animation<TextureRegion>(1/13f, skillFrames);

        spriteBatch = new SpriteBatch();
        stateTime = 0;
        idleFlipState = false;
        isWalking = false;
    }

    @Override
    public void render() {
        // rgb(8, 64, 93)
        int red = 8;
        int green = 64;
        int blue = 93;
        // Convert rgb to rgba in libgdx
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;
        float alpha = 1f;

        Gdx.gl.glClearColor(r, g, b, alpha);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();

        TextureRegion idleCurrentFrame = idleAnimation.getKeyFrame(stateTime, true);
        TextureRegion walkCurrentFrame = walkAnimation.getKeyFrame(stateTime, true);
        TextureRegion skillCurrentFrame = skillAnimation.getKeyFrame(stateTime, true);

        spriteBatch.begin();
        /*spriteBatch.draw(idleCurrentFrame, x, y);

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (walkCurrentFrame.isFlipX()) {
                walkCurrentFrame.flip(true, false);
            }
            spriteBatch.draw(walkCurrentFrame, x, y);
            x += 3;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (!walkCurrentFrame.isFlipX()) {
                walkCurrentFrame.flip(true, false);
            }
            spriteBatch.draw(walkCurrentFrame, x, y);
            x -= 3;
        }*/
        if (!isWalking) {
            if (idleFlipState) {
                idleCurrentFrame.flip(true, false);
            }
            spriteBatch.draw(idleCurrentFrame, x, y);
        } /*else {
            spriteBatch.draw(walkCurrentFrame, x, y);
        }*/

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (walkCurrentFrame.isFlipX()) {
                walkCurrentFrame.flip(true, false);
            }
            spriteBatch.draw(walkCurrentFrame, x, y);
            x += 2;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (!walkCurrentFrame.isFlipX()) {
                walkCurrentFrame.flip(true, false);
                idleFlipState = true;
            }
            spriteBatch.draw(walkCurrentFrame, x, y);
            x -= 2;
        } else {
            spriteBatch.draw(idleCurrentFrame, x, y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            isWalking = true;
        }

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        necromancerImage.dispose();
    }
}
