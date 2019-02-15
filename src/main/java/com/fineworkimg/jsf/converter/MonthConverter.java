/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.jsf.converter;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Adisorn.jo
 */
@FacesConverter("monthConverter")
public class MonthConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return "";
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Map<String, Object> attributes = component.getAttributes();
        Locale locale1 = (Locale) attributes.get("locale");
        String locale=locale1.getLanguage();
        if (null == value) {
            return "";
        } else {
            int month = ((Integer) value).intValue();
            return Month.of(month).getDisplayName(TextStyle.FULL, new Locale(locale, locale.toUpperCase()));
        }
    }
}
