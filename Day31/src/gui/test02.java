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
	
	// �гΰ�ü����
	JPanel centerP = new JPanel();
	JPanel centerP1 = new JPanel();
	JPanel centerP2 = new JPanel();
	JPanel centerP3 = new JPanel();
	JPanel centerP4 = new JPanel();
	JPanel southP = new JPanel();
	// �󺧰�ü ����
	JLabel titleLB = new JLabel("  ȸ������");
	JLabel idLB = new JLabel("�� �� ��");
	JLabel nameLB = new JLabel("��       ��");
	JLabel passLB = new JLabel("��й�ȣ");
	JLabel telLB = new JLabel("��ȭ��ȣ");
	// �ؽ�Ʈ�ʵ� ��ü����
	JTextField idInput = new JTextField(10);
	JTextField nameInput = new JTextField(10);
	JTextField pwdInput = new JTextField(10);
	JTextField telInput = new JTextField(10);
	// ��ư ��ü����
	JButton btn = new JButton("����");
	JButton close = new JButton("����");
	JButton reset = new JButton("�ʱ�ȭ");

	public test02() {// �α��� â ������
		// â �����
		this.setBounds(100, 300, 230, 250);// ������ ����(x��ǥ, y��ǥ ,�ʺ�, ����)

		// â�� ������ ��ġ
		this.add(centerP, "Center");
		this.add(titleLB, "North");
		this.add(southP, "South");

		// �г� ���̾ƿ� ����
		centerP.setLayout(new GridLayout(4, 1));
		centerP1.setLayout(new FlowLayout());
		centerP2.setLayout(new FlowLayout());
		centerP3.setLayout(new FlowLayout());
		centerP4.setLayout(new FlowLayout());

		// �����гο� �󺧰� �ؽ�Ʈ �ʵ� �߰�
		centerP1.add(idLB);
		centerP1.add(idInput);
		centerP2.add(nameLB);
		centerP2.add(nameInput);
		centerP3.add(passLB);
		centerP3.add(pwdInput);
		centerP4.add(telLB);
		centerP4.add(telInput);
		// ������ξȿ� 4���� �г� ��ġ
		centerP.add(centerP1);
		centerP.add(centerP2);
		centerP.add(centerP3);
		centerP.add(centerP4);
		// �Ʒ� �гο� ��ư ��ġ
		southP.add(btn);
		southP.add(reset);
		southP.add(close);

		// �׼Ǹ����� �������̽��� ����� ����ϱ� ����
		btn.addActionListener(this);
		reset.addActionListener(this);
		close.addActionListener(this);

//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// â�� ������ ���α׷� ����
	}

	@Override // �������̽� ��� �������̵�(�׼Ǹ�����)
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btn)) {// ���Թ�ư ������ Ÿ��Ʋ�� �ٲ�
			String id = idInput.getText();
			String name = nameInput.getText();
			String pass = pwdInput.getText();
			String tel = telInput.getText();
			
			//������ ��� ����
			M_DTO newDto = new M_DTO();
			
			newDto.setId(id);
			newDto.setName(name);
			newDto.setPass(pass);
			newDto.setTel(tel);
			newDao.insertMem(newDto);
			
			titleLB.setText(id + "/" + name + "/" + pass + "/" + tel);
		} else if (temp.equals(close)) {// �����ư ������ â����
			closeWin();
		} else if (temp.equals(reset)) {// �ʱ�ȭ ��ư ������ ���� ���
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
