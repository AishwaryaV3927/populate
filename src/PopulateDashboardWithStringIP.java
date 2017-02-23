//$Id$
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

public class PopulateDashboardWithStringIP {
	
	public static Statement stmt;
	static int type = 0;
	static Random rand = new Random();
	static int randomNum ;
	
	static Long crmAPIDashboardID = 25010000000001L;
	//static String date[] = new String[] {"2016-11-01","2016-11-02","2016-11-03","2016-11-04","2016-11-05","2016-11-06","2016-11-07","2016-11-08","2016-11-09","2016-11-10","2016-11-11","2016-11-12","2016-11-13","2016-11-14","2016-11-15","2016-11-16","2016-11-17","2016-11-18","2016-11-19","2016-11-20","2016-11-21","2016-11-22","2016-11-23","2016-11-24","2016-11-25","2016-11-26","2016-11-27","2016-11-28","2016-11-29","2016-11-30"};
	//static Long date[] = new Long[] {1480550400L,1480636800L,1480723200L,1480809600L,1480896000L,1480982400L,1481068800L,1481155200L,1481241600L,1481328000L,1481414400L,1481500800L,1481587200L,1481673600L,1481760000L,1481846400L,1481932800L,1482019200L,1482105600L,1482192000L,1482278400L,1482364800L,1482451200L,1482537600L,1482624000L,1482710400L,1482796800L,1482883200L,1482969600L,1483056000L};
	//static Long date[] = new Long[] {201611010501L,201611012001L,201611020800L,201611021000L,201611021001L,201611030301L,201611030601L,201611030600L,201611042300L,201611041801L,201611050601L,201611060000L,201611061500L,201611061801L,201611062000L,201611062201L,201611070401L,201611070901L,201611070900L,201611202001L,201611202200L,201611202201L,201611210400L,201611210800L,201611231500L,201611231501L,201611241201L,201611241700L,201611241800L,201611241801L};
	//static Long date[] = new Long[] {201612011700L,201612011701L,201612011800L,201612011801L,201612011900L,201612011901L,201612012000L,201612012001L,201612012100L,201612012101L,201612012200L,201612012201L,201612012300L,201612012301L,201612020000L,201612020001L,201612020100L,201612020101L,201612020200L,201612020201L,201612020300L,201612020301L,201612020400L,201612020401L,201612020500L,201612020501L,201612020600L,201612020601L,201612020700L,201612020701L,201612020800L,201612020801L,201612020900L,201612020901L,201612021000L,201612021001L,201612021100L,201612021101L,201612021200L,201612021201L,201612021300L,201612021301L,201612021400L,201612021401L,201612021500L,201612021501L,201612021600L,201612021601L,201612021700L,201612021701L,201612021800L,201612021801L,201612021900L,201612021901L,201612022000L,201612022001L,201612022100L,201612022101L,201612022200L,201612022201L,201612022300L,201612022301L,201612030000L,201612030001L,201612030100L,201612030101L,201612030200L,201612030201L,201612030300L,201612030301L,201612030400L,201612030401L,201612030500L,201612030501L,201612030600L,201612030601L,201612030700L,201612030701L,201612030800L,201612030801L,201612030900L,201612030901L,201612031000L,201612031001L,201612031100L,201612031101L,201612031200L,201612031201L,201612031300L,201612031301L,201612031400L,201612031401L,201612031500L,201612031501L,201612031600L,201612031601L,201612031700L,201612031701L,201612031800L,201612031801L,201612031900L,201612031901L};
	//static Long date[] = new Long[] {201612011800L,201612011801L,201612011900L,201612011901L,201612012000L,201612012001L,201612012100L,201612012101L,201612012200L,201612012201L,201612012300L,201612012301L,201612020000L,201612020001L,201612020100L,201612020101L,201612020200L,201612020201L,201612020300L,201612020301L,201612020400L,201612020401L,201612020500L,201612020501L,201612020600L,201612020601L,201612020700L,201612020701L,201612020800L,201612020801L,201612020900L,201612020901L,201612021000L,201612021001L,201612021100L,201612021101L,201612021200L,201612021201L,201612021300L,201612021301L,201612021400L,201612021401L,201612021500L,201612021501L,201612021600L,201612021601L,201612021700L,201612021701L,201612021800L,201612021801L};
	//static Long date[] = new Long[] {201612021801L,201612021900L,201612021901L,201612022000L,201612022001L,201612022100L,201612022101L,201612022200L,201612022201L,201612022300L,201612022301L,201612030000L,201612030001L,201612030100L,201612030101L,201612030200L,201612030201L,201612030300L,201612030301L,201612030400L,201612030401L,201612030500L,201612030501L,201612030600L,201612030601L,201612030700L,201612030701L,201612030800L,201612030801L,201612030900L,201612030901L,201612031000L,201612031001L,201612031100L,201612031101L,201612031200L,201612031201L,201612031300L,201612031301L,201612031400L,201612031401L,201612031500L,201612031501L,201612031600L,201612031601L,201612031700L,201612031701L,201612031800L};
	static Long date[] = new Long[] {1480557600000L,1480588200000L,1480611600000L,1480644000000L,1480674600000L,1480698000000L,1480730400000L,1480761000000L,1480784400000L,1480816800000L,1480847400000L,1480870800000L,1480903200000L,1480933800000L,1480957200000L,1480989600000L,1481020200000L,1481043600000L,1481076000000L,1481106600000L,1481130000000L,1481162400000L,1481193000000L,1481216400000L,1481248800000L,1481279400000L,1481302800000L,1481335200000L,1481365800000L,1481389200000L,1481421600000L,1481452200000L,1481475600000L,1481508000000L,1481538600000L,1481562000000L,1481594400000L,1481625000000L,1481648400000L,1481680800000L,1481711400000L,1481734800000L,1481767200000L,1481797800000L,1481821200000L,1481853600000L,1481884200000L,1481907600000L,1481940000000L,1481970600000L,1481994000000L,1482026400000L,1482057000000L,1482080400000L,1482112800000L,1482143400000L,1482166800000L,1482199200000L,1482229800000L,1482253200000L,1482285600000L,1482316200000L,1482339600000L,1482372000000L,1482402600000L,1482426000000L,1482458400000L,1482489000000L,1482512400000L,1482544800000L,1482575400000L,1482598800000L,1482631200000L,1482661800000L,1482685200000L,1482717600000L,1482748200000L,1482771600000L,1482804000000L,1482834600000L,1482858000000L,1482890400000L,1482921000000L,1482944400000L,1482976800000L,1483007400000L,1483030800000L,1483063200000L,1483093800000L,1483117200000L,1483149600000L,1483180200000L,1483203600000L};
//	static int hour[] = new int[] {2,8,15};
	//static Long date[] = populateDate("2017-01-01",30);
	static Long userid[] = new Long[] {25000000030320L,25000000030525L,25000000030533L,25000000030539L};
	static String ipAddress[] = new String[] {"172.16.205.254","122.68.25.254","1.8.0.1","183.196.20.2","2001:0db8:85a3:0000:0000:8a2e:0370:7334","e001:0db8:98fa:0000:8765:8a2e:abcd:7334","2607:f0d0:1002:0051:0000:0000:0000:0004","ffff:0db8:98fa:2371:8765:8a2e:abcd:87ad","108.26.149.203"};
	//static Long applicationId[] = new Long[] {15110000000001L,15110000000002L,15110000000003L,15110000000004L,15110000000005L,15110000000006L,15110000000007L,15110000000008L,15110000000009L};
	static Long applicationId[] = new Long[] {25100000000001L,25100000000002L,25100000000003L,25100000000004L,25100000000005L,25100000000006L,25100000000007L,25100000000008L};
	//static String clientId[] = new String[]{"1000.62IL67N8OLNW65915UNYALPN9F8524","1000.68IL67N8OLNW65915UNYALPN9O8721","1000.62IL67N8OLVX01035UNYALPN9F8524","1000.68IL67N8OLNW65915ABCDEFG9O8721","1000.62IL89B45IAW65915UNYALPN9F8524","1000.01PQ35H8OLNW65915UNYALPN9O8721","1000.62IL67N8XVPK45035UNYALPN9F8524","1000.81AB02L8OLNW65915ABCDEFG9O8721","1000.81IQ02L8OFUK12315ABCDEFF0O8721"};
	static String module[] = new String[] {"Leads","Contacts","Potentials","Campaigns","Cases","Solutions","SalesOrders","Accounts","Vendors"};
	static String method[] = new String[] {"getDeletedRecordIds","getACRecords","getRecycleBinRecords","getRecordsForSync","getSearchRecords","insertRecords","updateRecords","deleteRecords"};
	static int moduloInfo[] = new int[] {userid.length,ipAddress.length,applicationId.length,module.length,method.length};
	
