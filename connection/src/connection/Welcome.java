package connection;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class Welcome {

	public JFrame frame;
	public JLabel lblWelcomeToSimpharm;
	public JLabel lblMedicine;
	public JButton btnSearch;
	
	public static String s2;
	public static int s1,s3,s4;
	public JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	public ResultSet rs;
	private JButton btnLogout;
	//public PreparedStatement pst1;
	/**
	 * Create the application.
	 */
	public void list()
	{
		try
		{
			String query1="select Drug_name from drugs";
			PreparedStatement pst1=connection.prepareStatement(query1);
			
			 rs=pst1.executeQuery(); 
		     // JOptionPane.showMessageDialog(null,"Connection Successful");
		
			 while(rs.next())
			 {
				 comboBox.addItem(rs.getString("Drug_name"));
			 }
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		
		}
		
	}
	public Welcome() {
		
		connection=(Connection) Connect.dbConnector();
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 680, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setUndecorated(true);
		
		lblWelcomeToSimpharm = new JLabel("WelCome to SimPharm");
		lblWelcomeToSimpharm.setFont(new Font("Sitka Display", Font.ITALIC, 38));
		lblWelcomeToSimpharm.setForeground(Color.WHITE);
		lblWelcomeToSimpharm.setBounds(153, 69, 359, 48);
		frame.getContentPane().add(lblWelcomeToSimpharm);
		
		lblMedicine = new JLabel("Medicine ");
		lblMedicine.setFont(new Font("Myanmar Text", Font.PLAIN, 21));
		lblMedicine.setForeground(Color.WHITE);
		lblMedicine.setBounds(215, 169, 126, 28);
		frame.getContentPane().add(lblMedicine);
		
		 comboBox=new JComboBox();
			comboBox.setBounds(325, 169, 176, 22);
			frame.getContentPane().add(comboBox);
			
			list();
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setOpaque(false);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					String query1="select * from drugs where Drug_name=?";
					PreparedStatement pst1=connection.prepareStatement(query1);
					pst1.setString(1, (String) comboBox.getSelectedItem());
					  rs=pst1.executeQuery();
					 Search s=new Search();
					 s.table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					
					  rs=pst1.executeQuery();
					 
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null,"Drug found!");
						
						 rs=pst1.executeQuery();
						 rs.next();
						 
						 s1= rs.getInt("Drug_id");
						 s2= rs.getString("Drug_name");
						 s3= rs.getInt("Price_per_unit");
						 s4=rs.getInt("Stock");
						 
					     System.out.println(s1);
					     System.out.println(s2);
					     System.out.println(s3);
						
						
						frame.dispose();
						
						s.setVisible(true);
						
						
						
					
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
				
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2);
					
				}
				
			
			}
		});
		btnSearch.setBounds(325, 220, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		JButton btnLoadAllDrugs = new JButton("Show All");
		btnLoadAllDrugs.setBackground(Color.LIGHT_GRAY);
		btnLoadAllDrugs.setForeground(Color.WHITE);
		btnLoadAllDrugs.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLoadAllDrugs.setOpaque(false);
		btnLoadAllDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewall v=new Viewall();
				
				
				
				frame.dispose();
				
				v.setVisible(true);
				
			}
		});
		btnLoadAllDrugs.setBounds(325, 298, 116, 28);
		frame.getContentPane().add(btnLoadAllDrugs);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setOpaque(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				frame.dispose();
				l.frame.setVisible(true);
				
			}
		});
		btnLogout.setBounds(783, 559, 105, 28);
		frame.getContentPane().add(btnLogout);
		
		JPanel heading;
		heading=new JPanel();
			
		frame.setSize(900,600);
		frame.getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\welcome.png");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		background.setBackground(Color.GRAY);
		background.setForeground(Color.BLACK);
		
		background.add(heading);
		background.setBounds(0, 0, 900,600);
		frame.getContentPane().add(background);
		
		
		
		frame.setVisible(true);
	}
}
