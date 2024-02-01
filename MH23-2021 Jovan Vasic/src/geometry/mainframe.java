package geometry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JScrollPane;
import java.awt.Font;

public class mainframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Stack<Circle> stck=new Stack<>();
	private DefaultListModel<Circle> dlm =new DefaultListModel<>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	///GLAVNI FREJM ZA PRVI I DRUGI ZADATAK
	public mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Input new Circle");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDialog();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JList<Circle> list = new JList<>(dlm);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton_1 = new JButton("Remove Circle");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Jdg dialog1=new Jdg(stck,dlm);
				dialog1.setVisible(true);
				String s1= Integer.toString(dlm.get(0).center.getX());
				String s2= Integer.toString(dlm.get(0).center.getY());
				String s3= Integer.toString(dlm.get(0).getRadius());
				dialog1.textField_1.setText(s1);
				dialog1.textField_2.setText(s2);
				dialog1.textField_3.setText(s3);
				dialog1.textField_1.setEditable(false);
				dialog1.textField_2.setEditable(false);
				dialog1.textField_3.setEditable(false);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Sort by Area");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bblsort();
			}});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 2;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
	}
	
	private void showDialog() {
	Jdg dialog1=new Jdg(stck,dlm);
	dialog1.setVisible(true);
	}
	private void bblsort() {
		for (int i=0;i<dlm.getSize()-1;i++) {
			for (int j=i+1;j<dlm.getSize();j++) {
				if(dlm.get(j).area()>dlm.get(i).area()) {
					Circle temp = dlm.get(j);
					dlm.set(j, dlm.get(i));
					dlm.set(i, temp);
				}
			}
	}
	}
	}

