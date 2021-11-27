package de.stylextv.candle.util.async;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.stylextv.candle.util.ExceptionUtil;

public class AsyncUtil {
	
	private static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
	
	public static TaskInfo loopAsync(Runnable r, long delay) {
		return loopAsync(r, 0, delay);
	}
	
	public static TaskInfo loopAsync(Runnable r, long initialDelay, long delay) {
		return loopAsync(r, null, initialDelay, delay);
	}
	
	public static TaskInfo loopAsync(Runnable r, Runnable killCallback, long initialDelay, long delay) {
		TaskInfo info = new TaskInfo();
		
		info.setTask(() -> {
			
			sleep(initialDelay);
			
			while(!info.isKilled()) {
				r.run();
				
				sleep(delay);
			}
			
			if(killCallback != null) killCallback.run();
		});
		
		runAsync(info);
		
		return info;
	}
	
	public static void runLaterAsync(Runnable r, long delay) {
		runAsync(() -> {
			
			sleep(delay);
			
			r.run();
		});
	}
	
	public static void runAsync(Runnable r) {
		Runnable wrapped = () -> ExceptionUtil.catchEverything(r);
		
		THREAD_POOL.execute(wrapped);
	}
	
	public static void sleep(long delay) {
		sleep(delay, TimeUnit.MILLISECONDS);
	}
	
	public static void sleep(long delay, TimeUnit u) {
		if(delay <= 0) return;
		
		long l = u.convert(delay, TimeUnit.NANOSECONDS);
		
		try {
			
			long millis = l / 1000000;
			long nanos = l % 1000000;
			
			Thread.sleep(millis, (int) nanos);
			
		} catch (InterruptedException ex) {}
	}
	
}
