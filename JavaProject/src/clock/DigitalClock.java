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
			int year = c.get(Calendar.YEAR); // 연도를 받아온다
			int month = c.get(Calendar.MONTH); // 월을 받아온다
			month = month + 1; // 1월이 0이라 +1을 해줌.
			int date = c.get(Calendar.DATE); // 일을 받아온다
			int amPm = c.get(Calendar.AM_PM); // 오전/오후를 받아온다
			int hour = c.get(Calendar.HOUR); // 시를 받아온다
			int min = c.get(Calendar.MINUTE); // 분을 받아온다
			int sec = c.get(Calendar.SECOND); // 초를 받아온다
			int msec = c.get(Calendar.MILLISECOND); // msec를 리턴 but.적용하지 않음.
			String ampm = amPm == Calendar.AM ? "PM" : "AM"; // 비교해서 pm이나 am을 am/pm에 저장
			int day = c.get(Calendar.DAY_OF_WEEK); // 요일을 정수형으로 리턴1=일~7은토
			String clockStr = year + ". " + month + ". " + date + "." + " day";
			String clockStr2 = ampm + " " + hour + " : " + min + " : " + sec + " sec";

			clockLabel.setText(clockStr);
			try {
				Thread.sleep(1000); // 1초마다
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			} // interrupt() 메소드를 이용하여 스레드를 정지
			
			clockLabel.setText(clockStr2);
			try {
				Thread.sleep(1000); // 1초마다
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			} // interrupt() 메소드를 이용하여 스레드를 정지
		}
	}

}

public class DigitalClock extends JFrame {
	ClockT timerThread;

	public DigitalClock() {
		setTitle("Digital Clock"); // 프레임의 타이틀 설정
		setLayout(new BorderLayout()); // 영역 사이에 간격이 없는 BorderLayout을 생성
		setVisible(true); // Digital Clock창을 닫을 수 있도록 함

		Container c = getContentPane(); //프레임에 연결된 컨텐트팬을 알아냄
		JLabel clock = new JLabel(""); 
		clock.setHorizontalAlignment(JLabel.CENTER); // Label 가운데 정렬
		clock.setFont(new Font("함초롬 돋움",Font.PLAIN,26));
		c.add(clock, BorderLayout.CENTER);
		
		timerThread = new ClockT(clock);
		timerThread.start(); // thread의 run()호출
		
		c.setBackground(Color.white);
		setBounds(689, 435, 552, 300);
		c.setSize(552, 300);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌
		
	}

	public static void main(String[] args) {
		new DigitalClock();
	}

	public void run() {
		
	}

}
