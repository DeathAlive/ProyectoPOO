package projectopoo;

import java.io.*;
import javax.swing.JOptionPane;

public class Acciones {
    
    public finanzas accion;

    public void registrarUsuario() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: "));
        try {
            if (leerObjeto(cedula) == null) {
                Usuario nuevoUsuario = new Usuario(cedula, Integer.parseInt(JOptionPane.showInputDialog("Ingrese su capital actual (en pesos): ")));
                nuevoUsuario.setNombreYapellido(JOptionPane.showInputDialog("Ingrese su nombre y apellido: "));
                nuevoUsuario.setContrasena(JOptionPane.showInputDialog("Ingrese la contraseña a registrar: "));
                escribirObjeto(nuevoUsuario, cedula);
                System.out.println(nuevoUsuario.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ya existente! Por favor inicie sesion.");
            }
        } catch (NumberFormatException e) {
            // Manejo de excepción si el valor ingresado no es un número válido
        }
    }

    public Object iniciarUsuario() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula: "));
        Object user = leerObjeto(cedula);
        if (user != null) {
            return user;
        } else {
            System.out.println("Inicio de sesion fallido");
            return null;
        }
    }

    private boolean escribirObjeto(Object objAEscribir, int cedula) {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(new FileOutputStream(".\\cuentas\\" + cedula + ".dat"))) {
            objetoOut.writeObject(objAEscribir);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public void guardarObjeto(Usuario user){
        escribirObjeto(user, user.getCedula());
    }

    private Object leerObjeto(int cedula) {
        try (ObjectInputStream objetoIn = new ObjectInputStream(new FileInputStream(".\\cuentas\\" + cedula + ".dat"))) {
            return objetoIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Manejo de excepción si no se encuentra el archivo o no se puede leer
        }
        return null;
    }
}
