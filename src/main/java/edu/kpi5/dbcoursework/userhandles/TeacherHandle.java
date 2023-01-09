package edu.kpi5.dbcoursework.userhandles;

import edu.kpi5.dbcoursework.dbaccess.DBApi;
import edu.kpi5.dbcoursework.entities.coredb.*;
import edu.kpi5.dbcoursework.entities.marksdb.MarksList;
import edu.kpi5.dbcoursework.entities.userdb.User;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherHandle extends Handle {
    private Teacher teacher;
    public TeacherHandle(User user, DBApi object) {
        super(user);
        teacher = object.getTeacher(user.getLogin());
    }

    //UNREALIZED
//    public void setAttestation(String courseName, MarksList marksList, DBApi object) {
//        //потрібно знати за яким правилом виставлятиметься атестація, наприклад якщо більше 20 балів
//        //але за що? ключ в марксЛісті містить тільки назву роботи, тому ми будемо тільки враховуючи її
//        // виставляти атестацію ?
//        for(var pair : marksList.getList()){//отримуємо список пар учень - оцінка
//            if(pair.getValue() > 20){
//                object.setAttestation(courseName,pair.getKey());//треба додати метод до BDApi для виставлення атестації учню за ім'ям
//            }
//        }
//    }

    public void setMark(Long courseId, String markName, Long studentId, int mark, DBApi object) {
        //переписати, бо непевний чи правильно розташував ключі
        object.setMarks(courseId, markName,null);
    }//todo

    public void setMarks(Long courseId, String markName, Map<Long, Integer> marksList, DBApi object) {
        object.setMarks(courseId,markName, marksList);
    }

    public void setSocialWork(Long courseId, Long studentId, DBApi object) {
        object.setSocialWork(courseId, studentId);
    }

    public void setExam(Long courseId, Map<Long, Integer> marksList, DBApi object) {
        object.setMarks(courseId, "EXAM", marksList);
    }

    public void addCourse(String courseName, ArrayList<Long> groups,DBApi object) {
        Long courseId = object.addCourse(courseName);
        for (long id :
                groups) {
            object.addStudentsToCourse(courseId, id);
        }
    }

    public void editCourse(Course course, DBApi object) {
        object.editCourse(course);
    }

    public void removeCourse(Long courseId, DBApi object) {
        object.removeCourse(courseId);
    }

    public Course getCourse(Long courseId, DBApi object) {
        return object.getCourse(courseId);
    }

    public List<Student> getCourseStudents(Long course, DBApi object) {
        return object.getCourseStudents(course);
    }

    public List<Course> getCourseList(DBApi object) {
        return object.getCourseList(super.getUser());
    }
}
