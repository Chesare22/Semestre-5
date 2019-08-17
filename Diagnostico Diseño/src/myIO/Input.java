package myIO;

import dataModels.DataModel;
import dataModels.Student;
import dataModels.Teacher;
import dataModels.Subject;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Input {    
    private final TableReader reader = ReaderFactory.getReader();
    
    public Student[] students (String path) throws FileNotFoundException{
        Class<Student> cls = (Class<Student>) new Student().getClass();
        return tableToModel(path, cls);
    }
    public Teacher[] teachers (String path) throws FileNotFoundException{
        Class<Teacher> cls = (Class<Teacher>) new Teacher().getClass();
        return tableToModel(path, cls);
    }
    public Subject[] subjects (String path) throws FileNotFoundException{
        Class<Subject> cls = (Class<Subject>) new Subject().getClass();
        return tableToModel(path, cls);
    }
    
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
}
