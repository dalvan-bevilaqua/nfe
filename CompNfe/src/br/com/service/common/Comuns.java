package br.com.service.common;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.service.bean.Logger;

public class Comuns {

	private  static final Locale BRAZIL = new Locale("pt","BR");
	private static final  DecimalFormatSymbols REAL = new  DecimalFormatSymbols(BRAZIL);
	public  static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("###,###,##0.00",REAL);

	
	public static Properties setupProperties() throws Exception {
		Properties props = new  Properties();
    	String path = System.getProperty("catalina.home");	    			

		try{			
			 //InputStream inStream = Comuns.class.getResourceAsStream(path+"conf/capreerfw.properties");	
			 props.load(new FileInputStream(path+"/conf/capreerfw.properties"));
			// props.load(inStream);			
			
		}catch(Exception e){
			
			Logger.log("ERRO caminho do arquivo vaccineWSDL.properties nao encontrado", e.getMessage());
			throw new Exception("[ConnectionFactory:setupProperties]" + e.getMessage());
			
		}
		return props;
	}
	
	public static String getUrlLembrete() throws Exception {
		Properties prop = Comuns.setupProperties();
		return prop.getProperty("site.url.lembrete");
	}

	
	public static String formatarCNPJ(String paramDados){
		Pattern pattern = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");
		Matcher match = pattern.matcher(paramDados);
		return match.replaceAll("$1.$2.$3/$4-$5");
	}

	public static String formatarTelefone(String paramDados){
		Pattern pattern = Pattern.compile("(\\d{2})(\\d{4})(\\d{4})");
		Matcher match = pattern.matcher(paramDados);
		return match.replaceAll("($1) $2-$3");
	}
	
	public static String formataCampoValorWeb(String paramHeader, String paramDados){
		String stringResultado = "";

		// Campo com formatacao especifica
		if(paramHeader.trim().equals("QTDE_NF")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("QTD_PARC")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("QTDE")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("QTD_ENTRADA")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("QTD_SAIDA")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("SALDO")){
			stringResultado = Comuns.formataAlinhamento(Comuns.trocarPontoVirgula(paramDados));
		}else if(paramHeader.trim().contains("CST_ICMS")){
			stringResultado = Comuns.formataCST_ICMS(Comuns.formataAlinhamento(paramDados),true);
		}else if(paramHeader.trim().contains("CST_IPI")){
			stringResultado = Comuns.formataCST_IPI(Comuns.formataAlinhamento(paramDados),true);
		}else if(paramHeader.trim().contains("CST_PIS")){
			stringResultado = Comuns.formataCST_PIS(Comuns.formataAlinhamento(paramDados),true);
		}else if(paramHeader.trim().contains("CST_COFINS")){
			stringResultado = Comuns.formataCST_COFINS(Comuns.formataAlinhamento(paramDados),true);
		}else if(paramHeader.trim().contains("EX_IPI")){
			stringResultado = Comuns.formataEX_IPI(Comuns.formataAlinhamento(paramDados),true);
		}else{
			stringResultado = Comuns.formataAlinhamento(paramDados);
		}
			
		return stringResultado;
	}
	
	public static String trocarPontoVirgula(String paramDados){
		return paramDados.replace(",", "").replace(".", ",");
	}
	
	public static String formataEX_IPI(String paramDados, boolean paramFormata){
		NumberFormat fmt = new DecimalFormat("000");
		if(paramFormata){
			if(paramDados.matches("[0-9]+")){
				if(Integer.parseInt(paramDados)>0){
					return fmt.format(Double.parseDouble(paramDados));
				}else{
					return "";
				}
			}
		}
		return paramDados;
	}
	public static String formataCST_ICMS(String paramDados, boolean paramFormata){
		NumberFormat fmt = new DecimalFormat("000");
		if(paramFormata){
			if(paramDados.matches("[0-9]+")){
				return fmt.format(Double.parseDouble(paramDados));
			}
		}
		return paramDados;
	}

	public static String formataCST_IPI(String paramDados, boolean paramFormata){
		NumberFormat fmt = new DecimalFormat("00");
		if(paramFormata){
			if(paramDados.matches("[0-9]+")){
				return fmt.format(Double.parseDouble(paramDados));
			}
		}
		return paramDados;
	}

	public static String formataCST_PIS(String paramDados, boolean paramFormata){
		NumberFormat fmt = new DecimalFormat("00");
		if(paramFormata){
			if(paramDados.matches("[0-9]+")){
				return fmt.format(Double.parseDouble(paramDados));
			}
		}
		return paramDados;
	}

