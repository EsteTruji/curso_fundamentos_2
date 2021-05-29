import java.util.ArrayList;

public class Sensor{
    private String tipo;
    private double valor;
    
    public Sensor(){
    }

    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
    }

    public String getTipo(){
        return this.tipo;
    }

    public double getValor(){
        return this.valor;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String toString(){
        return "Tipo: "+this.getTipo() + " - Valor: " + this.getValor();
    }
}