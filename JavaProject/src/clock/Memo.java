package clock;

import java.awt.*;
import java.awt.event.*;
//import java.io.BufferedReader;
import java.io.BufferedWriter; // ���� ���� ����� �ʿ��� ��
//import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.border.Border;

public class Memo {
	public Memo() {

		// Frame ���� �� �߰�
		// Frame ���� ����ǥ���ٿ� �޸����� ǥ�õǵ��� �Ѵ�.
		JFrame frame = new JFrame("Memo");

		// Frame�� ����� �������� ���ϵ��� �Ѵ�.
		 frame.setResizable(false);

		// Memoâ�� ���� �� �ֵ��� ��
		frame.setVisible(true); 
		frame.setBounds(780, 300, 552, 300);
		
		// �г� ���� �� �߰�
		// �г� ��ü�� ����. (�ؽ�Ʈ ����)
		JPanel textPanel = new JPanel();

		// �� �Ʒ� �г��� ������ Ȯ���ϱ� ���ؼ� �гο� ������ �־���.
		textPanel.setBackground(Color.black);

		// frame �������ϰ�� �ټ� �������� �������� �� ���ʿ� textPanel�� ���� �ִ´�.
		frame.getContentPane().add(textPanel, "North");

		// TextArea�� content�� ����Ű�� ���ڿ��� ǥ���ϰ� 20��, 30���� �����մϴ�.
		JTextArea ta = new JTextArea(content, 20, 30);

		// �� �ѱ�� ��� �ѱ�
		ta.setLineWrap(true);

		// �� �ѱ� �� ���� ������ �ܾ ���࿡ ���� ������ �ʵ��� �ϱ�
		ta.setWrapStyleWord(true);

		// ToolTip����
		ta.setToolTipText("�̰��� �ؽ�Ʈ�� �Է��ϼ���");

		// TextArea�� �׵θ����� ���� ���� �α��� 3px�� �����մϴ�.
		Border lineBorder = BorderFactory.createLineBorder(Color.white, 3);

		// �ؽ�Ʈ�� TextArea ��� ���̿� ������ �α� ���ؼ� emptyBorder�� �����Ѵ�.
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

		// TextArea�� lineBorder(�����׵θ�), emptyBorder(����)�� ������ ���� ��輱�� �����Ѵ�.
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		// TextArea�� ��ũ�� ����� �߰��� �� Panel�ȿ� ���� �ֽ��ϴ�.
		textPanel.add(new JScrollPane(ta));

		// �޴���
		JMenuBar menuBar = new JMenuBar();

		// �޴�
		JMenu fileMenu = new JMenu("����");

		// �޴� ������ ������ �غ�
		JMenuItem saveItem = new JMenuItem("����");
		JMenuItem saveasItem = new JMenuItem("�ٸ� �̸����� ����");
		JMenuItem closeItem = new JMenuItem("�ݱ�");

		frame.setJMenuBar(menuBar);

		menuBar.add(fileMenu); // ����
		fileMenu.add(saveItem); // ����
		fileMenu.add(saveasItem); // �ٸ� �̸����� ����
		fileMenu.add(closeItem); // �ݱ�

		// ��� ������ �����Ѵ�.
		JTextArea tf = new JTextArea("", 10, 40);

		// ������ ���ϵ��� �Ѵ�.
		tf.setEditable(false);

		// �� �ѱ�� ��� �ѱ�
		tf.setLineWrap(true);

		FileDialog mSave = new FileDialog(frame, "����", FileDialog.SAVE);
		FileDialog mOpen = new FileDialog(frame, "����", FileDialog.LOAD);

		saveItem.addActionListener(new ActionListener() {

			@Override // �����ϱ⸦ ������ ��
			public void actionPerformed(ActionEvent e) {

				if (flag == 0) {
					mSave.setVisible(true);
					String data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������ ���ϸ��� ��´�.
					try {
						FileWriter fw = new FileWriter(data + ".txt"); // txt ���Ϸ� �����Ѵ�.
						BufferedWriter bw = new BufferedWriter(fw);

						String str = ta.getText();
						for (int i = 0; i < str.length(); i++) {
							if (str.charAt(i) == '\n') {
								System.out.println("find");
								bw.newLine();
							}

							else {
								bw.write(str.charAt(i));
							} // Textarea��  bw��ü�� �ִ� ������ �ִ´�.
						}

						bw.close();
						String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�
						frame.setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�
					}

					catch (Exception e1) {
					}
					flag = 1;
				}

				else if (flag == 1) { 
					String data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������ ���ϸ��� ��´�.

					try {
						FileWriter fw = new FileWriter(data + ".txt"); // txt ���Ϸ� �����Ѵ�.
						BufferedWriter bw = new BufferedWriter(fw);

						String str = ta.getText();
						for (int i = 0; i < str.length(); i++) {
							if (str.charAt(i) == '\n') {
								System.out.println("find");
								bw.newLine();
							} else
								bw.write(str.charAt(i)); // Textarea�� bw��ü�� �ִ� ������ �ִ´�.
						}
						bw.close();
					} catch (Exception e2) {

					}

				}

			}
		});

		saveasItem.addActionListener(new ActionListener() { // �ٸ��̸����� �����ϱ⸦ ������ ��

			@Override
			public void actionPerformed(ActionEvent e) { 
				mSave.setVisible(true);
				String data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������ ���ϸ��� ��´�.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt ���Ϸ� �����Ѵ�.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = ta.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();

						} else
							bw.write(str.charAt(i)); // Textarea�� bw��ü�� �ִ� ������ �ִ´�.
					}

					bw.close();
					String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�,
					frame.setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�.
				} catch (Exception e1) {

				}

			}
		});

		closeItem.addActionListener(new ActionListener() { // �ݱ⸦ ������ ��

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// frame �ȿ� �ִ� ��� ������� ���̵��� frame����� �����Ѵ�.
		frame.pack();

		// frame�� ���̵��� �����մϴ�.
		frame.setVisible(true);
	}

	static String content = "";
	static int flag = 0; // ���� �� �ٸ� �̸����� ���忡 �̿�

	static int pos = 0;
	static int fromindex = 0;
}
