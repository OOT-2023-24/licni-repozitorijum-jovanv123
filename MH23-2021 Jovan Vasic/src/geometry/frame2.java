package geometry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.Color;
import java.awt.Dimension;

public class frame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int x=10;
	private static int selectedID=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Glavni frejm za 3. zadatak. Da bi iscrtali oblik koji zelimo prvo stiskamo dugme a potom na panel, posle je neophodno deselektovati dugme koje ce postati crveno
	public frame2() {
		Stack<Shape>stack=new Stack<>();
		PnlDrawing panel = new PnlDrawing(stack);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{33, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JButton btnNewButton_5 = new JButton("Modify selected Shape");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int y=10;
					if(stack.get(selectedID) instanceof Donut) {
						y=4;
					}
					else if(stack.get(selectedID) instanceof Rectangle) {
						y=3;			
					}
					else if(stack.get(selectedID) instanceof Circle) {
						y=2;
					}
					else if(stack.get(selectedID) instanceof Line) {
						y=1;
					}
					else if(stack.get(selectedID) instanceof Point) {
						y=0;
					}
					JModal modal = new JModal(selectedID, stack, panel, y);
					modal.setModal(true);
					modal.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		contentPane.add(btnNewButton_5, gbc_btnNewButton_5);
		btnNewButton_5.setEnabled(false);
		JButton btnNewButton_6 = new JButton("Remove selected Shape");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 1;
		contentPane.add(btnNewButton_6, gbc_btnNewButton_6);
		btnNewButton_6.setEnabled(false);
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the selected shape?", "Confirmation", JOptionPane.YES_NO_OPTION);
			     if (result == JOptionPane.YES_OPTION) {
		            stack.remove(selectedID);
		            panel.loop();
		        }
			}});
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.PINK);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					for (Shape s: stack) {
						if(s.contains(e.getX(), e.getY())) {
							btnNewButton_6.setEnabled(true);
							btnNewButton_5.setEnabled(true);
							selectedID=stack.indexOf(s);
							break;
						}
						else {
							btnNewButton_6.setEnabled(false);
							btnNewButton_5.setEnabled(false);
							
						}
					}
				
			}
		});
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Circle");
		JButton btnNewButton_3 = new JButton("Line");
		JButton btnNewButton_4 = new JButton("Point");
		JButton btnNewButton_1 = new JButton("Circle with Hole");
		JButton btnNewButton_2 = new JButton("Rectangle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x!=2) {
					x=2;
					btnNewButton.setBackground(Color.red);
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					
					
				}
				else if(x==2) {
					x=5;
					btnNewButton.setBackground(new Color(240,240,240));
				}
			}
		});
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(x!=1) {
					x=1;
					btnNewButton_3.setBackground(Color.red);
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
				}
				else if(x==1) {
					x=5;
					btnNewButton_3.setBackground(new Color(240,240,240));
				}
			}
		});
		
		
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x!=0) {
					x=0;
					btnNewButton_4.setBackground(Color.red);
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					}
					else if (x==0) {
						x=5;
						btnNewButton_4.setBackground(new Color(240,240,240));
					}
			}
		});	
		panel_1.add(btnNewButton_3);
		panel_1.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (x!=4) {
				x=4;
				btnNewButton_1.setBackground(Color.red);
				btnNewButton_2.setBackground(new Color(240, 240, 240));
				btnNewButton_3.setBackground(new Color(240, 240, 240));
				btnNewButton_4.setBackground(new Color(240, 240, 240));
				btnNewButton.setBackground(new Color(240, 240, 240));
				}
				else if(x==4)
				{
					x=5;
					btnNewButton_1.setBackground(new Color(240,240,240));
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x!=3) {
					x=3;
					btnNewButton_2.setBackground(Color.red);
					btnNewButton.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
				}
				else if(x==3)
					{
						x=5;
						btnNewButton_2.setBackground(new Color(240,240,240));
				}
			}
		});
		panel_1.add(btnNewButton_2);
	}
	public static int getshape() {
		return x;


	}
	
}
