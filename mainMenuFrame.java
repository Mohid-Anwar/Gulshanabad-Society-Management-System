import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenuFrame extends JFrame {

    JButton bAdmin, bOwner, bExit;
    JPanel pMain, pHeader;
    JLabel lHeader, lMain, lImage;
    mainMenuFrame ()
    {
        setSize(900,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font f = new Font("Times New Roman",Font.BOLD,35);

        //header
        pHeader = new JPanel();
        pHeader.setLayout(null);
        pHeader.setSize(600,70);
        pHeader.setBounds(0,50,900,70);
        pHeader.setBackground(new Color(0,0,0,180));

        lHeader = new JLabel("NEW GULSHANABAD SOCIETY");
        lHeader.setForeground(Color.WHITE);
        lHeader.setBounds(200,10,600,50);
        lHeader.setFont(f);
        pHeader.add(lHeader);


        //main menu
        pMain = new JPanel();
        pMain.setLayout(null);
        pMain.setSize(400,400);
        pMain.setBounds(250,175,400,315);
        pMain.setBackground(new Color(0,0,0,180));

        lMain = new JLabel("MAIN MENU");
        lMain.setForeground(Color.WHITE);
        lMain.setBounds(95,30,250,50);
        lMain.setFont(f);
        pMain.add(lMain);


        bAdmin = new JButton("ADMIN");
        bAdmin.setBounds(130,120,140,30);
        bAdmin.setBackground(Color.lightGray);
        bAdmin.setForeground(Color.black);

        bOwner = new JButton("OWNER");
        bOwner.setBounds(130,180,140,30);
        bOwner.setBackground(Color.lightGray);
        bOwner.setForeground(Color.black);

        bExit = new JButton("EXIT");
        bExit.setBounds(130,240,140,30);
        bExit.setBackground(Color.lightGray);
        bExit.setForeground(Color.black);

//        pMain.add(bEmployee);
        pMain.add(bAdmin);
        pMain.add(bOwner);
        pMain.add(bExit);

        MyActionListener a = new MyActionListener();
        bAdmin.addActionListener(a);
        bOwner.addActionListener(a);
        bExit.addActionListener(a);

        //Background
        ImageIcon pic = new ImageIcon("oop2.jpg");
        Image img = pic.getImage();
        Image temp_img = img.getScaledInstance(900,600, Image.SCALE_SMOOTH);
        pic    = new ImageIcon(temp_img);
        lImage = new JLabel("",pic,JLabel.CENTER);
        lImage.setBounds(0,0,900,600);

        lImage.add(pHeader);
        lImage.add(pMain);
        add(lImage);

        setVisible(true);

    }

    public class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ADMIN")){
                dispose();
                new LoginPage();
            }
            else if (e.getActionCommand().equals("OWNER")){
                dispose();
                new LoginPage();
            }
            else if (e.getActionCommand().equals("EXIT")){
                System.exit(0);
            }
        }

    }
}
