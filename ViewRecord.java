import javax.swing.JOptionPane;


public class ViewRecord{

	ViewRecord() {
		String[] responses = {"Flat", "Villa"};
        int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to update","Confirm the type?",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
		responses,
		0);

        if(buttonResponse == 0){
   			FileOperationProperty f = new FileOperationProperty();
			f.viewFlat();
        }
        else if(buttonResponse == 1){
          	FileOperationProperty f = new FileOperationProperty();
			f.viewVilla();
		}
		else{
			System.out.println("No such record exists!!");
		}
	}
	
}