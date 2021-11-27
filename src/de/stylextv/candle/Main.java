package de.stylextv.candle;

import de.stylextv.candle.util.ExceptionUtil;

public class Main {
	
	public static void main(String[] args) {
		Candle c = new Candle();
		
		ExceptionUtil.catchEverything(() -> c.onStart());
	}
	
}
