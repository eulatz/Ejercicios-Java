package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("./ejercicios/alumnosNota.txt");
        
        if (fichero.exists()) {
            Scanner lector = new Scanner(fichero);

            String nombre = "";
            double nota = 0;
            double suma = 0;
            double notaMasAlta=0;
            int cont = 0;
            String mejorAlumno = "";

            while (lector.hasNext()) {
                nombre = lector.next();
                
                if (lector.hasNextDouble()) {
                    nota = lector.nextDouble();
                    suma += nota;

                    if (nota >= 5) {
                        System.out.println("Aprobado: " + nombre + "(" +nota+")");
                    }
                    if (nota > notaMasAlta) {
                        notaMasAlta = nota;
                        mejorAlumno = nombre;
                    }
                }
                cont++;
            }
            System.out.println();
            System.out.println("Han Participado: " + cont + " alumnos.");
            System.out.println("La suma es: " + suma);
            System.out.println("Promedio: " + suma / cont );
            System.out.println("La nota mas alta es: " + mejorAlumno + " (" +notaMasAlta+")");
            lector.close();        
        }
    }
}
