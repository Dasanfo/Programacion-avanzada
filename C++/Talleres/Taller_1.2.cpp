/*
TALLER #1.2
DANIEL SANTIAGO FORERO GARCIA 
14/02/23
*/

#include <iostream>
#include <fstream>

using namespace std;

 struct datos { // se creo una estructura para almacenar la info de los usuarios
 	
	string nombre; 
	string apellido; 
 	int edad;

 }; 
 
 
 datos funcion_recoleccion (); // creo una fucnion para recolectar la info del usuario 
 void funcion_escritura (datos *ptr_info, int cantidad_usuarios); // creo una funcion para escribir la info de del usuario en un archivo 
 
 
 int main (){

	datos *ptr_datos; // creo un apuntador que guarde la direccion de memoria de ¡los usuarios 
	int cantidad_usuarios; // creo una variable para saber cuantos usuarios van a igresar 
	
	cout << "Cuantos usuarios va a ingresar: ";
	cin >> cantidad_usuarios; 
	
	datos usuarios[cantidad_usuarios]; // Creo un vector tipo "datos" del tamaño de los usuarios a ingresar 
	
	ptr_datos = usuarios; // Igualo el puntero con el vector tipo "datos"
	
	for (int i=0 ; i<cantidad_usuarios ; i++){ // Creo un for para guardar la info de os usuarios 
		usuarios [i] = funcion_recoleccion(); // Igualo en vector "usuarios" con la funcion recoleccion para que cada usuario tegna su respectiva info 
	}
	
	funcion_escritura(ptr_datos, cantidad_usuarios); // Llamo la funcion para que me escriba las info de los usuarios en el archivo 
 	
 	
 }
 
 
datos funcion_recoleccion (){
  
  datos *ptr_info; // Creo un puntero tipo "datos"
  datos usuario; // creo una variable tipo "datos"
  
  ptr_info = &usuario; // Igualo el puntero con la variable 
  
  // se pide la info del usuario
  cout << "Ingrese su nombre: "; 
  cin  >> ptr_info -> nombre; 
  
  cout << "Ingrese su apellido: ";
  cin  >> ptr_info -> apellido;
  
  cout << "Ingrese su edad: ";
  cin  >> ptr_info -> edad;
  
  // imprimo la info para que el usuario puede ver una vez mas su info 
  cout << "-" << ptr_info -> nombre << endl;
  cout << "-" << ptr_info -> apellido << endl;
  cout << "-" << ptr_info -> edad << endl;
  
  return usuario; // retorno la variable usuario 
 	
 }
 
 
 void funcion_escritura (datos *ptr_datos, int cantidad_usuarios){
 	
  ofstream archivo("informacion.txt"); // creo el archivo y el nombre del archivo
  
  if (archivo.is_open()){ // Si el usuario abre guardo la info de los usuarios en el archivo 
  	
    for(int i=0 ; i<cantidad_usuarios ; i++){	
    
		archivo << (ptr_datos+i) -> nombre <<endl;   
		archivo << (ptr_datos+i) -> apellido <<endl;
		archivo << (ptr_datos+i) -> edad <<endl;
	
	}

  	
  }	
  else{
     cout<<"error apertura archivo"; // si no se abre me dira que hay un error 
  }
  archivo.close(); // Cierro el archivo 
 	

 }
 
 
