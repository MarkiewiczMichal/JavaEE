<%@ page import="com.example.javaeereimbursementapp.Reimbursement" %>
<%@ page import="com.example.javaeereimbursementapp.Receipt" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User panel</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="clear" style="margin: auto; width: 900px;">
    <h1><%= "User panel" %>
    </h1>
    <form action="user" method="POST" name="form">
        <label>Create new reimbursement claim:
        </label>
        <br>
        <label>
            <input type="checkbox" id="box" name="carMileageBox" onclick="functionChangeVisibleCarMileage()">
            Have you car mileage to refund
        </label>

        <label id="label" style="visibility: hidden">
            <input type="number" name="carMileage" placeholder="number of km to refund"/> km
        </label>

        <br>
        <label>
            <input type="checkbox" id="box2" name="dailyallowance" onclick="functionChangeVisibleDailyAllowance()">
            Set periods for which you get daily allowance
        </label>


        <label id="label2" style="visibility: hidden">
            <b><i>start: </i></b> <input type="date" name="dailyAllowanceStart" min="2021-01-01" max="2023-12-31"/>
            <b><i>end: </i></b> <input type="date" name="dailyAllowanceEnd" min="2021-01-01" max="2023-12-31"/>
        </label>

        <br>
        <label>
            <input type="checkbox" name="receipts" id="boxOfSelect" onclick="functionChangeVisibleSelect()"> Have you
            receipts to refund
        </label>

        <% List<Receipt> listOfReceipt = (List<Receipt>) request.getAttribute("listOfReceipt");%>
        <br>
        <label class="select1" style="visibility: hidden">Select from list:</label>
        <select name="select" class="select1" style="visibility: hidden">
            <option selected value>
                -- select an option --
            </option>
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
        <input type="number" class="select1" name="select1Amount" placeholder="Enter the value of the bill"
               min="0" step="0.01" style="visibility: hidden">
        <label class="select1" style="visibility: hidden; font-style: italic;">
            <input type="checkbox" class="select1" id="secondBox"
                   onclick="functionChangeVisibleSelectSecond()" style="visibility: hidden">
            Add more
        </label>

        <br>
        <label class="select2" style="visibility: hidden">Select from list:</label>
        <select name="select2" class="select2" style="visibility: hidden">
            <option selected value>
                -- select an option --
            </option>
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
        <input type="number" class="select2" name="select2Amount" placeholder="Enter the value of the bill"
               min="0" step="0.01" style="visibility: hidden">
        <label class="select2" style="visibility: hidden; font-style: italic;">
            <input type="checkbox" class="select2" id="thirdBox"
                   onclick="functionChangeVisibleSelectThird()" style="visibility: hidden">
            Add more
        </label>


        <br>
        <label class="select3" style="visibility: hidden">Select from list:</label>
        <select name="select3" class="select3" style="visibility: hidden">
            <option selected value>
                -- select an option --
            </option>
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
        <input type="number" class="select3" name="select3Amount" placeholder="Enter the value of the bill"
               min="0" step="0.01" style="visibility: hidden">
        <label class="select3" style="visibility: hidden; font-style: italic;">
            <input type="checkbox" class="select3" id="fourthBox"
                   onclick="functionChangeVisibleSelectFourth()" style="visibility: hidden">
            Add more
        </label>

        <br>
        <label class="select4" style="visibility: hidden">Select from list:</label>
        <select name="select4" class="select4" style="visibility: hidden">
            <option selected value>
                -- select an option --
            </option>
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
        <input type="number" class="select4" name="select4Amount" placeholder="Enter the value of the bill"
               min="0" step="0.01" style="visibility: hidden">
        <label class="select4" style="visibility: hidden; font-style: italic;">
            <input type="checkbox" class="select4" id="fifthBox"
                   onclick="functionChangeVisibleSelectFifth()" style="visibility: hidden">
            Add more
        </label>

        <br>
        <label class="select5" style="visibility: hidden">Select from list:</label>
        <select name="select5" class="select5" style="visibility: hidden">
            <option selected value>
                -- select an option --
            </option>
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
        <input type="number" class="select5" name="select5Amount" placeholder="Enter the value of the bill"
               min="0" step="0.01" style="visibility: hidden">
        <br>
        <input type="submit" value="Send"/>
    </form>
</div>

<script>

    function functionChangeVisibleCarMileage() {
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

    function functionChangeVisibleDailyAllowance() {
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
        document.getElementById('secondBox').addEventListener('change', () => {
            if (document.getElementById('secondBox').checked || document.getElementById('thirdBox').checked
                || document.getElementById('fourthBox').checked || document.getElementById('fifthBox').checked) {
                for (let el of document.querySelectorAll('.select2')) el.style.visibility = 'visible';
                document.getElementById("boxOfSelect").disabled = true;
            } else {
                for (let el of document.querySelectorAll('.select2')) el.style.visibility = 'hidden';
                document.getElementById("boxOfSelect").disabled = false;
            }
        })
    }

    function functionChangeVisibleSelectThird() {
        document.getElementById('thirdBox').addEventListener('change', () => {
            if (document.getElementById('thirdBox').checked || document.getElementById('fourthBox').checked
                || document.getElementById('fifthBox').checked) {
                for (let el of document.querySelectorAll('.select3')) el.style.visibility = 'visible';
            } else {
                for (let el of document.querySelectorAll('.select3')) el.style.visibility = 'hidden';
            }
        })
    }

    function functionChangeVisibleSelectFourth() {
        document.getElementById('fourthBox').addEventListener('change', () => {
            if (document.getElementById('fourthBox').checked || document.getElementById('fifthBox').checked) {
                for (let el of document.querySelectorAll('.select4')) el.style.visibility = 'visible';
            } else {
                for (let el of document.querySelectorAll('.select4')) el.style.visibility = 'hidden';
            }
        })
    }

    function functionChangeVisibleSelectFifth() {
        document.getElementById('fifthBox').addEventListener('change', () => {
            if (document.getElementById('fifthBox').checked) {
                for (let el of document.querySelectorAll('.select5')) el.style.visibility = 'visible';
            } else {
                for (let el of document.querySelectorAll('.select5')) el.style.visibility = 'hidden';
            }
        })
    }

</script>
</body>
</html>
