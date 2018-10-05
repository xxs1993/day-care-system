/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.util;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import csye6200.exception.DatabaseException;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Administrator
 */
public class FileUtil {
    private static ConcurrentMap<String,Integer> flagMap = null;

    private static void init(){
        if(flagMap == null){
            flagMap = Maps.newConcurrentMap();
        }
    }

    private static void addFlag(String fileName){
        flagMap.put(fileName,1);
    }
    
    public static boolean isFileWriting(String fileName){
        init();
        if( Strings.isNullOrEmpty(fileName)){
            return false;
        }
        return flagMap.get(fileName)!=null && flagMap.get(fileName)==1;
    }



    /**
     * write content to file
     * @param fileName
     * @param contents
     * @throws DatabaseException
     */
    public static void writeToFile(String fileName,List<String> contents) throws DatabaseException{
        if(isFileWriting(fileName)){
            throw new DatabaseException(String.format("%s is in use",fileName));
        }
        addFlag(fileName);
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
            for (String content : contents) {
                bf.write(content);
                bf.newLine();
            }
        }catch (FileNotFoundException f){
            throw new DatabaseException(String.format("%s missed",fileName));
        }catch (IOException e){
            throw new DatabaseException("Unexpected Error");
        }
    }

    public static List<String>  readContents(String fileName) throws DatabaseException{
        if(isFileWriting(fileName)){
            throw new DatabaseException(String.format("%s is in use",fileName));
        }
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
