package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test02 extends JFrame implements ActionListener {
	JLabel titleLB = new JLabel("  ȸ������");
	JButton btn = new JButton("����");
	JButton close = new JButton("����");
	JButton reset = new JButton("�ʱ�ȭ");
	JLabel idLB = new JLabel("�� �� ��");
	JLabel nameLB = new JLabel("��       ��");
	JLabel passLB = new JLabel("��й�ȣ");
	JLabel telLB = new JLabel("��ȭ��ȣ");
	JTextField idInput = new JTextField(10);
	JTextField nameInput = new JTextField(10);
	JTextField pwdInput = new JTextField(10);
	JTextField telInput = new JTextField(10);
	JPanel centerP = new JPanel();
	JPanel centerP1 = new JPanel();
	JPanel centerP2 = new JPanel();
	JPanel centerP3 = new JPanel();
	JPanel centerP4 = new JPanel();
	JPanel southP = new JPanel();

	public test02() {
		this.setBounds(100, 300, 230, 250);// ������ ����(x��ǥ, y��ǥ ,�ʺ�, ����)
		// �α��� â ������
		centerP.setLayout(new GridLayout(4, 1));
		centerP1.setLayout(new FlowLayout());
		centerP2.setLayout(new FlowLayout());
		centerP3.setLayout(new FlowLayout());
		centerP4.setLayout(new FlowLayout());
		centerP1.add(idLB);
		centerP1.add(idInput);
		centerP2.add(nameLB);
		centerP2.add(nameInput);
		centerP3.add(passLB);
		centerP3.add(pwdInput);
		centerP4.add(telLB);
		centerP4.add(telInput);
		centerP.add(centerP1);
		centerP.add(centerP2);
		centerP.add(centerP3);
		centerP.add(centerP4);
		southP.add(btn);
		southP.add(reset);
		southP.add(close);
		
		//�������̽��� ����� ����ϱ� ����
		btn.addActionListener(this);
		reset.addActionListener(this);
		close.addActionListener(this);
		
		this.add(centerP, "Center");
		this.add(titleLB, "North");
		this.add(southP, "South");

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//â�� ������ ���α׷� ����
	}

	@Override//�������̽� ��� �������̵�(�׼Ǹ�����)
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btn)) {//���Թ�ư ������ Ÿ��Ʋ�� �ٲ�
			String a = "���̵�/�̸�/���/����";
			titleLB.setText(a);
		} else if (temp.equals(close)) {//�����ư ������ ���α׷� ����
			System.exit(0);
		} else if (temp.equals(reset)) {//�ʱ�ȭ ��ư ������ ���� ���
			idInput.setText("");
			nameInput.setText("");
			pwdInput.setText("");
			telInput.setText("");
		}

	}

}
