package ejercicios;

import java.io.*;
import java.util.*;

public class ejercicio3 {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("./ejercicios/texto.txt");
        int contIguales = 0;
        int totalPalabras = 0;
        
        String palabramaslarga = "";
        
        if (fichero.exists()) {
            Scanner leerFicheroScanner = new Scanner(fichero);
            Scanner leerTeclado = new Scanner(System.in);

            System.out.print("Que palabra queres encontrar? ");
            String palabra = leerTeclado.nextLine();

            while (leerFicheroScanner.hasNext()) {   
                String palabraActual = leerFicheroScanner.next();
                totalPalabras++;

                if (palabraActual.toLowerCase().contains(palabra)) {
                    contIguales++;
                    }
                if (palabraActual.length() > palabramaslarga.length()) {
                        palabramaslarga = palabraActual;
                    }
            }

            System.out.println("Tamaño: " + totalPalabras);
            System.out.println(palabra + " se repite '" + contIguales + "' veces");
            System.out.println("La palabra mas larga es: " + palabramaslarga + " (" + palabramaslarga.length() + ")");
            
            leerFicheroScanner.close();
            leerTeclado.close();
        }
        else {
            System.out.println("Ruta Incorrecta");
        }
    }
}


