/*
FECHA: 13/04/23
NOMBRE: Daniel Santiago Forero Garcia
TEMA: Clases Comparator, Collections y Arrays
PROBLEMA: Crear un fichero (.java), el cual pueda manipular una lista de Jugadores de Ajedrez que han participado en un evento. Los datos son: Nombre, ELO, edad, valorPremio. El ELO representa un valor del tipo entero al igual que el valorPremio. Se requiere una aplicación que se pueda ordenar los jugadores en función de el ELO, de la edad y del valor del premio. Inicialmente, la aplicación deberá presentar la lista de almenos 7 jugadores de forma desordenada. Crear las Clases correspondientes en el fichero (.java).
*/

// Importar librerias correspondientes 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Se crea un clase del jugador para tratar los datos donde estan los atributos y los metodos 
class Player{
  private String name;
  private int age;
  private int elo;
  private int pv; //prize value

  // contructor 
  public Player(String name, int age, int elo, int pv){
    this.name = name;
    this.age = age;
    this.elo  = elo;
    this.pv = pv;
  } 

  public String getName(){
    return name;
  }

  public int getAge(){
    return age;
  }
  
  public int getElo(){
    return elo;
  }
  
  public int getPv(){
    return pv;
  }

  public void setNombre(String name){
    this.name = name;
  }
  public void setAge(int age){
    this.age = age;
  }
  public void setElo(int elo){
    this.elo = elo;
  }
  public void setPv(int pv){
    this.pv = pv;
  }

  public String presentadatos() {
    return "[" +getName() + "," +getAge() + "," +getElo() + "," +getPv() + "]";
  }
} 


class CompareAgePlayer implements Comparator<Player>{
  public int compare (Player player01 ,Player player02){
    return player01.getAge() - player02.getAge();
  }
}
class CompareEloPlayer implements Comparator<Player>{
  public int compare (Player player01 ,Player player02){
    return player01.getElo() - player02.getElo();
  }
}
class ComparePvPlayer implements Comparator<Player>{
  public int compare (Player player01 ,Player player02){
    return player01.getPv() - player02.getPv();
  }
}

public class Main {
  public static void main (String[] args){
    // se crean unos empleados para jugar (arreglo)
    ArrayList<Player> playerList = new ArrayList<Player>();
    // se llena la lista con empleados 
    playerList.add(new Player("Jhon",18,500,10000));
    playerList.add(new Player("Maria",50,800,11000));
    playerList.add(new Player("Juan",31,300,9000));
    playerList.add(new Player("Manuel",11,900,13000));
    playerList.add(new Player("Santiago",32,640,1500));
    playerList.add(new Player("David",15,200,20000));
    playerList.add(new Player("Mateo",40,254,17000));
    // se quiere presentar la lista sin ordenar 
    System.out.println("\nLista de jugadores sin ordenar:");
    for (Player player: playerList){
      System.out.println(player.presentadatos());
    }
    System.out.println("\nLista de jugadores ordenados por edad:") 
    Collections.sort(playerList, new CompareAgePlayer());
    for (Player player: playerList){
      System.out.println(player.presentadatos());
    }
    System.out.println("\nLista de jugadores ordenados por elo:");
    Collections.sort(playerList, new CompareEloPlayer());
    for (Player player: playerList){
      System.out.println(player.presentadatos());
    }
    System.out.println("\nLista de jugadores ordenados por valor del premio:");
    Collections.sort(playerList, new ComparePvPlayer());
    for (Player player: playerList){
      System.out.println(player.presentadatos());
    }
  } 
}