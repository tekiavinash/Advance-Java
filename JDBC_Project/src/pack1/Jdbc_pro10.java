package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//PreparedStatement Interface
public class Jdbc_pro10 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "system";
	String dbPwd ="avinash";
	Scanner sc=new Scanner(System.in);
	
	Connection testConnect()
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(dbURL,dbUser,dbPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void operations()
	{
		try
		{
			Connection con=testConnect();
			PreparedStatement pstm1=con.prepareStatement("insert into patient values(?,?,?,?)");
			PreparedStatement pstm2=con.prepareStatement("select*from patient");
			PreparedStatement pstm3=con.prepareStatement("select*from patient where Pid=?");
			PreparedStatement pstm4=con.prepareStatement("Update patient set age=? where Pid=?");
			PreparedStatement pstm5=con.prepareStatement("Delete from patient where Pid=?");
			
			
			while(true)
			{					
				System.out.println("***********Welcome to Patient Database***************");
				
				System.out.println("1.Insert patient Data\n2.View patient Data\n3.Reterving Specific patient Data\n"
						+ "4.Updating Specific patient Data\n5.Delete Specifi patient Data\n6.Exit");
				System.out.println("Enter your choice:");
				int choice=sc.nextInt();
				
				switch(choice)
				{
					case 1:
						System.out.println("Inserting patient Data");
						System.out.println("Enter patinet id:");
						sc.nextLine();
						String PId=sc.nextLine();
						System.out.println("Enter patinet Name:");
						String PName=sc.nextLine();
						System.out.println("Enter patinet Age:");
						int PAge=Integer.parseInt(sc.nextLine());
						System.out.println("Enter patinet Contact:");
						long PContact=Long.parseLong(sc.nextLine());
						
						pstm1.setString(1, PId);
						pstm1.setString(2, PName);
						pstm1.setInt(3, PAge);
						pstm1.setLong(4, PContact);
						
						int rowCount=pstm1.executeUpdate();
						if(rowCount>0)
						{
							System.out.println("Data Inserted");
						}
						else
						{
							System.out.println("Data Not Inserted");
						}
						break;
					case 2:
						System.out.println("Vewing the patinet Details");
						ResultSet rs =pstm2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
						}
						System.out.println("Data Retervied");
						break;
					case 3:
						System.out.println("Reterving the Specific patient Data");
						System.out.println("Enter Pid");
						sc.nextLine();
						String Pid=sc.nextLine();
						pstm3.setString(1, Pid);
						ResultSet rs1 = pstm3.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getLong(4));
						}
						else 
						{
							System.out.println("There is NO record with Pid "+Pid);
						}
						break;
					case 4:
						System.out.println("Updating Specific Patient Data");
						System.out.println("Enter Patient Id:");
						sc.nextLine();
						String PId1=sc.nextLine();
						System.out.println("Enter Age:");
						int PAge1=Integer.parseInt(sc.nextLine());
						pstm4.setInt(1, PAge1);
						pstm4.setString(2, PId1);						
						int rowCount1=pstm4.executeUpdate();
						if(rowCount1>0)
						{
							System.out.println("Data Updated");
						}
						else
						{
							System.out.println("Data not Updated");
						}
						break;
					case 5:
						System.out.println("Deleteing Specific Patient Data");
						System.out.println("Enter patient Id:");
						sc.nextLine();
						String PId2=sc.nextLine();
						pstm5.setString(1, PId2);
						int rowCount2=pstm5.executeUpdate();
						if(rowCount2>0)
						{
							System.out.println("Data Deleted");
						}
						else
						{
							System.out.println("There NO data found with pid "+PId2);
						}
						break;
					case 6:
						System.out.println("Thank you see you seen");
						System.exit(0);
						break;
						default:
							System.out.println("Invalid Input");
				}				
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		new Jdbc_pro10().operations();
	}
}
