package paqueteGeneral;


public class JefeDeSeccion extends Empleado {
	private int cat;

	public JefeDeSeccion(String nombre, String apellidos, String dni, int antiguedad, double aumento, int cat) {
		super(nombre, apellidos, dni, antiguedad , 1750, 0.83, 0.7);
		this.cat = cat;
	}

	@Override
	public double sueldoBruto() {
		return super.getSueldoBase()+(50.0*this.cat);
	}

	@Override
	public double indemnizacion() {
		double indeminisación = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos() + (400.0*this.cat);
		double max = super.getSueldoBase() * 12;
		return Math.round(Math.min(indeminisación, max) * 100.0) / 100.0;
	}

	@Override
	public double sueldoNeto() {
		return this.sueldoBruto()*super.getNeto();
	}
}
