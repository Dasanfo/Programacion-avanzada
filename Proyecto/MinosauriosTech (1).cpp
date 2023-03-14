/*
* Autores: Gabriela_Santiago_Andres
*   Fecha: 1-3-2023
    Tema: Proyecto de Aula de Clases
    Materia Programación Avanzada
    Empresa Minosaurios Tech, solicita registro de sus empleados.
    La estructura de datos Empleado:
 
    - Codigo numerico
    - Nombres
    - Apellidos
    - Celular
Funciones:
- Registrar empleados: se debe almacenar en un fichero binario "Empleados.Bin"
- Agregar nuevos empleados: se verifica que el empleado no este, la información se adiciona al final del fichero.
- Mostrar Los empleados registrados: Se imprime en pantalla los empleados en orden alfabético.
- Cambiar el número de móvil del empleado: con el código del empleado, si existe, se modifica.
- Despedir empleado: con el código, si existe, se elimina del binario. Se genera una carta de despido.txt
- Mostrar empleados que han sido despedidos: se presenta un vector con los empleados despedidos
*/
//librerias para usar en el código

#include <iostream>
#include <fstream>
#include <vector>
#include <string.h>

using namespace std;
//Se crea una estructura para la informacion de los usuarios 
struct s_empleado{
  int codigo;
  char nombre [50];
  char apellido [50];
  long long celular;
};
//funciones para ejercutar durante el código
void registrar_empleados();
void mostrar_empleados();
void registrar_nuevos_empleados();
void cambiar_celular();
void eliminar_empleado();
void mostrar_empleados_despedidos();
//arregro tipo estructura de 100 casillas
s_empleado array_principal [100];
vector <s_empleado> v_eliminados;
//vector donde se guardara los codigos de archivo

int main(){
//variable para usar en el switch
  int opcion;
     //se da la bienvenida al programa
    cout << "---------------------------------------------------------------------" << endl;
    cout << "\t \t            Bienvenido a Minosaurios Tech   \t \t" << endl;
    cout << "---------------------------------------------------------------------" << endl;
  while(opcion != 7){
    // se crea un menu para las 7 opciones
    cout <<endl;
    cout << "--------------------MENU---------------------" << endl;
    cout<<"1.Registrar usuarios"<<endl;
    cout<<"2.Agregar nuevos empleados"<<endl;
    cout<<"3.Mostrar los empleados registrados"<<endl;
    cout<<"4.Cambiar el número de celular de un empleado"<<endl; 
    cout<<"5.Despedir a un empleado"<<endl;
    cout<<"6.Mostrar empleados que sido despedidos "<<endl;
    cout<<"7.Salir"<<endl;
    cout<< "----------------------------------------------" << endl;
    cout<<"Que desea hacer?: ";
    cin >> opcion;
    cout<< "----------------------------------------------" << endl;
    
      switch(opcion){
        case 1:  
            registrar_empleados();
          break;
        case 2:
            registrar_nuevos_empleados();
          break;
        case 3:
            mostrar_empleados();
          break;
        case 4:
            cambiar_celular();
          break;
        case 5:  
            eliminar_empleado();
        break;
        case 6:    
            mostrar_empleados_despedidos();
          break; 

      }
  }
}

void registrar_empleados(){
  int tamano;
  ofstream archivo_binario;
  
  archivo_binario.open("Empleados.bin",ios::binary | ios::app);  //se abre el archivo tipo binario se usa app para agregar datos
  cout << "Cuantos empleados desea registrar?: "; 
  cin  >> tamano; //cantidad de empleados que se registraran, se guarda
  cout <<endl;
  
  if (archivo_binario.is_open()){  //se comprueba que el archivo se abra de forma correcta
    for (int i = 0 ; i < tamano ; i ++){ //ciclo para pedir los datos y llenar el arreglo
      cout << "Código del empleado   ["<< i+1 <<"]: ";
      cin  >> array_principal[i].codigo;
      cout << "Nombre del empleado   ["<< i+1 <<"]: ";
      cin  >> array_principal[i].nombre;
      cout << "Apellido del empleado ["<< i+1 <<"]: ";
      cin  >> array_principal[i].apellido;
      cout << "celular del empleado  ["<< i+1 <<"]: ";
      cin  >> array_principal[i].celular; 
      cout << endl; 
      
      archivo_binario.write((char*)&array_principal[i], sizeof(s_empleado)); //se escribe los datos que se tomaron dentro del archivo binario.Es decir lo que esta en array_principal[].
    }
  }
  else {
    cout << "El archivo no se pudo abrir"; //por si el archivo no se pudo abrir
  }
  archivo_binario.close();//se cierra el archivo
}

