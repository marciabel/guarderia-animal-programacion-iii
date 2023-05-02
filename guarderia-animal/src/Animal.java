public abstract class Animal {
    private String nombre;
    private Integer edad;
    private Duenio duenio;
    private Sexo sexo;
    private Double peso;

    //Constructores
    public Animal(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.duenio = duenio;
        this.sexo = sexo;
        this.peso = peso;
    }

    public Animal(String nombre, Duenio duenio, Sexo sexo) {
        this.nombre = nombre;
        this.duenio = duenio;
        this.sexo = sexo;

        this.edad = null;
        this.peso = null;
    }

    //Setters y Getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Metodos
    abstract void saludar();


}
