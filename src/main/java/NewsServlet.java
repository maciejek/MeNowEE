
import connection.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dupa")
public class NewsServlet extends HttpServlet {

    private UpdatesManager manager;
    @Override
    public void init() throws ServletException {
        super.init();
        manager = new UpdatesManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<News> manyNews = manager.getUpdates();

        request.setAttribute("manyNews", manyNews); // This will be available as ${message}
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newSource = request.getParameter("source");
        manager.register(newSource);
        response.sendRedirect("dupa");
//        }
//        else {
//            request.setAttribute("error", "Unknown user, please try again");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//        String newsSource = req.getAttribute("newSource");
    }
}