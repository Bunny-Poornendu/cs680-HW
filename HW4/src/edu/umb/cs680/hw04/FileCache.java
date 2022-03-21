package edu.umb.cs680.hw04;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public abstract class FileCache
{
	protected LinkedHashMap<Path,String> cache;

	public String fetch(Path path){
		if(isCached(path))
			return getFileFromCache(path);
		else
			if(isCacheFull()){
				replace(path);
				return getFileFromCache(path);
			}
			else{
				cacheFile(path);
				return getFileFromCache(path);
			}
	}

	protected abstract boolean isCached(Path path);

	protected abstract boolean isCacheFull();

	protected abstract void cacheFile(Path path);

	protected abstract void replace(Path path);

	protected abstract String getFileFromCache(Path path);

}
