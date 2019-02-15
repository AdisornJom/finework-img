package com.fineworkimg.ejb.facade;

import com.fineworkimg.core.ejb.bo.CommissionBO;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless
public class CommissionFacade {

    @EJB
    private CommissionBO commissionBO;

    
}
