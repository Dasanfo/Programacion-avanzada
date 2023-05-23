import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private static final String[] palabras = {"profesor", "computadora", "programacion", "java", "python"};
    private static final int[] intentosPorNivel = {10, 7, 5};  // Intentos permitidos para cada nivel: [Fácil, Medio, Difícil]

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida y selección de nivel de dificultad
        System.out.println("¡Bienvenido al juego del Ahorcado!");
        System.out.println("Elige el nivel de dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        System.out.print("Selecciona un nivel (1-3): ");

        // Leer el nivel seleccionado por el usuario
        int nivelSeleccionado = scanner.nextInt();

        // Validar la selección del nivel
        if (nivelSeleccionado < 1 || nivelSeleccionado > 3) {
            System.out.println("Selección inválida. El juego se cerrará.");

            // Cerrar el objeto Scanner para liberar recursos
            scanner.close();
            return;
        }

        // Obtener el número de intentos permitidos para el nivel seleccionado
        int intentosPermitidos = intentosPorNivel[nivelSeleccionado - 1];

        // Crear un objeto Random para generar un número aleatorio
        Random random = new Random();

        // Generar un número aleatorio entre 0 y la longitud del array de palabras
        int i = random.nextInt(palabras.length);

        // Obtener la palabra seleccionada aleatoriamente del array de palabras
        String palabraSeleccionada = palabras[i];

        // Crear un array de caracteres para representar las letras adivinadas
        char[] letrasAdivinadas = new char[palabraSeleccionada.length()];

        // Inicializar el array de letras adivinadas con guiones bajos
        for (int j = 0; j < letrasAdivinadas.length; j++) {
            letrasAdivinadas[j] = '_';
        }

        // Contadores para el número de errores y letras adivinadas correctamente
        int numeroErrores = 0;
        int letrasCorrectas = 0;

        // Limpiar el buffer del scanner después de leer el número de nivel
        scanner.nextLine();

        // Bucle principal del juego: continuar hasta que se agoten los intentos o se adivine la palabra completa
        while (numeroErrores < intentosPermitidos && letrasCorrectas < palabraSeleccionada.length()) {
            // Mostrar la palabra oculta hasta el momento
            System.out.println("\nPalabra a adivinar: " + String.valueOf(letrasAdivinadas));

            // Solicitar al jugador que ingrese una letra
            System.out.print("Ingresa una letra: ");

            // Leer la letra ingresada por el jugador
            String letraIngresada = scanner.nextLine().toLowerCase();

            // Bandera para verificar si la letra ingresada es correcta
            boolean letraCorrecta = false;

            // Verificar si la letra ingresada coincide con alguna letra de la palabra seleccionada
            for (int k = 0; k < palabraSeleccionada.length(); k++) {
                // Si la letra coincide, actualizar el array de letras adivinadas y los contadores correspondientes
                if (palabraSeleccionada.charAt(k) == letraIngresada.charAt(0)) {
                    letrasAdivinadas[k] = letraIngresada.charAt(0);
                    letraCorrecta = true;
                    letrasCorrectas++;
                }
            }

            // Si la letra ingresada no coincide con ninguna letra de la palabra, incrementar el contador de errores
            // y mostrar el número de errores cometidos
            if (!letraCorrecta) {
                numeroErrores++;
                System.out.println("Letra incorrecta. Llevas " + numeroErrores + " errores.");
            }
        }

        // Mostrar el resultado del juego: si se adivinó la palabra completa o no
        if (letrasCorrectas == palabraSeleccionada.length()) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra " + palabraSeleccionada + "!");
        } else {
            System.out.println("\nLo siento, has perdido. La palabra era " + palabraSeleccionada + ".");
        }

        // Cerrar el objeto Scanner para liberar recursos
        scanner.close();
    }
}



