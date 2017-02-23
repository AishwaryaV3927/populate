//$Id$
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;


public class Main {

	static int type = 0;
	static Random rand = new Random();
	static int randomNum ;
	
	/*static Long crmAPIDashboardID = 12000134203671L;
	static Long userIDArray[] = new Long[] {12000000030132L,12000000034003L,12000000034011L,12000000034023L};
	static int responseTime[] = new int[] {1000000,2000003,3981203,4098321,1090245,6602462,7025892,8234760};
	static String ipAddress[] = new String[] {"1.255.255.254","172.16.205.254","122.68.25.254","183.68.0.1","1.8.0.1","183.196.20.2","152.210.55.42"};
	static String module[] = new String[] {"Leads","Contacts","Potentials","Campaigns","Cases","Solutions","SalesOrders"};
	
	
	static String oldMethod[] = new String[] {"getDeletedRecordIds","getACRecords","getRecycleBinRecords","getRecordsForSync","getSearchRecords"};
	static String oldURL[] = new String[] {"/crm/private/xml/","/crm/private/json/","/crm/private/csv/"};
	static String oldReqType[] = new String[] {"GET","POST"};
	
	static String newURL[] = new String[] {"/crm/v2/","/crm/v2/settings/layouts"};
	static String newReqType[] = new String[] {"GET","POST","PUT","DELETE","PATCH"};
	static int newRespStatus[] = new int[] {200,201,202,204,301,302,304,400,401,403,404,405,413,415,429,500};
	static Long appID[] = new Long[] {1L,2L,3L,4L,5L,6L,8L,9L};
	
	//String applicationName[] = new String[] {"Flipkart","HackerRank","Sakura","Snapdeal","eBay","WhatsApp","HDFC"};
	
	
	
	//String method[] = new String[] {"getDeletedRecordIds","getACRecords","getRecycleBinRecords","getRecordsForSync","getSearchRecords"};
	
	//Long tabID[] = new Long[] {9000000000101L,9000000000097L,9000000000103L,9000000000105L,9000000129001L,9000000000093L,9000000000061L};//"Leads","Accounts","Contacts","Deals","Events","Activities","Vendors"};
	static int moduloInfo0[] = new int[] {4,8,7,7,5,3,2};
	static int moduloInfo1[] = new int[] {4,8,7,7,2,5,16,8};//7,4,5,7};*/
	
