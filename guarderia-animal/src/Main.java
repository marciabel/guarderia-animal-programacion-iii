import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        //Collection para almacenar los animales. Por el momento todas las especies se almacenan en la misma estructura.
        List<Animal> animales = new ArrayList<>();

        //Esta función se encarga de cargar animales predeterminados a la lista para poder demostrar el funcionamiento del programa.
        agregarAnimalesIniciales(animales);

        //MENU ----------------------------------------------------------------------------------------
        Integer opcion;

        do {
            imprimirMenu();

            opcion = LeerConsola.leerInteger();
            if (Objects.isNull(opcion)) {break;}

            switch (opcion) {
                case 1: {
                    ingresarAnimal(animales);
                    System.out.println("Presione enter para continuar...");
                    LeerConsola.saltoLinea();
                    break;
                }
                case 2: {
                    retirarAnimales(animales);
                    System.out.println("Presione enter para continuar...");
                    LeerConsola.saltoLinea();
                    break;
                }
                case 3: {
                    cantidadAnimalesEnGuarderia(animales);
                    System.out.println("Presione enter para continuar...");
                    LeerConsola.saltoLinea();
                    break;
                }
                case 4: {
                    listarAnimalesEnGuarderia(animales);
                    System.out.println("Presione enter para continuar...");
                    LeerConsola.saltoLinea();
                    break;
                }
                case 5: {
                    hacerSaludarAnimales(animales);
                    System.out.println("Presione enter para continuar...");
                    LeerConsola.saltoLinea();
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
    public static void ingresarAnimal(List<Animal> animales) {

        //Carga de datos del dueño
        System.out.println("Ingrese DNI del dueño: ");
        Integer dni = LeerConsola.leerInteger();
        if (Objects.isNull(dni)) {return;}

        System.out.println("Ingrese nombre del dueño: ");
        String nombreDuenio = LeerConsola.leerString();

        System.out.println("Ingrese la direccion donde vive: ");
        String direccion = LeerConsola.leerString();

        //Carga de datos del animal
        List<String> opcionesEspecie = new ArrayList<>();
        opcionesEspecie.add("Perro");
        opcionesEspecie.add("Pez");
        opcionesEspecie.add("Gato");
        opcionesEspecie.add("Hamster");

        System.out.println("Ingrese la especie del animal: (Perro / Pez / Gato / Hamster) ");
        String especie = LeerConsola.leerString(opcionesEspecie);
        if (Objects.isNull(especie)) {return;}

        System.out.println("Ingrese el nombre del animalito: ");
        String nombre = LeerConsola.leerString();

        System.out.println("Ingrese edad del animal: ");
        Integer edad = LeerConsola.leerInteger();
        if (Objects.isNull(edad)) {return;}

        System.out.println("Ingrese el sexo del animal: (M: Macho / H: Hembra)");
        List<Character> opcionesSexo = new ArrayList<>();
        opcionesSexo.add('M');
        opcionesSexo.add('H');

        Character sexoChar = LeerConsola.leerCaracter(opcionesSexo);
        if (Objects.isNull(sexoChar)){ return; }
        Sexo sexo = (sexoChar == 'M' || sexoChar == 'm') ? Sexo.MACHO : Sexo.HEMBRA;

        System.out.println("Ingrese el peso del animal (para decimales usar coma. Ejemplo: 2,5): ");
        Double peso = LeerConsola.leerDouble();
        if (Objects.isNull(peso)) {return;}

        //Instancias de las clases
        Animal animal = null;
        Duenio duenio = new Duenio(dni, nombreDuenio, direccion);

        //Construcción del objeto animal segun especie
        if (especie.equalsIgnoreCase("perro")){
            System.out.println("Ingrese la raza del perro: ");
            String raza = LeerConsola.leerString();

            animal = new Perro(nombre, edad, duenio, sexo, peso, raza);
        }
        else if (especie.equalsIgnoreCase("pez")){
            System.out.println("Ingrese de qué tipo de agua es el pez: (Salada/Dulce)");
            List<String> opcionesAgua = new ArrayList<>();
            opcionesAgua.add("Salada");
            opcionesAgua.add("Dulce");
            String tipoAgua = LeerConsola.leerString(opcionesAgua);

            if (Objects.isNull(tipoAgua)) {return;}

            animal = new Pez(nombre, edad, duenio, sexo, peso, tipoAgua);
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

        try {
            animales.add(animal);
            System.out.println("Nuevo animalito sumado a la guarderia con exito!");
        }
        catch (NullPointerException e) {
            System.out.println("Ha ocurrido un error cargando los datos del animalito, intente nuevamente.");
        }
    }

    //Opcion 2===============================================================================
    public static void retirarAnimales(List<Animal> animales) {

            System.out.println("Seleccione una de las opciones a continuación: ");
            System.out.println("1. Retirar un animalito de la guarderia");
            System.out.println("2. Retirar todos los animalitos de la guarderia");
            System.out.println("3. Volver al menu principal");

            int[] rangoMenu = {1,3};
            Integer retirarOpcion = LeerConsola.leerInteger(rangoMenu);
            if (Objects.isNull(retirarOpcion)) {
                System.out.println("Se lo redireccionará al menú principal...");
                return;
            }

        switch (retirarOpcion) {
            case 1: {
                retirarUnAnimal(animales); break;
            }
            case 2: {
                if (animales.size() > 0) {
                    System.out.println("Se retiraran los siguientes animalitos de la guarderia: ");
                    imprimirAnimales(animales);

                    System.out.println("Confirma la operacion? (S/N)");
                    char confirmarOperacion = LeerConsola.leerCaracter();
                    if (confirmarOperacion == 'S' || confirmarOperacion == 's' ) {
                        animales.clear();
                        System.out.println("Animalitos retirados con éxito.");
                    }
                    else if (confirmarOperacion == 'N' || confirmarOperacion == 'n') {
                        System.out.println("Operacion cancelada. Se lo redireccionara al menu principal...");
                    }
                    else {
                        System.out.println("La opcion ingresada no es correcta. Se lo redireccionara al menu principal...");
                    }
                }
                else {

                }
                break;

            }
            case 3: {
                return;
            }
            default: {
                System.out.println("Opcion incorrecta, por favor intente de nuevo");
                retirarAnimales(animales);
                break;
            }
        }
    }
    public static void retirarUnAnimal(List<Animal> animales) {

        int dniDuenio = 0;

        System.out.println("++++++++++++++++++++RETIRAR UN ANIMALITO++++++++++++++++++++");
        System.out.println("Ingrese el DNI del dueño: ");

        dniDuenio = LeerConsola.leerInteger();
        if (dniDuenio < 0 ) {
            System.out.println("No ha ingresado un DNI valido.");
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

            List<Character> opcionesBinarias = new ArrayList<>();
            opcionesBinarias.add('S');
            opcionesBinarias.add('N');

            Character intentarNuevamente = LeerConsola.leerCaracter(opcionesBinarias);

            if (Objects.isNull(intentarNuevamente)) {return;}
            else if (intentarNuevamente== 'S' || intentarNuevamente == 's') {
                retirarUnAnimal(animales);
            }
            else if (intentarNuevamente == 'N' || intentarNuevamente == 'n') {
                System.out.println("Operacion terminada. Se lo redireccionara al menu principal (presione enter para continuar)...");
            }
            else {
                System.out.println("La opcion ingresada no es correcta. Se lo redireccionara al menu  (presione enter para continuar)...");
            }
        }
        else {
            while (animalesDuenio.size() > 0) {
                System.out.println("En este momento hay " + animalesDuenio.size() + " animalitos registrados : ");
                for (Animal animal: animalesDuenio) {
                    System.out.println("-------------------------------------");
                    System.out.println("((" + (animalesDuenio.indexOf(animal) + 1)  + "))");
                    System.out.println(animal);
                }

                boolean valorInvalido = false;
                Integer indiceRetirarAnimal = null;

                do {
                    System.out.println("Cual desea retirar? (Indique según el número de la lista)");

                    try {
                        int[] rangoOpciones = {0, animalesDuenio.size()};
                        indiceRetirarAnimal = LeerConsola.leerInteger(rangoOpciones);
                        valorInvalido = true;
                    }
                    catch (IndexOutOfBoundsException  e) {
                        System.out.println("No ha ingresado indice valido. Intente nuevamente.");
                    }
                } while (!valorInvalido);

                animales.remove(animalesDuenio.get(indiceRetirarAnimal-1));
                animalesDuenio.remove(indiceRetirarAnimal-1);
                System.out.println("El animalito fue retirado con éxito!");

                if (animalesDuenio.size() > 0) {
                    System.out.println("Desea retirar otro animalito? (S/N)");
                    Character retirarOtroAnimal = LeerConsola.leerCaracter();
                    if (retirarOtroAnimal == 'N' || retirarOtroAnimal == 'n') {
                        break;
                    }
                    else if (retirarOtroAnimal == 'S' || retirarOtroAnimal == 's') {}
                    else {
                        System.out.println("La opcion ingresada no es correcta. Intente nuevamente");
                    }
                }
                else {
                    System.out.println("No tenemos más animalitos registrados para este dueño! Presione enter para volver al menu.");
                    LeerConsola.saltoLinea();
                }
            }
        }
    }

    //Opcion 3===============================================================================
    public static void cantidadAnimalesEnGuarderia(List<Animal> animales) {
        System.out.println("En la guarderia hay actualmente " + animales.size() + " animales.");
    }

    //Opcion 4===============================================================================
    public static void listarAnimalesEnGuarderia(List<Animal> animales) {
        System.out.println("______________ANIMALITOS EN LA GUARDERIA______________");
        if (animales.size() > 0) {
            imprimirAnimales(animales);
            System.out.println("");
        }
        else {
            System.out.println("No hay animalitos registrados en la guarderia en este momento.");
        }
    }

    //Opcion 5===============================================================================
    public static void hacerSaludarAnimales(List<Animal> animales) {
        System.out.println("Preparense! A continuación todos nuestros animalitos van a saludar: ");
        if (animales.size() > 0 ) {
            for (Animal animal: animales) {
                animal.saludar();
                System.out.println("");
            }
        }
        else {
            System.out.println("Oh no! No hay animalitos en la guarderia en este momento");
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
