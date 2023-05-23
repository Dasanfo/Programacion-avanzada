
/* Solución preguntas del parcial
* 1 -> V
* 2 -> V
* 3 -> F
* 4 -> V
* 5 -> V
* 6 -> D. la capacidad de un objeto de ser tratado como uno de varios tipos posibles.
* 7 -> D. la capacidad de un objeto de ser tratado como uno de varios tipos posibles.
* 8 -> D. se utilizan como plantillas para crear subclases concretas.
* 9 -> A. la capacidad de una subclase de proporcionar una implementación diferente para un método heredado de la clase padre.
* 10 -> D. Una clase puede implementar múltiples interfaces al mismo tiempo.
*/
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // CREO ALGUNOS CONJUNTOS
        ConjuntoDeDatosTabular conjunto00 = new ConjuntoDeDatosTabular("Datos de estudiantes",1000,200,5);
        ConjuntoDeDatosImagen conjunto01 =  new ConjuntoDeDatosImagen("Imagenes de satelite",2000,1080,720);
        ConjuntoDeDatosImagen conjunto02 = new ConjuntoDeDatosImagen("Imagenes de satelite",2000,1080,720);
        ConjuntoDeDatosTabular conjunto03 = new ConjuntoDeDatosTabular("Datos de animales",1500,200,10);
        ArrayList <ConjutoDeDatos> conjuntos = new ArrayList<>();
        AnalizadorDeDatos analizadorDeDatos = new AnalizadorDeDatos(conjuntos); // CREO UN OBJETO PARA LLAMAR SUS METODOS
        // AÑADO LOS CONJUTNOS A LA LISTA DE CONJUNTOS
        conjuntos.add(conjunto00);
        conjuntos.add(conjunto01);
        conjuntos.add(conjunto02);
        System.out.println("LISTA INICIAL:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (ConjutoDeDatos c1: conjuntos){// MUESTRO EN PANTALLA EL CONJUTNO USANDO EL METODO ABSTRACTO DESCRIBIR
            System.out.println(c1.describir());
        }
        analizadorDeDatos.agregarConjuntoDeDatos(conjunto03);// AÑADO UN CONJUNTO CON EL METODO AGREGARCONJUTNO
        System.out.println("LISTA DESPUES DE AGREGAR UN CONJUNTO:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (ConjutoDeDatos c1: conjuntos){ // MUESTRO EN PANTALLA EL CONJUTNO USANDO EL METODO ABSTRACTO DESCRIBIR
            System.out.println(c1.describir());
        }
        analizadorDeDatos.eliminarConjuntoDeDatos("Datos de animales"); // ELIMINO UN CONJUNTO CON EL METODO ELIMINAR DE LA CLASE ANALISAR

        System.out.println("LISTA DESPUES DE ELIMINAR UN CONJUNTO:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println(analizadorDeDatos.describirConjuntosDeDatos()); // MUESTRO EN PANTALLA LOS CONJUTNOS CON EL METODO QUE ME DEVUELVE EL ARRAY DE STRING
        
    }
}
///////////////////////////////////////////////////////////////////////
public abstract class ConjutoDeDatos {
    // ATRIBUTOS
    private String nombre;
    private int tamano;
    // CONSTRUCTOR
    public ConjutoDeDatos(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }
    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTamano() {
        return tamano;
    }
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    //METODO ABSTRACTO
    public abstract String describir();
}

///////////////////////////////////////////////////////////////////////
public class ConjuntoDeDatosTabular extends ConjutoDeDatos{
    // ATRIBUTOS
    private int numeroDeColumnas;
    private int numeroDeFIlas;
    // CONSTRUCTOR
    public ConjuntoDeDatosTabular(String nombre, int tamano, int numeroDeFIlas, int  numeroDeColumnas) {
        super(nombre, tamano);
        this.numeroDeFIlas = numeroDeFIlas;
        this.numeroDeColumnas = numeroDeColumnas;
    }
    // GETTERS Y SETTERS
    public int getNumeroDeColumnas() {
        return numeroDeColumnas;
    }

    public void setNumeroDeColumnas(int numeroDeColumnas) {
        this.numeroDeColumnas = numeroDeColumnas;
    }

    public int getNumeroDeFIlas() {
        return numeroDeFIlas;
    }

