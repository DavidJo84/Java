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

	static JButton btnSer = new JButton("검색");
	JButton btnDel = new JButton("삭제");
	JButton btnMod = new JButton("수정");
	JButton btnNewButton = new JButton("퇴원처리");
	JButton btnAdd = new JButton("등록");
	JButton btnUseradd = new JButton("사용자관리");
	JRadioButton radioButton = new JRadioButton("재원");
	JRadioButton radioButton_1 = new JRadioButton("퇴원");
	JRadioButton radioButton_2 = new JRadioButton("전체");
	private JComboBox<String> comboBox;
	private ArrayList<String> selList;
	private JComboBox<String> comboBoxD;
//	= new JComboBox<String>(new String[] { "입원일", "퇴원일"});

	String header[] = { "환자번호", "호실", "환자명", "성별", "나이", "진료과", "진단명", "비고", "입원일", "퇴원일" };
	DefaultTableModel model = new DefaultTableModel(header, 0); // header추가

	Pat_DAO pdao = new Pat_DAO();
	Pat_DTO pdto = new Pat_DTO();
	ButtonGroup group = new ButtonGroup(); // 라디오 버튼 그룹
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	private final JButton btnExel = new JButton("엑셀로 저장");
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel label_3 = new JLabel("");
	private final JLabel label_4 = new JLabel("");
	private final JLabel label_5 = new JLabel("");
	private final JLabel label_10 = new JLabel("2 층");
	private final JLabel label_11 = new JLabel("");
	private final JLabel label_12 = new JLabel("");
	private final JLabel label_17 = new JLabel("1 층");
	private final JLabel label_18 = new JLabel("");
	private final JLabel label_19 = new JLabel("");
	private final JLabel label_20 = new JLabel("양방과");
	private final JLabel label_21 = new JLabel("한방2과");
	private final JLabel label_22 = new JLabel("한방1과");
	private final JLabel label_23 = new JLabel("전     체");
	private final JLabel label_24 = new JLabel("환자현황");
	private final JLabel label_28 = new JLabel("");
	private final JLabel label_29 = new JLabel("");
	private final JLabel label = new JLabel("시작일 ");
	private final JLabel label_1 = new JLabel("종료일 ");
	private JLabel label_2 = new JLabel();// 양방과 합계
	private JLabel label_6 = new JLabel(); // 2층 양방과
	private JLabel label_7 = new JLabel(); // 2층 한방2과
	private JLabel label_8 = new JLabel(); // 2층 한방1과
	private JLabel label_9 = new JLabel(); // 2층 합
	private JLabel label_13 = new JLabel(); // 1층 양방과
	private JLabel label_14 = new JLabel(); // 1층 한방2과
	private JLabel label_15 = new JLabel(); // 1층 한방1과
	private JLabel label_16 = new JLabel();// 1층 합
	private JLabel label_35 = new JLabel();// 한방2과합계
	private JLabel label_25 = new JLabel();// 한방1과 합계
	private JLabel label_26 = new JLabel();// 전체합계
	private LineBorder border = new LineBorder(Color.black, 1);

	private final JLabel label_36 = new JLabel("");
	private final JLabel label_27 = new JLabel("합   계");
	private final JLabel label_30 = new JLabel("");
	private final JLabel label_31 = new JLabel("");

	/**
	 * Create the frame.
	 */
	public MainWin(U_DTO udto) {
		super("환자관리 프로그램 v1.0");

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

		// 라디오 버튼 그룹
		panel.add(radioButton_2);
		group.add(radioButton_2);

		panel.add(radioButton);
		group.add(radioButton);

		panel.add(radioButton_1);
		group.add(radioButton_1);// 그룹에 그룹화시킬 버튼들을 추가
		// 같은 그룹끼리는 그룹중에 1개만 선택된다.
		radioButton_2.setSelected(true);
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "전체과", "한방1과", "한방2과", "양방과" }));
//		comboBox.setEditable(true);//화면에서 콤보박스 내용을 수정할 수 있게 함. 
		panel.add(comboBox);

		comboBoxD = new JComboBox<String>();
		panel.add(lblNewLabel);
		comboBoxD.setModel(new DefaultComboBoxModel<String>(new String[] { "입원일", "퇴원일" }));
		panel.add(comboBoxD);

		panel.add(label);
		label.setHorizontalAlignment(JLabel.RIGHT);

		textField = new JTextField();// 시작일
		panel.add(textField);
		textField.setColumns(10);

		panel.add(label_1);
		label_1.setHorizontalAlignment(JLabel.RIGHT);

		Color color = new Color(222, 238, 18, 100);
		Color colorGreen = new Color(25, 137, 44);

		label_17.setHorizontalAlignment(JLabel.CENTER);// 1층
		label_17.setBorder(border);// 1층
		label_17.setOpaque(true);// 1층
		label_17.setBackground(color);// 1층
		label_10.setHorizontalAlignment(JLabel.CENTER);
		label_10.setBorder(border);
		label_10.setOpaque(true);
		label_10.setBackground(color);
		label_27.setHorizontalAlignment(JLabel.CENTER);
		label_27.setBorder(border);
		label_27.setOpaque(true);
		label_27.setBackground(color);
		label_20.setHorizontalAlignment(JLabel.CENTER);// 양방과
		label_20.setBorder(border);// 양방과
		label_20.setOpaque(true);// 양방과
		label_20.setBackground(color);// 양방과
		label_21.setHorizontalAlignment(JLabel.CENTER);// 한방2과
		label_21.setBorder(border);// 한방2과
		label_21.setOpaque(true);// 한방2과
		label_21.setBackground(color);// 한방2과
		label_22.setHorizontalAlignment(JLabel.CENTER);// 한방1과
		label_22.setBorder(border);// 한방1과
		label_22.setOpaque(true);// 한방1과
		label_22.setBackground(color);// 한방1과
		label_23.setHorizontalAlignment(JLabel.CENTER);// 전체
		label_23.setBorder(border);// 전체
		label_23.setOpaque(true);// 전체
		label_23.setBackground(color);// 전체
		label_24.setHorizontalAlignment(JLabel.CENTER);// 환자현황
		label_24.setBorder(border);// 환자현황
		label_24.setOpaque(true);// 환자현황
		label_24.setBackground(color);// 환자현황

		label_2.setHorizontalAlignment(JLabel.CENTER);// 양방과 합계
		label_2.setBorder(border);// 양방과 합계
		label_2.setOpaque(true);
		label_2.setForeground(Color.red);
		label_2.setBackground(Color.white);
		label_7.setHorizontalAlignment(JLabel.CENTER); // 2층 한방2과
		label_7.setBorder(border); // 2층 한방2과
		label_7.setOpaque(true); // 2층 한방2과
		label_7.setForeground(colorGreen);
		label_7.setBackground(Color.white); // 2층 한방2과
		label_6.setHorizontalAlignment(JLabel.CENTER); // 2층 양방과
		label_6.setBorder(border); // 2층 양방과
		label_6.setOpaque(true); // 2층 양방과
		label_6.setForeground(Color.red);
		label_6.setBackground(Color.white); // 2층 양방과
		label_8.setHorizontalAlignment(JLabel.CENTER); // 2층 한방1과
		label_8.setBorder(border); // 2층 한방1과
		label_8.setOpaque(true); // 2층 한방1과
		label_8.setBackground(Color.white); // 2층 한방1과
		label_8.setForeground(Color.blue); // 2층 한방1과
		label_9.setHorizontalAlignment(JLabel.CENTER); // 2층 합
		label_9.setBorder(border); // 2층 합
		label_9.setOpaque(true); // 2층 합
		label_9.setBackground(Color.white); // 2층 합
		label_13.setHorizontalAlignment(JLabel.CENTER);// 1층 양방과
		label_13.setBorder(border);// 1층 양방과
		label_13.setOpaque(true);// 1층 양방과
		label_13.setForeground(Color.red);
		label_13.setBackground(Color.white);// 1층 양방과
		label_14.setHorizontalAlignment(JLabel.CENTER); // 1층 한방2과
		label_14.setBorder(border); // 1층 한방2과
		label_14.setOpaque(true); // 1층 한방2과
		label_14.setForeground(colorGreen);
		label_14.setBackground(Color.white); // 1층 한방2과
		label_15.setHorizontalAlignment(JLabel.CENTER); // 1층 한방1과
		label_15.setBorder(border); // 1층 한방1과
		label_15.setOpaque(true);// 1층 한방1과
		label_15.setForeground(Color.blue);
		label_15.setBackground(Color.white); // 1층 한방1과
		label_16.setHorizontalAlignment(JLabel.CENTER);// 1층 합
		label_16.setBorder(border);// 1층 합
		label_16.setOpaque(true);// 1층 합
		label_16.setBackground(Color.white);// 1층 합
		label_35.setHorizontalAlignment(JLabel.CENTER);// 한방2과합계
		label_35.setBorder(border);// 한방2과합계
		label_35.setOpaque(true);// 한방2과합계
		label_35.setForeground(colorGreen);
		label_35.setBackground(Color.white);// 한방2과합계
		label_25.setHorizontalAlignment(JLabel.CENTER);// 한방1과 합계
		label_25.setBorder(border);// 한방1과 합계
		label_25.setOpaque(true);// 한방1과 합계
		label_25.setForeground(Color.blue);
		label_25.setBackground(Color.white);// 한방1과 합계
		label_26.setHorizontalAlignment(JLabel.CENTER);// 전체합계
		label_26.setBorder(border);// 전체합계
		label_26.setOpaque(true);// 전체합계
		label_26.setBackground(Color.white);// 전체합계

		textField_1 = new JTextField();// 종료일
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
		if (udto.getUgrade().equals("운영자")) {
			btnAdd.addActionListener(this);
			btnDel.addActionListener(this);
			btnMod.addActionListener(this);
			btnUseradd.addActionListener(this);
			btnNewButton.addActionListener(this);
		} else if (udto.getUgrade().equals("관리자")) {
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
		JScrollPane scrolledTable = new JScrollPane(table); // 스크롤 될 수 있도록 JScrollPane 적용
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 너무 붙어있어서 가장자리 띄움(padding)
		// 테이블 컬럼 너비 지정
		table.getColumn("환자번호").setPreferredWidth(25);
		table.getColumn("성별").setPreferredWidth(2);
		table.getColumn("나이").setPreferredWidth(2);
		table.getColumn("호실").setPreferredWidth(10);
		table.getColumn("진료과").setPreferredWidth(30);
		table.getColumn("환자명").setPreferredWidth(25);
		table.getColumn("진단명").setPreferredWidth(300);
		table.getColumn("입원일").setPreferredWidth(30);
		table.getColumn("퇴원일").setPreferredWidth(30);
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
			int answer = JOptionPane.showConfirmDialog(null, "환자정보를 삭제하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
			if (answer == 0) {
				pdao.deletePat(value);
				search();
			}
		} else if (temp.equals(btnMod)) {
//			Pat_DTO mod = pdao.SelectOne(value);
			new ModyPat(pdto);
		} else if (temp.equals(btnNewButton)) {
			int answer = JOptionPane.showConfirmDialog(null, "퇴원처리하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
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
					.createWorkbook(new File("C:\\Users\\human\\Desktop\\환자리스트_" + count + ".xls"));// 엑셀파일생성(생성위치,파일명)
			WritableSheet sheet = workbook.createSheet("환자리스트", 0);// 엑셀 시트 생성(이름,몇번째 시트)
			WritableCellFormat col_form = new WritableCellFormat();// 컬럼포맷,default 스트링
			WritableCellFormat data_form = new WritableCellFormat();// 데이터 포맷,default 스트링
//		WritableCellFormat int_form = new WritableCellFormat(NumberFormat.INTEGER_FIELD);
			col_form.setBackground(Colour.GRAY_25);// 컬럼 배경색 설정
			col_form.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < getColumn.length; i++) {// 컬럼에 컬럼명 삽입
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
		if (depart.equals("전체과")) {
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
			if (i.getDepart().equals("양방과")) {
				sum_med++;
				if (i.getRoom().charAt(0) == '1') {
					sum_med_1++;
					allSum_1++;
				} else if (i.getRoom().charAt(0) == '2') {
					sum_med_2++;
					allSum_2++;
				}
			} else if (i.getDepart().equals("한방1과")) {
				sum_ort1++;
				if (i.getRoom().charAt(0) == '1') {
					sum_ort1_1++;
					allSum_1++;
				} else if (i.getRoom().charAt(0) == '2') {
					sum_ort1_2++;
					allSum_2++;
				}
			} else if (i.getDepart().equals("한방2과")) {
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
		label_6.setText(Integer.toString(sum_med_2));// 2층 양방과
		label_7.setText(Integer.toString(sum_ort2_2));// 2층 한방2과
		label_8.setText(Integer.toString(sum_ort1_2));// 2층 한방1과
		label_9.setText(Integer.toString(allSum_2)); // 2층 합
		label_13.setText(Integer.toString(sum_med_1)); // 1층 양방과
		label_14.setText(Integer.toString(sum_ort2_1)); // 1층 한방2과
		label_15.setText(Integer.toString(sum_ort1_1)); // 1층 한방1과
		label_16.setText(Integer.toString(allSum_1));// 1층 합
		label_35.setText(Integer.toString(sum_ort2));// 한방2과합계
		label_25.setText(Integer.toString(sum_ort1));// 한방1과 합계
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
