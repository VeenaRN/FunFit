package com.xadmin.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.bean.Batch;
import com.xadmin.usermanagement.bean.User;
import com.xadmin.usermanagement.dao.BatchDao;


@WebServlet({ "/BatchServlet", "/batches" ,"/delete","/edit1","/update","/new1","/insert"})
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private BatchDao batchDao;  
   
	public void init() throws ServletException {
		 batchDao = new BatchDao();
	}
    public BatchServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action=request.getServletPath();
		switch(action) {
		
		case "/new1":
			ShowNewForm(request,response);
			break;
		case "/insert":
			try {
				insertBatch(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteBatch(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
			
		case "/edit1":
			   
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			    
			    break;
		
		case "/update":
			try {
				updateBatch(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
					
			
			
		case "/batches":
			try {
				listBatch(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		
		}
	
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void ShowNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("batch-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertBatch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String batch_name = request.getParameter("batch_name");
		
		//String session_time = request.getParameter("session_time");

		String session_type = request.getParameter("session_type");
		String instructor = request.getParameter("instructor");
		
		String location = request.getParameter("location");
		
		Batch newBatch = new Batch(batch_name,session_type,instructor,location);
		
		batchDao.insertBatch(newBatch);
		response.sendRedirect("list");
	}
	
	private void deleteBatch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id  = Integer.parseInt(request.getParameter("id"));
		batchDao.deleteBatch(id);
		response.sendRedirect("batches");

	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Batch existingBatch;
		try {
			existingBatch=batchDao.selectBatch(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("batch-form.jsp");
			request.setAttribute("batch", existingBatch);
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	private void updateBatch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String batch_name = request.getParameter("batch_name");
		//String session_time =request.getParameter("session_time");
		String session_type = request.getParameter("session_type");
		String instructor = request.getParameter("instructor");
		String location = request.getParameter("location");
		Batch batch = new Batch(id,batch_name,session_type,instructor, location);
		batchDao.updateBatch(batch);
		response.sendRedirect("list");
	}
	
	
	private void listBatch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		try {
		List<Batch> listBatch = batchDao.selectAllBatches();
		request.setAttribute("listBatch", listBatch);
		RequestDispatcher dispatcher = request.getRequestDispatcher("batch-list.jsp");
		dispatcher.forward(request, response);
	}catch (Exception e) {
		e.printStackTrace();
	}
}

}
