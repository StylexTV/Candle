package de.stylextv.candle.render.resolution;

import de.stylextv.candle.render.resolution.types.FixedRatioResolution;
import de.stylextv.candle.render.resolution.types.FixedSizeResolution;
import de.stylextv.candle.window.Window;

public abstract class RenderResolution {
	
	public static final RenderResolution HIGH = new FixedRatioResolution(0.5625f);
	public static final RenderResolution LOW = new FixedSizeResolution(320, 180);
	
	public abstract int getWidth();
	public abstract int getHeight();
	
	public abstract void fitWindow(Window w);
	
	public float getRenderScale() {
		return (float) getWidth() / LOW.getWidth();
	}
	
}
