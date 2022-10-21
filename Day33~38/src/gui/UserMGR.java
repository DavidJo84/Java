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
	JLabel titleLB = new JLabel("  ����� ����");
	JLabel uid = new JLabel("��  ��  ��");
	JLabel uname = new JLabel("��         ��");
	JLabel upwd = new JLabel("��й�ȣ");
	JLabel upart = new JLabel("�ٹ��μ�");
	JLabel lblUgrade = new JLabel("��         ��");
	JLabel empty = new JLabel("");
	// �ؽ�Ʈ�ʵ� ��ü����
	JTextField searchUser = new JTextField(10);
	JTextField uidIn = new JTextField(12);
	JTextField unameIn = new JTextField(12);
	JTextField upwdIn = new JTextField(12);
	JTextField upartIn = new JTextField(12);
	JComboBox<String> comboBox;

	// ��ư ��ü����
	JButton add = new JButton("������߰�");
	JButton del = new JButton("����ڻ���");
	JButton show = new JButton("����ں���");
	JButton search = new JButton("��    ��");
	JButton save = new JButton("�����ϱ�");
	List userList = new List(9);
	JTextArea userInfo = new JTextArea(9, 14);
	U_DAO udao = new U_DAO();
	U_DTO udto = new U_DTO();
	String selUser;

	public UserMGR() {// �α��� â ������
		// â �����
		this.setBounds(100, 300, 330, 350);// ������ ����(x��ǥ, y��ǥ ,�ʺ�, ����)

		// â�� ������ ��ġ
		this.add(NorthP, "North");
		this.add(centerP, "Center");
		this.add(SouthP, "South");

		// �г� ���̾ƿ� ����
		centerP.setLayout(new FlowLayout(FlowLayout.RIGHT));
		NorthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		SouthP.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerP3_1.setLayout(new GridLayout(6, 2));

		titleLB.setFont(new Font(null, Font.BOLD, 15));
		NorthP.add(titleLB);
		// ������ξȿ� 3���� �г� ��ġ
		centerP.add(centerP1);
		centerP.add(centerP2);
		// �����г� 1�� ��ư�� �ؽ�Ʈ �ʵ� �߰�
		centerP1.add(searchUser);
		centerP1.add(search);
		// �����г� 2�� ��ư ��ġ
		centerP2.add(add);
		centerP2.add(del);
		centerP2.add(show);
		// �����г� 3_1
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
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "���", "������", "����� " }));
		comboBox.setEditable(true);

		centerP3_1.add(comboBox);
		centerP3_1.add(empty);
		centerP3_1.add(save);
		// �����г� 3_2

		centerP3_2.setLayout(new BorderLayout());
		centerP3_2.add(userList, "West");
		centerP3_2.add(userInfo, "East");

		// �׼Ǹ����� �������̽��� ����� ����ϱ� ����
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
				JOptionPane.showMessageDialog(null, "������ ���̵� �����ϼ���.");
			} else {
				int answer = JOptionPane.showConfirmDialog(null, selUser + "�� �����Ͻðڽ��ϱ�?", "Ȯ��",
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
				JOptionPane.showMessageDialog(null, "�˻��� ���̵� �̸��� �Է����ּ���.");
			} else {
				ArrayList<U_DTO> uList = udao.search(word);
				userList.removeAll();
				if (uList.size() == 0) {
					JOptionPane.showMessageDialog(null, "���̵� �̸��� �����ϴ�.");
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
//			comboBox.setSelectedItem(comboBox.getItemAt(0));//ù �ε����� ���� ��������
				udto.setUid(uid);
				udto.setUname(uname);
				udto.setUpwd(upwd);
				udto.setUpart(upart);
				udto.setUgrade(ugrade);
				udao.insertUser(udto);
			} else {
				JOptionPane.showMessageDialog(null, "�̹� ������� ���̵��Դϴ�.");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(userList)) {
			selUser = userList.getSelectedItem();
			U_DTO udto = udao.SelectOne(selUser);

			userInfo.setText("");
			userInfo.append("���̵�: " + udto.getUid() + "\n");
			userInfo.append("��     ��: " + udto.getUname() + "\n");
			userInfo.append("��й�ȣ: " + udto.getUpwd() + "\n");
			userInfo.append("�ٹ��μ�: " + udto.getUpart() + "\n");
			userInfo.append("��     ��: " + udto.getUgrade() + "\n");

		}

	}
}
