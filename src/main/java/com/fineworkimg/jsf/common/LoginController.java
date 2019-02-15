package com.fineworkimg.jsf.common;

import com.fineworkimg.ejb.facade.CoreFacade;
import com.fineworkimg.core.util.JsfUtil;
import com.fineworkimg.core.util.MessageBundleLoader;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.omnifaces.util.Faces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * @author MR Aekasit Sengnualnim (Aek) System Analyst
 *
 * Progress Software Co.,Ltd Fl. 6-7 306 Supha Road, Phomphlab
 * Phomphlabsattupai, Bangkok 10100 Thailand Tel :+66 (0) 2867 5020 Mobile : +66
 * 91004 1009 Skype : s.aekasit MSN : aekasit.se@gmail.com Email :
 * aekasit.s@kasikornbank.com Website http://www.kasikornbank.com
 *
 * @create 11-11-2014 3:58:48 PM
 */
@SessionScoped
@ManagedBean(name = LoginController.CONTROLLER_NAME)
public class LoginController extends BaseController implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    public static final String CONTROLLER_NAME = "loginController";
    private String username;
    private String password;
    private String captchaCode;

    //
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager;
    @ManagedProperty(value = "#{sas}")
    private SessionAuthenticationStrategy sessionAuthenticationStrategy;
    @Inject
    private LogController log;
    //
    @Inject
    private CoreFacade coreFacade;

    //
    // For sound
    private Long depositCount;
    private Long withdrawCount;
    //

    @PostConstruct
    @Override
    public void init() {
    }

    public void login() {
        try {
            ExternalContext context = Faces.getExternalContext();
            if (context.getUserPrincipal() != null) {
                String serverName = context.getRequestServerName();
                if (StringUtils.equals(serverName, "localhost") || StringUtils.equals(serverName, "127.0.0.1")) {
                    Faces.redirect(context.getRequestContextPath());
                    Faces.responseComplete();
                } else {
                    Faces.redirect("/");
                    Faces.responseComplete();
                }
                return;
            }

            if (StringUtils.isBlank(username)) {
                captchaCode = "";
                JsfUtil.addFacesErrorMessage(MessageBundleLoader.getMessageFormat("messages.code.2002", "บัญชีผู้ใช้งาน"));
                return;
            }
            if (StringUtils.isBlank(password)) {
                captchaCode = "";
                JsfUtil.addFacesErrorMessage(MessageBundleLoader.getMessageFormat("messages.code.2002", "รหัสผ่าน"));
                return;
            }

//            HttpSession session = (HttpSession) context.getSession(false);
//            Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
//
//            if (!captcha.isCorrect(captchaCode)) {
//                captchaCode = "";
//                JsfUtil.addFacesErrorMessage(MessageBundleLoader.getMessage("messages.code.2025"));
//                return;
//            }
//
//            // Check IP Whitelist
//            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            String ipAddr = req.getHeader("X-FORWARDED-FOR");
//            if (ipAddr == null) {
//                ipAddr = req.getRemoteAddr();
//            }
//            ipAddr = StringUtil.getMyRealIp(ipAddr);

//            if (!coreFacade.checkIPWhitelist(username, ipAddr)) {
//                captchaCode = "";
//                JsfUtil.addFacesErrorMessage(MessageBundleLoader.getMessage("messages.code.2026"));
//                return;
//            }

            Authentication request = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext secu = SecurityContextHolder.getContext();
            secu.setAuthentication(result);
            // need special statement for mix spring authen and custom jsf form
            sessionAuthenticationStrategy.onAuthentication(result, Faces.getRequest(), Faces.getResponse());

            UserInfoController userInfoController = (UserInfoController) JsfUtil.getManagedBeanValue(UserInfoController.CONTROLLER_NAME);
            userInfoController.init();

            log.login();

            //
            //notiController.chkNotify();
            
            FacesContext.getCurrentInstance().responseComplete();
            context.redirect(context.getRequestContextPath());

//            String serverName = context.getRequestServerName();
//            if (StringUtils.equals(serverName, "localhost") || StringUtils.equals(serverName, "127.0.0.1")) {
//                Faces.redirect(context.getRequestContextPath());
//                Faces.responseComplete();
//            } else {
//                Faces.redirect("/");
//                Faces.responseComplete();
//            }

        } catch (IOException ex) {
            JsfUtil.addFacesErrorMessage(ex.getMessage());
            LOG.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
            JsfUtil.addFacesErrorMessage(MessageBundleLoader.getMessage("messages.code.1001"));
            LOG.error(ex.getMessage());
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }

    }

    public void isLogin() {
        try {
            Principal principal = Faces.getExternalContext().getUserPrincipal();
            if (principal != null) {
                ExternalContext context = Faces.getExternalContext();
                context.redirect(context.getRequestContextPath());
                Faces.responseComplete();
            }

        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

    public synchronized void logout() throws IOException {
        //this.username = null;
        //this.password = null;
        Faces.redirect(Faces.getRequestContextPath() + "/j_spring_security_logout");
        Faces.responseComplete();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public SessionAuthenticationStrategy getSessionAuthenticationStrategy() {
        return sessionAuthenticationStrategy;
    }

    public void setSessionAuthenticationStrategy(SessionAuthenticationStrategy sessionAuthenticationStrategy) {
        this.sessionAuthenticationStrategy = sessionAuthenticationStrategy;
    }
    
    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public Long getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(Long depositCount) {
        this.depositCount = depositCount;
    }

    public Long getWithdrawCount() {
        return withdrawCount;
    }

    public void setWithdrawCount(Long withdrawCount) {
        this.withdrawCount = withdrawCount;
    }
}
