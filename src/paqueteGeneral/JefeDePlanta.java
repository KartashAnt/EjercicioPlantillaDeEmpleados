package paqueteGeneral;

public class JefeDePlanta extends Empleado {
	private int cat;

	public JefeDePlanta(String nombre, String apellidos, String dni, int antiguedad, double aumento, int cat) {
		super(nombre, apellidos, dni, antiguedad , 1825.5, 0.81, 0.9);
		this.cat = cat;
	}

	@Override
	public double sueldoBruto() {
		return super.getSueldoBase()+(60.0*this.cat);
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
