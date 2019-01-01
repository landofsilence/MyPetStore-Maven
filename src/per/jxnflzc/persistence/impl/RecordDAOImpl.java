package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Record;
import per.jxnflzc.persistence.RecordDAO;
import per.jxnflzc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
public class RecordDAOImpl implements RecordDAO {
	private static String INSERT_RECORD = "INSERT INTO record (userid, actionType, date, id, count) VALUES (?, ?, ?, ?, ?)";
	private static String GET_RECORD_LIST = "SELECT * FROM record WHERE userid = ?";
	private static String GET_RECORD = "SELECT * FROM record WHERE recordId = ?";
	@Override
	public boolean InsertRecord(Record record) {
		int success = 0;
		try {
			System.out.println("record.getDate() = " + record.getDate());
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECORD);
			preparedStatement.setString(1, record.getUserId());
			preparedStatement.setInt(2, record.getActionType());
			preparedStatement.setTimestamp(3, new Timestamp(record.getDate().getTime()));
			preparedStatement.setString(4, record.getId());
			preparedStatement.setInt(5, record.getCount());
			success = preparedStatement.executeUpdate();

			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);

		} catch (Exception e){
		System.out.println(e.toString());
		}
		return success > 0;
	}

	@Override
	public List<Record> getRecordList(String userId) {
		List<Record> recordList = new ArrayList<Record>();

		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_RECORD_LIST);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				Record record = new Record();
				record.setRecordId(resultSet.getInt(1));
				record.setUserId(resultSet.getString(2));
				record.setActionType(resultSet.getInt(3));
				record.setDate(new Date(resultSet.getTimestamp(4).getTime()));
				record.setId(resultSet.getString(5));
				record.setCount(resultSet.getInt(6));
				recordList.add(record);
			}

			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);

		} catch (Exception e){

		}

		return recordList;
	}

	@Override
	public Record getRecord(String recordId) {
		Record record = null;

		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_RECORD);
			preparedStatement.setString(1, recordId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				record.setRecordId(resultSet.getInt(1));
				record.setUserId(resultSet.getString(2));
				record.setActionType(resultSet.getInt(3));
				record.setDate(new Date(resultSet.getTimestamp(4).getTime()));
				record.setId(resultSet.getString(5));
				record.setCount(resultSet.getInt(6));
			}

			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);

		} catch (Exception e){

		}

		return record;
	}
}
