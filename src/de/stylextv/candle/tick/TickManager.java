package de.stylextv.candle.tick;

import java.util.concurrent.TimeUnit;

import de.stylextv.candle.asset.AssetManager;
import de.stylextv.candle.render.RenderManager;
import de.stylextv.candle.util.async.AsyncUtil;

public class TickManager {
	
	private static final int FPS = 60;
	
	public static void start() {
		onStart();
		
		long time = System.nanoTime();
		
		long wait = 1000000000 / FPS;
		
		while(!RenderManager.isWindowClosed()) {
			
			run();
			
			long elapsed = System.nanoTime() - time;
			
			long delay = wait - elapsed;
			
			AsyncUtil.sleep(delay, TimeUnit.NANOSECONDS);
			
			time = System.nanoTime();
		}
		
		onStop();
	}
	
	private static void onStart() {
		// load the main menu scene
		
		RenderManager.start();
	}
	
	private static void onStop() {
		RenderManager.stop();
		
		AssetManager.destroyAssets();
	}
	
	private static void run() {
		RenderManager.run();
	}
	
}