	/*public static StringBuilder populateAPIDashboard()
	{
		randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
		type = randomNum % 2;
		
		StringBuilder query = new StringBuilder("insert into Crmapidashboard(APIDASHBOARDID,USERID,request_time,response_time,ip_address,module,method,url,request_type,response_status,appid) values (");
		{
			java.util.Date date= new java.util.Date();
			String timeStamp = new Timestamp(date.getTime()).toString();
			rand = new Random();
			randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
			int j = 0;
			if(type == 0)
			{
				int index = randomNum % moduloInfo0[j++];
				query.append(crmAPIDashboardID++).append(",");
				query.append(userIDArray[index].toString()).append(",");
				query.append("'").append(timeStamp).append( "',");
				index = randomNum % moduloInfo0[j++];
				query.append(responseTime[index]).append(",");
				index = randomNum % moduloInfo0[j++];
				query.append("'").append(ipAddress[index]).append("',");
				index = randomNum % moduloInfo0[j++];
				query.append("'").append(module[index]).append("',");
				index = randomNum % moduloInfo0[j++];
				query.append("'").append(oldMethod[index]).append("',");
				index = randomNum % moduloInfo0[j++];
				query.append("'").append(oldURL[index]).append("',");
				index = randomNum % moduloInfo0[j++];
				query.append("'").append(oldReqType[index]).append("',");
				query.append("200,null);");
			}
			else
			{
				int index = randomNum % moduloInfo1[j++];
				query.append(crmAPIDashboardID++).append(",");
				query.append(userIDArray[index].toString()).append(",");
				query.append("'").append(timeStamp).append("',");
				index = randomNum % moduloInfo1[j++];
				query.append(responseTime[index]).append(",");
				index = randomNum % moduloInfo1[j++];
				query.append("'").append(ipAddress[index]).append("',");
				index = randomNum % moduloInfo1[j++];
				query.append("'").append(module[index]).append("',");
				query.append("null,");
				index = randomNum % moduloInfo1[j++];
				query.append("'").append(newURL[index]).append("',");
				index = randomNum % moduloInfo1[j++];
				query.append("'").append(newReqType[index]).append("',");
				index = randomNum % moduloInfo1[j++];
				query.append("'").append(newRespStatus[index]).append("',");
				index = randomNum % moduloInfo1[j++];
				query.append(appID[index]).append(");");
			}
			
			
		}
		//System.out.println("AISHWARYA QUERY IS : \n\n\n"+query);
		return query;
	}
	
	
	public static void insertIntoDB(Statement stmt)
	{
		try
		{
			//for(int j=0;j<200000;j++)
			{
				for(Long i=1L;i<=1366296329;i++)
			    {
			    	  String query = populateAPIDashboard().toString();
			    	  stmt.executeUpdate(query);
			    }
				//System.out.println("Rows inserted Successfully");
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
	}
	
	public static void printApplicationDetails(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***APPLICATION INFORMATION***\n");
			String applicationQuery = "SELECT application_name, count(*) AS count FROM crmapidashboard GROUP BY application_name order by count desc";
			ResultSet applicationResult = stmt.executeQuery(applicationQuery);
			System.out.println("APPLICATION_NAME\t\t\t\t\t\t\t\t\t\t\t| TOTAL\n-----------------------------------------------------------------------------------------------------------------");
			while(applicationResult.next())
			{
				String  applicationName = applicationResult.getString(1);
				int count = applicationResult.getInt(2);
				System.out.println(applicationName+"\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
		
	}
	
	public static void printAccessPointDetails(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***ACCESSPOINT INFORMATION***\n");
			String accessPointQuery = "SELECT ip_address, count(*) AS count FROM crmapidashboard GROUP BY ip_address order by count desc";
			ResultSet accessPointResut = stmt.executeQuery(accessPointQuery);
			System.out.println("IP_ADDRESS\t\t\t| TOTAL\n-----------------------------------------------");
			while(accessPointResut.next())
			{
				String  accessPointName = accessPointResut.getString(1);
				int count = accessPointResut.getInt(2);
				System.out.println(accessPointName+"\t\t\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
		
	}
	
	public static void printTopModulesUsed(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***TOP MODULES USED***\n");
			//String moduleQuery = "SELECT SUBSTRING(url from POSITION('/' in url)+1 for CHAR_LENGTH(url)) as module, COUNT(*) as count from CrmAPIDashboard GROUP BY module ORDER BY count DESC;";
			String moduleQuery = "SELECT name, COUNT(*) as count from CrmAPIDashboard join CrmTab on CrmAPIDashboard.TABID=CrmTab.TABID GROUP BY CrmAPIDashboard.tabid,CrmTab.name ORDER BY count DESC;";
			ResultSet moduleResult = stmt.executeQuery(moduleQuery);
			System.out.println("MODULE\t\t\t| TOTAL\n-------------------------------------");
			while(moduleResult.next())
			{
				String  moduleName = moduleResult.getString(1);
				int count = moduleResult.getInt(2);
				System.out.println(moduleName+"\t\t\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
	}
	
	public static void printTopMethodsUsed(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***TOP METHODS USED***\n");
			String methodQuery = "SELECT method, COUNT(*) as count from CrmAPIDashboard GROUP BY method ORDER BY count DESC;";
			ResultSet methodResult = stmt.executeQuery(methodQuery);
			System.out.println("METHOD\t\t\t| TOTAL\n-------------------------------------");
			while(methodResult.next())
			{
				String  methodName = methodResult.getString(1);
				int count = methodResult.getInt(2);
				System.out.println(methodName+"\t\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
	}
	
	public static void printTopUsers(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***TOP USERS***\n");
			String userQuery = "SELECT userid, count(*) AS count FROM crmapidashboard GROUP BY userid order by count desc";
			ResultSet userResult = stmt.executeQuery(userQuery);
			System.out.println("USER_ID\t\t\t| TOTAL\n-------------------------------------");
			while(userResult.next())
			{
				String  userID = userResult.getString(1);
				int count = userResult.getInt(2);
				System.out.println(userID+"\t\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
	}
	
	public static void printAPIUsageStatistics(Statement stmt)
	{
		try
		{
			System.out.println("\n\n***API USAGE STATISTICS***\n");
			String usageQuery = "SELECT date_trunc('hour', time) as time,count(*) as apicalls from CrmApiDashboard group by date_trunc('hour',time);";
			ResultSet usageResult = stmt.executeQuery(usageQuery);
			System.out.println("TIME\t\t\t\t| APICALLS\n-------------------------------------");
			while(usageResult.next())
			{
				String  hour = usageResult.getString(1);
				int count = usageResult.getInt(2);
				System.out.println(hour+"\t\t| "+count);
			}
		}
		catch (Exception e)
	    {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		}
	}
	
	public static String getCurrentDateOfUser()
	{
		String stringDate;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		stringDate = df.format(date);
		return stringDate;
	}
	
	public static String getDateToDeleteRecords(String currentStringDate)
	{
		String dateStringToDelete="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate;
		try {
			currentDate = sdf.parse(currentStringDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.DATE, -30);
			Date dateToDelete = cal.getTime();
			dateStringToDelete = sdf.format(dateToDelete);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dateStringToDelete;
	}
	
	private static void generateAndPrintCompleteAPILog(Statement stmt) {
		insertIntoDB(stmt);
		  printApplicationDetails(stmt);
		  printAccessPointDetails(stmt);
		  printTopModulesUsed(stmt);
		  printTopMethodsUsed(stmt);
		  printTopUsers(stmt);
		  printAPIUsageStatistics(stmt);
	}*/
	
