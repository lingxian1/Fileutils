import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UI extends JFrame implements ActionListener {
	JButton button =new JButton("选择目录");
	JFileChooser chooser=new JFileChooser();
    JTextArea textArea=new JTextArea(10,20);
    List<info> infos=new ArrayList<>();
	public UI()
	{       
		setSize(240,200);
		FlowLayout layout = new FlowLayout();
	    setLayout(layout);
	    setTitle("repeatinfo");
		add(button);
        add(textArea);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		button.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp=(JButton)e.getSource();
		 
		 if(temp==button){
			 textArea.setText("please wait...");
			 int status=chooser.showOpenDialog(this);
			 if(status!=JFileChooser.APPROVE_OPTION)
				 System.out.println("error");
			 else{
			   _FilePaths.list.clear();             //clear list
		     
		       File temps=chooser.getSelectedFile();  //get selected files
		       //System.out.println(temps.getAbsolutePath());
		       infos=new RepeatInfo(temps).cout();  //get repeat files info		       
               new ChooseFrame(infos);  //open a window 
               
		     }
		}
	}

}


