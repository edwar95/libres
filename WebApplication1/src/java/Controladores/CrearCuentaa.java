package Controladores;

import enviomail.javamail.Mail;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gonzalo
 */
@ManagedBean
@RequestScoped
public class CrearCuentaa {

    String nombre;
    String apellido;
    String cedula;
    String correo;
    String Password;
    String confPassword;
    conexion.Conectar conectar=new conexion.Conectar();
    String validarConrreo;
    String validarContrasenia;

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
    public void InsertarUsuario()
    {
    
    conectar.EjecutarSQL("Insert into artesano(nombre,apellido,correo,password1,confPassword)values("+nombre+","+apellido+","+correo+","+Password+","+confPassword);
    }
    public void comprobarCuenta(String x)
    {
     ResultSet consulta=conectar.Consulta("select *from artesano a where a.nombre='"+nombre+"'"+"&& a.password1='"+Password+"'");
       try{
            while(consulta.next()){
                validarConrreo=consulta.getString(4);
                validarContrasenia=consulta.getString(5);
                System.out.println(validarConrreo);
                 
            }    
        }catch(SQLException e){   
            System.out.println("hay error en el while");
        }  
    }
}
