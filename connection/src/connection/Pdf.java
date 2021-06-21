package connection;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.itextpdf.text.Document.*;
import com.itextpdf.text.Paragraph;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdom.Text;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class Pdf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pdf frame = new Pdf();
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
	public Pdf() {
		
	
		connection=(Connection) Connect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer      Details");
		lblCustomerName.setForeground(Color.BLUE);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblCustomerName.setBounds(237, 13, 378, 75);
		contentPane.add(lblCustomerName);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(329, 136, 77, 23);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(405, 139, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPhone = new JLabel("PHONE:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhone.setBounds(320, 184, 77, 23);
		contentPane.add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(405, 187, 116, 22);
		contentPane.add(textField_1);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(329, 234, 77, 23);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(405, 237, 116, 22);
		contentPane.add(textField_2);
		
		JButton btnMakeInvoice = new JButton("DONE");
		btnMakeInvoice.setOpaque(false);
		btnMakeInvoice.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMakeInvoice.setForeground(Color.BLACK);
		btnMakeInvoice.setBackground(Color.WHITE);
		btnMakeInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select * from billing";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					ViewBill v= new ViewBill();
					
					DateFormat date = new SimpleDateFormat("dd/MM/yyyy ");    
				       Date dateobj = new Date();
				   //    System.out.println(date.format(dateobj));
				       
				       DateFormat time = new SimpleDateFormat("HH:mm:ss ");   
				       
				     //  System.out.println(time.format(dateobj));
				       
					
			Document doc=new Document();
				
				PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\hp\\Desktop\\Bill\\"+textField.getText()+".pdf"));
					doc.open();
					
				/*
					doc.addCreationDate();
					doc.addAuthor("PRATIK JADHAV");
					doc.addCreator("SIMPHARM");
				*/
					
					Paragraph preface = new Paragraph("INVOICE"); 
					preface.setAlignment(Element.ALIGN_CENTER);
					
					doc.add(preface);
					
					doc.add(new Paragraph(" \n  \n NAME: "+textField.getText()+"\n PHONE: "+textField_1.getText()+"\n EMAIL: "+textField_2.getText()+"\n DATE: "+date.format(dateobj)+"\n TIME: "+time.format(dateobj)+"\n\n"));
					PdfPTable t=new PdfPTable(5);
					t.setWidthPercentage(105);
					t.setSpacingAfter(11f);
					t.setSpacingBefore(11f);
					
					float s[]={2f,2f,2f,2f,2f};
					t.setWidths(s);
					
					//set column names
					
					PdfPCell c1=new PdfPCell(new Paragraph("Drug_ID"));
					PdfPCell c2=new PdfPCell(new Paragraph("Description"));
					PdfPCell c3=new PdfPCell(new Paragraph("Quantity"));
					PdfPCell c4=new PdfPCell(new Paragraph("Price"));
					PdfPCell c5=new PdfPCell(new Paragraph("Total"));
					
					t.addCell(c1);
					t.addCell(c2);
					t.addCell(c3);
					t.addCell(c4);
					t.addCell(c5);
					
					//fill table
					while(rs.next())		
					{
						
						
						t.addCell(new PdfPCell(new Paragraph(rs.getString("Drug_id"))));
						t.addCell(new PdfPCell(new Paragraph(rs.getString("Description"))));
						t.addCell(new PdfPCell(new Paragraph(rs.getString("Quantity"))));
						t.addCell(new PdfPCell(new Paragraph(rs.getString("Price"))));
						t.addCell(new PdfPCell(new Paragraph(rs.getString("total"))));
						
						
						
					}
					
					
					
					
					
					
					
					doc.add(t);
					
					v.dispose();
					
					Paragraph preface2 = new Paragraph("TOTAL BILL AMOUNT : "+v.total); 
					preface2.setAlignment(Element.ALIGN_CENTER);
					doc.add(preface2);
					
					doc.add(new Paragraph(" \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));

					
					Paragraph preface1 = new Paragraph("-By Pratik Jadhav"); 
					
					preface1.setAlignment(Element.ALIGN_CENTER);
					doc.add(preface1);
					
					
					
					
					doc.close();
			//	direct print table	
				/*	
					MessageFormat h=new MessageFormat(" \n INVOICE  \n NAME: "+textField.getText()+"\n PHONE: "+textField_1.getText());
					MessageFormat f=new MessageFormat("-by pratik jadhav");
					
				Viewall v= new Viewall();
				v.dispose();
				v.table.print(JTable.PrintMode.FIT_WIDTH, h,f);
				*/
					
				
				} 
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			
				JOptionPane.showMessageDialog(null,"DONE");
				
				
				setVisible(false);
				
			}
		});
		btnMakeInvoice.setBounds(371, 288, 116, 32);
		contentPane.add(btnMakeInvoice);
		

		JPanel heading;
		heading=new JPanel();
			
		setSize(900,600);
		getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\print.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0, 0, 900,600);
		getContentPane().add(background);
		
		setVisible(true);
	}
}
