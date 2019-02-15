package com.fineworkimg.jsf.controller.commission;

import com.fineworkimg.ejb.facade.CommissionFacade;
import com.fineworkimg.core.util.DateTimeUtil;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@Named(P101Controller.CONTROLLER_NAME)
public class P101Controller implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(P101Controller.class);
    public static final String CONTROLLER_NAME = "p101Controller";

    //
    @Inject
    private CommissionFacade commissionFacade;
    
    //find by criteria
    private String username;
    private Date startDate;
    private Date toDate;

    @PostConstruct
    public void init() {
        //criteria
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.add(Calendar.DAY_OF_MONTH, -7);
        startDate = cal.getTime();
        toDate = DateTimeUtil.getSystemDate();

        search();
    }

    public void search() {
        try {

            if (null != startDate) {
                //Init start date
                Calendar c1 = Calendar.getInstance();
                c1.setTime(startDate);
                c1.set(Calendar.HOUR_OF_DAY, 0);
                c1.set(Calendar.MINUTE, 0);
                c1.set(Calendar.SECOND, 0);
                startDate = c1.getTime();
            }
            if (null != toDate) {
                //Init to date
                Calendar c2 = Calendar.getInstance();
                c2.setTime(toDate);
                c2.set(Calendar.HOUR_OF_DAY, 23);
                c2.set(Calendar.MINUTE, 59);
                c2.set(Calendar.SECOND, 59);
                toDate = c2.getTime();
            }

//            items = commissionFacade.findUserPointByCriteria(StringUtils.trimToEmpty(username), startDate, toDate);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}
