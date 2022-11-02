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
 * Servlet implementation class CategoryControl
 */
@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cateID=request.getParameter("cid");
		List<Sach> s=new ArrayList<>();
		List<Category> c=new ArrayList<>();
		c=new CategoryDao().getAll();
		s=new SachDao().getcateID(Integer.parseInt(cateID));
		request.setAttribute("listP", s);
		request.setAttribute("listCC", c);
		request.setAttribute("tag", cateID);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
