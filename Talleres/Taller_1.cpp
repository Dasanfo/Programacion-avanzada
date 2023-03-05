/*
TALLER #1
DANIEL SANTIAGO FORERO GARCIA 
14/02/23
*/


#include <iostream>
#include <stdlib.h>
#include<time.h>
// Llamo las bibliotecas que necesito 
using namespace std;

//creo la funcion para crear los numero aleatorios del vector
int numero_aleatorio(); 


int main(){
	
	srand(time(NULL)); // creo la semilla 
	
	int array[10]; // creo el array de 10 
	int *ptr_array; // creo un puntero 
	
	ptr_array = array; // el puntero señala o apunta al array
	
		
	for (int i = 0; i < 10; i++){
		array[i] =  numero_aleatorio (); // lleno el vector con un for hasta 10 llamando la funcion donde creo los numeros aleatorios 
	}
	
	for (int i = 0; i < 10; i++){
		cout << "numero ["<<i<<"] del array: " << *ptr_array++ <<endl; // imprimo todo el vector con sus respectivos valores 
	}
	
	cout <<"\n";
	
	for (int i = 0; i < 10; i++){
		cout << "direccion ["<<i<<"] del array: " << ptr_array++ <<endl; // imprimo todo el vector con sus respectivas direciones de cada pocicion 
	}
	
}

// funcion que me ayuda a crear retornar el numero aleatorio 
int numero_aleatorio(){
	
	int numero; //vareiable donde almaceno mi numero aleatorio
	
	numero = rand()%26; // llamo a la funcion para que mi variable "numero" obtenga un valor entre 0-25
	 
	return numero; // retorna el numero
}