	public PopulateDashboardWithStringIP(Statement stmt)
	{
		PopulateDashboardWithStringIP.stmt = stmt;
	}
	
	public static Long[] populateDate(String startingDate,int totalNoOfDays)
	{
		int hour[] = new int[] {2,8,15};
		List<Long> longDate = new ArrayList<Long>();
		Long date[] = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date start = null;
		try
		{
			start = df.parse(startingDate);
		}
		catch(Exception e)
		{
			
		}
		//convert the mentioned date to Long and add it into date[]
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		longDate.add(cal.getTimeInMillis());
		for(int j =0;j<hour.length;j++)
		{
			cal.add(Calendar.HOUR, hour[j++]);
			longDate.add(cal.getTimeInMillis());
			cal.setTime(start);
		}
		
		for(int i=1;i<=totalNoOfDays;i++)
		{
			//add one day and obtain the new day
			cal.add(Calendar.DATE, 1);
			//assign new day to the mentioned day
			start = cal.getTime();
			
			//convert the calculated date to Long and add it into date[]
			cal.setTime(start);
			longDate.add(cal.getTimeInMillis());
		}
		date = (Long[]) longDate.toArray();
		return date;
	}
	
	public void populateTable()
	{
		for(int i=0;i<date.length;i++)
		{
			for(int j=0;j<5;j++)
			{
				//for(int k=0;k<=23;k++)
				//{
					String query = populateAPIDashboard(i).toString();
					try
					{
						stmt.executeUpdate(query);
					}
					catch(Exception e)
					{
						System.out.println("Exception occured while inserting using query: "+query+" Reason: "+e.toString());
					}
				//}
			}
		}
	}
	
