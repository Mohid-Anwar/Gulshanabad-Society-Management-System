import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ownerOnlyMenu extends JFrame{

    JButton b1, b2, b3, b4;
    JLabel lHeader;
    JPanel pHeader, pButtons;

    ownerOnlyMenu (){

        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());

        setSize(360,200);
        setLocationRelativeTo(null);
        setTitle("Member Dashboard");


        pHeader = new JPanel();
        pHeader.setLayout(new GridLayout(1, 1));
//        pHeader.setSize(100, 100);
        pHeader.setBackground(Color.white);

        lHeader = new JLabel("Member Menu");
        lHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lHeader.setFont(new Font("Calibri", Font.BOLD, 36));
//        addition of header in panel 1
        pHeader.add(lHeader);
//        addition of panel 1 in the frame
        add(pHeader);


        pButtons = new JPanel();
        pButtons.setLayout(new GridLayout(2, 1, 0, 10));
        pButtons.setBackground(Color.white);


        b1 = new JButton("Search plots by owner name");
        b1.setFont(new Font("Calibri", Font.BOLD, 18));
        b1.setBackground(Color.gray);
        b1.setForeground(Color.white);

        b4 = new JButton("Logout");
        b4.setFont(new Font("Calibri", Font.BOLD, 18));
        b4.setBackground(Color.gray);
        b4.setForeground(Color.white);

        pButtons.add(b1);
        pButtons.add(b4);


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b1.setFocusable(false);
        b4.addActionListener(a);
        b4.setFocusable(false);


        add(pButtons);

        setVisible(true);
    }



    
    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search plots by owner name")){
                new SearchByName();
            }else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }
            
        }
    }
}
