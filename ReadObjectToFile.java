
import java.io.*;




/**
 *
 * @author Saeed & Maryam
 */
public class ReadObjectToFile {
    
    private ObjectInputStream in;
    
    public ReadObjectToFile(String filelocation) throws FileNotFoundException,IOException{
        
        in=new ObjectInputStream(new FileInputStream(new File(filelocation)));
    
    }
    
    /**
     * read object from file method
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object readFromFile() throws IOException, ClassNotFoundException{
        return  in.readObject();
    }
    
    
    /**
     * close file reader
     * @throws IOException 
     */
    public void closeFileReader() throws IOException{
        in.close();
    }
    
    
}
