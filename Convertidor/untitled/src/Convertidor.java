import javax.imageio.IIOException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Convertidor {

    public static void main(String[] args){

        //Inicializando valores

        Scanner teclado = new Scanner(System.in);
        Scanner lectura = new Scanner(System.in);
        Configuracion conversion_divisas = new Configuracion();
        boolean detener = false;
        int opcion = 0;
        int cantidad = 0;


        String menu = """
                Bienvenido al convertidor de divisas
                ------------------------------------
                Qué acción deseas realizar?
                
                1) Dolar ---> Peso Argentino
                2) Peso Argentino ---> Dolar
                3) Dolar ---> Peso Mexicano
                4) Peso Mexicano ---> Dolar
                5) Peso Argentino ---> Peso Mexicano
                6) Peso Mexicano ---> Peso Argentino
                7) Salir
                
                Elija una opción válida
                
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""";

        while (detener == false) {

            System.out.println(menu);
            opcion = teclado.nextInt();
            String mensaje = "Qué cantidad desea convertir?";

            switch (opcion){

                case 1:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("USD","ARS",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("ARS","USD",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("USD","MXN",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("MXN","USD",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("ARS","MXN",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(mensaje);
                    try{
                        cantidad = Integer.valueOf(lectura.nextLine());

                        Conversion conversion = conversion_divisas.conversion_divisas("MXN","ARS",cantidad);
                        System.out.println(conversion);

                        Creador_de_archivo generador = new Creador_de_archivo();
                        generador.guardar_json(conversion);

                    } catch (RuntimeException | IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro convertidor de divisas");
                    detener = true
                    ;break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }

    }
}