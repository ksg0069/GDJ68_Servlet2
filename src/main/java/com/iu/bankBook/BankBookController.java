package com.iu.bankBook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankBookDAO bankBookDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        bankBookDAO = new BankBookDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /bankbook/list.do 	: 상품목록
		// /bankbook/detail.do  : 상품상세내용 조회
		// /bankbook/add.do 	: 새로운 상품을 등록
		// /bankbook/update.do  : 상품 수정
		// /bankbook/delete.do  : 상품 삭제
		
		try {
			
			System.out.println(request.getMethod());
			System.out.println(request.getPathInfo());
			System.out.println(request.getServletPath());
			
			String path = request.getPathInfo();
			String viewName ="/WEB-INF/views/errors/notFound.jsp";
			boolean flag = true;
			
			if(path.equals("/list.do")) {
				System.out.println("목록");
				ArrayList<BankBookDTO> ar = bankBookDAO.bankBookList();
				System.out.println(ar.size());
				request.setAttribute("list", ar);
				
				viewName="/WEB-INF/views/bankbook/list.jsp";
			}else if(path.equals("/detail.do")) {
				System.out.println("상세");
				
				String num = request.getParameter("bookNum");
				
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNum(Long.parseLong(num));
				bankBookDTO = bankBookDAO.bankBookDetail(bankBookDTO);
				
				request.setAttribute("dto", bankBookDTO);
				
				viewName="/WEB-INF/views/bankbook/detail.jsp";
			}else if(path.equals("/add.do")) {
				
				String method =request.getMethod();
				if(method.equals("POST")) {
					BankBookDTO BankBookDTO = new BankBookDTO();
					BankBookDTO.setBookName(request.getParameter("bookName"));
					BankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")) );
					BankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
					BankBookDTO.setBookContents(request.getParameter("bookContents"));
				
					int result = bankBookDAO.bankBookAdd(BankBookDTO);
					request.setAttribute("result", result); 
					
					flag=false;
					viewName="./list.do";
//					viewName="/WEB-INF/views/commons/result.jsp";
				
				}else {
					
					viewName="/WEB-INF/views/bankbook/add.jsp";
					
				}
			}else if(path.equals("/update.do")){
				String method = request.getMethod();
				
				if (method.equals("POST")){
					BankBookDTO bankBookDTO = new BankBookDTO();
					bankBookDTO.setBookName(request.getParameter("bookName"));
					bankBookDTO.setBookContents(request.getParameter("bookContents"));
					bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")) );
					bankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
					bankBookDTO.setBookNum(Long.parseLong(request.getParameter("bookNum")));
					
					int result = bankBookDAO.bankBookUpdate(bankBookDTO);
					request.setAttribute("result", result);
					
					flag=false;
					viewName="./detail.do?bookNum="+bankBookDTO.getBookNum();
					
//					viewName="/WEB-INF/views/commons/result.jsp";
					
					
				}else {
					System.out.println("수정");
					String bookNum = request.getParameter("bookNum");
					BankBookDTO bankBookDTO = new BankBookDTO();
					bankBookDTO.setBookNum(Long.parseLong(bookNum));
					bankBookDTO = bankBookDAO.bankBookDetail(bankBookDTO);
					
					request.setAttribute("dto", bankBookDTO);
					viewName="/WEB-INF/views/bankbook/update.jsp";
				}
				
			}else if(path.equals("/delete.do")) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNum(Long.parseLong(request.getParameter("bookNum")));
				int result = bankBookDAO.bankBookDelete(bankBookDTO);
				
				request.setAttribute("result", result);
				viewName="/WEB-INF/views/commons/result.jsp";
				System.out.println("삭제");
				
			}
		
			if(flag ) {
			// foward
			RequestDispatcher view = request.getRequestDispatcher(viewName);    // webapps까지가 루트임
			view.forward(request, response);
			}else {
			//redirect
			response.sendRedirect(viewName);			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
