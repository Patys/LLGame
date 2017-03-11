package com.patys.llgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.patys.llgame.UserInterface.UserInterface;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;
	
	private final float appWidth = 720; 
	private final float appHeight = 1280;
	private float screenWidth;
	private float screenHeight;
	
	private OrthographicCamera camera;
	private Stage stage;
	private Table table; // everything from UI goes here
	private UserInterface userInterface;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("data/background.png");
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		
  		camera = new OrthographicCamera();
		camera.setToOrtho(false, appWidth, appHeight);
		
		stage = new Stage();
		table = new Table();
		table.setFillParent(true);
		table.setDebug(true);

		userInterface = new UserInterface(table);
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
				
		
		CardManager cardManager = new CardManager();
		cardManager.loadCards("data/cards.json");
		cardManager.saveCards("data/test.json");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		screenWidth = width;
		screenHeight = height;
        camera.update();
        stage.getViewport().update(width, height, true);
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
