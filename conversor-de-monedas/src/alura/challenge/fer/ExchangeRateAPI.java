package alura.challenge.fer;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateAPI {
    private static final String API_KEY = "151b662ae502da49e6376a49";

    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        double tasaDeCambio = 0;
        try {
            String endpoint = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;
            System.out.println("Endpoint: " + endpoint);
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String jsonResponse = response.toString();
                System.out.println("Respuesta JSON: " + jsonResponse);

                JsonObject json = JsonParser.parseString(jsonResponse).getAsJsonObject();

                if (json.has("conversion_rate")) {
                    tasaDeCambio = json.get("conversion_rate").getAsDouble();
                } else {
                    System.out.println("No se encontró la tasa en la respuesta");
                    JOptionPane.showMessageDialog(null, "No se encontró la tasa de cambio en la respuesta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Error en la conexión: " + connection.getResponseCode());
                JOptionPane.showMessageDialog(null, "Error en la conexión " + connection.getResponseCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasaDeCambio;
    }
}
