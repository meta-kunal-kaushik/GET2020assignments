export{};
let empId : Number = Math.floor(Math.random() * 100);
let vehicleIs : string[] = ["cycle", "bike", "car"];
let money : number[][]= new Array(3);
money[0] = new Array(3);
money[1] = new Array(3);
money[2] = new Array(3);
money[0] = [5, 100, 500];
money[1] = [10, 200, 1000];
money[2] = [20, 500, 3500];
let unitCurrency = [1, 0.014, 1.45] // Rs 1 in [rupee,usd,yen]
let option = 0;

let hideMe = (id) => {
    if (id == 'username' && isCorrectName()) {
        document.getElementById("username").style.display = 'none';
        document.getElementById("gender").style.display = 'initial';
        document.getElementById("message").innerHTML = '';
    } else if (id == 'gender' && isGenderChecked()) {
        document.getElementById("gender").style.display = 'none';
        document.getElementById("email").style.display = 'initial';
        document.getElementById("message").innerHTML = '';
    } else if (id == 'email' && isCorrectEmail()) {
        document.getElementById("email").style.display = 'none';
        document.getElementById("password").style.display = 'initial';
        document.getElementById("message").innerHTML = "Note : Password should have Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character "
    } else if (id == 'password' && passwordStrength()) {
        document.getElementById("password").style.display = 'none';
        document.getElementById("confirmPassword").style.display = 'initial';
        document.getElementById("message").innerHTML = '';
    } else if (id == 'confirmPassword' && isPasswordAndConfirmPassMatch()) {
        document.getElementById("confirmPassword").style.display = 'none';
        document.getElementById("contactNo").style.display = 'initial';
        document.getElementById("message").innerHTML = '';
    } else if (id == 'contactNo' && isCorrectPhoneNo()) {
        document.getElementById("form1").style.display = 'none';
        document.getElementById("form2").style.display = 'inherit';
        document.getElementById("message").innerHTML = '';
    } else if (id == 'vehicleName' && isCorrectVehicleName()) {
        document.getElementById("vehicleName").style.display = 'none';
        document.getElementById("vehicleType").style.display = 'initial';
        document.getElementById("message1").innerHTML = '';
    } else if (id == 'vehicleType' && isCorrectVehicleType()) {
        document.getElementById("vehicleType").style.display = 'none';
        document.getElementById("idOfEmp").style.display = 'initial';
        document.getElementById("message1").innerHTML = '';
    } else if (id == 'idOfEmp') {
        document.getElementById("idOfEmp").style.display = 'none';
        document.getElementById("typeOfVehicle").style.display = 'initial';
        document.getElementById("message1").innerHTML = '';
    } else if (id == 'typeOfVehicle') {
        document.getElementById("typeOfVehicle").style.display = 'none';
        document.getElementById("description").style.display = 'inherit';
        document.getElementById("message1").innerHTML = '';
    } else if (id == 'description') {
        document.getElementById("form2").style.display = 'none';
        document.getElementById("form3").style.display = 'inherit';
        document.getElementById("message1").innerHTML = '';
    } else if (id == 'priceCatalog') {
        document.getElementById("priceCatalog").style.display = 'none';
        document.getElementById("finalBill").style.display = 'inherit';
        document.getElementById("message2").innerHTML = '';
    }


}

let passwordStrength = ()=> {
    let password = (<HTMLInputElement>document.getElementById("pass")).value; //type assertion is done to use .value property
    let returnVal = false;
    // Minimum eight characters and any combination of number: (weak)
    if (/^(?=.*\d)[\d]{8,}$/.test(password)) {
        document.getElementById('pass').style.borderColor = 'red';
        document.getElementById("message").innerHTML = "Password too weak";
    }
    // Minimum eight characters, at least one uppercase letter, one lowercase letter and one number: (medium)
    else if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/.test(password)) {
        document.getElementById('pass').style.borderColor = 'yellow';
        document.getElementById("message").innerHTML = "Note : Password should have Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character "
    }
    // Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character: (strong)
    else if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$/.test(password)) {
        document.getElementById('pass').style.borderColor = 'green';
        document.getElementById("message").innerHTML = "It's a good one..";
        returnVal = true;
    }
    return returnVal;
}

