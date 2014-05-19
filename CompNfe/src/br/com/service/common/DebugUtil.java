package br.com.service.common;

import java.lang.reflect.Field;

public class DebugUtil {
	
	@SuppressWarnings("rawtypes")
	public void GetFldsFromClas(Object obj){
		try {
			final Class cls = obj.getClass();
			Field fieldlist[] = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				Field privateStringField = obj.getClass().getDeclaredField(fld.getName());
				privateStringField.setAccessible(true);
				Object fieldValue = privateStringField.get(obj);
				System.out.println(obj.getClass().getSimpleName() + " " + fld.getName() + " = " + fieldValue);
				//Logger.log(Logger.CONST_LEVEL_LOGGING, " DEBUG "+obj.getClass().getSimpleName() + " " + fld.getName() + " = " + fieldValue);
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
	
}
