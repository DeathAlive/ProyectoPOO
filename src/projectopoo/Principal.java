/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectopoo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Migue
 */
public class Principal {

  
        private static List<Usuario> usuariosRegistrados = new ArrayList<>();

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
                    break;
                case "2":
                    Usuario user = (Usuario) accion.iniciarUsuario();
                    if(user!=null){
                        System.out.println(user.getCedula()+"\n"+user.getNombreYapellido());
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

    public static void menuSesion() {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "----- MENÚ DE SESIÓN -----\n"
                    + "1. DINERO QUE PUEDES GASTAR\n"
                    + "2.  PORCENTAJE  :) 2\n"
                    + "3. Cerrar sesión\n"
                    + "Ingrese una opción:"
            );

            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Opción 1 seleccionada");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Opción 2 seleccionada");
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Acaso vez que hay mas numeros pendejo?");
            }
        }
    }

  
}