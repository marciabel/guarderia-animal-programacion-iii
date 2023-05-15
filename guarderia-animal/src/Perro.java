public class Perro extends Animal {
    //Atributos
    private String raza;


    //Constructores
    public Perro(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso, String raza) {
        super(nombre, edad, duenio, sexo, peso);
        this.raza = raza;
    }

    public Perro(String nombre, Duenio duenio, Sexo sexo, String raza) {
        super(nombre, duenio, sexo);
        this.raza = raza;
    }

    public Perro(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso) {
        super(nombre, edad, duenio, sexo, peso);
        this.raza = "Sin raza";
    }

    public Perro(String nombre, Duenio duenio, Sexo sexo) {
        super(nombre, duenio, sexo);
        this.raza = "Sin raza";
    }

    //Getters y Setters

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    //Metodos


    @Override
    void saludar() {
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un perro... \nwoof woof...");
    }

    @Override
    public int hashCode() {
        return ("perro").hashCode() + this.getNombre().hashCode() + this.getEdad();
    }


    @Override
    public String toString() {
        return
                "Tipo de animal: Perro \n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Edad: " + this.getEdad() + "\n" +
                "Raza: " + this.raza + "\n" +
                "Sexo: " + this.getSexo() + "\n" +
                "Peso (kg): " + this.getPeso();
    }
}
