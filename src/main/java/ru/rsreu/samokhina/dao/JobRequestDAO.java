package ru.rsreu.samokhina.dao;

import ru.rsreu.samokhina.entity.Count;
import ru.rsreu.samokhina.entity.JobRequest;
import ru.rsreu.samokhina.entity.JobType;
import ru.rsreu.samokhina.entity.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobRequestDAO {
	Connection connection;

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<JobRequest> selectJobRequests() throws SQLException {
		List<JobRequest> jobRequests = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.jobrequest.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			jobRequests.add(new JobRequest(result.getInt("reqid"),
					result.getDate("startDate"),
					result.getDate("endDate"),
					new JobType(result.getInt("typeid"), result.getString("typetitle")),
					result.getString("description"),
					new State(result.getInt("stateid"), result.getString("statetitle")),
					result.getInt("initiator")));
		}
		connection.close();

		return jobRequests;
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<JobRequest> selectUserJobRequests(int userId) throws SQLException {
		List<JobRequest> jobRequests = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.jobrequest.select.user");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			jobRequests.add(new JobRequest(result.getInt("reqid"),
					result.getDate("startDate"),
					result.getDate("endDate"),
					new JobType(result.getInt("typeid"), result.getString("typetitle")),
					result.getString("description"),
					new State(result.getInt("stateid"), result.getString("statetitle")),
					result.getInt("initiator")));
		}
		connection.close();

		return jobRequests;
	}

	/**
	 *
	 * @param expertId
	 * @return
	 * @throws SQLException
	 */
	public List<JobRequest> selectExpertConfirmJobRequests(int expertId) throws SQLException {
		List<JobRequest> jobRequests = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.jobrequest.select.forexpertconfirm");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expertId);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			jobRequests.add(new JobRequest(result.getInt("reqid"),
					result.getDate("startDate"),
					result.getDate("endDate"),
					new JobType(result.getInt("typeid"), result.getString("typetitle")),
					result.getString("description"),
					new State(result.getInt("stateid"), result.getString("statetitle")),
					result.getInt("initiator")));
		}
		connection.close();

		return jobRequests;
	}

	/**
	 *
	 * @param reqId
	 * @return
	 * @throws SQLException
	 */
	public List<JobRequest> selectJobRequestById(int reqId) throws SQLException {
		List<JobRequest> jobRequests = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.jobrequest.select.byid");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, reqId);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			jobRequests.add(new JobRequest(result.getInt("reqid"),
					result.getDate("startDate"),
					result.getDate("endDate"),
					new JobType(result.getInt("typeid"), result.getString("typetitle")),
					result.getString("description"),
					new State(result.getInt("stateid"), result.getString("statetitle")),
					result.getInt("initiator")));
		}
		connection.close();

		return jobRequests;
	}

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<JobRequest> selectNoExpertJobRequests() throws SQLException {
		List<JobRequest> jobRequests = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.jobrequest.select.noexperts");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			jobRequests.add(new JobRequest(result.getInt("reqid"),
					result.getDate("startDate"),
					result.getDate("endDate"),
					new JobType(result.getInt("typeid"), result.getString("typetitle")),
					result.getString("description"),
					new State(result.getInt("stateid"), result.getString("statetitle")),
					result.getInt("initiator")));
		}
		connection.close();

		return jobRequests;
	}

	/**
	 *
	 * @param startDate
	 * @param endDate
	 * @param jobTypeId
	 * @param description
	 * @param initiatorUserId
	 * @throws SQLException
	 */
	public void addRequest(Date startDate, Date endDate, int jobTypeId,
						   String description, int initiatorUserId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.add");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDate(1, startDate);
		statement.setDate(2, endDate);
		statement.setInt(3, jobTypeId);
		statement.setString(4, description);
		statement.setInt(5, initiatorUserId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param reqId
	 * @param expertId
	 * @throws SQLException
	 */
	public void addExpert(int reqId, int expertId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.expertgroup.addexpert");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, reqId);
		statement.setInt(2, expertId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param reqId
	 * @throws SQLException
	 */
	public void updateStateOnExpert(int reqId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.update.state.onexpert");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, reqId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param startDate
	 * @param endDate
	 * @param description
	 * @param id
	 * @throws SQLException
	 */
	public void updateRequest(Date startDate, Date endDate, String description, int id) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.update.entity");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDate(1, startDate);
		statement.setDate(2, endDate);
		statement.setString(3, description);
		statement.setInt(4, id);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param id
	 * @param expertCount
	 * @throws SQLException
	 */
	public void setExpertCount(int id, int expertCount) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.set.expertcount");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expertCount);
		statement.setInt(2, id);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @throws SQLException
	 */
	public void setConfirmToAll() throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.set.confirm.state");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @throws SQLException
	 */
	public void setRefuseToAll() throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.set.refuse.state");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param id
	 * @throws SQLException
	 */
	public void setApproveCount(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.set.approvecount");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param id
	 * @throws SQLException
	 */
	public void setRefuseCount(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobrequest.set.refusecount");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param expertId
	 * @param reqId
	 * @throws SQLException
	 */
	public void approveRequest(int expertId, int reqId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.expertgroup.approve");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expertId);
		statement.setInt(2, reqId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param expertId
	 * @param reqId
	 * @throws SQLException
	 */
	public void refuseRequest(int expertId, int reqId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.expertgroup.refuse");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expertId);
		statement.setInt(2, reqId);
		statement.executeUpdate();

		connection.close();
	}
}
