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
    static void assginStuToTeacher(int age){
        int ratio;
        if(age<6){
        //age not satisfied! Error!
        }else if(age>=6 && age <=12){
            ratio = 4;   
        }else if(age>12 && age <=24){
            ratio = 5;
        }else if(age>24 && age <=35){
            ratio = 6;
        }else if(age>35 && age <=47){
            ratio = 8;
        }else if(age>47 && age <=59){
            ratio = 12;
        }else{
            ratio = 15;
        }
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
    void assignTeacherToClassRoom(int age, int tid){
        int maxSize;
        if(age>=6 && age <= 37){
            maxSize = 3;
        }else{
            maxSize = 2;
            
        }
            //pass parameter tid to Classroom.class
            //get database of classroom that matches teacher's group
            //get the first classroom that satisfies classroom.size+1<=maxSize
            //classroom.size+1, set connection attributes among stu&classroom&teacher
    }
}
