package thread;
import java.awt.*;
import java.applet.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AppletThreadSample extends Applet implements Runnable {
    private Thread T; //создаётся объект потока

    private ShapePes m_ShapePes = null;
    private ShapeRect m_ShapeRect1 = null;
    private ShapeRect m_ShapeRect2 = null;

    public void run() {
        setBackground(Color.black);
        while (true) {
            repaint();
            try {
                T.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void init() { //метод инициализации апплета
        T = new Thread(this);
        T.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    m_ShapePes = new ShapePes();
                    m_ShapeRect1 = new ShapeRect();
                    m_ShapeRect2 = new ShapeRect();
                }
            }
        });
    }

    public void paint(Graphics g) {
        if (m_ShapePes != null && m_ShapeRect1 != null && m_ShapeRect2 != null) {
            int i = 50;
            while (i < 1100) {
                g.setColor(Color.orange);
                g.fillOval(m_ShapePes.x_Pes, m_ShapePes.y_Pes - i,
                        m_ShapePes.w_Pes, m_ShapePes.h_Pes);
                i += 50;
            }
            g.setColor(Color.black);
            g.fillRect(245, 0, 10, 250);

            g.setColor(Color.orange);
            g.fillPolygon(m_ShapeRect1.x_Tri, m_ShapeRect1.y_Tri, m_ShapeRect1.x_Tri.length);
            g.fillPolygon(m_ShapeRect2.x_Tri2, m_ShapeRect2.y_Tri2, m_ShapeRect2.x_Tri2.length);
        }
        g.setColor(Color.CYAN);
        g.drawLine(300, 0, 200, 500);
        g.drawLine(200, 0, 300, 500);
    }
}