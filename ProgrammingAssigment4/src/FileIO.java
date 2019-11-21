
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clisk
 */
public class FileIO {
    
    private File file;
    private String filename;
    
    public FileIO()
    {
        file = null;
    }
    
    public FileIO(String filename)
    {
        this.filename = filename;
        file = new File(this.filename);
    }
    
    public Scanner openFileForReading()
    {
        try {          
            Scanner scnr = new Scanner(file);
            return scnr;
        } catch (FileNotFoundException ex) {
            // Returns null scanner if not found
            return null;
        }
    }
    
    public PrintWriter openFileForWriting()
    {
        try {
            PrintWriter writer = new PrintWriter(file);
            return writer;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    
    public File getFile()
    {
        return file;
    }
    
    public String getFilename()
    {
        return filename;
    }
    
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    
    public void setFile(File file)
    {
        this.file = file;
    }
}
