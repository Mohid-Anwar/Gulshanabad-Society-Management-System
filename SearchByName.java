import javax.swing.JOptionPane;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SearchByName {
    SearchByName() {
        try{
            String[] responses = {"Flat", "Villa"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to search","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            String name = JOptionPane.showInputDialog("Enter the name you want to search? ");
            if(buttonResponse == 0){
                boolean flag = false;
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Flat.txt"));
                    try{

                        while(true){
                            Flat s = (Flat) obj.readObject();
                            if(s.getOwner().equalsIgnoreCase(name)){
                                flag = true;
                                new Details(s.toString());
                            }
                            
                        }
                    }catch(EOFException e){
                        obj.close();
                        System.out.println("The targetted file has ended Flat\n");
                    }
                }catch(FileNotFoundException e){
                    System.out.println("no file of Flat");
                    JOptionPane.showMessageDialog(null, "No such record found!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error Flat");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Flat of " + name+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Flat of " + name+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else if(buttonResponse == 1){
                boolean flag = false;
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Villa.txt"));
                    try{    
                        while(true){
                            VillaPlot s = (VillaPlot) obj.readObject();
                            if(s.getOwner().equalsIgnoreCase(name)){
                                flag = true;
                                new Details(s.toString());
                            }    
                        }
                    }catch(EOFException e){
                        obj.close();
                        System.out.println("The targetted file has ended Flat\n");
                    }
                }catch(FileNotFoundException e){
                    JOptionPane.showMessageDialog(null, "No such record found!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Villa plot of " + name+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Villa plot of " + name+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
        catch(Exception e){
            System.out.println("Any error "+e.getMessage());
        }
        
    }

}