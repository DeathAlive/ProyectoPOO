/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectopoo;

import java.io.Serializable;

/**
 *
 * @author deavi
 */
public class Usuario implements Serializable {
        private String nombreYapellido;
        private int cedula;
        private String contraseña;

    public Usuario(int cedula) {
        this.cedula = cedula;
    }    
        
    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }   

    public int getCedula() {
        return cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
