import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JButton blogin      = new JButton("Log In");
    JButton bSignUp    = new JButton("Sign Up");
    JButton bReset = new JButton("Reset");
    JButton bBack  = new JButton("Back");

    JTextField userIdField   = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel headerLabel = new JLabel("Log In...");
    JLabel userIdLabel = new JLabel("User Email");
    JLabel userPasswordLabel = new JLabel("Password");
//    JLabel messageLabel = new JLabel();


    LoginPage(){
//        setLocationRelativeTo(null);
        setTitle("New Gulshanabad Society");
        ImageIcon image = new ImageIcon("Images/logo.jpg");
        setIconImage(image.getImage());
        // getContentPane().setBackground(new Color(50,20,60));


        headerLabel.setBounds(150,20,400,50);
        headerLabel.setFont(new Font(null, Font.BOLD, 40));

        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

//        messageLabel.setBounds(50, 300,500,35);
//        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        userIdField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        add(headerLabel);
        add(userIdField);
        add(userPasswordField);

        blogin.setBounds(120,200,100,25);
        blogin.setFont(new Font("Calibri", Font.BOLD, 18));
        blogin.setBackground(Color.darkGray);
        blogin.setForeground(Color.white);
        blogin.setFocusable(false);
        blogin.addActionListener(this);

        bSignUp.setBounds(230,200,100,25);
        bSignUp.setFont(new Font("Calibri", Font.BOLD, 18));
        bSignUp.setBackground(Color.darkGray);
        bSignUp.setForeground(Color.white);
        bSignUp.setFocusable(false);
        bSignUp.addActionListener(this);

        bReset.setBounds(120,250,100,25);
        bReset.setFont(new Font("Calibri", Font.BOLD, 18));
        bReset.setBackground(Color.darkGray);
        bReset.setForeground(Color.white);
        bReset.setFocusable(false);
        bReset.addActionListener(this);

        bBack.setBounds(230,250,100,25);
        bBack.setFont(new Font("Calibri", Font.BOLD, 18));
        bBack.setBackground(Color.darkGray);
        bBack.setForeground(Color.white);
        bBack.setFocusable(false);
        bBack.addActionListener(this);

        add(userIdLabel);
        add(userPasswordLabel);
//        add(messageLabel);
        add(blogin);
        add(bSignUp);
        add(bReset);
        add(bBack);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100, 450,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSignUp) {
                    
            String[] responses = {"Admin", "Member"};
            int buttonResponse = JOptionPane.showOptionDialog(this,"Select Your Account Type","SignUp",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            if(buttonResponse == 0){
                dispose();
                new AdminSignUp();
            }
            else if (buttonResponse == 1) {
                dispose();
                new OwnerSignUp();
            }

        }

        if (e.getSource() == bReset) {
            userIdField.setText("");
            userPasswordField.setText("");
//            messageLabel.setText("");
        }

        if (e.getSource() == blogin) {
            String UserID = userIdField.getText();
            String              password = String.valueOf(userPasswordField.getPassword());
            FileOperationsAdmin f        = new FileOperationsAdmin();

            try {
                if (f.readPasswordsAndValidate(UserID,password)){
//                    messageLabel.setForeground(Color.green);
//                    messageLabel.setText("Login successful");
                    JOptionPane.showMessageDialog(this, "LogIn SuccessFull!");


                    if(f.adminRoleCheck(UserID, password)) {
                        String[] responses = {"Property", "Owner"};
                        int buttonResponse = JOptionPane.showOptionDialog(this,"Select Menu to Open","Menu Selection",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        responses,
                        0);

                        if(buttonResponse == 0){
                            new PropertyDashboard();
                            dispose();
                        }
                        else if (buttonResponse == 1){
                            new OwnerDashboard();
                            dispose();
                        }

                    }
                    else{
                        System.out.println("is");
                        new ownerOnlyMenu();
                        dispose();
                    }
                }else {
//                    messageLabel.setForeground(Color.red);
//                    messageLabel.setText("Invalid UserName or Password!");
                    JOptionPane.showMessageDialog(this, "Invalid UserName or Password!");
                    userIdField.setText("");
                    userPasswordField.setText("");

                }
            } catch (Exception ex) {
//                messageLabel.setForeground(Color.red);
//                messageLabel.setText("Invalid UserName or Password!");
                JOptionPane.showMessageDialog(this, "Invalid UserName or Password!");
                userIdField.setText("");
                userPasswordField.setText("");
            }
        }

        if (e.getSource() == bBack) {
            dispose();
            new mainMenuFrame();
        }
    }
}
