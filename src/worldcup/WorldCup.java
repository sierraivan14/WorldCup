package worldcup;

import java.io.FileNotFoundException;
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

}
