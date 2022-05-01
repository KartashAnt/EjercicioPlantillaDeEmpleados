package paqueteGeneral;

//Clase para identificar un personal de administración
public class PersonalDeAdministracion extends Empleado {

	// Constructor que pasa caracteristicas basicas al superclase. Además paso los valores de variables nesesarios para calculos
	public PersonalDeAdministracion(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad, 1635, 0.84, 0.06);
	}

	//Implemento metodo de clase padre
	@Override
	public double sueldoBruto() {
		return super.getSueldoBase();
	}

	//Implemento metodo de Interfaz Cobros pasado a traves de clase abstracta padre
	@Override
	public double indemnizacion() {
		//Comparo Indeminización teorica de ese empleado con una máxima para este empleado
		double indeminisacion = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos();
		double max = super.getSueldoBase() * 12;
		return Math.round(Math.min(indeminisacion, max) * 100.0) / 100.0;
	}

	//Implemento metodo de Interfaz Cobros herdido de clase abstracta padre
	@Override
	public double sueldoNeto() {
		//Lo calculo y redondeo
		return Math.round(this.sueldoBruto() * super.getNeto() * 100.0) / 100.0;
	}

	//El toString que usa toString de clase padre
	@Override
	public String toString() {
		return super.toString() + "Personal de Administraci\u00F3n";
	}
}
