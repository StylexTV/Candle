package de.stylextv.candle.render.layer;

import de.stylextv.candle.render.resolution.RenderResolution;

public class RenderLayer {
	
	public static final RenderLayer UI = new RenderLayer(RenderResolution.HIGH);
	
	public static final RenderLayer GAMEPLAY = new RenderLayer();
	public static final RenderLayer FOREGROUND_GAMEPLAY = new RenderLayer();
	public static final RenderLayer BACKGROUND_GAMEPLAY = new RenderLayer();
	
	public static final RenderLayer FOREGROUND_PARTICLES = new RenderLayer();
	public static final RenderLayer BACKGROUND_PARTICLES = new RenderLayer();
	
	public static final RenderLayer FOREGROUND_TILES = new RenderLayer();
	public static final RenderLayer BACKGROUND_TILES = new RenderLayer();
	
	public static final RenderLayer FOREGROUND_SCENERY = new RenderLayer();
	public static final RenderLayer BACKGROUND_SCENERY = new RenderLayer();
	
	public static final RenderLayer LANDSCAPE1 = new RenderLayer();
	public static final RenderLayer LANDSCAPE2 = new RenderLayer();
	public static final RenderLayer LANDSCAPE3 = new RenderLayer();
	
	private static RenderLayer[] layers = new RenderLayer[] {
			LANDSCAPE3,
			LANDSCAPE2,
			LANDSCAPE1,
			
			BACKGROUND_PARTICLES,
			BACKGROUND_TILES,
			BACKGROUND_SCENERY,
			
			BACKGROUND_GAMEPLAY,
			GAMEPLAY,
			FOREGROUND_GAMEPLAY,
			
			FOREGROUND_TILES,
			FOREGROUND_SCENERY,
			FOREGROUND_PARTICLES,
			
			UI
	};
	
	private RenderResolution resolution;
	
	public RenderLayer() {
		this(RenderResolution.LOW);
	}
	
	public RenderLayer(RenderResolution r) {
		this.resolution = r;
	}
	
	public float getRenderScale() {
		return resolution.getRenderScale();
	}
	
	public int getResolutionWidth() {
		return resolution.getWidth();
	}
	
	public int getResolutionHeight() {
		return resolution.getHeight();
	}
	
	public RenderResolution getResolution() {
		return resolution;
	}
	
	public static RenderLayer[] getLayers() {
		return layers;
	}
	
}
