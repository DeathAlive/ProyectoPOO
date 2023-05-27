package projectopoo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class RegistrarUsuario {
    
    public boolean registrarUsuario(){
        Usuario nuevoUsuario = new Usuario(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de cedula: ")));
        nuevoUsuario.setNombreYapellido(JOptionPane.showInputDialog("Ingrese su nombre y apellido: "));
        nuevoUsuario.setContraseña(JOptionPane.showInputDialog("Ingrese la contraseña a registrar: "));
        if (escribirObjeto(nuevoUsuario, nuevoUsuario.getCedula())) {
            return true;
        }
        return false;
    }
    
    private boolean escribirObjeto(Object objAEscribir, int cedula){
        try {
            FileOutputStream archivoOut = new FileOutputStream("./saves/"+cedula+".dat");
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);
            objetoOut.writeObject(objAEscribir);
            objetoOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
