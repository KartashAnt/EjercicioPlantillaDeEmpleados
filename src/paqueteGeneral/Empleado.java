package paqueteGeneral;

//Clase abstracto para definir cualquier empleado. Implementamos interfaz Cobros aunque no desarollamos sus metodos en el clase dado.
// Lo dejamos para los clases hijos, ya que este es una clase abstracta
public abstract class Empleado implements Cobros {
	//Caracteristicas basicas de un empleado
	private String nombre;
	private String apellidos;
	private String dni;
	private int antiguedad;
	
	//Caracteristicas estaticas que participan en calculo
	private double sueldoBase;
	private double neto;
	private double aumento;
	
	//Caracteristica dinamica que participa en calculos
	private double contAnyos = 0;

	//Constructor con todos los datos. Pide nombre,apellidos,DNI,antiguedad,sueldo base, porciento de sueldo neto y aumento anual del sueldo base
	public Empleado(String nombre, String apellidos, String dni, int antiguedad, double sueldoBase, double neto,
			double aumento) {
		//Constructor vacío de superclase Objeto
		super();
		//Asigno Caracteristicas
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.neto = neto;
		this.aumento = aumento;
		//Conto años por si acaso se mete un empleado con años de expiriencia en la empresa
		contarAnyos();
	}

	//Metodo abstracto para calcular sueldo bruto
	public abstract double sueldoBruto();

	//Metodo para contar años y subir sueldo base por el aumento
	public void contarAnyos() {
		//Bucle para ver si lo tenemos guardado bien su cantidad de años en la nuestra empresa
		while (this.antiguedad - (this.contAnyos * 365) >= 365) {
			contAnyos++;
			//Aumento sueldoBase
			this.sueldoBase += this.sueldoBase * aumento;
			sueldoBase = Math.round(sueldoBase * 100.0) / 100.0;
		}
		
	}

	//Metodo para mostrar sueldo bruto,sueldo neto e Indemnización de un empleado
	public void mostrarNetoEIdemnizacion() {
		System.out.println(this.nombre + " " + this.apellidos);
		System.out.println("Sueldo Bruto: " + this.sueldoBruto() + "\u20AC");
		System.out.println("Sueldo Neto: " + this.sueldoNeto() + "\u20AC");
		System.out.println("Indemnizaci\u00F3n: " + this.indemnizacion() + "\u20AC");
	}

	//El toString basico. Lo seguimos desarollando en hijos
	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos + " " + this.dni + " lleva " + this.antiguedad
				+ " dias en la empresa en el puesto de ";
	}
	
	//Alternativa a toString
	public String datosConSueldoNeto() {
		return this.nombre + " " + this.apellidos + " " + this.dni + " lleva " + this.antiguedad
				+ " dias en empresa con el salario Neto " + this.sueldoNeto() + "\u20AC";
	}

	//Getters y Setters basicos
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
