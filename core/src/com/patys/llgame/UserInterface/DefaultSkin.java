package com.patys.llgame.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DefaultSkin {	
	private Skin skin;
	public DefaultSkin() {

		//Neon UI Ver. 1
		//
		//Created by Raymond "Raeleus" Buckley
		//Visit ray3k.wordpress.com for games, tutorials, and much more!
		//
		//Neon UI can be used under the CC BY license.
		//http://creativecommons.org/licenses/by/4.0/
		skin = new Skin(Gdx.files.internal("data/neon-ui.json"));
	}
	public Skin getSkin() {
		return skin;
	}
}
