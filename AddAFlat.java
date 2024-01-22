import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddAFlat extends JFrame implements Serializable {
    AddAFlat (){

        String[] responses = {"Flat", "Villa"};
		int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to add","Confirm the type?",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				responses,
				0);

		String owner = JOptionPane.showInputDialog("Enter the owner name? ");
		String sizeStr = JOptionPane.showInputDialog("Enter the size of plot in Kanals? ");
        int size = Integer.parseInt(sizeStr);
		String sector = JOptionPane.showInputDialog("Enter the Sector of plot? ");
		String street = JOptionPane.showInputDialog("Enter the Street of plot?");
		String plotNumber = JOptionPane.showInputDialog("Enter the number of plot? ");
		String priceStr = JOptionPane.showInputDialog("Enter the price of plot? ");
        int price = Integer.parseInt(priceStr);

		Address myAddress = new Address(plotNumber, street, sector);

		if (buttonResponse == 0) {
			Flat                  plotObj = new Flat(owner, size, myAddress, price);
			FileOperationProperty myFile  = new FileOperationProperty();
			myFile.addFlat(plotObj);
			JOptionPane.showMessageDialog(null, "Congratulations! Flat added successfully",
			 "Update", JOptionPane.INFORMATION_MESSAGE );
		}
		else if (buttonResponse == 1) {
			VillaPlot             plotObj = new VillaPlot(owner, size, myAddress, price);
			FileOperationProperty myFile  = new FileOperationProperty();
			myFile.addVilla(plotObj);
			JOptionPane.showMessageDialog(null, "Congratulations! Villa Plot of size is added successfully",
			 "Update", JOptionPane.INFORMATION_MESSAGE );
		}
		else {
			System.out.println("Invalid input !!!");
		}




		
    }	
    //Adding event listeners
		// @Override
		// public void actionPerformed(ActionEvent e){
		// 	if(e.getSource() == buttonResponse){
		// 		System.out.println("Poo");
		// 	}
		// }

}