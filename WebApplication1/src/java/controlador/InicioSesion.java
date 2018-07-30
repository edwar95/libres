/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author david
 */
@Named(value = "inicioSesion")
@RequestScoped
public class InicioSesion {

    private String nombre;
    private String  pssw;

    public String getPssw() {
        return pssw;
    }

    public void setPssw(String pssw) {
        this.pssw = pssw;
    }


    /**
     * Creates a new instance of InicioSesion
     */
    public InicioSesion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
