import java.util.Scanner;
import javax.swing.JOptionPane;
public class Principal{
    public static void main(String[] args){
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner entrada = new Scanner(System.in);
        String sig = "OK";
        while(true){
            while(!(sig.equalsIgnoreCase("OK"))){
                System.out.println(" --- Ingrese OK para volver al menú.");
                System.out.println("");
                sig = entrada.next();
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("/-------------------------------------------------/ MENU /-------------------------------------------------/");
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|| *Ingrese una de los siguientes números para:*                                                           ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 0 ) - Para finalizar la ejecución del programa.                                                       ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 1 ) - Para añadir un nuevo vehículo.                                                                  ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 2 ) - Para visualizar los datos de los vehículos creados.                                             ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 3 ) - Para visualizar el número de vehículos creados.                                                 ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 4 ) - Para encontrar todos lo vehículos ingresados con color verde.                                   ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 5 ) - Para visualizar los datos de un vehículo según su ID.                                           ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 6 ) - Para añadir un sensor a un vehículo según si ID.                                                ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 7 ) - Para visualizar los sensores añadidos a un vehículo según su ID.                                ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 8 ) - Para encontrar todos los sensores ingresados con tipo temperatura.                              ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 9 ) - Para visualizar los datos del vehículo con más sensores.                                        ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 10 ) - Para crear vehículos con sus datos a partir de un archivo de texto plano.                      ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|| ( 666 ) - Para organizar y visualizar los sensores tipo temperatura ingresados, de menor a mayor valor. ||");
            System.out.println("|| --------------                                                                                          ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int num = entrada.nextInt();
            if(num == 0){
                System.out.println("------ Hasta pronto. Gracias por usar el programa!! :)");
                System.out.println("    ");
                System.out.println("    ");
                System.out.println("              ||||           ||||            ");
                System.out.println("              ||||           ||||            ");
                System.out.println("              ||||           ||||            ");
                System.out.println("              ||||           ||||            ");
                System.out.println("              ||||           ||||            ");
                System.out.println("              ||||           ||||            ");
                System.out.println("                                                 ");
                System.out.println("     ||||                             ||||    ");
                System.out.println("     ||||                             ||||    ");
                System.out.println("     ||||                             ||||    ");
                System.out.println("      ||||                           ||||    ");
                System.out.println("       ||||                        ||||    ");
                System.out.println("         ||||                    ||||    ");
                System.out.println("            ||||              ||||    ");
                System.out.println("               ||||||||||||||||     ");
                break;
            }else if(num == 1){

                try{
                    System.out.println("--- Ingrese un modelo (int):");
                    int modelo = entrada.nextInt();
                    System.out.println("--- Ingrese una marca (String):");
                    String marca = entrada.next();
                    System.out.println("--- Ingrese un valor (double):");
                    double valor = entrada.nextDouble();
                    System.out.println("--- Ingrese un color (String):");
                    String color = entrada.next();
                    Vehiculo vehiculo = new Vehiculo(modelo,marca,valor,color);
                    sig = "";
                }catch(java.util.InputMismatchException e){
                    JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
                }

            }else if(num == 2){
                if(Vehiculo.cantidadVehiculos() > 0){
                    System.out.println(Vehiculo.toStringVehiculos());
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han ingresado vehículos aún -");
                    JOptionPane.showMessageDialog(null,"- Por favor, primero añada vehículos\n para después visualizarlos -");
                }
                sig = "";
            }else if(num == 3){
                System.out.println("--- La cantidad de vehículos ingresados es: "+ Vehiculo.cantidadVehiculos()+".");
                sig = "";
            }else if(num == 4){
                if(Vehiculo.cantidadVehiculos() > 0){
                    System.out.println(Vehiculo.encontrarVehiculoVerde());
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han ingresado vehículos aún -");
                    JOptionPane.showMessageDialog(null,"- Por favor, primero añada vehículos\n para después visualizarlos -");
                }
                sig = "";
            }else if(num == 5){
                System.out.println("--- Ingrese un ID:");
                if(Vehiculo.cantidadVehiculos() > 0){
                    try{
                        int idTemp = entrada.nextInt();
                        System.out.println(Vehiculo.encontrarVehiculoConID(idTemp).toString());
                    }catch(java.lang.NullPointerException e){
                        JOptionPane.showMessageDialog(null,"- No hay un vehículo con el ID ingresado -");
                    }catch(java.util.InputMismatchException e){
                        JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
                sig = "";
            }else if(num == 6){
                System.out.println("--- Ingrese un ID:");
                if(Vehiculo.cantidadVehiculos() > 0){
                    try{
                        int idTemp = entrada.nextInt();
                        System.out.println(Vehiculo.encontrarVehiculoConID(idTemp).toString());
                        System.out.println("--- Ingrese un tipo (String):");
                        String tipo = entrada.next();
                        System.out.println("--- Ingrese un valor (double):");
                        int valor = entrada.nextInt();
                        Sensor sensor = new Sensor(tipo,valor);
                        Vehiculo.encontrarVehiculoConID(idTemp).anadirSensor(sensor);
                    }catch(java.util.InputMismatchException e){
                        JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
                    }catch(java.lang.NullPointerException e){
                        JOptionPane.showMessageDialog(null,"- No hay un vehículo con el ID ingresado -");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
                sig = "";
            }else if(num == 7){
                System.out.println("--- Ingrese un ID:");
                if(Vehiculo.cantidadVehiculos() > 0){
                    try{
                        int idTemp = entrada.nextInt();
                        System.out.println(Vehiculo.encontrarVehiculoConID(idTemp).getSensores());
                        sig = "";
                    }catch(java.util.InputMismatchException e){
                        JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
                    }catch(java.lang.NullPointerException e){
                        JOptionPane.showMessageDialog(null,"- No hay un vehículo con el ID ingresado -");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
            }else if(num == 8){
                if(Vehiculo.cantidadVehiculos() > 0){
                    for(int d = 0; d < Vehiculo.vehiculos.size(); d++){
                        if(!(Vehiculo.vehiculos.get(d).encontrarSensoresTipoTemperatura(Vehiculo.vehiculos.get(d)).equals(""))){
                            System.out.println(Vehiculo.vehiculos.get(d).encontrarSensoresTipoTemperatura(Vehiculo.vehiculos.get(d)));
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
                sig = "";
            }else if(num == 9){
                if(Vehiculo.cantidadVehiculos() > 0){
                    int mayor = Vehiculo.vehiculos.get(0).getSensores().size();
                    int numero = 0;
                    for(int d = 1; d < Vehiculo.vehiculos.size(); d++){
                        if(Vehiculo.vehiculos.get(d).getSensores().size() > mayor){
                            mayor = Vehiculo.vehiculos.get(d).getSensores().size();
                            numero = d;
                        }
                    }
                    System.out.println(Vehiculo.vehiculos.get(numero).toString());
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
                sig = "";
            }else if(num == 10){
                try{
                    System.out.println("");
                    System.out.println("--- Ingrese el nombre del archivo:");
                    System.out.println("");
                    String nombreArchivo = entrada.next();
                    Vehiculo.obtenerVehiculosEnArchivo(nombreArchivo);
                    sig = "";
                }catch(java.util.InputMismatchException e){
                    JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
                }
            }else if(num == 666){
                if(Vehiculo.cantidadVehiculos() > 0){
                    for(int m = 0; m < Vehiculo.organizarSensores().size(); m++){
                        System.out.println(Vehiculo.organizarSensores().get(m).toString()); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"- No se han creado vehículos aún -");
                }
                sig = "";
            }else{
                JOptionPane.showMessageDialog(null,"- Ingrese un valor válido -");
            }
        }
    }
}
