package Java_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class rule extends JFrame implements ActionListener {
	String name;
	JButton start,back;
	
	rule(String name){
		this.name=name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		JLabel heading=new JLabel("welcome "+name+" to quiz");
		heading.setBounds(55,20,700,35);
		heading.setFont(new Font("Roboto Slab", Font.BOLD, 28));
		heading .setForeground(new Color(30,144,254));
		add(heading);
		
		JLabel rule=new JLabel();
		rule.setBounds(20,90,700,350);
		rule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rule.setText(
					 "<html>"+ 
				     "1. Attempt all the question by reading the question carefully" + "<br><br>" +
				     "2. Time limit for all the question" + "<br><br>" +
				     "3. All question are compulsory" + "<br><br>" +
				     "4. You also provided the lifeline" + "<br><br>" +
				      "5. Dont search the answers on Google" + "<br><br>" +
				      "<html>"
				   );
		add(rule);
		
		back=new JButton("back");
		back.setBounds(250,500,100,30);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		start=new JButton("start");
		start.setBounds(400,500,100,30);
		start.setBackground(new Color(30,144,254));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);
		
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==start) {
			setVisible(false);
			new Quiz(name);
		}
		else {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] arg) {
		new rule("user");
	}
}
