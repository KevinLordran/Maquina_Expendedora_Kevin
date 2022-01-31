package com.curso.pruebas;

import java.util.Scanner;

import com.curso.Maquina_Expendedora_Kevin.Maquina;

public class TestMaquina {

	public static void main(String[] args) {
		
		Maquina m = new Maquina();
		Scanner sr = new Scanner(System.in);
		System.out.println("La máquina tiene: " + m.getRefrescos().length + " tipos de refrescos.");
		System.out.println("Tiene: ");
		for(int i = 0; i < m.getRefrescos().length; i++) {
			System.out.println(m.getRefrescos()[i].getStock() + " latas de " + m.getRefrescos()[i].getNombre() + " (Tecla " + (i+1) + ")");
		}
		do {
			System.out.println("===========================================");
			System.out.println("Introduzca el número del producto deseado: ");
			System.out.println("===========================================");
			m.opcion = sr.nextInt();
			System.out.println("1 lata de " + m.getRefrescos()[m.opcion-1].getNombre() + " cuesta " + m.saberPrecio(m.opcion-1));
			System.out.println("===========================================");
			System.out.println("¿Desea comprar? (S/N)");
			System.out.println("===========================================");
			String decision = sr.next();
			if(decision.equals("S")) {
				if(m.comprobarStock() == true) {
					double pago;
					do{
						System.out.println("Introduzca importe---->");
						pago = sr.nextDouble();
						m.comprobarImporte(pago);
					}while(m.getRefrescos()[m.opcion].getPrecio() > pago);
					m.comprar(pago);
				}else {
					System.out.println("No nos queda stock de esa bebida.");
				}
				
			}else {
				System.out.println();
				System.out.println();
			}
		}while(m.getRefrescos() != null);
		
		
	}

}
