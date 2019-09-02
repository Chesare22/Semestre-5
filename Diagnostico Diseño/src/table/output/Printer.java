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
    private final TableWriter writer = WriterFactory.getWriter();
    private final Store store = Store.getStore();
    
    public void printStudentSubjects(String path) throws FileAlreadyExistsException{
        Map<Student, Set<Subject>> studentsWithSubject = store.getStudentsWithSubject();
        LinkedList<String[]> list = new LinkedList<>();
        studentsWithSubject.forEach((Student student, Set<Subject> subjects) -> {
            subjects.forEach((Subject subject)->{
                String[] str = {student.matricula(), subject.cve_asignatura()};
                list.add(str);
            });
        });
        writer.write(list.toArray(new String[list.size()][]), path);
    }
    public void printTeacherSubjects(String path) throws FileAlreadyExistsException{
        Map<Subject, Teacher> subjectsWithTeacher = store.getSubjectsWithTeacher();
        LinkedList<String[]> list = new LinkedList<>();
        subjectsWithTeacher.forEach((Subject subject, Teacher teacher) ->{
            String[] str = {subject.cve_asignatura(), teacher.cve_empleado()};
            list.add(str);
        });
        writer.write(list.toArray(new String[list.size()][]), path);
    }
}
