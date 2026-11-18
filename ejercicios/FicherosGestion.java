package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FicherosGestion {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero1 = new File("./ejercicios/datos1.txt");
        //File fichero2 = new File("./ejercicios/datos2.txt");

        Scanner leerFichero = new Scanner(fichero1);
        while (leerFichero.hasNextLine()) {
            System.out.println(leerFichero.nextLine());
        }
        System.out.println("suma: ");
        System.out.println("promedio: ");
        System.out.println("Mayor: ");
        System.out.println("Menor: ");
        System.out.println("Numeros validos: ");
        leerFichero.close();
    } 
}

/*
Introduce el nombre del Fichero de: datos1.txt
Números:
    Suma: 100
    Promedio: 25.0
    Mayor: 40
    Menor: 10
    Números válidos: 4
Palabras: Hola Error 10aquí 67,98 */