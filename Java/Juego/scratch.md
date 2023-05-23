## Juego del Ahorcado

El juego del Ahorcado es un juego en el que el jugador intenta adivinar una palabra oculta letra por letra antes de cometer un número máximo de errores. En cada turno, el jugador ingresa una letra y se verifica si la letra está presente en la palabra oculta. Si la letra es correcta, se revela en su posición correspondiente en la palabra. Si la letra es incorrecta, se cuenta como un error. El juego continúa hasta que el jugador adivine la palabra completa o cometa un número máximo de errores.

### Cómo Jugar?

1. Ejecuta el juego del Ahorcado.
2. Selecciona el nivel de dificultad:
    - Nivel Fácil: Mayor número de intentos permitidos.
    - Nivel Medio: Número moderado de intentos permitidos.
    - Nivel Difícil: Menor número de intentos permitidos.
3. Se mostrará la palabra oculta representada por guiones bajos "_".
4. Ingresa una letra por turno y presiona Enter.
5. Si la letra ingresada está presente en la palabra oculta, se revelará en su posición correspondiente. Si la letra no está presente, se contará como un error.
6. Continúa adivinando letras hasta que adivines la palabra completa o cometas el número máximo de errores permitidos.
7. Si adivinas la palabra, ¡felicidades! Habrás ganado el juego. Si cometes demasiados errores, habrás perdido.
8. Al final del juego, se mostrará la palabra oculta.

### Cambios Realizados

Se han realizado los siguientes cambios en el código del juego del Ahorcado:

1. Se ha agregado una documentación completa en el código para facilitar su comprensión.

2. Se ha introducido un array `palabras` que contiene una lista de palabras para el juego. Puedes modificar este array y agregar o eliminar palabras según tu preferencia.

3. Se ha implementado la posibilidad de especificar un número máximo de errores permitidos. Esto permite agregar niveles de dificultad al juego.

4. Se ha agregado un bucle de nivel de dificultad al principio del juego, donde el jugador puede elegir el nivel deseado. Cada nivel tiene un número máximo de errores permitidos.

5. Se han corregido errores en la lógica del juego, como el tipo de dato utilizado para almacenar la letra ingresada por el jugador.

6. Se han realizado mejoras en la presentación de los mensajes y la interacción con el jugador para hacer el juego más amigable y comprensible.

### Compilación del Juego

Para compilar y ejecutar el juego del Ahorcado, sigue los siguientes pasos:

1. Asegúrate de tener instalado el entorno de desarrollo Java en tu computadora.

2. Crea un nuevo archivo llamado `Ahorcado.java` y copia el código del juego en ese archivo.

3. Abre una terminal o línea de comandos y navega hasta la ubicación del archivo `Ahorcado.java`.

4. Ejecuta el siguiente comando para compilar el código:
`javac Ahorcado.java`
Si no hay errores de compilación, se generará un archivo Ahorcado.class en el mismo directorio.
Ejecuta el juego con el siguiente comando:
`java Ahorcado`

	El juego se iniciará y podrás jugar al Ahorcado.

¡Disfruta del juego del Ahorcado!
