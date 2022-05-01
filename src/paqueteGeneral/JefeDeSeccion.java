package paqueteGeneral;

//Clase para identificar un jefe de seccion
public class JefeDeSeccion extends Empleado {
	//Caracteristica de un jefe de seccion
	private int cat;

	// Constructor que pasa caracteristicas basicas al superclase. Además paso los valores de variables nesesarios para calculos
	// Además paso la caracteristica basica de ese clase
	public JefeDeSeccion(String nombre, String apellidos, String dni, int antiguedad, int cat) {
		super(nombre, apellidos, dni, antiguedad , 1750, 0.83, 0.7);
		this.cat = cat;
	}

	//Implemento metodo de clase padre
	@Override
	public double sueldoBruto() {
		return super.getSueldoBase()+(50.0*this.cat);
	}

	//Implemento metodo de Interfaz Cobros pasado a traves de clase abstracta padre
	@Override
	public double indemnizacion() {
		//Comparo Indeminización teorica de ese empleado con una máxima para este empleado
		double indeminisacion = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos() + (400.0*this.cat);
		double max = super.getSueldoBase() * 12;
		return Math.round(Math.min(indeminisacion, max) * 100.0) / 100.0;
	}

	//Implemento metodo de Interfaz Cobros heredido de clase abstracta padre
	@Override
	public double sueldoNeto() {
		//Lo calculo y redondeo
		return Math.round(this.sueldoBruto()*super.getNeto()*100.0)/100.0;
	}
	
	//El toString que usa toString de clase padre
	@Override
	public String toString() {
		return super.toString() + "Jefe de sección de la " + this.cat + " categor\u00EDa";
	}

	//Getters y Setters basicos
	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}
	
}
