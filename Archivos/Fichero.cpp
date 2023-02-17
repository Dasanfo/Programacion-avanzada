/*
 fecha: 06/02/2023
 Autor: Daniel Santiago Forero Garcia 
 Problema: 
    -Crear una estructura corta para pedir datos basicos del usuario 
    -Crear un lista de palabras a ser usadas aleatoriamente 
    -Almacenar palabras en un fichero 
    -Leer y presentar en pantalla la lectura de un fichero 		    
*/
#include <iostream>
#include <fstream>
#include <ctime>
using namespace std;

// se crea una estructura basica para la captura de datos de los usuarios 

struct datos_usuarios{
	
	string nombre;
	string apellido;
	int edad;
	
};

// se crea un lista, como conjunto de palabras disponibles para jugar 

const string lista_palabras[] = {"Hola", "Manana", "Hoy", "Tarde", "Noche"};

// se crea la funcion principal
int main (){
	// se declaran variables a usar
	int i,j,cantidad;
	// se pide cuantos usuario va a usar
	cout<< "Cuantos usuarios va a ingresar: ";
	cin>> cantidad;	
	// se crea un vector del tamaño de las person 	as a ingresar
	datos_usuarios personas[cantidad];
	// se piden los datos al usuario
	// se escribe sobre un fichero: se usa "ofstream" para almacenar el fichero
	// se crea el objeto de tipo ofstream (digital) junto con el nombre de fichero (fisico)
	
	ofstream fichero_escritura ("fichero01.txt");
	// se debe preguntar si hay espacio en memorio para abirir el fichero 
	if (fichero_escritura.is_open()){
		for (i=0 ; i<cantidad ; i++){
			cout<<" Ingrese su nombre: "; 
			cin >> personas[i].nombre;
			fichero_escritura << personas[i].nombre<<endl;
			cout<<" Ingrese su apellido: ";
			cin >> personas[i].apellido;
			fichero_escritura << personas[i].apellido<<endl;
			cout<<" Ingrese su edad: "; 
			cin>> personas[i].edad;
			fichero_escritura << personas[i].edad <<endl;
		}	
	}
	else {
		cout<< "\nNo tiene permisos de escritura!!";
	}
	cout << "------------------------------------------------------------------";
	// se imprimen los datos del usuario
	for (i=0 ; i<cantidad ; i++){ 
		cout<<"\n Nombre: " << personas[i].nombre;
		cout<<"\n Apellido: "<< personas[i].apellido;
		cout<<"\n Edad: "<< personas[i].edad;
	}	 
	cout << " \n------------------------------------------------------------------";
	
	
	
	
	
	cout << "\n prueba de exito" << endl;
	return 0;
	
}
