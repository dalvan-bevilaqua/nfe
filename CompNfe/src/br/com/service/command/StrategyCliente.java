package br.com.service.command;

import java.sql.SQLException;
import java.util.List;

import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Cliente;
import br.com.vaccine.service.controller.Process;

public class StrategyCliente {

	public static Cliente strategyCliente(Process processo, List<Cliente> clientes,TNFe nfe) {
		Cliente cli = null;
		try {			
			cli = loadCliente(processo, clientes, nfe);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cli;

	}	
	
	public static Cliente strategyCliente(Process processo, List<Cliente> clientes, TNfeProc proc) {
		Cliente cli = null;
		try {	
			cli = loadCliente(processo, clientes, proc);
			
		  } catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}	

	private static Cliente loadCliente(Process processo, List<Cliente> clientes, TNFe nfe) throws SQLException {
		Cliente cli;
		cli = processo.getClienteByClientes(clientes, nfe.getInfNFe().getEmit().getCNPJ());

		if (cli == null) {
			cli = processo.getClienteByClientes(clientes, nfe.getInfNFe().getDest().getCNPJ());
			if (cli == null)
				cli = processo.getClienteByClientes(clientes, nfe.getInfNFe().getDest().getCPF());
		}
		return cli;
	}

	private static Cliente loadCliente(Process processo, List<Cliente> clientes, TNfeProc proc) throws SQLException {
		Cliente cli;
		
		cli = processo.getClienteByClientes(clientes, proc.getNFe().getInfNFe().getEmit().getCNPJ());

		if (cli == null) {
			cli = processo.getClienteByClientes(clientes, proc.getNFe().getInfNFe().getDest().getCNPJ());
			
		}
		return cli;
	}

}
