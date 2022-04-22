package paqueteGeneral;

public class Directivo extends Empleado {
	private boolean consejo;

	public Directivo(String nombre, String apellidos, String dni, int antiguedad, boolean consejo) {
		super(nombre, apellidos, dni, antiguedad, 4500, 0.73, 0.12);
		this.consejo = consejo;
	}

	@Override
	public double sueldoBruto() {
		return super.getSueldoBase()+(100.0*super.getContAnyos());
	}

	@Override
	public double indemnizacion() {
		double indeminisación = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos();
		double max = super.getSueldoBase() * 24;
		return Math.round(Math.min(indeminisación, max) * 100.0) / 100.0;
	}

	@Override
	public double sueldoNeto() {
		return this.sueldoBruto()*super.getNeto()+200.0*((this.consejo) ? 1:0);
	}
	
	public boolean isConsejo() {
		return consejo;
	}

	public void setConsejo(boolean consejo) {
		this.consejo = consejo;
	}
	
}
