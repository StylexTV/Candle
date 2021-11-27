package de.stylextv.candle.game.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

import de.stylextv.candle.game.scene.object.SceneObject;
import de.stylextv.candle.game.scene.object.SceneObjectType;
import de.stylextv.candle.game.scene.object.render.Camera;
import de.stylextv.candle.render.layer.RenderLayer;

public class Scene {
	
	private List<SceneObject> objects = new CopyOnWriteArrayList<>();
	
	private Camera camera;
	
	public Scene() {
		camera = new Camera(this);
	}
	
	public void addObject(SceneObject o) {
		objects.add(o);
	}
	
	public void removeObject(SceneObject o) {
		objects.remove(o);
	}
	
	public List<SceneObject> getObjectsOnLayer(RenderLayer layer) {
		return getObjects(o -> o.getLayer().equals(layer));
	}
	
	public List<SceneObject> getObjectsByType(SceneObjectType type) {
		return getObjects(o -> o.getType().equals(type));
	}
	
	private List<SceneObject> getObjects(Predicate<SceneObject> predicate) {
		List<SceneObject> list = new ArrayList<>();
		
		objects.forEach(o -> {
			
			boolean matches = predicate.test(o);
			
			if(matches) list.add(o);
			
		});
		
		return list;
	}
	
	public List<SceneObject> getObjects() {
		return objects;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
}
