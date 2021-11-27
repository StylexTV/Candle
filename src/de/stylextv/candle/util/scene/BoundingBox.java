package de.stylextv.candle.util.scene;

public abstract class BoundingBox {
	
	public abstract float getMinX();
	public abstract float getMaxX();
	
	public abstract float getMinY();
	public abstract float getMaxY();
	
	public boolean intersects(BoundingBox box) {
		float minX = box.getMinX();
		float maxX = box.getMaxX();
		
		if(getMaxX() < minX || getMinX() > maxX) return false;
		
		float minY = box.getMinY();
		float maxY = box.getMaxY();
		
		if(getMaxY() < minY || getMinY() > maxY) return false;
		
		return true;
	}
	
}