    public void setNumeroDeFIlas(int numeroDeFIlas) {
        this.numeroDeFIlas = numeroDeFIlas;
    }
    // SOBREESCRIBO EL METODO ABSTACTO DESCRIBIR
    @Override
    public String describir(){ // RETORNO TODOS LOS ATRIBUTOS DE ESTA CLASE
        return "\nNombre: "+getNombre()+ " \nTamaño: "+getTamano()+ " \nTipo: tabular \nFilas: " +getNumeroDeFIlas()+ " \nColumnas: "+ getNumeroDeColumnas()+"\n---------------------------------------------------------------------------------------------------------------";
    }
}
///////////////////////////////////////////////////////////////////////
public class ConjuntoDeDatosImagen extends ConjutoDeDatos{
    // ATRIBUTOS
    private int ancho;
    private int alto;
    // CONSTRUCTOR
    public ConjuntoDeDatosImagen(String nombre, int tamano, int ancho, int alto) {
        super(nombre, tamano);
        this.ancho = ancho;
        this.alto = alto;
    }
    // GETTERS Y SETTERS
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    // SOBREESCRIBO EL METODO ABSTACTO DESCRIBIR
    @Override
    public String describir(){// RETORNO TODOS LOS ATRIBUTOS DE ESTA CLASE
        return "\nNombre: "+getNombre()+ " \nTamaño: "+getTamano()+ "\nTipo: Imagen \nAncho: " +getAncho()+ " \nAlto: "+ getAlto()+"\n---------------------------------------------------------------------------------------------------------------";
    }

}
///////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
public class AnalizadorDeDatos {
    // ATRIBUTOS
    ArrayList<ConjutoDeDatos> conjutoDeDatos;
    // CONSTRUCTOR
    public AnalizadorDeDatos(ArrayList<ConjutoDeDatos> conjutoDeDatos) {
        this.conjutoDeDatos = conjutoDeDatos;
    }
    // GETTERS Y SETTERS
    public ArrayList<ConjutoDeDatos> getConjutoDeDatos() {
        return conjutoDeDatos;
    }
    public void setConjutoDeDatos(ArrayList<ConjutoDeDatos> conjutoDeDatos) {
        this.conjutoDeDatos = conjutoDeDatos;
    }
    //METODOS
    public void agregarConjuntoDeDatos (ConjutoDeDatos conjunto1){ // AGREFO UN CONJUNTO DADO COMO PARAMETRO A LA LISTA DE CONJUNTOS
        conjutoDeDatos.add(conjunto1);
    }
    public void eliminarConjuntoDeDatos (String nombre){ // ELIMINO UN CONJUTNO DADO SU NOMBRE
        boolean eliminado = false; // VARIABLE QUE ME AYUDA A SABER SI EL CONJUNTO FUE ENCONTRADO
        ConjutoDeDatos conjuntoAux = new ConjuntoDeDatosImagen("",0,0,0); // OBJETO QUE ME AYUDARA A ELIMINAR MI CONJUNTO
        for (ConjutoDeDatos c1: conjutoDeDatos){ // BUSCO AL CONJUNTO POR SU NOMBRE EN LA LISTAA DE CONJUNTOS
            if (c1.getNombre().equals(nombre)){
                eliminado = true; // SI LO ENCUENTRO MI VARIABLE ES TRUE
                conjuntoAux = c1;// GUARDO EL CONJUNOT EN MI OBJETO TIPO CONJUNTO
            }
        }
        if (eliminado){ // SI MI VARIABLE ES TRU OSEA SI ENCONTRE EL CONJUNTO POR SU NOMBRE LO ELIMINO
            conjutoDeDatos.remove(conjuntoAux); // ELIMINO EL CONJUNTO
            System.out.println("Se elimino correctamente el conjunto de datos: " +conjuntoAux.getNombre());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public ArrayList<String> describirConjuntosDeDatos(){
        ArrayList<String> conjutoDescribir = new ArrayList<>(); // ARRAY LIST DEL METODO ABSTRACTO DESCRIBIR POR ENDE EL ARRAAY ES DE TIPO STRING
        for (ConjutoDeDatos c1: conjutoDeDatos) { // RECORRO MI LISTA
            conjutoDescribir.add(c1.describir()); // LLAMO A CADA CONJUNTO DE LA LISTA E INVOCO EL METODO PARA ASI POODER GUARDALO EN EL ARRAYLIST
        }
        return conjutoDescribir; // RETORNO EL ARRAY
    }

}
///////////////////////////////////////////////////////////////////////





