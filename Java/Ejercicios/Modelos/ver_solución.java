
import java.util.ArrayList;
import java.util.*;

//////////////////////
abstract class Modelo{
  
  private String nombre; 
  private int numeroParametros;

  public Modelo(String nombre, int numeroParametros){
    this.nombre = nombre;
    this.numeroParametros = numeroParametros;
  };

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNumeroParametros() {
    return numeroParametros;
  }

  public void setNumeroParametros(int numeroParametros) {
    this.numeroParametros = numeroParametros;
  }

  public abstract void entrenar();
  
}
/////////////////////////////////////////
public class ModeloLineal extends Modelo{

  private double coeficienteCorrelacion;
  private double errorCuadraticoMedio;

  
  public ModeloLineal(String nombre, int numeroParametros, double coeficienteCorrelacion, double errorCuadraticoMedio){
    super(nombre,numeroParametros);
    this.coeficienteCorrelacion = coeficienteCorrelacion;
    this.errorCuadraticoMedio = errorCuadraticoMedio;
  }

  public double getCoeficienteCorrelacion() {
    return coeficienteCorrelacion;
  }

  public void setCoeficienteCorrelacion(double coeficienteCorrelacion) {
    this.coeficienteCorrelacion = coeficienteCorrelacion;
  }

  public double getErrorCuadraticoMedio() {
    return errorCuadraticoMedio;
  }

  public void setErrorCuadraticoMedio(double errorCuadraticoMedio) {
    this.errorCuadraticoMedio = errorCuadraticoMedio;
  }

  @Override
  public void entrenar(){
  System.out.println("\nEntrenando modelo lineal: " + getNombre());
  System.out.println("Número de parámetros: " + getNumeroParametros());                   
  System.out.println("Coeficiente de correlación inicial: " + getCoeficienteCorrelacion());                       
  System.out.println("Error cuadrático medio inicial: " + getErrorCuadraticoMedio()+"\nEntrenamiento completado.");  
  }
}
////////////////////////////////////////////////
public class ModeloArbolDecision extends Modelo{

  private int profundidaArbol;
  private int cantidadNodos;

  public ModeloArbolDecision(String nombre, int numeroParametros, int profundidaArbol, int cantidadNodos){
    super(nombre,numeroParametros);
    this.profundidaArbol = profundidaArbol;
    this.cantidadNodos = cantidadNodos;
  }

  public int getProfundidaArbol() {
    return profundidaArbol;
  }

  public void setProfundidaArbol(int profundidaArbol) {
    this.profundidaArbol = profundidaArbol;
  }

  public int getCantidadNodos() {
    return cantidadNodos;
  }

  public void setCantidadNodos(int cantidadNodos) {
    this.cantidadNodos = cantidadNodos;
  }

  @Override
  public void entrenar(){
    System.out.println("\nEntrenando modelo de arbol de decision:" +getNombre());
    System.out.println("Numero de parámetros:"+getNumeroParametros());
    System.out.println("Profundidad del arbol:" +getProfundidaArbol());                    
    System.out.println("Numero de nodos hoja:" +getCantidadNodos()+"\nEntrenamiento completado.");                   
  };
}
////////////////
class Validador{

  public Validador(){
  };
  
  public void validarModelo(Modelo m1){
    m1.entrenar();
    if (m1 instanceof ModeloLineal){
      ModeloLineal mAux = (ModeloLineal) m1;
      if (mAux.getCoeficienteCorrelacion() > 0.8 && mAux.getErrorCuadraticoMedio()<0.2){
        System.out.println("El modelo: "+mAux.getNombre()+ " ha pasado la validación.");
      }else{
        System.out.println("El modelo: "+mAux.getNombre()+" no ha pasado la validacion");
      }
    } else if(m1 instanceof ModeloArbolDecision){
      ModeloArbolDecision mAux2 = (ModeloArbolDecision) m1;
      if (mAux2.getProfundidaArbol() < 10 && mAux2.getCantidadNodos() > 5){
        System.out.println("El modelo: "+mAux2.getNombre()+ " ha pasado la validación.");
      }else{
        System.out.println("El modelo: "+mAux2.getNombre()+" no ha pasado la validacion");
      }
    }
  }
}
////////////
class Main {
  public static void main(String[] args) {
    ArrayList<Modelo> modelos = new ArrayList<>();
    Validador v1 = new Validador();
    ModeloLineal modeloLineal = new ModeloLineal("FORK",5,0.2,0.5);
    ModeloArbolDecision modeloArbolDecision = new ModeloArbolDecision("CHAID",3,10,2);

    modelos.add(modeloLineal);
    modelos.add(modeloArbolDecision);

    for (Modelo modelo : modelos) {
      v1.validarModelo(modelo);
    }
  }
}




