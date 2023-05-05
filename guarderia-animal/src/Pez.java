public class Pez extends Animal {
    //Atributos
    private TipoAgua tipoAgua;


    //Constructores

    public Pez(String nombre, Integer edad, Duenio duenio, Sexo sexo, Double peso, String tipoAgua) {
        super(nombre, edad, duenio, sexo, peso);
        if (tipoAgua.equalsIgnoreCase("salada")) {
            this.tipoAgua = TipoAgua.SALADA;
        }
        else if (tipoAgua.equalsIgnoreCase("dulce")){
            this.tipoAgua = TipoAgua.DULCE;
        }

    }

    public Pez(String nombre, Duenio duenio, Sexo sexo, String tipoAgua) {
        super(nombre, duenio, sexo);
        if (tipoAgua.equalsIgnoreCase("salada")) {
            this.tipoAgua = TipoAgua.SALADA;
        }
        else if (tipoAgua.equalsIgnoreCase("dulce")){
            this.tipoAgua = TipoAgua.DULCE;
        }
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
        System.out.println("Hola me llamo: " + this.getNombre() + " y ademas soy un pez... \nglu glu...");
    }

    @Override
    public int hashCode() {
        return ("pez").hashCode() + this.getNombre().hashCode() + this.getEdad();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return
                "Tipo de animal: Pez \n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Edad: " + this.getEdad() + "\n" +
                "Tipo de agua: " + this.tipoAgua + "\n" +
                "Sexo: " + this.getSexo() + "\n" +
                "Peso (kg): " + this.getPeso();
    }

    public enum TipoAgua {
        SALADA,
        DULCE;
    }

}



