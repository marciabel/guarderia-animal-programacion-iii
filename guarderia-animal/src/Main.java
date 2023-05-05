import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner para leer los datos por consola
        Scanner sc = new Scanner(System.in);

        //Collection para almacenar los animales. Por el momento todas las especies se almacenan en la misma estructura.
        List<Animal> animales = new ArrayList<>();

        Duenio nuevo = new Duenio(398, "mar", "dire");
        Animal animal1 = new Perro("nombre", 2, nuevo, Sexo.HEMBRA, 14.5);

        animales.add(animal1);

        //MENU ----------------------------------------------------------------------------------------
        int opcion;

        do {
            imprimirMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    ingresarAnimal(animales, sc); break;
                }
                case 2: {
                    retirarAnimales(animales, sc); break;
                }
                case 3: {
                    cantidadAnimalesEnGuarderia(animales, sc);
                    break;
                }
                case 4: {
                    listarAnimalesEnGuarderia(animales, sc); break;
                }
                case 5: {
                    hacerSaludarAnimales(animales, sc); break;
                }
                case 0: {
                    System.out.println("Saliendo del menu..."); break;
                }
                default: {
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
                }
            }

        } while (opcion != 0);

        System.out.println(animales);

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



    public static void ingresarAnimal(List<Animal> animales, Scanner sc) {

        System.out.println("Ingrese la especie del animal: ");
        String especie = sc.nextLine();
        System.out.println("Ingrese el nombre del animalito: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese edad del animal: ");
        int edad = sc.nextInt();
        System.out.println("Ingrese nombre del dueño: ");
        String nombreDuenio = sc.nextLine();
        System.out.println("Ingrese DNI del dueño: ");
        int dni = sc.nextInt();
        System.out.println("Ingrese la direccion donde vive: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el sexo del animal: ");
        char sexoChar = sc.nextLine().charAt(0);
        Sexo sexo = (sexoChar == 'M') ? Sexo.MACHO : Sexo.HEMBRA;
        System.out.println("Ingrese el peso del animal: ");
        double peso = sc.nextDouble();

        if (especie.toLowerCase() == "perro"){
            System.out.println("Ingrese la raza del perro: ");
            String raza = sc.nextLine();

            Duenio duenio = new Duenio(dni, nombreDuenio, direccion);
            Perro perro = new Perro(nombre, edad, duenio, sexo, peso, raza);
            animales.add(perro);
        }
        else if (especie.toLowerCase() == "pez"){

            Duenio duenio = new Duenio(dni, nombreDuenio, direccion);
            System.out.println("Ingrese de qué tipo de agua es el pez: (salada/dulce");
            String tipoAgua = sc.next();

            Pez pez = new Pez(nombre, duenio, sexo, tipoAgua);
            animales.add(pez);

        }

    }

    public static void retirarAnimales(List<Animal> animales, Scanner sc) {
        System.out.println("Seleccione una de las opciones a continuación: ");
        System.out.println("1. Retirar un animalito de la guarderia");
        System.out.println("2. Retirar todos los animalitos de la guarderia");

        int retirarOpcion = sc.nextInt();

        switch (retirarOpcion) {
            case 1: {
                retirarUnAnimal(animales, sc);
            }
            case 2: {

            }
            default: {
                System.out.println("Opcion incorrecta, por favor intente de nuevo");
                retirarAnimales(animales, sc);
            }
        }

    }
    public static void retirarUnAnimal(List<Animal> animales, Scanner sc) {

        int dniDuenio;

        System.out.println("++++++++++++++++++++RETIRAR UN ANIMALITO++++++++++++++++++++");
        System.out.println("Ingrese el DNI del dueño: ");
        dniDuenio = sc.nextInt();
        
        Duenio duenio;
        List<Animal> animalesDuenio = new ArrayList<>();

        for (Animal animal:animales) {
            if (animal.getDuenio().getDni() == dniDuenio) {
                animalesDuenio.add(animal);
                duenio = animal.getDuenio();
            }
        }

        if (animalesDuenio.size() == 0) {
            System.out.println("El dni indicado no existe o no tiene animalitos registrados en la guarderia.");

            System.out.println("Desea intentar de nuevo? (S/N)");
            char intentarNuevamente =  sc.next().charAt(0);

            if (intentarNuevamente == 'S' || intentarNuevamente == 's') {
                retirarUnAnimal(animales, sc);
            }
        }
        else {
            while (animalesDuenio.size() > 0) {
                System.out.println("En este momento hay " + animalesDuenio.size() + " animalitos registrados : ");
                for (Animal animal: animales) {
                    System.out.println("-------------------------------------");
                    System.out.println("((" + (animales.indexOf(animal) + 1)  + "))");
                    System.out.println(animal);
                }

                System.out.println("Cual desea retirar? (Indique según el número de la lista)");
                int indiceRetirarAnimal = sc.nextInt();

                animales.remove(animalesDuenio.get(indiceRetirarAnimal-1));
                animalesDuenio.remove(indiceRetirarAnimal-1);
                System.out.println("El animalito fue retirado con éxito!");

                if (animalesDuenio.size() > 0) {
                    System.out.println("Desea retirar otro animalito? (S/N)");
                    char retirarOtroAnimal =  sc.next().charAt(0);
                    if (retirarOtroAnimal == 'N' || retirarOtroAnimal == 'n') {
                        break;
                    }
                }
                else {
                    System.out.println("No tenemos más animalitos registrados para este dueño! Presione enter para volver al menu.");
                    sc.nextLine(); sc.nextLine();
                }
            }
        }
    }

    public static void cantidadAnimalesEnGuarderia(List<Animal> animales, Scanner sc) {
        System.out.println("En la guarderia hay actualmente " + animales.size() + " animales.");
        System.out.println("Presione enter para volver al menu.");
        sc.nextLine(); sc.nextLine();
    }

    public static void listarAnimalesEnGuarderia(List<Animal> animales, Scanner sc) {
        System.out.println("______________ANIMALITOS EN LA GUARDERIA______________");
        for (Animal animal: animales) {
            System.out.println("Posición : " + animales.indexOf(animal) + 1);
            System.out.println(animal);
            System.out.println("Datos del dueño: ");
            System.out.println("    - Nombre   : " + animal.getDuenio().getNombre());
            System.out.println("    - Nro. DNI : " + animal.getDuenio().getDni());
            System.out.println("    - Direccion: " + animal.getDuenio().getDireccion());

            System.out.println("======================================================");
        }

        System.out.println("");
        System.out.println("Presione enter para volver al menu.");
        sc.nextLine(); sc.nextLine();

    }

    public static void hacerSaludarAnimales(List<Animal> animales, Scanner sc) {
        System.out.println("Preparense! A continuación todos nuestros animalitos van a saludar: ");
        for (Animal animal: animales) {
            animal.saludar();
            System.out.println("");
        }

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
                    Te quiero mar
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

