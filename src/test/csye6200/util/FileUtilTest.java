package test.csye6200.util;


import com.google.common.collect.Lists;
import csye6200.constants.Constants;
import csye6200.util.FileUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
* FileUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>10/05/2018</pre> 
* @version 1.0 
*/ 
public class FileUtilTest extends TestCase {
public FileUtilTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: isFileWriting(String fileName) 
* 
*/
@Test
public void testIsFileWriting() throws Exception { 
//TODO: Test goes here... .


}

/** 
* 
* Method: writeToFile(String fileName, List<String> contents) 
* 
*/ 
public void testWriteToFile() throws Exception { 
//TODO: Test goes here...
    List<String> list = Lists.newArrayList();
    for(int i=0;i<20;i++){
        list.add("qq,[1.2.3],[4.5.6],ddd,1");
        list.add("sds,[],[],ccc,2");
    }
    for(int i = 0;i<10;i++){
        FileUtil.writeToFile("test.csv",list);

    }

} 

/** 
* 
* Method: readContents(String fileName) 
* 
*/ 
public void testReadContents() throws Exception { 
//TODO: Test goes here...
    List<String> list = FileUtil.readContents(Constants.TEACHER_FILE_NAME);
    System.out.println(Arrays.toString(list.toArray()));

} 


/** 
* 
* Method: init() 
* 
*/ 
public void testInit() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FileUtil.getClass().getMethod("init"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: addFlag(String fileName) 
* 
*/ 
public void testAddFlag() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FileUtil.getClass().getMethod("addFlag", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 



} 
