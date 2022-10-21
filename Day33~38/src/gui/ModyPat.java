package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO_DTO.Pat_DAO;
import DAO_DTO.Pat_DTO;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ModyPat extends JFrame implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = -4856589804294284315L;
	private JPanel contentPane;
	private JTextField txtInputno;
	private JTextField txtInputroom;
	private JTextField txtInputname;
	private JTextField txtInputage;
	private JTextField txtInputdepart;
	private JTextField txtInputdisease;
	private JTextField txtInputindate;
	private JTextField txtInputmemo;
	private JTextField txtInputsex;
	JComboBox<String> comboBox = new JComboBox<String>();
	JButton btnMody = new JButton("수     정");
	Pat_DAO pdao = new Pat_DAO();
	Pat_DTO pdto;
	Pat_DTO mod;
	JOptionPane chk = new JOptionPane();

	/**
	 * Create the frame.
	 */
	public ModyPat(Pat_DTO pdto) {
		this.mod = pdto;
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 6, 0, 0));

		JLabel lblNo = new JLabel("환자번호");

		panel.add(lblNo);

		txtInputno = new JTextField();
		txtInputno.setText(pdto.getNo());
		panel.add(txtInputno);
		txtInputno.setColumns(10);

		JLabel lblRoom = new JLabel("입원호실");
		panel.add(lblRoom);

		txtInputroom = new JTextField();
		txtInputroom.setText(pdto.getRoom());
		panel.add(txtInputroom);
		txtInputroom.setColumns(10);

		JLabel lblName = new JLabel("환자명");
		panel.add(lblName);

		txtInputname = new JTextField();
		txtInputname.setText(pdto.getName());
		panel.add(txtInputname);
		txtInputname.setColumns(10);

		JLabel lblAge = new JLabel("나    이");
		panel.add(lblAge);

		txtInputage = new JTextField();
		String age1 = Integer.toString(pdto.getAge());
		txtInputage.setText(age1);
		panel.add(txtInputage);
		txtInputage.setColumns(10);

		JLabel lblSex = new JLabel("성   별");
		panel.add(lblSex);

		txtInputsex = new JTextField();
		txtInputsex.setText(pdto.getSex());
		panel.add(txtInputsex);
		txtInputsex.setColumns(10);

		JLabel lblDapert = new JLabel("진료과");
		panel.add(lblDapert);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "한방1과", "한방2과", "양방과" }));
		panel.add(comboBox);
		comboBox.setSelectedItem(pdto.getDepart());
//		txtInputdepart.setText(pdto.getDepart());

		JLabel lblDisease = new JLabel("질병명");
		panel.add(lblDisease);

		txtInputdisease = new JTextField();
		txtInputdisease.setText(pdto.getDisease());
		panel.add(txtInputdisease);
		txtInputdisease.setColumns(10);

		JLabel lblIndate = new JLabel("입원날짜");
		panel.add(lblIndate);

		txtInputindate = new JTextField();
		txtInputindate.setText(pdto.getIndate());
		panel.add(txtInputindate);
		txtInputindate.setColumns(10);

		JLabel lblMemo = new JLabel("비    고");
		panel.add(lblMemo);

		txtInputmemo = new JTextField();
		txtInputmemo.setText(pdto.getMemo());
		panel.add(txtInputmemo);
		txtInputmemo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel();
		panel.add(lblNewLabel_1);

		panel.add(btnMody);

		JLabel lblTitle = new JLabel("환자 정보 수정");
		contentPane.add(lblTitle, BorderLayout.NORTH);
		this.setVisible(true);
		btnMody.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btnMody)) {
			pdto = new Pat_DTO();
			String no = txtInputno.getText();
			String room = txtInputroom.getText();
			String name = txtInputname.getText();
			String sex = txtInputsex.getText();
			int age = Integer.parseInt(txtInputage.getText());
			String depart = txtInputdepart.getText();
			String disease = txtInputdisease.getText();
			String memo = txtInputmemo.getText();
			String indate = txtInputindate.getText();

			pdto.setNo(no);
			pdto.setRoom(room);
			pdto.setName(name);
			pdto.setSex(sex);
			pdto.setAge(age);
			pdto.setDepart(depart);
			pdto.setDisease(disease);
			pdto.setMemo(memo);
			pdto.setIndate(indate);

			if (mod.getNo().equals(pdto.getNo()) || pdao.chkNo(pdto.getNo())) {
				pdao.modyWord(pdto, mod);
				txtInputno.setText("");
				txtInputroom.setText("");
				txtInputname.setText("");
				txtInputsex.setText("");
				txtInputage.setText("");
				txtInputdepart.setText("");
				txtInputdisease.setText("");
				txtInputmemo.setText("");
				txtInputindate.setText("");
				MainWin.btnSer.doClick();
			} else {
				JOptionPane.showMessageDialog(null, "사용중인 환자번호입니다.");
			}
		}

		// TODO Auto-generated method stub

	}

}
