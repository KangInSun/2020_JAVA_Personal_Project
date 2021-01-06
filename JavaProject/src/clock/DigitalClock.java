package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ClockT extends Thread {
	private JLabel clockLabel;
	boolean flag = true;

	public ClockT(JLabel clockLabel) {
		this.clockLabel = clockLabel;
	}
	
	public ClockT() {
		
	}

	@Override
	public void run() {
		while (flag) {
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // ������ �޾ƿ´�
			int month = c.get(Calendar.MONTH); // ���� �޾ƿ´�
			month = month + 1; // 1���� 0�̶� +1�� ����.
			int date = c.get(Calendar.DATE); // ���� �޾ƿ´�
			int amPm = c.get(Calendar.AM_PM); // ����/���ĸ� �޾ƿ´�
			int hour = c.get(Calendar.HOUR); // �ø� �޾ƿ´�
			int min = c.get(Calendar.MINUTE); // ���� �޾ƿ´�
			int sec = c.get(Calendar.SECOND); // �ʸ� �޾ƿ´�
			int msec = c.get(Calendar.MILLISECOND); // msec�� ���� but.�������� ����.
			String ampm = amPm == Calendar.AM ? "PM" : "AM"; // ���ؼ� pm�̳� am�� am/pm�� ����
			int day = c.get(Calendar.DAY_OF_WEEK); // ������ ���������� ����1=��~7����
			String clockStr = year + ". " + month + ". " + date + "." + " day";
			String clockStr2 = ampm + " " + hour + " : " + min + " : " + sec + " sec";

			clockLabel.setText(clockStr);
			try {
				Thread.sleep(1000); // 1�ʸ���
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			} // interrupt() �޼ҵ带 �̿��Ͽ� �����带 ����
			
			clockLabel.setText(clockStr2);
			try {
				Thread.sleep(1000); // 1�ʸ���
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			} // interrupt() �޼ҵ带 �̿��Ͽ� �����带 ����
		}
	}

}

public class DigitalClock extends JFrame {
	ClockT timerThread;

	public DigitalClock() {
		setTitle("Digital Clock"); // �������� Ÿ��Ʋ ����
		setLayout(new BorderLayout()); // ���� ���̿� ������ ���� BorderLayout�� ����
		setVisible(true); // Digital Clockâ�� ���� �� �ֵ��� ��

		Container c = getContentPane(); //�����ӿ� ����� ����Ʈ���� �˾Ƴ�
		JLabel clock = new JLabel(""); 
		clock.setHorizontalAlignment(JLabel.CENTER); // Label ��� ����
		clock.setFont(new Font("���ʷ� ����",Font.PLAIN,26));
		c.add(clock, BorderLayout.CENTER);
		
		timerThread = new ClockT(clock);
		timerThread.start(); // thread�� run()ȣ��
		
		c.setBackground(Color.white);
		setBounds(689, 435, 552, 300);
		c.setSize(552, 300);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���������� JFrame�� ����ǰ� ����
		
	}

	public static void main(String[] args) {
		new DigitalClock();
	}

	public void run() {
		
	}

}
