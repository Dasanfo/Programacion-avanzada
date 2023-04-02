#include <iostream>
#include <string>
#include <cmath>
using namespace std;

class triangulo{
  private:
    float opuesto;
    float adyacente;
    
  public: 
    float hipotenusa;

    void pedir_datos(){
      
      cout<< "-> Ingrese los datos de un triangulo rectangulo"<<endl;
      cout<< "Ingrese el cateto opuesto: ";
      cin >> opuesto;
      cout<< "Ingrese el cateto adyacente: ";
      cin >> adyacente;
    }
  
    void calcular_hipotenusa (){
      hipotenusa = sqrt(pow (opuesto,2) + pow(adyacente,2));
      cout <<"La hipoteenusa del triangulo es: "<< hipotenusa<<endl;
    }

    void calcular_altura (){
      cout << "La altura de triangulo rectangulo es: "<< adyacente <<endl;
    }

    void calcular_perimetro(){
      int perimetro;
      perimetro = adyacente + hipotenusa + opuesto;
      cout <<"El perimetro del triangulo es: "<<perimetro<<endl;
    }
};

class circulo {
  private:
    float radio;
  public: 
    float pi = 3.13;
    void pedir_datos(){
      cout << "Ingrese el radio del circulo: ";
      cin  >> radio;
    }
    void calcular_area(){
      int area = pi*pow(radio, 2);
      cout << "El area del circlo es: "<<area<<endl;
    }
    void calcular_perimetro(){
      int perimetro;
      perimetro = pi *(2*radio);
      cout << "El perimetro del circulo es: "<<perimetro<<endl;
    }
    void calcular_diametro(){
      int diametro;
      diametro = 2*radio;
      cout << "El diametro del circulo es: "<<diametro<<endl;
    }
};

class persona{
  protected:
    string nombre;
    int edad;
    int curso;
    string profesion;

  public:
    void pedir_datos(){
      cout<< "Ingrese su nombre: ";
      cin >> nombre;
      cout<< "Ingrese su edad: ";
      cin >> edad;
    } 
    void presentase(){
      cout << "Mi nombre es "<< nombre<< ", tengo "<< edad<<" años. Me encanta aprender cosas nuevas y estar en constante crecimiento. Siempre he sentido una gran pasión por la tecnología y me gusta mucho explorar nuevas ideas y perspectivas"<<endl;
    }
};

class estudiante : public persona {

    public:
      void pedir_datos(){
      cout<< "Ingrese su nombre: ";
      cin >> nombre;
      cout<< "Ingrese su edad: ";
      cin >> edad;
      cout<< "Ingrese su curso: ";
      cin >> curso;
    } 
   
    void inscribir_prgramacion(){
      int op;
      if (curso >=9){
        cout <<"-> Usted es apto para inscribir la materia de programacion."<<endl;
        cout << "Desea inscribirla?"<<endl;
        cout <<"1 = si"<<endl;
        cout <<"2 = no "<<endl;
        cin  >> op;
        if (op = 1){
          cout <<"Inscribio exitosamente la materia de programacion"<< endl;
        }
      }
      
      
    }
};

class profesor : public persona{
  public:
    void pedir_datos(){
      cout<< "Ingrese su nombre: ";
      cin >> nombre;
      cout<< "Ingrese su edad: ";
      cin >> edad;
      cout<< "Ingrese su profesion: ";
      cin >> profesion;
    } 
    void presentar_profesion() {
        cout << "En mi curso vamos a aprender sobre " << profesion << " desde los fundamentos hasta los temas más avanzados.\n";
        cout << "A lo largo del curso, veremos cómo crear programas utilizando " << profesion << " y cómo resolver problemas utilizando las herramientas que nos brinda esta disciplina.\n";
        cout << "Además, repasaremos algunos conceptos de matemáticas y lógica que son fundamentales para entender bien " << profesion << ".\n";
        cout << "Al final del curso, tendrás las herramientas necesarias para desarrollar programas de " << profesion << " de forma autónoma y resolver problemas complejos utilizando las herramientas que te brinda esta disciplina.\n";
    }
};

int main (){
  int op;
  do{  
    cout << "----------------BIENVENIDO------------------"<<endl;
    cout << "1. Calculos de un triangulo"<<endl;
    cout << "2. Calculos de un circulo"<<endl;
    cout << "3. Persona"<<endl;
    cout << "4. Estudiante"<<endl;
    cout << "5. Profesor"<<endl;
    cout << "6. Salir"<<endl;
    cin  >> op;
    
    
      switch(op){
        
        case 1:{ 
          cout <<"--------------------------------------------"<<endl;
          triangulo tr;
          tr.pedir_datos();
          cout <<endl;         
          int op;
          do{
            cout <<"-> Qué desea hacer?"<<endl;
            cout <<"1. Hallar el perimetro"<<endl;
            cout <<"2. Hallar la hipotenusa"<<endl;
            cout <<"3. Hallar la altura " <<endl;
            cout <<"4. Salir"<<endl;
            cin  >> op;
            cout <<"--------------------------------------------"<<endl;         
            switch(op){
              case 1:{
                tr.calcular_perimetro();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
              case 2:{
                tr.calcular_hipotenusa();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
              case 3:{
                tr.calcular_altura();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
            }
          }while (op != 4);
        break;
        }
        
        case 2:{
          cout <<"--------------------------------------------"<<endl; 
          circulo cr;
          cr.pedir_datos();
          cout <<"--------------------------------------------"<<endl; 
          int op;
          do{
            cout <<"-> Qué desea hacer?"<<endl;
            cout <<"1. Hallar el perimetro"<<endl;
            cout <<"2. Hallar la area"<<endl;
            cout <<"3. Hallar la diametro "<<endl;
            cout <<"4. Salir"<<endl;
            cin  >> op;
            cout <<"--------------------------------------------"<<endl; 
            switch(op){
              case 1:{
                cr.calcular_perimetro();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
              case 2:{
                cr.calcular_area();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
              case 3:{
                cr.calcular_diametro();
                cout <<"--------------------------------------------"<<endl; 
                break;
              }
            }
          }while (op!=4);
        break;
        }

        case 3:{
         cout <<"--------------------------------------------"<<endl; 
          persona persona1;
          persona1.pedir_datos();
          cout <<"--------------------------------------------"<<endl; 
          persona1.presentase();
          cout <<"--------------------------------------------"<<endl; 
        break; 
        }
        case 4:{
          int op;
          cout <<"--------------------------------------------"<<endl; 
          estudiante estudent;
          estudent.pedir_datos();
          cout <<"--------------------------------------------"<<endl; 
          estudent.presentase();
          cout <<"--------------------------------------------"<<endl; 
          estudent.inscribir_prgramacion();
          cout <<"--------------------------------------------"<<endl; 
          break;
        }
        case 5:{
          int op;
          cout <<"--------------------------------------------"<<endl;
          profesor profesor1;
          profesor1.pedir_datos();
          cout <<"--------------------------------------------"<<endl; 
          profesor1.presentase();
          cout <<"--------------------------------------------"<<endl; 
          cout <<"Desea conocer el curso que doy?: "<<endl;
          cout << "1. Si"<<endl;
          cout << "2. No"<<endl;
          cin  >> op;
          if (op == 1){
            profesor1.presentar_profesion();
          }
        }
      } 
  }while(op != 6);


  
}










