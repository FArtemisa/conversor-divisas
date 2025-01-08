package alura.challenge.fer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal {
    public static void main(String[] args) {
        ConvertirMonedas monedas = new ConvertirMonedas();
        String[] opcionesMoneda = {"MXN", "COP", "JPY", "USD", "EUR", "KRW"};
        String monedaOrigen = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de origen",
                "Moneda de origen", JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

        if (monedaOrigen != null){
            String input = mostrarInputDialogNumerico("Ingrese un valor en " + monedaOrigen + " a convertir");

            if (input != null && !input.isEmpty()){
                try {
                    double valorRecibido = Double.parseDouble(input);
                    String monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda de destino",
                            "Moneda de destino", JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

                    if (monedaDestino != null){
                        monedas.convertirMonedas(valorRecibido, monedaOrigen, monedaDestino);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se seleccionó una moneda de destino", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha ingresado un valor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una moneda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String mostrarInputDialogNumerico(String mensaje) {
        NumericTextField textField = new NumericTextField();

        Object[] inputFields = {mensaje, textField};
        int option = JOptionPane.showConfirmDialog(null, inputFields, "Entrada numérica", JOptionPane.OK_CANCEL_OPTION);

        return option == JOptionPane.OK_OPTION ? textField.getText() : null;
    }

}
