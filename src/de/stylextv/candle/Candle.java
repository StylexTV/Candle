package de.stylextv.candle;

import de.stylextv.candle.tick.TickManager;

public class Candle {
	
	private static Candle instance;
	
	public Candle() {
		instance = this;
	}
	
	public void onStart() {
		TickManager.start();
	}
	
	public static Candle getInstance() {
		return instance;
	}
	
}
