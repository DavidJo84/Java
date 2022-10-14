package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO_DTO.Word_DAO;
import DAO_DTO.Word_DTO;

public class WordMGR extends JFrame implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8432360310016535040L;
	// 패널객체생성
	JPanel centerP = new JPanel();
	JPanel centerP1 = new JPanel();
	JPanel centerP2 = new JPanel();
	JPanel centerP3_1 = new JPanel();
	JPanel centerP3_2 = new JPanel();
	JPanel centerP3_3 = new JPanel();
	JPanel NorthP = new JPanel();
	JPanel SouthP = new JPanel();
	// 라벨객체 생성
	JLabel titleLB = new JLabel("  단어관리 프로그램 ver 1.0");
	JLabel word = new JLabel(" 영단어");
	JLabel mean = new JLabel(" 한글뜻");
	JLabel memo = new JLabel(" 메    모");
	JLabel imp = new JLabel(" 중요도");
	JLabel empty = new JLabel("");
	JLabel footLB = new JLabel("  개발자 조하영");
	// 텍스트필드 객체생성
	JTextField searchWord = new JTextField(10);
	JTextField wordIn = new JTextField(12);
	JTextField meanIn = new JTextField(12);
	JTextField memoIn = new JTextField(12);
	JTextField impIn = new JTextField(12);

	// 버튼 객체생성
	JButton add = new JButton("단어추가");
	JButton del = new JButton("단어삭제");
	JButton show = new JButton("단어보기");
	JButton search = new JButton("search");
	JButton save = new JButton("저장하기");
	List wordList = new List(9);
	JTextArea wordInfo = new JTextArea(9, 14);
	Word_DAO wdao = new Word_DAO();
	Word_DTO wdto = new Word_DTO();

	public WordMGR() {// 로그인 창 만들어보기
		// 창 만들기
		this.setBounds(100, 300, 300, 350);// 사이즈 설정(x좌표, y좌표 ,너비, 높이)

		// 창에 프레임 배치
		this.add(NorthP, "North");
		this.add(centerP, "Center");
		this.add(SouthP, "South");

		// 패널 레이아웃 지정
		centerP.setLayout(new FlowLayout(FlowLayout.RIGHT));
		NorthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		SouthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerP3_1.setLayout(new GridLayout(5, 2));

		titleLB.setFont(new Font(null, Font.BOLD, 15));
		footLB.setFont(new Font(null, Font.BOLD, 15));
		NorthP.add(titleLB);
		SouthP.add(footLB);
		// 센터페널안에 3개의 패널 배치
		centerP.add(centerP1);
		centerP.add(centerP2);
		// 센터패널 1에 버튼과 텍스트 필드 추가
		centerP1.add(searchWord);
		centerP1.add(search);
		// 센터패널 2에 버튼 배치
		centerP2.add(add);
		centerP2.add(del);
		centerP2.add(show);
		// 센터패널 3_1
		centerP3_1.add(word);
		centerP3_1.add(wordIn);
		centerP3_1.add(mean);
		centerP3_1.add(meanIn);
		centerP3_1.add(imp);
		centerP3_1.add(impIn);
		centerP3_1.add(memo);
		centerP3_1.add(memoIn);
		centerP3_1.add(empty);
		centerP3_1.add(save);
		// 센터패널 3_2

		centerP3_2.setLayout(new BorderLayout());
		centerP3_2.add(wordList, "West");
		centerP3_2.add(wordInfo, "East");

		// 액션리스너 인터페이스의 기능을 사용하기 위함
		add.addActionListener(this);
		del.addActionListener(this);
		show.addActionListener(this);
		search.addActionListener(this);
		save.addActionListener(this);
		wordList.addItemListener(this);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(add)) {
			centerP.add(centerP3_1);
			centerP3_2.setVisible(false);
			centerP3_3.setVisible(false);
			centerP3_1.setVisible(true);
			this.setVisible(true);
		} else if (temp.equals(del)) {

		} else if (temp.equals(show)) {
			centerP.add(centerP3_2);

			ArrayList<Word_DTO> wList = wdao.allSelect();
			wordList.removeAll();
			for (Word_DTO i : wList) {
				wordList.add(i.getWord());
			}
			centerP3_1.setVisible(false);
			centerP3_3.setVisible(false);
			centerP3_2.setVisible(true);

			this.setVisible(true);

		} else if (temp.equals(search)) {
			centerP.add(centerP3_2);
			String word = searchWord.getText();
			searchWord.setText("");
			
			ArrayList<Word_DTO> wList = wdao.search(word);
			wordList.removeAll();
			for (Word_DTO i : wList) {
				wordList.add(i.getWord());
			}
			centerP3_1.setVisible(false);
			centerP3_3.setVisible(false);
			centerP3_2.setVisible(true);
			
		} else if (temp.equals(save)) {
			String word = wordIn.getText();
			String mean = meanIn.getText();
			String memo = memoIn.getText();
			String imp = impIn.getText();
			wordIn.setText("");
			meanIn.setText("");
			memoIn.setText("");
			impIn.setText("");
			wdto.setWord(word);
			wdto.setMean(mean);
			wdto.setMemo(memo);
			wdto.setImp(imp);

			wdao.insertWord(wdto);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(wordList)) {
			String selWord = wordList.getSelectedItem();
			Word_DTO wdto = wdao.SelectOne(selWord);

			wordInfo.setText("");
			wordInfo.append("영단어: " + wdto.getWord() + "\n");
			wordInfo.append("한글뜻: " + wdto.getMean() + "\n");
			wordInfo.append("중요도: " + wdto.getImp() + "\n");
			wordInfo.append("메    모: " + wdto.getMemo() + "\n");
		}

	}
}
