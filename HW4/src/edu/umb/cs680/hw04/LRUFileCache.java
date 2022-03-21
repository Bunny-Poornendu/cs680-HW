package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LRUFileCache extends FileCache
{
	private List<Long> LRUCount;

	public LRUFileCache(){
		LRUCount = new ArrayList<>();
		cache = new LinkedHashMap<>();
	}

	@Override
	protected boolean isCached(Path path)
	{
		return cache.containsKey(path);
	}

	@Override
	protected boolean isCacheFull()
	{
		return cache.size() == 3;
	}

	@Override
	protected void cacheFile(Path path)
	{
		try{
			String content = new String(Files.readAllBytes(path));
			cache.put(path,content);
			LRUCount.add(System.currentTimeMillis());
		}catch (IOException exception){
			exception.printStackTrace();
		}
	}

	@Override
	protected void replace(Path path)
	{
		int rmvIndex = LRUCount.indexOf(Collections.min(LRUCount));
		LRUCount.remove(rmvIdx);
		cache.remove(cache.keySet().toArray()[rmvIdx]);
		try{
			String content = new String(Files.readAllBytes(path));
			cache.put(path,content);
			LRUCount.add(System.currentTimeMillis());
		}catch (IOException exception){
			exception.printStackTrace();
		}
	}

	@Override
	protected String getFileFromCache(Path path)
	{
		String content = cache.get(path);
		ArrayList<String> contents = new ArrayList<String>(cache.values());
		int updateIndex = contents.indexOf(content);
		LRUCount.remove(updateIndex);
		LRUCount.add(updateIndex, System.currentTimeMillis());
		return content;
	}
}
