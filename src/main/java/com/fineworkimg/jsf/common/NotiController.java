package com.fineworkimg.jsf.common;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.util.Faces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@SessionScoped
@Named(NotiController.CONTROLLER_NAME)
public class NotiController implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(NotiController.class);
    public static final String CONTROLLER_NAME = "notiController";


    private Long deposit;
    private Long withdraw;
    private Long apiFail;
    private Boolean toggleSound = false;

    public void onIdle() throws Exception {
        Faces.redirect("expired.xhtml");
        logout();
    }

    private void logout() {
        HttpServletRequest request = Faces.getRequest();
        HttpServletResponse response = Faces.getResponse();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    public void chkNotify() throws Exception {
//        deposit = userTxnFacade.countTx(Constants.USER_TXN_TYPE_DEPOSIT);
//        withdraw = userTxnFacade.countTx(Constants.USER_TXN_TYPE_WITHDRAW);
//        apiFail = userFundsDataFacade.countRecordByStatus(Constants.USER_FUNDS_DATA_STS_TRANSAPIFAIL);
//        if (deposit > 0 || withdraw > 0 || apiFail > 0) {
//            toggleSound = true;
//        } else {
//            toggleSound = false;
//        }
//
//        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("listForm:depositTable");
//        if ((deposit > 0) && null != dataTable) {
//            c101Controller.search();
//    }
//        DataTable dataTable2 = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("listForm:withdrawTable");
//        if ((withdraw > 0) && null != dataTable2) {
//            c103Controller.search();
//        }
//        DataTable dataTable3 = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("listForm:fundDataTable");
//        if ((apiFail > 0) && null != dataTable3) {
//            c105Controller.search();
//        }

    }

    public void chkApiFailNotify() throws Exception {
//        apiFail = userFundsDataFacade.countRecordByStatus(Constants.USER_FUNDS_DATA_STS_TRANSAPIFAIL);
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Long withdraw) {
        this.withdraw = withdraw;
    }

    public Boolean getToggleSound() {
        return toggleSound;
    }

    public void setToggleSound(Boolean toggleSound) {
        this.toggleSound = toggleSound;
    }

    public Long getApiFail() {
        return apiFail;
}

}
