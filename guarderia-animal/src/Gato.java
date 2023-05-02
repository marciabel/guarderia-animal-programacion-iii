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
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un gato");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