	 private static StringBuilder populateAPIDashboard(int dateIndex)
		{
			randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
			type = randomNum % 2;
			
			//StringBuilder query = new StringBuilder("insert into crmapidashboarddummy(APIDASHBOARDID,DATE,USERID,IPADDRESS,CLIENTID,MODULE,METHOD,TOTALCALLS) values (");
			StringBuilder query = new StringBuilder("insert into CrmFeatureUsageCounter(USAGEID,FEATUREID,TRACKINGFIELD1,TRACKINGFIELD2,TRACKINGFIELD3,TRACKINGFIELD4,TRACKINGFIELD5,USAGECOUNT,USAGEDATE) values (");
			{
				rand = new Random();
				randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
				int j = 0;
				if(type == 0)
				{
					query.append(crmAPIDashboardID++).append(",");
					query.append("4,");
					int index = randomNum % moduloInfo[j++];
					query.append("'").append(userid[index].toString()).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(ipAddress[index]).append("'").append(",");
					index = randomNum % moduloInfo[j++];
					query.append("'',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(module[index]).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(method[index]).append("',");
					//query.append(String.valueOf(hourValue)).append(",");
					query.append(randomNum % 1000).append(",");
					//query.append(3).append(",");
					query.append(date[dateIndex]);
					query.append(");");
				}
				else
				{
					query.append(crmAPIDashboardID++).append(",");
					query.append("4,");
					int index = randomNum % moduloInfo[j++];
					query.append("'").append(userid[index].toString()).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(ipAddress[index]).append("'").append(",");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(applicationId[index]).append("',");
					//query.append("'").append(clientId[index]).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(module[index]).append("',");
					query.append("'',");
					//query.append(String.valueOf(hourValue)).append(",");
					query.append(randomNum % 1000).append(",");
					//query.append(3).append(",");
					query.append(date[dateIndex]);
					query.append(");");
				}
				
			}
			return query;
		}
	 
	 public void populateCrmAPIAppDetails()
	 {
		 List<String> queries = new ArrayList<String>();
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000001,'1000.62IL67N8OLNW65915UNYALPN9F8524','Flipkart');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000002,'1000.68IL67N8OLNW65915UNYALPN9O8721','HackerRank');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000003,'1000.62IL67N8OLVX01035UNYALPN9F8524','Sakura');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000004,'1000.68IL67N8OLNW65915ABCDEFG9O8721','Snapdeal');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000005,'1000.62IL89B45IAW65915UNYALPN9F8524','eBay');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000006,'1000.01PQ35H8OLNW65915UNYALPN9O8721','Whatsapp');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000007,'1000.62IL67N8XVPK45035UNYALPN9F8524','Amazon');");
		 queries.add("insert into crmapiappdetails (applicationid,clientid,applicationname) values(25100000000008,'1000.81AB02L8OLNW65915ABCDEFG9O8721','HDFC');");
		 for(int i=0;i<queries.size();i++)
		 {
			 try
			 {
				 stmt.executeUpdate(queries.get(i));
			 }
			 catch(Exception e)
			 {
				 System.out.println("Exception in query "+queries.get(i));
			 }
		 }
	 }

}
