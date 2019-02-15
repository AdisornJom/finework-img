/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.ejb.bo;

import com.fineworkimg.core.ejb.entity.Language;
import com.fineworkimg.ejb.dao.LanguageDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless(name = "fineworkimg.CommonBO")
public class CommonBO {

    @EJB
    private LanguageDAO languageDAO;
    
    public List<Language> findLanguageList() throws Exception {
        return languageDAO.findLanguageList();
    }
}
