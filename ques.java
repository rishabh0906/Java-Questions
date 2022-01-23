import java.applet.Applet;
import java.awt.*;

public class ques extends Applet {
    String s;
    public void init() {
    s = "Welcome to Java Applet"; 
    System.out.println("Inside init method");
    }
    public void start() { 
    System.out.println("Inside start method");
    }
    public void paint(Graphics g) { 
    System.out.println("Inside paint method"); 
    g.drawString(s, 100, 100);
    }
    public void stop() { 
    System.out.println("Inside stop method");
    }
    public void destroy() { 
    System.out.println("Inside destroy method");
    }
    
}
