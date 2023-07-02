<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .main{
            display: flex;
            align-items: center;
            justify-content: space-around;
            width: 100vw;
            height: 300px;
        }
        .direction-handle{
            width: 100vw;
            height: 100px;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="main">
    <div>
        <h1>
            MANAGE CUSTOMERS
        </h1>
    </div>
</div>
<div class="direction-handle">
    <div><a href="add_customer.jsp"><button>Add Customer</button></a></div>
    <div><a ><button>Delete Customer</button></a></div>
    <div><a href="updateCustomer.jsp"><button>Update Customer</button></a></div>
    <div><a href="viewCustomer.jsp"><button>View Customer</button></a></div>
    <div><a href="viewAllCustomer.jsp"><button>View All Customer</button></a></div>
</div>
</body>
</html>