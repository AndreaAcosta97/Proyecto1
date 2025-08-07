
// Es un animal herbivoro, solo come plantas
public class Conejo extends Animal {
    public Conejo() {
        // Agregamos sus caracteristicas
        super("Conejo", 2, 2, 0.45);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        System.out.println(nombre + " comió plantas.");
    }
}