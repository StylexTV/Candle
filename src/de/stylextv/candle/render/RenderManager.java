package de.stylextv.candle.render;

import java.util.List;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import de.stylextv.candle.game.GameManager;
import de.stylextv.candle.game.scene.Scene;
import de.stylextv.candle.game.scene.object.SceneObject;
import de.stylextv.candle.render.layer.RenderLayer;
import de.stylextv.candle.render.resolution.RenderResolution;
import de.stylextv.candle.render.target.RenderTarget;
import de.stylextv.candle.window.Window;

public class RenderManager {
	
	private static Window window;
	
	public static void start() {
		window = new Window(960, 540);
		
		window.create();
	}
	
	public static void stop() {
		window.destroy();
	}
	
	public static void run() {
		GL.createCapabilities();
		
		RenderResolution.HIGH.fitWindow(window);
		
		Scene scene = GameManager.getScene();
		
		// render lights
		
		RenderTarget.LEVEL.bind();
		
		for(RenderLayer l : RenderLayer.getLayers()) {
			
			// if at high resolution layer: apply effects to level render target, switch render target and draw level render target
			
			List<SceneObject> objects = scene.getObjectsOnLayer(l);
			
			for(SceneObject o : objects) {
				
				if(!o.shouldRender()) continue;
				
				// render object
			}
		}
		
		GLFW.glfwPollEvents();
	}
	
	public static void closeWindow() {
		window.close();
	}
	
	public static boolean isWindowClosed() {
		return window.isClosed();
	}
	
}
