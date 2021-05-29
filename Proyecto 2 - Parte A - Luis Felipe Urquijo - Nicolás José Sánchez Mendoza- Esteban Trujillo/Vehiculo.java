import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Vehiculo{
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int tamano = 10;
    public static int idActual = 1;
    private int id = 0;
    static BufferedReader br = null;
    static int j = 0;

    public Vehiculo(){
        this.setID(Vehiculo.idActual);
        Vehiculo.idActual++;
        Vehiculo.vehiculos.add(this);
    }

    public Vehiculo(int modelo, String marca, double valor){
        this(modelo, marca, valor, "verde");
    }

    public Vehiculo(int modelo, String marca, double valor, String color){
        this.setID(Vehiculo.idActual);
        Vehiculo.idActual++;
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valor;
        this.color = color;
        Vehiculo.vehiculos.add(this);
    }

    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> sensores2){
        this.sensores = sensores2;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getModelo(){
        return this.modelo;
    }

    public String getMarca(){
        return this.marca;
    }

    public double getValorComercial(){
        return this.valorComercial;
    }

    public String getColor(){
        return this.color;
    }

    public void setModelo(int mo){
        this.modelo = mo;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public void setValorComercial(double va){
        this.valorComercial = va;
    }

    public void setColor(String co){
        this.color = co;
    }

    public String encontrarSensoresTipoTemperatura(Vehiculo vehiculo3){
        String texto = "";
        for(int h = 0; h < vehiculo3.sensores.size(); h++){
            if((vehiculo3.sensores.get(h).getTipo()).equals("temperatura")){
                texto =  texto + " //\n "+"Sensor "+(h+1)+": "+vehiculo3.sensores.get(h).toString();
            }
        }
        return texto;
    }

    public String toString(){
        String texto2 = "";
        for(int i = 0; i < this.sensores.size(); i++){
            texto2 = texto2+ "//\n " + "Sensor "+ (i+1) +": "+this.sensores.get(i).toString();
        }

        return "Modelo: "+ this.getModelo() +" - Marca: " + this.getMarca() +" - Valor Comercial: "+ this.getValorComercial() +" - Color: "+ this.getColor() +" - ID: "+this.getID()+ texto2+"// ";
    }

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public void anadirSensor(Sensor sensor){
        this.sensores.add(sensor);
    }

    public static String toStringVehiculos(){
        String informacionVehiculos = "";
        for(int i = 0; i< Vehiculo.vehiculos.size(); i++){
            informacionVehiculos = vehiculos.get(i).toString() + " //\n "+ informacionVehiculos;
        }
        return informacionVehiculos;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    public static ArrayList<Sensor> organizarSensores(){
        ArrayList<Sensor> listaSensores = new ArrayList<Sensor>();

        for(int d = 0; d < Vehiculo.vehiculos.size(); d++){
            for(int f = 0; f < Vehiculo.vehiculos.get(d).getSensores().size(); f++){
                if(Vehiculo.vehiculos.get(d).getSensores().get(f).getTipo().equalsIgnoreCase("TEMPERATURA")){
                    listaSensores.add(Vehiculo.vehiculos.get(d).getSensores().get(f)); 
                }
            }
        }

        int pos_menor;
        Sensor temp;
        for (int i = 0; i < listaSensores.size() - 1; i++) {
            pos_menor = i;
            for (int j = i + 1; j < listaSensores.size(); j++) {
                if ((listaSensores.get(j)).getValor() < (listaSensores.get(pos_menor)).getValor()){
                    pos_menor = j;
                }
            }
            temp = listaSensores.get(i);
            listaSensores.set(i, listaSensores.get(pos_menor));
            listaSensores.set(pos_menor, temp);
        }

        return listaSensores;
    }

    public static Vehiculo encontrarVehiculoConID(int id){
        String texto = "";
        for(int h = 0; h < Vehiculo.vehiculos.size(); h++){
            if((Vehiculo.vehiculos.get(h).getID()) == id){
                return Vehiculo.vehiculos.get(h);
            }
        }
        return null;
    }

    public static String encontrarVehiculoVerde(){
        String texto = "";
        for(int h = 0; h < Vehiculo.vehiculos.size(); h++){
            if((Vehiculo.vehiculos.get(h).getColor()).equals("verde")){
                texto = Vehiculo.vehiculos.get(h).toString() + " //\n "+ texto;
            }
        }
        return texto;
    }

    public static void obtenerVehiculosEnArchivo(String nombreFichero){
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            //Leer la primera línea, guardando en un String
            String texto = br.readLine();
            //Repetir mientras no se llegue al final del fichero
            while(texto != null)
            {
                //Hacer lo que sea con la línea leída
                Vehiculo.trabajoSubtextos(texto);
                //Leer la siguiente línea
                texto = br.readLine();

            }
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichero no encontrado");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error de lectura del fichero");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally {
            try {
                if(br != null){
                    br.close();
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al cerrar el fichero");
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }

    public static void trabajoSubtextos(String texto){
        int longitud = texto.length();
        int modelo2 = 0;
        String marca2 = "";
        double valor2 = 0.0;
        String color2 = "";
        int b = 0;

        while(texto.charAt(b)!='-'){
            b++;
        }
        modelo2 = Integer.parseInt(texto.substring(0,b));
        int bTemp = b+1;
        b++;
        while(texto.charAt(b)!='-'){
            b++;
        }
        marca2 = texto.substring(bTemp,b);
        int bTemp2 = b+1;
        b++;
        while(texto.charAt(b)!='-'){
            b++;
        }
        valor2 = Double.parseDouble(texto.substring(bTemp2,b));
        int bTemp3 = b+1;
        b++;
        while(texto.charAt(b)!='/'){
            b++;
        }
        color2 = texto.substring(bTemp3,b);
        Vehiculo vehiculo2 = new Vehiculo(modelo2,marca2,valor2,color2);

    }
}