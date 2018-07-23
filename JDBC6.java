import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Medicalshop
{
   int Age,Quantity,Price,Bill;
   String PName,Address,MedicineName,BatchNo;
   
   Medicalshop(String MedicineNam,String BatchN,int Quantit,int Pric)
	{
	this.MedicineName=MedicineNam;
	this.BatchNo=BatchN;
	this.Quantity=Quantit;
	this.Price=Pric;
	}
	
   void getInfo()
   {
   Scanner si=new Scanner(System.in);
   System.out.println("Enter the Patients Name: ");
   PName=si.next();
   System.out.println("Enter Age: ");
   Age=si.nextInt();
   System.out.println("Enter Patients Address: ");
   Address=si.next();
   System.out.println("Enter Medicine Name: ");
   MedicineName=si.next();
   System.out.println("Enter BatchNo: ");
   BatchNo=si.next();
   System.out.println("Enter Quantity: ");
   Quantity=si.nextInt();
   System.out.println("Enter Price: ");
   Price=si.nextInt();
   }
   void showInfo()
   {
   System.out.println("Patients Name: "+PName);
   System.out.println("Patients Age: "+Age);
   System.out.println("Patients Address: "+Address);
   System.out.println("Medicine Name: "+MedicineName);
   System.out.println("BatchNo : "+BatchNo);
   System.out.println("Quantity: "+Quantity);
   System.out.println("Price: "+Price);
   }
   void showInfo(int n)
	{
		System.out.println(MedicineName+ " | " +BatchNo+ " | " +Quantity+ " | " +Price);
	}
   void save()
   {
      try                                                                                                     
      {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection c=DriverManager.getConnection("jdbc:odbc:MedicDB");
       Statement s=c.createStatement();
       String query="insert into Medicalshop (MedicineName,BatchNo,Quantity,Price) values('"+MedicineName+"','"+BatchNo+"',"+Quantity+","+Price+")";       
       int n=s.executeUpdate(query);
	  	   }
	   catch(Exception e)
	   {}
	}
	void showAllRecords()
	{
	 
	try
	{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   Connection c=DriverManager.getConnection("jdbc:odbc:MedicDB");
	   Statement s=c.createStatement();
	   String query="select * from Medicalshop where MedicineName='Neeri'";
 	   ResultSet rs =s.executeQuery(query);
	     System.out.println("All Rec");
	     int i=1;
	    while(rs.next())
	    {
	      int srno=rs.getInt(1);
	      String mednm=rs.getString(2);
	      String bn=rs.getString(3);
	      int qnt=rs.getInt(4);
	      int pr=rs.getInt(5);
 	      System.out.println( i + "  "+srno+ " | "  +mednm+ " | " +bn+ " | " +qnt+ " | " +pr);
 	      i++;
	     }
	  //   JOptionPane.showMessageDialog(this,"YOu have Enrolled Successfuly");
	    }
	   catch(Exception e)
	   { 
        e.printStackTrace();
	   }
	}
	}
	
class Medic extends JFrame implements ActionListener
{
        JLabel l1,l2,l3,l4;
        JTextField t1,t2,t3,t4;
        JButton b1,b2;
       Medic()
       {
        super("Medic");
        setSize(200,200 );
        setLayout(new GridLayout(5,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1=new JLabel("MedicineName");
        l2=new JLabel("BatchNo");
        l3=new JLabel("Quantity");
        l4=new JLabel("Price");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        b1=new JButton("Bill");
        b2=new JButton("Clear");
        add(l1);  add(t1);
        add(l2);  add(t2);
        add(l3);  add(t3);
        add(l4);  add(t4);
        add(b1);  add(b2);
       b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
       }
       public void actionPerformed(ActionEvent a)
       {
       String caption=a.getActionCommand();
       String tMnm=t1.getText();
       String tbno=t2.getText();
       String tqnt=t3.getText();
       String tpr=t4.getText();
       if(caption.equals("BIll"))
       {
          Medicalshop p=new Medicalshop(tMnm,tbno,tqnt,tpr);
	        p.getInfo();
	        p.showInfo();
	        p.showAllRecord();
	        }
	        else if(caption.equals("Clear"))
	        {
	        tMnm=setText(null);
	        tbno=setText(null);
	        tqnt=setText(null);
	        tpr=setText(null);
	        
	        }
	        }
  }     
class JDBC5
{
	  public static void main(String args[])
	{
	 Medic m=new Medic();
	 m.setVisible(true);
 	 Medicalshop l=new Medicalshop();
	 l.getInfo();
	 l.showInfo();
	 l.save();
	 l.showAllRecords();
	 
	}	
}    	        
       
       
       
       
       
       
       
       
       
       
       
       