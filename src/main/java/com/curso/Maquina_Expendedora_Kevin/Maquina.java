package com.curso.Maquina_Expendedora_Kevin;

public class Maquina {
	// Atributos
	private Refresco[] refrescos;
	private double cambiosMaquina;
	public double vueltasUsuario;
	public int opcion;

	// Constructores
	public Maquina() {
		refrescos = new Refresco[10];
		cambiosMaquina = 10.0;
		loadMaquina();
	}

	// Getters y Setters
	public Refresco[] getRefrescos() {
		return refrescos;
	}
	public double getCambios() {
		return cambiosMaquina;
	}

	// Métodos
	public void loadMaquina() {
		for(int i = 0; i < refrescos.length; i++) {
			refrescos[i] = new Refresco(i);
		}
	}

	public double saberPrecio(int huecoRefresco) {
		return refrescos[huecoRefresco].getPrecio();			
	}
	
	public boolean comprobarStock() {
		if(getRefrescos()[opcion].getStock() > 0) {
			return true;
		}else {
			return false;
		}
	}
	public void comprobarImporte(double pago) {
		if(getRefrescos()[opcion].getPrecio() > pago) {
			System.out.println("Importe introducido insuficiente...");
		}else{
			vueltasUsuario = 0.0;
			cambiosMaquina += pago;
			if(getRefrescos()[opcion].getPrecio() < pago) {
				vueltasUsuario = pago - getRefrescos()[opcion].getPrecio();
				cambiosMaquina -= pago - vueltasUsuario;
			}
		}
	}
	public void comprar(double pago) {
		getRefrescos()[opcion].stock = getRefrescos()[opcion].stock - 1; 
		System.out.println("...Bebida entregada...");
		if(vueltasUsuario > 0.0) {
			System.out.println("Sus vueltas son " + vueltasUsuario);
		}
	}

}
