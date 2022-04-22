package paqueteGeneral;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static ArrayList<Empleado> empleados=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		inicializar();
		menuPrincipal();
		System.out.println("Programa ha sido acabado con exito");
	}
	
	public static void inicializar() {
		empleados.add(new MozoDeAlmacen("Ozzy", "Osbourne", "35775553C", 30));
		empleados.add(new JefeDePlanta("Lemmy", "Kilmister", "05535530G", 20, 2));
		empleados.add(new Directivo("Corey", "Taylor", "65003200B", 0, true));
		empleados.add(new MozoDeAlmacen("George", "Fisher", "20202086E", 10));
	}
	
	public static void menuPrincipal() {
		int entrada;
		boolean ejecutar=true;
		while(ejecutar) {
			System.out.println("MENU PRINCIPAL");
			System.out.println(	"1.- Introducir trabajador\n" +
								"2.- Eliminar trabajador\n" +
								"3.- Listado trabajadores\n" +
								"4.- Listado trabajadores por puesto\n" +
								"5.- Avance temporal\n" +
								"6.- Mostrar matriz días trabajados\n" +
								"7.- Acabar programa\n"
					);
			System.out.print("Elige una opci\u00F3n: ");
			entrada=enteroNoNegativo();
			switch (entrada) {
			case 1:
				
				break;
			case 2:
				
				break;

			case 3:
				
				break;
			case 4:
				
				break;

			case 5:
				
				break;
			case 6:
				
				break;

			case 7:
				System.out.println("Eres seguro de que queieres acabar la programa (S/N)¿?");
				if(aseguro()) {
					ejecutar=false;
				}
				break;
			default:
				System.out.println("Opción invalida");
				break;
			}
		}
		
	}
	
	// Metodo para que me introducen un int no negativo
		public static int enteroNoNegativo() {

			int num = 0;
			boolean listo = false;
			// Hasta el momento que no introducen un int valido
			while (!listo) {
				// Hago try catch para estar seguro de que me introducen un int
				try {

					num = Integer.parseInt(sc.nextLine());
					// Si numero es positivo es valido
					if (num >= 0) {
						listo = true;
					}
					// El caso de un numero negativo
					else {
						System.out.println("No aceptamos numeros negativos");
					}

				}
				// Error de formato de numero
				catch (NumberFormatException e) {
					System.out.println("Formato de entrada invalido");
				}

			}

			return num;

		}
		
		// Metodo para asegurar una desicion con s/n
		public static boolean aseguro() {
			char entrada = ' ';
			while (true) {
				try {
					entrada = sc.nextLine().toLowerCase().charAt(0);
					if (entrada == 's' || entrada == 'n')
						break;
					else
						System.out.println("Solo se aceptan letras s/n:");
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					System.out.println("No se aceptan lineas vacias:");
				}
			}
			if (entrada == 's') {
				return true;
			} else {
				return false;
			}
		}
}
