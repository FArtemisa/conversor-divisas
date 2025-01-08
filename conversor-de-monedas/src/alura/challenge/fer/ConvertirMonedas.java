package alura.challenge.fer;

import javax.swing.*;

public class ConvertirMonedas {
    public void convertirMonedas(double valorRecibido, String monedaOrigen, String monedaDestino) {
        double tasaDeCambio = ExchangeRateAPI.obtenerTasaDeCambio(monedaOrigen, monedaDestino);
        mostrarResultado(valorRecibido, tasaDeCambio, monedaDestino);
    }

    private void mostrarResultado(double valorRecibido, double tasaDeCambio, String monedaDestino){
        if(tasaDeCambio != 0){
            double valorConvertido = valorRecibido * tasaDeCambio;
            valorConvertido = (double) Math.round(valorConvertido * 100d) / 100;
            JOptionPane.showMessageDialog(null, "Tienes: " + valorConvertido + " en " + monedaDestino);
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener la tasa de cambio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
