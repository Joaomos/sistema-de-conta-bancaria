package br.com.banco.service;

import java.util.ArrayList;

import br.com.banco.model.Conta;

public class Banco {
	
	private ArrayList<Conta> contas = new ArrayList<>();
	
	public void adicionarConta(Conta conta) {
		boolean sucesso = contas.add(conta);
		if(sucesso) {
			System.out.println("Conta adcionada com sucesso.");
			System.out.println("\n=== Dados da conta ===\n"
					+ "Numero da conta: " + conta.getNumeroConta() + "\n"
					+ "Titular: " + conta.getTitular() + "\n"
					+ "Saldo: R$ " + conta.getSaldo() + "\n"
					+ "Agência: " + conta.getAgencia() + "\n");
		} else {
			System.out.println("A operação falhou. Tente novamente.");
		}
	}
	
	public void removerConta(int numeroConta) {
		
		for (Conta conta : contas) {
			if(conta.getNumeroConta() == numeroConta) {
				contas.remove(conta);
				System.out.println("Conta removida com sucesso.");
				return;
			} 
		}
		
		System.out.println("A operação falhou. Tente novamente.");
		
	}
	
	public String buscarConta(int numeroConta) {
		for (Conta conta : contas) {
			if(conta.getNumeroConta() == numeroConta) {
				return "Numero da conta: " + numeroConta + "\n"
						+ "Titular: " + conta.getTitular() + "\n"
						+ "Saldo: " + conta.getSaldo() + "\n"
						+ "Agência" + conta.getAgencia() + "\n";
			}
		}
		return "O numero da conta digitado não está cadastrado.";
	}
	
	public void depositar(int numeroConta, Double valor) {
		if (valor > 0) {
			for (Conta conta : contas) {
				if (conta.getNumeroConta() == numeroConta) {
					Double novoSaldo = conta.getSaldo() + valor;
					conta.setSaldo(novoSaldo);
					System.out.println("Deposito bem sucedido.");
					return;
				}
			}			
		} else {
			System.out.println("O valor digitado deve ser maior que zero.");			
		}
	}
	
	public void sacar(int numeroConta, Double valor) {
		for (Conta conta : contas) {
			if (conta.getNumeroConta() == numeroConta) {
				if(valor > conta.getSaldo()) {
					System.out.println("Saldo insuficiente.");
				} else if (valor > 0) {
					Double novoSaldo = conta.getSaldo() - valor;
					conta.setSaldo(novoSaldo);
					System.out.println("Saque bem sucedido.");
				} else {
					System.out.println("O valor digitado deve ser maior que zero.");
				}							
			}
		}
	}
	
	public void exibirSaldo(int numeroConta) {
		
		for (Conta conta : contas) {
			if (conta.getNumeroConta() == numeroConta) {
				System.out.println("Saldo da conta " + numeroConta + ": R$" + conta.getSaldo());
				return;
			} 
		}
		
		System.out.println("Conta não encontrada.");
	}
	
	public void transferir(double valor, int numeroContaOrigem, int numeroContaDestino) {
		Conta origem = null;
	    Conta destino = null;

	    for (Conta conta : contas) {
	        if (conta.getNumeroConta() == numeroContaOrigem) {
	            origem = conta;
	        } else if (conta.getNumeroConta() == numeroContaDestino) {
	            destino = conta;
	        }
	    }

	    if (origem == null) {
	        System.out.println("Conta de origem não encontrada.");
	        return;
	    }
	    if (destino == null) {
	        System.out.println("Conta de destino não encontrada.");
	        return;
	    }

	    if (origem == destino) {
	        System.out.println("Não é possível transferir para a mesma conta.");
	        return;
	    }
	    
	    if (origem.getSaldo() >= valor) {
	        origem.setSaldo(origem.getSaldo() - valor); 
	        destino.setSaldo(destino.getSaldo() + valor); 
	        System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
	    } else {
	        System.out.println("Saldo insuficiente para transferência.");
	    }

	}
}
