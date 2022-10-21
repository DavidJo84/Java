package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO_DTO.U_DAO;
import DAO_DTO.U_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3479132687255390618L;
	private JPanel contentPane;
	private JTextField textField_1 = new JTextField();// 아이디
	private JTextField textField = new JTextField();// 비번
	private final JButton btnNewButton = new JButton("로그인");
	U_DAO udao = new U_DAO();
	U_DTO udto = new U_DTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Login();
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblLogin = new JLabel("  환자관리 프로그램 v1.0");
		lblLogin.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(lblLogin, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));

		JLabel label = new JLabel("");
		panel.add(label);

		JLabel label_8 = new JLabel("");
		panel.add(label_8);

		JLabel label_7 = new JLabel("");
		panel.add(label_7);

		JLabel label_6 = new JLabel("");
		panel.add(label_6);

		JLabel label_5 = new JLabel("");
		panel.add(label_5);

		JLabel lblId = new JLabel("ID :");
		panel.add(lblId);

		panel.add(textField_1);
		textField_1.setColumns(20);

		JLabel label_1 = new JLabel("");
		panel.add(label_1);

		JLabel label_4 = new JLabel("");
		panel.add(label_4);

		JLabel lblPwd = new JLabel("PWD : ");
		panel.add(lblPwd);

		panel.add(textField);
		textField.setColumns(10);

		JLabel label_3 = new JLabel("");
		panel.add(label_3);

		JLabel label_2 = new JLabel("");
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnNewButton.addActionListener(this);

		panel_1.add(btnNewButton);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		Object temp = e.getSource();
		if (temp.equals(btnNewButton)) {
			udto = new U_DTO();
			udto.setUid(textField_1.getText());
			udto.setUpwd(textField.getText());
			udto = udao.chkLogin(udto);
			if (udto == null) {
				JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 확인해주세요.");
			} else {
				new MainWin(udto);
				this.setVisible(false);
			}
		}
	}

}
