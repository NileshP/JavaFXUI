package com.hack.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class DBUtil {

	MongoClient mongo;
	DB db;

	@SuppressWarnings("deprecation")
	public DBUtil() {

		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("BPODB");
	}

	public void insertData(String jsonData) {

		try {

			DBCollection collection = db.getCollection("TweetsCollection");
			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(jsonData);
			collection.insert(dbObject);

			//System.out.println("Done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void insertIntoTimeSeriesReport(String timeSeriesJson){
	
		try {

			//System.out.println("inserting into timeseries");
			DBCollection collection = db.getCollection("TimeSeriesReportCollection");
			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(timeSeriesJson);
			collection.insert(dbObject);

			//System.out.println("Done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void insertUserMentionEntities(String userMentionJson) {
	
		try {

			//System.out.println("inserting into timeseries");
			DBCollection collection = db.getCollection("UserMentionCollection");
			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(userMentionJson);
			collection.insert(dbObject);

			//System.out.println("Done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void insertTagData(String tagJson) {
	
		try {

			//System.out.println("inserting into timeseries");
			DBCollection collection = db.getCollection("TagsCollection");
			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(tagJson);
			collection.insert(dbObject);

			//System.out.println("Done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void confirmSupport(String inReplyToStatusId) {
	
		try {

			//System.out.println("inserting into timeseries");
			DBCollection collection = db.getCollection("TimeSeriesReportCollection");
			// convert JSON to DBObject directly
			/*DBObject dbObjectQuery = (DBObject) JSON.parse("{\"id\":\""+inReplyToStatusId+"\"}");
			DBObject dbObjectupdate = (DBObject) JSON.parse("{\"replied\":\"Y\"}");*/
			
			BasicDBObject updateDocument = new BasicDBObject();
			  updateDocument.append("$set", new BasicDBObject().append("replied", "Y"));

			  BasicDBObject searchQuery2 = new BasicDBObject().append("id", inReplyToStatusId);

			  collection.update(searchQuery2, updateDocument);

			//System.out.println("Done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
