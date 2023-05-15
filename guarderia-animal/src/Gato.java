public class Gato extends Animal {
    //Atributos


    //Constructores

    public Gato(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso) {
        super(nombre, edad, duenio, sexo, peso);
    }

    public Gato(String nombre, Duenio duenio, Sexo sexo) {
        super(nombre, duenio, sexo);
    }


    //Getters y Setters


    //Metodos
    @Override
    void saludar() {
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un gato... \nmiau miau...");
    }

    @Override
    public int hashCode() {
        return ("hamster").hashCode() + this.getNombre().hashCode() + this.getEdad();
    }

    @Override
    public String toString() {
        return ("Tipo de animal: Gato \n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Edad: " + this.getEdad() + "\n" +
                "Sexo: " + this.getSexo() + "\n" +
                "Peso (kg): " + this.getPeso());
    }
}
