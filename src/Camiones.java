import java.io.Serializable;
import java.util.Objects;

public class Camiones implements Serializable {
    private final String marcaCamiones;
    private final double capacidadCisterna;

    @Override
    public String toString() {
        return "Camiones{" +
                "marcaCamiones='" + marcaCamiones + '\'' +
                ", capacidadCisterna=" + capacidadCisterna +
                '}';
    }

    public String getMarcaCamiones() {
        return marcaCamiones;
    }

    public double getCapacidadCisterna() {
        return capacidadCisterna;
    }

    public Camiones(String marcaCamiones, double capacidadCisterna) {
        this.marcaCamiones = marcaCamiones;
        this.capacidadCisterna = capacidadCisterna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camiones camiones = (Camiones) o;
        return Double.compare(camiones.capacidadCisterna, capacidadCisterna) == 0 &&
                Objects.equals(marcaCamiones, camiones.marcaCamiones);
    }


    @Override
    public int hashCode() {
        return Objects.hash(marcaCamiones, capacidadCisterna);
    }

    public String info(){
        return marcaCamiones + " con capacidad: " + capacidadCisterna;
    }
}
