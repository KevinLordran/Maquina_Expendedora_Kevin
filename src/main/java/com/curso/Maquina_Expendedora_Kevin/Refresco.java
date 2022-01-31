package com.curso.Maquina_Expendedora_Kevin;

import java.util.Random;

public class Refresco {
	//Atributos
	private String nombre;
	private double precio;
	public int stock;
	private enum TipoBebida {
		RedBull(1.50),
		CocaCola(1.00),
		Pepsi(1.00),
		Nestea(1.20),
		KasLimón(1.10),
		KasNaranja(1.10),
		Agua(0.50),
		Sprite(1.20),
		Café(0.60),
		Monster(2.00);
		private double precio;
		private TipoBebida(double precio) {
			this.precio = precio;
		}
		private double getPrecio() {
			return precio;
		}
	};
	//Constructores
	public Refresco(int i) {
		Random rng = new Random();
		nombre = TipoBebida.values()[i].name();
		precio = TipoBebida.values()[i].getPrecio();
		stock = rng.nextInt(15)+1;
	}
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return stock;
	}
	//Métodos
	public void addStock(int carga) {
		if(this.getStock() < 15 && (this.getStock() + carga) < 15) {
			stock = stock + carga;
			System.out.println("Se han recargado " + carga + " latas de " + this.nombre);
			
		}else {
			System.out.println("No hay espacio para recargar la bebida.");
		}
	}	
}
