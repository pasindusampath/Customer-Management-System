<%--
  Created by IntelliJ IDEA.
  User: Pasindu Sampath
  Date: 6/30/2023
  Time: 11:53 PM
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
            justify-content: space-around;
            width: 100vw;
            height: 300px;
        }
    </style>
</head>
<body>
<div class="main">
    <div>
        <h1>ADD CUSTOMER FORM</h1>
    </div>
</div>
<div>
    <form method="post" action="customer">
        <div>
            <label for="name">Name</label>
            <input id="name" type="text" name="name" placeholder="name">
        </div>
        <div>
            <label for="contact">Mobile No</label>
            <input id="contact" type="text" name="contact" placeholder="Mobile No">
        </div>
        <div>
            <label for="address">Address</label>
            <input id="address" type="text" name="address" placeholder="Address">
        </div>
        <div>
            <label for="gmail">G-Mail</label>
            <input id="gmail" type="text" name="gmail" placeholder="G-Mail">
        </div>
        <div>
            Gender
           <div>
               <input checked type="radio" name="gender" value="Male">Male
               <input type="radio" name="gender" value="Female">FeMale
           </div>
        </div>
        <div>
            <button type="submit">SUBMIT</button>
        </div>
    </form>
    <%=request.getAttribute("id")%>
</div>
</body>
</html>