<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="clear">
    <form action="hello" method="POST" name="form">
        <label>Reimbursement name:
            <input type="text" name="name"/>
        </label>
        <br>
        <label>
            <input type="checkbox" name="receipts"> have you receipts to refund
        </label>
        <br>
        <label>
            <input  type="checkbox" id="box" name="carMileageBox" onclick="functionChangeVisible()"> have you car mileage to refund
        </label>

        <label id="label" style="visibility: hidden">
            <input type="number" name="carMileage" placeholder="number of km to refund"/> km
        </label>

        <br>
        <label>
            <input  type="checkbox" id="box2" name="carMileageBox" onclick="functionChangeVisible2()"> test
        </label>
        <br>

        <label id="label2" style="visibility: hidden">
            <input type="date" name="dailyAllowanceStart" min="2021-01-01" max="2023-12-31"/>
            <input type="date" name="dailyAllowanceEnd" min="2021-01-01" max="2023-12-31"/>
        </label>

        <br>


        <input type="submit" value="Send"/>
    </form>
</div>

Work in progress


<script>

    function functionChangeVisible() {
        const checkbox = document.getElementById("box");
        const label = document.getElementById("label");


        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                label.style.visibility = 'visible';

            } else {
                label.style.visibility = 'hidden';
            }
        });
    }

    function functionChangeVisible2() {
        const checkbox = document.getElementById("box2");
        const label = document.getElementById("label2");


        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                label.style.visibility = 'visible';

            } else {
                label.style.visibility = 'hidden';
            }
        });
    }


</script>
</body>
</html>
