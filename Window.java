import javax.swing.JFrame;
import javax.swing.JPanel;
public class Window extends JFrame{

    public Window(){
        setSize(800, 400);
        setContentPane(new Artist());
        setTitle("Perlin Noise in 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[]args){
        Window frame = new Window();
    }
}
