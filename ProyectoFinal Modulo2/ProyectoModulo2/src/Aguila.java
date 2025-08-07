
// El aguila tambien come animales, pero mas pequeños
public class Aguila extends Animal {
    public Aguila() {
        // Agregamos sus caracteristicas
        super("Aguila", 6, 3, 1);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        for (Animal otro : isla.getMapa()[fila][col]) {
            if (otro != this && (otro instanceof Conejo || otro instanceof Raton)) {
                System.out.println(nombre + " cazó a " + otro.getNombre());
                otro.morir();
                isla.getMapa()[fila][col].remove(otro);
                break;
            }
        }
    }
}