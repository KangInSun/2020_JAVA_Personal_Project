package clock;

import java.awt.*;
import java.awt.event.*;
//import java.io.BufferedReader;
import java.io.BufferedWriter; // 많은 양의 출력이 필요할 때
//import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.border.Border;

public class Memo {
	public Memo() {

		// Frame 설정 및 추가
		// Frame 생성 제목표시줄에 메모장이 표시되도록 한다.
		JFrame frame = new JFrame("Memo");

		// Frame의 사이즈를 변경하지 못하도록 한다.
		 frame.setResizable(false);

		// Memo창을 닫을 수 있도록 함
		frame.setVisible(true); 
		frame.setBounds(780, 300, 552, 300);
		
		// 패널 설정 및 추가
		// 패널 객체를 생성. (텍스트 영역)
		JPanel textPanel = new JPanel();

		// 위 아래 패널의 영역을 확인하기 위해서 패널에 배경색을 주었다.
		textPanel.setBackground(Color.black);

		// frame 동서남북가운데 다섯 영역으로 구분했을 때 위쪽에 textPanel을 집어 넣는다.
		frame.getContentPane().add(textPanel, "North");

		// TextArea에 content가 가리키는 문자열을 표시하고 20행, 30열로 설정합니다.
		JTextArea ta = new JTextArea(content, 20, 30);

		// 행 넘기기 기능 켜기
		ta.setLineWrap(true);

		// 행 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
		ta.setWrapStyleWord(true);

		// ToolTip제작
		ta.setToolTipText("이곳에 텍스트를 입력하세요");

		// TextArea의 테두리선의 색을 검정 두깨를 3px로 설정합니다.
		Border lineBorder = BorderFactory.createLineBorder(Color.white, 3);

		// 텍스트와 TextArea 경계 사이에 여백을 두기 위해서 emptyBorder를 생성한다.
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

		// TextArea에 lineBorder(검정테두리), emptyBorder(여백)로 구성된 복합 경계선을 설정한다.
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		// TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
		textPanel.add(new JScrollPane(ta));

		// 메뉴바
		JMenuBar menuBar = new JMenuBar();

		// 메뉴
		JMenu fileMenu = new JMenu("파일");

		// 메뉴 아이템 순서로 준비
		JMenuItem saveItem = new JMenuItem("저장");
		JMenuItem saveasItem = new JMenuItem("다른 이름으로 저장");
		JMenuItem closeItem = new JMenuItem("닫기");

		frame.setJMenuBar(menuBar);

		menuBar.add(fileMenu); // 파일
		fileMenu.add(saveItem); // 저장
		fileMenu.add(saveasItem); // 다른 이름으로 저장
		fileMenu.add(closeItem); // 닫기

		// 출력 공간을 생성한다.
		JTextArea tf = new JTextArea("", 10, 40);

		// 적지는 못하도록 한다.
		tf.setEditable(false);

		// 행 넘기기 기능 켜기
		tf.setLineWrap(true);

		FileDialog mSave = new FileDialog(frame, "저장", FileDialog.SAVE);
		FileDialog mOpen = new FileDialog(frame, "열기", FileDialog.LOAD);

		saveItem.addActionListener(new ActionListener() {

			@Override // 저장하기를 눌렀을 때
			public void actionPerformed(ActionEvent e) {

				if (flag == 0) {
					mSave.setVisible(true);
					String data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을 얻는다.
					try {
						FileWriter fw = new FileWriter(data + ".txt"); // txt 파일로 저장한다.
						BufferedWriter bw = new BufferedWriter(fw);

						String str = ta.getText();
						for (int i = 0; i < str.length(); i++) {
							if (str.charAt(i) == '\n') {
								System.out.println("find");
								bw.newLine();
							}

							else {
								bw.write(str.charAt(i));
							} // Textarea에  bw객체에 있는 내용을 넣는다.
						}

						bw.close();
						String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고
						frame.setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다
					}

					catch (Exception e1) {
					}
					flag = 1;
				}

				else if (flag == 1) { 
					String data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을 얻는다.

					try {
						FileWriter fw = new FileWriter(data + ".txt"); // txt 파일로 저장한다.
						BufferedWriter bw = new BufferedWriter(fw);

						String str = ta.getText();
						for (int i = 0; i < str.length(); i++) {
							if (str.charAt(i) == '\n') {
								System.out.println("find");
								bw.newLine();
							} else
								bw.write(str.charAt(i)); // Textarea에 bw객체에 있는 내용을 넣는다.
						}
						bw.close();
					} catch (Exception e2) {

					}

				}

			}
		});

		saveasItem.addActionListener(new ActionListener() { // 다른이름으로 저장하기를 눌렀을 때

			@Override
			public void actionPerformed(ActionEvent e) { 
				mSave.setVisible(true);
				String data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을 얻는다.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt 파일로 저장한다.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = ta.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();

						} else
							bw.write(str.charAt(i)); // Textarea에 bw객체에 있는 내용을 넣는다.
					}

					bw.close();
					String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고,
					frame.setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다.
				} catch (Exception e1) {

				}

			}
		});

		closeItem.addActionListener(new ActionListener() { // 닫기를 눌렀을 때

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// frame 안에 있는 모든 내용들이 보이도록 frame사이즈를 조정한다.
		frame.pack();

		// frame이 보이도록 설정합니다.
		frame.setVisible(true);
	}

	static String content = "";
	static int flag = 0; // 저장 및 다른 이름으로 저장에 이용

	static int pos = 0;
	static int fromindex = 0;
}
