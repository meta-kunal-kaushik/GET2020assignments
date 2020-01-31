var empId = Math.floor(Math.random() * 100);

function setEmpId() {
    document.getElementById('empId').value = "Employy ID : " + empId;
}

function collapseMessageTicketGenerateForm() {
    var name = document.getElementById('empName').value;
    document.getElementById('ticketGenerateForm').innerHTML = "Your  empId is : " + empId +
        document.getElementById("addVechileForm").innerHTML;
    setEmpId();
}

function collapseMessageAddVechileForm(vechileType) {
    document.getElementById('addVechileForm').innerHTML = "Your  empId is : " + empId + " . Do remember this ID for car retrival";
    showPassesPrice(vechileType);
}

function verifyEmail() {
    var email = document.getElementById('email').value;
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {
        document.getElementById('submit').disabled = true;
        document.getElementById('email').style.outline = "none";
        document.getElementById('email').style.borderColor = "red";
    } else {
        document.getElementById('submit').disabled = false;
        document.getElementById('email').style.borderColor = "inherit";
    }
}

function verifyContactNo() {
    var contactNo = document.getElementById('contactNo').value;
    if (!(/^\d{10}$/.test(contactNo))) {
        document.getElementById('submit').disabled = true;
        document.getElementById('contactNo').style.outline = "none";
        document.getElementById('contactNo').style.borderColor = "red";
    } else {
        document.getElementById('submit').disabled = false;
        document.getElementById('contactNo').style.borderColor = "inherit";
    }

}


function verifyConfirmPassword() {
    var confirmPassword = document.getElementById('confirmPassword').value;
    var password = document.getElementById('password').value;
    if (password != confirmPassword) {
        document.getElementById('submit').disabled = true;
        document.getElementById('confirmPassword').style.outline = "none";
        document.getElementById('confirmPassword').style.borderColor = "red";
    } else {
        document.getElementById('submit').disabled = false;
        document.getElementById('confirmPassword').style.borderColor = "inherit";
    }
}

function verifyName() {
    console.log("hello");
    var name = document.getElementById('empName').value;
    if (!(/^[a-zA-Z0-9]+$/.test(name))) {
        document.getElementById('empName').style.outline = "none";
        document.getElementById('empName').style.borderColor = "red";
        document.getElementById('submit').disabled = true;
    } else {
        document.getElementById('submit').disabled = false;
        document.getElementById('empName').style.borderColor = "inherit";
    }
}

function verifyPassword() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(password))) {
        document.getElementById('submit').disabled = true;
        document.getElementById('password').style.outline = "none";
        document.getElementById('password').style.borderColor = "red";
    } else {
        document.getElementById('submit').disabled = false;
        document.getElementById('password').style.borderColor = "inherit";
    }
}

function finalPrice() {
    var price = document.getElementsByName('price');
    for (var index = 0; index < price.length; index++) {
        if (price[index].checked) {
            var usdPrice = (price[index].value) * 0.014;
            var yenPrice = (price[index].value) * 1.53;
            document.getElementById('ticketGenerateForm').innerHTML = "Amount to be paid : " + "</br> USD : " + usdPrice + "</br> YEN : " + yenPrice + "</br> INR : " + price[index].value;
        }
    }
}



function showPassesPrice(vechileType) {
    switch (vechileType) {
        case 'car':
            document.getElementById("ticketGenerateForm").innerHTML =
                "<form >" +
                "<h1>Select Plan</h1>" +
                "<label><input type='radio' name='price' value=20>RS.20 Daily</br></label>" +
                "<label><input type='radio' name='price' value=500>RS.500 Monthly</br></label>" +
                "<label><input type='radio' name='price' value=3500>RS.3500 Yearly</br></label>" +
                "<input type='button' value='GetPass' onclick='finalPrice()' />" +
                "</form>";
            break;
        case 'bike':
            document.getElementById("ticketGenerateForm").innerHTML =
                "<form>" +
                "<h1>Select Plan</h1>" +
                "<label><input type='radio' name='price' value=10>RS.10 Daily</br></label>" +
                "<label><input type='radio' name='price' value=200>RS.200 Monthly</br></label>" +
                "<label><input type='radio' name='price' value=1000>RS.1000 Yearly</br></label>" +
                "<input type='button' value='Get Pass' onclick='finalPrice()' />" +
                "</form>";
            break;

        case 'cycle':
            document.getElementById("ticketGenerateForm").innerHTML =
                "<form>" +
                "<h1>Select Plan</h1>" +
                "<label><input type='radio' name='price' value=5>RS.5 Daily</br></label>" +
                "<label><input type='radio' name='price' value=100>RS.100 Monthly</br></label>" +
                "<label><input type='radio' name='price' value=500>RS.500 Yearly</br></label>" +
                "<input type='button' value='Get Pass' onclick='finalPrice()' />" +
                "</form>";
            break;
    }
}