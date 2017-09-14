package mzh.servlet;
import mzh.pojo.provider;
import mzh.dao.providerDAO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newProvider extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public newProvider() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		  //ʵ����pojo
		  provider pro1=new provider();
		  //Ϊjopo��ֵ
		  String typeView=request.getParameter("typeView");
	  if(typeView!=null){
		  pro1.setPro_Id(request.getParameter("userId"));
	        pro1.setPro_Name(request.getParameter("name"));
	        pro1.setPro_Tel(request.getParameter("tel"));
	        pro1.setPro_Address(request.getParameter("address"));

	        pro1.setCargo_Type(request.getParameter("typeView"));
	        pro1.setPro_Date(request.getParameter("date"));
	       
	       request.setAttribute("typeView", typeView);
	        try
	        {
	        	//ʵ����DAO
	         providerDAO proBean=new providerDAO();
	         //�{��
	           proBean.newpro(pro1);
	        }
	        catch(SQLException eb)		
	        {
	         request.setAttribute("errorMessage","�ڴ������û�ʱ����������Ϊ�û��Ѿ����ڣ����������ԡ�������Ϣ="+eb.getMessage()+"!");
	     
	        }
	      
//	        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newProviders.jsp");
	        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("proTypeView");
           requestDispatcher.forward(request,response);
           return;
	  }else{
		        pro1.setPro_Id(request.getParameter("userId"));
		        pro1.setPro_Name(request.getParameter("name"));
		        pro1.setPro_Tel(request.getParameter("tel"));
		        pro1.setPro_Address(request.getParameter("address"));
		        pro1.setCargo_Type(request.getParameter("type"));
		        pro1.setPro_Date(request.getParameter("date"));
		       
		       
		        try
		        {
		        	//ʵ����DAO
		         providerDAO proBean=new providerDAO();
		         //�{��
		           proBean.newpro(pro1);
		        }
		        catch(SQLException eb)		
		        {
		     
		         request.setAttribute("errorMessage","�ڴ������û�ʱ����������Ϊ�û��Ѿ����ڣ����������ԡ�������Ϣ="+eb.getMessage()+"!");
	
		        }
		      
//		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newProviders.jsp");
		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("proLogin");
	             requestDispatcher.forward(request,response);
		         return;
		         }}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
