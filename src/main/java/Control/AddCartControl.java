package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Model.Account;

/**
 * Servlet implementation class AddCartControl
 */
@WebServlet("/addcart")
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String amount=request.getParameter("amount");
//		System.out.println(amount);
			
		response.setCharacterEncoding("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("acc");
		String idsach=request.getParameter("sid");
		String amount=request.getParameter("amount");
		CartDao cDao=new CartDao();
		if(account==null) {
			response.sendRedirect("home");
		}
		else {
			if(cDao.seachCart(Integer.parseInt(idsach), account.getId())==0) {
				cDao.insertCart(Integer.parseInt(idsach), account.getId(), Integer.parseInt(amount));
			}
			else {
				cDao.update(Integer.parseInt(idsach), account.getId(), Integer.parseInt(amount));
			}
		}
		response.sendRedirect("cart");
	}

}
