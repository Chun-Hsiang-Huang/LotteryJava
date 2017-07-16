import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Lottery extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf11;
	private JTextField tf12;
	private JTextField tf13;
	private JTextField tf14;
	private JTextField tf15;
	private JTextField tf16;
	private JTextField tf17;
	private ArrayList<JButton> btnarr = new ArrayList();//存放動態產生的按鈕
	private TreeSet<Integer> hs = new TreeSet<>();//手動產生號碼排序
	private TreeSet<Integer> ts = new TreeSet<Integer>();//動態產生號碼排序
	private Integer[] arr = new Integer[6];//存放手動產生的號碼
	private Integer [] arrAuto = new Integer[6];//存放自動產生號碼
	private String[] str = new String[6];//存放要放入table的號碼
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private Integer [] arr1 = new Integer[7];//存放開獎號碼
	private HashSet<Integer> ts1 = new HashSet<Integer>();//放開出獎號
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery frame = new Lottery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lottery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 940);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 10));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		panel_1.setPreferredSize(new Dimension(10, 350));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 80));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		
		tf1 = new JTextField();
		tf1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		panel_3.add(tf1);
		tf1.setColumns(2);
		
		
		
		
		tf2 = new JTextField();
		tf2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf2.setColumns(2);
		panel_3.add(tf2);
		
		
		tf3 = new JTextField();
		tf3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf3.setColumns(2);
		panel_3.add(tf3);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf4.setColumns(2);
		panel_3.add(tf4);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf5.setColumns(2);
		panel_3.add(tf5);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf6.setColumns(2);
		panel_3.add(tf6);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setPreferredSize(new Dimension(10, 40));
		panel_4.add(panel_15, BorderLayout.NORTH);
		
		JButton btnCom = new JButton("\u96FB\u8166\u5E6B\u9078");
		panel_15.add(btnCom);
/*自動產生號碼*********************************************************************************************/
	
		btnCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				
				for(JButton btn:btnarr){
					btn.setBackground(null);
				}
				int Rvalue=0;
				
				while(ts.size()<7){
					Rvalue = (int)(Math.random()*48+1);
					ts.add(Rvalue);
					JButton	temp = 	btnarr.get(Rvalue-1);
					temp.setBackground(Color.orange);
					if(ts.size()==6) 
						break;
				}
					/*將ts轉成整數陣列存入arrAuto中   tf再從中取值*/
					arrAuto = ts.toArray(new Integer[ts.size()]);
					tf1.setText(arrAuto[0].toString());
					tf2.setText(arrAuto[1].toString());
					tf3.setText(arrAuto[2].toString());
					tf4.setText(arrAuto[3].toString());
					tf5.setText(arrAuto[4].toString());
					tf6.setText(arrAuto[5].toString());
					
					/*將tf的值放入str陣列中，以利放入table*/
					str[0] = tf1.getText();
					str[1] = tf2.getText();
					str[2] = tf3.getText();
					str[3] = tf4.getText();
					str[4] = tf5.getText();
					str[5] = tf6.getText();
					
					ts.clear();//清空ts值避免產生錯誤
					
								
			}
		});
		/*************************************************************************/
		btnCom.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnCom.setPreferredSize(new Dimension(100, 30));
		
		JButton btnReset = new JButton("\u91CD\u7F6E\u865F\u78BC");
		panel_15.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf11.setText("");
				tf12.setText("");
				tf13.setText("");
				tf14.setText("");
				tf15.setText("");
				tf16.setText("");
				tf17.setText("");
				ts.clear();
				hs.clear();
				ts1.clear();
				for(JButton btn:btnarr){
					btn.setBackground(null);
				}
				
			}
		});
		btnReset.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnReset.setPreferredSize(new Dimension(100, 30));
