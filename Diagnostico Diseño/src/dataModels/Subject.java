package dataModels;

public class Subject extends DataModel{
    private String cve_asignatura;
    private String nombre;
    private String licenciatura;
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
    @Override
    public String toString(){
        return nombre + " - " + licenciatura;
    }
    // Getters
    public String cve_asignatura(){return cve_asignatura;}
    public String nombre(){return nombre;}
    public String licenciatura(){return licenciatura;}
}
