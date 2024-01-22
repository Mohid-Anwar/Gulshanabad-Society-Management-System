import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PropertyDashboard extends JFrame implements ActionListener{
	
	JButton button7;
	JLabel  lHeader;
	JPanel  pHeader, pButtons;

	PropertyDashboard () {

		setSize(500,750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		setTitle("Admin Dashboard - Plot");
		ImageIcon image = new ImageIcon("Images/logo.jpg");
		setIconImage(image.getImage());


//        PANEL 1
		pHeader = new JPanel();
		pHeader.setLayout(new GridLayout(1, 1));
		pHeader.setBackground(Color.lightGray);

		lHeader = new JLabel("Admin Property Menu");
		lHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lHeader.setFont(new Font("Calibri", Font.BOLD, 36));
//        addition of header in panel 1
		pHeader.add(lHeader);
//        addition of panel 1 in the frame
		add(pHeader);


//        PANEL 2
		pButtons = new JPanel();
		pButtons.setLayout(new GridLayout(8, 1, 0, 10));
//        pButtons.setLayout(new FlowLayout());
		pButtons.setBackground(Color.lightGray);



		JButton button1 = new JButton("Register a Property");
		button1.setFont(new Font("Calibri", Font.BOLD, 18));
		button1.setBackground(Color.darkGray);
		button1.setForeground(Color.white);
		button1.setFocusable(false);
		button1.addActionListener(e -> new AddAFlat());

		JButton button2 = new JButton("Check Records");
		button2.setFont(new Font("Calibri", Font.BOLD, 18));
		button2.setBackground(Color.darkGray);
		button2.setForeground(Color.white);
		button2.addActionListener(e -> new ViewRecord());
		button2.setFocusable(false);

		JButton button3 = new JButton("Search by Name");
		button3.setFont(new Font("Calibri", Font.BOLD, 18));
		button3.setBackground(Color.darkGray);
		button3.setForeground(Color.white);
		button3.addActionListener(e -> new SearchByName());
		button3.setFocusable(false);

		JButton button4 = new JButton("Search by Sector");
		button4.setFont(new Font("Calibri", Font.BOLD, 18));
		button4.setBackground(Color.darkGray);
		button4.setForeground(Color.white);
		button4.addActionListener(e -> new SearchBySector());
		button4.setFocusable(false);

		JButton button5 = new JButton("Update Property Information");
		button5.setFont(new Font("Calibri", Font.BOLD, 18));
		button5.setBackground(Color.darkGray);
		button5.setForeground(Color.white);
		button5.addActionListener(e -> new UpdatePlotInformation());
		button5.setFocusable(false);

		JButton button6 = new JButton("Remove an Onwer");
		button6.setFont(new Font("Calibri", Font.BOLD, 18));
		button6.setBackground(Color.darkGray);
		button6.setForeground(Color.white);
		button6.addActionListener(e -> new DeleteRecordByOwner());
		button6.setFocusable(false);

		button7 = new JButton("Owner Functionality Menu");
		button7.setFont(new Font("Calibri", Font.BOLD, 18));
		button7.setBackground(Color.darkGray);
		button7.setForeground(Color.white);
		button7.addActionListener(this);
		button7.setFocusable(false);

		JButton button8 = new JButton("Exit");
		button8.setFont(new Font("Calibri", Font.BOLD, 18));
		button8.setBackground(Color.darkGray);
		button8.setForeground(Color.white);
		button8.addActionListener(e -> System.exit(0));
		button8.setFocusable(false);

		pButtons.add(button1);
		pButtons.add(button2);
		pButtons.add(button3);
		pButtons.add(button5);
		pButtons.add(button6);
		pButtons.add(button7);
		pButtons.add(button8);
		pButtons.add(button4);

		add(pButtons);

		setVisible(true);

	}
        @Override
        public void actionPerformed(ActionEvent ex) {
			if(ex.getSource() == button7){
                dispose();
                new OwnerDashboard();
            }
        }


	
}