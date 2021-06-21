package connection;
import com.itextpdf.*;
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
import java.text.MessageFormat;
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

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

public class ViewBill extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JButton btnPrintBill;
	public JButton btnLogout;
	protected int total=0,count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBill frame = new ViewBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public ViewBill() {
		connection=(Connection) Connect.dbConnector();
		Pdf p=new Pdf();			//for pdf
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 13, 663, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setForeground(Color.WHITE);
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalCost.setBounds(290, 392, 335, 33);
		contentPane.add(lblTotalCost);
		
		
		
		btnPrintBill = new JButton("Print Receipt");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try
				{
					
					p.setVisible(true);
					
					
					/*
					MessageFormat h=new MessageFormat("INVOICE");
					MessageFormat f=new MessageFormat("TOTAL BILL AMOUNT:"+total);
					
					table.print(JTable.PrintMode.FIT_WIDTH, h, f);
					*/
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		});
		btnPrintBill.setBounds(373, 470, 112, 25);
		contentPane.add(btnPrintBill);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try
				{
					String query="delete from billing";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.executeUpdate();
					
					
				
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
					
				}
				
				dispose();
				Login p=new Login();
				p.frame.setVisible(true);
				
			}
		});
		btnLogout.setBounds(644, 470, 97, 25);
		contentPane.add(btnLogout);
		
		try
		{
			String query="select * from billing";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
		   
			ResultSet rst=pst.executeQuery();
			
			while(rst.next())
			{
				total=total + rst.getInt("total");
				count++;		//for pdf
				
			}
			
			
			lblTotalCost.setText("TOTAL BILL AMOUNT IS " + total);
			
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Welcome s=new Welcome();
					dispose();
					s.frame.setVisible(true);
					
				}
			});
			btnBack.setBounds(157, 470, 97, 25);
			contentPane.add(btnBack);
		
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			
		}
		
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
