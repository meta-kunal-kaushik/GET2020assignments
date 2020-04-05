package dictionary;

/**
 * @author kunal
 * 
 * This class is used for entry of dictionary
 *
 */
public class Entry {

    public String key;
    public String value;
    Entry left,right;
   
    /**
     * Constructor initializes instance variables
     * @param key
     * @param value
     */
    public Entry(String key,String value){
        this.key=key;
        this.value=value;
        left=right=null;
    }
    
    /**
     * 
     * @return key
     */
    public String getKey(){
        return key;
    }
    
    /**
     * 
     * @return value
     */
    public String getValue(){
        return value;
    }
}