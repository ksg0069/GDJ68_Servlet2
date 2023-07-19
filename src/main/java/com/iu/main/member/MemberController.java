package com.iu.main.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		boolean flag = true;
		try {
		if(path.equals("/join.do")) {
			
				
				
			String method = request.getMethod();
			
					
			if(method.equals("POST")) {
						
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setBirth(Date.valueOf(request.getParameter("birth")));
					
					memberDAO.join(memberDTO);
//					request.setAttribute("result", result);
					
					flag=false;
					path="../index.do";
					
				}else {
					path="/WEB-INF/views/member/join.jsp";
				}
				

			}else if(path.equals("/login.do")) {
				
				String method = request.getMethod();
				if(method.equals("POST")) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO = memberDAO.login(memberDTO);
					
					if(memberDTO != null) {
						System.out.println("로그인 성공");
						HttpSession session =request.getSession();
						session.setAttribute("member", memberDTO);
						
					}else {
						System.out.println("실패");
					}
					
					
					flag=false;
					path="../index.do";
					
				}else {
					path="/WEB-INF/views/member/login.jsp";
				}
				
			}else if(path.equals("/logout.do")){
				HttpSession session =request.getSession();
				//1. MemberDTo값을 null
//				session.setAttribute("member", null);
				//2. Member 키와 MemberDTO 삭제
//				session.removeValue("member");
				//3. session 객체 소멸
				session.invalidate();
				
				flag=false;
				path="../index.do";
			}else if(path.equals("/mypage.do")){
				
				path="/WEB-INF/views/member/mypage.jsp";
				
			
			}
				
					
					
					
									
				
		
		
		if(flag) {
			//forword
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		}else {
			response.sendRedirect(path);
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
