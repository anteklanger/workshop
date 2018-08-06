package pl.coderslab.team2.controller;

import pl.coderslab.team2.dao.ClientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ClientDeleteController")
public class ClientDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int clientToDeleteId = Integer.parseInt(request.getParameter("id"));
        int result = ClientDao.delete(clientToDeleteId);

        if (result != 0)
            response.getWriter().append("Client: " + clientToDeleteId + ", deleted");
        else
            response.getWriter().append("Operation failed");
    }
}
