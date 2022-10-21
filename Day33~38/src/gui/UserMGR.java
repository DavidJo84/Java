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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO_DTO.U_DAO;
import DAO_DTO.U_DTO;

public class UserMGR extends JFrame implements ActionListener, ItemListener {
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
	JLabel titleLB = new JLabel("  사용자 관리");
	JLabel uid = new JLabel("아  이  디");
	JLabel uname = new JLabel("이         름");
	JLabel upwd = new JLabel("비밀번호");
	JLabel upart = new JLabel("근무부서");
	JLabel lblUgrade = new JLabel("등         급");
	JLabel empty = new JLabel("");
	// 텍스트필드 객체생성
	JTextField searchUser = new JTextField(10);
	JTextField uidIn = new JTextField(12);
	JTextField unameIn = new JTextField(12);
	JTextField upwdIn = new JTextField(12);
	JTextField upartIn = new JTextField(12);
	JComboBox<String> comboBox;

	// 버튼 객체생성
	JButton add = new JButton("사용자추가");
	JButton del = new JButton("사용자삭제");
	JButton show = new JButton("사용자보기");
	JButton search = new JButton("검    색");
	JButton save = new JButton("저장하기");
	List userList = new List(9);
	JTextArea userInfo = new JTextArea(9, 14);
	U_DAO udao = new U_DAO();
	U_DTO udto = new U_DTO();
	String selUser;

	public UserMGR() {// 로그인 창 만들어보기
		// 창 만들기
		this.setBounds(100, 300, 330, 350);// 사이즈 설정(x좌표, y좌표 ,너비, 높이)

		// 창에 프레임 배치
		this.add(NorthP, "North");
		this.add(centerP, "Center");
		this.add(SouthP, "South");

		// 패널 레이아웃 지정
		centerP.setLayout(new FlowLayout(FlowLayout.RIGHT));
		NorthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		SouthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerP3_1.setLayout(new GridLayout(6, 2));

		titleLB.setFont(new Font(null, Font.BOLD, 15));
		NorthP.add(titleLB);
		// 센터페널안에 3개의 패널 배치
		centerP.add(centerP1);
		centerP.add(centerP2);
		// 센터패널 1에 버튼과 텍스트 필드 추가
		centerP1.add(searchUser);
		centerP1.add(search);
		// 센터패널 2에 버튼 배치
		centerP2.add(add);
		centerP2.add(del);
		centerP2.add(show);
		// 센터패널 3_1
		centerP3_1.add(uid);
		centerP3_1.add(uidIn);
		centerP3_1.add(uname);
		centerP3_1.add(unameIn);
		centerP3_1.add(upart);
		centerP3_1.add(upartIn);
		centerP3_1.add(upwd);
		centerP3_1.add(upwdIn);
		centerP3_1.add(lblUgrade);
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "운영자", "관리자", "사용자 " }));
		comboBox.setEditable(true);

		centerP3_1.add(comboBox);
		centerP3_1.add(empty);
		centerP3_1.add(save);
		// 센터패널 3_2

		centerP3_2.setLayout(new BorderLayout());
		centerP3_2.add(userList, "West");
		centerP3_2.add(userInfo, "East");

		// 액션리스너 인터페이스의 기능을 사용하기 위함
		add.addActionListener(this);
		del.addActionListener(this);
		show.addActionListener(this);
		search.addActionListener(this);
		save.addActionListener(this);
		userList.addItemListener(this);

		this.setResizable(false);
		this.setVisible(true);
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
			selUser = null;
		} else if (temp.equals(del)) {
			if (selUser == null) {
				JOptionPane.showMessageDialog(null, "삭제할 아이디를 선택하세요.");
			} else {
				int answer = JOptionPane.showConfirmDialog(null, selUser + "를 삭제하시겠습니까?", "확인",
						JOptionPane.OK_CANCEL_OPTION);
				if (answer == 0) {
					udao.deleteUser(selUser);
				}
			}

		} else if (temp.equals(show)) {
			centerP.add(centerP3_2);

			ArrayList<U_DTO> uList = udao.allSelect();
			userList.removeAll();
			userInfo.setText("");
			for (U_DTO i : uList) {
				userList.add(i.getUid());
			}
			centerP3_1.setVisible(false);
			centerP3_3.setVisible(false);
			centerP3_2.setVisible(true);

			this.setVisible(true);

		} else if (temp.equals(search)) {
			centerP.add(centerP3_2);
			String word = searchUser.getText();
			System.out.println(word);
			searchUser.setText("");
			if (word.equals("")) {
				JOptionPane.showMessageDialog(null, "검색할 아이디나 이름을 입력해주세요.");
			} else {
				ArrayList<U_DTO> uList = udao.search(word);
				userList.removeAll();
				if (uList.size() == 0) {
					JOptionPane.showMessageDialog(null, "아이디나 이름이 없습니다.");
				} else {
					userInfo.setText("");
					for (U_DTO i : uList) {
						userList.add(i.getUid());
					}
					centerP3_1.setVisible(false);
					centerP3_3.setVisible(false);
					centerP3_2.setVisible(true);
					this.setVisible(true);
				}
			}
			selUser = null;

		} else if (temp.equals(save)) {
			String uid = uidIn.getText();
			if (!udao.chkUser(uid)) {
				String uname = unameIn.getText();
				String upwd = upwdIn.getText();
				String upart = upartIn.getText();
				Object a = comboBox.getSelectedItem();
				String ugrade = (String) a;
				uidIn.setText("");
				unameIn.setText("");
				upwdIn.setText("");
				upartIn.setText("");
//			comboBox.setSelectedItem(comboBox.getItemAt(0));//첫 인덱스로 값을 셋팅해줌
				udto.setUid(uid);
				udto.setUname(uname);
				udto.setUpwd(upwd);
				udto.setUpart(upart);
				udto.setUgrade(ugrade);
				udao.insertUser(udto);
			} else {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(userList)) {
			selUser = userList.getSelectedItem();
			U_DTO udto = udao.SelectOne(selUser);

			userInfo.setText("");
			userInfo.append("아이디: " + udto.getUid() + "\n");
			userInfo.append("이     름: " + udto.getUname() + "\n");
			userInfo.append("비밀번호: " + udto.getUpwd() + "\n");
			userInfo.append("근무부서: " + udto.getUpart() + "\n");
			userInfo.append("등     급: " + udto.getUgrade() + "\n");

		}

	}
}
