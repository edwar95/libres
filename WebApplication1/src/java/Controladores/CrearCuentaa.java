package Controladores;

import enviomail.javamail.Mail;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Gonzalo
 */
@Named(value = "crearCuentaa")
@RequestScoped
public class CrearCuentaa {

    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String Password;
    private String confPassword;
   

    public CrearCuentaa() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        System.out.println("EL valor de cedula es :" + cedula);
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
        
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public void EnviarMail() {
        Mail mail = new Mail();
        mail.sendEmail(correo, "Acceso al sistema", "Usuario: " + nombre + "\nPassword: " + Password);

    }
    
}
