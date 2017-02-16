import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class _FilePaths {
   static List<String> list =new ArrayList<>();
   public static void getfilepath(File s) throws Exception {
    File root = s;
    showAllFiles(root);
   }
 
   final static void showAllFiles(File dir) throws Exception{
     File[] fs = dir.listFiles();
     for(int i=0; i<fs.length; i++){
       list.add(fs[i].getAbsolutePath());
       if(fs[i].isDirectory()){
         try{
           showAllFiles(fs[i]);
         }catch(Exception e){}
       }
     }
   }
}