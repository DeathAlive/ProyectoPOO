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
    
        //Info per
        private String nombreYapellido;
        private int cedula;
        private String contrasena;
        
        //Dinero
        private double capital;
        private double capitalGastosBasicos;
        private double capitalGastosPer;
        private double capitalGastosAh;
    
    public Usuario(int cedula, int capital) {
        this.cedula = cedula;
        this.capital = capital;
        capitalGastosBasicos = capital*0.5;
        capitalGastosPer=capital*0.3;
        capitalGastosAh=capital*0.2;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }
    
    public double getCapital() {
        return capital;
    }

    public double getCapitalGastosBasicos() {
        return capitalGastosBasicos;
    }

    public void setCapitalGastosBasicos(double capitalGastosBasicos) {
        this.capitalGastosBasicos = capitalGastosBasicos;
    }

    public double getCapitalGastosPer() {
        return capitalGastosPer;
    }

    public void setCapitalGastosPer(double capitalGastosPer) {
        this.capitalGastosPer = capitalGastosPer;
    }

    public double getCapitalGastosAh() {
        return capitalGastosAh;
    }

    public void setCapitalGastosAh(double capitalGastosAh) {
        this.capitalGastosAh = capitalGastosAh;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreYapellido=" + nombreYapellido + ", cedula=" + cedula + ", contrasena=" + contrasena + ", capital=" + capital + ", capitalGastosBasicos=" + capitalGastosBasicos + ", capitalGastosPer=" + capitalGastosPer + ", capitalGastosAh=" + capitalGastosAh + '}';
    }
    
    
    
    
}
