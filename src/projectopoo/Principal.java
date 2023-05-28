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
        RegistrarUsuario rU = new RegistrarUsuario();

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "----- MENÚ PRINCIPAL -----\n"
                    + "1. Registrarse\n"
                    + "2. Iniciar sesión\n"
                    + "3. Salir\n"
                    + "Ingrese una opción:"
            );

            switch (opcion) {
                case "1":
                    registrar();
                    break;
                case "2":
                    boolean sesionIniciada = iniciarSesion();
                    if (sesionIniciada) {
                        menuSesion();
                    } else {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Volviendo al menú principal.");
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

    public static void registrar() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese un nombre de usuario:");

    // Validar si el nombre de usuario ya existe
    boolean usuarioExistente = false;
    for (Usuario usuario : usuariosRegistrados) {
        if (usuario.getNombreYapellido().equals(nombreUsuario)) {
            usuarioExistente = true;
            break;
        }
    }

    if (usuarioExistente) {
        JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado. Por favor, ingrese un nombre de usuario diferente.");
    } else {
        String contrasena = JOptionPane.showInputDialog("Ingrese una contraseña:");

        Usuario usuario = new Usuario(nombreUsuario, contrasena);
        usuariosRegistrados.add(usuario);

        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    }
}
    public static boolean iniciarSesion() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombreYapellido().equals(nombreUsuario) && usuario.getContraseña().equals(contrasena)) {
                return true;
            }
        }

        return false;
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