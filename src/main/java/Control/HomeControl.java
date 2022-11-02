package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CategoryDao;
import Dao.SachDao;
import Model.Category;
import Model.Sach;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<Sach> s = new ArrayList<>();
		List<Category> c=new ArrayList<>();
		s=new SachDao().getAll();
		c=new CategoryDao().getAll();
		request.setAttribute("listP", s);
		request.setAttribute("listCC", c);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
