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
//    assign student to different groups of teachers based on student's age
//    get database of teachers teaching that age  
//    assign student to the first teacher of database that satisfied the ratio
//    teacher's groupsize attribute value increases by one
private static int maxStuAmount(int ageRange) {
        int maxStuAmount=0;
    if (ageRange < 6)
        maxStuAmount = 0;
    else if (ageRange < 13)
            maxStuAmount = 4;
    else if (ageRange < 25)
            maxStuAmount = 5;
    else if (ageRange < 36)
            maxStuAmount = 6;
    else if (ageRange < 46)
            maxStuAmount = 8;
    else if (ageRange < 60)
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
private static int maxGroupAmount(int ageRange) {
        int maxGroupAmount;
    if (ageRange < 6)
        maxGroupAmount = 0;
    if (ageRange <= 47)
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
        map.put(Constants.MAX_GROUP_AMOUNT, maxGroupAmount(age));
        map.put(Constants.MAX_STUDENT_AMOUNT, maxStuAmount(age));
        return map;
    }

}
