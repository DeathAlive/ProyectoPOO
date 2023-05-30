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
                    if(user!=null){
                        String contra = JOptionPane.showInputDialog("Ingrese la contraseña");
                        if(contra.equals(user.getContrasena())){
                            finanzas fn = new finanzas(
                                    user.getCapital(),
                                    user.getCapitalGastosBasicos()
                                    , user.getCapitalGastosPer()
                                    , user.getCapitalGastosAh());
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

    public static Usuario menuSesion(Usuario user,finanzas fn) {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "----- MENÚ DE SESIÓN -----\n"
                    + "1. DINERO QUE PUEDES GASTAR\n"
                    + "2.  PORCENTAJE  :) 2\n"
                    + "3. Ver info\n"
                    + "4. Salir.\n"        
                    + "Ingrese una opción:"
            );
            

            switch (opcion) {
                case "1":         
                    double monto = Double.parseDouble(JOptionPane.showInputDialog("<h2>Ingrese la cantidad de transaccion (numeros positivos para ingresar/numeros negativos para retirar):</h2> "));
                    double[] datos=fn.registrarTransaccion(monto);
                    if(monto>0){
                        user.setCapital(datos[0]);
                        user.setCapitalGastosAh(datos[1]);
                        user.setCapitalGastosBasicos(datos[2]);
                        user.setCapitalGastosPer(datos[3]);
                    } else if (monto<0){
                        user.setCapital(datos[0]);
                        user.setCapitalGastosPer(datos[1]);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Opción 2 seleccionada");
                    break;
                case "3":
                    fn.infoFinanciera();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Acaso vez que hay mas numeros pendejo?");
            }
            
        }
        return user;
    }

  
}