
import dataModels.Teacher;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myIO.input.Input;
import myIO.output.CSVWriter;

public class Test {
    public static void main(String[] args){
        testOutput();
    }
    public static void testInput(){
        String path = "C:\\Users\\PAPA\\Desktop\\Semestre actual\\TestData\\maestros.csv";
        Input input = new Input();
        try {
            Class<Teacher> cls = (Class<Teacher>) new Teacher().getClass();
            Teacher[] teachers = input.tableToModel(path, cls);
            for(Teacher teacher : teachers){
                System.out.println(teacher);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No encuentro el archivo u.u");
        }
    }
    public static void testOutput(){
        String[][] table = {
            {"11","12","13","14"},
            {"21","22","23","24"},
            {"31","32","33","34"},
            {"Testing","The values","with, commas", "hue"}
        };
        String name = "C:\\Users\\PAPA\\Desktop\\Semestre actual\\TestData\\Output.csv";
        CSVWriter writer = new CSVWriter();
        try {
            writer.write(table, name);
        } catch (FileAlreadyExistsException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
