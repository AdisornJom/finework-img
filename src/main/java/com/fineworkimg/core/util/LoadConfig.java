/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author Adisorn.jo
 */
public class LoadConfig {

    private static final Logger LOG = Logger.getLogger(LoadConfig.class);
    private static Map<String, String> FILE_CONFIG;

    public static final String _IMAGES_URL = "images.url";
    public static final String _SMTP_HOST = "smtp.host";
    public static final String _SMTP_PORT = "smtp.port";
    public static final String _SMTP_USER = "smtp.user";
    public static final String _SMTP_PASS = "smtp.pass";
    public static final String _FTP_HOST = "ftp.host";
    public static final String _FTP_USER = "ftp.user";
    public static final String _FTP_PASS = "ftp.pass";
    public static final String _FTP_PORT = "ftp.port";
    public static final String FILE_DEFAULT = "config.properties";
    

   public static Map<String, String> loadFileDefault() {
        try {

            if (FILE_CONFIG == null) {
                FILE_CONFIG = new HashMap<>();
                Properties p = new Properties();
                p.load(LoadConfig.class.getClassLoader().getResourceAsStream(FILE_DEFAULT));
                Set keySet = p.keySet();
                for (Object key : keySet) {
                    FILE_CONFIG.put((String) key, (String) p.get(key));
                }
            }

            return FILE_CONFIG;
        } catch (IOException ex) {
            LOG.error(ex);
            return null;
        }
    }

    public static Map<String, String> loadFile(String path) {
        try {
            if (FILE_CONFIG == null) {
                FILE_CONFIG = new HashMap<>();
                Properties p = new Properties();
                p.load(LoadConfig.class.getClassLoader().getResourceAsStream(path));
                Set keySet = p.keySet();
                for (Object key : keySet) {
                    FILE_CONFIG.put((String) key, (String) p.get(key));
                }
            }
            return FILE_CONFIG;
        } catch (IOException ex) {
            LOG.error(ex);
            return null;
        }
    }
}
