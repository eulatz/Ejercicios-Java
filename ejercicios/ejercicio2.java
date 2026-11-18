package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Introduce el nombre del Fichero de: ");
    Scanner teclado = new Scanner(System.in);
    String texto = teclado.nextLine();
    System.out.println(texto);
    
    String path = "./ejercicios/";
    File leerFichero = new File(path+texto);
    int suma = 0;
    int cont =0;    
    int numeroMayor = 0; 
    int numeroMenor = 0;
    String palabras = "";


    if(leerFichero.exists()){
        Scanner datosFichero = new Scanner(leerFichero);
    
        while(datosFichero.hasNext()) {
            if(datosFichero.hasNextInt()){
                int valor = datosFichero.nextInt();
                suma += valor;
                if (cont == 0) {
                    numeroMenor = valor;
                    numeroMayor = valor;
                }
                cont++;
                if(valor > numeroMayor) {
                    numeroMayor = valor;
                }
                if (valor < numeroMenor) {
                    numeroMenor = valor;
                }
            }else {
                palabras += datosFichero.next() + " ";
            }
        }

    }


    System.out.println("Números");
    System.out.println("\tSuma: " + suma);
    double promedio = suma / cont;
    System.out.println("\tPromedio: " + promedio);
    System.out.println("\tMayor: " + numeroMayor);
    System.out.println("\tMenor: " + numeroMenor);
    System.out.println("\tNúmeros válidos: " + cont);
    System.out.println("Palabras: " + palabras.trim());


}
}

/*
Hola  10
20
Error 10aquí
30  67,98
40 */


/*
Números:
    Suma: 100
    Promedio: 25.0
    Mayor: 40
    Menor: 10
    Números válidos: 4
Palabras: Hola Error 10aquí 67,98 */