package projectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author deavi
 */
public class Principal {

    private static Acciones accion;

    public static void main(String[] args) {
        accion = new Acciones();
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenuPrincipal() + 1;

            switch (opcion) {
                case 1:
                    accion.registrarUsuario();
//                    salir = true;
                    break;
                case 2:
                    Usuario user = (Usuario) accion.iniciarUsuario();
                    if (user != null) {
                        String contra = JOptionPane.showInputDialog("Ingrese la contraseña");
                        if (contra.equals(user.getContrasena())) {
                            finanzas fn = new finanzas(
                                    user.getCapital(),
                                    user.getCapitalGastosBasicos(),
                                    user.getCapitalGastosPer(),
                                    user.getCapitalGastosAh(),
                                    user.getMetaDinero());

                            menuSesion(user, fn);
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                        }
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

        JOptionPane.showMessageDialog(null, "Proceso terminado.");
    }

    public static int mostrarMenuPrincipal() {
        Object[] options = {"Registrarse", "Iniciar sesión", "Salir"};
        return JOptionPane.showOptionDialog(null,
                "MENÚ PRINCIPAL",
                "MENÚ PRINCIPAL",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[2]);
    }

    public static void menuSesion(Usuario user, finanzas fn) {
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenuSesion(fn) + 1;

            switch (opcion) {
                case 1:
                    double monto = Double.parseDouble(JOptionPane.showInputDialog(
                            "<html><h2>Ingrese la cantidad de transacción "
                            + "(números positivos para ingresar / "
                            + "números negativos para retirar):"
                            + "</h2></html> "));
                    double[] datos = fn.registrarTransaccion(monto);
                    if (datos != null) {
                        if (monto > 0) {
                            user.setCapital(datos[0]);
                            user.setCapitalGastosAh(datos[1]);
                            user.setCapitalGastosBasicos(datos[2]);
                            user.setCapitalGastosPer(datos[3]);
                            user.verificarMetaDinero(datos[4]);
                        } else if (monto < 0) {
                            user.setCapital(datos[0]);
                            user.setCapitalGastosAh(datos[1]);
                            user.setCapitalGastosBasicos(datos[2]);
                            user.setCapitalGastosPer(datos[3]);
                        } else {
                            System.out.println("Error");
                        }
                        accion.guardarObjeto(user);
                    }
                    break;
                case 2:
                    fn.pagoServicios(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar: ")));
                    accion.guardarObjeto(user);
                    break;
                case 3:
                    fn.retiroEmergencias(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar: ")));
                    accion.guardarObjeto(user);
                    break;
                case 4:
                    fn.aFuturo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su salario quincenal promedio: ")), Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántas quincenas a futuro desea ver: ")));
                    break;
                case 5:
                    double metaDinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la meta de dinero: "));
                    user.insertarMetaDinero(metaDinero);
                    accion.guardarObjeto(user);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }

    public static int mostrarMenuSesion(finanzas fn) {
        Object[] options = {
            "Registrar ingreso o retiro",
            "Retiro gastos basicos",
            "Retiro de emergencia",
            "Predicciones financieras a futuro",
            "Establecer meta de dinero",
            "Salir"
        };
        return JOptionPane.showOptionDialog(null,
                fn.infoFinanciera(),
                "MENÚ DE SESIÓN\n",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[5]);
    }
}
