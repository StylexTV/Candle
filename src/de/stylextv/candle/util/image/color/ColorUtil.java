package de.stylextv.candle.util.image.color;

public class ColorUtil {
	
	private static final int COMPONENT_LENGTH = 8;
	private static final int MAX_COMPONENT_VALUE = 255;
	
	public static byte[] splitComponents(int color, ColorFormat f) {
		int l = f.getLength();
		
		byte[] data = new byte[l];
		
		for(int i = 0; i < l; i++) {
			
			int index = l - i - 1;
			
			byte b = (byte) getComponent(color, index);
			
			data[i] = b;
		}
		
		return data;
	}
	
	public static int setFormat(int color, ColorFormat from, ColorFormat to) {
		int r = getComponent(color, from.getRedIndex());
		int g = getComponent(color, from.getGreenIndex());
		int b = getComponent(color, from.getBlueIndex());
		
		int a = 255;
		
		if(from.hasAlpha()) {
			
			int index = from.getAlphaIndex();
			
			a = getComponent(color, index);
		}
		
		int i = 0;
		
		setComponent(i, to.getRedIndex(), r);
		setComponent(i, to.getGreenIndex(), g);
		setComponent(i, to.getBlueIndex(), b);
		
		if(to.hasAlpha()) setComponent(color, to.getAlphaIndex(), a);
		
		return i;
	}
	
	private static int getComponent(int color, int index) {
		int l = COMPONENT_LENGTH * index;
		
		int i = color >> l;
		
		return i & MAX_COMPONENT_VALUE;
	}
	
	private static int setComponent(int color, int index, int value) {
		int l = COMPONENT_LENGTH * index;
		
		int i = value << l;
		
		int mask = MAX_COMPONENT_VALUE << l;
		
		color &= ~mask;
		
		return color | i;
	}
	
}
