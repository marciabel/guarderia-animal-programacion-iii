import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LeerConsola {
    static private Scanner sc = new Scanner(System.in);

    public static Integer leerInteger() {
        boolean opcionCorrecta = true;

        int cantidadIntentos = 0;
        Integer opcion = null;

        do {
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                opcionCorrecta = false;
            } catch (InputMismatchException e) {
                cantidadIntentos++;
                if (cantidadIntentos < 3) {
                    System.out.println("El valor ingresado es incorrecto. Quedan " + (3 - cantidadIntentos) + " intentos disponibles.");
                    sc.nextLine();
                } else {
                    System.out.println("No quedan más intentos disponibles. ");
                    sc.nextLine();
                }

            }
        } while (opcionCorrecta && cantidadIntentos != 3);

        return opcion;
    }

    public static Integer leerInteger(int[] rango) {

        Integer opcion = leerInteger();
        if (!(opcion >= rango[0] && opcion <= rango[1])) {
            throw new IndexOutOfBoundsException();
        }
        return opcion;
    }

    public static Double leerDouble() {
        boolean opcionCorrecta = true;

        int cantidadIntentos = 0;
        Double opcion = null;

        do {
            try {
                opcion = sc.nextDouble();
                sc.nextLine();
                opcionCorrecta = false;
            } catch (InputMismatchException e) {
                cantidadIntentos++;
                if (cantidadIntentos < 3) {
                    System.out.println("El valor ingresado es incorrecto. Quedan " + (3 - cantidadIntentos) + " intentos disponibles.");
                    sc.nextLine();
                } else {
                    System.out.println("No quedan más intentos disponibles. ");
                    sc.nextLine();
                }

            }
        } while (opcionCorrecta && cantidadIntentos != 3);

        return opcion;
    }


    public static char leerCaracter() {
        char caracter = sc.next().charAt(0);
        sc.nextLine();
        return caracter;
    }

    public static Character leerCaracter(List<Character> posibilidades) {
        int cantidadIntentos = 0;
        Character caracter = leerCaracter();
        do {
            for (Character caract : posibilidades) {
                if (caracter == caract || caracter == (caract - 32) || caracter == (caract + 32)) {
                    return caracter;
                }
                cantidadIntentos++;

                if (cantidadIntentos < 3) {
                    System.out.println("El valor ingresado es incorrecto. Quedan " + (3 - cantidadIntentos) + " intentos disponibles.");
                    caracter = leerCaracter();
                } else {
                    System.out.println("No quedan más intentos disponibles. ");

                }
            }
        } while (cantidadIntentos < 3);

        return null;
    }


    public static String leerString() {
        String cadenaCaracteres = sc.next();
        sc.nextLine();
        return cadenaCaracteres;
    }

    public static String leerString(List<String> posibilidades) {
        int cantidadIntentos = 0;
        String cadena = leerString();
        do {

            for (String posibilidad:posibilidades) {
                if (posibilidad.equalsIgnoreCase(cadena)) {return cadena; }
            }

            cantidadIntentos++;
            if (cantidadIntentos < 3) {
                System.out.println("El valor ingresado es incorrecto. Quedan " + (3 - cantidadIntentos) + " intentos disponibles.");
                cadena = leerString();
            } else {
                System.out.println("No quedan más intentos disponibles. ");
            }

        } while (cantidadIntentos < 3);
        return null;
    }

    public static void saltoLinea() {
        sc.nextLine();
    }
}
