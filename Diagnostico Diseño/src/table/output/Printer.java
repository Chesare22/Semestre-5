package table.output;

import dataModels.Student;
import dataModels.Subject;
import dataModels.Teacher;
import java.nio.file.FileAlreadyExistsException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import store.Store;

public class Printer {
    private final Store store = Store.getStore();
    
    public void printStudentSubjects(String path) throws FileAlreadyExistsException{
        Map<Student, Set<Subject>> studentsWithSubject = store.getStudentsWithSubject();
        LinkedList<String[]> list = new LinkedList<>();
        studentsWithSubject.forEach((Student student, Set<Subject> subjects) -> {
            subjects.forEach((Subject subject)->{
                String[] str = new String[student.expectedColumns()+subject.expectedColumns()];
                System.arraycopy(student.toArray(), 0, str, 0, student.expectedColumns());
                System.arraycopy(subject.toArray(), 0, str, student.expectedColumns(), subject.expectedColumns());
                list.add(str);
            });
        });
        // Set header
        String[] studentHeader = new Student().header();
        String[] subjectHeader = new Subject().header();
        String[] header = new String[studentHeader.length + subjectHeader.length];
        System.arraycopy(studentHeader, 0, header, 0, studentHeader.length);//copy array of students
        System.arraycopy(subjectHeader, 0, header, studentHeader.length, subjectHeader.length);
        TableWriter writer = WriterFactory.getWriter();
        writer.setHeader(header);
        
        writer.write(list.toArray(new String[list.size()][]), path);
    }
    public void printTeacherSubjects(String path) throws FileAlreadyExistsException{
        Map<Subject, Teacher> subjectsWithTeacher = store.getSubjectsWithTeacher();
        LinkedList<String[]> list = new LinkedList<>();
        subjectsWithTeacher.forEach((Subject subject, Teacher teacher) ->{
            String[] str = new String[teacher.expectedColumns()+subject.expectedColumns()];
                System.arraycopy(teacher.toArray(), 0, str, 0, teacher.expectedColumns());//copy array of students
                System.arraycopy(subject.toArray(), 0, str, teacher.expectedColumns(), subject.expectedColumns());//copy array of students
            list.add(str);
        });
        // Set header
        String[] teacherHeader = new Teacher().header();
        String[] subjectHeader = new Subject().header();
        String[] header = new String[teacherHeader.length + subjectHeader.length];
        System.arraycopy(teacherHeader, 0, header, 0, teacherHeader.length);
        System.arraycopy(subjectHeader, 0, header, teacherHeader.length, subjectHeader.length);
        TableWriter writer = WriterFactory.getWriter();
        writer.setHeader(header);
        
        writer.write(list.toArray(new String[list.size()][]), path);
    }
}
