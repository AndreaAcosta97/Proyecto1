import java.util.Random;

public abstract class Animal {

    // Caracteristicas que comparten estos animales
    protected String nombre;
    protected double peso;
    protected int velocidad; // cuántas casillas puede moverse
    protected double comidaNecesaria;
    protected boolean vivo = true;

    protected Random random = new Random();

    public Animal(String nombre, double peso, int velocidad, double comidaNecesaria) {
        this.nombre = nombre;
        this.peso = peso;
        this.velocidad = velocidad;
        this.comidaNecesaria = comidaNecesaria;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void morir() {
        vivo = false;
    }

    // Todos los animales van a comer
    public abstract void comer(Isla isla, int fila, int col);

    // Movimiento de cada uno
    public void mover(Isla isla, int fila, int col) {
        // Movemos -1, 0 o 1 posiciones
        int nuevaFila = fila + random.nextInt(3) - 1;
        int nuevaCol = col + random.nextInt(3) - 1;

        // Evitar que los animales se salgan del mapa
        if (nuevaFila < 0) nuevaFila = 0;
        if (nuevaFila >= isla.getFilas()) nuevaFila = isla.getFilas() - 1;
        if (nuevaCol < 0) nuevaCol = 0;
        if (nuevaCol >= isla.getColumnas()) nuevaCol = isla.getColumnas() - 1;

        // Si cambia de lugar, se mueve
        if (nuevaFila != fila || nuevaCol != col) {
            isla.getMapa()[fila][col].remove(this);
            isla.getMapa()[nuevaFila][nuevaCol].add(this);
            System.out.println(nombre + " se movió a (" + nuevaFila + "," + nuevaCol + ")");
        }
    }

    // Poca probabilidd de reproduccion
    public void reproducir(Isla isla, int fila, int col) {
        if (random.nextDouble() < 0.2) {
            try {
                Animal bebe = this.getClass().getDeclaredConstructor().newInstance();
                isla.getMapa()[fila][col].add(bebe);
                System.out.println(nombre + " tuvo una cría.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}