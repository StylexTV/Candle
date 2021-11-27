package de.stylextv.candle.util.opengl.shader;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL30;

public class ShaderUtil {
	
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	
	public static String getProgramLog(int pointer) {
		return GL30.glGetProgramInfoLog(pointer);
	}
	
	public static String getShaderLog(int pointer) {
		return GL30.glGetShaderInfoLog(pointer);
	}
	
	public static boolean isProgramLinked(int pointer) {
		int i = getShaderStatus(pointer, GL30.GL_LINK_STATUS);
		
		return i == SUCCESS;
	}
	
	public static boolean isShaderCompiled(int pointer) {
		int i = getShaderStatus(pointer, GL30.GL_COMPILE_STATUS);
		
		return i == SUCCESS;
	}
	
	public static int getProgramStatus(int pointer, int name) {
		IntBuffer buffer = BufferUtils.createIntBuffer(1);
		
		GL30.glGetProgramiv(pointer, name, buffer);
		
		return buffer.get();
	}
	
	public static int getShaderStatus(int pointer, int name) {
		IntBuffer buffer = BufferUtils.createIntBuffer(1);
		
		GL30.glGetShaderiv(pointer, name, buffer);
		
		return buffer.get();
	}
	
}
