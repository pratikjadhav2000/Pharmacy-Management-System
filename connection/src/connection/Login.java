package connection;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Login {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=Connect.dbConnector();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Trebuchet MS", Font.ITALIC, 36));
		frame.setBounds(100, 100, 1118, 782);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBounds(486, 275, 99, 25);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(613, 278, 116, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(486, 338, 99, 25);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(128, 128, 128));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setOpaque(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					
					String query="select * from user where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null,"Username and Password is correct!");
						frame.dispose();
						Welcome p=new Welcome();
						p.frame.setVisible(true);
						
					
					}
					
					else if(count>1)
					{
							JOptionPane.showMessageDialog(null,"Duplicate Username and Password");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong Username and Password");
					}
					
					
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
					
				}
				
				
			}
		});
		btnLogin.setBounds(529, 400, 149, 40);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(613, 340, 116, 25);
		frame.getContentPane().add(passwordField);
		
		JLabel lblSimpharm = new JLabel("SimPharm");
		lblSimpharm.setForeground(new Color(0, 0, 0));
		lblSimpharm.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 42));
		lblSimpharm.setBounds(506, 65, 204, 55);
		frame.getContentPane().add(lblSimpharm);
		
		
		JPanel heading;
		heading=new JPanel();
			
		frame.setSize(900,600);
		frame.getContentPane().setLayout(null);
	
		ImageIcon background_image=new ImageIcon("C:\\Users\\hp\\Desktop\\med.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0, 0, 900,600);
		frame.getContentPane().add(background);
		
		frame.setVisible(true);
		
		
		
		
	}
}
