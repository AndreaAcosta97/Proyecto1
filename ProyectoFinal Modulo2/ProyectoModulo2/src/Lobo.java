
// El lobo es carnivoro, come otros animales
public class Lobo extends Animal {
    public Lobo() {
        // Agregamos sus caracteristicas
        super("Lobo", 50, 3, 8);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        for (Animal otro : isla.getMapa()[fila][col]) {
            // Buscamos que animales se puede comer
            if (otro != this && (otro instanceof Conejo || otro instanceof Cabra || otro instanceof Raton)) {
                System.out.println(nombre + " se comió a " + otro.getNombre());
                otro.morir();
                isla.getMapa()[fila][col].remove(otro);
                break; // comer solo uno
            }
        }
    }
}