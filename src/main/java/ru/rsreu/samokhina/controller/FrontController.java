package ru.rsreu.samokhina.controller;

import ru.rsreu.samokhina.dao.*;
import ru.rsreu.samokhina.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {
	public final static String ADMIN_URL = "/samokhina/jobrequest?action=admin";
	public final static String MODERATOR_URL = "/samokhina/jobrequest?action=moderator";
	public final static String USER_URL = "/samokhina/jobrequest?action=user";
	public final static String LOGIN_URL = "/samokhina/jobrequest?action=login";

	private HttpSession session;
	private User user;
	private UserDAO userDAO = new UserDAO();
	private RoleDAO roleDAO = new RoleDAO();
	private JobTypeDAO jobTypeDAO = new JobTypeDAO();
	private StateDAO stateDAO = new StateDAO();
	private JobRequestDAO jobRequestDAO = new JobRequestDAO();

	/**
	 * Method Get
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
				case "login":
					request.getRequestDispatcher("pages/login.jsp").forward(request, response);
					break;
				case "admin":
					if(session!=null) {
						User ses = (User)session.getAttribute("user");
						if(ses != null) {
							System.out.println("session yes");
							if ("Administrator".equals(user.getRole().getTitle())) {
								try {
									List<User> users = userDAO.selectUsers();
									List<Role> roles = roleDAO.selectRoles();

									request.setAttribute("users", users);
									request.setAttribute("roles", roles);
									request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} else response.sendRedirect(LOGIN_URL);
						}
					} else response.sendRedirect(LOGIN_URL);
					break;
				case "moderator":
					if(session!=null) {
						User ses = (User)session.getAttribute("user");
						if(ses != null) {
							System.out.println("session yes");
							if ("Moderator".equals(user.getRole().getTitle())) {
								try {
									List<JobType> jobTypes = jobTypeDAO.selectJobTypes();
									request.setAttribute("types", jobTypes);
									List<State> states = stateDAO.selectStates();
									request.setAttribute("states", states);
									List<JobRequest> jobRequestsNoExpert = jobRequestDAO.selectNoExpertJobRequests();
									request.setAttribute("requests", jobRequestsNoExpert);
									request.getRequestDispatcher("pages/moderator.jsp").forward(request, response);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} else response.sendRedirect(LOGIN_URL);
						} else response.sendRedirect(LOGIN_URL);
					}

					break;
				case "user":
					if(session!=null) {
						User ses = (User)session.getAttribute("user");
						if(ses != null) {
							System.out.println("session yes");
							if ("User".equals(user.getRole().getTitle())) {
								try {
									jobRequestDAO.setConfirmToAll();
									jobRequestDAO.setRefuseToAll();
									List<JobRequest> userRequests = jobRequestDAO.selectUserJobRequests(user.getId());
									request.setAttribute("requests", userRequests);
									List<JobRequest> requestsForConfirm = jobRequestDAO.selectExpertConfirmJobRequests(user.getId());
									request.setAttribute("requestsForConfirm", requestsForConfirm);
									List<JobType> jobTypes = jobTypeDAO.selectJobTypes();
									request.setAttribute("types", jobTypes);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								request.getRequestDispatcher("pages/user.jsp").forward(request, response);
							} else response.sendRedirect(LOGIN_URL);
						}
					} else response.sendRedirect(LOGIN_URL);
					break;
				case "expertgroup":
					request.getRequestDispatcher("pages/expertgroup.jsp").forward(request, response);
					break;
				case "editrequest":
					System.out.println("get edit request");
					int editedId = Integer.parseInt(request.getParameter("getEditedId"));
					try {
						List<JobRequest> jobRequest = jobRequestDAO.selectJobRequestById(editedId);
						request.setAttribute("jobRequest", jobRequest.get(0));


					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
	}

	/**
	 * Method Post
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
				case "login":
					try {
						String login = request.getParameter("login");
						String password = request.getParameter("password");
						System.out.println(login);
						System.out.println(password);
						user = userDAO.checkAccess(login, password);
						if (user != null) {
							String roleTitle = user.getRole().getTitle();
							session = request.getSession();
							session.setAttribute("user", user);
							switch (roleTitle) {
								case "User":
									response.sendRedirect(USER_URL);
									break;
								case "Administrator":
									response.sendRedirect(ADMIN_URL);
									break;
								case "Moderator":
									response.sendRedirect(MODERATOR_URL);
									break;
								default:
									response.sendRedirect(LOGIN_URL);
									break;
							}
						} else response.sendRedirect(LOGIN_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "adminadduser":
					try {
						String userName = request.getParameter("name");
						String login = request.getParameter("login");
						String password = request.getParameter("password");
						String roleTitle = request.getParameter("role");
						Role role = roleDAO.getRoleByTitle(roleTitle);
						userDAO.addUser(userName, login, password, role.getId());
						response.sendRedirect(ADMIN_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "adminedituser":
					String editedUserId = request.getParameter("getEditedId");
					try {
							User editedUser = userDAO.getUserById(Integer.parseInt(editedUserId));
							request.setAttribute("editedUser", editedUser);
							request.getRequestDispatcher("pages/edituser.jsp").forward(request, response);

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "useredited":
					String newUserName = request.getParameter("name");
					String newUserLogin = request.getParameter("login");
					String newPassword = request.getParameter("password");
					String userId = request.getParameter("editedUserId");
					try {
						userDAO.updateUser(newUserName, newUserLogin, newPassword, Integer.parseInt(userId));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(ADMIN_URL);
					break;
				case "admindeleteuser":
					String deletedUserId = request.getParameter("getDeletedId");
					try {
						userDAO.deleteUser(Integer.parseInt(deletedUserId));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(ADMIN_URL);
					break;
				case "addjobtype":
					try {
						String typeTitle = request.getParameter("typetitle");
						jobTypeDAO.addType(typeTitle);
						response.sendRedirect(MODERATOR_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "addjobstate":
					try {
						String stateTitle = request.getParameter("statetitle");
						stateDAO.addState(stateTitle);
						response.sendRedirect(MODERATOR_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "chooseexperts":
					String requestId = request.getParameter("getReqId");
					try {
						List<JobRequest> jobRequests = jobRequestDAO.selectJobRequestById(Integer.parseInt(requestId));
						request.setAttribute("req", jobRequests.get(0));
						List<User> experts = userDAO.selectExperts();
						request.setAttribute("experts", experts);
						request.getRequestDispatcher("pages/expertgroup.jsp").forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "assignexpertgroup":
					String reqId = request.getParameter("getReqId");
					String[] expertIds = request.getParameterValues("expertIds");
					int expertCount = expertIds.length;
					try {
						jobRequestDAO.setExpertCount(Integer.parseInt(reqId), expertCount);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < expertIds.length; i++) {
						try {
							jobRequestDAO.addExpert(Integer.parseInt(reqId), Integer.parseInt(expertIds[i]));
							jobRequestDAO.updateStateOnExpert(Integer.parseInt(reqId));
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					response.sendRedirect(MODERATOR_URL);
					break;
				case "usercreaterequest":
					String startDate = request.getParameter("startdate");
					String endDate = request.getParameter("enddate");
					int jobTypeId = Integer.parseInt(request.getParameter("jobtype"));
					String description = request.getParameter("description");
					try {
						jobRequestDAO.addRequest(Date.valueOf(startDate), Date.valueOf(endDate), jobTypeId, description, user.getId());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(USER_URL);
					break;
				case "editrequest":
					String editedRequestId = request.getParameter("getEditedRequestId");
					System.out.println(editedRequestId);
					try {
						JobRequest jobRequest = jobRequestDAO.selectJobRequestById(Integer.parseInt(editedRequestId)).get(0);
						request.setAttribute("jobRequest", jobRequest);
						request.getRequestDispatcher("pages/editrequest.jsp").forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "requestupdate":
					String newRequestStartDate = request.getParameter("startdate");
					String newRequestEndDate = request.getParameter("enddate");
					String newDescription = request.getParameter("description");
					int reqId2  = Integer.parseInt(request.getParameter("editedRequestId"));
					try {
						jobRequestDAO.updateRequest(Date.valueOf(newRequestStartDate),
								Date.valueOf(newRequestEndDate), newDescription, reqId2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(USER_URL);
					break;
				case "approverequest":
					String approvedReqId = request.getParameter("getApprovedId");
					System.out.println(approvedReqId);
					System.out.println(user.getId());
					try {
						int id = Integer.parseInt(approvedReqId);
						jobRequestDAO.setApproveCount(id);
						jobRequestDAO.approveRequest(user.getId(), id);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(USER_URL);
					break;
				case "refuserequest":
					String refusedReqId = request.getParameter("getRefusedId");
					try {
						int refusedId = Integer.parseInt(refusedReqId);
						jobRequestDAO.setRefuseCount(refusedId);
						jobRequestDAO.refuseRequest(user.getId(), refusedId);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.sendRedirect(USER_URL);
					break;
				default:
					break;
			}
		}
	}

}
