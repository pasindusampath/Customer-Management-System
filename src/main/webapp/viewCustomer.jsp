<%@ page import="entity.custom.Customer" %>
<%@ page import="dto.custom.CustomerDTO" %><%--
  Created by IntelliJ IDEA.
  User: Pasindu Sampath
  Date: 7/1/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            display: flex;
            align-items: center;
            width: 100vw;
            height: 100vh;
            justify-content: center;
        }

        .sub{
            display: flex;
            align-items: center;
            justify-content: center;
            width: 50vw;
            height: 50vh;
        }
        .sub div{
            width: 100%;
            height: 57px;
        }

    </style>
</head>
<body>
<div class="main">
    <div class="sub">
        <form action="customer" method="get">
            <%CustomerDTO customer = (CustomerDTO) request.getAttribute("customer");%>
            <div>
                <label for="id">Name</label>
                <input id="id" type="text" name="id" placeholder="name">
            </div>
            <div>
                <label for="name">Name</label>
                <input id="name" type="text" name="name" value="<%if(customer!=null){%>
            <%=customer.getName()%><%}%>" placeholder="name">
            </div>
            <div>
                <label for="contact">Mobile No</label>
                <input id="contact" type="text" name="contact" value="<%if(customer!=null){%>
            <%=customer.getContact()%><%}%>" placeholder="Mobile No">
            </div>
            <div>
                <label for="address">Address</label>
                <input id="address" type="text" value="<%if(customer!=null){%>
            <%=customer.getAddress()%><%}%>" name="address" placeholder="Address">
            </div>
            <div>
                <label for="gmail">G-Mail</label>
                <input id="gmail" value="<%if(customer!=null){%>
                                 <%=customer.getGmail()%><%}%>
            " type="text" name="gmail" placeholder="G-Mail">
            </div>
            <div>
                Gender
                <div>
                    <input <%if(customer!=null){%>
                        <%if(customer.getGender().equals("Male")){%>
                            checked
                        <%}%>
                        <%}%> type="radio" name="gender" value="Male">Male
                    <input <%if(customer!=null){%>
                        <%if(customer.getGender().equals("Female")){%>
                            checked
                        <%}%>
                        <%}%>  type="radio" name="gender" value="Female">FeMale
                </div>
            </div>
            <div>
                <input checked name="type-get" type="radio" value="single">
                <button type="submit">SUBMIT</button>
            </div>
        </form>
    </div>
</div>


</body>
</html>
