<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
        }

        div.c {
            width: 500px;
            height: 100px;
            margin: auto;
        }

        div.a {
            float: left;
            margin: 0;
        }

        div.b {
            float: left;
            margin: 0;
        }

        div.clear {
            clear: both;
        }


        input.formClass[type="submit"] {
            width: 200px;
            height: 100px;
            color: white;
            margin-right: 25px;
            margin-left: 25px;
            background-color: darkslategrey;
            font-size: large;
        }

        input.formClass:hover {
            background-color: #111;
        }
    </style>
</head>
<body>

<div class="c">
    <div class="a">
        <form action="login.jsp" method="POST">
            <input class="formClass" type="submit" name="userName" value="User"/>
        </form>
    </div>

    <div class="b">
        <form action="login.jsp" method="POST">
            <input class="formClass" type="submit" name="userName" value="Admin"/>
        </form>
    </div>
    <div class="clear"></div>
</div>

</body>
</html>
