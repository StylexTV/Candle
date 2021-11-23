package de.stylextv.candle.render.layer;

public class RenderLayer {
	
	public static final RenderLayer UI = new RenderLayer();
	
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
			UI,
			
			FOREGROUND_PARTICLES,
			FOREGROUND_SCENERY,
			FOREGROUND_TILES,
			
			FOREGROUND_GAMEPLAY,
			GAMEPLAY,
			BACKGROUND_GAMEPLAY,
			
			BACKGROUND_SCENERY,
			BACKGROUND_TILES,
			BACKGROUND_PARTICLES,
			
			LANDSCAPE1,
			LANDSCAPE2,
			LANDSCAPE3
	};
	
	
	
	public static RenderLayer[] getLayers() {
		return layers;
	}
	
}
