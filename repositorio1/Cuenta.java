package banco;


/**

 * Esta clase define las funciones basicas de una cuenta bancaria en función a saldo que esta definido como enteros

 * @author Larronte

 * @version 1Daw 
 */



public class Cuenta {

	private String numero;
	private String titular;
	private double saldo;
	private boolean bloqueada;

	
	public Cuenta(String numero, String titular) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 0;
		this.bloqueada = false;
	}
/**
 * Constructor para la cuenta bancaria
 * @param dineroIngresado La cantidad que se ingresa en la cuenta con decimales
 * @return el dinero ingresado en la cuenta
 */
	protected double ingresarDinero(double dineroIngresado) {
		if (dineroIngresado > 0) {
			this.saldo = this.saldo + dineroIngresado;
			comprobarBloqueo();
			return dineroIngresado;
		} else {
			System.out.println("El dinero ingresado debe ser mayor que 0");
			return 0;
		}

	}
	

	/**
	 * Metodo para retirar dinero sin que sea mayor que el saldo de la cuenta
	 * @param dineroRetirado la cantidad que va a retirar sin que sea mayor que el saldo de la cuenta
	 * @return dienero retirado de la cuenta
	 */

	protected double retirarDinero(double dineroRetirado) {
		if (dineroRetirado > 0 && dineroRetirado <= 500) {
			this.saldo = this.saldo - dineroRetirado;
			comprobarBloqueo();
			return dineroRetirado;
		} else {
			System.out.println("El dinero retirado debe ser mayor que 0 y menor o igual que 500");
			return 0;
		}

	}
	
	/**
	 * Metodo para comprobar si le cuenta debe ser bloqueada, la cuenta debera ser bloqueda si su saldo es inferior a 0
	 */

	protected boolean comprobarBloqueo() {
		if (this.saldo <= 0) {
			bloquearCuenta();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Metodo para bloquear cuenta mostrando por pantalla un mensaje.
	 */

	protected boolean bloquearCuenta() {
		this.bloqueada = true;
		System.out.println("La cuenta ha sido bloqueada");
		return true;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}
}
