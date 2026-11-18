import java.util.Scanner;

/******************************************************************************************************************
 * 
 * Nombre: Eulatz Torres Ferreira 
 * Fecha: 13/28/2026 
 * Modulo: Programación. 
 * UD: UD3 Estructuras de control. 
 * Tarea: Tarea Práctica 01. Realiza un programa en Java.
 * 
 * Descripción del programa: Calcula la nota final de un estudiante a partir de
 * sus calificaciones en las tareas del curso y en el examen final 
 * 
 *******************************************************************************************************************/ 

public class RedundanciasComparar {
	public static final int MAX_EXAMEN = 100;
	public static final int MAX_EXTRA = 10;
	public static final int MAX_PESO = 100;

	public static void main(String[] args) {
		Scanner leerTeclado = new Scanner(System.in);
		presentacion();

        System.out.println("\nIntroduzca los datos del primer alumno: ");
		double alumna1 = calcularNotas(leerTeclado);
		obtenerEscala(alumna1);
      
        System.out.println("\nIntroduzca los datos del segundo alumno: ");
        double alumna2 = calcularNotas(leerTeclado);
        obtenerEscala(alumna2);
        
        compararAlumnos(alumna1, alumna2);

        leerTeclado.close();
	}


    public static void presentacion() {
		System.out.println("Este programa lee las calificaciones de las Unidades Didácticas y del examen final");
		System.out.println("para calcular la nota final del módulo.");
		System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas.");
		System.out.println();
	}

	public static double calcularNotas(Scanner leerTeclado) {

        double notaTareas = unidades(leerTeclado);
        System.out.println("\nTOTAL UDs ");
        System.out.println("Nota final ponderada de las UDs (sobre 100): " + notaTareas + "\n");
        
        double notaFinal = notaTareas;
		
        if (notaTareas >= 50) {
            double notaExamen = examen(leerTeclado);
            System.out.println("Nota final del examen (sobre 100): " + notaExamen + "\n");
            notaFinal = (notaExamen * 50) / 100 + (notaTareas * 50) / 100;
    
            if(notaExamen < 50 && notaFinal >= 50){
                notaFinal = 40;
            }
			
        }
		else {
            System.out.println("No cumple el mínimo de 50 puntos en las UDs para presentarse al examen.");
        }
        System.out.println("TOTAL FINAL: " + notaFinal);
		return notaFinal;
	}
   
	
	//Calcula la aportación de las tareas a la nota final 
	public static double unidades(Scanner leerTeclado) {
        
		System.out.println("UNIDADES:");
        System.out.print("Introduce el número de unidades: ");
		int unidades = leerTeclado.nextInt();
      
        double totalPonderado =0;
		for (int i =1; i <= unidades;i++) {
        	System.out.println("--- Unidad " + i + " ---");        
        	System.out.print("Introduce el peso de la UD (0-" + MAX_PESO + "): ");        
        	double peso = leerTeclado.nextDouble();

        	System.out.print("Introduce la nota de la UD (0-" + MAX_EXAMEN + "): ");
        	double nota = leerTeclado.nextDouble();
      
        	totalPonderado += (peso * nota) / MAX_PESO;
      }
      return totalPonderado;
	}

	
	//Calcula la nota del examen final
	public static double examen(Scanner leerDatos) {
		System.out.println("EXAMEN FINAL:");
      
        System.out.print("Introduce la calificación del examen (0-" + MAX_EXAMEN + "): ");
		double nota = leerDatos.nextDouble();
      
        System.out.print("¿Has obtenido puntos extra (1=Si, 2=No)? ");
		int extra = leerDatos.nextInt();

        if (extra == 1) {
            System.out.print("Introduce los puntos extra (0-" + MAX_EXTRA + "): ");            
            double puntosExtra = leerDatos.nextDouble();
            
            nota += puntosExtra;
            if (nota > MAX_EXAMEN) {
                nota = MAX_EXAMEN;
            }
        }
		return nota;
	}

	public static void obtenerEscala(double nota) {
     System.out.print("Escala final (0-4): ");
        if (nota >= 90) {
            System.out.println("4 (Sobresaliente)");
        } else if (nota >= 70) {
            System.out.println("3 (Notable)");
        } else if (nota >= 60) {
            System.out.println("2 (Bien)");
        } else if (nota >= 50) {
            System.out.println("1 (Suficiente)");
        } else {
            System.out.println("0 (Insuficiente)");
        }
    }
	
	public static void compararAlumnos(double alumna1, double alumna2) {
		if (alumna1 > alumna2) {
			System.out.println("La calificación del primer estudiante, " + alumna1 + " es más alta que la del segundo estudiante, " + alumna2); 
		} else if (alumna2 > alumna1) {
			System.out.println("La calificación del segundo estudiante, " + alumna2 + " es más alta que la del primer estudiante, " + alumna1); 
		} else {
			System.out.println("La calificación de los dos estudiantes es la misma: " + alumna1);
		}
	}
}
