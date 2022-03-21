package edu.umb.cs680.hw04;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class FileCachingTest {

    private String[] convertMapToArray(HashMap<String, String> map){
        String[] result = new String[map.size()];
        int i = 0;
        for(Map.Entry<String, String> entry : map.entrySet()){
            result[i++] = entry.getValue();
        }
        return result;
    }


    @Test
    public void FIFOFileCacheTest(){
        FIFOFileCache fileCache = new FIFOFileCache();
        String[] targetFiles = new String[]{"T1", "T2", "T3", "T1", "T4", "T2", "T5"};
         for(int i = 0;i < targetFiles.length; i++) {
            fileCache.fetchTarget(targetFiles[i]);
        }
        
        String[] actual = hashmapToStringArray(fileCache.cache);
        String[] expected = new String[]{"T2", "T3", "T4", "T5"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LRUFileCacheTest(){
        LFUFileCache fileCache = new LFUFileCache();
        String[] targetFiles = new String[]{"T1", "T2", "T3", "T4", "T5", "T6", "T7"};
         for(int i = 0;i < targetFiles.length; i++) {
            fileCache.fetchTarget(targetFiles[i]);
        }
        String[] actual = hashmapToStringArray(fileCache.cache);
        String[] expected = new String[]{"T1", "T2", "T4", "T5"};
        Assertions.assertArrayEquals(expected, actual);
    }
}

