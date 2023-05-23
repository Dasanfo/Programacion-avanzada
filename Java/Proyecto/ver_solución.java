import java.util.ArrayList;
import java.util.Scanner;
//librerias necesarias para el codigo
public class PantallaGaleria { //Clase Pantalla Galeria funciona como la clase principal
    public static void main(String[] args) {
        ArrayList<Artista> listaArtistas = new ArrayList<>(); //Array list para los datos de los artistas
        //Algunos artistas inicializados
        Artista artista00 = new Artista(111,"daniel","2004-02-26","Colombiano","Artista moderno");
        Artista artista01 = new Artista(222,"picaso","1954-06-20","Español","Artista conteporaneo");
        Artista artista02 = new Artista(333,"sergio","1994-08-20","Venezolano","Artista clasico");
        Artista artista03 = new Artista(444,"leonardo","1954-06-20","Italiana","Artista renacentista");
        //Se agregan a la lista listaArtistas
        listaArtistas.add(artista00);
        listaArtistas.add(artista01);
        listaArtistas.add(artista02);
        ArrayList<Artista> listaArtistasEliminados = new ArrayList<>();//listaArtistasEliminados(Para eliminados)
        ArrayList<Compra> listaCompras = new ArrayList<>(); //Lista para las compras
        ArrayList<Cliente> listaClientes = new ArrayList<>();//Lista para los clientes, y así llevar control de lo uqe se compra o se elimina.
        //Se inicializa el un cliente
        Cliente cliente00 = new Cliente("Santiago","Crr 95","santiago.com");
        Cliente cliente01 = new Cliente("Libia","Crr 95","Libia.com");
        //Se añaden a la lista
        listaClientes.add(cliente00);
        listaClientes.add(cliente01);
        ArrayList<Cliente> listaClientesEliminados = new ArrayList<>();//Nueva lista para los clientes que son eliminados.
        ArrayList<Obra> listaObras = new ArrayList<>();//Para listar las obras
        //Se inicializan obras.
        Obra obra00 = new Obra("Monalisa","acuarela",1998,15.00,artista03);
        Obra obra01 = new Obra("La noche estrellada", "óleo", 1889, 20.50, artista01);
        Obra obra02 = new Obra("El grito", "temple", 1893, 18.75, artista02);
        Obra obra03 = new Obra("La persistencia de la memoria", "óleo", 1931, 22.25, artista00);
        Obra obra04 = new Obra("Guernica", "óleo", 1937, 25.00, artista02);
        Obra obra05 = new Obra("El beso", "litografía", 1907, 16.80, artista02);
        //Se añaden las obras antes inicializadas
        listaObras.add(obra00);
        listaObras.add(obra01);
        listaObras.add(obra02);
        listaObras.add(obra03);
        listaObras.add(obra04);
        listaObras.add(obra05);
        ArrayList<Obra> listaObrasEliminadas = new ArrayList<>(); //lista para las obras elimindas
        // Se crean los controles para manejar el menu de opciones
        ControlGaleria controlGaleria = new ControlGaleria(listaArtistas,listaArtistasEliminados,listaCompras);
        ControlCliente controlCliente = new ControlCliente(listaClientes,listaClientesEliminados);
        GestionObras gestionObras = new GestionObras(listaObras,listaObrasEliminadas);

        Scanner scanner = new Scanner(System.in);//Se toman datos por medio de la opción scannner
        //Bucle para mostrar el menú y ejecutar
        int opcion;//Variable para el menú
        do {
            System.out.println("Ingrese la opcion que desee");
            System.out.println("1. Agregar obra");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Agregar artista");
            System.out.println("4. Eliminar obra");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Eliminar artista");
            System.out.println("7. Listar obras");
            System.out.println("8. Listar clientes");
            System.out.println("9. Listar artistas");
            System.out.println("10. Realizar compra");
            System.out.println("11. Listar compras");
            System.out.println("12. Listar obras eliminadas");
            System.out.println("13. Listar artistas eliminados");
            System.out.println("14. Listar clientes eliminados");
            System.out.println("15. Listar compras de un cliente");
            System.out.println("16. Salir");
            System.out.println("--------------------------------------------------------");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {//switch para que se elija una opción y así poner a ejecutar los métodos.
                case 1 -> gestionObras.agregarObra(listaObras,listaArtistas);
                case 2 -> controlCliente.agregarCliente(listaClientes);
                case 3 -> controlGaleria.agregarArtista(listaArtistas);
                case 4 -> gestionObras.eliminarObra(listaObras,listaObrasEliminadas);
                case 5 -> controlCliente.eliminarCliente(listaClientes,listaClientesEliminados);
                case 6 -> controlGaleria.eliminarArtista(listaArtistas,listaArtistasEliminados,listaObras);
                case 7 -> gestionObras.listarObra(listaObras);
                case 8 -> controlCliente.listarCliennte(listaClientes);
                case 9 -> controlGaleria.listarArtista(listaArtistas);
                case 10 -> controlGaleria.realizarCompra(listaCompras, listaObras, listaClientes);
                case 11 -> controlGaleria.listarCompra(listaCompras);
                case 12 -> gestionObras.listarObrasEliminadas(listaObrasEliminadas);
                case 13 -> controlGaleria.listarArtistasEliminados(listaArtistasEliminados);
                case 14 -> controlCliente.listarClientesEliminados(listaClientesEliminados);
                case 15 -> controlGaleria.listarComprasCliente(listaCompras);
                case 16 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        while (opcion != 16);//Opción de salida.
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
//librerias necesarias para el codigo
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//inicio de clase de control de galeria
class ControlGaleria{
    //creacion de listas para modificar, artistas, los eliminados y las compras.
    private ArrayList <Artista> Artistas;
    private ArrayList <Artista> ArtistasEliminados;
    private ArrayList <Compra> Compras;
    //constructor
    public ControlGaleria(ArrayList<Artista> artistas, ArrayList<Artista> artistasEliminados, ArrayList<Compra> compras) {
        this.Artistas = artistas;
        this.ArtistasEliminados = artistasEliminados;
        this.Compras = compras;
    }
    //metodos setters y getters
    public void setArtistas(ArrayList<Artista> artista) {
        this.Artistas = artista;
    }
    public ArrayList<Artista> getArtistas() {
        return Artistas;
    }
    public void setCompras(ArrayList<Compra> compras) {
        this.Compras = compras;
    }
    public ArrayList<Compra> getCompras() {
        return Compras;
    }
    public ArrayList<Artista> getArtistasEliminados() {
        return ArtistasEliminados;
    }
    public void setArtistasEliminados(ArrayList<Artista> artistasEliminados) {
        this.ArtistasEliminados = artistasEliminados;
    }
    //Metodos para el contro de la galeria
    public void agregarArtista(ArrayList<Artista> Artistas){
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        boolean comprobarIdRepetido = false; // variable que me ayuda a saber si el artista ya esta en la lista

        System.out.println("Ingrese el ID del artista:");
        int id = scan.nextInt();

        for (Artista artistaAux : Artistas) { // bucle para buscar el artista en la lista con ese id
            if (artistaAux.getId() == id) {
                comprobarIdRepetido = true;
                break;
            }
        }

        if (!comprobarIdRepetido) { // si no encuentro el id del artista en la lista lo agrego
            scan.nextLine();
            // se piden los datos del artista
            System.out.println("Ingrese el nombre del artista:");
            String nombre = scan.nextLine();
            System.out.println("Ingrese la fecha de nacimiento del artista:");
            String fechaNacimiento = scan.nextLine();
            System.out.println("Ingrese la nacionalidad del artista:");
            String nacionalidad = scan.nextLine();
            System.out.println("Ingrese la biografía del artista:");
            String biografia = scan.nextLine();

            Artista artistaNuevo = new Artista(id, nombre, fechaNacimiento, nacionalidad, biografia); // creo a mi artista
            Artistas.add(artistaNuevo); // añado al artista

            System.out.println("El artista se agregó correctamente.");
        } else {
            System.out.println("El artista ya fue registrado."); // si encuentro el ID le muestro el mensaje
        }
        System.out.println("--------------------------------------------------------");
    }
    public void eliminarArtista(ArrayList<Artista> Artistas,ArrayList<Artista> ArtistasEliminados,ArrayList<Obra>obras){
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el ID del artista a eliminar:");
        int id = scan.nextInt();
        Artista artistaAux = null;
        //se pide el id del artista a eliminar
        boolean artistaEncontrado = false; // variable par ver si el artista esta en la lista de artistas
        Iterator<Artista> iterator = Artistas.iterator();//iterator para comprobar la lista de artista

        while (iterator.hasNext()) { // Se hace con un iterator ya que en un for each no nos deja eliminar/agregar obajetos a listas
            Artista artista = iterator.next();
            if (artista.getId() == id) { // se busca el id del artista para ver si esta en la lista
                iterator.remove(); // si encuentro el id del artista lo elimino
                // busco las obras del artista y las elimino
                obras.removeIf(obra -> obra.getArtista().getId() == id);
                artistaEncontrado = true;
                ArtistasEliminados.add(artista); // agrego el artista a los eliminados
                artistaAux = artista;
                break;
            }
        }

        if (artistaEncontrado) {
            System.out.println("Se eliminó el artista " +artistaAux.getNombre()+ " correctamente.");
        } else {
            System.out.println("No se encontró el artista con el ID especificado.");
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarArtista(ArrayList<Artista> Artistas){
        //metodo para imprimir los distintos artistas en la lista
        System.out.println("--------------------------------------------------------");
        //si no encuentra llena la lista menciona que la lista esta vacia
        if(Artistas.isEmpty()){
            System.out.println("Aún no hay Artistas registrados");
        }else {
            System.out.println("LISTA DE ARTISTAS: ");// se imprime los artistas si la lsita no esta vacia
            for (Artista ArtistaAux: Artistas) {
                ArtistaAux.presentarArtista();
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    public void realizarCompra(ArrayList<Compra> Compras,ArrayList <Obra> obras, ArrayList<Cliente>Clientes) {
        System.out.println("--------------------------------------------------------");
        System.out.println("°°°°°°°°°°BINEVENIDO A GALERIA 2023°°°°°°°°°");
        Scanner scanner = new Scanner(System.in);
        // variables que me ayudaran a hacer la compra
        int indiceObra = 0;
        Obra obraComprar = null;
        int comprobar = 0;
        int confirmacion = 0;
        boolean comprobarcliente = false;
        Cliente clienteCompra = null;
        double precioObra = 0;
        String nombreAux = "";
        //sistema para comprar o seguir viendo las obras.
        System.out.println("-Presiona 'Enter' para ver la siguiente obra ");
        System.out.println("-Escribe 'comprar' para comprar una obra");
        System.out.println("-Escribe 'fin' para dejar de ver las obras\n");
        System.out.println("-> OBRAS QUE PUEDE COMPRAR:");

        while (true) { /*el bucle se ejecutará continuamente sin ninguna condición de salida explícita. el bucle seguirá ejecutándose
             hasta que se encuentre una instrucción de break dentro del bucle, que interrumpirá el bucle y terminará la ejecución.*/

            // Esperar la entrada del usuario
            String tecla = scanner.nextLine();

            if (tecla.equals("fin")) {
                // Si se ingresa "fin", se termina la ejecución
                break;
            } else if (tecla.equals("c")) {
                // Si se ingresa "c", se guarda la obra y se termina el ciclo
                obraComprar = obras.get(indiceObra-1);
                precioObra = obraComprar.getPrecio();
                comprobar = 1;
                break;
            }

            if (indiceObra < obras.size()) {
                // Obtener la obra actual y mostrar su información
                Obra obraItaradora = obras.get(indiceObra);
                obraItaradora.presentarObra();
                // Incrementar el índice para apuntar a la siguiente obra
                indiceObra++;
            } else {
                // Se han mostrado todas las obras
                System.out.println("Ya se han mostrado todas las obras.");
                break;
            }
        }
        // si elusuario hizo la compra imprimo el siguiente mensaje
        if (comprobar == 1) {
            System.out.println("Has seleccionado la obra: " +obraComprar.getTitulo()+" con un valor de: "+obraComprar.getPrecio());
            System.out.println("Ingrese su nombre (cliente):"); // piedo el nombre de la persona que compra (cliente)
            nombreAux = scanner.nextLine();

        }else{
            System.out.println("Gracias por su visita");
        }

        for (Cliente c1: Clientes){// reviso que el el nombre este en la lista de clientes
            if (c1.getNombre().equals(nombreAux)) {
                System.out.println("Esta seguro que desea compra estas obra?");// me aseguro de que quiere hacer la compra
                System.out.println("1 -> Si");
                System.out.println("2 -> No");
                confirmacion = scanner.nextInt();
                comprobarcliente = true;
                clienteCompra = c1; // guardo al cliente que quiere hacer la compra en un objeto clienteCompra
                break;
            }
        }
        if (comprobarcliente && confirmacion == 1){ // si el cliente exite en la lista y esta seguro de hacer la compra, hago la compra
            Compra compraNueva = new Compra(LocalDate.now(),clienteCompra,precioObra,obraComprar); // creo la compra
            Compras.add(compraNueva); // agrego la compra a la lista de compras
            System.out.println("La compra fue exitosa!");
            obras.remove(obraComprar); // remuevo la obra de la lista de obra para que ya nadie la pueda comprar
        }else {
            System.out.println("Se canceló la compra ya sea porque no se encontró al cliente o no comfirmó la compra, intentelo de nuevo");
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarCompra(ArrayList<Compra> Compras){
        System.out.println("--------------------------------------------------------");
        //si la lista de compras esta vacia, entra en la condicion
        if (Compras.isEmpty()){
            System.out.println("No se han registrado compras.");
        }else{
            System.out.println("-> LISTA DE COMPRAS: ");
            for (Compra compraAux: Compras){
                compraAux.presentarCompra();//metodo en la clase de compra
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarArtistasEliminados(ArrayList<Artista> ArtistasEliminados){
        System.out.println("--------------------------------------------------------");
        if(ArtistasEliminados.isEmpty()){
            System.out.println("Aún no hay obras resgistradas");
        }else{
            for (Artista artistas: ArtistasEliminados) { // bucle para imprimir los artistas eliminados
                artistas.presentarArtista();
            }
        }
    }
    public void listarComprasCliente(ArrayList<Compra> compras){
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        // variable para guardar la entrada del usuario
        System.out.println("Ingrese su nombre (cliente):");
        String nombre = scan.nextLine();
        int comprobar = 0; // variable para comprobar que tengo compras
        for (Compra compra: compras) {
            if (compra.getCliente().getNombre().equals(nombre)){ // si encuetro el nombre del cliente en alguna de las obras lo printeo
                System.out.println("OBRAS COMPRADAS:");
                compra.presentarCompra(); // muestro las obras que compró con el metodo de la clase
                System.out.println("--------------------------------------------------------");
                comprobar = 1;
            }
        }
        if (comprobar == 0){
            System.out.println("No hay ninguna compra");
        }
    }

}
//////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public  class GestionObras {
    private ArrayList <Obra> obras;
    private ArrayList <Obra> obrasEliminadas;
    //Constructor
    public GestionObras(ArrayList<Obra> obras,ArrayList <Obra> obrasEliminadas) {
        this.obras = obras;
        this.obrasEliminadas = obrasEliminadas;
    }
    //Getters y Setters
    public ArrayList<Obra> getObras() {
        return obras;
    }
    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }
    public ArrayList<Obra> getObrasEliminadas() {
        return obras;
    }
    public void setObrasEliminadas(ArrayList<Obra> obrasEliminadas) {
        this.obrasEliminadas = obrasEliminadas;
    }
    //Metodos
    public void agregarObra(ArrayList <Obra> obras, ArrayList <Artista> Artistas){
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        boolean comprobarListaObraVacia = obras.isEmpty();
        boolean comprobarNombreArtistaRepetido = false;
        boolean comprobarTituloRepetido = false;
        Artista artistaObra = null;

        System.out.println("Ingrese el nombre del artista de la obra:");
        String nombreArtista = scan.nextLine();
        System.out.println("Ingrese el título de la obra:");
        String titulo = scan.nextLine();

        if (comprobarListaObraVacia) {
            for (Artista artista : Artistas) {
                if (artista.getNombre().equals(nombreArtista)) {
                    comprobarNombreArtistaRepetido = true;
                    System.out.println("Ingrese la técnica de la obra:");
                    String tecnica = scan.nextLine();
                    System.out.println("Ingrese el año de la obra:");
                    int anioCreacion = scan.nextInt();
                    System.out.println("Ingrese el precio de la obra:");
                    double precio = scan.nextDouble();
                    scan.nextLine(); // Limpiar el búfer de entrada

                    Obra obraNueva = new Obra(titulo, tecnica, anioCreacion, precio, artista);
                    obras.add(obraNueva);
                    System.out.println("La obra se agregó correctamente.");
                    break;
                }
            }
            if (!comprobarNombreArtistaRepetido) {
                System.out.println("No se encontró el artista. Por favor, agregue el artista antes de agregar la obra.");
            }
        } else {
            for (Artista artista : Artistas) {
                if (artista.getNombre().equals(nombreArtista)) {
                    comprobarNombreArtistaRepetido = true;
                    artistaObra = artista;
                    break;
                }
            }

            if (comprobarNombreArtistaRepetido) {
                for (Obra obra : obras) {
                    if (obra.getTitulo().equals(titulo)) {
                        comprobarTituloRepetido = true;
                        System.out.println("El título ya está en la lista de obras.");
                        break;
                    }
                }

                if (!comprobarTituloRepetido) {
                    System.out.println("Ingrese la técnica de la obra:");
                    String tecnica = scan.nextLine();
                    System.out.println("Ingrese el año de la obra:");
                    int anioCreacion = scan.nextInt();
                    System.out.println("Ingrese el precio de la obra:");
                    double precio = scan.nextDouble();
                    scan.nextLine(); // Limpiar el búfer de entrada

                    Obra obraNueva = new Obra(titulo, tecnica, anioCreacion, precio, artistaObra);
                    obras.add(obraNueva);
                    System.out.println("La obra se agregó correctamente.");
                }
            } else {
                System.out.println("No se encontró el artista. Por favor, agregue el artista primero.");
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    public void eliminarObra(ArrayList <Obra> obras,ArrayList <Obra> obrasEliminadas) {
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        //escaner de titulo para buscar la obra que se quiere eliminar
        System.out.println("Ingrese el título de la obra a eliminar: ");
        String titulo = scan.nextLine();
        boolean obraEncontrada = false;
        //ciclo con iterator para buscar el titulo de las obras
        Iterator<Obra> iterator = obras.iterator();
        while (iterator.hasNext()) {
            Obra obra = iterator.next();
            if (obra.getTitulo().equals(titulo)) {
                iterator.remove();
                obrasEliminadas.add(obra);//añadir la obra a lista de obras eliminadas
                obraEncontrada = true;
                break;
            }
        }
        //mencion si la obra se elimino correctamente
        if (obraEncontrada) {
            System.out.println("La obra \"" + titulo + "\" se ha eliminado correctamente.");
        } else {
            System.out.println("No se encontró la obra \"" + titulo + "\" en la lista de obras.");
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarObra(ArrayList <Obra> obras){
        System.out.println("--------------------------------------------------------");
        if(obras.isEmpty()){
            System.out.println("Aún no hay obras resgistradas");
        }else{
            System.out.println("LISTA DE OBRAS: "); // muesto las obras registradas con un blucle
            for (Obra obraAux: obras){
                obraAux.presentarObra();
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarObrasEliminadas(ArrayList<Obra> obrasEliminadas){
        System.out.println("--------------------------------------------------------");
        if(obrasEliminadas.isEmpty()){
            System.out.println("Aún no hay obras resgistradas"); // muestra todas las obras eliminadas con el bucle
        }else{
            for (Obra obra: obrasEliminadas) {
                obra.presentarObra();
            }
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public  class ControlCliente {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesEliminados;


    //Constructor
    public ControlCliente(ArrayList<Cliente> clientes, ArrayList<Cliente> clientesEliminados) {
        this.clientes = clientes;
        this.clientesEliminados = clientesEliminados;
    }
    //Getters y Setters
    public ArrayList<Cliente> getCliente() {
        return clientes;
    }
    public void setCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    //Metodos de la clase
    public void agregarCliente(ArrayList<Cliente> clientes){
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scan.nextLine();
        System.out.println("Ingrese la dirección del cliente");
        String direccion = scan.nextLine();
        System.out.println("Ingrese el correo del cliente");
        String correo = scan.nextLine();

        boolean comprobar;
        comprobar = false;

        for (Cliente c1: clientes) {
            if (c1.getNombre().equals(nombre)) {
                comprobar = true;
                break;
            }
        }
        if (comprobar){
            System.out.println("El cliente ya fue agregado.");
        }else{
            Cliente clienteAux = new Cliente(nombre,direccion,correo);
            clientes.add(clienteAux);
        }
        System.out.println("--------------------------------------------------------");
    }
    public void eliminarCliente(ArrayList<Cliente> clientes,ArrayList<Cliente> clientesEliminados) {
        System.out.println("--------------------------------------------------------");
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el correo del cliente que desea eliminar:");
        String correo = scan.nextLine();
        boolean clienteEncontrado = false;
        //escaner de titulo para buscar la obra que se quiere eliminar
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCorreo().equals(correo)) { // si encuentro el correo del cliente lo elimino
                iterator.remove();
                clientesEliminados.add(cliente);//añadir la cliente a lista de clientes eliminados
                clienteEncontrado = true;
                break;
            }
        }
        //mencion si el cliente se elimino correctamente
        if (clienteEncontrado) {
            System.out.println("El cliente se eliminó correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con ese correo.");
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarCliennte(ArrayList<Cliente> clientes){
        System.out.println("--------------------------------------------------------");
        if(clientes.isEmpty()){
            System.out.println("Aún no hay clientes resgistrados");
        }else{
            System.out.println("LISTA DE CLIENTES: "); // Muestro los clientes registrados
            for (Cliente c1: clientes){
                c1.presentarCliente();
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    public void listarClientesEliminados(ArrayList<Cliente> clientesEliminados){
        System.out.println("--------------------------------------------------------");
        if(clientesEliminados.isEmpty()){
            System.out.println("Aún no hay clientes resgistradas");// muestra todos los clientes eliminados con el bucle
        }else{
            for (Cliente cliente: clientesEliminados) {
                cliente.presentarCliente();
            }
        }
    }
    
}
//////////////////////////////////////////////////////////////////////////////////////////
public class Artista {
    private int id;// se crea una variable de id, para que sea mas facil encontrar el artista a eliminar
    private String nombre;
    private String fechaNacimineto;
    private String nacionalidad;
    private String biografia;
    //Constructor
    public Artista(int id, String nombre, String fechaNacimineto, String nacionalidad, String biografia) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
    }
    //Setter & Getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaNacimineto() {
        return fechaNacimineto;
    }
    public void setFechaNacimineto(String fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getBiografia() {
        return biografia;
    }
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    //Methods
    public void presentarArtista(){
        // metodo que ayuda a presentar los artistas
        System.out.println("->ID: "+getId());
        System.out.println("->NOMBRE: "+getNombre());
        System.out.println("->FECHA DE NACIMINETO: "+getFechaNacimineto());
        System.out.println("->NACIONALIDAD: "+getNacionalidad());
        System.out.println("->BIOGRAFIA: "+getBiografia());
        System.out.println("--------------------------------------------------------");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
public class Obra {
    private String titulo;
    private String tecnica;
    private int anioCreacion;
    private double  precio;
    private Artista artista;
    //constructor
    public Obra(String name){

    }
    public Obra( String titulo, String tecnica, int anioCreacion, double precio, Artista artista) {
        this.titulo = titulo;
        this.tecnica = tecnica;
        this.anioCreacion = anioCreacion;
        this.precio = precio;
        this.artista = artista;
    }
    // Getters & Setters

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTecnica() {
        return tecnica;
    }
    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
    public int getAnioCreacion() {
        return anioCreacion;
    }
    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Artista getArtista() {
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    //Methods
    public void presentarObra(){
        // metodo que ayuda a presentar ls obras
        System.out.println("->TITULO: "+getTitulo());
        System.out.println("->TECNICA: "+getTecnica());
        System.out.println("->AÑO DE CREACIÓN: "+getAnioCreacion());
        System.out.println("->PRECIO: "+getPrecio());
        System.out.println("->ARTISTA: "+getArtista().getNombre());
        System.out.println("--------------------------------------------------------");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
public class Cliente {
    private String nombre;
    private String direccion;
    private String correo;
    //Constructor
    public Cliente (String name){}
    public Cliente( String nombre, String direccion, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }
    //Getters & setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    //Methods
    public void presentarCliente(){
        // metodo que ayuda a presentar los clientes
        System.out.println("->NOMBRE: "+getNombre());
        System.out.println("->DIRECCION: "+getDireccion());
        System.out.println("->CORREO: "+getCorreo());
        System.out.println("--------------------------------------------------------");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
import java.time.LocalDate;
public class Compra {
    private LocalDate fecha;
    private Cliente cliente;
    private double precio;
    private Obra obra;

    //Constructor
    public Compra( LocalDate fecha, Cliente cliente, double precio, Obra obra) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.precio = precio;
        this.obra = obra;
    }

    //Getters & Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    // Methods
    public void presentarCompra() {
        // metodo que ayuda a presentar las compras
        System.out.println("FECHA: " + getFecha());
        System.out.println("PRECIO: " + getObra().getPrecio());
        System.out.println("CLIENTE: " + getCliente().getNombre());
        System.out.println("OBRA: " + getObra().getTitulo());
    }
}























































class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}