package com.patys.llgame.UserInterface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

public class NextLevelWindow {
	private Dialog dialog;
	
	public NextLevelWindow() {
		DefaultSkin skin = new DefaultSkin();
		dialog = new Dialog("Nowy poziom!", skin.getSkin()) {
		    public void result(Object obj) {
		        System.out.println("result "+obj);
		    }
		};
		dialog.setColor(Color.BLACK);
		dialog.text("Jestes szczesliwy?");
		dialog.button("Hurra", true);
//		dialog.show(stage);
	}

	public Dialog getDialog() {
		return dialog;
	}
}