	public static String formataCST_COFINS(String paramDados, boolean paramFormata){
		NumberFormat fmt = new DecimalFormat("00");
		if(paramFormata){
			if(paramDados.matches("[0-9]+")){
				return fmt.format(Double.parseDouble(paramDados));
			}
		}
		return paramDados;
	}

	public static String formataMonetario(String paramDados){
		
		String stringTemp = "";
		if(paramDados!=null){
			if(paramDados.contains(".") || paramDados.contains(",")){
				stringTemp = paramDados.replace(".", "").replace(",", "") ;
				if(stringTemp.matches("^-[0-9]+")||stringTemp.matches("[0-9]+")){
					double doubleValor = Double.parseDouble(stringTemp)/100;
					return DINHEIRO_REAL.format(doubleValor);
				}
			}
		}
		return paramDados;
	}
	
	public static String formataAlinhamento(String paramDados){
		String stringTemp = "";
		if(paramDados!=null){
			if(paramDados.contains(".") || paramDados.contains(",")){
				stringTemp = paramDados.replace(".", "").replace(",", "") ;
				if(stringTemp.matches("^-[0-9]+")||stringTemp.matches("[0-9]+")){
					return "<div style='width:100%;text-align:right;'>"+paramDados+"</div>";
				}
			}
		}
		return paramDados;
	}
	
	public static boolean verificaNumericoPOI(String paramDados){
		String stringTemp = "";
		if(paramDados!=null){
			if(paramDados.contains(".") || paramDados.contains(",")){
				stringTemp = paramDados.replace(".", "").replace(",", "") ;
				if(stringTemp.matches("^-[0-9]+")||stringTemp.matches("[0-9]+")){
					return true;
				}
			}
		}
		return false;
	}
	
	public static double converteDoublePOI(String paramDados){
		String stringTemp = "";
		if(paramDados!=null){
			if(paramDados.contains(".") || paramDados.contains(",")){
				stringTemp = paramDados.replace(".", "").replace(",", "") ;
				if(stringTemp.matches("^-[0-9]+")||stringTemp.matches("[0-9]+")){
					double stringRet = Double.parseDouble(stringTemp)/100;
					return stringRet;
				}
			}
		}
		return 0.0;
	}
	
	public static double converteTributadaMI(String paramDados){
		String stringTemp = "";
		if(paramDados!=null){
			if(paramDados.contains(".") || paramDados.contains(",")){
				stringTemp = paramDados.replace(".", "").replace(",", "") ;
				if(stringTemp.matches("^-[0-9]+")||stringTemp.matches("[0-9]+")){
					double stringRet = Double.parseDouble(stringTemp)/1000;
					return stringRet;
				}
			}
		}
		return 0.0;
	}

	public static String removeTagsHTML(String paramDados){
		return paramDados.replaceAll("<[^>]*>", "");
	}
	
	public static String formatar( String valor, String mascara ) {
        String dado = "";      
        for ( int i = 0; i < valor.length(); i++ )  {
            char c = valor.charAt(i);
            if ( Character.isDigit( c ) ) { dado += c; }
        }

        int indMascara = mascara.length();
        int indCampo = dado.length();

        for ( ; indCampo > 0 && indMascara > 0; ) {
            if ( mascara.charAt( --indMascara ) == '#' ) { indCampo--; }
        }

        String saida = "";
        for ( ; indMascara < mascara.length(); indMascara++ ) {    
            saida += ( ( mascara.charAt( indMascara ) == '#' ) ? dado.charAt( indCampo++ ) : mascara.charAt( indMascara ) );
        }    
        return saida;
    }
    
    public static String formatarCpf( String cpf ) {
        while( cpf.length() < 11 ) {
            cpf = "0" + cpf;
        }
        return formatar( cpf, "###.###.###-##" );
    }
    
    
    private String readTextFile(String fileName) throws IOException {
    	 
        //carrega o arquivo especificado em "fileName"
        InputStream input = getClass().getResourceAsStream(fileName);     
        //Abre fluxos de saída para escrever o conteúdo do arquivo
        ByteArrayOutputStream output = new ByteArrayOutputStream(1024);     
        byte[] buffer = new byte[512];
     
        int bytes;     
        while ((bytes = input.read (buffer)) > 0) {
            output.write (buffer, 0, bytes);
        }
     
        input.close ();
        //retorna o conteúdo do arquivo lido em String
        return new String(output.toByteArray());
    }
    
}
