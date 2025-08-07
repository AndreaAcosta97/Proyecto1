
// Es un animal herbivoro, come plantas
public class Raton extends Animal {
    public Raton() {
        // Agregamos sus caracteristicas
        super("Raton", 0.05, 1, 0.01);
    }

    @Override
    public void comer(Isla isla, int fila, int col) {
        System.out.println(nombre + " comió plantas.");
    }
}