/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author deavi
 */
public class finanzas {
    
    private double capital;
    private double capitalGastosBasicos;
    private double capitalGastosPer;
    private double capitalGastosAh;

    public finanzas(double capital, double capitalGastosBasicos, double capitalGastosPer, double capitalGastosAh) {
        this.capital = capital;
        this.capitalGastosBasicos = capitalGastosBasicos;
        this.capitalGastosPer = capitalGastosPer;
        this.capitalGastosAh = capitalGastosAh;
    }
    
    public void infoFinanciera(){
        JOptionPane.showMessageDialog(null, ""
                + "<html><h2>Informacion financiera</h2><ul style=\"font-size:14px\"><li><b>Capital: </b>"
                +capital+"</li><li><b>Para gastos basicos: </b>"
                +capitalGastosBasicos+"</li><li><b>Para gastos personales: </b>"
                +capitalGastosPer+"</li><li><b>Ahorrado: </b>"
                +capitalGastosAh+"</li></ul></html>");
    }
    
    public double[] registrarTransaccion(double monto){
        if(monto>0){
            System.out.println("Registrado");
            return transaccion(monto);
        } else if(monto<0){
            if(Math.abs(monto)>=capitalGastosBasicos){
                JOptionPane.showMessageDialog(null, "No DEBERIAS gastar la cantidad de dinero ingresada\nesta cantidad de dinero supera tus gastos basicos!");
                System.out.println("No registrado");
                return null;
            } else if(Math.abs(monto)>capitalGastosPer){
                JOptionPane.showMessageDialog(null, "Estas gastando mas de lo debido (gastos personales agotados)");
                System.out.println("No registrado");
                return null;
            } else{
                JOptionPane.showMessageDialog(null, "monto a gastar dentro del presupuesto!");
                transaccion(monto);
                System.out.println("Registrado!");
                return transaccion(monto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sin transaccion");
        }
        return null;
  }
    
public double[] transaccion(double monto){
        if(monto>0){
            capitalGastosAh+=monto*0.2;
            capitalGastosPer+=monto*0.3;
            capitalGastosBasicos+=monto*0.5;
            capital = capitalGastosAh + capitalGastosBasicos + capitalGastosPer;
            double[] a = {capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer};
            return a;
        } else if(monto<0){
            capitalGastosPer-=monto;
            capital-=capitalGastosPer;
            double[] a={capital,capitalGastosPer};
            return a;
        } else {
            double[] a={capital};
            return a;
        }
    }

    
}
