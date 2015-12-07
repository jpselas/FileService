/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class SingleSpaceFormat implements TextFormatStrategy{

    @Override
    public List<Map<String, String>> decode(String data) {
         List<Map<String, String>> records = new ArrayList<>();
        
        String[] lines = data.split("\\n");
        String[] header = lines[0].split(" ");
        for (int i = 1; i < lines.length; i++) {
            LinkedHashMap<String, String> record = new LinkedHashMap<>();
            String[] row = lines[i].split(" ");
            for (int j = 0; j < row.length; j++) {
                record.put(header[j], row[j]);
            }
            records.add(record);
        }
        return records;
    }

    @Override
    public void encode(List<Map<String, String>> data) {
         FileWriter fw = null;
         BufferedWriter bw = null;
         try{
            File file = new File("C:"+File.separatorChar + "temp" + File.separatorChar 
                        + "lab1.txt");
             // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            
            Map<String,String> entry1= data.get(0);
            Set<String> keys = entry1.keySet();
            for(String item : keys){
                bw.write(item + " ");
            }
            bw.write("\n");
            for (Map<String, String> entry : data) {
                for (String key : keys) {
                    String value = entry.get(key);
                    bw.write(value + " ");
                }
                bw.write("\n");
            }
        }
        catch(Exception e){
                e.printStackTrace();
        }
         finally{
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(SingleSpaceFormat.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Done");
         }
    }
    }

