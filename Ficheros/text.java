import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;;

class text {
    public static void main(String[] args) throws FileNotFoundException{
        File fichero = new File("./Ficheros/numerosX.txt");
        Scanner leerFichero = new Scanner(fichero);
        leerFichero.useLocale(Locale.US);

        for(int i = 0; i < 5; i ++) {
            double num = leerFichero.nextDouble();
            System.out.println(num);
        }

        leerFichero.close();
    }
}