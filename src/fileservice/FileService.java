/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.*;
import java.util.*;
/**
 *
 * @author John
 */
public class FileService {

 
    private FileTextReader ftr;
    private FileTextWriter ftw;

    public FileService(FileTextReader ftr, FileTextWriter ftw) {
        this.ftr = ftr;
        this.ftw = ftw;
    }
    
    public List<Map<String,String>> readFile(File file) throws IOException{
        return ftr.readFile(file);
    }
    
}
