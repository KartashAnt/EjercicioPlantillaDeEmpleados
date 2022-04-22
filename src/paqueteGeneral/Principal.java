package paqueteGeneral;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Principal {
	static ArrayList<Empleado> empleados=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		inicializar();
		menuPrincipal();
		System.out.println("Programa ha sido acabado con exito");
	}
	
	public static void inicializar() {
		empleados.add(new MozoDeAlmacen("Ramon", "Joven Letov", "35775553C", 30));
		empleados.add(new JefeDePlanta("Pepe", "Cerdo Malvado", "05535530G", 20, 2));
		empleados.add(new Directivo("John", "Apellido", "65003200B", 0, true));
		empleados.add(new MozoDeAlmacen("Ivan", "Iban", "20202086E", 10));
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
				introducirEmpleado();
				break;
			case 2:
				eliminarEmpleado();
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
				System.out.println("Opci\u00F3n invalida");
				break;
			}
		}
		
	}
	
	// Metodo para introducir a un empleado
	public static void introducirEmpleado() {
		System.out.print("Nombre: ");
		String nombre=sc.nextLine();
		System.out.print("Apellidos: ");
		String apellidos=sc.nextLine();
		System.out.print("DNI: ");
		String dni;
		do {
			dni=sc.nextLine();
		} while (!validarDNI(dni));
		int tipo=0;
		while(tipo<1 || tipo>5) {
			System.out.print("Tipo de trabajador (0 para ayuda): ");
			tipo=enteroNoNegativo();
			if(tipo==0) {
				JOptionPane.showMessageDialog(null, "Tipos disponibles\n" + 
													"1.- Mozo de almacen\n" +
													"2.- Jefe de Secci\u00F3n\n" +
													"3.- Jefe de Planta\n" +
													"4.- Personal de Administraci\u00F3n\n" +
													"5.- Directivo"
						);
			}
		}
		System.out.print("Antiguedad: ");
		int antiguedad=enteroNoNegativo();
		int cat=0;
		boolean consejo;
		switch (tipo) {
		case 1:
			System.out.println("Nuevo Mozo de almacen registrado");
			empleados.add(new MozoDeAlmacen(nombre, apellidos, dni, antiguedad));
			break;
		case 2:
			while (cat<1 || cat>3) {
				System.out.print("Categoria(1-3): ");
				cat=enteroNoNegativo();
			}
			System.out.println("Nuevo Jefe de Secci\u00F3n registrado");
			empleados.add(new JefeDeSeccion(nombre, apellidos, dni, antiguedad, cat));
			break;
		case 3:
			while (cat<1 || cat>4) {
				System.out.print("Categoria(1-4): ");
				cat=enteroNoNegativo();
			}
			System.out.println("Nuevo Jefe de Planta registrado");
			empleados.add(new JefeDePlanta(nombre, apellidos, dni, antiguedad, cat));
			break;
		case 4:
			System.out.println("Nuevo Personal De Administraci\u00F3n");
			empleados.add(new PersonalDeAdministracion(nombre, apellidos, dni, antiguedad));
			break;
		case 5:
			System.out.println("Indica si es el miembro del consejo (S/N)");
			consejo=aseguro();
			System.out.println("Nuevo Directivo registrado");
			empleados.add(new Directivo(nombre, apellidos, dni, antiguedad, consejo));
			break;
		default:
			break;
		}
		
	}
	
	public static void eliminarEmpleado() {
		while(true) {
			listarEmpleados();
			System.out.println("Elige un empleado para borrar (0 - para salir):");
			int entrada=enteroNoNegativo()-1;
			if(entrada==-1) {
				System.out.println("Eliminado acabado");
				return;
			}
			if (entrada<empleados.size()) {
				System.out.println("Eres seguro que quieres borrar el siguiente empleado");
				System.out.println(empleados.get(entrada));
				if(aseguro()) empleados.remove(entrada);
				else System.out.println("Borrado cancelado");
			}
			else {
				System.out.println("Error: empleado no existe");
			}
		}
	}
	
	public static void listarEmpleados() {
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println((i+1) + ".- " + empleados.get(i));
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
		
		// Metodo para validar introducion del DNI
		public static boolean validarDNI(String dni) {
			// Patron de DNI
			if (Pattern.matches("\\d{8}[A-Z]", dni)) {
				// Busqueda del DNI repetido
				for (int i = 0; i < empleados.size(); i++) {

					if (empleados.get(i).getDni().equals(dni)) {
						System.out.println("ERROR: DNI coincide con DNI de otro cliente");
						return false;
					}

				}
				System.out.println("DNI valido");
				return true;
			}

			System.out.println("ERROR: DNI no valido");
			return false;
		}
}
