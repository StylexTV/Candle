package de.stylextv.candle.asset;

import java.io.InputStream;

public class Asset {
	
	private static final String FOLDER = "assets/";
	
	private String path;
	
	private boolean created;
	
	public Asset() {
		this(null);
	}
	
	public Asset(String path) {
		this.path = path;
		
		create();
	}
	
	public void create() {
		if(created) destroy();
		
		AssetManager.addAsset(this);
		
		created = true;
	}
	
	public void destroy() {
		AssetManager.removeAsset(this);
		
		created = false;
	}
	
	public InputStream asStream() {
		return asStream("");
	}
	
	public InputStream asStream(String ending) {
		Thread thread = Thread.currentThread();
		
		ClassLoader loader = thread.getContextClassLoader();
		
		return loader.getResourceAsStream(FOLDER + path + ending);
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean isCreated() {
		return created;
	}
	
}
