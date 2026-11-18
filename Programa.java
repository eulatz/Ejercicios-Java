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
 * Enlace autoevaluación:
 * 
 *******************************************************************************************************************/ 

public class Programa {

	// Constantes que se van a utilizar
	public static final int MAX_EXAMEN = 100;
	public static final int MAX_EXTRA = 10;
	public static final int MAX_PESO = 100;

	/*
	 * Método principal: calcula la calificación final de un alumno o alumna y
	 * muestra en qué escala está. Podría hacerse para varias personas y comparar sus
	 * resultados
	 */
	public static void main(String[] args) {
		Scanner leerTeclado = new Scanner(System.in);
		presentacion();

        System.out.println("\nIntroduzca los datos del primer alumno: ");
		double alumna1 = calcularNotas(leerTeclado);
		obtenerEscala(alumna1);
      
        // Código para introducir las notas de otra persona y compararla con la primera
        System.out.println("\nIntroduzca los datos del segundo alumno: ");
        double alumna2 = calcularNotas(leerTeclado);
        obtenerEscala(alumna2);
        
        compararAlumnos(alumna1, alumna2);

        leerTeclado.close();
	}

	/*
	 * Método presentacion: Explica lo que hace el programa No tiene parámetros y no
	 * devuelve ningún valor
	*/
    public static void presentacion() {
		System.out.println("Este programa lee las calificaciones de las Unidades Didácticas y del examen final");
		System.out.println("para calcular la nota final del módulo.");
		System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas.");
		System.out.println();
	}

	
	/*
	 * Método que calcula la calificación final de un estudiante 
	 * Parámetros: 	Scanner leerTeclado para leer valores introducidos por teclado 
	 * return: 		valor de tipo double con la nota final ponderada
	 */
	public static double calcularNotas(Scanner leerTeclado) {
	
    // UNIDADES DIDACTICAS
        double notaTareas = unidades(leerTeclado);
        System.out.println("\nTOTAL UDs ");
        System.out.println("Nota final ponderada de las UDs (sobre 100): " + notaTareas + "\n");
        
    // COMPLETAR
    // Controlar que solo se puede presentar al examen si la nota de las UDs es mayor o igual que 5
        double notaFinal = notaTareas;

        if (notaTareas >= 50) {
            double notaExamen = examen(leerTeclado);
            System.out.println("Nota final del examen (sobre 100): " + notaExamen + "\n");
            notaFinal = (notaExamen * 50) / 100 + (notaTareas * 50) / 100;
    
            // Si la nota del examen es menor que cinco y la nota Final es aprobado
            if(notaExamen < 50 && notaFinal >= 50){
                notaFinal = 40;
            }
        
        }else {
            System.out.println("No cumple el mínimo de 50 puntos en las UDs para presentarse al examen.");
        }
        System.out.println("TOTAL FINAL: " + notaFinal);
		return notaFinal;
	}
   
	/*
	 * Calcula la aportación de las tareas a la nota final 
	 * Parámetros: 	Scanner leerTeclado para leer valores introducidos por teclado 
	 * return: 		valor de tipo double con la nota final ponderada de las tareas
	 */
	public static double unidades(Scanner leerTeclado) {
        
		System.out.println("UNIDADES:");
        System.out.print("Introduce el número de unidades: ");
		int unidades = leerTeclado.nextInt();
      
        double totalPonderado =0;
      // COMPLETAR
      // Pide el peso y la nota de cada UD y calcula la nota ponderada mediante la formula peso x nota / MAX_PESO
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

	/*
	 * Calcula la nota del examen final
	 * Parámetros:  Scanner leerDatos para leer valores introducidos por teclado
	 * 				String periodo para distinguir si el examen es parcial o final 
	 * return: 		valor de tipo double con la nota final del examen
	 */
	public static double examen(Scanner leerDatos) {
		System.out.println("EXAMEN FINAL:");
      
        System.out.print("Introduce la calificación del examen (0-" + MAX_EXAMEN + "): ");
		double nota = leerDatos.nextDouble();
      
        System.out.print("¿Has obtenido puntos extra (1=Si, 2=No)? ");
		int extra = leerDatos.nextInt();

      // COMPLETAR
		// Si hay puntos extra los lee. Además, controla que la nota final no sea mayor que MAX_EXAMEN
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

	/*
	 * COMPLETAR
    * Pasa la nota final a una escala del 0 al 4 y muestra el mensaje
	 * correspondiente 
	 * Parámetros: 	int nota: valor de la nota final total 
	 * No devuelve nada
	 */
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
	
   /* Compara la nota de 2 personas diferentes, e indica cuál es mayor */
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