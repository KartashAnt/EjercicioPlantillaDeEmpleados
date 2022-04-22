package paqueteGeneral;

public class PersonalDeAdministracion extends Empleado {
	
	public PersonalDeAdministracion(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad, 1635, 0.84, 0.06);
	}

	@Override
	public double sueldoBruto() {
		return super.getSueldoBase();
	}

	@Override
	public double indemnizacion() {
		double indeminisación = super.getSueldoBase() * (2.0 / 3.0) * super.getContAnyos();
		double max = super.getSueldoBase() * 12;
		return Math.round(Math.min(indeminisación, max) * 100.0) / 100.0;
	}
	@Override
	public double sueldoNeto() {
		return this.sueldoBruto()*super.getNeto();
	}
	
	@Override
	public String toString() {
		return super.toString() + "Personal de Administraci\u00F3n";
	}
}
