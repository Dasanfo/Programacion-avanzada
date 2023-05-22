/* 
    FECHA: 02/13/23
    NOMBRE: Santiago Forero
    TEMA: Ejercicio tipo parcial 
    PROBLEMA: Hacer un aplicacion que capture los datos de usuarios segun el tipo de cliente.
    El resultado sera el valor a pagar segun la cantidad de canales premium a pagar y conexiones 
    de servicios basicos.
  
       1. Inicialmente el usuario debera digistar el numero de cuenta. 
       2. Existen dos tipos de clientes: r/R (recidencial) y n/N (Negocio).
       3. El valor si es recidencial es igual a 20.7 mas 8.8 veces la cantidad de canales primium.
       4. El valor si es de negocio vendra definido por: 
          - Si la cantidad de conexiones de servicio basicos es mayor a 10
            *El valor es igual a el restante de los 10 (conexiones_servicios_basicos) más 78.9 más 18.7                  veces cantidad_canales_premium.
       5.- Al final se pregunta al usuario si quiere ingresar otro cliente.
*/ 
  
#include <iostream>
#include <vector>
using namespace std;
  
  // Creo la estrcutura de los datos que voy a cpturar.
struct datos{
   int numero_de_cuenta;
   char tipo_cliente;
   int cantidad_canales_primium;
   int cantidad_servicios_basicos;
};
  
int main() {
  
    // Declaro "i" que me va ayudar a saber cuantos usuarios hay 
 int i=0;
    // declaro la "seguir" que me ayudara a detener mi bucle do-while. 
 int seguir;
    
    // Creo un Do-While para que siga pidiendo datos por si el usuario quiere resgistrar un nuevo cliente 
  do{
    // Creo un vector para guadar los datos de cada usuario.
   vector<datos> usuarios;
    // Redefino el tamaño del vector, asi cada vez que ingrese un cliente nuevo el tamaño del vector cambiara.
   usuarios.resize(i+1);
  
   // Capturo los datos del cliente y los guardo en el vector-stuct.
   cout << "\n----BIENVENIDO AL SISTEMA----\n";
  
   cout << "\nIngrese el numero de cuenta: ";
   cin  >> usuarios[i].numero_de_cuenta;
  
   cout << "\nQue tipo de cliente es?: ";
   cin  >> usuarios[i].tipo_cliente;
  
   cout << "\nCuantos canales primium tiene?: ";
   cin  >>  usuarios[i].cantidad_canales_primium;
  
   cout << "\nCuantos canales basicos tiene?: ";
   cin  >> usuarios[i].cantidad_servicios_basicos;
  
   cout << "\nDesea ingresar otro cliente? (1 = SI 0 = NO): ";
   cin  >> seguir;
  
      // Creo una condicion e imprimo el resultado del calculo que debera pagar el cliente residencial.
   if (usuarios[i].tipo_cliente == 'r' || usuarios[i].tipo_cliente == 'R'){      
        cout << "\nEl valor a pagar es: " << (20.7 + (usuarios[i].cantidad_canales_primium * 8.8)); 
   }
      // Creo dos condiciones en la primera imprimo el resultado del calculo que debera pagar el cliente residencial y en la condicon anidada calculo el valor a pagar si lleva mas de 10 cantidades de servicios basicos.
      
  if (usuarios[i].tipo_cliente == 'n' || usuarios[i].tipo_cliente == 'N'){
        if (usuarios[i].cantidad_servicios_basicos > 10) {
          cout << "\nEl valor a pagar es: " << (78.9 + (usuarios[i].cantidad_canales_primium * 18.7) + (usuarios[i].cantidad_servicios_basicos - 10));
        }
 else{
           cout << "\nEl valor a pagar es: " << (78.9 + (usuarios[i].cantidad_canales_primium * 18.7)); 
     }   
}
      
  
      i++;
    }while(seguir==1);
    
  }
  
