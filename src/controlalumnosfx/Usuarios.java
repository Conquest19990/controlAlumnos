package controlalumnosfx;

public class Usuarios {
   private String username;
   private String password;
   private String instituto;
   private String nombre;
   private String apPaterno;
   private String apMaterno;
   private String Puesto;

    public Usuarios(String username, String password, String instituto, String nombre, String apPaterno, String apMaterno, String Puesto) {
        this.username = username;
        this.password = password;
        this.instituto = instituto;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.Puesto = Puesto;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getInstituto() {
        return instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public String getPuesto() {
        return Puesto;
    }
    
   
}
