package paqueteGeneral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal {
	// Sitio para guardar los empleados
	static ArrayList<Empleado> empleados = new ArrayList<>();
	// Scanner
	static Scanner sc = new Scanner(System.in);

	//main que ejecuto
	public static void main(String[] args) {
		//Inicializo programa
		inicializar();
		//Voy al menu principal
		menuPrincipal();
		//Mensaje de finilización de la programa
		System.out.println("Programa ha sido acabado con exito");
	}

	//Inicio de la programa. Creo los empleados
	public static void inicializar() {
		
		empleados.add(new MozoDeAlmacen("Ramon", "Joven Letov", "35775553C", 30));
		empleados.add(new JefeDePlanta("Pepe", "Cerdo Malvado", "05535530G", 20, 2));
		empleados.add(new Directivo("John", "Apellido", "65003200B", 0, true));
		empleados.add(new MozoDeAlmacen("Ivan", "Iban", "20202086E", 10));
		
	}

	//Menu principal
	public static void menuPrincipal() {
		int entrada;
		boolean ejecutar = true;
		while (ejecutar) {
			//Pinto Menu
			System.out.println("MENU PRINCIPAL");
			System.out.println(	"1.- Introducir trabajador\n" + 
								"2.- Eliminar trabajador\n" + 
								"3.- Listado trabajadores\n" + 
								"4.- Listado trabajadores por puesto\n" + 
								"5.- Avance temporal\n"	+
								"6.- Mostrar matriz d\u00EDas trabajados\n" + 
								"7.- Acabar programa\n");
			//Pido elegir una opción
			System.out.print("Elige una opci\u00F3n: ");
			entrada = enteroNoNegativo();
			switch (entrada) {
			//Introducir Empleado
			case 1:
				introducirEmpleado();
				break;
			//Eliminar Empleado
			case 2:
				eliminarEmpleado();
				break;
			//Listar empleados
			case 3:
				listadoDetalladoEmpleados();
				break;
			//Listar empleados de un cierto puesto
			case 4:
				listadoPuesto();
				break;
			//Avance temporal
			case 5:
				avanceTemporal();
				break;
			//Mostrar tabla compartiva de la antiguedad de los trabajadores de varios puestos
			case 6:
				matrizEmpleados();
				break;
			//Acabar programa
			case 7:
				//Aseguramos de que el cliente quiere apagar la programa
				System.out.println("Esta seguro de que quiere acabar la programa (S/N)?");
				if (aseguro()) {
					ejecutar = false;
				}
				break;
			//Opción invalida
			default:
				System.out.println("Opci\u00F3n invalida");
				break;
			}
		}

	}

	// Metodo para introducir a un empleado
	public static void introducirEmpleado() {
		//Pido nombre
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		//Pido apellidos
		System.out.print("Apellidos: ");
		String apellidos = sc.nextLine();
		//Pido DNI valido
		System.out.print("DNI: ");
		String dni;
		do {
			dni = sc.nextLine();
		} while (!validarDNI(dni));
		//Pido tipo de un empleado
		int tipo = tipoEmpleado();
		//Pido su antiguedad actual en la empresa
		System.out.print("Antiguedad: ");
		int antiguedad = enteroNoNegativo();
		int cat = 0;
		boolean consejo;
		//Creo empleado según su tipo
		switch (tipo) {
		//Mozo de almacen
		case 1:
			System.out.println("Nuevo Mozo de almacen registrado");
			empleados.add(new MozoDeAlmacen(nombre, apellidos, dni, antiguedad));
			break;
		//Jefe de Seccion
		case 2:
			//Pido categoría
			while (cat < 1 || cat > 3) {
				System.out.print("Categor\u00EDa(1-3): ");
				cat = enteroNoNegativo();
			}
			System.out.println("Nuevo Jefe de Secci\u00F3n registrado");
			empleados.add(new JefeDeSeccion(nombre, apellidos, dni, antiguedad, cat));
			break;
		//Jefe de Planta
		case 3:
			//Pido categoría
			while (cat < 1 || cat > 4) {
				System.out.print("Categor\u00EDa(1-4): ");
				cat = enteroNoNegativo();
			}
			System.out.println("Nuevo Jefe de Planta registrado");
			empleados.add(new JefeDePlanta(nombre, apellidos, dni, antiguedad, cat));
			break;
		//Personal de Administración
		case 4:
			System.out.println("Nuevo Personal De Administraci\u00F3n");
			empleados.add(new PersonalDeAdministracion(nombre, apellidos, dni, antiguedad));
			break;
		//Directivo
		case 5:
			//pregunto si es uno de los miembros del consejo
			System.out.println("Indique si es el miembro del consejo (S/N)");
			consejo = aseguro();
			System.out.println("Nuevo Directivo registrado");
			empleados.add(new Directivo(nombre, apellidos, dni, antiguedad, consejo));
			break;
		//Tipo invalido
		default:
			System.out.println("Error impredecible ocurrio");
			break;
		}

	}

	//Metodo para eliminar un empleado
	public static void eliminarEmpleado() {
		//Borro hasta que asi lo quiere el cliente o hasta que no me quedan más empleados para borrar
		while (true) {
			//Si hay empleados para borrar
			if (empleados.size() > 0) {
				//Listo empleados
				listarEmpleados();
				//Pido selecionar un empleado para borrar o introducir 0 para acabar el borrado
				System.out.println("Elija un empleado para borrar (0 - para salir):");
				int entrada = enteroNoNegativo() - 1;
				//Acabamos eliminado
				if (entrada == -1) {
					System.out.println("Eliminado acabado");
					return;
				}
				//Si existe ese empleado
				if (entrada < empleados.size()) {
					//Aseguro antes de borrar un empleado
					System.out.println("Eres seguro que quieres borrar el siguiente empleado");
					System.out.println(empleados.get(entrada));
					if (aseguro())
						empleados.remove(entrada);
					else
						System.out.println("Borrado cancelado");
				}
				//Si no existe empleado pedido
				else {
					System.out.println("Error: empleado no existe");
				}
			} 
			//Si no hay empleados para borrar
			else {
				System.out.println("No hay empleados agregados en la sistema");
				return;
			}
		}
	}

	//Listamos empleados con posibilidad de selecionar uno y ver sus datos detallados
	public static void listadoDetalladoEmpleados() {
		//Si hay empleados para listar
		if (empleados.size() > 0) {
			//Listo empleados
			listarEmpleados();
			//Pido numero de empleado para listar su info detallado
			System.out.println("Seleccione un empleado para ver la información detallada:");
			int entrada = enteroNoNegativo() - 1;
			//Si empleado existe muestro su info detallado
			if (entrada >= 0 && entrada < empleados.size()) {
				empleados.get(entrada).mostrarNetoEIdemnizacion();
			} 
			//Si empleado no existe
			else {
				System.out.println("Error: empleado no existe");
			}
		} 
		//Si no hay empleados
		else {
			System.out.println("No hay empleados disponibles");
		}
	}

	//Listo empleados de un cierto puesto
	public static void listadoPuesto() {
		//Pregunto tipo de empleado
		int tipo = tipoEmpleado();
		//Seleccionamos clase en funcion de su tipo
		Class clase;
		switch (tipo) {
		case 1:
			clase = MozoDeAlmacen.class;
			break;
		case 2:
			clase = JefeDeSeccion.class;
			break;
		case 3:
			clase = JefeDePlanta.class;
			break;
		case 4:
			clase = PersonalDeAdministracion.class;
			break;
		case 5:
			clase = Directivo.class;
			break;
		//En el caso que ocurra una error impredecible acabo este metodo antes para evitar una error
		default:
			System.out.println("Error impredecible");
			return;
		}
		//buscamos empleados de ese tipo
		boolean esta = false;
		for (int i = 0; i < empleados.size(); i++) {
			if (clase.isInstance(empleados.get(i))) {
				System.out.println(empleados.get(i).datosConSueldoNeto());
				esta = true;
			}
		}
		//Si no hemos encontrado ningun empleado de ese tipo
		if (!esta) {
			System.out.println("No hay empleados de ese tipo");
		}
	}
	
	//Avance temporal
	public static void avanceTemporal() {
		//Pido numero de dias para avanzar
		System.out.print("Cuantos dias: ");
		int dias = enteroNoNegativo();
		//Sumo esa cantidad de dias a la antiguedad de un empleado y hago recuento de años para aumentar sueldo base
		for (Empleado empleado : empleados) {
			empleado.setAntiguedad(empleado.getAntiguedad() + dias);
			empleado.contarAnyos();
		}
	}

	//Metodo para mostrar matriz de puesto,menor antiguedad dentro de ese puesto,
	//mayor cantidad dentro de ese puesto y media de dias trabajada por los trabajadores de ese puesto
	public static void matrizEmpleados() {
		//Todos los puestos
		Class[] clases = { MozoDeAlmacen.class, JefeDeSeccion.class, JefeDePlanta.class, PersonalDeAdministracion.class,
				Directivo.class };
		//Lista para almacenar empleados de cada tipo
		ArrayList<Empleado> almacen = new ArrayList<>();
		//Comparador de los empleados por la antiguedad
		Comparator<Empleado> comparadorPorAntiguedad = new Comparator<Empleado>() {
			@Override
			public int compare(Empleado arg0, Empleado arg1) {
				return arg0.getAntiguedad() - arg1.getAntiguedad();
			}
		};
		//Nombres de las columnas de la futura tabla
		String[] nombresColumnas = { "Puesto", "Menos antiguo", "Mas antiguo", "Media" };
		//Matriz
		Integer[][] datosColumnas = new Integer[5][4];
		//Sumatorio de dias acumulados por todos los trabajadores de mismo puesto
		int sumaDias;
		//Contador de los trabajadores de mismo puesto
		int contTrabajadores;
		for (int i = 0; i < clases.length; i++) {
			//Guardo numero de puesto
			datosColumnas[i][0] = i + 1;
			//Vacío el almacen
			almacen.clear();
			//Anulo sumatorio y contados
			sumaDias = 0;
			contTrabajadores = 0;
			//Recorro empleados buscando instancias de cada puesto
			for (Empleado empleado : empleados) {
				if (clases[i].isInstance(empleado)) {
					sumaDias += empleado.getAntiguedad();
					contTrabajadores++;
					almacen.add(empleado);
				}
			}
			//Si no hay trabajadores de ese puesto relleno su fila de matriz con 0s
			if (contTrabajadores == 0) {
				for (int j = 1; j < datosColumnas[i].length; j++) {
					datosColumnas[i][j] = 0;
				}
			} 
			//Si hay al menos un trabajador ocupando ese puesto
			else {
				//Sorteo almacen por antiguedad y guardo cantidad de dias de primero y último trabajador sorteados
				//También guardo media
				Collections.sort(almacen, comparadorPorAntiguedad);
				datosColumnas[i][1] = almacen.get(0).getAntiguedad();
				datosColumnas[i][2] = almacen.get(almacen.size() - 1).getAntiguedad();
				datosColumnas[i][3] = sumaDias / contTrabajadores;
			}
		}
		//Pinto lo en forma de una tabla de java
		JTable tabla = new JTable(datosColumnas, nombresColumnas);
		JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
	}

	//Metodo para listar empleados
	public static void listarEmpleados() {
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println((i + 1) + ".- " + empleados.get(i));
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
		//Me vale solo S o N
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

	// Metodo para selecionar tipo de empleado
	public static int tipoEmpleado() {
		int tipo = 0;
		//Solo me valen numeros entre 1 y 5, porque tengo solamente 5 tipos de los empleados
		while (tipo < 1 || tipo > 5) {
			//Pido Tipo
			System.out.print("Tipo de trabajador (0 para ayuda): ");
			tipo = enteroNoNegativo();
			//Mensaje de ayuda
			if (tipo == 0) {
				JOptionPane.showMessageDialog(null,	"Tipos disponibles\n" + 
													"1.- Mozo de almacen\n" + 
													"2.- Jefe de Secci\u00F3n\n" +
													"3.- Jefe de Planta\n" +
													"4.- Personal de Administraci\u00F3n\n" +
													"5.- Directivo");
			}
		}
		return tipo;
	}
}
