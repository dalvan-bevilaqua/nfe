package br.com.service.bean;

import java.math.BigDecimal;

public interface Imposto {
abstract String returnCst();
abstract BigDecimal returnVlrBc();
abstract BigDecimal returnPorcentegem();
abstract BigDecimal returnValor();

}
