package org.fatec.les.controller.utils;

import java.io.IOException;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class jsfUtils {

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
		FacesMessage facesMessage = new FacesMessage(severity, "", mensagem);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static void redirecionar(String endereco) throws IOException {
		getCurrentInstance().getExternalContext().redirect(endereco);
	}

	public static void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

}
