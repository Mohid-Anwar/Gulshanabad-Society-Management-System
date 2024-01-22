import javax.swing.JOptionPane;


public class UpdatePlotInformation{

	UpdatePlotInformation(){
			String[] responses = {"Flat", "Villa"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to update","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

			String oldName = JOptionPane.showInputDialog("Enter the owner of the plot:");
			String newName = JOptionPane.showInputDialog("Enter the new owner you want to update:");
			String priceStr = JOptionPane.showInputDialog("Enter the price you want to update:");
        	int price = Integer.parseInt(priceStr);


			FileOperationProperty f = new FileOperationProperty();

		if(buttonResponse == 0){
			if(f.updateFlat(oldName, newName, price)){
				JOptionPane.showMessageDialog(null, "Updated flat information Successfully!!", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
			else{
				
				JOptionPane.showMessageDialog(null, "No such user exists in flat files", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		else{
			if(f.updateVilla(oldName, newName, price)){
				JOptionPane.showMessageDialog(null, "Updated Villa plot information Successfully!!", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
			else{
				
				JOptionPane.showMessageDialog(null, "No such user exists in Villa files", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
		}
	}
	
}