/*號碼放入表格中*****************************************************************************/
		JButton btnSure = new JButton("\u78BA\u5B9A\u9078\u865F");
		panel_15.add(btnSure);
		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] column = {"號碼1","號碼2","號碼3","號碼4","號碼5","號碼6"};
				if(dtm.getColumnCount()<6){
					
					for(String title:column)
					dtm.addColumn(title);
				}
				
				
			
					
				dtm.addRow(str);
				table.setModel(dtm);
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				ts.clear();
				hs.clear();
				for(JButton btn:btnarr){
					btn.setBackground(null);
				}
				//System.out.println(ts.toString());
				
				
			}
		});
		btnSure.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnSure.setPreferredSize(new Dimension(100, 30));
/*************************************************************************************************/
		
		JPanel panel_16 = new JPanel();
		panel_16.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		panel_4.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(10, 25));
		panel_16.add(panel_17, BorderLayout.NORTH);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_17.rowHeights = new int[]{0, 0};
		gbl_panel_17.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_17.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_17.setLayout(gbl_panel_17);
		
		JLabel label_1 = new JLabel("\u982D\u734E\u865F\u78BC\u5132\u5B58\u5340");
		label_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridwidth = 4;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_17.add(label_1, gbc_label_1);
		
		JPanel panel_18 = new JPanel();
		panel_18.setPreferredSize(new Dimension(10, 35));
		panel_18.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		panel_16.add(panel_18, BorderLayout.SOUTH);
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_1 = new JButton("\u522A\u9664\u734E\u865F");
		button_1.setPreferredSize(new Dimension(100, 30));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.removeRow(0);
			}
		});
		panel_18.add(button_1);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JPanel panel_20 = new JPanel();
		panel_16.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_20.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u865F\u78BC1", "\u865F\u78BC2", "\u865F\u78BC3", "\u865F\u78BC4", "\u865F\u78BC5", "\u865F\u78BC6"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(10, 250));
		panel_10.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_11.add(panel_19, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Lottery.class.getResource("/resource/\u8CA1\u795E\u723A.png")));
		lblNewLabel.setIcon(new ImageIcon(Lottery.class.getResource("/resource/\u8CA1\u795E\u723A.png")));
		panel_19.add(lblNewLabel);
		
		
		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_14.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		FlowLayout flowLayout_1 = (FlowLayout) panel_13.getLayout();
		flowLayout_1.setVgap(40);
		flowLayout_1.setHgap(10);
		
		tf11 = new JTextField();
		tf11.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		panel_13.add(tf11);
		tf11.setColumns(2);
		
		tf12 = new JTextField();
		tf12.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf12.setColumns(2);
		panel_13.add(tf12);
		
		tf13 = new JTextField();
		tf13.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf13.setColumns(2);
		panel_13.add(tf13);
		
		tf14 = new JTextField();
		tf14.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf14.setColumns(2);
		panel_13.add(tf14);
		
		tf15 = new JTextField();
		tf15.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf15.setColumns(2);
		panel_13.add(tf15);
		
		tf16 = new JTextField();
		tf16.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf16.setColumns(2);
		panel_13.add(tf16);
		
		tf17 = new JTextField();
		tf17.setBackground(new Color(255, 204, 102));
		tf17.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		tf17.setColumns(2);
		panel_13.add(tf17);
		
		JPanel panel_7 = new JPanel();
		panel_14.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
/*產生獎號**********************************************************************************/		
		JButton btnStart = new JButton("\u9EDE\u6211\u958B\u734E");
		btnStart.setSelectedIcon(null);
		panel_8.add(btnStart);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				int Rvalue=0;
				
				while(ts1.size()<8){
					Rvalue = (int)(Math.random()*48+1);
					ts1.add(Rvalue);
					JButton	temp = 	btnarr.get(Rvalue-1);
					temp.setBackground(Color.yellow);
					if(ts1.size()==7) 
						break;
				}
				
					
					
					arr1 = ts1.toArray(new Integer[ts1.size()]);
					
					tf11.setText(arr1[0].toString());
					tf12.setText(arr1[1].toString());
					tf13.setText(arr1[2].toString());
					tf14.setText(arr1[3].toString());
					tf15.setText(arr1[4].toString());
					tf16.setText(arr1[5].toString());
					tf17.setText(arr1[6].toString());
				
			}
		});
		btnStart.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
