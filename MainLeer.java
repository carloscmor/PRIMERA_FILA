import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class MainLeer {

	//selecciona una pregunta aleatoria cada vez que se invoca con su categoria, tipo, etc.en una misma String
	private static String leer(String nfich) {
		String linea = "";
		try (Scanner sc = new Scanner(new File(nfich))) {
			Random rd = new Random();
			int n = rd.nextInt(20);
			for (int i = 0; i < n && sc.hasNextLine(); ++i) {
				linea = sc.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return linea;
	}
	
	public static void main(String[] args) {
		String lineaCompleta = leer("salida.txt");
		//formato de la pregunta: categoria ; tipo ; dificultad ; pregunta ; respuesta correcta ; respuesta incorrecta (puede ser una lista si la respuesta es de multiple eleccion
		//							  0		   1		 2			 3				 4							5
		//indices del array despues del split

		String pregunta = lineaCompleta.split("[;]")[3];
		System.out.println("La pregunta: " + pregunta);
		
	}

}
