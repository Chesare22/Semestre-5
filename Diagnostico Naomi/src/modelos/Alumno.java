package modelos;

/**
 *
 * @author Naomi
 */
public class Alumno extends Persona{
    
    private String matricula;
    private String licenciatura;
    private Asignatura[] listaMaterias;

    public Alumno(String matricula, String licenciatura, String name, String apellidoP, String apellidoM) {
        super(name, apellidoP, apellidoM);
        this.matricula = matricula;
        this.licenciatura = licenciatura;
    }

    public Asignatura[] getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(Asignatura[] listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }
        
}
