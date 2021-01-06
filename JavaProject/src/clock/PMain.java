package clock;

import java.awt.*; // java의 GUI Programming을 지원하기 위해 나온 AWT패키지
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

import org.omg.CORBA.PRIVATE_MEMBER;


public class PMain extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
//	private JButton bt1,bt2,bt3;
//	private JButton[] allBtn;
	// 배경 화면 설정
	JLabel background = new JLabel(new ImageIcon(PMain.class.getResource("../img1/moon3.PNG"))); 
	
	public PMain() {
		background.setBounds(2000, 100, 1000, 1000); // 배경화면의 위치 설정
		setTitle("Multi Clock"); // 프레임의 타이틀을 설정
		setSize(1200, 740); // 프레임의 사이즈를 정한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메인 프레임을 닫을 때 프로그램이 안정적으로 종료되도록 한다.
		contentPane = new JPanel(); // 버튼이나 라벨이 들어갈 화면을 만든다
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // 레이아웃이 없음을 의미한다.
		
//		JPanel bottom = new JPanel(new GridLayout(1,5,0,0));
//		bt1 = new JButton("Digital Clock");
//		bt2 = new JButton("Memo");
//		bt3 = new JButton("Analog Clock");
//		
//		bottom.setBackground(Color.WHITE);
//		bottom.add(bt1);
//		bottom.add(bt2);
//		bottom.add(bt3);
		
		JButton jButton1 = new JButton("Digital Clock"); // 버튼의 이름 설정
		jButton1.setFont(new Font("함초롬 돋움", Font.PLAIN, 18)); // 폰트, 폰트 크기 설정
		jButton1.setForeground(Color.white); // 글씨 색 설정
		jButton1.setBounds(50, 360, 320, 80); // 버튼의 위치 설정
		jButton1.setBackground(Color.darkGray); // 버튼의 색 설정
		contentPane.add(jButton1); // jButton1(= Digital Clock) 버튼 달기
		
		JButton jButton2 = new JButton("Analog Clock");
		jButton2.setFont(new Font("함초롬 돋움", Font.PLAIN, 18));  
		jButton2.setBounds(820, 360, 320, 80);
		jButton2.setBackground(Color.darkGray);
		jButton2.setForeground(Color.white);
		contentPane.add(jButton2);
		
		JButton jButton3 = new JButton("Memo");
		jButton3.setFont(new Font("함초롬 돋움", Font.PLAIN, 18));
		jButton3.setBounds(440, 535, 320, 80);
		jButton3.setBackground(Color.darkGray);
		jButton3.setForeground(Color.white);
		contentPane.add(jButton3);
		
		setVisible(true); // 화면에 프레임 출력을 한다.
		setLocationRelativeTo(null);// 화면 가운데서 창이 나온다.
		
		jButton1.addMouseListener(new MouseAdapter() { // 마우스를 클릭할때마다 이벤트를 준다.
			@Override
			public void mousePressed(MouseEvent e) {
				DigitalClock dc = new DigitalClock(); // 버튼을 눌렀을 때 DigitalClock()과 연결되도록 함
			}
		});
		
		jButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AnalogClock ac = new AnalogClock(); // 버튼을 눌렀을 때 AnalogClock()과 연결되도록 함
			}
		});
		
		jButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Memo me = new Memo(); // 버튼을 눌렀을 때 Memo()과 연결되도록 함
			}
		});
		
		background.setSize(1200, 720); // 배경화면의 사이즈를 설정
		background.setBounds(0, 0, 1200, 720); // 배경화면의 위치를 설정
		
		JLabel label = new JLabel("Multi Clock"); // PMain 화면 내의 타이틀 설정
		label.setForeground(Color.white); // PMain 화면 내의 타이틀 색 설정
		label.setFont(new Font("함초롬 돋움",Font.PLAIN,50)); // PMain 화면 내의 타이틀의 폰트, 폰트 크기 설정
		label.setBounds(470, 100, 600, 80); // PMain 화면 내의 타이틀의 위치 설정
		contentPane.add(label); // label(= "Multi Clock") 타이틀  달기
		contentPane.add(background); // background(= 배경화면) 달기
		setVisible(true); // 창을 화면에 나타낼 것인지 설정
	}

	public static void main(String[] args) {
		PMain p = new PMain(); // PMain()을 연결시켜줌.
	}
}