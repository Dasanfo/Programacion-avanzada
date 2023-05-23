import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Clase abstracta base que representa un producto electrónico
abstract class ProductoElectronico {
    private String nombre;
    private double precio;
    private int garantia;

    // Constructor de la clase
    public ProductoElectronico(String nombre, double precio, int garantia) {
        this.nombre = nombre;
        this.precio = precio;
        this.garantia = garantia;
    }

    // Método getter para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Método getter para obtener la garantía del producto
    public int getGarantia() {
        return garantia;
    }

    // Método abstracto que debe ser implementado por las clases hijas
    public abstract void cargar(int cargaInicial);

    // Método para mostrar la información básica del producto
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Garantía: " + garantia + " meses");
    }
}

// Clase hija que representa un celular
class Celular extends ProductoElectronico {
    private String modelo;
    private int capacidadBateria;
    private int velocidadCarga;

    // Constructor de la clase
    public Celular(String nombre, double precio, int garantia, String modelo, int capacidadBateria, int velocidadCarga) {
        super(nombre, precio, garantia);
        this.modelo = modelo;
        this.capacidadBateria = capacidadBateria;
        this.velocidadCarga = velocidadCarga;
    }

    // Implementación del método abstracto de la clase base
    @Override
    public void cargar(int cargaInicial) {
        double tiempoCarga = (capacidadBateria - cargaInicial) / velocidadCarga;
        System.out.println("Cargando el celular " + modelo + " con una carga inicial de " + cargaInicial + " horas.");
        System.out.println("Tiempo estimado de carga: " + tiempoCarga + " horas.");
    }

    // Método adicional que simula hacer una llamada desde el celular
    public void hacerLlamada(String numero) {
        System.out.println("Llamando al número " + numero + " desde el celular " + modelo + ".");
    }
}

// Clase hija que representa una computadora
class Computadora extends ProductoElectronico {
    private String marca;
    private int capacidadBateria;
    private int velocidadCarga;

    // Constructor de la clase
    public Computadora(String nombre, double precio, int garantia, String marca, int capacidadBateria, int velocidadCarga) {
        super(nombre, precio, garantia);
        this.marca = marca;
        this.capacidadBateria = capacidadBateria;
        this.velocidadCarga = velocidadCarga;
    }

    // Implementación del método abstracto de la clase base
    @Override
    public void cargar(int cargaInicial) {
        double tiempoCarga = (capacidadBateria - cargaInicial) / velocidadCarga;
        System.out.println("Cargando la computadora " + marca + " con una carga inicial de " + cargaInicial + " minutos.");
        System.out.println("Tiempo estimado de carga: " + tiempoCarga + " minutos.");
    }

    // Método adicional que simula ejecutar un programa en la computadora
    public void ejecutarPrograma(String programa) {
        System.out.println("Ejecutando el programa " + programa + " en la computadora " + marca + ".");
    }
}

// Clase principal que contiene el programa principal
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ProductoElectronico> productos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    crearCelular();
                    break;
                case 2:
                    crearComputadora();
                    break;
                case 3:
                    mostrarInformacionProductos();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    // Método que muestra el menú de opciones
    private static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Crear Celular");
        System.out.println("2. Crear Computadora");
        System.out.println("3. Mostrar información de los productos");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
    }

    // Método que obtiene la opción seleccionada por el usuario
    private static int obtenerOpcion() {
        int opcion;
        while (true) {
            try {
                opcion = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar el búfer del escáner
            }
        }
        return opcion;
    }

    // Método que permite crear un nuevo celular
    private static void crearCelular() {
        System.out.print("Ingrese el nombre del celular: ");
        String nombreCelular = scanner.next();
        System.out.print("Ingrese el precio del celular: ");
        double precioCelular = scanner.nextDouble();
        System.out.print("Ingrese la garantía del celular (meses): ");
        int garantiaCelular = scanner.nextInt();
        System.out.print("Ingrese el modelo del celular: ");
        String modeloCelular = scanner.next();
        System.out.print("Ingrese la capacidad de la batería del celular (mAh): ");
        int capacidadBateriaCelular = scanner.nextInt();
        System.out.print("Ingrese la velocidad de carga del celular (mAh/h): ");
        int velocidadCargaCelular = scanner.nextInt();

        Celular celular = new Celular(nombreCelular, precioCelular, garantiaCelular, modeloCelular,
                capacidadBateriaCelular, velocidadCargaCelular);
        productos.add(celular);
        System.out.println("Celular creado con éxito.");
    }

    // Método que permite crear una nueva computadora
    private static void crearComputadora() {
        System.out.print("Ingrese el nombre de la computadora: ");
        String nombreComputadora = scanner.next();
        System.out.print("Ingrese el precio de la computadora: ");
        double precioComputadora = scanner.nextDouble();
        System.out.print("Ingrese la garantía de la computadora (meses): ");
        int garantiaComputadora = scanner.nextInt();
        System.out.print("Ingrese la marca de la computadora: ");
        String marcaComputadora = scanner.next();
        System.out.print("Ingrese la capacidad de la batería de la computadora (mAh): ");
        int capacidadBateriaComputadora = scanner.nextInt();
        System.out.print("Ingrese la velocidad de carga de la computadora (mAh/h): ");
        int velocidadCargaComputadora = scanner.nextInt();

        Computadora computadora = new Computadora(nombreComputadora, precioComputadora, garantiaComputadora,
                marcaComputadora, capacidadBateriaComputadora, velocidadCargaComputadora);
        productos.add(computadora);
        System.out.println("Computadora creada con éxito.");
    }

    // Método que muestra la información de todos los productos
    private static void mostrarInformacionProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("----- PRODUCTOS -----");
            for (ProductoElectronico producto : productos) {
                producto.mostrarInformacion();
                producto.cargar(60); // Ejemplo de carga inicial de 60 minutos

                if (producto instanceof Celular) {
                    Celular celular = (Celular) producto;
                    celular.hacerLlamada("123456789");
                } else if (producto instanceof Computadora) {
                    Computadora computadora = (Computadora) producto;
                    computadora.ejecutarPrograma("Word");
                }

                System.out.println();
            }
        }
    }
}
