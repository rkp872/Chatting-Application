package com.chatbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener
{
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	Client()
	{	
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/chatbox/icons/3.png"));
		Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae)
			{
				System.exit(0);
			}
		});
		
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("com/chatbox/icons/2.png"));
		Image i5=i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel l2=new JLabel(i6);
		l2.setBounds(40,5,60,60);
		p1.add(l2);
		
		JLabel l3=new JLabel ("Bunty");
		l3.setBounds(110,10,100,20);
		l3.setFont(new Font("SAN_SARIF",Font.BOLD,18));
		l3.setForeground(Color.WHITE);
		
		JLabel l4=new JLabel ("Active Now");
		l4.setBounds(110,35,100,18);
		l4.setFont(new Font("SAN_SARIF",Font.PLAIN,14));
		l4.setForeground(Color.WHITE);
		
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("com/chatbox/icons/video.png"));
		Image i8=i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel l5=new JLabel(i9);
		l5.setBounds(290,20,30,30);
		p1.add(l5);
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("com/chatbox/icons/phone.png"));
		Image i12=i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
		ImageIcon i13=new ImageIcon(i12);
		JLabel l6=new JLabel(i13);
		l6.setBounds(350,20,35,30);
		p1.add(l6);
		
		ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("com/chatbox/icons/3icon.png"));
		Image i15=i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
		ImageIcon i16=new ImageIcon(i15);
		JLabel l7=new JLabel(i16);
		l7.setBounds(410,20,13,25);
		p1.add(l7);
	
		p1.add(l3);
		p1.add(l4);
		
		a1=new JTextArea();
		a1.setBounds(5,75,440,470);
		a1.setFont(new Font("SAN_SeRIF",Font.PLAIN,16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		
		add(a1);
		
		t1=new JTextField();
		t1.setBounds(5,550,350,40);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(t1);
		
		b1=new JButton("Send");
		b1.setBounds(360,550,80,40);
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SARIF",Font.PLAIN,14));
		b1.addActionListener(this);
		add(b1);
		setLayout(null);
		setSize(450,600);
		setLocation(700,50);
		setUndecorated(true);
		setVisible(true);
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		try {
			String out=t1.getText();
			a1.setText(a1.getText()+"\n\t\t\t"+out);
			dout.writeUTF(out);
			t1.setText("");
		}catch(Exception e) {}
		
		
	}
	public static void main(String args[])
	{
		new Client();
		
		try {
			String msginput="";
			s=new Socket("127.0.0.1",6001);
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			msginput=din.readUTF();
			a1.setText(a1.getText()+"\n"+ msginput);
			
		}catch(Exception e) {}
	}
}
