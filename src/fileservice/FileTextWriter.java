/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.List;
import java.util.Map;
/**
 *
 * @author John
 */
public class FileTextWriter {
    
    private TextFormatStrategy tfs;
    
    
    public FileTextWriter(TextFormatStrategy tfs){
        this.tfs = tfs;
        
    }

    
    public void encode(List<Map<String,String>> data){
        tfs.encode(data);
    }
    
}
