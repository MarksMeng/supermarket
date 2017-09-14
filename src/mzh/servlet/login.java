package mzh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mzh.dao.ManaDAO;
import mzh.pojo.Manager;

public class login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到用户输入的账号密码
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		Manager mana = new Manager();
		try{	
			ManaDAO manDAO=new ManaDAO();
			mana=manDAO.Check(name,pwd);		//验证用户合法性
			if(mana!=null){
			HttpSession session=request.getSession();
			session.setAttribute("manager",name);
			session.setAttribute("popedom",mana.getPopedom());
			}else{
				request.setAttribute("error","登陆失败");
		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request,response);
			}
			javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/frame.html");
	        requestDispatcher.forward(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
