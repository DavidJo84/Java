package gui;

import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test01 extends JFrame implements ActionListener {
	JLabel titleLB = new JLabel("휴먼프로그램");
	JButton btn = new JButton("Login");
	JButton close = new JButton("Exit");
	JButton join = new JButton("회원가입");
//	JLabel mainLB = new JLabel("아이디");
	JLabel idLB = new JLabel("아이디");
	JLabel passLB = new JLabel("비    번");
	JTextField idInput = new JTextField(18);
	JTextField pwdInput = new JTextField(18);
//	JTextArea inputBody = new JTextArea(20, 10);
	JPanel centerP = new JPanel();
	JPanel centerPN = new JPanel();
	JPanel centerPS = new JPanel();
	JPanel southP = new JPanel();

	public test01() {
		System.out.println("프로그램 시작");
		this.setBounds(100, 300, 300, 150);// 사이즈 설정(x좌표, y좌표 ,너비, 높이)
//		idInput.setBackground(Color.blue);
//		btn.setBackground(Color.red);
//		titleLB.setBackground(Color.red);
//		inputBody.setBackground(Color.orange);

		// this에 컴포넌트를 배치, 기본은 보더레이아웃
//		this.add(titleLB, "North");
//		this.add(btn, "East");
//		this.add(mainLB, "West");
//		this.add(idInput, "Center");
//		this.add(inputBody, "South");

		// flowLayout
//		this.setLayout(new FlowLayout());
//		this.add(titleLB);
//		this.add(btn);
//		this.add(mainLB);
//		this.add(inputBody);
//		this.add(idInput);

		// 로그인 창 만들어보기
//		centerP.setBackground(Color.cyan);
		centerPN.setBackground(Color.green);
		centerPS.setBackground(Color.yellow);

		centerP.setLayout(new GridLayout(2, 1));
		centerPN.setLayout(new FlowLayout());
		centerPS.setLayout(new FlowLayout());
		centerPN.add(idLB);
		centerPN.add(idInput);
		centerPS.add(passLB);
		centerPS.add(pwdInput);
		centerP.add(centerPN);
		centerP.add(centerPS);
		southP.add(btn);
		southP.add(close);
		southP.add(join);

		btn.addActionListener(this);
		close.addActionListener(this);
		join.addActionListener(this);

		this.add(centerP, "Center");
		this.add(titleLB, "North");
//		this.add(btn, "South");
		this.add(southP, "South");

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btn)) {
			String id = idInput.getText();
			System.out.println(id);
		} else if (temp.equals(close)) {
			System.out.println("종료");
			System.exit(0);
		} else if(temp.equals(join)) {
			new test02();
		}

	}

}
