package dataModels;

public class Subject extends DataModel{
    public String cve_asignatura;
    public String nombre;
    public String licenciatura;
    /*
    El archivo de materias tiene este orden:
    || Cve_Asig || Nombre || Licenciatura {LIS, LCC, LIC} ||
    */
    public Subject(){
        this.expectedColumns = 3;
    }
    public Subject(String[] data){
        this();
        this.readFromArray(data);
    }
    @Override
    public void readFromArray(String[] data){
        this.cve_asignatura = data[0];
        this.nombre = data[1];
        this.licenciatura = data[2];
    }
    @Override
    public String[] toArray(){
        String[] data = new String[3];
        data[0] = this.cve_asignatura;
        data[1] = this.nombre;
        data[2] = this.licenciatura;
        return data;
    }
}
