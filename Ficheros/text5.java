import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class text5 {
        public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("datos.txt");
        Scanner leerFichero = new Scanner(fichero);
        int cont = 0;
        
        while (leerFichero.hasNext()) {
            if(leerFichero.hasNextInt()) {
                int num = leerFichero.nextInt();
            }
            else {
                String otros = leerFichero.next();
            }
            cont++;
        }
        System.out.println("Tiene " + cont + " palabras");
        leerFichero.close();
    }
}
