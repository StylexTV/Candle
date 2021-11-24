package de.stylextv.candle.asset;

import java.io.InputStream;

public class Asset {
	
	private static final String ROOT_FOLDER = "assets/";
	
	private String path;
	
	private boolean created;
	
	public Asset(String path) {
		this.path = path;
		
		create();
	}
	
	public void create() {
		AssetManager.addAsset(this);
		
		created = true;
	}
	
	public void destroy() {
		AssetManager.removeAsset(this);
		
		created = false;
	}
	
	public InputStream asStream() {
		Thread thread = Thread.currentThread();
		
		ClassLoader loader = thread.getContextClassLoader();
		
		return loader.getResourceAsStream(ROOT_FOLDER + path);
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean isCreated() {
		return created;
	}
	
}
