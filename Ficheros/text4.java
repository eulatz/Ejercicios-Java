import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class text4 {
        public static void main(String[] args) throws FileNotFoundException {
        Scanner leerFichero = new Scanner(new File("datos.txt"));
        
        int total = mayor75(leerFichero);
        System.out.println("Hay " + total + " numeros mayores que 75");
        
        leerFichero.close();
    }
        
   public static int mayor75(Scanner leerFichero) {
    int cont = 0;
    while (leerFichero.hasNext()) {
        String palabra = leerFichero.next();
        try {
            double numero = Double.parseDouble(palabra.replace(',', '.'));
            if (numero > 75) {
                cont++;
            }
        } catch (NumberFormatException e) {
        }
    }
    return cont;
}
}
