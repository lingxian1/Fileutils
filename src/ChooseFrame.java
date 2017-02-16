import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChooseFrame extends JFrame implements ActionListener {
	JButton button =new JButton("删除");
    List<info> infos=new ArrayList<>(); //repeat file lsit
    JList<String> jls;
	public ChooseFrame(List<info> infos) {
		this.infos=infos;
    	setSize(800,600);
 	    setLayout(new BorderLayout(10, 20));
 	    setTitle("repeatinfo");
 	    Container cp = getContentPane();
 	    jls = new JList<>(new MyListModel(infos));
		JScrollPane js = new JScrollPane(jls);
		js.setBounds(10, 10, 100, 100);
		cp.add(js);
 		add(button,BorderLayout.SOUTH);
 		button.addActionListener(this);
 		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp=(JButton)e.getSource();
		
		if(temp==button){
			int option = JOptionPane.showConfirmDialog(null,
					"是否删除选中文件", "delete", JOptionPane.YES_NO_OPTION,
				       JOptionPane.WARNING_MESSAGE, null);
				     switch (option) {
				     case JOptionPane.YES_NO_OPTION: {
				    	 if(deletefile()){
				    		 JOptionPane.showMessageDialog(null, "success", "message",JOptionPane.WARNING_MESSAGE);
				    		 dispose();
				    		 showlist(infos);
				    	 }else{
				    		 JOptionPane.showMessageDialog(null, "fail", "message",JOptionPane.WARNING_MESSAGE);  
				    	 } 
				         break;
				     }
				     case JOptionPane.NO_OPTION:
				        break;
				     }
            
		}
	}
	
	public boolean deletefile(){
		boolean flag=false;
		int [] indexs =jls.getSelectedIndices();
		for (int index : indexs) {
			File f =new File(infos.get(index).getPath());
			flag=f.delete();
		}
        for(int i=0,k=0;i<indexs.length;i++){
        	infos.remove(indexs[i]-k);
        	k++;
        }
		return flag;
	}
	
	public void showlist(List<info> infos){
		new ChooseFrame(infos);
	}
	
	class MyListModel extends AbstractListModel<String> {
		private String[] contents;
		public MyListModel(List<info> infos){
			contents=new String[infos.size()];
			for(int i=0;i<infos.size();i++){
				contents[i]=infos.get(i).getpathandmd5();
				//System.out.println(contents[i]);
			}
		}
		public String getElementAt(int x) {
			if (x < contents.length)
				return contents[x++];
			else
				return null;
		}
		
		public int getSize() {
			return contents.length;
		}
	}

}
