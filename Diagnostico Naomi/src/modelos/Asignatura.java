package modelos;

/**
 *
 * @author Naomi
 */
public class Asignatura {
    
    private String claveAsignatura;
    private String nombreAsignatura;
    private String licenciatura;
    private boolean haveTeacher;
    private Maestro educador;

    public Asignatura(String claveAsignatura, String nombreAsignatura, String carrera) {
        this.claveAsignatura = claveAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.licenciatura = carrera;
    }

    public String getClaveAsignatura() {
        return claveAsignatura;
    }

    public void setClaveAsignatura(String claveAsignatura) {
        this.claveAsignatura = claveAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public boolean isHaveTeacher() {
        return haveTeacher;
    }

    public void setHaveTeacher(boolean haveTeacher) {
        this.haveTeacher = haveTeacher;
    }

    public Maestro getEducador() {
        return educador;
    }

    public void setEducador(Maestro educador) {
        this.educador = educador;
    }
    
    
      
}
