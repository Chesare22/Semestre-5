
package modelos;

/**
 *
 * @author Naomi
 */
public class Persona {
    
    private String name;
    private String apellidoP;
    private String apellidoM;

    public Persona(String name, String apellidoP, String apellidoM) {
        this.name = name;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public String getName() {
        return name;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
          
}
