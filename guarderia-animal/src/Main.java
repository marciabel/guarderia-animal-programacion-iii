import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner para leer los datos por consola
        Scanner sc = new Scanner(System.in);

        //Collection para almacenar los animales. Por el momento todas las especies se almacenan en la misma estructura.
        List<Animal> animales = new ArrayList<>();

        //Esta función se encarga de cargar animales predeterminados a la lista para poder demostrar el funcionamiento del programa.
        agregarAnimalesIniciales(animales);

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
                    cantidadAnimalesEnGuarderia(animales);
                    sc.nextLine(); sc.nextLine();
                    break;
                }
                case 4: {
                    listarAnimalesEnGuarderia(animales);
                    sc.nextLine(); sc.nextLine();
                    break;
                }
                case 5: {
                    hacerSaludarAnimales(animales);
                    sc.nextLine(); sc.nextLine();
                    break;
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

    }

    //Opciones para imprimir--------------------------------------------------------------------------
    public static void imprimirMenu() {
        System.out.println("Ingrese una opción: ");
        System.out.println("1. Ingresar animal a la guarderia");
        System.out.println("2. Retirar animal de la guarderia");
        System.out.println("3. Calcular cantidad de animales actualmente en la guardería");
        System.out.println("4. Listar todos los animales con todos sus datos");
        System.out.println("5. Hacer saludar a todos los animales de la lista");
        System.out.println("0. Salir");
    }

    public static void imprimirAnimales(List <Animal> animales) {
        for (Animal animal: animales) {
            System.out.println("Posición : " + (animales.indexOf(animal) + 1));
            System.out.println(animal);
            System.out.println("Datos del dueño: ");
            System.out.println("    - Nombre   : " + animal.getDuenio().getNombre());
            System.out.println("    - Nro. DNI : " + animal.getDuenio().getDni());
            System.out.println("    - Direccion: " + animal.getDuenio().getDireccion());

            System.out.println("======================================================");
        }
    }

    //Opciones menu-----------------------------------------------------------------------------------

    //Opcion 1===============================================================================
    public static void ingresarAnimal(List<Animal> animales, Scanner sc) {

        //Carga de datos del animal
        System.out.println("Ingrese la especie del animal: ");
        String especie = sc.next();
        sc.nextLine();
        System.out.println("Ingrese el nombre del animalito: ");
        String nombre = sc.next();
        System.out.println("Ingrese edad del animal: ");
        int edad = sc.nextInt();
        System.out.println("Ingrese nombre del dueño: ");
        String nombreDuenio = sc.next();
        sc.nextLine();
        System.out.println("Ingrese DNI del dueño: ");
        int dni = sc.nextInt();
        System.out.println("Ingrese la direccion donde vive: ");
        String direccion = sc.next();
        sc.nextLine();
        System.out.println("Ingrese el sexo del animal: ");
        char sexoChar = sc.next().charAt(0);
        Sexo sexo = (sexoChar == 'M') ? Sexo.MACHO : Sexo.HEMBRA;
        System.out.println("Ingrese el peso del animal: ");
        double peso = sc.nextDouble();
        sc.nextLine();

        Animal animal;
        Duenio duenio = new Duenio(dni, nombreDuenio, direccion);

        if (especie.equalsIgnoreCase("perro")){
            System.out.println("Ingrese la raza del perro: ");
            String raza = sc.next();
            sc.nextLine();

            animal = new Perro(nombre, edad, duenio, sexo, peso, raza);
            animales.add(animal);
        }
        else if (especie.equalsIgnoreCase("pez")){

            System.out.println("Ingrese de qué tipo de agua es el pez: (salada/dulce");
            String tipoAgua = sc.next();
            sc.nextLine();

            animal = new Pez(nombre, edad, duenio, sexo, peso, tipoAgua);
            animales.add(animal);
        }
        else if (especie.equalsIgnoreCase("gato")){
            animal = new Gato(nombre, edad, duenio, sexo, peso);
        }
        else if (especie.equalsIgnoreCase("hamster")){
            animal = new Hamster(nombre, edad, duenio, sexo, peso);
        }
        else{
            System.out.println("Animal no registrado.");
            System.out.println();

        }
    }

    //Opcion 2===============================================================================
    public static void retirarAnimales(List<Animal> animales, Scanner sc) {
        System.out.println("Seleccione una de las opciones a continuación: ");
        System.out.println("1. Retirar un animalito de la guarderia");
        System.out.println("2. Retirar todos los animalitos de la guarderia");

        int retirarOpcion = sc.nextInt();

        switch (retirarOpcion) {
            case 1: {
                retirarUnAnimal(animales, sc); break;
            }
            case 2: {
                System.out.println("Se retiraran los siguientes animalitos de la guarderia: ");
                imprimirAnimales(animales);

                System.out.println("Confirma la operacion? (S/N)");
                int confirmarOperacion = sc.next().charAt(0);
                if (confirmarOperacion == 'S' || confirmarOperacion == 's' ) {
                    animales.clear();
                    System.out.println("Animalitos retirados con éxito.");
                }
                else {
                    System.out.println("Operacion cancelada");
                }
                break;

            }
            default: {
                System.out.println("Opcion incorrecta, por favor intente de nuevo");
                retirarAnimales(animales, sc);
                break;
            }
        }

    }
    public static void retirarUnAnimal(List<Animal> animales, Scanner sc) {

        int dniDuenio = 0;

        System.out.println("++++++++++++++++++++RETIRAR UN ANIMALITO++++++++++++++++++++");
        System.out.println("Ingrese el DNI del dueño: ");
        try {
            dniDuenio = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("No ha ingresado un DNI valido.");
            sc.nextLine();
            retirarUnAnimal(animales, sc);
        }

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

            if (intentarNuevamente== 'S' || intentarNuevamente == 's') {
                retirarUnAnimal(animales, sc);
            }
            else if (intentarNuevamente == 'N' || intentarNuevamente == 'n') {
                System.out.println("Operacion terminada. Se lo redireccionara al menu principal...");
                sc.nextLine(); sc.nextLine();
            }
            else {
                System.out.println("La opcion ingresada no es correcta. Se lo redireccionara al menu principal...");
                sc.nextLine(); sc.nextLine();
            }
        }
        else {
            while (animalesDuenio.size() > 0) {
                System.out.println("En este momento hay " + animalesDuenio.size() + " animalitos registrados : ");
                for (Animal animal: animalesDuenio) {
                    System.out.println("-------------------------------------");
                    System.out.println("((" + (animales.indexOf(animal) + 1)  + "))");
                    System.out.println(animal);
                }

                Integer indiceRetirarAnimal = null;
                boolean valorInvalido = true;

                do {
                    System.out.println("Cual desea retirar? (Indique según el número de la lista)");

                    try {
                        //Agregar control para que no se exceda del limite de la lista (no out of range)
                        indiceRetirarAnimal = sc.nextInt();
                        valorInvalido = false;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("No ha ingresado indice valido. Intente nuevamente.");
                        sc.nextLine();
                    }
                } while (valorInvalido);

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

    //Opcion 3===============================================================================
    public static void cantidadAnimalesEnGuarderia(List<Animal> animales) {
        System.out.println("En la guarderia hay actualmente " + animales.size() + " animales.");
        System.out.println("Presione enter para volver al menu.");
    }

    //Opcion 4===============================================================================
    public static void listarAnimalesEnGuarderia(List<Animal> animales) {
        System.out.println("______________ANIMALITOS EN LA GUARDERIA______________");
        if (animales.size() > 0) {
            imprimirAnimales(animales);

            System.out.println("");
            System.out.println("Presione enter para volver al menu.");
        }
        else {
            System.out.println("No hay animalitos registrados en la guarderia en este momento.");
        }
    }

    //Opcion 5===============================================================================
    public static void hacerSaludarAnimales(List<Animal> animales) {
        System.out.println("Preparense! A continuación todos nuestros animalitos van a saludar: ");
        for (Animal animal: animales) {
            animal.saludar();
            System.out.println("");
        }

    }

    //====================================================================================================
    //Esta función se utiliza para cargar datos de animales a la lista 'animales' en cuanto comienza la
    //ejecución del programa para demostrar el funcionamiento del mismo.
    public static void agregarAnimalesIniciales(List<Animal> animales) {
        Duenio nuevo1 = new Duenio(123, "Mar", "Calle 1");
        Animal animal1_1 = new Perro("Floki", 6, nuevo1, Sexo.MACHO, 7.2);
        animales.add(animal1_1);
        Animal animal1_2 = new Gato("Kiro", 3, nuevo1, Sexo.HEMBRA, 3.7);
        animales.add(animal1_2);
        Animal animal1_3 = new Gato("Misha", 11, nuevo1, Sexo.HEMBRA, 2.9);
        animales.add(animal1_3);


        Duenio nuevo2 = new Duenio(456, "Pom", "Calle 2");
        Animal animal2_1 = new Perro("Lucho", 4, nuevo2, Sexo.MACHO, 7.8);
        animales.add(animal2_1);
        Animal animal2_2 = new Hamster("Rrrraton", 4, nuevo2, Sexo.MACHO, 1.2);
        animales.add(animal2_2);
        Animal animal2_3 = new Gato("Coco", 4, nuevo2, Sexo.MACHO, 7.8);
        animales.add(animal2_3);
        Animal animal2_4 = new Gato("Juno", 4, nuevo2, Sexo.MACHO, 7.8);
        animales.add(animal2_4);


        Duenio nuevo3 = new Duenio(789, "Pablo", "Calle 3");
        Animal animal3 = new Perro("Rocky", 1, nuevo3, Sexo.MACHO, 12.3);
        animales.add(animal3);

        Duenio nuevo4 = new Duenio(234, "Maria", "Calle 4");
        Animal animal4 = new Perro("Toby", 5, nuevo4, Sexo.MACHO, 9.1);
        animales.add(animal4);

        Duenio nuevo5 = new Duenio(567, "Lucia", "Calle 5");
        Animal animal5 = new Perro("Lola", 2, nuevo5, Sexo.HEMBRA, 11.5);
        animales.add(animal5);

        Duenio nuevo6 = new Duenio(890, "Pedro", "Calle 6");
        Animal animal6 = new Perro("Max", 6, nuevo6, Sexo.MACHO, 8.7);
        animales.add(animal6);

        Duenio nuevo7 = new Duenio(345, "Sofia", "Calle 7");
        Animal animal7 = new Perro("Milo", 3, nuevo7, Sexo.MACHO, 13.2);
        animales.add(animal7);

        Duenio nuevo8 = new Duenio(678, "Carlos", "Calle 8");
        Animal animal8 = new Perro("Coco", 7, nuevo8, Sexo.HEMBRA, 6.4);
        animales.add(animal8);

        Duenio nuevo9 = new Duenio(901, "Laura", "Calle 9");
        Animal animal9 = new Perro("Buddy", 4, nuevo9, Sexo.MACHO, 10.9);
        animales.add(animal9);

        Duenio nuevo10 = new Duenio(432, "Diego", "Calle 10");
        Animal animal10 = new Perro("Mia", 5, nuevo10, Sexo.HEMBRA, 8.2);
        animales.add(animal10);

    }
}
