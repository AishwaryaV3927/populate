//$Id$
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulateExceptionalUseCases {
	
	public static Statement stmt;
	static int type = 0;
	static Random rand = new Random();
	static int randomNum ;
	
	static Long crmAPIDashboardID = 25010000000001L;
	static Long date[] = new Long[] {1480550400L,1480636800L};//,1480723200L,1480809600L,1480896000L,1480982400L,1481068800L,1481155200L,1481241600L,1481328000L,1481414400L,1481500800L,1481587200L,1481673600L,1481760000L,1481846400L,1481932800L,1482019200L,1482105600L,1482192000L,1482278400L,1482364800L,1482451200L,1482537600L,1482624000L,1482710400L,1482796800L,1482883200L,1482969600L,1483056000L};
	static Long userid[] = new Long[] {25000000030320L,25000000030525L,25000000030533L,25000000030539L};
	static String ipAddress[] = new String[] {"172.16.205.254","122.68.25.254","1.8.0.1","183.196.20.2","2001:0db8:85a3:0000:0000:8a2e:0370:7334","e001:0db8:98fa:0000:8765:8a2e:abcd:7334","2607:f0d0:1002:0051:0000:0000:0000:0004","ffff:0db8:98fa:2371:8765:8a2e:abcd:87ad"};
	static Long applicationId[] = new Long[] {25100000000001L,25100000000002L,25100000000003L,25100000000004L,25100000000005L,25100000000006L,25100000000007L,25100000000008L};
	static String module[] = new String[] {"Leads","Contacts","Potentials","Campaigns","Cases","Solutions","SalesOrders"};
	static String method[] = new String[] {"getDeletedRecordIds","getACRecords","getRecycleBinRecords","getRecordsForSync","getSearchRecords"};
	static int moduloInfo[] = new int[] {userid.length,ipAddress.length,applicationId.length,module.length,method.length};
	
	public PopulateExceptionalUseCases(Statement stmt)
	{
		PopulateExceptionalUseCases.stmt = stmt;
	}
	
	
	
	 /*private static StringBuilder populateAPIDashboard(int dateIndex, int hourValue)
		{
			randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
			type = randomNum % 2;
			
			//StringBuilder query = new StringBuilder("insert into crmapidashboarddummy(APIDASHBOARDID,DATE,USERID,IPADDRESS,CLIENTID,MODULE,METHOD,TOTALCALLS) values (");
			StringBuilder query = new StringBuilder("insert into CrmFeatureUsageCounter(USAGEID,FEATUREID,TRACKINGID1,TRACKINGID2,TRACKINGID3,TRACKINGID4,TRACKINGID5,TRACKINGID6,USAGECOUNT,USAGEDATE) values (");
			{
				rand = new Random();
				randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
				int j = 0;
				if(type == 0)
				{
					query.append(crmAPIDashboardID++).append(",");
					query.append("3,");
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
					query.append(String.valueOf(hourValue)).append(",");
					query.append(randomNum % 1000).append(",");
					query.append(date[dateIndex]);
					query.append(");");
				}
				else
				{
					query.append(crmAPIDashboardID++).append(",");
					query.append("3,");
					int index = randomNum % moduloInfo[j++];
					query.append("'").append(userid[index].toString()).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(ipAddress[index]).append("'").append(",");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(applicationId[index]).append("',");
					//query.append("'").append(clientId[index]).append("',");
					index = randomNum % moduloInfo[j++];
					query.append("'").append(module[index]).append("',");
					query.append("'',").append(String.valueOf(hourValue)).append(",");
					query.append(randomNum % 1000).append(",");
					query.append(date[dateIndex]);
					query.append(");");
				}
				
			}
			return query;
		}
	 */

	 
	 public void populateOldAPIAlone()
	 {
		 for(int i=0;i<date.length;i++)
		 {
			 for(int j=0;j<8;j++)
			 {
				 String query = getOldAPIAloneQuery(i,j).toString();
				 try
				 {
					 stmt.executeUpdate(query);
				 }
				 catch(Exception e)
				 {
					 System.out.println("Exception in query "+query);
				 }
			 }
		 }
		
	 }

	private StringBuilder getOldAPIAloneQuery(int dateIndex, int hourValue) {
		randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
		StringBuilder query = new StringBuilder("insert into crmfeatureusagecounterOldAPIAlone(USAGEID,FEATUREID,TRACKINGID1,TRACKINGID2,TRACKINGID3,TRACKINGID4,TRACKINGID5,TRACKINGID6,USAGECOUNT,USAGEDATE) values (");
		 int j = 0;
			query.append(crmAPIDashboardID++).append(",");
			query.append("3,");
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
			query.append(String.valueOf(hourValue)).append(",");
			query.append(randomNum % 1000).append(",");
			query.append(date[dateIndex]);
			query.append(");");
			return query;
	}
	
	public void populateNewAPIAlone()
	 {
		 for(int i=0;i<date.length;i++)
		 {
			 for(int j=0;j<8;j++)
			 {
				 String query = getOldNewAPIAloneQuery(i,j).toString();
				 try
				 {
					 stmt.executeUpdate(query);
				 }
				 catch(Exception e)
				 {
					 System.out.println("Exception in query "+query);
				 }
			 }
		 }
		
	 }
	
	private StringBuilder getOldNewAPIAloneQuery(int dateIndex, int hourValue) {
		randomNum = rand.nextInt((1000000 - 10) + 1) + 10;
		StringBuilder query = new StringBuilder("insert into crmfeatureusagecounterNewAPIAlone(USAGEID,FEATUREID,TRACKINGID1,TRACKINGID2,TRACKINGID3,TRACKINGID4,TRACKINGID5,TRACKINGID6,USAGECOUNT,USAGEDATE) values (");
		 int j = 0;
			query.append(crmAPIDashboardID++).append(",");
			query.append("3,");
			int index = randomNum % moduloInfo[j++];
			query.append("'").append(userid[index].toString()).append("',");
			index = randomNum % moduloInfo[j++];
			query.append("'").append(ipAddress[index]).append("'").append(",");
			index = randomNum % moduloInfo[j++];
			query.append("'").append(applicationId[index]).append("',");
			index = randomNum % moduloInfo[j++];
			query.append("'").append(module[index]).append("',");
			query.append("'',").append(String.valueOf(hourValue)).append(",");
			query.append(randomNum % 1000).append(",");
			query.append(date[dateIndex]);
			query.append(");");
			return query;
	}

}
