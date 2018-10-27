/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.util;

import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import csye6200.exception.DatabaseException;

import java.io.*;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Administrator
 */
public class FileUtil {
//    private static ConcurrentMap<String,Integer> flagMap = null;

    private static Cache<String, List<String>> cache = CacheBuilder.newBuilder()
            .maximumSize(20)
            .build();


//
//    private static void init(){
//        if(flagMap == null){
//            flagMap = Maps.newConcurrentMap();
//        }
//    }
//
//    private static void addFlag(String fileName){
//        flagMap.put(fileName,1);
//    }
//
//    private static void removeFlag(String fileName){
//        flagMap.remove(fileName);
//    }
//
//    public static boolean isFileWriting(String fileName){
//        init();
//        if( Strings.isNullOrEmpty(fileName)){
//            return false;
//        }
//        return flagMap.get(fileName)!=null && flagMap.get(fileName)==1;
//    }



    /**
     * write content to file
     * @param fileName
     * @param contents
     * @throws DatabaseException
     */
    public static void writeToFile(String fileName,List<String> contents) throws DatabaseException{
        synchronized (fileName) {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
                for (String content : contents) {
                    bf.write(content);
                    bf.newLine();
                }
            } catch (FileNotFoundException f) {
                throw new DatabaseException(String.format("%s missed", fileName));
            } catch (IOException e) {
                throw new DatabaseException("Unexpected Error");
            }
            cache.put(fileName, contents);
        }
    }

    public static List<String>  readContents(final String fileName) throws DatabaseException{

        List<String> result = null;
        try {
             result =  cache.get(fileName,()->{
             return getContents(fileName);
            });
        }catch (ExecutionException e){
            e.printStackTrace();
            System.out.println("Error occurred when getting cache");
        }

      return result;
    }

    private static List<String>  getContents(String fileName) throws  DatabaseException{
            List<String> contents = Lists.newArrayList();
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String content ;
                while(( content = br.readLine())!=null){
                    contents.add(content);
                }
            }catch (FileNotFoundException f){
                throw new DatabaseException(String.format("%s missed",fileName));
            }catch (IOException e){
                throw new DatabaseException("Unexpected Error");
            }
            return contents;

    }
}
