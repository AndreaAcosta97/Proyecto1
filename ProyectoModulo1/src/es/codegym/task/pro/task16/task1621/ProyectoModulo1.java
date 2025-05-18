package es.codegym.task.pro.task16.task1621;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

    public class ProyectoModulo1 {

        private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String ALPHABET_LOWER = ALPHABET_UPPER.toLowerCase();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Cifrado César ===");
            System.out.println("1) Cifrar archivo");
            System.out.println("2) Descifrar achivo con clave");
            System.out.println("3) Descifrar archivo (brute force)");
            System.out.print("Elija opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ruta archivo entrada: ");
            String inputPath = scanner.nextLine();

            System.out.print("Ruta archivo salida: ");
            String outputPath = scanner.nextLine();


            if (!Files.exists(Paths.get(inputPath))) {
                System.err.println("El archivo de entrada no existe.");
                return;
            }

            try {
                switch (option) {
                    case 1:
                        System.out.print("Clave (número entero positivo): ");
                        int keyEnc = scanner.nextInt();
                        if (keyEnc < 0) {
                            System.out.println("Clave inválida, debe ser positiva");
                            return; // ERROR: no usa excepción, termina abrupto
                        }
                        processFile(inputPath, outputPath, keyEnc, true);
                        System.out.println("Archivo cifrado creado.");
                        break;
                    case 2:
                        System.out.print("Clave (número entero positivo): ");
                        int keyDec = scanner.nextInt();
                        if (keyDec < 0) {
                            System.out.println("Clave inválida");
                            return;
                        }
                        processFile(inputPath, outputPath, keyDec, false);
                        System.out.println("Archivo descifrado creado.");
                        break;
                    case 3:
                        bruteForceDecrypt(inputPath);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException e) {
                System.err.println("Error al procesar archivos: " + e.getMessage());
            }
        }

        public static void processFile(String inputPath, String outputPath, int key, boolean encrypt) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? caesarCipher(line, key) : caesarCipher(line, 26 - (key % 26));
                writer.write(processedLine);
                writer.newLine();
            }

        }

        public static String caesarCipher(String text, int key) {
            StringBuilder result = new StringBuilder();

            for (char c : text.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    int pos = ALPHABET_UPPER.indexOf(c);
                    int newPos = (pos + key) % 26;
                    result.append(ALPHABET_UPPER.charAt(newPos));
                } else if (Character.isLowerCase(c)) {
                    int pos = ALPHABET_LOWER.indexOf(c);
                    int newPos = (pos + key) % 26;
                    result.append(ALPHABET_LOWER.charAt(newPos));
                } else {
                    result.append(c);
                }
            }

            return result.toString();
        }

        public static void bruteForceDecrypt(String inputPath) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get(inputPath)));

            System.out.println("Probando todas las claves (brute force):");
            for (int key = 1; key <= 26; key++) {
                String decoded = caesarCipher(content, 26 - key);
                System.out.println("Clave " + key + ": ");
                System.out.println(decoded);
                System.out.println("--------------------------------------");
            }
        }
    }
}
