import java.util.ArrayList;
import java.util.List;

// Es el mapa donde estan los animales
public class Isla {
    private List<Animal>[][] mapa;
    private int filas;
    private int columnas;

    @SuppressWarnings("unchecked")
    public Isla(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        mapa = new List[filas][columnas];

        // Hacer listas vacias
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mapa[i][j] = new ArrayList<>();
            }
        }
    }

    public List<Animal>[][] getMapa() {
        return mapa;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}