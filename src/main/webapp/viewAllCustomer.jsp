<%@ page import="java.util.List" %>
<%@ page import="dto.custom.CustomerDTO" %><%--
  Created by IntelliJ IDEA.
  User: Pasindu Sampath
  Date: 7/1/2023
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 80vw;
            height: max-content;
            border: 1px solid black;
        }
        table td{
            width: calc(80vw/5);
            height: max-content;
        }
        thead td{
            text-align: center;
        }
        td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <td>ID</td>
    <td>NAME</td>
    <td>ADDRESS</td>
    <td>CONTACT</td>
    <td>GENDER</td>
    </thead>
    <tbody>
    <%
        List<CustomerDTO> list = (List<CustomerDTO>) request.getAttribute("customerList");
        if(list!=null){
            for (CustomerDTO ob:list){
    %>
    <tr>
        <td><%=ob.getId()%></td>
        <td><%=ob.getName()%></td>
        <td><%=ob.getAddress()%></td>
        <td><%=ob.getContact()%></td>
        <td><%=ob.getGender()%></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<form action="customer" method="GET">
    <input checked name="type-get" type="radio" value="all">
    <button type="submit">Make GET Request</button>
</form>
<script>
    /*function makeGetRequest() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var response = this.responseText;
                //console.log(response)
                // Process the response as needed
            }
        };
        xhttp.open("GET", "customer", true);
        xhttp.send();
    }
    makeGetRequest()*/
</script>
</body>
</html>
