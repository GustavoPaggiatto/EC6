/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpii02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Gustavo
 */
public class LPII02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            registerDependencies();
        }
        catch (Exception ex) {
        }
    }
    
    private static void registerDependencies() throws ClassNotFoundException, FileNotFoundException, IOException {
        // Create Properties object.
	Properties props = new Properties();
	
        // Properties will use a FileReader object as input.
	FileReader fReader = new FileReader("JDBCSettings.properties");
        
        // Load jdbc related properties in above file. 
	props.load(fReader);
			
        Class.forName(props.getProperty("db.driver.class"));
    }
}
