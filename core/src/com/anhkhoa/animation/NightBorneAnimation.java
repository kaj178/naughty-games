package com.anhkhoa.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class NightBorneAnimation extends ApplicationAdapter {
    private static final int FRAME_COLS = 23, FRAME_ROWS = 5;
    private Texture nightBorneImage;
    private SpriteBatch spriteBatch;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> runAnimation;
    private Animation<TextureRegion> attackAnimation;
    private Animation<TextureRegion> hurtAnimation;
    private Animation<TextureRegion> dieAnimation;
    private float stateTime;

    private void addFrames(TextureRegion[][] tmp, Array<TextureRegion> frames, int i, int numberOfFrames) {
        for (int j = 0; j < numberOfFrames; j++) {
            frames.add(tmp[i][j]);
        }
    }

    @Override
    public void create() {
        nightBorneImage = new Texture(Gdx.files.internal("NightBorne.png"));

        TextureRegion[][] tmp = TextureRegion.split(nightBorneImage,
                            nightBorneImage.getWidth() / FRAME_COLS,
                            nightBorneImage.getHeight() / FRAME_ROWS);
        Array<TextureRegion> idleFrames = new Array<>();
        Array<TextureRegion> runFrames = new Array<>();
        Array<TextureRegion> attackFrames = new Array<>();
        Array<TextureRegion> hurtFrames = new Array<>();
        Array<TextureRegion> dieFrames = new Array<>();

        // int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            switch (i) {
                case 0:
                    addFrames(tmp, idleFrames, i, 9);
                    break;
                case 1:
                    addFrames(tmp, runFrames, i, 6);
                    break;
                case 2:
                    addFrames(tmp, attackFrames, i, 12);
                    break;
                case 3:
                    addFrames(tmp, hurtFrames, i, 5);
                    break;
                case 4:
                    addFrames(tmp, dieFrames, i, 23);
            }
        }

        idleAnimation = new Animation<>((float) 1/12, idleFrames);
        runAnimation = new Animation<>((float) 1/10, runFrames);
        attackAnimation = new Animation<>((float) 1/15, attackFrames);
        hurtAnimation = new Animation<>((float) 1/8, hurtFrames);
        dieAnimation = new Animation<>((float) 1/20, dieFrames);

        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void render() {
        // rgb(7, 87, 128)
        int red = 7;
        int green = 87;
        int blue = 128;
        // Convert rgb to rgba in libgdx
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;
        float alpha = 1f;
        Gdx.gl.glClearColor(r, g, b, alpha);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime();

        TextureRegion idleCurrentTime = idleAnimation.getKeyFrame(stateTime, true);
        TextureRegion runCurrentTime = runAnimation.getKeyFrame(stateTime, true);
        TextureRegion attackCurrentTime = attackAnimation.getKeyFrame(stateTime, true);
        TextureRegion hurtCurrentTime = hurtAnimation.getKeyFrame(stateTime, true);
        TextureRegion dieCurrentTime = dieAnimation.getKeyFrame(stateTime, true);

        spriteBatch.begin();
        spriteBatch.draw(idleCurrentTime, 100, 200);
        spriteBatch.draw(runCurrentTime, 200, 200);
        spriteBatch.draw(attackCurrentTime, 300, 200);
        spriteBatch.draw(hurtCurrentTime, 400, 200);
        spriteBatch.draw(dieCurrentTime, 500, 200);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        nightBorneImage.dispose();
    }
}
