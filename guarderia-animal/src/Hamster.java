public class Hamster extends Animal {
    //Atributos


    //Constructores

    public Hamster(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso) {
        super(nombre, edad, duenio, sexo, peso);
    }

    public Hamster(String nombre, Duenio duenio, Sexo sexo) {
        super(nombre, duenio, sexo);
    }


    //Getters y Setters


    //Metodos
    @Override
    void saludar() {
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un hamster... \ncush cush");
    }

    @Override
    public int hashCode() {
        return  ("hamster").hashCode() + this.getNombre().hashCode() + this.getEdad();
    }


    @Override
    public String toString() {
        return
                "Tipo de animal: Hamster \n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Edad: " + this.getEdad() + "\n" +
                "Sexo: " + this.getSexo() + "\n" +
                "Peso (kg): " + this.getPeso();
    }
}
