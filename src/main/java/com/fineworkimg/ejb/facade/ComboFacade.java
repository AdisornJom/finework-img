package com.fineworkimg.ejb.facade;

import com.fineworkimg.core.ejb.bo.CommonBO;
import com.fineworkimg.core.ejb.entity.AdminUserRole;
import com.fineworkimg.core.ejb.entity.Language;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless
public class ComboFacade {

    @EJB
    private CommonBO commonBO;

    public List<Language> findLanguageList() throws Exception {
        return commonBO.findLanguageList();
    }

}
