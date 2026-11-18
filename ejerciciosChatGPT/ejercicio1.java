package ejerciciosChatGPT;
import java.util.*;
import java.io.*;

public class ejercicio1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("./ejerciciosChatGPT/datos.txt");
        Scanner leerFichero = new  Scanner(fichero);

        double suma = 0;

        while (leerFichero.hasNext()) {
            String dato = leerFichero.next();
            Scanner leerDatos = new Scanner(dato);

            if (leerDatos.hasNextDouble()) {
                suma += leerDatos.nextDouble();
            }
        }
        System.out.println("La suma total es: " + suma);
        leerFichero.close();

    }
    
}
/*
Reto 1 (El de tu código): Calcula e imprime por pantalla la suma, el promedio, 
el Mayor, el Menor y los Numeros validos de practica.txt.
*/

/* 

Resultado esperado: Válidos: 6, Suma: 185.0, Promedio: 30.83, Mayor: 100.0, Menor: -5.0.





Reto 2 (Contar palabras vs números): Recorre practica.txt y muestra cuántos elementos en total hay en el fichero, cuántos son números y cuántas son palabras (texto).

Resultado esperado: Total: 11, Números: 6, Palabras: 5.

Reto 3 (Filtro con condición): Crea un método public static double sumarPares(Scanner sc) que lea solo los números enteros que sean pares y devuelva su suma.

Resultado esperado: 150 (de 10 + 40 + 100).

Reto 4 (Dos ficheros a la vez): Descomenta fichero2 en tu código. Lee los números de datos1.txt y los de datos2.txt, y muestra cuál de los dos ficheros tiene una suma mayor.

*/