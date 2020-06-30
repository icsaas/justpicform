import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Date;

public class SerializableDemo{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Initializes The Object
        User user = new User();
        user.setName("hollis");
        user.setGender("male");
        user.setAge(23);
        user.setBirthday(new Date());
        System.out.println(user);

        //Write obj to File
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);

        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            IOUtils.closeQuietly(oos);
        }
        //Read obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User)ois.readObject();
            System.out.println(newUser);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            IOUtils.closeQuietly(ois);
            try{
                FileUtils.forceDelete(file);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

         oos = new ObjectOutputStream(new FileOutputStream("tempFile"));

        oos.writeObject(Singleton.getSingleton());

        //Read Object from file
         file = new File("tempFile");
         ois = new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton)ois.readObject();
        System.out.println(newInstance==Singleton.getSingleton());


    }

}
