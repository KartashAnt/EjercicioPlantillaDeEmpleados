package paqueteGeneral;

//Clase para identificar un mozo de almacen
public class MozoDeAlmacen extends Empleado {

	// Constructor que pasa caracteristicas basicas al superclase. Además paso los valores de variables nesesarios para calculos
	public MozoDeAlmacen(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad, 1545.5, 0.85, 0.05);
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
		double indeminisación = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos();
		double max = super.getSueldoBase() * 12;
		return Math.round(Math.min(indeminisación, max) * 100.0) / 100.0;
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
		return super.toString() + "Mozo de Almacen";
	}
}
