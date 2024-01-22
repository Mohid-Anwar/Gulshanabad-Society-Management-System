import javax.swing.JOptionPane;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SearchBySector {
    SearchBySector() {
        try{
            String[] responses = {"Flat", "Villa"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to search","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            String sector = JOptionPane.showInputDialog("Enter the sector you want to search? ");
            if(buttonResponse == 0){
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Flat.txt"));
                    String output = "";
                    try{

                        while(true){
                            Flat s = (Flat) obj.readObject();
                            if(s.plotAddress.getSector().equalsIgnoreCase(sector)){
                                output += s.toString();

                            }


                        }
                    }catch(EOFException e){
                        obj.close();
                        new Details(output);
                    }
                }catch(FileNotFoundException e){

                }
                catch (ClassNotFoundException e) {

                }catch(IOException e){

                }

            }
            else if(buttonResponse == 1){
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Villa.txt"));
                    String output = "";
                    try{
                        while(true){
                            VillaPlot s = (VillaPlot) obj.readObject();
                            if(s.plotAddress.getSector().equalsIgnoreCase(sector)){
                                output += s.toString();
                            }
                        }
                    }catch(EOFException e){
                        obj.close();
                        new Details(output);
                    }
                }catch(FileNotFoundException e){

                }
                catch (ClassNotFoundException e) {

                }catch(IOException e){

                }


            }
        }
        catch(Exception e){
            System.out.println("Any error "+e.getMessage());
        }

    }

}