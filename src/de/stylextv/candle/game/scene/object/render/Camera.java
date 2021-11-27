package de.stylextv.candle.game.scene.object.render;

import de.stylextv.candle.game.scene.Scene;
import de.stylextv.candle.game.scene.object.SceneObject;
import de.stylextv.candle.game.scene.object.SceneObjectType;
import de.stylextv.candle.game.scene.position.Position;
import de.stylextv.candle.game.scene.position.types.WorldPosition;
import de.stylextv.candle.render.layer.RenderLayer;

public class Camera extends SceneObject {
	
	public Camera(Scene scene) {
		this(0, 0, scene);
	}
	
	public Camera(float x, float z, Scene scene) {
		super(SceneObjectType.CAMERA, new WorldPosition(x, z, RenderLayer.GAMEPLAY), scene);
	}
	
	@Override
	public float getMinX() {
		int width = getViewWidth();
		
		return getCenterX() - width / 2;
	}
	
	@Override
	public float getMaxX() {
		int width = getViewWidth();
		
		return getCenterX() + width / 2;
	}
	
	@Override
	public float getMinY() {
		int height = getViewHeight();
		
		return getCenterY() - height / 2;
	}
	
	@Override
	public float getMaxY() {
		int height = getViewHeight();
		
		return getCenterY() + height / 2;
	}
	
	private int getViewWidth() {
		RenderLayer layer = getLayer();
		
		return layer.getResolutionWidth();
	}
	
	private int getViewHeight() {
		RenderLayer layer = getLayer();
		
		return layer.getResolutionHeight();
	}
	
	public float getCenterX() {
		Position p = getPosition();
		
		return p.getX();
	}
	
	public float getCenterY() {
		Position p = getPosition();
		
		return p.getX();
	}
	
}
