package de.stylextv.candle.asset.types;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.stylextv.candle.asset.Asset;

public class TextAsset extends Asset {
	
	public TextAsset(String path) {
		super(path);
	}
	
	public String getText() {
		return getText("");
	}
	
	public String getText(String ending) {
		InputStream stream = asStream(ending);
		
		InputStreamReader reader = new InputStreamReader(stream);
		
		BufferedReader buffered = new BufferedReader(reader);
		
		Stream<String> s = buffered.lines();
		
		return s.collect(Collectors.joining("\n"));
	}
	
}
