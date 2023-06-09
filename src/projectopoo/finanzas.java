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
    private double estadoMeta;

    public finanzas(double capital, double capitalGastosBasicos, double capitalGastosPer, double capitalGastosAh, double estadoMeta) {
        this.capital = capital;
        this.capitalGastosBasicos = capitalGastosBasicos;
        this.capitalGastosPer = capitalGastosPer;
        this.capitalGastosAh = capitalGastosAh;
        this.estadoMeta = estadoMeta;
    }

    public String infoFinanciera() {
        return "<html>"
                + "<head>"
                + "    <title>Información financiera</title>"
                + "</head>"
                + "<body>"
                + "    <h2>Información financiera</h2>"
                + "    <ul style=\"font-size:14px\">"
                + "        <li><b>Capital: </b>" + capital + "</li>"
                + "        <li><b>Para gastos básicos: </b>" + capitalGastosBasicos + "</li>"
                + "        <li><b>Para gastos personales: </b>" + capitalGastosPer + "</li>"
                + "        <li><b>Ahorrado: </b>" + capitalGastosAh + "</li>"
                + "        <li><b>Meta de dinero actual: </b>" + estadoMeta + "</li>"
                + "    </ul>"
                + "</body>"
                + "</html>";
    }

    public double[] registrarTransaccion(double monto) {
    if (monto > 0) {
        System.out.println("Registrado");
        return transaccion(monto);
    } else if (monto < 0) {
        if (Math.abs(monto) >= capitalGastosBasicos) {
            JOptionPane.showMessageDialog(null, "No DEBERIAS gastar la cantidad de dinero ingresada\nesta cantidad de dinero supera tus gastos basicos!");
            System.out.println("No registrado");
            return null;
        } else if (Math.abs(monto) >= capitalGastosPer) {
            JOptionPane.showMessageDialog(null, "Estas gastando mas de lo debido (gastos personales agotados)");
            System.out.println("No registrado");
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "monto a gastar dentro del presupuesto!");
            System.out.println("Registrado!");
            return transaccion(monto);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Sin transaccion");
        return null;
    }
}

    public double[] transaccion(double monto) {
        if (monto > 0) {
            capitalGastosAh += monto * 0.2;
            capitalGastosPer += monto * 0.3;
            capitalGastosBasicos += monto * 0.5;
            capital = capitalGastosAh + capitalGastosBasicos + capitalGastosPer;
            return new double[]{capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer, monto};
        } else if (monto < 0) {
            capitalGastosPer = Math.abs(capitalGastosPer - Math.abs(monto));
            capital = capitalGastosAh + capitalGastosBasicos + capitalGastosPer;
            return new double[]{capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer, monto};
        } else if ((-1 * monto) == capitalGastosPer) {
            return new double[]{capital - capitalGastosPer};
        } else {
            return new double[]{capital};
        }
    }

    public double[] retiroEmergencias(double monto) {
        if (Integer.parseInt(JOptionPane.showInputDialog("Esta "
                + "seguro de realizar su retiro de emergencia? "
                + "(esto significara perdidas grandes en el capital y posible "
                + "desbalance financiero)\n1.Si\n2.No\nEscriba una respuesta:"
                + "")) == 0) {
            System.out.println("Proceso no realizado");
            return null;
        } else {
            if (monto > capital) {
                JOptionPane.showMessageDialog(null, "No tienes capital suficiente!");
                return null;
            } else if (monto == capital) {
                if (Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                  Tras esta transaccion su capital sera 0, desea continuar?
                                                                  1.Si.
                                                                  2.No
                                                                  Escriba una respuesta:""")) == 0) {
                    System.out.println("Proceso no realizado");
                    return null;
                } else {
                    capital = capital - monto;
                    capitalGastosBasicos = capital * 0.5;
                    capitalGastosPer = capital * 0.3;
                    capitalGastosAh = capital * 0.2;
                    double[] a = {capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer, monto};
                    return a;
                }
            } else {
                if (Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                  Tras esta transaccion su capital sera """ + (capital - monto) + """
                                                                                                            , desea continuar?
                                                                  1.Si.
                                                                  2.No
                                                                  Escriba una respuesta:""")) == 0) {
                    System.out.println("Proceso no realizado");
                    return null;
                } else {
                    capital = capital - monto;
                    capitalGastosBasicos = capital * 0.5;
                    capitalGastosPer = capital * 0.3;
                    capitalGastosAh = capital * 0.2;
                    double[] a = {capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer, monto};
                    return a;
                }
            }
        }
    }

    public void aFuturo(double ingresos, int quincenas) {
        double capitalL = this.capital;
        double capitalGastosBasicosL;
        double capitalGastosPerL;
        double capitalGastosAhL;
        double monto = ingresos * quincenas;
        double[] a = transaccion(monto);
        capitalL = a[0];
        capitalGastosAhL = a[1];
        capitalGastosBasicosL = a[2];
        capitalGastosPerL = a[3];
        JOptionPane.showMessageDialog(null, ""
                + "<html><h2>Informacion financiera</h2><ul><li><b>Capital: </b>"
                + capitalL + "</li><li><b>Para gastos basicos: </b>"
                + capitalGastosBasicosL + "</li><li><b>Para gastos personales: </b>"
                + capitalGastosPerL + "</li><li><b>Ahorrado: </b>"
                + capitalGastosAhL + "</li></ul></html>");
    }
    
    public double[] pagoServicios(double monto){
        double capital = this.capital;
        if(monto<=capitalGastosBasicos){
            capitalGastosBasicos = Math.abs(capitalGastosBasicos - Math.abs(monto));
            capital = capitalGastosAh + capitalGastosBasicos + capitalGastosPer;
            return new double[]{capital, capitalGastosAh, capitalGastosBasicos, capitalGastosPer, monto};
        } else {
            JOptionPane.showMessageDialog(null, "No tienes dinero suficiente como para pagar los gastos basicos.");
            return new double[]{capital};
        }
    }

}
