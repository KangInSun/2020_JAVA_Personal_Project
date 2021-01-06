package clock;

import java.awt.*; // java�� GUI Programming�� �����ϱ� ���� ���� AWT��Ű��
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
	// ��� ȭ�� ����
	JLabel background = new JLabel(new ImageIcon(PMain.class.getResource("../img1/moon3.PNG"))); 
	
	public PMain() {
		background.setBounds(2000, 100, 1000, 1000); // ���ȭ���� ��ġ ����
		setTitle("Multi Clock"); // �������� Ÿ��Ʋ�� ����
		setSize(1200, 740); // �������� ����� ���Ѵ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �������� ���� �� ���α׷��� ���������� ����ǵ��� �Ѵ�.
		contentPane = new JPanel(); // ��ư�̳� ���� �� ȭ���� �����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // ���̾ƿ��� ������ �ǹ��Ѵ�.
		
//		JPanel bottom = new JPanel(new GridLayout(1,5,0,0));
//		bt1 = new JButton("Digital Clock");
//		bt2 = new JButton("Memo");
//		bt3 = new JButton("Analog Clock");
//		
//		bottom.setBackground(Color.WHITE);
//		bottom.add(bt1);
//		bottom.add(bt2);
//		bottom.add(bt3);
		
		JButton jButton1 = new JButton("Digital Clock"); // ��ư�� �̸� ����
		jButton1.setFont(new Font("���ʷ� ����", Font.PLAIN, 18)); // ��Ʈ, ��Ʈ ũ�� ����
		jButton1.setForeground(Color.white); // �۾� �� ����
		jButton1.setBounds(50, 360, 320, 80); // ��ư�� ��ġ ����
		jButton1.setBackground(Color.darkGray); // ��ư�� �� ����
		contentPane.add(jButton1); // jButton1(= Digital Clock) ��ư �ޱ�
		
		JButton jButton2 = new JButton("Analog Clock");
		jButton2.setFont(new Font("���ʷ� ����", Font.PLAIN, 18));  
		jButton2.setBounds(820, 360, 320, 80);
		jButton2.setBackground(Color.darkGray);
		jButton2.setForeground(Color.white);
		contentPane.add(jButton2);
		
		JButton jButton3 = new JButton("Memo");
		jButton3.setFont(new Font("���ʷ� ����", Font.PLAIN, 18));
		jButton3.setBounds(440, 535, 320, 80);
		jButton3.setBackground(Color.darkGray);
		jButton3.setForeground(Color.white);
		contentPane.add(jButton3);
		
		setVisible(true); // ȭ�鿡 ������ ����� �Ѵ�.
		setLocationRelativeTo(null);// ȭ�� ����� â�� ���´�.
		
		jButton1.addMouseListener(new MouseAdapter() { // ���콺�� Ŭ���Ҷ����� �̺�Ʈ�� �ش�.
			@Override
			public void mousePressed(MouseEvent e) {
				DigitalClock dc = new DigitalClock(); // ��ư�� ������ �� DigitalClock()�� ����ǵ��� ��
			}
		});
		
		jButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AnalogClock ac = new AnalogClock(); // ��ư�� ������ �� AnalogClock()�� ����ǵ��� ��
			}
		});
		
		jButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Memo me = new Memo(); // ��ư�� ������ �� Memo()�� ����ǵ��� ��
			}
		});
		
		background.setSize(1200, 720); // ���ȭ���� ����� ����
		background.setBounds(0, 0, 1200, 720); // ���ȭ���� ��ġ�� ����
		
		JLabel label = new JLabel("Multi Clock"); // PMain ȭ�� ���� Ÿ��Ʋ ����
		label.setForeground(Color.white); // PMain ȭ�� ���� Ÿ��Ʋ �� ����
		label.setFont(new Font("���ʷ� ����",Font.PLAIN,50)); // PMain ȭ�� ���� Ÿ��Ʋ�� ��Ʈ, ��Ʈ ũ�� ����
		label.setBounds(470, 100, 600, 80); // PMain ȭ�� ���� Ÿ��Ʋ�� ��ġ ����
		contentPane.add(label); // label(= "Multi Clock") Ÿ��Ʋ  �ޱ�
		contentPane.add(background); // background(= ���ȭ��) �ޱ�
		setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����
	}

	public static void main(String[] args) {
		PMain p = new PMain(); // PMain()�� ���������.
	}
}