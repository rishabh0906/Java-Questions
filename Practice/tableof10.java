import java.applet.Applet;
import java.awt.*;

public class tableof10 extends Applet {
    int count, i;

    public void init() {
        this.count = 10;
    }

    public void start(){
        
    }

    public void paint(Graphics g) {
        for (i = 1; i <= 10; i++) {
            g.drawString(i + "* 10 =" + i * 10, 150, count);
            count = count + 20;
        }

    }

}
