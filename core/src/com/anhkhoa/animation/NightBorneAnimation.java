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
    Animation<TextureRegion> idleAnimation;
    Animation<TextureRegion> runAnimation;
    Animation<TextureRegion> attackAnimation;
    Animation<TextureRegion> hurtAnimation;
    Animation<TextureRegion> dieAnimation;
    float stateTime;

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

        idleAnimation = new Animation<>(0.08f, idleFrames);
        runAnimation = new Animation<>(0.08f, runFrames);
        attackAnimation = new Animation<>(0.07f, attackFrames);
        hurtAnimation = new Animation<>(0.1f, hurtFrames);
        dieAnimation = new Animation<>(0.07f, dieFrames);

        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
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
