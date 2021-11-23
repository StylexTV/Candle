package de.stylextv.candle.tick;

import de.stylextv.candle.render.RenderManager;

public class TickManager {
	
	public static void start() {
		onStart();
		
		while(!RenderManager.isWindowClosed()) {
			
			run();
		}
		
		onStop();
	}
	
	private static void onStart() {
		RenderManager.start();
	}
	
	private static void onStop() {
		RenderManager.stop();
	}
	
	private static void run() {
		RenderManager.run();
	}
	
}
