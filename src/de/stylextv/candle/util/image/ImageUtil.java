package de.stylextv.candle.util.image;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import de.stylextv.candle.util.image.color.ColorFormat;
import de.stylextv.candle.util.image.color.ColorUtil;

public class ImageUtil {
	
	public static ByteBuffer imageToBuffer(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		int l = width * height * 4;
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(l);
		
		for(int i = 0; i < l; i++) {
			
			int color = pixels[i];
			
			color = ColorUtil.setFormat(color, ColorFormat.ARGB, ColorFormat.RGBA);
			
			byte[] data = ColorUtil.splitComponents(color, ColorFormat.RGBA);
			
			buffer.put(data);
		}
		
		buffer.flip();
		
		return buffer;
	}
	
}
