/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.util;

/**
 *
 * @author ziyanzhu
 */
public class RegulationUtil {
//    assign student to different groups of teachers based on student's age
//    get database of teachers teaching that age  
//    assign student to the first teacher of database that satisfied the ratio
//    teacher's groupsize attribute value increases by one
    static int maxStuAmount(String ageRange){
        int maxStuAmount=0;
        if(ageRange=="6-12")
            maxStuAmount = 4;
        else if(ageRange=="13-24")
            maxStuAmount = 5;
        else if(ageRange=="25-35")
            maxStuAmount = 6;
        else if(ageRange=="36-47")
            maxStuAmount = 8;
        else if(ageRange=="48-59")
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
    static int maxGroupAmount(String ageRange){
        int maxGroupAmount;
        if(ageRange=="6-12"||ageRange=="13-24"||ageRange=="25-35"||ageRange=="36-47")
            maxGroupAmount = 3;
        else
            maxGroupAmount = 2;
        return maxGroupAmount;
            //pass parameter tid to Classroom.class
            //get database of classroom that matches teacher's group
            //get the first classroom that satisfies classroom.size+1<=maxSize
            //classroom.size+1, set connection attributes among stu&classroom&teacher
            
    }
}
