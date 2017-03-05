package com.patys.llgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	
	final float appWidth = 720; 
	final float appHeight = 1280;
	float screenWidth;
	float screenHeight;
	
	OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
  		camera = new OrthographicCamera();
		camera.setToOrtho(false, appWidth, appHeight);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		screenWidth = width;
		screenHeight = height;
        camera.update();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
