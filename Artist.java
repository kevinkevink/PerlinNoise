import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Artist extends JPanel implements ActionListener {
    int seed = 1350;
    int x;
    PerlinNoise generator1;
    PerlinNoise generator2;
    PerlinNoise generator3;
    PerlinNoise generator4;
    ArrayList<Integer> yCoords;

    public Artist(){
        generator1 = new PerlinNoise(40, 5, 18 + seed);
        generator2 = new PerlinNoise(40, 25, 1878 + seed);
        generator3 = new PerlinNoise(40, 125, 3030 + seed);
        generator4 = new PerlinNoise(40, 400, 1 + seed);
        Timer timer = new Timer(10, this);
        timer.start();
        x = 0;
        yCoords = new ArrayList<Integer>();
    }

    public void paintComponent(Graphics g) {
        int y1, y2, y3, y4;
        g.setColor(Color.blue);
        y1 = generator1.generateHeight(x);
        y2 = generator2.generateHeight(x);
        y3 = generator3.generateHeight(x);
        y4 = generator4.generateHeight(x);
        yCoords.add(y1 + y2 + y3 + y4);
        if (x < 801) {
            g.fillRect(x, y1 + y2 + y3 + y4, 8, 8);
            x++;
            for(int i = 0; i < x; i++){
                int y = yCoords.get(i).intValue();
                g.setColor(Color.black);
                g.fillRect(i, y, 4, 4);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x < 801){
            repaint();
        }
    }
}
