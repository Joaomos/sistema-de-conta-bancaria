package br.com.banco.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Conta {
	protected int numeroConta;
	protected String titular;
	protected Double saldo = 0.0;
	protected int agencia;
	private static final Set<Integer> numerosGerados = new HashSet<>();
	
	
	public Conta(String titular, int agencia) {
		super();
		this.titular = titular;
		this.agencia = agencia;
		this.numeroConta = gerarNumeroConta();
	}
	
	
	public String getTitular() {
		return titular;
	}


	public Double getSaldo() {
		return saldo;
	}
	
	


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public int getAgencia() {
		return agencia;
	}


	public int getNumeroConta() {
		return numeroConta;
	}



	private int gerarNumeroConta() {
		Random random = new Random();
		do {
			numeroConta = 100 + random.nextInt(900);
		} while (numerosGerados.contains(numeroConta));
		
		numerosGerados.add(numeroConta);
		return numeroConta;
	}
}
