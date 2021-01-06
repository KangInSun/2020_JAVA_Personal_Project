package clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
 
import javax.swing.JFrame;

public class AnalogClock extends JFrame implements Runnable {
 
    private GregorianCalendar time;
 
    // frame ũ��
    private int width = 300;
 
    // time ����� ���� ����
    private int hour = 0;
    private int min = 0;
    private int sec = 0;
 
    private Graphics gp;
 
    // time�� ����� ������ Frame �� �̹����� �� ��ġ�ϱ� ���� �޼���
    public void paint(Graphics gp) {
 
        time = new GregorianCalendar();
 
        // �ð� ������ �����´�.
        min = time.get(Calendar.MINUTE);
        hour = time.get(Calendar.HOUR);
        sec = time.get(Calendar.SECOND);
 
        if (sec == 60) {
            sec = 0;
            min++;
        }
        
        if (min == 60) {
            min = 0;
            hour++;
        }
        
        if (min == 60 && hour == 12) {
            hour = 0;
        }
 
        // Frame ���ο� �׷��� ��� �κ��� �����.
        gp.clearRect(0, 0, width, width);
        
        // �ð� �׵θ��� ǥ���ϱ� ����
        rec_draw();
 
        // �� , �� , �� �ٴ��� �׸���.
        draw(150, 150, 150, 50, 50, hour * 30 + min / 2);
        draw(150, 150, 150, 50, 70, min * 6);
        draw(150, 150, 150, 50, 100, sec * 6);
       
    }
    
    // �ð� �׵θ��� ������ ǥ���ϱ� ���� �޼���
    public void rec_draw() {
        int j = 1;
        
        for (int i = 1; i <= 60; i++) {
            // 5 �� ������ �ð��� ǥ��, ���� ũ�� ǥ���Ͽ� ������ �Ѵ�.
            if (i % 5 == 0) {
                draw_t(150, 50, i * 6, 3);
                draw_time(150, 50, i * 6, j + "");
                j++;
            } 
            
            else {
                draw_t(150, 50, i * 6, 1);
            }
        }
    }
    
    // �ð� �׵θ��� ���� ǥ���ϱ� ���� �޼���
    public void draw_t(int x, int y, int angle, int width) {
        x = 150 + (int) (120 * Math.sin(angle * Math.PI / 180));
        y = 150 - (int) (120 * Math.cos(angle * Math.PI / 180));
        gp.fillRect(x, y, width, width);
    }
    
    // �ð� �׵θ� �κп� 5�� ������ �ð��� ǥ���ϱ� ���� �޼���
    public void draw_time(int x, int y, int angle, String i) {
        x = 147 + (int) (105 * Math.sin(angle * Math.PI / 180));
        y = 155 - (int) (100 * Math.cos(angle * Math.PI / 180));
        gp.drawString(i, x, y);
    }
 
    // ��, ��, �� �� ǥ���ϱ� ���� drawLine(���� �׸��� �޼���) ���
    public void draw(int ox, int oy, int x, int y, int l, int angle) {
        x = ox + (int) (l * Math.sin(angle * Math.PI / 180));
        y = oy - (int) (l * Math.cos(angle * Math.PI / 180));
        gp.drawLine(ox, oy, x, y);
    }
 
    // ������ ����
    public AnalogClock() {
        init();
    }
 
    // frame�� �׸��� ���� �ʱ�ȭ �޼���
    public void init() {
        this.setTitle("Analog Clock");
        this.setSize(width, width);
        this.setResizable(false);
        this.setVisible(true); // AnalogClock â�� ���� �� �ֵ��� ��
        this.setBackground(Color.white);
        this.setVisible(true);
        gp = getGraphics();
        setBounds(820, 435, width, width);
    }
 
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // 1�ʸ���
                repaint();
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        AnalogClock a2 = new AnalogClock();
        Thread th = new Thread(a2);
        th.start();
    }
}