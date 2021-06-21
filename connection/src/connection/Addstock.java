package connection;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;



public class Addstock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstock frame = new Addstock();
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
	public Addstock() {
		connection=(Connection) Connect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter Drug :");
		lblEnterName.setForeground(Color.WHITE);
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterName.setBounds(295, 195, 131, 43);
		contentPane.add(lblEnterName);
		
		textField = new JTextField();
		textField.setBounds(438, 208, 154, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStockAmount = new JLabel("Stock Quantity:");
		lblStockAmount.setForeground(Color.YELLOW);
		lblStockAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStockAmount.setBounds(258, 251, 168, 43);
		contentPane.add(lblStockAmount);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(438, 264, 154, 22);
		contentPane.add(textField_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setOpaque(false);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					String query1="select * from drugs where Drug_name=?";
					PreparedStatement pst1=connection.prepareStatement(query1);
					pst1.setString(1, textField.getText());
					 ResultSet rs=pst1.executeQuery();
					 
					
					  rs=pst1.executeQuery();
					 
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					
					if(count==1)
					{
						 rs=pst1.executeQuery();
						 rs.next();
						 
						int i=rs.getInt("Stock");
						
						//JOptionPane.showMessageDialog(null,"Drug found!")
						 query1="update drugs set stock=? where Drug_name= ?";
						 PreparedStatement pst2=connection.prepareStatement(query1);
						 pst2.setInt(1, i + Integer.parseInt(textField_1.getText()));
						pst2.setString(2, textField.getText());
						pst2.executeUpdate();
						dispose();				
					}
					
					else if(count>1)
					{
							JOptionPane.showMessageDialog(null,"Duplicate Drug!");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Drug not found!");
					}
					
		
					
					
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
		});
		btnAdd.setBounds(401, 320, 118, 35);
		contentPane.add(btnAdd);
		
		JPanel heading;
		heading=new JPanel();
			
		setSize(900,600);
		getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\stock.jpg");
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
