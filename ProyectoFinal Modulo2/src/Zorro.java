
// El zorro es carnivoro, come otros animales
public class Zorro extends Animal {
    public Zorro() {
        // Agregamos sus caracteristicas
        super("Zorro", 8, 2, 2);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        // Solo come animales mas pequeños
        for (Animal otro : isla.getMapa()[fila][col]) {
            // Si hay un conejo o un ratón, se lo come
            if (otro != this && (otro instanceof Conejo || otro instanceof Raton)) {
                System.out.println(nombre + " se comió a " + otro.getNombre());
                otro.morir();
                isla.getMapa()[fila][col].remove(otro);
                break; // Solo comer uno
            }
        }
    }
}