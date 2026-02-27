package worldcup;

import java.awt.Dimension;
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
        try {
            dataSet = Archivo.load();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El archivo de datos no existe", "World Cup", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        WorldCup demo = new WorldCup();
        VistaDesktop vista = new VistaDesktop(demo);

        vista.show();
    }
}

class Archivo {

    static String load() throws FileNotFoundException {
        String filename = "src/worldcup/Datos.txt";
        if (new File(filename).exists()) {
            Scanner sc;
            sc = new Scanner(new File(filename));
            return sc.nextLine();
        } else {
            throw new FileNotFoundException("...");
        }
    }
}

class VistaDesktop {

    WorldCup datos;

    VistaDesktop(WorldCup datos) {
        this.datos = datos;
    }

    void show() {
        JPanel panel = new JPanel();
        JLabel uno = new JLabel(), dos = new JLabel(), tres = new JLabel();
        String[] partes = datos.dataSet.split(", ");
        String primero = partes[3], segundo = partes[4], mundial = partes[0] + "-" + partes[1] + "," + partes[2];
        ImageIcon lugar = new ImageIcon(getClass().getResource("/worldcup/Images/" + partes[0] + ".jpeg"));

        panel.setPreferredSize(new Dimension(700, 445));
        panel.setLayout(null);

        uno.setIcon(lugar);
        uno.setBounds(0, 0, 700, 445);

        dos.setIcon(new ImageIcon(getClass().getResource("/worldcup/Images/" + partes[3] + ".png")));
        dos.setBounds(10, 50, 200, 290);
        
        tres.setIcon(new ImageIcon(getClass().getResource("/worldcup/Images/" + partes[4] + ".png")));
        tres.setBounds(480, 100, 220, 220);
        
        panel.add(tres);
        panel.add(dos);
        panel.add(uno);
        
        JOptionPane.showMessageDialog(null, panel, mundial, -1);
    }

}