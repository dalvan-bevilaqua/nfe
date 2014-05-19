package br.com.vaccine.service.controller;

import java.util.List;

import br.com.javac.bean.Usuario;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Ide;
import br.com.service.bean.SugestaoTO;
import br.com.service.dao.HibernateDAO;
import br.com.service.util.TypeFor;

abstract class AbstractProcess {

	public String createsSuggestion(Usuario usr, ParseXml parse, Ide ide, Process processo, HibernateDAO dao, TypeFor typeFor,int totalCri) throws Exception {
		List<SugestaoTO> sugestoes=null;
		try{
		processo.executaFormulas(8, ide.getIdIDe(), dao,TypeFor.SUGESTAO.ordinal(), typeFor);
		sugestoes = processo.returnSugestoes(ide.getIdIDe());
		}catch(Exception e){
			e.printStackTrace();
		}
		return parse.criaXmlRetSug(ide, sugestoes,totalCri);
	}
	
	public void createsCritical(Usuario usr, ParseXml parse, Ide ide, Process processo, HibernateDAO dao, String msg, TypeFor typeFor) throws Exception {
		List<CriticaTO> criticas;
		processo.executaFormulas(8, ide.getIdIDe(), dao, usr.getIndOper(), typeFor);
		criticas = processo.returnCriticas(ide.getIdIDe());
		msg = parse.criaXmlRetCri(ide, criticas);
	}

	public boolean existsCritical(List<CriticaTO> criticas, int totalfor) {
		return criticas.size() > 0 && totalfor > 0;
	}
	
	public boolean existsCritical(List<CriticaTO> criticas) {
		return criticas.size() > 0 ;
	}

	public TypeFor setTypeOper(Usuario usr) {
		return usr.getIndOper() == 0 ? TypeFor.CRITICA : TypeFor.SUGESTAO;
	}

}
