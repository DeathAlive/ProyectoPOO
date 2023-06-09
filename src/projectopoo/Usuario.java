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
    private double metaDinero;

    public Usuario(int cedula, int capital) {
        this.cedula = cedula;
        this.capital = capital;
        capitalGastosBasicos = capital * 0.5;
        capitalGastosPer = capital * 0.3;
        capitalGastosAh = capital * 0.2;
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

    public double getMetaDinero() {
        return metaDinero;
    }

    public void insertarMetaDinero(double metaDinero) {
        this.metaDinero = metaDinero;
    }

    public void verificarMetaDinero(double cantidadIngresada) {

        double dineroFaltante = metaDinero - (capital + cantidadIngresada);

        if (dineroFaltante > 0) {
            System.out.println("Te faltan $" + dineroFaltante + " para alcanzar tu meta de dinero.");
        } else if (dineroFaltante < 0) {
            System.out.println("¡Felicidades! Has alcanzado tu meta de dinero.");
            metaDinero = 0;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreYapellido=" + nombreYapellido + ", cedula=" + cedula + ", contrasena=" + contrasena + ", capital=" + capital + ", capitalGastosBasicos=" + capitalGastosBasicos + ", capitalGastosPer=" + capitalGastosPer + ", capitalGastosAh=" + capitalGastosAh + '}';
    }

}
