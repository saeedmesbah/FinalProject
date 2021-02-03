
import java.io.*;


/**
 *
 * @author Saeed & Maryam
 */
public class WriteObjectToFile {
    
    private ObjectOutputStream out;
    
    public WriteObjectToFile(String filelocation) throws FileNotFoundException,IOException{
        
        out=new ObjectOutputStream(new FileOutputStream(new File(filelocation)));
    
    }
    
    /**
     * write object to file method
     * @param object
     * @throws IOException 
     */
    public void writeToFile(Object object) throws IOException{
        out.writeObject(object);
    }
    
    
    /**
     * close file writer 
     * @throws IOException 
     */
    public void closeFileWriter() throws IOException{
        out.close();
    }
    
}
