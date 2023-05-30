package projectopoo;

import java.awt.HeadlessException;
import java.io.*;
import javax.swing.JOptionPane;

public class Acciones {

    public void registrarUsuario() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: "));
        try {
            if (leerObjeto(cedula) == null) {
                Usuario nuevoUsuario = new Usuario(cedula, Integer.parseInt(JOptionPane.showInputDialog("Ingrese su capital actual (en pesos): ")));
                System.out.println(nuevoUsuario.toString());
                nuevoUsuario.setNombreYapellido(JOptionPane.showInputDialog("Ingrese su nombre y apellido: "));
                nuevoUsuario.setContrasena(JOptionPane.showInputDialog("Ingrese la contraseña a registrar: "));
                escribirObjeto(nuevoUsuario, cedula);
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ya existente! porfavor inicie sesion.");
            }
        } catch (HeadlessException e) {
        }

    }

    public Object iniciarUsuario() {
        Object user = leerObjeto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula: ")));
        if (user != null) {
            return user;
        } else {
            System.out.println("Inicio de sesion fallido");
            return null;
        }
    }

    private boolean escribirObjeto(Object objAEscribir, int cedula) {
        try {
            FileOutputStream archivoOut = new FileOutputStream(".\\cuentas\\"+cedula + ".dat");
            try (ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
                objetoOut.writeObject(objAEscribir);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public void guardarObjeto(Usuario user){
        escribirObjeto(user, user.getCedula());
    }

    private Object leerObjeto(int cedula) {
        try {
            FileInputStream archivoIn = new FileInputStream(".\\cuentas\\"+cedula + ".dat");
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);
            Object user = objetoIn.readObject();
            return user;
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }
}
