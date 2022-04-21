package paqueteGeneral;

public abstract class Empleado{
	private String nombre;
	private String apellidos;
	private String dni;
	private int antiguedad;
	private double sueldoBase;
	private double neto;
	private double aumento;
	
	public Empleado(String nombre, String apellidos, String dni, double sueldoBase, double neto , double aumento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.antiguedad = 0;
		this.sueldoBase = sueldoBase;
		this.neto=neto;
		this.aumento = aumento;
	}

	public abstract double sueldoBruto();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getNeto() {
		return neto;
	}

	public void setNeto(double neto) {
		this.neto = neto;
	}

	public double getAumento() {
		return aumento;
	}

	public void setAumento(double aumento) {
		this.aumento = aumento;
	}
	
	
}
