public class Sensor{
    public static Sensor[] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;
    String texto;
    
    
    public Sensor(){
        
    }
    
    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
        Sensor sensor = new Sensor(t,v);
        sensores[this.posAnadir] = sensor;
        this.posAnadir++;
        
    }
    
    public String toStringSensores(){
        for(int i = 0; i <= posAnadir; i = i + 2){
            texto = sensores[i].tipo + " " + sensores[i].valor + "// ";
            texto = texto + sensores[i+1].tipo + " " + sensores[i+1].valor + "// ";
        }
        return texto;
    }
    
    public int cantidadSensores(){
        return posAnadir;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setTipo(String t){
        this.tipo = t;
    }
    
    public void setValor(double v){
        this.valor = v;
    }
    
    public String toString(){
        return this.tipo + " " + this.valor;
    }
}