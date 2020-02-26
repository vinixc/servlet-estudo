package br.com.vini.gerenciador.listener;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class UsuarioDuplicadoListener implements HttpSessionAttributeListener{
	
	public static final String ATTRIBUTE_NAME = "usuarioLogado";
	private static final Set<Object> USUARIOS_LOGADOS = Collections.synchronizedSet(new HashSet<Object>());
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("USUARIO DUPLICADO LISTENER");
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		if(ATTRIBUTE_NAME.equals(attributeName)) {
			if(!USUARIOS_LOGADOS.add(attributeValue)) {
				event.getSession().removeAttribute(ATTRIBUTE_NAME);
			}
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		if(ATTRIBUTE_NAME.equals(attributeName)) {
			USUARIOS_LOGADOS.remove(attributeValue);
		}
	}

	public static Set<Object> getUsuariosLogados() {
		return USUARIOS_LOGADOS;
	}
}
