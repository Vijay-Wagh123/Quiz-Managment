package Java_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Login extends JFrame implements ActionListener{
	JButton rule,back;
	JTextField fname;
	JFrame f;
	
	
	Login(){
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		
		JLabel heading=new JLabel("Welcome to Java Quiz");
		heading.setBounds(400,60,300,45);
		heading.setFont(new Font("Agbalumo",Font.BOLD,25));
		heading.setForeground(Color.WHITE);
		add(heading);
		
		JLabel name=new JLabel("Enter your name");
		name.setBounds(410,150,300,30);
		name.setFont(new Font("Poppins",Font.BOLD,25));
		name.setForeground(new Color(30,144,254));
		add(name);
	
		fname=new JTextField();
		fname.setBounds(400,200,300,30);
		fname.setFont(new Font("Times New roman",Font.BOLD,20));
		String logiin_name=fname.getText();
		add(fname);
		
		
		rule=new JButton("Rule");
		rule.setBounds(400,270,120,25);
		rule.setBackground(new Color(30,144,254));
		rule.setForeground(Color.WHITE);
		rule.addActionListener(this);
		add(rule);
		
		back=new JButton("Back");
		back.setBounds(570,270,120,25);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(1200,500);
		setLocation(200,150);
		setVisible(true);
	}
	
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==rule) {
				String name=fname.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1", "root", "Viju@2327");
					PreparedStatement ps=con.prepareStatement("insert into student values('"+name+"')");
					ps.executeUpdate();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				setVisible(false);
				new rule(name);
				}
			else if(a.getSource()==back){
				setVisible(false);
			}
			
		}
		public static void main(String[] args) {
			new Login();
		}
	}
