package worldcup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    public static void main(String[] args) {
        WorldCup demo = new WorldCup();
        VistaDesktop vista = new VistaDesktop(demo);
        
        vista.show();
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
    
    class VistaDesktop{
        WorldCup datos;

        public VistaDesktop(WorldCup datos) {
            this.datos = datos;
        }
        
        void show(){
            JPanel panel = new JPanel();
            JLabel uno = new JLabel(), dos = new JLabel(), tres = new JLabel();
            String [] partes = datos.dataSet.split(", ");
            String primero = partes[3], segundo = partes[4], mundial = partes[0] + "-" + partes[1]+ "," + partes[2];
            ImageIcon lugar = new ImageIcon("/Users/gokuv/OneDrive/Imágenes/Topicos/" + partes[0] + ".jpg" );
        }
            
    }
}
