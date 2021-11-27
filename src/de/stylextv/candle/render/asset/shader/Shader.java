package de.stylextv.candle.render.asset.shader;

import java.util.HashMap;

import org.lwjgl.opengl.GL30;

import de.stylextv.candle.asset.types.TextAsset;
import de.stylextv.candle.util.DataUtil;
import de.stylextv.candle.util.opengl.shader.ShaderUtil;

public class Shader extends TextAsset {
	
	private static final String FOLDER = "shaders/";
	
	private static final String FILE_ENDING = ".glsl";
	
	private static final String VERTEX_FILE_ENDING = "_vertex" + FILE_ENDING;
	private static final String FRAGMENT_FILE_ENDING = "_fragment" + FILE_ENDING;
	
	private int pointer;
	
	private HashMap<String, Integer> locationCache = new HashMap<>();
	
	public Shader(String path) {
		super(FOLDER + path);
	}
	
	@Override
	public void create() {
		super.create();
		
		int pointer1 = compileShader(VERTEX_FILE_ENDING, GL30.GL_VERTEX_SHADER);
		int pointer2 = compileShader(FRAGMENT_FILE_ENDING, GL30.GL_FRAGMENT_SHADER);
		
		pointer = GL30.glCreateProgram();
		
		GL30.glAttachShader(pointer, pointer1);
		GL30.glAttachShader(pointer, pointer2);
		
		GL30.glLinkProgram(pointer);
		
		if(!ShaderUtil.isProgramLinked(pointer)) {
			
			String log = ShaderUtil.getProgramLog(pointer);
			
			System.err.println("Failed to link program: " + log);
		}
		
		GL30.glDeleteShader(pointer1);
		GL30.glDeleteShader(pointer2);
	}
	
	private int compileShader(String ending, int type) {
		int pointer = GL30.glCreateShader(type);
		
		String s = getText(ending);
		
		GL30.glShaderSource(pointer, s);
		GL30.glCompileShader(pointer);
		
		if(!ShaderUtil.isShaderCompiled(pointer)) {
			
			String log = ShaderUtil.getShaderLog(pointer);
			
			System.err.println("Failed to compile shader: " + log);
		}
		
		return pointer;
	}
	
	@Override
	public void destroy() {
		GL30.glDeleteProgram(pointer);
		
		super.destroy();
	}
	
	public void setFloat(String name, float f) {
		int i = getUniformLocation(name);
		
		GL30.glUniform1f(i, f);
	}
	
	public void setInteger(String name, int i) {
		int location = getUniformLocation(name);
		
		GL30.glUniform1i(location, i);
	}
	
	public void setBoolean(String name, boolean b) {
		int i = DataUtil.booleanToInt(b);
		
		setInteger(name, i);
	}
	
	private int getUniformLocation(String name) {
		return locationCache.computeIfAbsent(name, s -> GL30.glGetUniformLocation(pointer, s));
	}
	
	public void use() {
		GL30.glUseProgram(pointer);
	}
	
}
