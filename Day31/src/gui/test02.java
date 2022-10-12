package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.M_DAO;
import dto.M_DTO;

public class test02 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -574322869717351717L;
	M_DAO newDao = new M_DAO();
	
	// 패널객체생성
	JPanel centerP = new JPanel();
	JPanel centerP1 = new JPanel();
	JPanel centerP2 = new JPanel();
	JPanel centerP3 = new JPanel();
	JPanel centerP4 = new JPanel();
	JPanel southP = new JPanel();
	// 라벨객체 생성
	JLabel titleLB = new JLabel("  회원가입");
	JLabel idLB = new JLabel("아 이 디");
	JLabel nameLB = new JLabel("이       름");
	JLabel passLB = new JLabel("비밀번호");
	JLabel telLB = new JLabel("전화번호");
	// 텍스트필드 객체생성
	JTextField idInput = new JTextField(10);
	JTextField nameInput = new JTextField(10);
	JTextField pwdInput = new JTextField(10);
	JTextField telInput = new JTextField(10);
	// 버튼 객체생성
	JButton btn = new JButton("가입");
	JButton close = new JButton("종료");
	JButton reset = new JButton("초기화");

	public test02() {// 로그인 창 만들어보기
		// 창 만들기
		this.setBounds(100, 300, 230, 250);// 사이즈 설정(x좌표, y좌표 ,너비, 높이)

		// 창에 프레임 배치
		this.add(centerP, "Center");
		this.add(titleLB, "North");
		this.add(southP, "South");

		// 패널 레이아웃 지정
		centerP.setLayout(new GridLayout(4, 1));
		centerP1.setLayout(new FlowLayout());
		centerP2.setLayout(new FlowLayout());
		centerP3.setLayout(new FlowLayout());
		centerP4.setLayout(new FlowLayout());

		// 센터패널에 라벨과 텍스트 필드 추가
		centerP1.add(idLB);
		centerP1.add(idInput);
		centerP2.add(nameLB);
		centerP2.add(nameInput);
		centerP3.add(passLB);
		centerP3.add(pwdInput);
		centerP4.add(telLB);
		centerP4.add(telInput);
		// 센터페널안에 4개의 패널 배치
		centerP.add(centerP1);
		centerP.add(centerP2);
		centerP.add(centerP3);
		centerP.add(centerP4);
		// 아래 패널에 버튼 배치
		southP.add(btn);
		southP.add(reset);
		southP.add(close);

		// 액션리스너 인터페이스의 기능을 사용하기 위함
		btn.addActionListener(this);
		reset.addActionListener(this);
		close.addActionListener(this);

//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 창을 닫으면 프로그램 종료
	}

	@Override // 인터페이스 기능 오버라이드(액션리스너)
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btn)) {// 가입버튼 누르면 타이틀이 바뀜
			String id = idInput.getText();
			String name = nameInput.getText();
			String pass = pwdInput.getText();
			String tel = telInput.getText();
			
			//내용을 디비에 저장
			M_DTO newDto = new M_DTO();
			
			newDto.setId(id);
			newDto.setName(name);
			newDto.setPass(pass);
			newDto.setTel(tel);
			newDao.insertMem(newDto);
			
			titleLB.setText(id + "/" + name + "/" + pass + "/" + tel);
		} else if (temp.equals(close)) {// 종료버튼 누르면 창닫힘
			closeWin();
		} else if (temp.equals(reset)) {// 초기화 버튼 누르면 내용 비움
			idInput.setText("");
			nameInput.setText("");
			pwdInput.setText("");
			telInput.setText("");
		}

	}

	public void viewWin() {
		this.setVisible(true);
	}

	public void closeWin() {
		this.setVisible(false);
	}

}
