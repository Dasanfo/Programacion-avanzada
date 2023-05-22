#include <iostream>
#include <string>
#include <cmath>

using namespace std;

class fecha {
  private:
    int dia;
    int mes;
    int ano;
  public:
    fecha(int d, int m , int a){
      dia = d;
      mes = m; 
      ano = a;
    };
    
    void fecha_de_hoy(){
      if (dia == 27 && mes== 03 && ano == 2023){
        cout <<"hoy es tu cumpleaños"<<endl;
      }else {
        cout << "dia: "<<dia<<endl;
        cout << "mes: "<<mes<<endl;
        cout << "año: "<<ano<<endl;
      }
    }
};


class triangulo{

  private:
    float opuesto;
    float adyacente;
    float hipotenusa;

  public: 
    void pedir_datos(){
      cout<< "Ingrese los datos de un triangulo rectangulo"<<endl;
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
    }
};

class pies{
    private:
      int pies;
      int metros;

    public:
      void pies_a_metros(){
        float aux = 3.28084;
        float resultado;
        cout << "Ingrese los pies:";
        cin  >> pies;
        resultado = pies/aux;
        cout << pies <<" pies son "<<resultado<<" en metros"<<endl;
      }
      void metro_a_pies (){
        float aux = 3.28084;
        float resultado;
        cout << "Ingrese los metros:";
        cin  >> metros;
        resultado = metros * aux;
        cout << metros <<" metros son "<<resultado<<" en pies"<<endl;
      }
    

  
};




int main (){
  int op;
  do{
    cout << "----------BIENVENIDO----------"<<endl;
    
    cout << "1. Fecha"<<endl;
    cout << "2. Calcular hipotenusa"<<endl;
    cout << "3. Pies a metros"<<endl;
    cout << "4. Salir"<<endl;
    cin  >> op;
    
      switch(op){
        
        case 1:{ 
          cout << "------------------------------"<<endl;
          fecha date (27, 03, 2023);
          date.fecha_de_hoy();
          break;
        }
        
        case 2:{
          cout << "------------------------------"<<endl;
          triangulo tr;
          tr.pedir_datos();
          tr.calcular_hipotenusa();
          tr.calcular_altura();
          tr.calcular_perimetro();
          break;
        }

        case 3:{
          cout << "------------------------------"<<endl;
          pies foot;
          foot.pies_a_metros();
          foot.metro_a_pies();
        }
      } 
  }while (op != 4);
}

