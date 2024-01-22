import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ImageIcon;

public class OwnerDashboard extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7;
    JLabel lHeader;
    JPanel pHeader, pButtons;
//    JScrollPane scrollbar = new JScrollPane();

    OwnerDashboard (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));
        setTitle("Admin Owner Menu");
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());



//        PANEL 1
        pHeader = new JPanel();
        pHeader.setLayout(new GridLayout(1, 1));
        pHeader.setBackground(Color.lightGray);

        lHeader = new JLabel("Admin Owner Menu");
        lHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lHeader.setFont(new Font("Calibri", Font.BOLD, 36));
//        addition of header in panel 1
        pHeader.add(lHeader);
//        addition of panel 1 in the frame
        add(pHeader);



//        PANEL 2
        pButtons = new JPanel();
        pButtons.setLayout(new GridLayout(7, 1, 0, 10));
//        pButtons.setLayout(new FlowLayout());
        pButtons.setBackground(Color.lightGray);

        b1 = new JButton("Display Owners Details");
        b1.setFont(new Font("Calibri", Font.BOLD, 18));
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.white);

        b2 = new JButton("Search Owner (email)");
        b2.setFont(new Font("Calibri", Font.BOLD, 18));
		b2.setBackground(Color.darkGray);
		b2.setForeground(Color.white);

        b3 = new JButton("Delete Owner (email)");
        b3.setFont(new Font("Calibri", Font.BOLD, 18));
		b3.setBackground(Color.darkGray);
		b3.setForeground(Color.white);

        b4 = new JButton("Update Owner Details");
        b4.setFont(new Font("Calibri", Font.BOLD, 18));
		b4.setBackground(Color.darkGray);
		b4.setForeground(Color.white);

        b7 = new JButton("Switch to Property Menu");
        b7.setFont(new Font("Calibri", Font.BOLD, 18));
		b7.setBackground(Color.darkGray);
		b7.setForeground(Color.white);

        b5 = new JButton("Logout");
        b5.setFont(new Font("Calibri", Font.BOLD, 18));
		b5.setBackground(Color.darkGray);
		b5.setForeground(Color.white);

//        b6 = new JButton("Exit");
//        b6.setFont(new Font("Calibri", Font.BOLD, 18));
//		b6.setBackground(Color.darkGray);
//		b6.setForeground(Color.white);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b7.addActionListener(a);
        b5.addActionListener(a);
//        b6.addActionListener(a);

        pButtons.add(b1);
        pButtons.add(b2);
        pButtons.add(b3);
        pButtons.add(b4);
        pButtons.add(b7);
        pButtons.add(b5);
//        pButtons.add(b6);

        add(pButtons);

        setVisible(true);
    }

    
    public class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Delete Owner (email)")) {
                String              email = JOptionPane.showInputDialog(null, "Enter the email to be deleted");
                FileOperationsOwner ad    = new FileOperationsOwner();
                JOptionPane.showMessageDialog(null, ad.deleteRecordByEmail(email), "Result", JOptionPane.INFORMATION_MESSAGE);
            }

            else if (e.getActionCommand().equals("Search Owner (email)")) {
                String              email = JOptionPane.showInputDialog(null, "Enter the email of owner to search");
                FileOperationsOwner ad = new FileOperationsOwner();
                owner               md = ad.searchRecordByEmail(email);
                if(md != null){
                    // ta.setText(md.toString());
                    new Details(md.toString());
                    JOptionPane.showMessageDialog(null, "Found", "Result", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Record not found");
                }
            }

            else if (e.getActionCommand().equals("Display Owners Details")) {
                String              str  = "";
                FileOperationsOwner ad   = new FileOperationsOwner();
                ArrayList<owner>    list = ad.checkAllRecords();
                for (int i = 0; i<list.size(); i++){
                    str += list.get(i).toString();
                }
                new Details(str);
            }

            else if(e.getActionCommand().equals("Logout")){
                dispose();
                new LoginPage();
            }
            
            else if(e.getActionCommand().equals("Switch to Property Menu")){
                dispose();
                new PropertyDashboard();
            }

            else if(e.getActionCommand().equals("Update Owner Details")){
                String email = JOptionPane.showInputDialog("Enter your email? ");
                System.out.println(email);
                FileOperationsOwner ad = new FileOperationsOwner();
                owner               md = new owner();
                md = ad.searchRecordByEmail(email);

                if(md != null){
                    JOptionPane.showMessageDialog(null,"Found");
                    dispose();
                    new UpdateOwnerRecord(md);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Member not found in record");
                }
            }
        }
    }
}