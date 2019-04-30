import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cisterna implements Utilizable{
    List<String> lista=new ArrayList<>();
    private String marcaCamiones;
    private double capacidadCisterna;

    public String muestraTodos() {
        String salida="";
        int contador=0;

        for (String s: lista) {
            salida+=s;
            if (contador%2==0){
                salida+=",";
            }
            else {
                salida+="\n";
            }
            contador++;
        }

        return salida;
    }

    public void leeDeFichero(File nombreLeer) {
        try {
            DataInputStream DIS=new DataInputStream(new FileInputStream(nombreLeer.getPath()));
            String[] leerFichero=DIS.readUTF().split("\n");
            for (String s: leerFichero) {
                lista.add(s);
            }
            DIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardaEnFichero(File nombreGuardar) {
        try {
           DataOutputStream DOS=new DataOutputStream(new FileOutputStream(nombreGuardar.getPath()));
            DOS.writeUTF(lista.stream().collect(Collectors.joining("\n")));
            DOS.close();
        } catch (FileNotFoundException fnfe){
          fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pideYAnyade() {
        try {
            marcaCamiones=JOptionPane.showInputDialog(null,"Escribe la marca del camión");
            capacidadCisterna= Double.parseDouble(JOptionPane.showInputDialog(null,"Introduzca la capacidad del camión"));
            lista.add(marcaCamiones);
            lista.add(Double.toString(capacidadCisterna));
        } catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

    }
}
