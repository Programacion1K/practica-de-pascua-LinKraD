import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelCamion extends JPanel {
    private Camiones camion;
    JTextField marca=new JTextField(20);
    JTextField capacidad=new JTextField(20);

    public PanelCamion(){
        this.camion=new Camiones("",0.0);
        setLayout(new GridLayout(2,2));
        add(new JLabel("Marca: "));
        add(marca);
        add(new JLabel("Capacidad: "));
        add(capacidad);
    }

    public Camiones getCamion(){
        Camiones c=null;
        try{
            c=new Camiones(marca.getText(),Double.parseDouble(capacidad.getText()));
            return c;
        }
        catch (Exception e){
            return null;
        }
    }
}
