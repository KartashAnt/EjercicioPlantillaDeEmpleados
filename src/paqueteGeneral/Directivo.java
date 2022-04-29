package paqueteGeneral;

//Clase para identificar un directivo
public class Directivo extends Empleado {
	//Caracteristica basica de un directivo
	private boolean consejo;

	// Constructor que pasa caracteristicas basicas al superclase. Además paso los valores de variables nesesarios para calculos
		// Además paso la caracteristica basica de ese clase
	public Directivo(String nombre, String apellidos, String dni, int antiguedad, boolean consejo) {
		super(nombre, apellidos, dni, antiguedad, 4500, 0.73, 0.12);
		this.consejo = consejo;
	}

	//Implemento metodo de clase padre
	@Override
	public double sueldoBruto() {
		return super.getSueldoBase() + (100.0 * super.getContAnyos());
	}
	
	//Implemento metodo de Interfaz Cobros pasado a traves de clase abstracta padre
	@Override
	public double indemnizacion() {
		//Comparo Indeminización teorica de ese empleado con una máxima para este empleado
		double indeminisación = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos();
		double max = super.getSueldoBase() * 24;
		return Math.round(Math.min(indeminisación, max) * 100.0) / 100.0;
	}

	//Implemento metodo de Interfaz Cobros heredido de clase abstracta padre
	@Override
	public double sueldoNeto() {
		//Lo calculo y redondeo
		return Math.round(this.sueldoBruto() * super.getNeto() * 100.0) / 100.0 + 200.0 * ((this.consejo) ? 1 : 0);
	}

	//El toString que usa toString de clase padre
	@Override
	public String toString() {
		return super.toString() + "Directivo" + (consejo ? ", Miembro de Consejo" : "");
	}

	//Getters y Setters basicos
	public boolean isConsejo() {
		return consejo;
	}

	public void setConsejo(boolean consejo) {
		this.consejo = consejo;
	}

}
