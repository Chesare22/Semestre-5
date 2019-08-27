package store;

import dataModels.Student;
import dataModels.Subject;
import dataModels.Teacher;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Store {
    private static final Store store = new Store();
    private Teacher[] teachers = null;
    private Student[] students = null;
    private Subject[] subjects = null;
    private final HashMap<Subject, Teacher> subjectsWithTeacher = new HashMap<>();
    private final HashMap<Student, Set<Subject>> studentsWithSubject = new HashMap<>();
    
    private Store(){}
    public static Store getStore(){return store;}
    
    public void setStudents(Student[] students){this.students = students;}
    public void setTeachers(Teacher[] teachers){this.teachers = teachers;}
    public void setSubjects(Subject[] subjects){this.subjects = subjects;}
    public Teacher[] teachers(){return teachers;}
    public Student[] students(){return students;}
    public Subject[] allSubjects(){return subjects;}
    public Set<Subject> aviableSubjects(){
        return subjectsWithTeacher.keySet();
    }
    
    public void boundSubjectWithTeacher(Subject subject, Teacher teacher){
        subjectsWithTeacher.put(subject, teacher);
    }
    public void boundStudentWithSubject(Student student, Subject subject){
        if(!studentsWithSubject.containsKey(student))
            studentsWithSubject.put(student, new HashSet<>());
        studentsWithSubject.get(student).add(subject);
    }
    public void unboundStudentWithSubject(Student student, Subject subject){
        if(studentsWithSubject.containsKey(student)){
            Set<Subject> subjectSet = studentsWithSubject.get(student);
            subjectSet.remove(subject);
            // Se quita al estudiante de la lista si no tiene materias cargadas
            if(subjectSet.isEmpty())
                studentsWithSubject.remove(student);
        }
    }
    public Map<Student, Set<Subject>> getStudentsWithSubject(){
        return (Map<Student, Set<Subject>>) studentsWithSubject.clone();
    }
    public Map<Subject, Teacher> getSubjectsWithTeacher(){
        return (Map<Subject, Teacher>) subjectsWithTeacher.clone();
    }
    public boolean inputDataIsReady(){
        return  teachers != null &&
                students != null &&
                subjects != null;
    }
    public boolean studentsLoaded(){return students != null;}
    public boolean teachersLoaded(){return teachers != null;}
    public boolean subjectsLoaded(){return subjects != null;}
    public boolean hasTeacher(Subject subject){
        return aviableSubjects().contains(subject);
    }
}
