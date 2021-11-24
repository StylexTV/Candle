package de.stylextv.candle.asset;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AssetManager {
	
	private static List<Asset> assets = new CopyOnWriteArrayList<>();
	
	public static void addAsset(Asset a) {
		assets.add(a);
	}
	
	public static void removeAsset(Asset a) {
		assets.remove(a);
	}
	
	public static void destroyAssets() {
		for(Asset a : assets) {
			
			a.destroy();
		}
	}
	
}
