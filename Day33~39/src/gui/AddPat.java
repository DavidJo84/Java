package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO_DTO.Pat_DAO;
import DAO_DTO.Pat_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddPat extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8904694273832105450L;
	private JPanel contentPane;
	private JTextField txtInputno;
	private JTextField txtInputroom;
	private JTextField txtInputname;
	private JTextField txtInputage;
	private JTextField txtInputdisease;
	private JTextField txtInputindate;
	private JTextField txtInputmemo;
	private JTextField txtInputsex;
	JComboBox<String> comboBox = new JComboBox<String>();
	JButton btnAdd = new JButton("저     장");
	


	/**
	 * Create the frame.
	 */
	public AddPat() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.add(txtInputno);
		txtInputno.setColumns(10);
		
		JLabel lblRoom = new JLabel("입원호실");
		panel.add(lblRoom);
		
		txtInputroom = new JTextField();
		panel.add(txtInputroom);
		txtInputroom.setColumns(10);
		
		JLabel lblName = new JLabel("환자명");
		panel.add(lblName);
		
		txtInputname = new JTextField();
		panel.add(txtInputname);
		txtInputname.setColumns(10);
		
		JLabel lblAge = new JLabel("나    이");
		panel.add(lblAge);
		
		txtInputage = new JTextField();
		panel.add(txtInputage);
		txtInputage.setColumns(10);
		
		JLabel lblSex = new JLabel("성   별");
		panel.add(lblSex);
		
		txtInputsex = new JTextField();
		panel.add(txtInputsex);
		txtInputsex.setColumns(10);
		
		JLabel lblDapert = new JLabel("진료과");
		panel.add(lblDapert);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "한방1과", "한방2과", "양방과" }));
		panel.add(comboBox);
		
		JLabel lblDisease = new JLabel("진단명");
		panel.add(lblDisease);
		
		txtInputdisease = new JTextField();
		panel.add(txtInputdisease);
		txtInputdisease.setColumns(10);
		
		JLabel lblIndate = new JLabel("입원날짜");
		panel.add(lblIndate);
		
		txtInputindate = new JTextField();
		txtInputindate.setText("예)22-10-17");
		panel.add(txtInputindate);
		txtInputindate.setColumns(10);
		
		JLabel lblMemo = new JLabel("비    고");
		panel.add(lblMemo);
		
		txtInputmemo = new JTextField();
		panel.add(txtInputmemo);
		txtInputmemo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel();
		panel.add(lblNewLabel_1);
		
		
		panel.add(btnAdd);
		
		JLabel lblTitle = new JLabel("환자 정보 입력");
		contentPane.add(lblTitle, BorderLayout.NORTH);
		this.setVisible(true);
		btnAdd.addActionListener(this);
	}
	
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object temp = e.getSource();
		if (temp.equals(btnAdd)) {
			Pat_DAO pdao = new Pat_DAO();
			Pat_DTO pdto = new Pat_DTO();
			String no = txtInputno.getText();
			if(pdao.chkNo(no)) {
				
				String room = txtInputroom.getText();
				String name = txtInputname.getText();
				String sex = txtInputsex.getText();
				int age = Integer.parseInt(txtInputage.getText());
				String depart = comboBox.getSelectedItem().toString();
				String disease = txtInputdisease.getText();
				String memo = txtInputmemo.getText();
				String indate = txtInputindate.getText();
				
				textfildReset();
				
				pdto.setNo(no);
				pdto.setRoom(room);
				pdto.setName(name);
				pdto.setSex(sex);
				pdto.setAge(age);
				pdto.setDepart(depart);
				pdto.setDisease(disease);
				pdto.setMemo(memo);
				pdto.setIndate(indate);
				pdao.insertWord(pdto);
				MainWin.btnSer.doClick();
			}else if(pdao.chkOut(no)){
				String room = txtInputroom.getText();
				String depart = comboBox.getSelectedItem().toString();
				String disease = txtInputdisease.getText();
				String memo = txtInputmemo.getText();
				String indate = txtInputindate.getText();
				
				textfildReset();
				
				pdto.setNo(no);
				pdto.setRoom(room);
				pdto.setDepart(depart);
				pdto.setDisease(disease);
				pdto.setMemo(memo);
				pdto.setIndate(indate);
				pdao.insertWord(pdto);
				MainWin.btnSer.doClick();
				
			}else {
			
				JOptionPane.showMessageDialog( null, "사용중인 환자번호입니다." );
			}
		}
		

		// TODO Auto-generated method stub
		
	}
	
	public void textfildReset() {
		txtInputno.setText("");
		txtInputroom.setText("");
		txtInputname.setText("");
		txtInputsex.setText("");
		txtInputage.setText("");
		txtInputdisease.setText("");
		txtInputmemo.setText("");
		txtInputindate.setText("");
	}

}