	 public static void main(String args[])
	 {
	      Connection c = null;
	      Statement stmt = null;
	      try
	      {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sasdb?currentSchema=db1638004db");
	         stmt = c.createStatement();
		      System.out.println("Database opened successfully");
		      PopulateDashboardWithStringIP obj = new PopulateDashboardWithStringIP(stmt);
		      //obj.populateTable();
		      //obj.populateCrmAPIAppDetails();
		      //populateSmartTable(stmt);
		      //PopulateExceptionalUseCases exc= new PopulateExceptionalUseCases(stmt);
		      //exc.populateOldAPIAlone();
		      //exc.populateNewAPIAlone();
		      
		      
		      //String key = "4454628::0:0:0:0:0:0:0:1::null::Contacts::getRecords";
		      
		      Date localDate = new Date();
		      Date gmtDateAlone = null;
		      Date gmtExactDateTime = null;
		      Date newDayZeroMins ;
		      Date newDayFiftyNineMins;
		      
		      DateFormat dfDateAlone = new SimpleDateFormat("yyyy-MM-dd");
		      dfDateAlone.setTimeZone(TimeZone.getTimeZone("Asia/Kabul"));
		      String gmtDateStringAlone = dfDateAlone.format(localDate);
		      
		      DateFormat dfLocalDateAlone = new SimpleDateFormat("yyyy-MM-dd");
		      
		      DateFormat dfExactDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		      dfExactDateTime.setTimeZone(TimeZone.getTimeZone("Asia/Kabul"));
		      String gmtDateStringExact = dfExactDateTime.format(localDate);
		      
		      DateFormat dfLocalExactDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		      
		      String finalDate = null;
		      try
		      {
		    	  gmtDateAlone = dfLocalDateAlone.parse(gmtDateStringAlone);
		    	  gmtExactDateTime = dfLocalExactDateTime.parse(gmtDateStringExact);
		      }
		      catch(Exception e)
		      {
		    	  
		      }
		     
		      Calendar cal = Calendar.getInstance();
		      cal.setTime(gmtDateAlone);
		      cal.set(Calendar.HOUR,0);
		      cal.set(Calendar.MINUTE, 0);
		      cal.set(Calendar.SECOND,0);
		      cal.set(Calendar.MILLISECOND, 0);
		      newDayZeroMins = cal.getTime();
		      cal.add(Calendar.MINUTE, 59);
		      cal.add(Calendar.SECOND, 59);
		      cal.add(Calendar.MILLISECOND, 999);
		      newDayFiftyNineMins = cal.getTime();
		      
		      if(gmtExactDateTime.after(newDayZeroMins) && gmtExactDateTime.before(newDayFiftyNineMins))
		      {
		    	  System.out.println("Check the previous day hash");
		    	  cal.clear();
		    	  cal.setTime(gmtDateAlone);
		    	  cal.add(Calendar.DATE, -1);
		    	  try
		    	  {
		    		  
		    		  finalDate = dfDateAlone.format(cal.getTime());
		    	  }
		    	  catch(Exception e)
		    	  {
		    		  
		    	  }
		      }
		      else
		      {
		    	  System.out.println("Check the today's hash");
		    	  finalDate = gmtDateStringAlone;
		      }
		      
		      
		      
		      System.out.println("Execution is over");
		      stmt.close();
		      c.close();
	      } catch (Exception e)
	      {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		  }
	      
	   }


