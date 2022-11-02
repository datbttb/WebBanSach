package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ButtonGroup;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import Dao.CartDao;
import Model.Account;
import Model.Cart;
import Model.CartItem;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		Account a=(Account) session.getAttribute("acc");
		List<CartItem> ci=new CartDao().getAll(a.getId());
		Cart c=new Cart(a,ci);
		long tt=c.tongTien();
		long vat=c.vat();
		long tht=c.thanhTien();
		request.setAttribute("tt", tt);
		request.setAttribute("vat", vat);
		request.setAttribute("tht", tht);
		request.setAttribute("list", ci);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
