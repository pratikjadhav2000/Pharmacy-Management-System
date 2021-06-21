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

public class Viewall extends JFrame {

	public JPanel contentPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewall frame = new Viewall();
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
	public Viewall() {
		connection=(Connection) Connect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 29, 633, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(SystemColor.menu);
		
		try
		{
			
			String query="select * from drugs";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}
		
		catch(Exception e2)
		{
			JOptionPane.showMessageDialog(null,e2);
			
		}
		
		JButton btnBack = new JButton("Next");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Welcome p=new Welcome();
				p.frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(545, 488, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnAddNew = new JButton("Add New Drug");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Addnew a=new Addnew();
				dispose();
				a.setVisible(true);
				
				
			}
		});
		btnAddNew.setBounds(360, 488, 97, 25);
		contentPane.add(btnAddNew);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Stock v=new Stock();
				dispose();
				v.setVisible(true);
				
				
			}
		});
		btnStock.setBounds(180, 488, 97, 25);
		contentPane.add(btnStock);
		
		JPanel heading;
		heading=new JPanel();
			
		setSize(900,600);
		getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\pill.jpg");
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
