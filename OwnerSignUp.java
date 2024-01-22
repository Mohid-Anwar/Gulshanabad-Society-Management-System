import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OwnerSignUp extends JFrame{
    JLabel l1, l2, l3, l4, l5, l6, l7, lHeader;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    JPanel  pHeader, pMid, pButtons;
    public OwnerSignUp (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Owner registration");
        setSize(500,700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

//        PANEL 1
        pHeader = new JPanel();
        pHeader.setLayout(new GridLayout(1, 1));
        pHeader.setSize(100, 100);
        pHeader.setBackground(Color.white);

        lHeader = new JLabel("OWNER SIGNUP");
        lHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lHeader.setFont(new Font("Calibri", Font.BOLD, 36));
//        addition of header in panel 1
        pHeader.add(lHeader);
//        addition of panel 1 in the frame
        add(pHeader, BorderLayout.NORTH);



//        PANEL 2
        pMid = new JPanel();
        pMid.setLayout(new GridLayout(7, 2, 0, 10));
        pMid.setBackground(Color.white);

        l1 = new JLabel("Name");
        l2 = new JLabel("Plot no");
        l3 = new JLabel("Street no");
        l4 = new JLabel("Sector");
        l5 = new JLabel("Phone no ");
        l6 = new JLabel("Email");
        l7 = new JLabel("Password");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();

        b1 = new JButton("Register");
        b1.setFont(new Font("Calibri", Font.BOLD, 18));
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.white);

        b2 = new JButton("Home");
        b2.setFont(new Font("Calibri", Font.BOLD, 18));
        b2.setBackground(Color.darkGray);
        b2.setForeground(Color.white);

        MyActionListener m = new MyActionListener();
        b1.addActionListener(m);
        b2.addActionListener(m);


        pMid.add(l1);
        pMid.add(t1);
        pMid.add(l2);
        pMid.add(t2);
        pMid.add(l3);
        pMid.add(t3);
        pMid.add(l4);
        pMid.add(t4);
        pMid.add(l5);
        pMid.add(t5);
        pMid.add(l6);
        pMid.add(t6);
        pMid.add(l7);
        pMid.add(t7);
        add(pMid, BorderLayout.CENTER);


//        PANEL 3
        pButtons = new JPanel();
        pButtons.setLayout(new FlowLayout());
        pButtons.setBackground(Color.white);

        pButtons.add(b1);
        pButtons.add(b2);
        add(pButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Register")){
                FileOperationsAdmin f    = new FileOperationsAdmin();
                String              name = t1.getText();
                String plotNo = t2.getText();
                String streetno = t3.getText();
                String city = t4.getText();
                String phoneNo = t5.getText();
                String email = t6.getText();
                String password = t7.getText();

                Address             userAddress = new Address(plotNo, streetno, city);
                owner               s           = new owner(name, userAddress, phoneNo, email, password);
                FileOperationsOwner ad          = new FileOperationsOwner();
                ad.addMemberRecord(s);
                IDAndPassword passId = new IDAndPassword(email, password, "Owner");
                f.writePasswordsAndUserNames(passId);
                new LoginPage();
                dispose();
            }

            else if(e.getActionCommand().equals("Home")){
                dispose();
                new LoginPage();
            }
        }
    }
}
