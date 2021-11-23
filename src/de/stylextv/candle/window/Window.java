package de.stylextv.candle.window;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

import de.stylextv.candle.Constants;

public class Window {
	
	private static final String TITLE = Constants.NAME;
	
	private static final boolean VSYNC = true;
	
	private int width;
	private int height;
	
	private long pointer;
	
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	// TODO create key, mouse and resize callbacks
	public void create() {
		if(!GLFW.glfwInit()) throw new IllegalStateException("Unable to initialize GLFW!");
		
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		
		pointer = GLFW.glfwCreateWindow(width, height, TITLE, MemoryUtil.NULL, MemoryUtil.NULL);
		
		if(pointer == MemoryUtil.NULL) throw new RuntimeException("Failed to create GLFW window!");
		
		centerOnScreen();
		
		GLFW.glfwMakeContextCurrent(pointer);
		
		int interval = VSYNC ? 1 : 0;
		
		GLFW.glfwSwapInterval(interval);
		
		GLFW.glfwShowWindow(pointer);
	}
	
	public void destroy() {
		Callbacks.glfwFreeCallbacks(pointer);
		
		GLFW.glfwDestroyWindow(pointer);
		
		GLFW.glfwTerminate();
	}
	
	public void close() {
		GLFW.glfwSetWindowShouldClose(pointer, true);
	}
	
	public boolean isClosed() {
		return GLFW.glfwWindowShouldClose(pointer);
	}
	
	public void centerOnScreen() {
		long l = GLFW.glfwGetPrimaryMonitor();
		
		GLFWVidMode mode = GLFW.glfwGetVideoMode(l);
		
		int w = mode.width();
		int h = mode.height();
		
		int x = (w - width) / 2;
		int y = (h - height) / 2;
		
		setPosition(x, y);
	}
	
	public void setPosition(int x, int y) {
		GLFW.glfwSetWindowPos(pointer, x, y);
	}
	
	public void setSize(int width, int height) {
		GLFW.glfwSetWindowSize(pointer, width, height);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
