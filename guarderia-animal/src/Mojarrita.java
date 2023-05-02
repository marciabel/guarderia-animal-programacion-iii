public class Mojarrita extends Animal {
    //Atributos
    private TipoAgua tipoAgua;


    //Constructores

    public Mojarrita(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso, TipoAgua tipoAgua) {
        super(nombre, edad, duenio, sexo, peso);
        this.tipoAgua = tipoAgua;
    }

    public Mojarrita(String nombre, Duenio duenio, Sexo sexo, TipoAgua tipoAgua) {
        super(nombre, duenio, sexo);
        this.tipoAgua = tipoAgua;
    }

    //Getters y Setters
    public TipoAgua getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(TipoAgua tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    //Metodos
    @Override
    void saludar() {
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy una mojarrita");
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

    private enum TipoAgua {
        SALADA,
        DULCE;
    }

}



