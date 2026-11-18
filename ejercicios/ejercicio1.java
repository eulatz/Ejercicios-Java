package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio1 {
        public static void main(String[] args) throws FileNotFoundException {
        Scanner leerFichero = new Scanner(new File("./ejercicios/datos.txt"));
        
        int total = palabrasAcabanO(leerFichero);
        System.out.println(total + " palabras acaban por 'o' ");
        
        leerFichero.close();
    }
    
    // Crear el metodo aqui
    public static int palabrasAcabanO(Scanner leerFichero) {
        int cont = 0;
        while (leerFichero.hasNext()){
        
            String palabra = leerFichero.next();

            if (palabra.endsWith("o")){
                cont++;
            }
        
        }
        return  cont;
    }
}
//0,1,4,5,8
