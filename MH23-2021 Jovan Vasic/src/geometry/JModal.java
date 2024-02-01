package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Stack;

import javax.swing.JTextField; ////GLAVNI FREJM ZA POKRETANJE 2. ZADATKA
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JModal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Color borderColor=Color.BLACK;
	private Color FillColor=Color.WHITE;
	String  lbl,lbl1,lbl2,lbl3,lbl4,lbl5;

	
	public JModal(int selectedID, Stack<Shape> stack, PnlDrawing panel, int y) {
		
		switch(y) {
		case 0: {
			
			lbl = "X: ";
			lbl1 = "Y: ";
			lbl2 = "Color: ";
			borderColor = ((Point)stack.get(selectedID)).getColor();
			break;
		}
		case 1: {
			
			lbl = "Starting point X: ";
			lbl1 = "Starting point Y: ";
			lbl2 = "Color: ";
			lbl3 = "Ending point X: ";
			lbl4 = "Ending point Y: ";
			borderColor = ((Line)stack.get(selectedID)).getColor();
			break;
		}
		case 2: {
			lbl = "Center X: ";
			lbl1 = "Center Y: ";
			lbl2 = "Border color: ";
			lbl3 = "Fill color: ";
			lbl4 = "Radius: ";
			borderColor = ((Circle)stack.get(selectedID)).getBorderColor();
			FillColor = ((Circle)stack.get(selectedID)).getFillColor();
			break;
		}
		case 3: {
			lbl = "Top left point X: ";
			lbl1 = "Top left point Y: ";
			lbl4 = "Width: ";
			lbl5 = "Height: ";
			lbl2 = "Border color: ";
			lbl3= "Fill color";
			borderColor = ((Rectangle)stack.get(selectedID)).getBorderColor();
			FillColor = ((Rectangle)stack.get(selectedID)).getFillColor();
			break;
		}
		case 4: {
			
			lbl = "Center X: ";
			lbl1 = "Center Y: ";
			lbl2 = "Border color: ";
			lbl3 = "Fill color: ";
			lbl4 = "Inner radius: ";
			lbl5 = "Outer radius: ";
			borderColor = ((Donut)stack.get(selectedID)).getBorderColor();
			FillColor = ((Donut)stack.get(selectedID)).getFillColor();
			break;
		}
		}
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_1 = new JLabel(lbl);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel(lbl1);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 2;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 4;
			gbc_textField_1.gridy = 2;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel(lbl2);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 2;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textField_2 = new JTextField();
			textField_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", Color.BLACK);
				if(selectedColor!=null) {
					textField_2.setText(selectedColor.toString());
					textField_2.setBackground(selectedColor);
					}
				}
			});
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 4;
			gbc_textField_2.gridy = 3;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel(lbl3);
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 2;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			textField_3 = new JTextField();
			textField_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", Color.BLACK);
				if(selectedColor!=null) {
				textField_3.setText(selectedColor.toString());
				textField_3.setBackground(selectedColor);
				}
            }
        });
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.insets = new Insets(0, 0, 5, 0);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 4;
			gbc_textField_3.gridy = 4;
			contentPanel.add(textField_3, gbc_textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel(lbl4);
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 2;
			gbc_lblNewLabel_5.gridy = 5;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			textField_4 = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 0);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 4;
			gbc_textField_4.gridy = 5;
			contentPanel.add(textField_4, gbc_textField_4);
			textField_4.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel(lbl5);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 6;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField_5 = new JTextField();
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.insets = new Insets(0, 0, 5, 0);
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 4;
			gbc_textField_5.gridy = 6;
			contentPanel.add(textField_5, gbc_textField_5);
			textField_5.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch (y){
						case 0:{
							stack.get(selectedID).moveTo(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()));
							borderColor=textField_2.getBackground();
							((Point)stack.get(selectedID)).setColor(borderColor);
							panel.loop();
							dispose();
							break;
						}
						case 1:{
							((Line)stack.get(selectedID)).setStartPoint(new Point(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()) ));
							borderColor=textField_2.getBackground();
							((Line)stack.get(selectedID)).setEndPoint(new Point(Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()) ));
							((Line)stack.get(selectedID)).setColor(borderColor);
							panel.loop();
							dispose();
							break;
						}
						case 2:{
							((Circle)stack.get(selectedID)).setCenter(new Point(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()) ));
							((Circle)stack.get(selectedID)).setRadius(Integer.parseInt(textField_4.getText()));
							borderColor=textField_2.getBackground();
							((Circle)stack.get(selectedID)).setBorderColor(borderColor);
							FillColor=textField_3.getBackground();
							((Circle)stack.get(selectedID)).setFillColor(FillColor);
							panel.loop();
							dispose();
							break;
						}
						case 3:{
							((Rectangle)stack.get(selectedID)).setUpperLeft(new Point(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()) ));
							((Rectangle)stack.get(selectedID)).setWidth(Integer.parseInt(textField_4.getText()));
							((Rectangle)stack.get(selectedID)).setHeight(Integer.parseInt(textField_5.getText()));
							borderColor=textField_2.getBackground();
							((Rectangle)stack.get(selectedID)).setBorderColor(borderColor);
							FillColor=textField_3.getBackground();
							((Rectangle)stack.get(selectedID)).setFillColor(FillColor);
							panel.loop();
							dispose();
							break;
						}
						case 4:{
							((Donut)stack.get(selectedID)).setCenter(new Point(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()) ));
							((Donut)stack.get(selectedID)).setRadius(Integer.parseInt(textField_5.getText()));
							((Donut)stack.get(selectedID)).setInnerRadius(Integer.parseInt(textField_4.getText()));
							borderColor=textField_2.getBackground();
							((Donut)stack.get(selectedID)).setBorderColor(borderColor);
							FillColor=textField_3.getBackground();
							((Donut)stack.get(selectedID)).setFillColor(FillColor);
							panel.loop();
							dispose();
							break;
						}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		switch (y) {
		case 0: {
			textField.setText("" + ((Point)stack.get(selectedID)).getX());
			textField_1.setText("" + ((Point)stack.get(selectedID)).getY());
			textField_2.setText("" + ((Point)stack.get(selectedID)).getColor().toString());
			textField_3.setVisible(false);
			textField_4.setVisible(false);
			textField_5.setVisible(false);
			
			break;
		}
		case 1: {
			textField.setText("" + ((Line)stack.get(selectedID)).getStartPoint().getX());
			textField_1.setText("" + ((Line)stack.get(selectedID)).getStartPoint().getY());
			textField_2.setText("" + ((Line)stack.get(selectedID)).getColor().toString());
			textField_3.setText("" + ((Line)stack.get(selectedID)).getEndPoint().getX());
			textField_4.setText("" + ((Line)stack.get(selectedID)).getEndPoint().getY());
			textField_5.setVisible(false);
	
			break;
		}
		case 2: {
			textField.setText("" + ((Circle)stack.get(selectedID)).getCenter().getX());
			textField_1.setText("" + ((Circle)stack.get(selectedID)).getCenter().getY());
			textField_2.setText("" + ((Circle)stack.get(selectedID)).getBorderColor().toString());
			textField_3.setText("" + ((Circle)stack.get(selectedID)).getFillColor().toString());
			textField_4.setText("" + ((Circle)stack.get(selectedID)).getRadius());
			textField_5.setVisible(false);
		
			break;
		}
		case 3: {
			textField.setText("" + ((Rectangle)stack.get(selectedID)).getUpperLeft().getX());
			textField_1.setText("" + ((Rectangle)stack.get(selectedID)).getUpperLeft().getY());
			textField_2.setText("" + ((Rectangle)stack.get(selectedID)).getBorderColor().toString());
			textField_3.setText("" + ((Rectangle)stack.get(selectedID)).getFillColor().toString());
			textField_4.setText("" + ((Rectangle)stack.get(selectedID)).getWidth());
			textField_5.setText("" + ((Rectangle)stack.get(selectedID)).getHeight());

			break;
		}
		case 4: {
			textField.setText("" + ((Donut)stack.get(selectedID)).getCenter().getX());
			textField_1.setText("" + ((Donut)stack.get(selectedID)).getCenter().getY());
			textField_2.setText("" + ((Donut)stack.get(selectedID)).getBorderColor().toString());
			textField_3.setText("" + ((Donut)stack.get(selectedID)).getFillColor().toString());
			textField_4.setText("" + ((Donut)stack.get(selectedID)).getInnerRadius());
			textField_5.setText("" + ((Donut)stack.get(selectedID)).getRadius());

			break;
		}
		}
	}

	

}
