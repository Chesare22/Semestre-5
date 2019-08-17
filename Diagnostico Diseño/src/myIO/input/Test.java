package myIO.input;

import dataModels.Teacher;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args){
        Input input = new Input();
        String path = "C:\\Users\\PAPA\\Desktop\\Semestre actual\\TestData\\maestros.csv";
        Teacher[] teachers;
        try {
            teachers = input.teachers(path);
            for(Teacher teacher : teachers){
                System.out.println(teacher);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            System.exit(0);
        }
        
    }
}
