import java.io.File;
import java.util.*;



public class  RepeatInfo {
  File temp;
  Map<String, String> name=new HashMap<>();
  Map<String, String> rename=new HashMap<>();
  
  public RepeatInfo(File s){
	store(s);
  }
  
  public void store(File s){
	try {
		_FilePaths.getfilepath(s);            
	} catch (Exception e) {
		e.printStackTrace();
	}
	for (String path : _FilePaths.list) {
		temp=new File(path);
		String key= MD5.getFileMD5(temp);
		if(key!=null){
			Collection<String> collection=name.keySet();
			Iterator<String> it=collection.iterator();
			while (it.hasNext()) {
			   String temp=it.next();
               if (temp.equals(key)) {
            	rename.put(name.get(temp),key);
				rename.put(path,key);
			   }                
			}		
			name.put(key,path);
		}		
	}  
  }
  
   public List<info> cout(){
	  Set<String> keys = MapSortByValue.sortByValue(rename).keySet();
	  Iterator<String> ita = keys.iterator();
	  info tempinfo;
	  List<info> infos=new ArrayList<>();
	  while(ita.hasNext()) {		
	   String key = ita.next();
	   tempinfo=new info();
	   tempinfo.setPath(key);
	   tempinfo.setMd5(rename.get(key));
	   tempinfo.setpathandmd5(key+"  MD5 is:"+rename.get(key));
	   infos.add(tempinfo);
      }
	  return infos;
   }
  

}  


