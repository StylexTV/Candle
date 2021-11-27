package de.stylextv.candle.game.scene.object;

import de.stylextv.candle.game.scene.Scene;
import de.stylextv.candle.game.scene.object.render.Camera;
import de.stylextv.candle.game.scene.position.Position;
import de.stylextv.candle.render.layer.RenderLayer;
import de.stylextv.candle.util.scene.BoundingBox;

public abstract class SceneObject extends BoundingBox {
	
	private SceneObjectType type;
	
	private Scene scene;
	
	private Position position;
	
	private boolean lit;
	
	public SceneObject(SceneObjectType type, Position p, Scene scene) {
		this.type = type;
		this.position = p;
		this.scene = scene;
		
		scene.addObject(this);
	}
	
	public void remove() {
		scene.removeObject(this);
	}
	
	public boolean shouldRender() {
		Camera camera = scene.getCamera();
		
		return intersects(camera);
	}
	
	public float getRenderScale() {
		return position.getRenderScale();
	}
	
	public float getRenderX() {
		Camera camera = scene.getCamera();
		
		return position.getRenderX(camera);
	}
	
	public float getRenderY() {
		Camera camera = scene.getCamera();
		
		return position.getRenderY(camera);
	}
	
	public RenderLayer getLayer() {
		return position.getLayer();
	}
	
	public SceneObjectType getType() {
		return type;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isLit() {
		return lit;
	}
	
}
