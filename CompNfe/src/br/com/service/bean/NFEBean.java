package br.com.service.bean;

import java.util.List;

public class NFEBean {

	private NfeIde ide;
	private NfeEmit emit;
	private NfeDest dest;
	private List<NfeProd> produtos;
	private NfeTotal nfeTotal;
	
	

	public NfeIde getIde() {
		return ide;
	}

	public NfeEmit getEmit() {
		return emit;
	}

	public NfeDest getDest() {
		return dest;
	}

	public List<NfeProd> getProdutos() {
		return produtos;
	}

	public void setIde(NfeIde ide) {
		this.ide = ide;
	}

	public void setEmit(NfeEmit emit) {
		this.emit = emit;
	}

	public void setDest(NfeDest dest) {
		this.dest = dest;
	}

	public void setProdutos(List<NfeProd> produtos) {
		this.produtos = produtos;
	}

	public void setNfeTotal(NfeTotal nfeTotal) {
		this.nfeTotal = nfeTotal;
	}

	public NfeTotal getNfeTotal() {
		return nfeTotal;
	}

}
