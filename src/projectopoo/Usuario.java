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
        private String contrasena;
        private boolean logged=false;

    public Usuario(int cedula) {
        this.cedula = cedula;
    }    

    public Usuario(String nombreYapellido, String contraseña) {
        this.nombreYapellido = nombreYapellido;
        this.contrasena = contraseña;
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
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

//    @Override
//    public String toString() {
//        return "Usuario{" + "nombreYapellido=" + nombreYapellido + ", cedula=" + cedula + ", contrasena=" + contrasena + ", logged=" + logged + '}';
//    }
    
}
