
// Es un animal herbivoro, solo come plantas
public class Cabra extends Animal {
    public Cabra() {
        // Agregamos sus caracteristicas
        super("Cabra", 60, 3, 10);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        System.out.println(nombre + " comió plantas.");
    }
}