void mostrar_empleados(){
  ifstream archivo_binario;
  s_empleado empleado_aux;
  vector <s_empleado> empleados; // Se crea un vector para almacenar los empleados

  archivo_binario.open("Empleados.bin", ios::binary);
  if (archivo_binario.is_open()){//si el archivo está abierto, que se lea.
    //El archivo se recorrera la variable que tiene los datos esto lo hará hasta que llegue al dato final del archivo
  while(archivo_binario.read((char*)&empleado_aux, sizeof(s_empleado))){
      //Se agregan los datos al final del vector tipo estructura.
      empleados.push_back(empleado_aux); // Se agrega el empleado al vector
    }
    archivo_binario.close();

    // Se ordenan los empleados alfabéticamente por apellido
    for(int i = 0; i < empleados.size(); i++){
      for(int j = i + 1; j < empleados.size(); j++){//se usa la funcion de comparrar cadenasde caracteres
        if(strcmp(empleados[j].nombre, empleados[i].nombre) < 0){
          empleado_aux = empleados[i];
          empleados[i] = empleados[j];
          empleados[j] = empleado_aux;
        }
      }
    }

    // Se imprime la información de los empleados ordenados hasta el tamaño final de archivo 
    cout <<"Empleados registrados:"<< endl;
    cout <<endl;
    for (int i = 0; i < empleados.size(); i++){
      cout << "Código: "   << empleados[i].codigo << endl;
      cout << "Nombre: "   << empleados[i].nombre << endl;
      cout << "Apellido: " << empleados[i].apellido << endl;
      cout << "Celular: "  << empleados[i].celular << endl;
      cout << "------------------------" << endl;
    }
  }
  else {
    cout << "El archivo no se pudo abrir" << endl;
  }
}

void registrar_nuevos_empleados(){
  int tamano2;
  ofstream archivo_binario;
  //se abre el archivo
  archivo_binario.open("Empleados.bin",ios::binary | ios::app);

  if (archivo_binario.is_open()){
    //se pregunta la cantidad de empleados nuevos
    cout << "Cuantos empleados nuevos va a ingresar?: ";
    cin >> tamano2;
    cout <<endl;
    //variable boleana iniciaoizada en falso
    bool repetido = false;
    for (int i = 0 ; i < tamano2; i++){
      cout << "Código del empleado ["<< i+1 <<"]: ";
      cin  >> array_principal[i].codigo;
      cout << "Nombre del empleado ["<< i+1 <<"]: ";
      cin  >> array_principal[i].nombre;
      cout << "Apellido del empleado ["<< i+1 <<"]: ";
      cin  >> array_principal[i].apellido;
      cout << "celular del empleado ["<< i+1 <<"]: ";
      cin  >> array_principal[i].celular; 
      cout << endl;

      //se escribe en el archivo lo que esta en la variable de array_principal[i]
      archivo_binario.write((char *)&array_principal[i], sizeof(s_empleado));   

    }
    
  }else {
    cout << "No se abrio el archio";
  }
  archivo_binario.close();
}

void cambiar_celular(){
  fstream archivo_binario;
  s_empleado empleado_aux;
  int codigo;
  int celular; 
  archivo_binario.open("Empleados.bin",ios::binary | ios::in | ios::out);
  
  if (archivo_binario.is_open()){
  //se pide el codigo de la persona a la que se le quiere cambiar el nuemro telefónico 
    cout <<"Ingrese el código del empleado al cual editará: ";
    cin  >> codigo;
    //lea el archivo
    while (archivo_binario.read((char *)&empleado_aux, sizeof(s_empleado))){
// se compara la variable que entró (código) en el archivo para ver si existe o no 
      if (empleado_aux.codigo == codigo){
        cout << "El empleado a editar es: "<<empleado_aux.nombre<<endl;
        cout << "Ingrese el nuevo celular de "<<empleado_aux.nombre<<": ";
        cin >> celular;
        //se guarda el nuevo celular en empleado_aux.celukar.
        empleado_aux.celular=celular;
        //seekp accede a la poscicion actual y modifica lo que había ahí.
        archivo_binario.seekp(-sizeof(s_empleado), ios::cur);
        //se escribe en el archivo
        archivo_binario.write((char *)&empleado_aux, sizeof(s_empleado));
      }
    }
  }
}

