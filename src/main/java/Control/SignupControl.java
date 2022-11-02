package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Sockaddr;

import com.mysql.cj.protocol.a.authentication.CachingSha2PasswordPlugin;

import Dao.AccountDao;
import Model.Account;

/**
 * Servlet implementation class SingupControl
 */
@WebServlet("/signup")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControl() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass=request.getParameter("repass");
		String fullname = request.getParameter("fullname");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		System.out.println(fullname);
		System.out.println(country);
		
		if(!pass.equals(re_pass)) {
			response.sendRedirect("Login.jsp");
			System.out.println("Sai pass");
		}
		else {
			Account a = new AccountDao().checkAccountExits(user);
			if(a==null) {
				Account a1=new Account();
				a1.setId(0);
				a1.setUser(user);
				a1.setPass(pass);
				a1.setName(fullname);
				a1.setEmail(email);
				a1.setCountry(country);
				a1.setIsad(0);
				AccountDao ad=new AccountDao();
				ad.signup(a1);
				response.sendRedirect("home");
			}else {
				System.out.println("da ton tai");
				response.sendRedirect("Login.jsp");
			}
		}
		
	}

}
