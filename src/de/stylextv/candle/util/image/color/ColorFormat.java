package de.stylextv.candle.util.image.color;

public class ColorFormat {
	
	public static final ColorFormat RGB = new ColorFormat(2, 1, 0);
	
	public static final ColorFormat ARGB = new ColorFormat(2, 1, 0, 3);
	public static final ColorFormat RGBA = new ColorFormat(3, 2, 1, 0);
	
	private static final int INVALID_INDEX = -1;
	
	private int redIndex;
	private int greenIndex;
	private int blueIndex;
	private int alphaIndex;
	
	private int length;
	
	public ColorFormat(int redIndex, int greenIndex, int blueIndex) {
		this(redIndex, greenIndex, blueIndex, INVALID_INDEX, 3);
	}
	
	public ColorFormat(int redIndex, int greenIndex, int blueIndex, int alphaIndex) {
		this(redIndex, greenIndex, blueIndex, alphaIndex, 4);
	}
	
	public ColorFormat(int redIndex, int greenIndex, int blueIndex, int alphaIndex, int length) {
		this.redIndex = redIndex;
		this.greenIndex = greenIndex;
		this.blueIndex = blueIndex;
		this.alphaIndex = alphaIndex;
		
		this.length = length;
	}
	
	public boolean hasAlpha() {
		return alphaIndex != INVALID_INDEX;
	}
	
	public int getRedIndex() {
		return redIndex;
	}
	
	public int getGreenIndex() {
		return greenIndex;
	}
	
	public int getBlueIndex() {
		return blueIndex;
	}
	
	public int getAlphaIndex() {
		return alphaIndex;
	}
	
	public int getLength() {
		return length;
	}
	
}
