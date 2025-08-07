public class Main {
    public static void main(String[] args) {
        // Creamos 5 filas y 5 columnas
        Isla isla = new Isla(5, 5);

        // Agregar los animales
        isla.getMapa()[0][0].add(new Lobo());
        isla.getMapa()[0][1].add(new Conejo());
        isla.getMapa()[1][1].add(new Zorro());
        isla.getMapa()[2][2].add(new Aguila());
        isla.getMapa()[3][3].add(new Cabra());
        isla.getMapa()[4][4].add(new Raton());

        // Crear un hilo de simulación
        Thread simulador = new Thread(new Simulacion(isla));
        simulador.start();
    }
}