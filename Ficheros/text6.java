import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class text6 {
     public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("Programa.java");
        Scanner leerFichero = new Scanner(fichero);
        while (leerFichero.hasNextLine()) {
            String linea = leerFichero.nextLine();
            System.out.println(linea);
        }
        leerFichero.close();
    }
}
