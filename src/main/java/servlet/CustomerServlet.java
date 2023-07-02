package servlet;

import com.google.gson.Gson;
import dto.custom.CustomerDTO;
import sevice.custom.CustomerService;
import util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        String gender = req.getParameter("gender");
        CustomerDTO customer = new CustomerDTO(0, name, contact, address, gmail, gender);
        CustomerDTO add = service.add(customer);
        req.setAttribute(String.valueOf(add.getId()),"id");
        getServletContext().getRequestDispatcher("/add_customer.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typ = req.getParameter("type-get");
        System.out.println(typ);
        if(typ.equals("all")){
            List<CustomerDTO> all = service.getAll();
            req.setAttribute("customerList",all);
            getServletContext().getRequestDispatcher("/viewAllCustomer.jsp").forward(req,resp);
        }
        if(typ.equals("single")){
            String id = req.getParameter("id");
            CustomerDTO search = service.search(id);
            req.setAttribute("customer",search);
            getServletContext().getRequestDispatcher("/viewCustomer.jsp").forward(req,resp);
        }
        if(typ.equals("up")){
            String id = req.getParameter("id");
            CustomerDTO search = service.search(id);
            String s = convertCustomerToJson(search);
            PrintWriter out = resp.getWriter();
            out.write(s);
            out.flush();
            System.out.println(s);
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = collectData(req);
        CustomerDTO update = service.update(customerDTO);
        if(update==null){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }


    public CustomerDTO collectData(HttpServletRequest req){
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String gmail = req.getParameter("gmail");
        String gender = req.getParameter("gender");
        return new CustomerDTO(Integer.parseInt(id),name,contact,address,gmail,gender);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("(delete) not Implemented yet");
    }

    private String convertCustomerToJson(CustomerDTO customer) {
        Gson gson = new Gson();
        return gson.toJson(customer);
    }

}
