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
	/**
	 * 
	 */
	private static final long serialVersionUID = 7024040638547273794L;
	test02 newTest02 = new test02();
	JLabel titleLB = new JLabel("�޸����α׷�");
	JButton btn = new JButton("Login");
	JButton close = new JButton("Exit");
	JButton join = new JButton("ȸ������");
	JLabel idLB = new JLabel("���̵�");
	JLabel passLB = new JLabel("��    ��");
	JTextField idInput = new JTextField(18);
	JTextField pwdInput = new JTextField(18);
	JPanel centerP = new JPanel();
	JPanel centerPN = new JPanel();
	JPanel centerPS = new JPanel();
	JPanel southP = new JPanel();

	public test01() {
		System.out.println("���α׷� ����");
		this.setBounds(100, 300, 300, 150);// ������ ����(x��ǥ, y��ǥ ,�ʺ�, ����)
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
			System.out.println("����");
			System.exit(0);
		} else if (temp.equals(join)) {
			//��ü�� ���� �������� �ʰ� �޼���� â�� ������.
			newTest02.viewWin();
		}

	}

}
