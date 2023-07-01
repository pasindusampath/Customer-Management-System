package servlet;

import dto.custom.CustomerDTO;
import sevice.custom.CustomerService;
import util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerManage",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet{
    CustomerService service;
    public void init(){
        service = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String gmail = req.getParameter("gmail");
        String gender = req.getParameter("gmail");
        CustomerDTO customer = new CustomerDTO(0, name, contact, address, gmail, gender);
        CustomerDTO add = service.add(customer);
        req.setAttribute(String.valueOf(add.getId()),"id");
        getServletContext().getRequestDispatcher("/add_customer.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerDTO> all = service.getAll();
        req.setAttribute("customerList",all);
        getServletContext().getRequestDispatcher("/viewAllCustomer.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("(put) not Implemented yet");
    }



    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("(delete) not Implemented yet");
    }
}
