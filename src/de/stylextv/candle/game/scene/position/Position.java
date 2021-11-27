package de.stylextv.candle.game.scene.position;

import de.stylextv.candle.game.scene.object.render.Camera;
import de.stylextv.candle.render.layer.RenderLayer;

public abstract class Position {
	
	private float x;
	private float y;
	
	private RenderLayer layer;
	
	public Position(float x, float y, RenderLayer layer) {
		this.x = x;
		this.y = y;
		this.layer = layer;
	}
	
	public abstract float getRenderX(Camera camera);
	public abstract float getRenderY(Camera camera);
	
	protected int getResolutionWidth() {
		RenderLayer layer = getLayer();
		
		return layer.getResolutionWidth();
	}
	
	protected int getResolutionHeight() {
		RenderLayer layer = getLayer();
		
		return layer.getResolutionHeight();
	}
	
	public float getRenderScale() {
		return layer.getRenderScale();
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public RenderLayer getLayer() {
		return layer;
	}
	
}
