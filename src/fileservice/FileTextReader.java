/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 *
 * @author John
 */
public class FileTextReader {
    
     private TextFormatStrategy tfs;

    public FileTextReader(TextFormatStrategy tfs) {
        this.tfs = tfs;
    }
    
    public List<Map<String,String>>readFile(File data){
         BufferedReader in = null;
         String stuff = "";
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		 stuff += line + "\n";
		  line = in.readLine();
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Warning, File Couldn't Be Read!!!");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        return tfs.decode(stuff);
    }
}
