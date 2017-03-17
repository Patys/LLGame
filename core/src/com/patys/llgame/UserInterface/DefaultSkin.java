package com.patys.llgame.UserInterface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DefaultSkin extends Skin {	
	public DefaultSkin() {
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		this.add("white", new Texture(pixmap));
		
		// Store the default libgdx font under the name "default".
		this.add("default", new BitmapFont());
		

		Label.LabelStyle label1Style = new Label.LabelStyle();
	    BitmapFont myFont = this.getFont("default");
	    label1Style.font = myFont;
	    label1Style.fontColor = Color.DARK_GRAY;
	    this.add("default", label1Style);
	}
}