	 static Long crmAPIDashboardID = 15100000026145L;
	 static String date[] = new String[] {"2016-12-01","2016-12-02","2016-12-03","2016-12-04","2016-12-05","2016-12-06","2016-12-07","2016-12-08","2016-12-09","2016-12-10","2016-12-11","2016-12-12","2016-11-13","2016-11-14","2016-11-15","2016-11-16","2016-11-17","2016-11-18","2016-11-19","2016-11-20","2016-11-21","2016-11-22","2016-11-23","2016-11-24","2016-11-25","2016-11-26","2016-11-27","2016-11-28","2016-11-29","2016-11-30"};
	 static Long userid[] = new Long[] {15000000030132L,15000000041014L,15000000041020L,15000000041026L};
	 static BigInteger ipAddress[] = new BigInteger[] {BigInteger.valueOf(739298814),new BigInteger("4198767102"),new BigInteger("2164785153"),BigInteger.valueOf(935597058),new BigInteger("42540766452641154071740215582052610868"),new BigInteger("297752541649330393411939404370441761588"),new BigInteger("50551894180553405834595368895122505732"),new BigInteger("340277452920730799056913150073516165037")};
	 //static String clientId[] = new String[]{"1000.62IL67N8OLNW65915UNYALPN9F8524","1000.68IL67N8OLNW65915UNYALPN9O8721","1000.62IL67N8OLVX01035UNYALPN9F8524","1000.68IL67N8OLNW65915ABCDEFG9O8721","1000.62IL89B45IAW65915UNYALPN9F8524","1000.01PQ35H8OLNW65915UNYALPN9O8721","1000.62IL67N8XVPK45035UNYALPN9F8524","1000.81AB02L8OLNW65915ABCDEFG9O8721","1000.81IQ02L8OFUK12315ABCDEFF0O8721"};
	 static Long applicationId[] = new Long[] {15110000000001L,15110000000002L,15110000000003L,15110000000004L,15110000000005L,15110000000006L,15110000000007L,15110000000008L,15110000000009L};
	 static String module[] = new String[] {"Leads","Contacts","Potentials","Campaigns","Cases","Solutions","SalesOrders"};
	 static String method[] = new String[] {"getDeletedRecordIds","getACRecords","getRecycleBinRecords","getRecordsForSync","getSearchRecords"};
	 static int moduloInfo[] = new int[] {4,8,9,7,5};
	 
	 public static StringBuilder populateAPIDashboardSmart(int dateIndex)
		{
			randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
			type = randomNum % 2;
			
			StringBuilder query = new StringBuilder("insert into crmapidashboard(APIDASHBOARDID,DATE,USERID,IPADDRESS,APPLICATIONID,MODULE,METHOD,TOTALCALLS) values (");
			{
				rand = new Random();
				randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
				int j = 0;
				if(type == 0)
				{
					query.append(crmAPIDashboardID++).append(",'").append(date[dateIndex]).append("',");
					int index = randomNum % moduloInfo[j++];
					query.append(userid[index].toString()).append(",");
					index = randomNum % moduloInfo[j++];
					query.append(ipAddress[index]).append(",");
					index = randomNum % moduloInfo[j++];
					//query.append("'',");
					query.append("null,");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(module[index]).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(method[index]).append("',");
					query.append(randomNum % 1000);
					query.append(");");
				}
				else
				{
					query.append(crmAPIDashboardID++).append(",'").append(date[dateIndex]).append("',");
					int index = randomNum % moduloInfo[j++];
					query.append(userid[index].toString()).append(",");
					index = randomNum % moduloInfo[j++];
					query.append(ipAddress[index]).append(",");
					index = randomNum % moduloInfo[j++];
					//query.append("'").append(clientId[index]).append("',");
					query.append(applicationId[index]).append(",");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(module[index]).append("',");
					query.append("'',");
					query.append(randomNum % 1000);
					query.append(");");
				}
			}
			return query;
		}
	
	public static void populateSmartTable(Statement stmt)
	{
		for(int i=0;i<date.length;i++)
		{
			for(int j=0;j<1000;j++)
			{
				String query = populateAPIDashboardSmart(i).toString();
				try
				{
					stmt.executeUpdate(query);
				}
				catch(Exception e)
				{
					System.out.println("Exception occured while inserting using query: "+query+" Reason: "+e.toString());
				}
			}
		}
		
	}
	
	
}
