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
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un perro");
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
