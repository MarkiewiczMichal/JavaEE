<%@ page import="com.example.javaeereimbursementapp.Reimbursement" %>
<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="clear">
    <form action="user" method="POST" name="form">
        <label>Reimbursement name:
            <input type="text" name="name"/>
        </label>
        <br>
        <label>
            <input type="checkbox" name="receipts" id="boxOfSelect" onclick="functionChangeVisibleSelect()"> have you
            receipts to refund
        </label>

        <% List<Receipt> listOfReceipt = (List<Receipt>) request.getAttribute("listOfReceipt");%>
        <br>
        <label class="select1" style="visibility: hidden">Wybierz z listy:</label>
        <select name="select" class="select1" style="visibility: hidden">
            <option name="option1" value="<%= listOfReceipt.get(0) %>"><%= listOfReceipt.get(0) %>
            </option>
            <option name="option2" value="<%= listOfReceipt.get(1) %>"><%= listOfReceipt.get(1) %>
            </option>
            <option name="option3" value="<%= listOfReceipt.get(2) %>"><%= listOfReceipt.get(2) %>
            </option>
            <option name="option4" value="<%= listOfReceipt.get(3) %>"><%= listOfReceipt.get(3) %>
            </option>
            <option name="option5" value="<%= listOfReceipt.get(4) %>"><%= listOfReceipt.get(4) %>
            </option>
        </select>
        <input type="number" class="select1" name="option1Amount" placeholder="Enter the value of the bill"
               style="visibility: hidden" >
        <input type="checkbox" name="receipts" class="select1" id="secondBox"
               onclick="functionChangeVisibleSelectSecond()" style="visibility: hidden">
        <br>
        <label class="select2" style="visibility: hidden">Wybierz z listy:</label>
        <select name="select2" class="select2" style="visibility: hidden">
            <option name="option1" value="<%= listOfReceipt.get(0) %>"><%= listOfReceipt.get(0) %>
            </option>
            <option name="option2" value="<%= listOfReceipt.get(1) %>"><%= listOfReceipt.get(1) %>
            </option>
            <option name="option3" value="<%= listOfReceipt.get(2) %>"><%= listOfReceipt.get(2) %>
            </option>
            <option name="option4" value="<%= listOfReceipt.get(3) %>"><%= listOfReceipt.get(3) %>
            </option>
            <option name="option5" value="<%= listOfReceipt.get(4) %>"><%= listOfReceipt.get(4) %>
            </option>
        </select>
        <input type="number" class="select2" name="option1Amount" placeholder="Enter the value of the bill"
               style="visibility: hidden">
        <input type="button" class="select2" value="Add next" style="visibility: hidden" onclick="">
        <br>


        <label>
            <input type="checkbox" id="box" name="carMileageBox" onclick="functionChangeVisible()">
            have you car mileage to refund
        </label>

        <label id="label" style="visibility: hidden">
            <input type="number" name="carMileage" placeholder="number of km to refund"/> km
        </label>

        <br>
        <label>
            <input type="checkbox" id="box2" name="dailyallowance" onclick="functionChangeVisible2()"> test
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


    function functionChangeVisibleSelect() {
        const checkbox = document.getElementById("boxOfSelect");


        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                for (let el of document.querySelectorAll('.select1')) el.style.visibility = 'visible';

            } else {
                for (let el of document.querySelectorAll('.select1')) el.style.visibility = 'hidden';
            }
        });
    }

    function functionChangeVisibleSelectSecond() {

        // document.getElementById('secondBox').onclick = function () {
        //     var disabled = document.getElementById("boxOfSelect").disabled;
        //     if (disabled) {
        //
        //         document.getElementById("boxOfSelect").disabled = false;
        //
        //     } else {
        //         document.getElementById("boxOfSelect").disabled = true;
        //
        //     }


            document.getElementById('secondBox').addEventListener('change', () => {
                if (document.getElementById('secondBox').checked) {
                    for (let el of document.querySelectorAll('.select2')) el.style.visibility = 'visible';
                    document.getElementById("boxOfSelect").disabled = true;
                } else {
                    for (let el of document.querySelectorAll('.select2')) el.style.visibility = 'hidden';

                    document.getElementById("boxOfSelect").disabled = false;
                }
            })
        // }
    }

</script>
</body>
</html>
