package br.com.vaccine.service.controller;

import java.util.List;

import br.com.javac.bean.Usuario;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.Ide;
import br.com.service.dao.HibernateDAO;
import br.com.service.util.TypeFor;

public class InitProcess extends AbstractProcess implements Config {	

	@Override
	public String operationInput(Usuario usr, ParseXml parse, String msg, Ide ide, Process processo, HibernateDAO dao) throws Exception {
		int totalfor=0;
		List<CriticaTO> criticas;
		if (usr.getIndOper() == NFE_SAIDA) {
			totalfor = processo.executaFormulas(PRODUTO_VACCINE_NFE, ide.getIdIDe(), dao, CLASSE_CRITICA, TypeFor.CRITICA);
			criticas = processo.returnCriticas(ide.getIdIDe());
			if(criticas.size()>0){
			msg = parse.criaXmlRetCri(ide, criticas);
			
			}else{
				msg = parse.criaXmlRetSaidaSemCritica(ide);	
			}

		} else {

			totalfor = processo.executaFormulas(PRODUTO_VACCINE_NFE, ide.getIdIDe(), dao, usr.getIndOper(), setTypeOper(usr));
			criticas = processo.returnCriticas(ide.getIdIDe());

			if (existsCritical(criticas)) {
				msg = parse.criaXmlRetCri(ide, criticas);

			} else if (!existsCritical(criticas) && usr.getIndOper() == 0) {
				msg = createsSuggestion(usr, parse, ide, processo, dao, TypeFor.SUGESTAO, criticas.size());
			}
		}
		return msg;
	}
	
	
	@Override
	public boolean validTypeOper(Ide nf, int total) {
		return total > 0 && nf.getOper()==0 || total > 0 && nf.getOper()==1;
	}

}
