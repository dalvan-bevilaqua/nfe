package br.com.vaccine.service.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import br.com.javac.bean.Usuario;
import br.com.javac.v200.nfe.TNFe;
import br.com.javac.v200.procnfe.TNfeProc;
import br.com.service.bean.Cliente;
import br.com.service.bean.Cofins;
import br.com.service.bean.Dest;
import br.com.service.bean.Emit;
import br.com.service.bean.Icms;
import br.com.service.bean.Ide;
import br.com.service.bean.Ipi;
import br.com.service.bean.Prod;
import br.com.service.bean.Logger;
import br.com.service.bean.Login;
import br.com.service.bean.Pis;
import br.com.service.bean.Total;

public class LoadDadosXml {

	public Ide loadDados(TNfeProc nfeProc, Usuario usr, Login login, Cliente cliente) throws Exception {

		Prod iten = null;
		Ipi ipi = null;
		Cofins cofins = null;
		Pis pis = null;
		Total total = new Total();
		Ide ide = null;
		Emit emit = new Emit();
		Dest dest = new Dest();
		List<Prod> itens = new ArrayList<Prod>();
		// DateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("proc");
		try {

			if (cliente.getCnpj().equalsIgnoreCase(nfeProc.getNFe().getInfNFe().getEmit().getCNPJ())) {

				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));

			} else if (cliente.getCnpj().equalsIgnoreCase(nfeProc.getNFe().getInfNFe().getDest().getCNPJ())) {
				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));

			} else if (cliente.getCnpj().equalsIgnoreCase(nfeProc.getNFe().getInfNFe().getDest().getCPF())) {
				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));
			}

			ide.setOper(usr.getIndOper());
			ide.setChNFe(nfeProc.getNFe().getInfNFe().getId().toString());
			ide.setNnf(Integer.parseInt(nfeProc.getNFe().getInfNFe().getIde().getNNF()));
			ide.setSerie(nfeProc.getNFe().getInfNFe().getIde().getSerie());
			ide.setdEmi(nfeProc.getNFe().getInfNFe().getIde().getDEmi());
			ide.setdSaiEnt(nfeProc.getNFe().getInfNFe().getIde().getDSaiEnt());
			sb.append("idePassed");
			emit.setCnpj(nfeProc.getNFe().getInfNFe().getEmit().getCNPJ());
			emit.setxNome(nfeProc.getNFe().getInfNFe().getEmit().getXNome());
			emit.setUf(nfeProc.getNFe().getInfNFe().getEmit().getEnderEmit().getUF().toString());			
			emit.setIe(nfeProc.getNFe().getInfNFe().getEmit().getIE());
			if(nfeProc.getNFe().getInfNFe().getEmit().getCRT()!=null)
			emit.setCrt(Integer.parseInt(nfeProc.getNFe().getInfNFe().getEmit().getCRT()));
			sb.append("emitPassed");
			dest.setCnpj(nfeProc.getNFe().getInfNFe().getDest().getCNPJ());
			dest.setCpf(nfeProc.getNFe().getInfNFe().getDest().getCPF());
			dest.setxNome(nfeProc.getNFe().getInfNFe().getDest().getXNome());
			dest.setUF(nfeProc.getNFe().getInfNFe().getDest().getEnderDest().getUF().toString());
			dest.setIE(nfeProc.getNFe().getInfNFe().getDest().getIE());
			sb.append("destPassed");
			for (int i = 0; i < nfeProc.getNFe().getInfNFe().getDet().size(); i++) {
				iten = new Prod();

				iten.setCfop(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getCFOP().toString());
				iten.setcProd(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getCProd().toString());
				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getEXTIPI() != null) {
					iten.setExtipi(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getEXTIPI().toString());
				}
				iten.setNcm(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getNCM());
				iten.setnItem(nfeProc.getNFe().getInfNFe().getDet().get(i).getNItem().toString());
				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getVProd() != null)
					iten.setvProd(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getVProd().toString()));
				iten.setxProd(nfeProc.getNFe().getInfNFe().getDet().get(i).getProd().getXProd());
				sb.append("prodPassed");

				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00() != null) {
					Icms icms00 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getOrig() != null)
						icms00.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getOrig().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getCST() != null)
						icms00.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getCST().toString());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getModBC() != null)
						icms00.setModBC(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getModBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVBC() != null)
						icms00.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getPICMS() != null)
						icms00.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVICMS() != null)
						icms00.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVICMS().toString()));
					iten.setIcms(icms00);
					icms00.setIten(iten);
					ide.setIcms(icms00);
					icms00.setIde(ide);
					sb.append("icms00Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10() != null) {
					Icms icms10 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getOrig() != null)
						icms10.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getOrig().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getCST() != null)
						icms10.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getCST().toString());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBC() != null)
						icms10.setModBC(new Integer(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBC() != null)
						icms10.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMS() != null)
						icms10.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMS() != null)
						icms10.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST() != null)
						icms10.setModBCST(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST() != null)
						icms10.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBCST() != null)
						icms10.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMSST() != null)
						icms10.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMSST() != null)
						icms10.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMSST().toString()));
					iten.setIcms(icms10);
					icms10.setIten(iten);
					ide.setIcms(icms10);
					icms10.setIde(ide);
					sb.append("icms10Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20() != null) {
					Icms icms20 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getOrig() != null)
						icms20.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getOrig().toString()));
					icms20.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getModBC() != null)
						icms20.setModBC(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getModBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVBC() != null)
						icms20.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPRedBC() != null)
						icms20.setpRedBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPRedBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPICMS() != null)
						icms20.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVICMS() != null)
						icms20.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVICMS().toString()));
					iten.setIcms(icms20);
					icms20.setIten(iten);
					ide.setIcms(icms20);
					icms20.setIde(ide);
					sb.append("icms20Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30() != null) {
					Icms icms30 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getOrig() != null)
						icms30.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getOrig().toString()));
					icms30.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getModBCST() != null)
						icms30.setModBCST(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getModBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPMVAST() != null)
						icms30.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVBCST() != null)
						icms30.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPICMSST() != null)
						icms30.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVICMSST() != null)
						icms30.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVICMSST().toString()));
					iten.setIcms(icms30);
					icms30.setIten(iten);
					ide.setIcms(icms30);
					icms30.setIde(ide);
					sb.append("icms30Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40() != null) {
					Icms icms40 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getOrig() != null)
						icms40.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getOrig().toString()));
					icms40.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getCST());
					iten.setIcms(icms40);
					icms40.setIten(iten);
					ide.setIcms(icms40);
					icms40.setIde(ide);
					sb.append("icms40Passed");

					/*
					 * } else if
					 * (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto
					 * ().getICMS().getICMS40() != null) { Icms icms41 = new
					 * Icms();
					 * icms41.setOrig(nfeProc.getNFe().getInfNFe().getDet
					 * ().get(i
					 * ).getImposto().getICMS().getICMS41().getOrig().toString
					 * ());
					 * icms41.setCST(nfeProc.getNFe().getInfNFe().getDet().get
					 * (i)
					 * .getImposto().getICMS().getICMS41().getCST().toString());
					 * iten.setIcms(icms41); icms41.setIten(iten);
					 * ide.setIcms(icms41); icms41.setIde(ide);
					 * 
					 * 
					 * } else if
					 * (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto
					 * ().getICMS().getICMS51() != null) { Icms icms50 = new
					 * Icms();
					 * icms51.setOrig(nfeProc.getNFe().getInfNFe().getDet
					 * ().get(i
					 * ).getImposto().getICMS().getICMS51().getOrig().toString
					 * ());
					 * icms51.setCST(nfeProc.getNFe().getInfNFe().getDet().get
					 * (i)
					 * .getImposto().getICMS().getICMS51().getCST().toString());
					 * icms51.setvBC(new
					 * BigDecimal(nfeProc.getNFe().getInfNFe().
					 * getDet().get(i).getImposto
					 * ().getICMS().getICMS51().getVBC().toString()));
					 * icms51.setpICMS(new
					 * BigDecimal(nfeProc.getNFe().getInfNFe(
					 * ).getDet().get(i).getImposto
					 * ().getICMS().getICMS51().getPICMS().toString()));
					 * icms51.setvICMS(new
					 * BigDecimal(nfeProc.getNFe().getInfNFe(
					 * ).getDet().get(i).getImposto
					 * ().getICMS().getICMS51().getVICMS().toString()));
					 * icms51.setpICMS(new
					 * BigDecimal(nfeProc.getNFe().getInfNFe(
					 * ).getDet().get(i).getImposto
					 * ().getICMS().getICMS51().getPICMS().toString()));
					 * 
					 * iten.setIcms(icms51); icms51.setIten(iten);
					 * ide.setIcms(icms51); icms51.setIde(ide);
					 */

				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51() != null) {
					Icms icms51 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getOrig() != null)
						icms51.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getOrig().toString()));
					icms51.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getCST());
					iten.setIcms(icms51);
					icms51.setIten(iten);
					ide.setIcms(icms51);
					icms51.setIde(ide);
					sb.append("icms51Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60() != null) {
					Icms icms60 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getOrig() != null)
						icms60.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getOrig().toString()));
					icms60.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVBCSTRet() != null)
						icms60.setvBCSTRet(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVBCSTRet().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVICMSSTRet() != null)
						icms60.setvICMSSTRet(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVICMSSTRet().toString()));
					iten.setIcms(icms60);
					icms60.setIten(iten);
					ide.setIcms(icms60);
					icms60.setIde(ide);
					sb.append("icms60Passed");

				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70() != null) {
					Icms icms70 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getOrig() != null)
						icms70.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getOrig().toString()));
					icms70.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBC() != null)
						icms70.setModBC(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC() != null)
						icms70.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPRedBC() != null)
						icms70.setpRedBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPRedBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC() != null)
						icms70.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMS() != null)
						icms70.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMS() != null)
						icms70.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBCST() != null)
						icms70.setModBCST(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPMVAST() != null)
						icms70.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBCST() != null)
						icms70.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMSST() != null)
						icms70.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMSST() != null)
						icms70.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMSST().toString()));
					iten.setIcms(icms70);
					icms70.setIten(iten);
					ide.setIcms(icms70);
					icms70.setIde(ide);
					sb.append("icms70Passed");

				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMS90() != null) {
					
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart() != null) {
					Icms icmsPart = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getOrig() != null)
						icmsPart.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getOrig().toString()));
					icmsPart.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBC() != null)
						icmsPart.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS() != null)
						icmsPart.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMS() != null)
						icmsPart.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBCST() != null)
						icmsPart.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS() != null)
						icmsPart.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMSST() != null)
						icmsPart.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMSST().toString()));
					iten.setIcms(icmsPart);
					icmsPart.setIten(iten);
					ide.setIcms(icmsPart);
					icmsPart.setIde(ide);
					sb.append("icmsPartPassed");

				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101() != null) {
					Icms icmsN101 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getOrig() != null)
						icmsN101.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getOrig().toString()));
					icmsN101.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getCSOSN());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getPCredSN() != null)
						icmsN101.setpCredSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getPCredSN().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getVCredICMSSN() != null)
						icmsN101.setvCredICMSSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getVCredICMSSN().toString()));
					iten.setIcms(icmsN101);
					icmsN101.setIten(iten);
					ide.setIcms(icmsN101);
					icmsN101.setIde(ide);
					sb.append("icmsN101Passed");

				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102() != null) {
					Icms icmsN102 = new Icms();
					icmsN102.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102().getOrig().toString()));
					icmsN102.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102().getCSOSN().toString());
					iten.setIcms(icmsN102);
					icmsN102.setIten(iten);
					ide.setIcms(icmsN102);
					icmsN102.setIde(ide);
					sb.append("icmsN102Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201() != null) {
					Icms icmsN201 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getOrig() != null)
						icmsN201.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getOrig().toString()));
					icmsN201.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getCSOSN());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getModBCST() != null)
						icmsN201.setModBCST(new Integer(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getModBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPCredSN() != null)
						icmsN201.setpCredSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPCredSN().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPICMSST() != null)
						icmsN201.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPRedBCST() != null)
						icmsN201.setpRedBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPRedBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPMVAST() != null)
						icmsN201.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVCredICMSSN() != null)
						icmsN201.setvCredICMSSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVCredICMSSN().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVICMSST() != null)
						icmsN201.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVICMSST().toString()));
					iten.setIcms(icmsN201);
					icmsN201.setIten(iten);
					ide.setIcms(icmsN201);
					icmsN201.setIde(ide);
					sb.append("icmsN201Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202() != null) {
					Icms icmsN202 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig() != null)
						icmsN202.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig().toString()));
					icmsN202.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getCSOSN());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig() != null)
						icmsN202.setModBCST(new Integer(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getModBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getModBCST() != null)
						icmsN202.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPMVAST() != null)
						icmsN202.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPRedBCST() != null)
						icmsN202.setpRedBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPRedBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVBCST() != null)
						icmsN202.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVICMSST() != null)
						icmsN202.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVICMSST().toString()));
					iten.setIcms(icmsN202);
					icmsN202.setIten(iten);
					ide.setIcms(icmsN202);
					icmsN202.setIde(ide);
					sb.append("icmsN202Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500() != null) {
					Icms icmsN500 = new Icms();
					icmsN500.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getCSOSN());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getOrig() != null)
						icmsN500.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getOrig().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVBCSTRet() != null)
						icmsN500.setvBCSTRet(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVBCSTRet().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVICMSSTRet() != null)
						icmsN500.setvICMSSTRet(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVICMSSTRet().toString()));
					iten.setIcms(icmsN500);
					icmsN500.setIten(iten);
					ide.setIcms(icmsN500);
					icmsN500.setIde(ide);
					sb.append("icmsN500Passed");
				} else if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900() != null) {
					Icms icmsN900 = new Icms();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getOrig() != null)
						icmsN900.setOrig(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getOrig().toString()));
					icmsN900.setcSOSN(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getCSOSN());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBC() != null)
						icmsN900.setModBC(new Integer((nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBC().toString())));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBCST() != null)
						icmsN900.setModBCST(new Integer(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBCST()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPCredSN() != null)
						icmsN900.setpCredSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPCredSN().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMS() != null)
						icmsN900.setpICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMSST() != null)
						icmsN900.setpICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMSST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPMVAST() != null)
						icmsN900.setpMVAST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPMVAST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBC() != null)
						icmsN900.setpRedBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBCST() != null)
						icmsN900.setpRedBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBC() != null)
						icmsN900.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBCST() != null)
						icmsN900.setvBCST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVCredICMSSN() != null)
						icmsN900.setvCredICMSSN(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVCredICMSSN().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMS() != null)
						icmsN900.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMSST() != null)
						icmsN900.setvICMSST(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMSST().toString()));
					iten.setIcms(icmsN900);
					icmsN900.setIten(iten);
					ide.setIcms(icmsN900);
					icmsN900.setIde(ide);
					sb.append("icmsN900Passed");
				} else {/* Fim icms */
				}

				// IPI
				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI() != null && nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib() != null) {
					ipi = new Ipi();
					// if(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getCST()!=null)
					ipi.setCST(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getCST());
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVBC() != null)
						ipi.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVBC()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getPIPI() != null)
						ipi.setpIPI(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getPIPI()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVIPI() != null)
						ipi.setvIPI(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVIPI()));

					iten.setIpi(ipi);
					ipi.setIten(iten);
					ide.setIpi(ipi);
					ipi.setIde(ide);
					sb.append("ipiPassed");
				}
				// pis
				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq() != null) {
					pis = new Pis();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getCST() != null)
						pis.setCST(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVBC() != null)
						pis.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getPPIS() != null)
						pis.setpPIS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getPPIS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVPIS() != null)
						pis.setvPIS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVPIS().toString()));

					iten.setPis(pis);
					pis.setIten(iten);
					ide.setPis(pis);
					pis.setIde(ide);
					sb.append("pisPassed");
				}
				// COFINS
				if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq() != null) {
					cofins = new Cofins();
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getCST() != null)
						cofins.setCST(Integer.parseInt(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getCST().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVBC() != null)
						cofins.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVBC().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getPCOFINS() != null)
						cofins.setpCOFINS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getPCOFINS().toString()));
					if (nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVCOFINS() != null)
						cofins.setvCOFINS(new BigDecimal(nfeProc.getNFe().getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVCOFINS().toString()));

					iten.setCofins(cofins);
					cofins.setIten(iten);
					ide.setCofins(cofins);
					cofins.setIde(ide);
					sb.append("cofinsPassed");
				} else {/* Fim imposto */
				}

				itens.add(iten);
				itens.get(i).setIde(ide);

			}
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVBC() != null)
				total.setvBC(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVBC().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVICMS() != null)
				total.setvICMS(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVICMS().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVST() != null)
				total.setvST(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVST().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVProd() != null)
				total.setvProd(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVProd().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVIPI() != null)
				total.setvIPI(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVIPI().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVPIS() != null)
				total.setvPIS(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVPIS().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS() != null)
				total.setvCOFINS(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVProd() != null)
				total.setvProd(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVProd().toString()));
			if (nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVNF() != null)
				total.setvNF(new BigDecimal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getVNF().toString()));

			emit.setIde(ide);
			dest.setIde(ide);
			iten.setIde(ide);
			total.setIde(ide);

			ide.setEmit(emit);
			ide.setDest(dest);
			ide.setTotal(total);
			ide.setItens(itens);

		} catch (NullPointerException e) {
			Logger.log("[ERRO] " + sb.toString() + " " + getClass(), e.getMessage());
			ide = null;
			throw new Exception(getClass() + " [" + sb.toString() + "] " + e.getMessage());

		} catch (Exception e) {
			Logger.log("[ERRO]" + sb.toString() + " " + getClass(), e.getMessage());
			ide = null;
			throw new Exception(getClass() + " [" + sb.toString() + "] " + e.getMessage());
		}
		sb = null;
		return ide;

	}

	public Ide loadDados(TNFe nfe, Usuario usr, Login login, Cliente cliente) throws Exception {

		Prod iten = null;
		Ipi ipi = null;
		Cofins cofins = null;
		Pis pis = null;
		Total total = new Total();
		Ide ide = null;
		Emit emit = new Emit();
		Dest dest = new Dest();
		List<Prod> itens = new ArrayList<Prod>();
		// DateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("nfe");
		try {
			if (cliente.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getEmit().getCNPJ())) {
				// indOper = 1 ver cnpj emitente esta no banco
				// se for igual a 1 não tem sugestão somente critica
				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));

			} else if (cliente.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getDest().getCNPJ())) {
				// se for 0 ver se cnpj destinatario esta no banco
				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));

			} else if (cliente.getCnpj().equalsIgnoreCase(nfe.getInfNFe().getDest().getCPF())) {
				ide = new Ide();
				ide.setCodCli(String.valueOf(cliente.getCodContratoCnpj()));
				ide.setCodContrato(String.valueOf(login.getCodContrato()));
			}

			ide.setOper(usr.getIndOper());
			ide.setChNFe(nfe.getInfNFe().getId().toString());
			ide.setNnf(Integer.parseInt(nfe.getInfNFe().getIde().getNNF()));
			ide.setSerie(nfe.getInfNFe().getIde().getSerie());
			ide.setdEmi(nfe.getInfNFe().getIde().getDEmi());
			ide.setdSaiEnt(nfe.getInfNFe().getIde().getDSaiEnt());
			sb.append("idePassed");
			emit.setCnpj(nfe.getInfNFe().getEmit().getCNPJ());
			emit.setxNome(nfe.getInfNFe().getEmit().getXNome());
			emit.setUf(nfe.getInfNFe().getEmit().getEnderEmit().getUF().toString());
			emit.setIe(nfe.getInfNFe().getEmit().getIE());
			if(nfe.getInfNFe().getEmit().getCRT()!=null)
				emit.setCrt(Integer.parseInt(nfe.getInfNFe().getEmit().getCRT()));
			sb.append("emitPassed");
			dest.setCnpj(nfe.getInfNFe().getDest().getCNPJ());
			dest.setCpf(nfe.getInfNFe().getDest().getCPF());
			dest.setxNome(nfe.getInfNFe().getDest().getXNome());
			dest.setUF(nfe.getInfNFe().getDest().getEnderDest().getUF().toString());
			dest.setIE(nfe.getInfNFe().getDest().getIE());
			sb.append("destPassed");
			for (int i = 0; i < nfe.getInfNFe().getDet().size(); i++) {
				iten = new Prod();

				iten.setCfop(nfe.getInfNFe().getDet().get(i).getProd().getCFOP().toString());
				iten.setcProd(nfe.getInfNFe().getDet().get(i).getProd().getCProd().toString());
				if (nfe.getInfNFe().getDet().get(i).getProd().getEXTIPI() != null) {
					iten.setExtipi(nfe.getInfNFe().getDet().get(i).getProd().getEXTIPI().toString());
				}
				iten.setNcm(nfe.getInfNFe().getDet().get(i).getProd().getNCM());
				iten.setnItem(nfe.getInfNFe().getDet().get(i).getNItem().toString());
				if (nfe.getInfNFe().getDet().get(i).getProd().getVProd() != null)
					iten.setvProd(new BigDecimal(nfe.getInfNFe().getDet().get(i).getProd().getVProd().toString()));
				iten.setxProd(nfe.getInfNFe().getDet().get(i).getProd().getXProd());
				sb.append("prodPassed");

				if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00() != null) {
					Icms icms00 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getOrig() != null)
						icms00.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getOrig().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getCST() != null)
						icms00.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getCST().toString());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getModBC() != null)
						icms00.setModBC(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getModBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVBC() != null)
						icms00.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getPICMS() != null)
						icms00.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVICMS() != null)
						icms00.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS00().getVICMS().toString()));
					iten.setIcms(icms00);
					icms00.setIten(iten);
					ide.setIcms(icms00);
					icms00.setIde(ide);
					sb.append("icms00Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10() != null) {
					Icms icms10 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getOrig() != null)
						icms10.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getOrig().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getCST() != null)
						icms10.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getCST().toString());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBC() != null)
						icms10.setModBC(new Integer(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBC() != null)
						icms10.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMS() != null)
						icms10.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMS() != null)
						icms10.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST() != null)
						icms10.setModBCST(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST() != null)
						icms10.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBCST() != null)
						icms10.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMSST() != null)
						icms10.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMSST() != null)
						icms10.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS10().getVICMSST().toString()));
					iten.setIcms(icms10);
					icms10.setIten(iten);
					ide.setIcms(icms10);
					icms10.setIde(ide);
					sb.append("icms10Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20() != null) {
					Icms icms20 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getOrig() != null)
						icms20.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getOrig().toString()));
					icms20.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getModBC() != null)
						icms20.setModBC(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getModBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVBC() != null)
						icms20.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPRedBC() != null)
						icms20.setpRedBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPRedBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPICMS() != null)
						icms20.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVICMS() != null)
						icms20.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS20().getVICMS().toString()));
					iten.setIcms(icms20);
					icms20.setIten(iten);
					ide.setIcms(icms20);
					icms20.setIde(ide);
					sb.append("icms20Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30() != null) {
					Icms icms30 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getOrig() != null)
						icms30.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getOrig().toString()));
					icms30.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getModBCST() != null)
						icms30.setModBCST(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPMVAST() != null)
						icms30.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVBCST() != null)
						icms30.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPICMSST() != null)
						icms30.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVICMSST() != null)
						icms30.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS30().getVICMSST().toString()));
					iten.setIcms(icms30);
					icms30.setIten(iten);
					ide.setIcms(icms30);
					icms30.setIde(ide);
					sb.append("icms30Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40() != null) {
					Icms icms40 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getOrig() != null)
						icms40.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getOrig().toString()));
					icms40.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS40().getCST());
					iten.setIcms(icms40);
					icms40.setIten(iten);
					ide.setIcms(icms40);
					icms40.setIde(ide);
					sb.append("icms40Passed");

					/*
					 * } else if
					 * (nfe.getInfNFe().getDet().get(i).getImposto().getICMS
					 * ().getICMS40() != null) { Icms icms41 = new Icms();
					 * icms41
					 * .setOrig(nfe.getInfNFe().getDet().get(i).getImposto(
					 * ).getICMS().getICMS41().getOrig().toString());
					 * icms41.setCST
					 * (nfe.getInfNFe().getDet().get(i).getImposto()
					 * .getICMS().getICMS41().getCST().toString());
					 * iten.setIcms(icms41); icms41.setIten(iten);
					 * ide.setIcms(icms41); icms41.setIde(ide);
					 * 
					 * 
					 * } else if
					 * (nfe.getInfNFe().getDet().get(i).getImposto().getICMS
					 * ().getICMS51() != null) { Icms icms50 = new Icms();
					 * icms51
					 * .setOrig(nfe.getInfNFe().getDet().get(i).getImposto(
					 * ).getICMS().getICMS51().getOrig().toString());
					 * icms51.setCST
					 * (nfe.getInfNFe().getDet().get(i).getImposto()
					 * .getICMS().getICMS51().getCST().toString());
					 * icms51.setvBC(new
					 * BigDecimal(nfe.getInfNFe().getDet().get(
					 * i).getImposto().getICMS
					 * ().getICMS51().getVBC().toString())); icms51.setpICMS(new
					 * BigDecimal
					 * (nfe.getInfNFe().getDet().get(i).getImposto().getICMS
					 * ().getICMS51().getPICMS().toString()));
					 * icms51.setvICMS(new
					 * BigDecimal(nfe.getInfNFe().getDet().get
					 * (i).getImposto().getICMS
					 * ().getICMS51().getVICMS().toString()));
					 * icms51.setpICMS(new
					 * BigDecimal(nfe.getInfNFe().getDet().get
					 * (i).getImposto().getICMS
					 * ().getICMS51().getPICMS().toString()));
					 * 
					 * iten.setIcms(icms51); icms51.setIten(iten);
					 * ide.setIcms(icms51); icms51.setIde(ide);
					 */

				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51() != null) {
					Icms icms51 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getOrig() != null)
						icms51.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getOrig().toString()));
					icms51.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS51().getCST());
					iten.setIcms(icms51);
					icms51.setIten(iten);
					ide.setIcms(icms51);
					icms51.setIde(ide);
					sb.append("icms51Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60() != null) {
					Icms icms60 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getOrig() != null)
						icms60.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getOrig().toString()));
					icms60.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVBCSTRet() != null)
						icms60.setvBCSTRet(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVBCSTRet().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVICMSSTRet() != null)
						icms60.setvICMSSTRet(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS60().getVICMSSTRet().toString()));
					iten.setIcms(icms60);
					icms60.setIten(iten);
					ide.setIcms(icms60);
					icms60.setIde(ide);
					sb.append("icms60Passed");

				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70() != null) {
					Icms icms70 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getOrig() != null)
						icms70.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getOrig().toString()));
					icms70.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBC() != null)
						icms70.setModBC(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC() != null)
						icms70.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPRedBC() != null)
						icms70.setpRedBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPRedBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC() != null)
						icms70.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMS() != null)
						icms70.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMS() != null)
						icms70.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBCST() != null)
						icms70.setModBCST(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPMVAST() != null)
						icms70.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBCST() != null)
						icms70.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMSST() != null)
						icms70.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMSST() != null)
						icms70.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS70().getVICMSST().toString()));
					iten.setIcms(icms70);
					icms70.setIten(iten);
					ide.setIcms(icms70);
					icms70.setIde(ide);
					sb.append("icms70Passed");

				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMS90() != null) {
					sb.append("icms90Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart() != null) {
					Icms icmsPart = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getOrig() != null)
						icmsPart.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getOrig().toString()));
					icmsPart.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBC() != null)
						icmsPart.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS() != null)
						icmsPart.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMS() != null)
						icmsPart.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBCST() != null)
						icmsPart.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS() != null)
						icmsPart.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMSST() != null)
						icmsPart.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSPart().getVICMSST().toString()));
					iten.setIcms(icmsPart);
					icmsPart.setIten(iten);
					ide.setIcms(icmsPart);
					icmsPart.setIde(ide);
					sb.append("icmsPartPassed");

				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101() != null) {
					Icms icmsN101 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getOrig() != null)
						icmsN101.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getOrig().toString()));
					icmsN101.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getCSOSN());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getPCredSN() != null)
						icmsN101.setpCredSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getPCredSN().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getVCredICMSSN() != null)
						icmsN101.setvCredICMSSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN101().getVCredICMSSN().toString()));
					iten.setIcms(icmsN101);
					icmsN101.setIten(iten);
					ide.setIcms(icmsN101);
					icmsN101.setIde(ide);
					sb.append("icmsN101Passed");

				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102() != null) {
					Icms icmsN102 = new Icms();
					icmsN102.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102().getOrig().toString()));
					icmsN102.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN102().getCSOSN().toString());
					iten.setIcms(icmsN102);
					icmsN102.setIten(iten);
					ide.setIcms(icmsN102);
					icmsN102.setIde(ide);
					sb.append("icmsN102Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201() != null) {
					Icms icmsN201 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getOrig() != null)
						icmsN201.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getOrig().toString()));
					icmsN201.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getCSOSN());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getModBCST() != null)
						icmsN201.setModBCST(new Integer(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPCredSN() != null)
						icmsN201.setpCredSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPCredSN().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPICMSST() != null)
						icmsN201.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPRedBCST() != null)
						icmsN201.setpRedBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPRedBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPMVAST() != null)
						icmsN201.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVCredICMSSN() != null)
						icmsN201.setvCredICMSSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVCredICMSSN().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVICMSST() != null)
						icmsN201.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN201().getVICMSST().toString()));
					iten.setIcms(icmsN201);
					icmsN201.setIten(iten);
					ide.setIcms(icmsN201);
					icmsN201.setIde(ide);
					sb.append("icmsN201Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202() != null) {
					Icms icmsN202 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig() != null)
						icmsN202.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig().toString()));
					icmsN202.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getCSOSN());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getOrig() != null)
						icmsN202.setModBCST(new Integer(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getModBCST() != null)
						icmsN202.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPMVAST() != null)
						icmsN202.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPRedBCST() != null)
						icmsN202.setpRedBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getPRedBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVBCST() != null)
						icmsN202.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVICMSST() != null)
						icmsN202.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN202().getVICMSST().toString()));
					iten.setIcms(icmsN202);
					icmsN202.setIten(iten);
					ide.setIcms(icmsN202);
					icmsN202.setIde(ide);
					sb.append("icmsN202Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500() != null) {
					Icms icmsN500 = new Icms();
					icmsN500.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getCSOSN());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getOrig() != null)
						icmsN500.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getOrig().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVBCSTRet() != null)
						icmsN500.setvBCSTRet(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVBCSTRet().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVICMSSTRet() != null)
						icmsN500.setvICMSSTRet(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN500().getVICMSSTRet().toString()));
					iten.setIcms(icmsN500);
					icmsN500.setIten(iten);
					ide.setIcms(icmsN500);
					icmsN500.setIde(ide);
					sb.append("icmsN500Passed");
				} else if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900() != null) {
					Icms icmsN900 = new Icms();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getOrig() != null)
						icmsN900.setOrig(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getOrig().toString()));
					icmsN900.setcSOSN(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getCSOSN());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBC() != null)
						icmsN900.setModBC(new Integer((nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBC().toString())));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBCST() != null)
						icmsN900.setModBCST(new Integer(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getModBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPCredSN() != null)
						icmsN900.setpCredSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPCredSN().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMS() != null)
						icmsN900.setpICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMSST() != null)
						icmsN900.setpICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPICMSST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPMVAST() != null)
						icmsN900.setpMVAST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPMVAST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBC() != null)
						icmsN900.setpRedBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBCST() != null)
						icmsN900.setpRedBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getPRedBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBC() != null)
						icmsN900.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBCST() != null)
						icmsN900.setvBCST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVBCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVCredICMSSN() != null)
						icmsN900.setvCredICMSSN(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVCredICMSSN().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMS() != null)
						icmsN900.setvICMS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMSST() != null)
						icmsN900.setvICMSST(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getICMS().getICMSSN900().getVICMSST().toString()));
					iten.setIcms(icmsN900);
					icmsN900.setIten(iten);
					ide.setIcms(icmsN900);
					icmsN900.setIde(ide);
					sb.append("icmsN900Passed");
				} else {/* Fim icms */
				}

				// IPI
				if (nfe.getInfNFe().getDet().get(i).getImposto().getIPI() != null && nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib() != null) {
					ipi = new Ipi();
					// if(nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getCST()!=null)
					ipi.setCST(nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getCST());
					if (nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVBC() != null)
						ipi.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVBC()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getPIPI() != null)
						ipi.setpIPI(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getPIPI()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVIPI() != null)
						ipi.setvIPI(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getIPI().getIPITrib().getVIPI()));

					iten.setIpi(ipi);
					ipi.setIten(iten);
					ide.setIpi(ipi);
					ipi.setIde(ide);
					sb.append("ipiPassed");
				}
				// pis
				if (nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq() != null) {
					pis = new Pis();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getCST() != null)
						pis.setCST(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVBC() != null)
						pis.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getPPIS() != null)
						pis.setpPIS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getPPIS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVPIS() != null)
						pis.setvPIS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getPIS().getPISAliq().getVPIS().toString()));

					iten.setPis(pis);
					pis.setIten(iten);
					ide.setPis(pis);
					pis.setIde(ide);
					sb.append("pisPassed");
				}
				// COFINS
				if (nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq() != null) {
					cofins = new Cofins();
					if (nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getCST() != null)
						cofins.setCST(Integer.parseInt(nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getCST().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVBC() != null)
						cofins.setvBC(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVBC().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getPCOFINS() != null)
						cofins.setpCOFINS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getPCOFINS().toString()));
					if (nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVCOFINS() != null)
						cofins.setvCOFINS(new BigDecimal(nfe.getInfNFe().getDet().get(i).getImposto().getCOFINS().getCOFINSAliq().getVCOFINS().toString()));

					iten.setCofins(cofins);
					cofins.setIten(iten);
					ide.setCofins(cofins);
					cofins.setIde(ide);
					sb.append("cofinsPassed");
				} else {/* Fim imposto */
				}

				itens.add(iten);
				itens.get(i).setIde(ide);

			}
			if (nfe.getInfNFe().getTotal().getICMSTot().getVBC() != null)
				total.setvBC(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVBC().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVICMS() != null)
				total.setvICMS(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVICMS().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVST() != null)
				total.setvST(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVST().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVProd() != null)
				total.setvProd(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVProd().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVIPI() != null)
				total.setvIPI(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVIPI().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVPIS() != null)
				total.setvPIS(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVPIS().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVCOFINS() != null)
				total.setvCOFINS(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVCOFINS().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVProd() != null)
				total.setvProd(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVProd().toString()));
			if (nfe.getInfNFe().getTotal().getICMSTot().getVNF() != null)
				total.setvNF(new BigDecimal(nfe.getInfNFe().getTotal().getICMSTot().getVNF().toString()));

			emit.setIde(ide);
			dest.setIde(ide);
			iten.setIde(ide);
			total.setIde(ide);

			ide.setEmit(emit);
			ide.setDest(dest);
			ide.setTotal(total);
			ide.setItens(itens);

		} catch (NullPointerException e) {
			Logger.log("[ERRO]" + getClass(), e.getMessage());
			ide = null;
			throw new Exception(getClass() + " " + e.getMessage());

		} catch (Exception e) {
			Logger.log("[ERRO]" + getClass(), e.getMessage());
			ide = null;
			throw new Exception(getClass() + " " + e.getMessage());
		}
		sb = null;
		return ide;

	}

}
