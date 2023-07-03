package com.anhkhoa.animation;

import com.anhkhoa.animation.breakout.BreakOut;
import com.anhkhoa.animation.circle.HuntingCircle;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(800, 480);
		config.setTitle("Night borne");
		// new Lwjgl3Application(new DemoAnimation(), config);
		// new Lwjgl3Application(new NightBorneAnimation(), config);
		// new Lwjgl3Application(new NecromancerAnimation(), config);
		// new Lwjgl3Application(new HuntingCircle(), config);
		new Lwjgl3Application(new BreakOut(), config);
	}
}