/********************************************************************/
		
/*對獎****************************************************************/		
		JButton button_2 = new JButton("\u5C0D\u734E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int getNum = 0;
				int speNum = Integer.parseInt(tf17.getText());
				Integer[] num = new Integer[6];
				for(int i = 0;i<table.getRowCount();i++){
					for(int k=0;k<table.getColumnCount();k++){
						num[k]=Integer.parseInt(table.getValueAt(i, k).toString());
						//System.out.println(Arrays.toString(num));
					}
				
				for(int a = 0; a<num.length;a++){
					for(int b=0;b<arr1.length-1;b++){
						
						if(num[a] == arr1[b]){
							getNum+=1;
						}
						else {
							if(num[a] == speNum){
								getNum+=10;
							}
						}
					}
					
				}
					
			}
			
			switch(getNum){
			case 1:
				JOptionPane.showMessageDialog(null, "只中一個號碼，加油好嗎");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "中兩個號碼，不錯喔");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "中三個號碼，領400回家花");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "中四個號碼，是伍獎");
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "中五個號碼，是三獎");
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "號碼全中，挖賽!是頭獎，沒作弊吧？");
				break;
			case 61:
				JOptionPane.showMessageDialog(null, "只中特別號，加油好嗎");
				break;
			case 62:
				JOptionPane.showMessageDialog(null, "中一個號碼與特別號，再接再厲好嗎");
				break;
			case 63:
				JOptionPane.showMessageDialog(null, "六獎1000塊哦要請客");
				break;
			case 64:
				JOptionPane.showMessageDialog(null, "四獎，運氣真好");
				break;
			case 65:
				JOptionPane.showMessageDialog(null, "五獎，可以買台百萬名車了");
				break;
			default:
				JOptionPane.showMessageDialog(null, "全槓龜，慘兮兮");
				break;
			
			}
				
				//System.out.print(getNum);
			}
		});
		panel_8.add(button_2);
		button_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
/**********************************************************************************************/		
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Lottery.class.getResource("/resource/lottery.png")));
		panel_9.add(label);
		
		
		
/*動態產生按鈕**********************************************************************************/
		//JButton newButton = new JButton();
		for(int i=0;i<7;i++){
			for(int j=1;j<8;j++){
			
					int x = i*7+j;
					JButton newButton = new JButton();
					newButton.setPreferredSize(new Dimension(55,45));
					newButton.setText(String.format("%02d",x));
					newButton.setName(String.format("%02d",x));
					
					panel_1.add(newButton);
					String s ="已經選取六個號碼";
					btnarr.add(newButton);
		newButton.addActionListener(new ActionListener(){
								
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField[] jtf = {tf1,tf2,tf3,tf4,tf5,tf6};
				if(hs.size()<=5){
					
					hs.add(Integer.parseInt(newButton.getName()));
					hs.add(Integer.parseInt(newButton.getName()));
					hs.add(Integer.parseInt(newButton.getName()));
					hs.add(Integer.parseInt(newButton.getName()));
					hs.add(Integer.parseInt(newButton.getName()));
					hs.add(Integer.parseInt(newButton.getName()));
					//newButton.setBackground(getForeground().RED);
					arr = hs.toArray(new Integer[hs.size()]);
					/*for(Integer a:arr){
						System.out.print(a.toString());
					}*/
					for(int i=0;i<arr.length;i++){
						jtf[i].setText(arr[i].toString());
					}
					//System.out.print(Arrays.toString(arr));
					str[0] = tf1.getText();
					str[1] = tf2.getText();
					str[2] = tf3.getText();
					str[3] = tf4.getText();
					str[4] = tf5.getText();
					str[5] = tf6.getText();
					
				
				}
				else{
					JOptionPane.showMessageDialog(null, "你已經選了6個號碼!!" );
					newButton.setBackground(null);
				}
					
				
			
				
			}
		});
		
				
			}
		}
/*********************************************************************************************/
	}

}
