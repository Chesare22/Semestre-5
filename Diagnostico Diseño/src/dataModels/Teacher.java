package dataModels;

public class Teacher extends DataModel{
    public String apellido1;
    public String apellido2;
    public String nombres;
    public String cve_empleado;
    /*
    El archivo de profesores tiene este orden:
    || Cve_Empleado || Apellido 1 || Apellido 2 || Nombres ||
    */
    public Teacher(){
        this.expectedColumns = 4;
    }
    public Teacher(String[] data){
        this();
        this.readFromArray(data);
    }
    @Override
    public void readFromArray(String[] data){
        this.cve_empleado = data[0];
        this.apellido1 = data[1];
        this.apellido2 = data[2];
        this.nombres = data[3];
    }
    @Override
    public String[] toArray(){
        String[] data = new String[4];
        data[0] = this.cve_empleado;
        data[1] = this.apellido1;
        data[2] = this.apellido2;
        data[3] = this.nombres;
        return data;
    }
    @Override
    public String toString(){
        return nombres + " " + apellido1 + " " + apellido2;
    }
}
