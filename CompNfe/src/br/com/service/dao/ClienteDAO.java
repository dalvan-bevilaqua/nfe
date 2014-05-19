package br.com.service.dao;

import java.io.Serializable;
import java.util.List;

import br.com.service.bean.Cliente;
import br.com.service.bean.Contrato;
import br.com.service.bean.Login;

public interface ClienteDAO {
	Login consultaUsuario(String email ,String senha);
	Login consultaUsuario(String email);
	boolean autentica(Serializable pojo);
	Contrato consultaCliByCont(int codCliente);
	List<Cliente> contratosByCliente(int codCliente); 

}
