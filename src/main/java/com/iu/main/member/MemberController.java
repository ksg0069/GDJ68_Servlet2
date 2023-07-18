package com.iu.main.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.bankBook.BankBookDTO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        memberDAO = new MemberDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getPathInfo();
		String viewName= "";
		try {
		if(path.equals("/join.do")) {
			
				
				
					String method = request.getMethod();
					boolean flag = true;
					
					if(method.equals("POST")) {
						
						MemberDTO memberDTO = new MemberDTO();
						memberDTO.setId(request.getParameter("id"));
						memberDTO.setPw(request.getParameter("pw"));
						memberDTO.setName(request.getParameter("name"));
						memberDTO.setEmail(request.getParameter("email"));
						memberDTO.setBirth(Date.valueOf(request.getParameter("birth")));
						
						int result = memberDAO.join(memberDTO);
//						request.setAttribute("result", result);
						
						flag=false;
						path="../index.do";
						
					}else {
						path="/WEB-INF/views/member/join.jsp";
					}
					
					if(flag) {
						//forword
						RequestDispatcher view = request.getRequestDispatcher(path);
						view.forward(request, response);
						
					}else {
						response.sendRedirect(path);
					}
					
			
				
				
		
			
			}else {
				
				path="/WEB-INF/views/member/join.jsp";
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
// URL 구분 끝
		
			
			
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
