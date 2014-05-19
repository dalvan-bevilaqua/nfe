package br.com.service.bean;


public class UnitTest {/*

	@Test
	public void test() {
		fail("Not yet implemented");
	}

    SessionFactory sf = null;
    Session session = null ;
    Transaction tx = null; 	
	
	
	//sempre execta quando junit é chamado pela primeira vez
	@Before
	public void init(){
		NotaFiscal n = new NotaFiscal();
		List<Iten> itens = new ArrayList<Iten>();
		Iten iten=null;
		for (int i = 0; i < 10; i++) {
			iten = new Iten();
			iten.setxProd("nome"+i);
			
			Icms icms = new Icms();
			Pis pis = new Pis();
			
			Cofins cofins = new Cofins();
			Ipi ipi = new Ipi();
			
			icms.setCST("10");
			pis.setCST("20");
			ipi.setCST("30");
			cofins.setCST("40");
			iten.setIcms(icms);
			iten.setIpi(ipi);
			iten.setCofins(cofins);
			iten.setPis(pis);
			iten.setnFe(n);
			itens.add(iten);
			
		}
		
		
		
		Identificacao ide = new Identificacao();
		Destinatario d = new Destinatario();
		TotalNota t = new TotalNota();
		Emitente e = new Emitente();
		
		d.setCnpj("2222");
		t.setvBC("12");
		e.setxNome("teste");
		ide.setCdv("jjjjjj");
		n.setItens(itens);
		
		//ide.setNfe(n);
		
		n.setIde(ide);
		n.setDest(d);
		n.setEmit(e);
		n.setTotal(t);
		
		
		
		Configuration cfg = new AnnotationConfiguration();
        cfg.configure();
       
        sf = cfg.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(n);
        
        tx.commit();
        sf.close();
        session.close();
        
        
       

		
		
		
	}
	
	
	@Test
	public void testeNfe(){
		
		

		
		
		System.out.println("qual coisa");
		
		
	}
	
	
	
	

*/}
