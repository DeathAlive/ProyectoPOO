/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Deavi
 */
public class Principal {

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            Acciones accion = new Acciones();
            String opcion = JOptionPane.showInputDialog(
                    "----- MENÚ PRINCIPAL -----\n"
                    + "1. Registrarse\n"
                    + "2. Iniciar sesión\n"
                    + "3. Salir\n"
                    + "Ingrese una opción:"
            );

            switch (opcion) {
                case "1":
                    accion.registrarUsuario();
                    salir = true;
                    break;
                case "2":
                    Usuario user = (Usuario) accion.iniciarUsuario();
                    if (user != null) {
                        String contra = JOptionPane.showInputDialog("Ingrese la contraseña");
                        if (contra.equals(user.getContrasena())) {
                            finanzas fn = new finanzas(
                                    user.getCapital(),
                                    user.getCapitalGastosBasicos(),
                                     user.getCapitalGastosPer(),
                                     user.getCapitalGastosAh());
                            accion.guardarObjeto(menuSesion(user, fn));
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                        }
                    }
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

        JOptionPane.showMessageDialog(null, "ADIOS");

    }

    public static Usuario menuSesion(Usuario user, finanzas fn) {
        boolean salir = false;

      
    while (!salir) {
        String opcion = JOptionPane.showInputDialog(
                "----- MENÚ DE SESIÓN -----\n"
                + "1. Ver info\n"
                + "2. Registrar ingreso o retiro\n"
                + "3. Retiro de emergencia\n"
                + "4. Predicciones financieras a futuro.\n"
                + "5. Establecer meta de dinero\n"
                + "6. Salir\n"
                + "Ingrese una opción:"
        );

        switch (opcion) {
            case "1":
                fn.infoFinanciera();
                break;
            case "2":
                double monto = Double.parseDouble(JOptionPane.showInputDialog("<h2>Ingrese la cantidad de transacción (números positivos para ingresar / números negativos para retirar):</h2> "));
                double[] datos = fn.registrarTransaccion(monto);
                if (datos != null) {
                    if (monto > 0) {
                        user.setCapital(datos[0]);
                        user.setCapitalGastosAh(datos[1]);
                        user.setCapitalGastosBasicos(datos[2]);
                        user.setCapitalGastosPer(datos[3]);
                    } else if (monto < 0) {
                        user.setCapital(datos[0]);
                        user.setCapitalGastosAh(datos[1]);
                        user.setCapitalGastosBasicos(datos[2]);
                        user.setCapitalGastosPer(datos[3]);
                    } else {
                        System.out.println("Error");
                    }
                }
                break;
            case "3":
                fn.retiroEmergencias(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar: ")));
                break;
            case "4":
                fn.aFuturo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su salario quincenal promedio: ")), Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántas quincenas a futuro desea ver: ")));
                break;
            case "5":
                double metaDinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la meta de dinero: "));
                user.insertarMetaDinero(metaDinero);
                break;
            case "6":
                salir = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
        }

    }
    return user;
}
}
