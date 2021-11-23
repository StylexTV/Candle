package de.stylextv.candle.render;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

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
		
		// render
		
		GLFW.glfwPollEvents();
	}
	
	public static void closeWindow() {
		window.close();
	}
	
	public static boolean isWindowClosed() {
		return window.isClosed();
	}
	
}
