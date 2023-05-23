# Ejercicio Modelo Tercer Parcial: Programación Avanzada
## _John Corredor, PhD_

- ✨Magic ✨

## Características del MODELO
- Representa un modelo práctico del 3er parcial
- Se recomienda hacer el ejercicio


### Propuesta MODELO TERCER PARCIAL


> a. En el contexto de la construcción de un modelo de aprendizaje automático, desarrolle una clase abstracta llamada ```Modelo``` que tiene como atributos el nombre (String) y el número de parámetros (int). Debe tener un constructor que permita inicializar sus atributos y un método abstracto llamado ```entrenar``` de tipo void.

> b. Diseñe una clase llamada ```ModeloLineal``` hija de ```Modelo``` que tiene como atributos adicionales el coeficiente de correlación (double) y el error cuadrático medio (double). Debe tener un método constructor que permita inicializar sus atributos y los del padre. Sobreescribe el método ```entrenar``` el cual muestra por pantalla el proceso de entrenamiento de un modelo lineal de esta manera:

```bash
Entrenando modelo lineal: <nombre>
Número de parámetros: <parámetros>
Coeficiente de correlación inicial: <coeficiente>
Error cuadrático medio inicial: <error>
Entrenamiento completado.
```

> c. Diseñe una clase llamada ModeloArbolDecision hija de Modelo que tiene como atributos adicionales la profundidad del árbol (int) y la cantidad de nodos hoja (int). La clase ModeloArbolDecision debe tener también un constructor que permite inicializar sus atributos y los del padre. Sobreescribe el método entrenar para que muestre por pantalla la información del entrenamiento del modelo de árbol de decisión así:

```bash
Entrenando modelo de árbol de decisión: <nombre>
Número de parámetros: <parámetros>
Profundidad del árbol: <profundidad>
Número de nodos hoja: <nodos hoja>
Entrenamiento completado.
```

> d. En el main de una aplicación en consola construya una lista de Modelos (objetos de tipo ModeloLineal y ModeloArbolDecision, en la misma lista puede haber objetos de los dos tipos). Construya por lo menos un objeto de cada tipo. Y en el mismo método del main desarrolle un ciclo que muestre por pantalla el proceso de entrenamiento de cada modelo usando el método entrenar de cada clase. En este punto debe utilizar polimorfismo para la lista de Modelos y para entrenar los modelos.

> e. Desarrolle una clase llamada Validador que tenga un método llamado validarModelo. Este método debe recibir un objeto de la clase Modelo, ejecutar el método entrenar del modelo, y luego imprimir un mensaje que indique si el modelo es válido o no. Un modelo se considera válido si cumple las siguientes condiciones:

> * Para los modelos lineales, el coeficiente de correlación debe ser superior a 0.8 y el error cuadrático medio debe ser inferior a 0.2.
> * Para los modelos de árbol de decisión, la profundidad del árbol debe ser inferior a 10 y el número de nodos hoja debe ser superior a 5.

> El método debe imprimir el siguiente mensaje si el modelo es válido:

```bash
El modelo <nombre> ha pasado la validación.
```

> Y el siguiente mensaje si el modelo no es válido:

```bash
El modelo <nombre> no ha pasado la validación.
```

### Salida
```bash
Entrenando modelo lineal: Modelo Lineal 1
Número de parámetros: 2
Coeficiente de correlación inicial: 0.85
Error cuadrático medio inicial: 0.1
Entrenamiento completado.
El modelo Modelo Lineal 1 ha pasado la validación.
Entrenando modelo de árbol de decisión: Modelo Árbol Decisión 1
Número de parámetros: 3
Profundidad del árbol: 9
Número de nodos hoja: 8
Entrenamiento completado.
El modelo Modelo Árbol Decisión 1 ha pasado la validación.
Entrenando modelo lineal: Modelo Lineal 2
Número de parámetros: 2
Coeficiente de correlación inicial: 0.7
Error cuadrático medio inicial: 0.3
Entrenamiento completado.
El modelo Modelo Lineal 2 no ha pasado la validación.
Entrenando modelo de árbol de decisión: Modelo Árbol Decisión 2
Número de parámetros: 3
Profundidad del árbol: 11
Número de nodos hoja: 4
Entrenamiento completado.
El modelo Modelo Árbol Decisión 2 no ha pasado la validación.
