import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class Details extends JFrame implements ActionListener{
	

	JTextArea textArea;
    JScrollPane scrollbar;
    JButton button = new JButton();

	Details(String str) {
		setSize(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Housing Society Management System");

		ImageIcon image = new ImageIcon("Images/logo.jpg");
		setIconImage(image.getImage());

		button.setText("Close");
		button.setBounds(195,300,75,40);
		button.addActionListener(this);
		
		textArea = new JTextArea(10,10);
		// textArea.setBounds(10,50,200,200)
		textArea.setSize(getWidth(), getHeight());
		textArea.setText(str);

		scrollbar = new JScrollPane(textArea);
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollbar);
		// add(button);
		setVisible(true);
		setResizable(false);
		
	}
        @Override
        public void actionPerformed(ActionEvent ex) {
			if(ex.getSource() == button){
                dispose();
            }
        }




	
}