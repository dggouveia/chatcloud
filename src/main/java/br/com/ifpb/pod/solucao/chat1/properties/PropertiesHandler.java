package br.com.ifpb.pod.solucao.chat1.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DouglasGabriel
 */
public class PropertiesHandler {

    private static Properties prop = null;
    private final String FILE_NAME = "/config.properties";
    private static PropertiesHandler instance;

    private PropertiesHandler (){
        this.prop = new Properties();
        try {
            loadProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadProperties () throws IOException{
        String path = getClass().getResource(FILE_NAME).getPath();
        System.out.println(path);
        this.prop.load(new FileInputStream(path));
    }
    
    public static PropertiesHandler getInstance(){
        if (instance == null)
            instance = new PropertiesHandler();
        return instance;
    }
    
    public String getProperty (String key){
        return this.prop.getProperty(key);
    }
    
}
