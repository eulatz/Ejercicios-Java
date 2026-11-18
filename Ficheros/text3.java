import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;;

public class text3 {
    public static void main(String[] args) throws FileNotFoundException{
        File fichero = new File("./Ficheros/numerosX.txt");
        Scanner leerFichero = new Scanner(fichero);
        leerFichero.useLocale(Locale.US);

        while(leerFichero.hasNext()) {
            if(leerFichero.hasNextDouble()){
                double num = leerFichero.nextDouble();
                System.out.println(num);
            }else {
                String otros = leerFichero.next();
                System.out.println(otros);
            }
        }
        leerFichero.close();
    }
}