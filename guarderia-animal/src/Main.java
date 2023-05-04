import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner para leer los datos por consola
        Scanner sc = new Scanner(System.in);

        //Collection para almacenar los animales. Por el momento todas las especies se almacenan en la misma estructura.
        List<Animal> animales = new ArrayList<>();

        Duenio nuevo = 
        Animal animal1 = new Perro("nombre", 2, );



        //MENU ----------------------------------------------------------------------------------------
        int opcion;

        do {
            imprimirMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarAnimal();
                case 2:
                    retirarAnimal();
                case 3:
                    cantidadAnimalesEnGuarderia();
                case 4:
                    listarAnimalesEnGuarderia();
                case 5:
                    hacerSaludarAnimales();
                case 0:
                    System.out.println("Saliendo del menu...");
                default:
                    if (opcion != 0){
                        System.out.println("Opción inválida, intente de nuevo.");
                        System.out.println();
                    }
            }

        } while (opcion != 0);

    }

    public static void imprimirMenu() {
        System.out.println("Ingrese una opción: ");
        System.out.println("1. Ingresar animal a la guarderia");
        System.out.println("2. Retirar animal de la guarderia");
        System.out.println("3. Calcular cantidad de animales actualmente en la guardería");
        System.out.println("4. Listar todos los animales con todos sus datos");
        System.out.println("5. Hacer saludar a todos los animales de la lista");
        System.out.println("0. Salir");
    }



    public static void ingresarAnimal() {
        System.out.println();
    }

    public static void retirarAnimal() {


    }

    public static void cantidadAnimalesEnGuarderia() {

    }

    public static void listarAnimalesEnGuarderia() {

    }
}

/*
//INTENTE HACER CON SWITCH, pero sin un metodo/funcion "imprimirMenu()" porque no me salìa je
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1. Ingresar animal a la guarderia");
            System.out.println("2. Retirar animal de la guarderia");
            System.out.println("3. Calcular cantidad de animales actualmente en la guardería");
            System.out.println("4. Listar todos los animales con todos sus datos");
            System.out.println("5. Hacer saludar a todos los animales de la lista");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del animal:");
                case 2:
                    System.out.println("Elija el animal que desea retirar:");
                case 3:
                    System.out.println("Actualmente hay" + " animales en la guardería.");
                case 4:
                    System.out.println("Lista de animales en la guardería:");
                case 5:
                    System.out.println(); //SALUDO
                case 0:
                    System.out.println("Saliendo del menu...");
                default:
                    if (opcion != 0){
                        System.out.println("Opción inválida, intente de nuevo.");
                        System.out.println();
                    }
            }
        } while (opcion != 0);

        sc.close();
    }
}*/