void eliminar_empleado(){
  fstream archivo_binario;
  //variable para el archivo de texto.
  ofstream archivo_despedidos("carta_de_despido.txt");
  fstream archivo_vector_despedidos;
  s_empleado empleado_aux;
  
  //variable vacia tipo estructura
  s_empleado empty = {0,"","",0};
  int codigo;
  cout<<"Ingrese el codigo del empleado a despedir: ";
  cin >> codigo;
  cout<<"El empleado fue despedido exitosamente";
  //se abre el archivo
  archivo_binario.open("Empleados.bin",ios::binary | ios::in | ios::out);
  archivo_vector_despedidos.open("Empleados_despedidos", ios :: in | ios :: binary | ios::app);
  
  if (archivo_binario.is_open()){
    while (archivo_binario.read((char *)&empleado_aux, sizeof(s_empleado))){
      if (empleado_aux.codigo == codigo){ // si se encuetraa el codigo de la persona a eliminar continue
        archivo_vector_despedidos.write((char *)&empleado_aux, sizeof(s_empleado)); // se escribe a ese empleado en un nuevo archivo
        v_eliminados.push_back(empleado_aux); //se llena el vector "v_eliminados" que es global con los usuarios que se van a despedi 
        archivo_despedidos << "Estimad@ "<< empleado_aux.nombre <<endl;// se escribe sobre el arrchivo de texto la carta de despido y ek nombre la persona que se despedió.
        archivo_despedidos <<endl;
        archivo_despedidos << "La empresa Minosaurio Tech ha estado valorando su rendimiento profesional y lamentablemente se tomó la decisión de calcelar el contrato de trabajo con usted, así que con efecto inmediato, su empleo con nuestra empresa llegará a su fin. "<<endl;
        archivo_despedidos <<"De antemano agradecemos el servicio prestado en nuestra empresa Minosaurios Tech"<<endl;
        archivo_despedidos <<endl;
        archivo_despedidos << "Atentamente,"<<endl;
        archivo_despedidos << " Minosaurios Tech";
        //seekp accede a la poscicion actual y busca.
        archivo_binario.seekp(-sizeof(s_empleado), ios::cur);
        //En el archivo en la poscicon que se elimino se llena del arreglo vacio.
        archivo_binario.write((char *)&empty,sizeof(s_empleado));
      }  
    }
  }
  archivo_binario.close();
}
//funcion para mostrar los empleados eliminados
void mostrar_empleados_despedidos(){
  //se ceea archivo para guardar las personas que han sido despedidas en consola
  fstream archivo_vector_despedidos;
  s_empleado empleado_aux;
  //vector para guardar personas despedida
  vector <s_empleado> empleado_despedidos;
  //se abre archivo
  archivo_vector_despedidos.open("Empleados_despedidos", ios :: in | ios :: binary | ios::out);

  if (archivo_vector_despedidos.is_open()){
  //como este archivo está abierto se leerá hasta empleado_aux hasta el tamaño de este.
    while(archivo_vector_despedidos.read((char *)&empleado_aux, sizeof(s_empleado))){
      //se añaden los datos al archivo en la ultima poscicion que haya información 
      empleado_despedidos.push_back(empleado_aux);
    }
  }
//este ciclo va hasta el tamaño de empleado_despedidos
  for (int i = 0 ; i < empleado_despedidos.size() ; i++){
    cout << "Código: " << empleado_despedidos[i].codigo << endl;
    cout << "Nombre: " << empleado_despedidos[i].nombre << endl;
    cout << "Apellido: " << empleado_despedidos[i].apellido << endl;
    cout << "Celular: " << empleado_despedidos[i].celular << endl;
    cout << "------------------------" << endl;
  }
  archivo_vector_despedidos.close(); 
}
//el programa va hasta aquí. // para ningun inconveniente comlie el codigo en replit
