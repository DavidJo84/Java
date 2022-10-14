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
	// �гΰ�ü����
	JPanel centerP = new JPanel();
	JPanel centerP1 = new JPanel();
	JPanel centerP2 = new JPanel();
	JPanel centerP3_1 = new JPanel();
	JPanel centerP3_2 = new JPanel();
	JPanel centerP3_3 = new JPanel();
	JPanel NorthP = new JPanel();
	JPanel SouthP = new JPanel();
	// �󺧰�ü ����
	JLabel titleLB = new JLabel("  �ܾ���� ���α׷� ver 1.0");
	JLabel word = new JLabel(" ���ܾ�");
	JLabel mean = new JLabel(" �ѱ۶�");
	JLabel memo = new JLabel(" ��    ��");
	JLabel imp = new JLabel(" �߿䵵");
	JLabel empty = new JLabel("");
	JLabel footLB = new JLabel("  ������ ���Ͽ�");
	// �ؽ�Ʈ�ʵ� ��ü����
	JTextField searchWord = new JTextField(10);
	JTextField wordIn = new JTextField(12);
	JTextField meanIn = new JTextField(12);
	JTextField memoIn = new JTextField(12);
	JTextField impIn = new JTextField(12);

	// ��ư ��ü����
	JButton add = new JButton("�ܾ��߰�");
	JButton del = new JButton("�ܾ����");
	JButton show = new JButton("�ܾ��");
	JButton search = new JButton("search");
	JButton save = new JButton("�����ϱ�");
	List wordList = new List(9);
	JTextArea wordInfo = new JTextArea(9, 14);
	Word_DAO wdao = new Word_DAO();
	Word_DTO wdto = new Word_DTO();

	public WordMGR() {// �α��� â ������
		// â �����
		this.setBounds(100, 300, 300, 350);// ������ ����(x��ǥ, y��ǥ ,�ʺ�, ����)

		// â�� ������ ��ġ
		this.add(NorthP, "North");
		this.add(centerP, "Center");
		this.add(SouthP, "South");

		// �г� ���̾ƿ� ����
		centerP.setLayout(new FlowLayout(FlowLayout.RIGHT));
		NorthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		SouthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerP3_1.setLayout(new GridLayout(5, 2));

		titleLB.setFont(new Font(null, Font.BOLD, 15));
		footLB.setFont(new Font(null, Font.BOLD, 15));
		NorthP.add(titleLB);
		SouthP.add(footLB);
		// ������ξȿ� 3���� �г� ��ġ
		centerP.add(centerP1);
		centerP.add(centerP2);
		// �����г� 1�� ��ư�� �ؽ�Ʈ �ʵ� �߰�
		centerP1.add(searchWord);
		centerP1.add(search);
		// �����г� 2�� ��ư ��ġ
		centerP2.add(add);
		centerP2.add(del);
		centerP2.add(show);
		// �����г� 3_1
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
		// �����г� 3_2

		centerP3_2.setLayout(new BorderLayout());
		centerP3_2.add(wordList, "West");
		centerP3_2.add(wordInfo, "East");

		// �׼Ǹ����� �������̽��� ����� ����ϱ� ����
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
			wordInfo.append("���ܾ�: " + wdto.getWord() + "\n");
			wordInfo.append("�ѱ۶�: " + wdto.getMean() + "\n");
			wordInfo.append("�߿䵵: " + wdto.getImp() + "\n");
			wordInfo.append("��    ��: " + wdto.getMemo() + "\n");
		}

	}
}
