package de.stylextv.candle.game.scene.position.types;

import de.stylextv.candle.game.scene.object.render.Camera;
import de.stylextv.candle.game.scene.position.Position;
import de.stylextv.candle.render.layer.RenderLayer;

public class ScreenPosition extends Position {
	
	public ScreenPosition(float x, float y, RenderLayer layer) {
		super(x, y, layer);
	}
	
	@Override
	public float getRenderX(Camera camera) {
		int width = getResolutionWidth();
		
		return width * getX();
	}
	
	@Override
	public float getRenderY(Camera camera) {
		int height = getResolutionHeight();
		
		return height * getY();
	}
	
}
