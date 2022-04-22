package paqueteGeneral;

public abstract class Empleado implements Cobros{
	private String nombre;
	private String apellidos;
	private String dni;
	private int antiguedad;
	private double sueldoBase;
	private double neto;
	private double aumento;
	private double contAnyos=0;
	
	public Empleado(String nombre, String apellidos, String dni, int antiguedad ,double sueldoBase, double neto , double aumento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.neto=neto;
		this.aumento = aumento;
		contarAnyos();
	}

	public abstract double sueldoBruto();
	
	public void contarAnyos() {
		while(this.antiguedad-(this.contAnyos*365)>=365) {
			contAnyos++;
			this.sueldoBase+=this.sueldoBase*aumento;
			sueldoBase=Math.round(sueldoBase *100.0)/100.0;
		}
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos + " " + this.dni + " lleva " +this.antiguedad + "dias en la empresa en el puesto de ";
	}

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

	public double getContAnyos() {
		return contAnyos;
	}

	public void setContAnyos(double contAnyos) {
		this.contAnyos = contAnyos;
	}
	
}
