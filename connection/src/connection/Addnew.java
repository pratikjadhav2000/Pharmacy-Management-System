package connection;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addnew extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addnew frame = new Addnew();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	Connection connection=null;
	public Addnew() {
		
		connection=Connect.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JButton btnAddtobase = new JButton("AddToBase");
		btnAddtobase.setOpaque(false);
		btnAddtobase.setBackground(Color.WHITE);
		btnAddtobase.setForeground(Color.WHITE);
		btnAddtobase.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddtobase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String query = " insert into drugs values (0,?, ?, ?, ?, ?)";
			        

				     
				      PreparedStatement preparedStmt = connection.prepareStatement(query);
				      preparedStmt.setString (1, textField.getText());
				      preparedStmt.setInt (2, Integer.parseInt(textField_1.getText()));
				      preparedStmt.setInt (3, Integer.parseInt(textField_2.getText()));
				      preparedStmt.setString (4, textField_3.getText());
				      preparedStmt.setString (5, textField_4.getText());
				      

				      
				      preparedStmt.execute();
				
				      JOptionPane.showMessageDialog(null,"Drug Successfully Added to Base!");
				
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please Enter Appropriate Data.Eg. name:pratik ,price:78 ,date:2019-02-02 ");
					 JOptionPane.showMessageDialog(null,"Please Fill all Details!");
				}
				
			
			}
		});
		btnAddtobase.setBounds(96, 400, 130, 25);
		contentPane.add(btnAddtobase);
		
		JButton btnBack = new JButton("Next");
		btnBack.setBackground(Color.WHITE);
		btnBack.setOpaque(false);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Viewall v=new Viewall();
				dispose();
				v.setVisible(true);
			}
		});
		btnBack.setBounds(302, 400, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(125, 158, 82, 25);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBounds(125, 191, 82, 25);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("STOCK:");
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setBounds(125, 229, 82, 25);
		contentPane.add(lblStock);
		
		JLabel lblMfgDate = new JLabel("MFG DATE:");
		lblMfgDate.setForeground(new Color(255, 255, 255));
		lblMfgDate.setBounds(125, 267, 82, 25);
		contentPane.add(lblMfgDate);
		
		JLabel lblExpDate = new JLabel("EXP DATE:");
		lblExpDate.setForeground(new Color(255, 255, 255));
		lblExpDate.setBounds(125, 305, 82, 25);
		contentPane.add(lblExpDate);
		
		textField = new JTextField();
		textField.setBounds(219, 159, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 195, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 230, 116, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 268, 116, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 306, 116, 22);
		contentPane.add(textField_4);
		
		JLabel lblNewDrug = new JLabel("NEW DRUG");
		lblNewDrug.setForeground(Color.RED);
		lblNewDrug.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewDrug.setBounds(167, 73, 135, 37);
		contentPane.add(lblNewDrug);
		
		JPanel heading;
		heading=new JPanel();
			
		setSize(900,600);
		getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\dna.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		background.setBackground(Color.GRAY);
		background.setForeground(Color.BLACK);
		
		background.add(heading);
		background.setBounds(0, 0, 900,600);
		getContentPane().add(background);
		
		setVisible(true);
	}
}
