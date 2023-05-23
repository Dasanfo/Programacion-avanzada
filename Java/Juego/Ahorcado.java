import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private static final String[] palabras = {"profesor", "computadora", "programacion", "java", "python"};
    private static final int[] intentosPorNivel = {10, 7, 5};  // Intentos permitidos para cada nivel: [Fácil, Medio, Difícil]

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("¡Bienvenido al juego del Ahorcado!");
        System.out.println("Elige el nivel de dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        System.out.println("----------------------------------");
        System.out.print("Selecciona un nivel (1-3): ");
        int nivelSeleccionado = scanner.nextInt();
        System.out.println("----------------------------------");



        // Validar la selección del nivel
        if (nivelSeleccionado < 1 || nivelSeleccionado > 3) {
            System.out.println("Selección inválida. El juego se cerrará.");
            scanner.close();
            return;
        }

        int intentosPermitidos = intentosPorNivel[nivelSeleccionado - 1];

        Random random = new Random();
        int i = random.nextInt(palabras.length);
        String palabraSeleccionada = palabras[i];

        char[] letrasAdivinadas = new char[palabraSeleccionada.length()];
        for (int j = 0; j < letrasAdivinadas.length; j++) {
            letrasAdivinadas[j] = '_';
        }

        int numeroErrores = 0;
        int letrasCorrectas = 0;

        scanner.nextLine();  // Limpiar el buffer del scanner

        while (numeroErrores < intentosPermitidos && letrasCorrectas < palabraSeleccionada.length()) {
            System.out.println("\nPalabra a adivinar: " + String.valueOf(letrasAdivinadas));

            System.out.print("Ingresa una letra: ");
            String letraIngresada = scanner.nextLine().toLowerCase();

            boolean letraCorrecta = false;
            for (int k = 0; k < palabraSeleccionada.length(); k++) {
                if (palabraSeleccionada.charAt(k) == letraIngresada.charAt(0)) {
                    letrasAdivinadas[k] = letraIngresada.charAt(0);
                    letraCorrecta = true;
                    letrasCorrectas++;
                }
            }

            if (!letraCorrecta) {
                numeroErrores++;
                System.out.println("Letra incorrecta. Llevas " + numeroErrores + " errores.");
            }
        }

        if (letrasCorrectas == palabraSeleccionada.length()) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra " + palabraSeleccionada + "!");
        } else {
            System.out.println("\nLo siento, has perdido. La palabra era " + palabraSeleccionada + ".");
        }

        scanner.close();
    }
}


