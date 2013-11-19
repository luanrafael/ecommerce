package org.fatec.les.controller.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MsgUtil {

	public static void addInfo(String mensagem) {
		addMessage(FacesMessage.SEVERITY_INFO, mensagem);
	}

	public static void addWarn(String mensagem) {
		addMessage(FacesMessage.SEVERITY_WARN, mensagem);
	}

	public static void addError(String mensagem) {
		addMessage(FacesMessage.SEVERITY_ERROR, mensagem);
	}

	public static void addFatal(String mensagem) {
		addMessage(FacesMessage.SEVERITY_FATAL, mensagem);
	}

	private static void addMessage(FacesMessage.Severity severity,
			String mensagem) {
		getCurrentInstance().addMessage(null,
				new FacesMessage(severity, mensagem, mensagem));
	}

	private static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}
	
}
