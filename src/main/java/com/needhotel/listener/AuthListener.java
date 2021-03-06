package com.needhotel.listener;

import com.needhotel.visao.mbeans.LoginBean;

import javax.faces.application.NavigationHandler;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.Arrays;

public class AuthListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public void afterPhase(PhaseEvent event) {

        String[] paginasRestritas = {"/pages/usuario.xhtml" };

        LoginBean loginBean = (LoginBean)event.getFacesContext()
                .getExternalContext().getSessionMap().get("loginBean");

        String currentView = event.getFacesContext().getViewRoot().getViewId();

        boolean usuarioLogado = (loginBean != null && loginBean.getUsuarioLogado() != null);
        if (!currentView.equals("/pages/login.xhtml")
                && Arrays.asList(paginasRestritas).contains(currentView)
                && !usuarioLogado) {
            NavigationHandler nh = event.getFacesContext().getApplication().getNavigationHandler();
            nh.handleNavigation(event.getFacesContext(), currentView, "goToLogin");
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
