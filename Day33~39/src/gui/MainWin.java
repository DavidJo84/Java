package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO_DTO.Pat_DAO;
import DAO_DTO.Pat_DTO;
import DAO_DTO.U_DTO;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class MainWin extends JFrame implements ActionListener, MouseListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8675085867570491262L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private int row;
	private Object value;
	private String selRadio;
	private int count;

	static JButton btnSer = new JButton("�˻�");
	JButton btnDel = new JButton("����");
	JButton btnMod = new JButton("����");
	JButton btnNewButton = new JButton("���ó��");
	JButton btnAdd = new JButton("���");
	JButton btnUseradd = new JButton("����ڰ���");
	JRadioButton radioButton = new JRadioButton("���");
	JRadioButton radioButton_1 = new JRadioButton("���");
	JRadioButton radioButton_2 = new JRadioButton("��ü");
	private JComboBox<String> comboBox;
	private ArrayList<String> selList;
	private JComboBox<String> comboBoxD;
//	= new JComboBox<String>(new String[] { "�Կ���", "�����"});

	String header[] = { "ȯ�ڹ�ȣ", "ȣ��", "ȯ�ڸ�", "����", "����", "�����", "���ܸ�", "���", "�Կ���", "�����" };
	DefaultTableModel model = new DefaultTableModel(header, 0); // header�߰�

	Pat_DAO pdao = new Pat_DAO();
	Pat_DTO pdto = new Pat_DTO();
	ButtonGroup group = new ButtonGroup(); // ���� ��ư �׷�
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	private final JButton btnExel = new JButton("������ ����");
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel label_3 = new JLabel("");
	private final JLabel label_4 = new JLabel("");
	private final JLabel label_5 = new JLabel("");
	private final JLabel label_10 = new JLabel("2 ��");
	private final JLabel label_11 = new JLabel("");
	private final JLabel label_12 = new JLabel("");
	private final JLabel label_17 = new JLabel("1 ��");
	private final JLabel label_18 = new JLabel("");
	private final JLabel label_19 = new JLabel("");
	private final JLabel label_20 = new JLabel("����");
	private final JLabel label_21 = new JLabel("�ѹ�2��");
	private final JLabel label_22 = new JLabel("�ѹ�1��");
	private final JLabel label_23 = new JLabel("��     ü");
	private final JLabel label_24 = new JLabel("ȯ����Ȳ");
	private final JLabel label_28 = new JLabel("");
	private final JLabel label_29 = new JLabel("");
	private final JLabel label = new JLabel("������ ");
	private final JLabel label_1 = new JLabel("������ ");
	private JLabel label_2 = new JLabel();// ���� �հ�
	private JLabel label_6 = new JLabel(); // 2�� ����
	private JLabel label_7 = new JLabel(); // 2�� �ѹ�2��
	private JLabel label_8 = new JLabel(); // 2�� �ѹ�1��
	private JLabel label_9 = new JLabel(); // 2�� ��
	private JLabel label_13 = new JLabel(); // 1�� ����
	private JLabel label_14 = new JLabel(); // 1�� �ѹ�2��
	private JLabel label_15 = new JLabel(); // 1�� �ѹ�1��
	private JLabel label_16 = new JLabel();// 1�� ��
	private JLabel label_35 = new JLabel();// �ѹ�2���հ�
	private JLabel label_25 = new JLabel();// �ѹ�1�� �հ�
	private JLabel label_26 = new JLabel();// ��ü�հ�
	private LineBorder border = new LineBorder(Color.black, 1);

	private final JLabel label_36 = new JLabel("");
	private final JLabel label_27 = new JLabel("��   ��");
	private final JLabel label_30 = new JLabel("");
	private final JLabel label_31 = new JLabel("");

	/**
	 * Create the frame.
	 */
	public MainWin(U_DTO udto) {
		super("ȯ�ڰ��� ���α׷� v1.0");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		panel.add(label_29);
		panel.add(label_28);
		panel.add(label_24);
		panel.add(label_23);
		panel.add(label_22);
		panel.add(label_21);
		panel.add(label_20);
		panel.add(label_19);
		panel.add(label_18);
		panel.add(label_17);
		panel.add(label_16);
		panel.add(label_15);
		panel.add(label_14);
		panel.add(label_13);
		panel.add(label_12);
		panel.add(label_11);
		panel.add(label_10);
		panel.add(label_9);
		panel.add(label_8);
		panel.add(label_7);
		panel.add(label_6);
		panel.add(label_36);
		panel.add(label_30);
		panel.add(label_27);
		panel.add(label_26);
		panel.add(label_25);
		panel.add(label_35);
		panel.add(label_2);
		panel.add(label_5);
		panel.add(label_31);
		panel.add(label_3);

		// ���� ��ư �׷�
		panel.add(radioButton_2);
		group.add(radioButton_2);

		panel.add(radioButton);
		group.add(radioButton);

		panel.add(radioButton_1);
		group.add(radioButton_1);// �׷쿡 �׷�ȭ��ų ��ư���� �߰�
		// ���� �׷쳢���� �׷��߿� 1���� ���õȴ�.
		radioButton_2.setSelected(true);
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "��ü��", "�ѹ�1��", "�ѹ�2��", "����" }));
//		comboBox.setEditable(true);//ȭ�鿡�� �޺��ڽ� ������ ������ �� �ְ� ��. 
		panel.add(comboBox);

		comboBoxD = new JComboBox<String>();
		panel.add(lblNewLabel);
		comboBoxD.setModel(new DefaultComboBoxModel<String>(new String[] { "�Կ���", "�����" }));
		panel.add(comboBoxD);

		panel.add(label);
		label.setHorizontalAlignment(JLabel.RIGHT);

		textField = new JTextField();// ������
		panel.add(textField);
		textField.setColumns(10);

		panel.add(label_1);
		label_1.setHorizontalAlignment(JLabel.RIGHT);

		Color color = new Color(222, 238, 18, 100);
		Color colorGreen = new Color(25, 137, 44);

		label_17.setHorizontalAlignment(JLabel.CENTER);// 1��
		label_17.setBorder(border);// 1��
		label_17.setOpaque(true);// 1��
		label_17.setBackground(color);// 1��
		label_10.setHorizontalAlignment(JLabel.CENTER);
		label_10.setBorder(border);
		label_10.setOpaque(true);
		label_10.setBackground(color);
		label_27.setHorizontalAlignment(JLabel.CENTER);
		label_27.setBorder(border);
		label_27.setOpaque(true);
		label_27.setBackground(color);
		label_20.setHorizontalAlignment(JLabel.CENTER);// ����
		label_20.setBorder(border);// ����
		label_20.setOpaque(true);// ����
		label_20.setBackground(color);// ����
		label_21.setHorizontalAlignment(JLabel.CENTER);// �ѹ�2��
		label_21.setBorder(border);// �ѹ�2��
		label_21.setOpaque(true);// �ѹ�2��
		label_21.setBackground(color);// �ѹ�2��
		label_22.setHorizontalAlignment(JLabel.CENTER);// �ѹ�1��
		label_22.setBorder(border);// �ѹ�1��
		label_22.setOpaque(true);// �ѹ�1��
		label_22.setBackground(color);// �ѹ�1��
		label_23.setHorizontalAlignment(JLabel.CENTER);// ��ü
		label_23.setBorder(border);// ��ü
		label_23.setOpaque(true);// ��ü
		label_23.setBackground(color);// ��ü
		label_24.setHorizontalAlignment(JLabel.CENTER);// ȯ����Ȳ
		label_24.setBorder(border);// ȯ����Ȳ
		label_24.setOpaque(true);// ȯ����Ȳ
		label_24.setBackground(color);// ȯ����Ȳ

		label_2.setHorizontalAlignment(JLabel.CENTER);// ���� �հ�
		label_2.setBorder(border);// ���� �հ�
		label_2.setOpaque(true);
		label_2.setForeground(Color.red);
		label_2.setBackground(Color.white);
		label_7.setHorizontalAlignment(JLabel.CENTER); // 2�� �ѹ�2��
		label_7.setBorder(border); // 2�� �ѹ�2��
		label_7.setOpaque(true); // 2�� �ѹ�2��
		label_7.setForeground(colorGreen);
		label_7.setBackground(Color.white); // 2�� �ѹ�2��
		label_6.setHorizontalAlignment(JLabel.CENTER); // 2�� ����
		label_6.setBorder(border); // 2�� ����
		label_6.setOpaque(true); // 2�� ����
		label_6.setForeground(Color.red);
		label_6.setBackground(Color.white); // 2�� ����
		label_8.setHorizontalAlignment(JLabel.CENTER); // 2�� �ѹ�1��
		label_8.setBorder(border); // 2�� �ѹ�1��
		label_8.setOpaque(true); // 2�� �ѹ�1��
		label_8.setBackground(Color.white); // 2�� �ѹ�1��
		label_8.setForeground(Color.blue); // 2�� �ѹ�1��
		label_9.setHorizontalAlignment(JLabel.CENTER); // 2�� ��
		label_9.setBorder(border); // 2�� ��
		label_9.setOpaque(true); // 2�� ��
		label_9.setBackground(Color.white); // 2�� ��
		label_13.setHorizontalAlignment(JLabel.CENTER);// 1�� ����
		label_13.setBorder(border);// 1�� ����
		label_13.setOpaque(true);// 1�� ����
		label_13.setForeground(Color.red);
		label_13.setBackground(Color.white);// 1�� ����
		label_14.setHorizontalAlignment(JLabel.CENTER); // 1�� �ѹ�2��
		label_14.setBorder(border); // 1�� �ѹ�2��
		label_14.setOpaque(true); // 1�� �ѹ�2��
		label_14.setForeground(colorGreen);
		label_14.setBackground(Color.white); // 1�� �ѹ�2��
		label_15.setHorizontalAlignment(JLabel.CENTER); // 1�� �ѹ�1��
		label_15.setBorder(border); // 1�� �ѹ�1��
		label_15.setOpaque(true);// 1�� �ѹ�1��
		label_15.setForeground(Color.blue);
		label_15.setBackground(Color.white); // 1�� �ѹ�1��
		label_16.setHorizontalAlignment(JLabel.CENTER);// 1�� ��
		label_16.setBorder(border);// 1�� ��
		label_16.setOpaque(true);// 1�� ��
		label_16.setBackground(Color.white);// 1�� ��
		label_35.setHorizontalAlignment(JLabel.CENTER);// �ѹ�2���հ�
		label_35.setBorder(border);// �ѹ�2���հ�
		label_35.setOpaque(true);// �ѹ�2���հ�
		label_35.setForeground(colorGreen);
		label_35.setBackground(Color.white);// �ѹ�2���հ�
		label_25.setHorizontalAlignment(JLabel.CENTER);// �ѹ�1�� �հ�
		label_25.setBorder(border);// �ѹ�1�� �հ�
		label_25.setOpaque(true);// �ѹ�1�� �հ�
		label_25.setForeground(Color.blue);
		label_25.setBackground(Color.white);// �ѹ�1�� �հ�
		label_26.setHorizontalAlignment(JLabel.CENTER);// ��ü�հ�
		label_26.setBorder(border);// ��ü�հ�
		label_26.setOpaque(true);// ��ü�հ�
		label_26.setBackground(Color.white);// ��ü�հ�

		textField_1 = new JTextField();// ������
		panel.add(textField_1);
		textField_1.setColumns(10);
		panel.add(btnSer);
		btnSer.addActionListener(this);

		panel.add(label_4);

		panel.add(btnExel);

		panel.add(btnUseradd);
		panel.add(btnAdd);
		panel.add(btnDel);
		panel.add(btnMod);
		panel.add(btnNewButton);
		if (udto.getUgrade().equals("���")) {
			btnAdd.addActionListener(this);
			btnDel.addActionListener(this);
			btnMod.addActionListener(this);
			btnUseradd.addActionListener(this);
			btnNewButton.addActionListener(this);
		} else if (udto.getUgrade().equals("������")) {
			btnAdd.addActionListener(this);
			btnMod.addActionListener(this);
			btnNewButton.addActionListener(this);
		}
		btnExel.addActionListener(this);
		radioButton.addItemListener(this);
		radioButton_1.addItemListener(this);
		radioButton_2.addItemListener(this);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		JScrollPane scrolledTable = new JScrollPane(table); // ��ũ�� �� �� �ֵ��� JScrollPane ����
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // �ʹ� �پ��־ �����ڸ� ���(padding)
		// ���̺� �÷� �ʺ� ����
		table.getColumn("ȯ�ڹ�ȣ").setPreferredWidth(25);
		table.getColumn("����").setPreferredWidth(2);
		table.getColumn("����").setPreferredWidth(2);
		table.getColumn("ȣ��").setPreferredWidth(10);
		table.getColumn("�����").setPreferredWidth(30);
		table.getColumn("ȯ�ڸ�").setPreferredWidth(25);
		table.getColumn("���ܸ�").setPreferredWidth(300);
		table.getColumn("�Կ���").setPreferredWidth(30);
		table.getColumn("�����").setPreferredWidth(30);
		table.setRowHeight(25);
		contentPane.add("Center", scrolledTable);
		table.addMouseListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if (temp.equals(btnSer)) {
			search();
		} else if (temp.equals(btnDel)) {
			int answer = JOptionPane.showConfirmDialog(null, "ȯ�������� �����Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.OK_CANCEL_OPTION);
			if (answer == 0) {
				pdao.deletePat(value);
				search();
			}
		} else if (temp.equals(btnMod)) {
//			Pat_DTO mod = pdao.SelectOne(value);
			new ModyPat(pdto);
		} else if (temp.equals(btnNewButton)) {
			int answer = JOptionPane.showConfirmDialog(null, "���ó���Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.OK_CANCEL_OPTION);
			if (answer == 0) {
				pdao.outPat(value);
				search();
			}
		} else if (temp.equals(btnAdd)) {
			new AddPat();

		} else if (temp.equals(btnUseradd)) {
			new UserMGR();
		} else if (temp.equals(btnExel)) {
			exelSave();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object temp = e.getSource();
		if (temp.equals(table)) {
			row = table.getSelectedRow();
			value = table.getValueAt(row, 0);
			String room = (String) table.getValueAt(row, 1);
			String name = (String) table.getValueAt(row, 2);
			String sex = (String) table.getValueAt(row, 3);
			int age = (int) table.getValueAt(row, 4);
			String depart = (String) table.getValueAt(row, 5);
			String disease = (String) table.getValueAt(row, 6);
			String memo = (String) table.getValueAt(row, 7);
			String indate = (String) table.getValueAt(row, 8);
			pdto.setNo((String) value);
			pdto.setRoom(room);
			pdto.setName(name);
			pdto.setSex(sex);
			pdto.setAge(age);
			pdto.setDepart(depart);
			pdto.setDisease(disease);
			pdto.setMemo(memo);
			pdto.setIndate(indate);

//			System.out.println(value);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable().equals(radioButton)) {
			selRadio = radioButton.getText();
		} else if (e.getItemSelectable().equals(radioButton_1)) {
			selRadio = radioButton_1.getText();
		} else {
			selRadio = null;
		}

	}

	public void exelSave() {
		String[] getColumn = new String[table.getColumnCount()];
		for (int i = 0; i < table.getColumnCount(); i++) {
			getColumn[i] = table.getColumnName(i);
		}

		Object[][] getData = new Object[table.getRowCount()][table.getColumnCount()];
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				getData[i][j] = table.getValueAt(i, j);
			}
		}
		try {
			WritableWorkbook workbook = Workbook
					.createWorkbook(new File("C:\\Users\\human\\Desktop\\ȯ�ڸ���Ʈ_" + count + ".xls"));// �������ϻ���(������ġ,���ϸ�)
			WritableSheet sheet = workbook.createSheet("ȯ�ڸ���Ʈ", 0);// ���� ��Ʈ ����(�̸�,���° ��Ʈ)
			WritableCellFormat col_form = new WritableCellFormat();// �÷�����,default ��Ʈ��
			WritableCellFormat data_form = new WritableCellFormat();// ������ ����,default ��Ʈ��
//		WritableCellFormat int_form = new WritableCellFormat(NumberFormat.INTEGER_FIELD);
			col_form.setBackground(Colour.GRAY_25);// �÷� ���� ����
			col_form.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < getColumn.length; i++) {// �÷��� �÷��� ����
				Label label = new Label(i, 0, getColumn[i], col_form);
				sheet.addCell(label);
			}
			for (int i = 0; i < getData.length; i++) {
				for (int j = 0; j < getData[i].length; j++) {
					Label data = new Label(j, i + 1, String.valueOf(getData[i][j]), data_form);
					sheet.addCell(data);
				}
			}

			workbook.write();
			workbook.close();
			count++;

		} catch (IOException | WriteException e1) {
			e1.printStackTrace();
		}
	}

	public void search() {
		int allSum = 0;
		int allSum_1 = 0;
		int allSum_2 = 0;
		int sum_ort1 = 0;
		int sum_ort1_1 = 0;
		int sum_ort1_2 = 0;
		int sum_ort2 = 0;
		int sum_ort2_1 = 0;
		int sum_ort2_2 = 0;
		int sum_med = 0;
		int sum_med_1 = 0;
		int sum_med_2 = 0;
		selList = new ArrayList<String>();
		String depart = comboBox.getSelectedItem().toString();
		String date = comboBoxD.getSelectedItem().toString();
		if (depart.equals("��ü��")) {
			depart = null;
		}
		selList.add(depart);
		selList.add(selRadio);
		selList.add(textField.getText());
		selList.add(textField_1.getText());
		selList.add(date);
//		for(String i : selList) {
//			System.out.println(i);
//		}

		ArrayList<Pat_DTO> pList = pdao.allSelect(selList);
		allSum = pList.size();
		for (Pat_DTO i : pList) {
			if (i.getDepart().equals("����")) {
				sum_med++;
				if (i.getRoom().charAt(0) == '1') {
					sum_med_1++;
					allSum_1++;
				} else if (i.getRoom().charAt(0) == '2') {
					sum_med_2++;
					allSum_2++;
				}
			} else if (i.getDepart().equals("�ѹ�1��")) {
				sum_ort1++;
				if (i.getRoom().charAt(0) == '1') {
					sum_ort1_1++;
					allSum_1++;
				} else if (i.getRoom().charAt(0) == '2') {
					sum_ort1_2++;
					allSum_2++;
				}
			} else if (i.getDepart().equals("�ѹ�2��")) {
				sum_ort2++;
				if (i.getRoom().charAt(0) == '1') {
					sum_ort2_1++;
					allSum_1++;
				} else if (i.getRoom().charAt(0) == '2') {
					sum_ort2_2++;
					allSum_2++;
				}
			}
		}
		label_26.setText(Integer.toString(allSum));
		label_2.setText(Integer.toString(sum_med));
		label_6.setText(Integer.toString(sum_med_2));// 2�� ����
		label_7.setText(Integer.toString(sum_ort2_2));// 2�� �ѹ�2��
		label_8.setText(Integer.toString(sum_ort1_2));// 2�� �ѹ�1��
		label_9.setText(Integer.toString(allSum_2)); // 2�� ��
		label_13.setText(Integer.toString(sum_med_1)); // 1�� ����
		label_14.setText(Integer.toString(sum_ort2_1)); // 1�� �ѹ�2��
		label_15.setText(Integer.toString(sum_ort1_1)); // 1�� �ѹ�1��
		label_16.setText(Integer.toString(allSum_1));// 1�� ��
		label_35.setText(Integer.toString(sum_ort2));// �ѹ�2���հ�
		label_25.setText(Integer.toString(sum_ort1));// �ѹ�1�� �հ�
		model.setNumRows(0);
		for (Pat_DTO i : pList) {
			if (i.getOutdate() == null) {
				model.addRow(new Object[] { i.getNo(), i.getRoom(), i.getName(), i.getSex(), i.getAge(), i.getDepart(),
						i.getDisease(), i.getMemo(), i.getIndate().substring(2, 10) });
			} else {
				model.addRow(new Object[] { i.getNo(), i.getRoom(), i.getName(), i.getSex(), i.getAge(), i.getDepart(),
						i.getDisease(), i.getMemo(), i.getIndate().substring(2, 10), i.getOutdate().substring(2, 10) });
			}
		}
	}
}
