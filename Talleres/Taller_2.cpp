#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <vector>
#include <cstdlib>

using namespace std;

// creo una struct que contega la info del vector
struct resultados{
  int max;
  int tamano_vector;
  int *puntero_vector;
};

resultados generarVectorAleatorio(int array_aleatorio[]); // funcion que me cree el vector aleatorio
void generar_histograma(resultados valores_principales); // funcion que me ayuda a genera el histograma del vecctor generado en la funcion anterior


int main() {

 resultados valores_principales; // variable tipo struc "resultados" para guardar la info del vector creado en la otra funcion
 int *array_aleatorio_principal = new int [100]; // creo un vector dinamico ya que no se cual va a ser el tamaño de este


 int opcion;// variable para saber que opcion escogio

 cout << ("--BIENVENIDO AL MENU--")<<endl; // le presento el menu
 cout << "1) presentar la generacion del conjunto de numeros aleatorios." <<endl;
 cout << "2) presentar el histograma del conjunto de números aleatorios." <<endl;
 cout << "Que desea hacer?: ";
 cin >> opcion;

 valores_principales = generarVectorAleatorio(array_aleatorio_principal); // Igualo la variable tipo struct con la funcion   que retorna la variable de tipo struct que tiene todo la info del vector aleatorio creado

// creo condiciones para presentar la parte del menu
 if (opcion == 1){
   // Le muestro el vector y  el valor mas grande que este contiene ademas el tamaño del vector
 	cout <<endl;
 	cout <<("--------------------------------------------------------------")<<endl;
 	cout << ("VECTOR: ");

 	for (int i=0 ; i<valores_principales.tamano_vector ; i++){
 		cout << (" ") << valores_principales.puntero_vector[i];
	}
	cout <<endl;

 	cout << ("El TAMANO del array es de: ") << valores_principales.tamano_vector <<endl;
 	cout << ("El valor MAXIMO del vector es: ") << valores_principales.max <<endl;

 }
 else if (opcion == 2){
 	// le imprimo la funcion que esta explicada mas abajo donde se hace el histograma
 	cout <<endl;
 	cout <<("--------------------------------------------------------------")<<endl;
 	cout << ("VECTOR: ");

 	for (int i=0 ; i<valores_principales.tamano_vector ; i++){
 		cout << (" ") << valores_principales.puntero_vector[i];
	}
	cout <<endl;

	generar_histograma(valores_principales);
 }

}



resultados generarVectorAleatorio(int array_aleatorio[]){
  resultados valores_generados;  // creo una variable tipo struct para guardar la info del vetor
  valores_generados.tamano_vector = 0;
  valores_generados.max = 0;

  cout << "Ingrese el tamano del vector: ";
  cin >> valores_generados.tamano_vector;
  cout <<("--------------------------------------------------------------")<<endl;
  //Se crea la semilla de aleatoriedad
  srand(time(NULL));

  int numero;

  // Lleno el vector con valores aleatorios creados por la funcion rand
  for (int i = 0 ; i < valores_generados.tamano_vector; i++){
    numero = rand()%21;
    array_aleatorio[i] = numero;
    //cout << " " << array_aleatorio[i];
  }


  cout<<endl;

  int numero_max=0;
  numero_max=array_aleatorio[0];

  // compara cada valor del vector para asi mirar cual es el valor maximo
  for (int j = 0 ; j < valores_generados.tamano_vector; j++){
    if (numero_max<array_aleatorio[j]){
    	numero_max=array_aleatorio[j];
	}
  }

 valores_generados.max = numero_max; // guardo el valor maximo en la variable tipo struct
 valores_generados.puntero_vector = array_aleatorio;  // guardo el valor maximo en la variable tipo struct


  return valores_generados; // retorno la variable tipo struct que contiene toda la info del vetor
}


void generar_histograma(resultados valores_principales){
	// imprimo el vector creado en la funcion anterior
	cout <<("--------------------------------------------------------------")<<endl;
 	cout << ("VECTOR: ");

 	for (int i=0 ; i<valores_principales.tamano_vector ; i++){
 		cout << (" ") << valores_principales.puntero_vector[i];
	}
	cout <<endl;



	// creo un  vector dinamico que contendra el numero de veces que se repite cada numero
	int *contador= new int [100];
	vector <int> numeros; // creo un vector donde guardop los numeros que ya fueron contados para que no se cuenten dos veces

  // lo primero que hace esta parte final del coidigo es:
  // primero comprueba si el numero ya fue contado
  // segundo si el valor no fue contado, lo cuaeta y lo guarda
	for (int i = 0 ; i < valores_principales.tamano_vector ; i++){
		bool repetido = false;
		for (int j = 0 ; j < numeros.size() ; j++){
			if (valores_principales.puntero_vector[i] == numeros[j]){
				repetido = true ;
			}
		}
		if (repetido == false){
			numeros.push_back(valores_principales.puntero_vector[i]);
			for (int g = 0 ; g < valores_principales.tamano_vector ; g++){
				if (valores_principales.puntero_vector[i] == valores_principales.puntero_vector[g]){
					contador[i]+= 1;
				}
			}
		}
		else{
			contador[i] = 0;
		}
	}

// muestro el indice del vector ademas de los numeros unicos del vetor aleatorio y la cantidad de veces que se reíte con *
	int indice = 1;
    cout <<"Indice:\t""Numero:\tHistograma:"<<endl;

    for(int f = 0; f < valores_principales.tamano_vector; f++){//Muestra el número de veces que aparece cada número en el arreglo por medio de un histograma.
      if(contador[f]>0){
         cout <<indice<<"\t\t"<<valores_principales.puntero_vector[f]<<"\t\t";
         for(int p = 0; p < contador[f]; p++){
        	cout << "*";
         }
          cout<<endl;
          indice++;
  		}
	}
	cout<<endl;
    delete[] contador;
}
