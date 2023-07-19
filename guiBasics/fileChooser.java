package guiBasics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class fileChooser extends JFrame implements ActionListener {
    JButton selectFile;
    fileChooser(){
        selectFile=new JButton("Select File");
        selectFile.setPreferredSize(new Dimension(100,30));
        selectFile.addActionListener(this);

        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.add(selectFile);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==selectFile){
           JFileChooser file=new JFileChooser();
         int response=file.showOpenDialog(null);
           System.out.println(response);
           if(response==JFileChooser.APPROVE_OPTION){
               File f=new File(file.getSelectedFile().getAbsolutePath());
               System.out.println(f);
           }
       }
    }
}
class driver{
    public static void main(String[] args){
        new fileChooser();
    }
}