let isCorrectPhoneNo = ()=> {
    let phoneNo = (<HTMLInputElement>document.getElementById("contact")).value;
    if (/[0-9]{8,10}$/.test(phoneNo)) {
        return true;
    } else {
        document.getElementById("message").innerHTML = "Note : contact number should be a valid 8 to 10 digit number";
    }
    return false;
}

let isCorrectEmail = ()=> {
    let email = (<HTMLInputElement>document.getElementById('emailId')).value;
    let returnVal = false;
    if (/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/.test(email)) {
        returnVal = true;
    } else {
        document.getElementById("message").innerHTML = "Please enter a valid Email id";
    }
    return returnVal;
}

let isCorrectName = ()=> {
    let name = (<HTMLInputElement>document.getElementById('name')).value;
    let vehicleName = (<HTMLInputElement>document.getElementById('VehicleName')).value;
    let vehicleType = (<HTMLInputElement>document.getElementById('VehicleType')).value;
    // console.log("hello" + vehicleName + "  " + vehicleType);
    let returnVal = false;
    if (/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(name) || /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(vehicleName) || /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(vehicleType)) {
        returnVal = true;
    } else {
        document.getElementById("message").innerHTML = "Please enter a valid name";
    }
    return returnVal;
}

let isPasswordAndConfirmPassMatch = ()=> {
    let password = (<HTMLInputElement>document.getElementById("pass")).value;
    let confirmPassword = (<HTMLInputElement>document.getElementById("confirmPass")).value;
    let returnVal = false;
    if (confirmPassword == password) {
        returnVal = true;
    } else {
        document.getElementById("message").innerHTML = "Please try again. There a miss match";
    }
    return returnVal;
}

let isGenderChecked = ()=> {
    let returnVal = false;
    if ((<HTMLInputElement>document.getElementById('male')).checked || (<HTMLInputElement>document.getElementById('female')).checked) {
        returnVal = true;
    } else {
        document.getElementById("message").innerHTML = "Please select your gender";
    }
    return returnVal;
}

let setEmpId = ()=> {
    console.log("emp id : " + empId);
    (<HTMLInputElement>document.getElementById('empId')).value = "Employy ID : " + empId;
}

let isCorrectVehicleName = ()=> {
    setEmpId();
    let vehicleName = (<HTMLInputElement>document.getElementById('VehicleName')).value;
    let returnVal = false;
    if (/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(vehicleName)) {
        returnVal = true;
    } else {
        document.getElementById("message1").innerHTML = "Please enter a valid Vehicle name";
    }
    return returnVal;
}

let isCorrectVehicleType = ()=> {
    let vehicleType = (<HTMLInputElement>document.getElementById('VehicleType')).value;
    let returnVal = false;
    if (/^[a-zA-Z]{2}.{4}[0-9]{4}/.test(vehicleType)) {
        returnVal = true;
    } else {
        document.getElementById("message1").innerHTML = "Please enter a valid Vechile type Example : Rj14150000";
    }
    return returnVal;
}

let showPrices = ()=> {
    let currency = (<HTMLInputElement>document.querySelector('#TypeOfCurrency')).value;
    let vehicleChosen = (<HTMLInputElement>document.querySelector('#TypeOfVehicle')).value;
    let unitAmount;
    for (let index = 0; index < vehicleIs.length; index++) {
        if (vehicleChosen == vehicleIs[index])
            option = index;
    }
    if (currency == "yen") {
        unitAmount = unitCurrency[2];
    }
    if (currency == "usd") {
        unitAmount = unitCurrency[1];
    }
    if (currency == "rupees" || currency == "none") {
        unitAmount = unitCurrency[0];
    }
    document.getElementById("priceCatalog").innerHTML = "<div class='priceCatalog'><label>Daily : <input type='radio' name='price' value=" + money[option][0] * unitAmount + ">" + money[option][0] * unitAmount + "</label><label>Daily : <input type='radio' name='price'>" + money[option][1] * unitAmount + "</label><label>Daily : <input type='radio' name='price'>" + money[option][2] * unitAmount + "</label>" + "<input type='button' value='Get Pass' onClick='billingAmount()'>";
}

let billingAmount = ()=> {
    document.getElementById('form3').innerHTML = "<div class='bill'>Thanks for trying our services</div> "
}