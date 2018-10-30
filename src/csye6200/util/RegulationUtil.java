/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.util;

import com.google.common.collect.Maps;
import csye6200.constants.Constants;

import java.util.Map;

/**
 *
 * @author ziyanzhu
 */
public class RegulationUtil {


    public static int getAgeRangeType(int ageRange){
        int type ;
        if (ageRange < 6)
            type = 0;
        else if (ageRange < 13)
            type = 1;
        else if (ageRange < 25)
            type = 2;
        else if (ageRange < 36)
            type = 3;
        else if (ageRange < 48)
            type = 4;
        else if (ageRange < 60)
            type = 5;
        else
            type = 6;
        return type;
    }
//    assign student to different groups of teachers based on student's age
//    get database of teachers teaching that age  
//    assign student to the first teacher of database that satisfied the ratio
//    teacher's groupsize attribute value increases by one
private static int maxStuAmount(int type) {
        int maxStuAmount;
    if (type == 0)
        maxStuAmount = 0;
    else if (type == 1)
            maxStuAmount = 4;
    else if (type == 2)
            maxStuAmount = 5;
    else if (type == 3)
            maxStuAmount = 6;
    else if (type == 4)
            maxStuAmount = 8;
    else if (type == 5)
            maxStuAmount = 12;
        else
            maxStuAmount = 15;
            return maxStuAmount;
        //TO DO
            //pass parameter age to Teacher.class
            //get database of teachers teaching those ages
            //get the first teacher that satisfies teacher.groupsize+1<=ratio
            //call assignTeacherToClassRoom(age, teacher.id)
    }
    
//    assign teacher to different groups of classrooms based on teacher's group
//    get database of classrooms belong to that group  
//    assign teacher to the first classroom of database that satisfied the ratio
//    classroom's groupsize attribute value increases by one
//    set connection between student&classroom, teacher&classroom
private static int maxGroupAmount(int type) {
        int maxGroupAmount;
    if (type == 0)
        maxGroupAmount = 0;
    else if (type <= 4)
            maxGroupAmount = 3;
        else
            maxGroupAmount = 2;
        return maxGroupAmount;
            //pass parameter tid to Classroom.class
            //get database of classroom that matches teacher's group
            //get the first classroom that satisfies classroom.size+1<=maxSize
            //classroom.size+1, set connection attributes among stu&classroom&teacher
    }

    public static Map<String, Integer> getRegulationMap(int age) {
        Map<String, Integer> map = Maps.newHashMap();
        int type = getAgeRangeType(age);
        map.put(Constants.MAX_GROUP_AMOUNT, maxGroupAmount(type));
        map.put(Constants.MAX_STUDENT_AMOUNT, maxStuAmount(type));
        return map;
    }

}
