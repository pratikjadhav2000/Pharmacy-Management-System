package connection;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class Stock extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	private JScrollPane scrollPane;
	public Stock() {
		connection=Connect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 34, 640, 355);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		try
		{
			String query="select * from requirement";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try
				{
					Addstock a=new Addstock();
					a.setVisible(true);
					
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
		});
		btnAddStock.setBounds(239, 483, 97, 25);
		contentPane.add(btnAddStock);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Viewall v=new Viewall();
				dispose();
				v.setVisible(true);
				
			}
		});
		btnBack.setBounds(547, 483, 97, 25);
		contentPane.add(btnBack);
		
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
