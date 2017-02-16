import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
//tools
public class MD5 {
	 public static String getFileMD5(File file) {  
		   if (!file.isFile()) {   
		     return null;   
		   }   
		   MessageDigest digest = null;  
		   BufferedInputStream in = null;  
		   byte buffer[] = new byte[8192];  
		   int len; 
		   try {   
		     digest = MessageDigest.getInstance("MD5");    
		     in =new BufferedInputStream(new FileInputStream(file)) ;    
		     while ((len = in.read(buffer)) != -1) {    
		       digest.update(buffer, 0, len);    
		     }    
		     BigInteger bigInt = new BigInteger(1, digest.digest());   
		     return bigInt.toString(16);  
		   } 
		   catch (Exception e) {    
		     e.printStackTrace();   
		     return null;  
		   }finally{
			   try {
				in.close();     //must close !!
			} catch (IOException e) {
				e.printStackTrace();
			}
		   } 
	   } 
}

