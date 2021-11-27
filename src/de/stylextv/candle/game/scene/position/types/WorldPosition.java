package de.stylextv.candle.game.scene.position.types;

import de.stylextv.candle.game.scene.object.render.Camera;
import de.stylextv.candle.game.scene.position.Position;
import de.stylextv.candle.render.layer.RenderLayer;

public class WorldPosition extends Position {
	
	public WorldPosition(float x, float y, RenderLayer layer) {
		super(x, y, layer);
	}
	
	// TODO factor in parallax effect
	
	@Override
	public float getRenderX(Camera camera) {
		float minX = camera.getMinX();
		
		float x = getX() - minX;
		
		return x * getRenderScale();
	}
	
	@Override
	public float getRenderY(Camera camera) {
		float minY = camera.getMinY();
		
		float y = getY() - minY;
		
		int height = getResolutionHeight();
		
		return height - y * getRenderScale();
	}
	
}
