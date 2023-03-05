# include <stdio.h>
// fecha: 30/01/2023
// Autor: Daniel Santiago Forero Garcia 
// Problema: "Se tiene un GYM que requiere un sistema informatico para capturar los datos de sus clientes".
// carateristicas: 
//                "se crea un struct para hacer el tipo de dato que capture los datos"
//                "Se  presenta que por cada dato se imprime la pregunta y se captura"


// Creamos un estructura donde creamremos los datos necesarios para el registro del GYM
struct gym{
	char nombre [100]; 
	int edad;
	int id; 
	float mc; // mc = masa corporal 
	char genero[50];
	char correo[50];
	int movil[50];
	int hijos;
	char direccion[100];
	
		
};


int main (){	
		
	int cantidad_usuarios; //  se crea una variable para saber cuantos usuarios van a ingresar 
	printf("Cuantos usuarios desea ingresar: ");
	scanf("%d",&cantidad_usuarios);
	
	struct gym persona[cantidad_usuarios]; // se crea una vector tipo struct para guadar cada usuario 
	
	for (int i=0 ; i<cantidad_usuarios; i++){
		
		printf("Ingrese su nombre: ");
		scanf("%s", &persona[i].nombre);

		printf("Ingrese su edad: ");
		scanf("%d", &persona[i].edad);
	
		printf("Ingrese su ID: ");
		scanf("%d", &persona[i].id);
	
		printf("Ingrese su masa corporal: ");
		scanf("%f", &persona[i].mc);

		printf("Ingrese su genero: ");
		scanf("%s", &persona[i].genero);
		
		printf("Ingrese su direccion: ");
		scanf("%s", &persona[i].direccion);
	
		printf("Ingrese su correo: ");
		scanf("%s", &persona[i].correo);
	
		printf("Ingrese su movil: ");
		scanf("%d", &persona[i].movil);
	
		printf("Ingrese la cantida de hijos que tiene: ");
		scanf("%d", &persona[i].hijos);
			
		if (persona.hijos>0){
			
			
		}
		
		printf("\n ----------------------------------------Su registro fue exitoso----------------------------------------");

		printf("\n NOMBRE: %s \n EDAD: %d \n ID: %d \n MASA CORPORAL: %f \n GENERO: %s \n DIRECCION: %s \n CORREO: %s \n MOVIL: %d \n HIJOS: %d \n ", persona[i].nombre, persona[i].edad, persona[i].id, persona[i].mc , persona[i].genero, persona[i].direccion , persona[i].correo, persona[i].movil, persona[i].hijos);
		
		if (cantidad_usuarios>1){	
			printf("----------------------------------------Ingrese otro usuario-----------------------------------------\n");
		}
 	
	}
	 printf("------------------------------------------------------------------------------------------------------");
	


}
