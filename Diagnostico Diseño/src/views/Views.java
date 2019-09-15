package views;

import dataModels.Student;
import dataModels.Subject;
import dataModels.Teacher;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;
import store.Store;

public class Views {
    private final Store store = Store.getStore();
    private final Scanner reader = new Scanner(System.in);
    private String commandInput;
    //private final Input fileInput = new Input();
    
    public Views(){
        System.out.println("Bienvenido a la carga de maestros, alumnos y materias."
                + "Primero vamos a cargar los datos."
                + "Luego decimos que maestros van a dar que materia."
                + "Luego hacemos que cada estudiante cargue las materias que quiera."
                + "Y por ultimo generamos los archivos con esas relaciones.");
        inputView();
        System.out.println("Chaito, buen dia :3");
    }
    
    public void inputView(){
        do{
            if(!store.studentsLoaded()){
                System.out.println("Ingrese el nombre del archivo con los estudiantes");
                commandInput = reader.nextLine();
                if(store.loadStudents(commandInput)){
                    System.out.println("Se guardaron los estudiantes");
                }else{
                    System.out.println("No se guardaron los estudiantes");
                }
            }
            if(!store.teachersLoaded()){
                System.out.println("Ingrese el nombre del archivo con los maestros");
                commandInput = reader.nextLine();
                if(store.loadTeachers(commandInput)){
                    System.out.println("Se guardaron los maestros");
                }else{
                    System.out.println("No se guardaron los maestros");
                }
            }
            if(!store.subjectsLoaded()){
                System.out.println("Ingrese el nombre del archivo con las materias");
                commandInput = reader.nextLine();
                if(store.loadSubjects(commandInput)){
                    System.out.println("Se guardaron las materias");
                }else{
                    System.out.println("No se guardaron las materias");
                }
            }
        }while(!store.inputDataIsReady());
        subjectsWithTeachers();
    }
    public void subjectsWithTeachers(){
        boolean keepAsking = true;
        while(keepAsking){
            for(Subject subject : store.allSubjects()){
                if(!store.hasTeacher(subject)){
                    for(Teacher teacher : store.teachers()){
                        System.out.println("Desea que la materia " + subject.nombre()
                            + " tenga como maestro a " + teacher.fullName() + "?");
                        if(yes()){
                            store.boundSubjectWithTeacher(subject, teacher);
                            break;
                        }
                    }
                }
            }
            System.out.println("Desea ingresar mas datos?(S/N)");
            if(!yes())
                keepAsking = false;
        }
        studentsWithSubjects();
    }
    public void studentsWithSubjects(){
        boolean keepAsking = true;
        while(keepAsking){
            for(Student student : store.students()){
                for(Subject subject : store.aviableSubjects()){
                    System.out.println("Desea que el alumno " + student.fullName()
                        + " tome la materia de " + subject.nombre() + "?");
                    if(yes())
                        store.boundStudentWithSubject(student, subject);
                }
            }
            System.out.println("Desea ingresar mas datos?(S/N)"
                    + "Se va a guardar el avance en un archivo si dice que no.");
            if(!yes())
                keepAsking = false;
        }
        save();
    }
    public void save(){
        boolean fail;
        do{
            System.out.println("Ingrese el nombre del archivo que tendra a los alumnos con sus materias");
            commandInput = reader.nextLine();
            try {
                store.printStudentSubjects(commandInput);
                fail = false;
                System.out.println("Success!");
            } catch (FileAlreadyExistsException ex) {
                System.out.println("Este archivo ya existe");
                fail = true;
            }
        }while(fail);
        
        do{
            System.out.println("Ingrese el nombre del archivo que tendra a las materias con su profesor");
            commandInput = reader.nextLine();
            try {
                store.printTeacherSubjects(commandInput);
                fail = false;
                System.out.println("Success!");
            } catch (FileAlreadyExistsException ex) {
                System.out.println("Este archivo ya existe");
                fail = true;
            }
        }while(fail);
    }
    public boolean yes(){
        String str;
        while(true){
            str = reader.nextLine();
            if(str.equals("S")) return true;
            if(str.equals("N")) return false;
            System.out.println("Favor de ingresar S o N");
        }
    }
    public static void main(String[] arguments){
        new Views();
    }
}
