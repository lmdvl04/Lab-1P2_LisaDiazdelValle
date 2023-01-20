/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.p2_lisadiazdelvalle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author HTS
 */
public class LabP2_LisaDiazdelValle {

    static Scanner leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        boolean cont = true;
        int opcion;

        do {
            System.out.println("---MENU---");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. salir");
            System.out.println("Ingrese una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el numero de discos: ");
                    int discos = leer.nextInt();
                    int origen = 1;
                    int auxiliar = 2;
                    int destino = 3;
                    hanoi(discos, origen, auxiliar, destino);
                }
                break;
                case 2: {
                    System.out.println("Ingrese un String separado por comas: ");
                    String frase = leer.next();
                    fecha(frase);

                }
                break;
                case 3: {
                    System.out.println("Ingrese el limite: ");
                    int lim = leer.nextInt();
                    double sum=0.0;
                    sumatoria(lim,sum);
                }
                break;
                case 4: {
                    cont = false;
                    System.out.println("Saliendo....");
                }
                break;
                default: {
                    System.out.println("Opcion no valida");
                }
                break;
            }
        } while (cont);
    }

    static void hanoi(int discos, int origen, int auxiliar, int destino) {

        if (discos == 1) {
            System.out.println( " Mover disco 1 de " + origen + " a " + destino);
            
            return;
        } else {
            hanoi(discos - 1, origen, destino, auxiliar);
            
        }
        System.out.println( " Mover disco " + discos + " de " + origen + " a " + destino);
        hanoi(discos - 1, auxiliar, origen, destino);
        
    }

    static void fecha(String cadena) throws ParseException {
        String datos[] = cadena.split(",");

        for (int i = 0; i < datos.length; i++) {
            if ((datos[i].charAt(2) == '/') && (datos[i].charAt(5) == '/') && (datos[i].length() == 10)) {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(datos[i]);
                System.out.println(fecha);
            }
        }
    }
    static double sumatoria (double lim, double sum){
        double n=-1;
        double num;
        double den;
        if (n==lim){
            return 4*sum;
        }else{
            n++;
            num = Math.pow(-1,n);
            den = (2*n)+1;
            sum += den/num;  
            n++;
            return sumatoria(lim,sum);   
            
        }
    }
}
