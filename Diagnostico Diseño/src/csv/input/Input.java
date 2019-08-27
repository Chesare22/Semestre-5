package csv.input;

import dataModels.DataModel;
import dataModels.Student;
import dataModels.Teacher;
import dataModels.Subject;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import csv.GenericArrayCreator;
import store.Store;

public class Input {    
    private final TableReader reader = ReaderFactory.getReader();
    private final Store store = Store.getStore();
    
    //This is the important method
    public <Model extends DataModel> Model[] tableToModel(String path, Class<Model> cls)
                throws FileNotFoundException{
        try {
            Model model = cls.newInstance();
            String[][] arrayResponse = reader.read(path, model.expectedColumns());
            GenericArrayCreator<Model> creator = new GenericArrayCreator<>(cls);
            Model[] response = creator.create(arrayResponse.length);
            for(int i = 0;i<response.length;i++){
                model = cls.newInstance();
                model.readFromArray(arrayResponse[i]);
                response[i] = model;
            }
            return response;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean loadStudents(String path){
        Class<Student> cls = (Class<Student>) new Student().getClass();
        try {
            store.setStudents(tableToModel(path, cls));
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
    public boolean loadTeachers(String path){
        Class<Teacher> cls = (Class<Teacher>) new Teacher().getClass();
        try {
            store.setTeachers(tableToModel(path, cls));
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
    public boolean loadSubjects(String path){
        Class<Subject> cls = (Class<Subject>) new Subject().getClass();
        try {
            store.setSubjects(tableToModel(path, cls));
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
}
