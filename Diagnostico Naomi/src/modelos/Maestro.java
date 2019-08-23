package modelos;

/**
 *
 * @author Naomi
 */
public class Maestro extends Persona{
    
    private String claveEmployee;

    public Maestro(String claveEmployee, String name, String apellidoP, String apellidoM) {
        super(name, apellidoP, apellidoM);
        this.claveEmployee = claveEmployee;
    }

    public String getClaveEmployee() {
        return claveEmployee;
    }

    public void setClaveEmployee(String claveEmployee) {
        this.claveEmployee = claveEmployee;
    }
    
}
