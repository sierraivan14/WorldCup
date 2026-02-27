package worldcup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WorldCup {

    String dataSet;

    WorldCup() {
        try{
            dataSet = Archivo.load();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "El archivo de datos no existe", "World Cup" , JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
    }
    
    class Archivo {
        static String load()throws FileNotFoundException{
            String filename = "src/worldcup/Datos.txt";
            if (new File(filename).exists()) {
                Scanner sc;
                sc = new Scanner(new File(filename));
                return sc.nextLine();
            }else
                throw new FileNotFoundException("...");
        }
    }
}
