import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileOperationsOwner extends Person {
    private String password;


    public FileOperationsOwner () {
    }
    public FileOperationsOwner (String name, Address address, String phoneNo, String email, String password){
        super(name, address, phoneNo, email);
        this.password = password;
    }


    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    public void addMemberRecord(owner s){
        try {
            File f = new File("Owners.txt");
            if(f.exists()){
                myObjectOutputStream myObject = new myObjectOutputStream(new FileOutputStream(f, true));
                myObject.writeObject(s);
                myObject.close();
            }else{
                ObjectOutputStream myObject = new ObjectOutputStream(new FileOutputStream(f));
                myObject.writeObject(s);
                myObject.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public ArrayList<owner> checkAllRecords(){
        ArrayList<owner> list = new ArrayList<owner>();
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Owners.txt"));
            try {
                while(true){
                    owner s = (owner) redFile.readObject();
                    System.out.println(s.getName());
                    list.add(s);
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Object not found");
            }catch(EOFException e){
                redFile.close();
                System.out.println("End of file");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found ");
        }
        catch(IOException e){
            System.out.println("some error occured while reading "+ e.getMessage());
        }
        return list;
    }


    public String deleteRecordByEmail(String email){
        ArrayList<owner> list  = new ArrayList<owner>();
        boolean          check = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Owners.txt"));
            try {
                while(true){
                    owner s = (owner) obj.readObject();
                    
                    if(email.equals(s.getEmail())){
                        check = true;
                    }else{
                        list.add(s);
                    }
                }
            }catch(SecurityException e){
                System.out.println("Security 1");
            }catch(FileNotFoundException e){
                System.out.println("File not found 1");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file 1");
            }catch(IOException e){
                System.out.println("Io exception 1");
            }catch (Exception e) {
                System.out.println("Some error occured 1");
            }
        }catch (IOException e){
            System.out.println("Some file error occured");
        }
        
        try {
            File f = new File("Owners.txt");
            f.delete();
            int loopcount = list.size();
            for(int i = 0; i<loopcount; i++){
                addMemberRecord(list.remove(0));
            }
        }catch(SecurityException e){
            System.out.println("Security");
        }catch (Exception e) {
            System.out.println("Some error occured while removing by name : "+e.getMessage());
        }
    
        return check? "Removed successfully!" : "Cannot found";
    }


    public owner searchRecordByEmail(String email){
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Owners.txt"));
            try {
                while(true){
                    owner s = (owner) obj.readObject();
                    if(s.getEmail().equals(email)){
                        obj.close();
                        return s;
                    }
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Object not found");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }catch(IOException e){
                System.out.println("End of file");
            }
        }catch (IOException e) {
            System.out.println("Some I/O error occured");
        }catch(Exception e){
            System.out.println("Some error occured");
        }
        return null;
    }



    public String updateMemberRecord(String email, owner ms){
        ArrayList<owner> list  = new ArrayList<owner>();
        boolean          check = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Owners.txt"));
            try {
                while(true){
                    owner s = (owner) obj.readObject();
                    if(s.getEmail().equals(email)){
                        s = ms;
                        check = true;
                    }
                    list.add(s);
                }
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }catch(ClassNotFoundException e){
                System.out.println("Object not found");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }catch (Exception e) {
                System.out.println("Some error occured");
                e.printStackTrace();
            }
            
            try {
                File f = new File("Owners.txt");
                f.delete();
                int loopsize = list.size();
                for(int i = 0; i<loopsize; i++){
                    addMemberRecord(list.remove(0));
                }

            }catch(SecurityException e){
                System.out.println("Security");
            }catch (Exception e) {
                System.out.println("S0me error occured + ");
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found Exception");
        }catch(EOFException e){
            System.out.println("End of file Exception");
        }catch(IOException e){
            System.out.println("File I/O Exception");
        }catch(Exception e){
            System.out.println("SOme error occured "+e.getMessage());
        }
        return check ? "Udpated seccessfully" : "Cannot update";
    }

}
