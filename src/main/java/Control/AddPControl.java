package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SachDao;
import Model.Sach;

/**
 * Servlet implementation class AddPControl
 */
@WebServlet("/addp")
public class AddPControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String img=request.getParameter("image");
		String price=request.getParameter("price");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String category=request.getParameter("category");
		
		Sach s=new Sach();
		s.setId(0);
		s.setName(name);
		s.setImg(img);
		s.setPrice(Integer.parseInt(price));
		s.setTitle(title);
		s.setDescription(description);
		s.setCateID(Integer.parseInt(category));
		
		SachDao sd=new SachDao();
		sd.insertSach(s);
		response.sendRedirect("managerp");
		
	}

}
