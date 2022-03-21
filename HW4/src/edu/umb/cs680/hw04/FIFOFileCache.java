package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FIFOFileCache extends FileCache
{
	private List<Long> FIFOCount;


	public FIFOFileCache(){
		FIFOCount = new ArrayList<>();
		cache = new LinkedHashMap<>();
	}

	@Override
	protected boolean isCached(Path path) {
		return cache.containsKey(path);
	}

	@Override
	protected boolean isCacheFull() {
		return cache.size() == 3;
	}

	@Override
	protected void cacheFile(Path path) {
		try{
			String content = new String(Files.readAllBytes(path));
			cache.put(path,content);
			FIFOCount.add(System.currentTimeMillis());
		}catch (IOException e){
			e.toSting();
		}
	}

	@Override
	protected void replace(Path path) {
		long minVal = Collections.min(FIFOCount);
		int rmvIdx = FIFOCount.indexOf(minval);
		FIFOCount.remove(rmvIdx);
		cache.remove(cache.keySet().toArray()[rmvIdx]);
		try{
			String content = new String(Files.readAllBytes(path));
			cache.put(path,content);
			long timeStamp = System.currentTimeMillis();
			FIFOCount.add(timeStamp);
		}catch (IOException e){
			e.toString();
		}
	}

	
}







