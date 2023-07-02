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
            flex-direction: column;
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
        .sub2{
            display: flex;
        }
        .sub2 div{
            width: max-content;
            height: 80px;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="sub">
        <form>
            <div>
                <label for="id">Name</label>
                <input id="id" type="text" name="id" placeholder="name">
            </div>
            <div>
                <label for="name">Name</label>
                <input id="name" type="text" name="name" placeholder="name">
            </div>
            <div>
                <label for="contact">Mobile No</label>
                <input id="contact" type="text" name="contact"  placeholder="Mobile No">
            </div>
            <div>
                <label for="address">Address</label>
                <input id="address" type="text"  name="address" placeholder="Address">
            </div>
            <div>
                <label for="gmail">G-Mail</label>
                <input id="gmail" type="text" name="gmail" placeholder="G-Mail">
            </div>
            <div>
                Gender
                <div>
                    <input class="gen" type="radio" name="gender" value="Male">Male
                    <input class="gen" type="radio" name="gender" value="Female">FeMale
                </div>
            </div>

        </form>
    </div>
    <div class="sub2">
        <div>
            <button onclick="getData()">SEARCH</button>
        </div>
        <div>
            <button onclick="update()">UPDATE</button>
        </div>
    </div>

</div>
</body>
<script src="lib/jquery-3.6.4.min.js"></script>
<script>
    let $j = jQuery.noConflict();
    function getData(){
        console.log('called')
        let id = $j('#id').val();
        fetch('http://localhost:8080/customer?id='+(id)+'&type-get=up',{method:'GET'}).then(function (response){
            if(response.ok){
                return response.json();
            }else{
                throw new Error('Error retrieving data');
            }
        }).then(function (data){
            $j('#id').val(data.id);
            $j('#name').val(data.name);
            $j('#contact').val(data.contact);
            $j('#address').val(data.address);
            $j('#gmail').val(data.gmail);
            if(data.gender==='Male'){
                $j('.gen').eq(0).prop('checked','true');
            }else{
                $j('.gen').eq(1).prop('checked','true');
            }
        });
    }
    function update(){
        let id = $j('#id').val();
        let name = $j('#name').val();
        let contact = $j('#contact').val();
        let address = $j('#address').val();
        let gmail = $j('#gmail').val();
        let gender = $j('.gen:checked').eq(0).val();

        let temp = "http://localhost:8080/customer?id="+id+"&name="+name+"&contact="+contact+"&address="+
            address+"&gmail="+gmail+"&gender="+gender;

        fetch(temp,{method:'PUT'}).then(function (response){
            if(response.ok){
               alert('update Success');
            }else {
                alert('something went wrong');
            }
        })
    }
</script>
</html>
