/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public class StartUp {
    public static void main(String[] args) throws IOException {
       FileService fs = new FileService(new FileTextReader(new SingleSpaceFormat()), new FileTextWriter(new SingleSpaceFormat()));
        List<Map<String,String>> list = fs.readFile(new File("C:" + File.separatorChar+"temp"+ File.separatorChar+ "test.txt" ));
        System.out.println(list);
    }
    
    
}
