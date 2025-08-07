public class Simulacion implements Runnable {
    private Isla isla;

    public Simulacion(Isla isla) {
        this.isla = isla;
    }

    @Override
    public void run() {
        try {
            // Simular
            for (int turno = 1; turno <= 10; turno++) {
                System.out.println("\n===== TURNO " + turno + " =====");

                for (int i = 0; i < isla.getFilas(); i++) {
                    for (int j = 0; j < isla.getColumnas(); j++) {
                        for (Animal a : isla.getMapa()[i][j].toArray(new Animal[0])) {
                            if (a.estaVivo()) {
                                a.comer(isla, i, j);
                                a.mover(isla, i, j);
                                a.reproducir(isla, i, j);
                            }
                        }
                    }
                }

                mostrarMapa();
                Thread.sleep(2000); // esperar 2 segundos entre turnos
            }

            System.out.println("\nLa simulación ha terminado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMapa() {
        System.out.println("----- Estado de la isla -----");
        for (int i = 0; i < isla.getFilas(); i++) {
            for (int j = 0; j < isla.getColumnas(); j++) {
                System.out.print("[" + isla.getMapa()[i][j].size() + "] ");
            }
            System.out.println();
        }
    }
}