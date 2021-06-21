package connection;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Search extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JTextField textField;
	public ResultSet rsbill;
	Welcome w=new Welcome();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(false);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public Search() {
		
		setUndecorated(true);
		
		connection=(Connection) Connect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 665, 109);
		contentPane.add(scrollPane);
		
		///
		/*scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);*/
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		///
		/*table.setOpaque(false);
	//	((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);*/
	
		
		//***
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSell.setForeground(Color.WHITE);
		btnSell.setBackground(Color.WHITE);
		btnSell.setOpaque(false);
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				try
				{
					
					//update stock
					
					 int updated=w.s4 - Integer.parseInt(textField.getText());
					    
					 if(updated>=0)
					 {
						    String query = " update drugs set Stock="+updated+" where Drug_name=?";
						     
							 
							PreparedStatement preparedStmt1 = connection.prepareStatement(query);
							preparedStmt1.setString(1, w.s2);	
							preparedStmt1.execute();
								
								
								//add to bill
								
								  query = " insert into billing (Drug_id, Description, Quantity, Price,total)"
									        + " values (?, ?, ?, ?, ?)";
								 
							PreparedStatement preparedStmt = connection.prepareStatement(query);
							preparedStmt.setInt(1, w.s1);
							preparedStmt.setString(2, w.s2);
							preparedStmt.setString(3,textField.getText());
							preparedStmt.setInt(4, w.s3);
							preparedStmt.setInt(5, 0);
					
							
							
							/* System.out.println(w.s1);
						     System.out.println(w.s2);
						     System.out.println(w.s3);*/
							
						    preparedStmt.execute();
							
						    
						   
								 
								 
								//preparedStmt.executeUpdate();
								JOptionPane.showMessageDialog(null,"OK!");
						 
								if(updated==0)
								{
									
									  query = " insert into requirement values(0,"+w.s1+",'Out of Stock: "+w.s2+" ')";	 
								PreparedStatement preparedStmt2 = connection.prepareStatement(query);
								preparedStmt2.execute();
								}
								
					 }
					 
					 else
					 {
						 JOptionPane.showMessageDialog(null,"Out of Stock! Stock Available only: " + w.s4);
					 }
					    
					
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please enter appropriate data");
					
				}
				
				
				
			}
		});
		btnSell.setBounds(178, 217, 97, 25);
		contentPane.add(btnSell);
		
		textField = new JTextField();
		textField.setBounds(299, 218, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddmore = new JButton("Addmore");
		btnAddmore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Welcome p=new Welcome();
				p.frame.setVisible(true);
			}
		});
		btnAddmore.setBounds(233, 287, 97, 25);
		contentPane.add(btnAddmore);
		
		JLabel lblEnterQuantity = new JLabel("Enter quantity ");
		lblEnterQuantity.setForeground(Color.WHITE);
		lblEnterQuantity.setBounds(433, 221, 97, 16);
		contentPane.add(lblEnterQuantity);
		
		JButton btnViewbill = new JButton("ViewBill");
		btnViewbill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ViewBill p=new ViewBill();
				p.setVisible(true);
			}
		});
		btnViewbill.setBounds(374, 287, 97, 25);
		contentPane.add(btnViewbill);
		
		JPanel heading;
		heading=new JPanel();
			
		setSize(900,600);
		getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\welcome.png");
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
