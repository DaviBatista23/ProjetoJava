package MeuPacote;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ValidaCep {

    public static void buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            // JOptionPane.showMessageDialog(null, json);

            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");

            // JOptionPane.showMessageDialog(null, array);

            String logradouro = array[7];
            String bairro = array[15];
            String cidade = array[19];
            String uf = array[23];


            System.out.println(logradouro + " " + bairro + " " + cidade + " " + uf);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
