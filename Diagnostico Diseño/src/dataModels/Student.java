package dataModels;

public class Student extends DataModel{
    public String matricula;
    public String licenciatura;
    public String apellido1;
    public String apellido2;
    public String nombres;
    /*
    El archivo de alumnos tiene este orden:
    || matrícula || Apellido1 || Apellido2 || Nombres || Licenciatura {LIS, LCC. LIC} ||
    */
    public Student(){
        this.expectedColumns = 5;
    }
    public Student(String[] data){
        this();
        this.readFromArray(data);
    }
    @Override
    public void readFromArray(String[] data){
        this.matricula = data[0];
        this.apellido1 = data[1];
        this.apellido2 = data[2];
        this.nombres = data[3];
        this.licenciatura = data[4];
    }
    @Override
    public String[] toArray(){
        String[] data = new String[5];
        data[0] = this.matricula;
        data[1] = this.apellido1;
        data[2] = this.apellido2;
        data[3] = this.nombres;
        data[4] = this.licenciatura;
        return data;
    }
    @Override
    public String toString(){
        return nombres + " " + apellido1 + " " + apellido2 + " - " + licenciatura;
    }
}
