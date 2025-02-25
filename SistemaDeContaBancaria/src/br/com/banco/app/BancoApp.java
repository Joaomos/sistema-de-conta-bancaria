package br.com.banco.app;

import java.util.Scanner;

import br.com.banco.model.Conta;
import br.com.banco.service.Banco;
import br.com.banco.view.BancoView;

public class BancoApp {
	private Banco banco;
	private BancoView bancoView;
	private Scanner entrada;
	
	public BancoApp() {
		super();
		this.banco = new Banco();
		this.bancoView = new BancoView();
		this.entrada = new Scanner(System.in);
	}
	
	public void inicializarSistema() {
		int opcao;
		do {
			bancoView.exibirMenu();
			System.out.println("Escolha uma opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			processarOpcao(opcao);
		} while(opcao != 0);
		System.out.println("Sistema encerrado.");
		entrada.close();
	}
	
	public void processarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			criarConta();
			break;
		case 2:
			excluirConta();
			break;
		case 3:
			depositar();
			break;
		case 4:
			sacar();
			break;
		case 5:
			transferir();
			break;
		case 6:
			consultarSaldo();
			break;
		case 0:
            System.out.println("Saindo do sistema...");
            break;
        default:
            System.out.println("Opção inválida! Tente novamente.");
		}
	}
	
	public void criarConta() {
		int agencia;
		String titular;
		
		System.out.println("Digite o nome do titular da conta: ");
		titular = entrada.nextLine();
		System.out.println("Digite a agência: ");
		agencia = entrada.nextInt();
			
		Conta conta = new Conta(titular, agencia);
		banco.adicionarConta(conta);
		 
	}
	
	public void excluirConta() {
		int numeroConta;
		System.out.println("Digite o número da conta que deseja excluir: ");
		numeroConta = entrada.nextInt();
		
		banco.removerConta(numeroConta);
	}
	
	public void depositar() {
		int numeroConta;
		double valor;
		System.out.println("Digite o número da conta que deseja depositar o dinheiro: ");
		numeroConta = entrada.nextInt();
		System.out.println("Digite o valor que deseja depositar: ");
		valor = entrada.nextDouble();
		
		banco.depositar(numeroConta, valor);
		
	}
	
	public void sacar() {
		int numeroConta;
		double valor;
		System.out.println("Digite o número da conta que deseja sacar o dinheiro: ");
		numeroConta = entrada.nextInt();
		System.out.println("Digite o valor que deseja sacar: ");
		valor = entrada.nextDouble();
		
		banco.sacar(numeroConta, valor);
	}
	
	public void transferir() {
		int numeroContaOrigem, numeroContaDestino;
		double valor;
		
		System.out.println("Digite o número da conta de origem: ");
		numeroContaOrigem = entrada.nextInt();
		
		System.out.println("Digite o número da conta de destino: ");
		numeroContaDestino = entrada.nextInt();
		
		System.out.println("Digite o valor que deseja transferir: ");
		valor = entrada.nextDouble();
		
		banco.transferir(valor, numeroContaOrigem, numeroContaDestino);
	}
	
	public void consultarSaldo() {
		int numeroConta;
		System.out.println("Digite o número da conta que deseja saber o saldo: ");
		numeroConta = entrada.nextInt();
		
		banco.exibirSaldo(numeroConta);
	}
	
	public static void main(String[] args) {
		BancoApp sistema = new BancoApp();
		sistema.inicializarSistema();
	}
}
