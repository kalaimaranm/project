<%-- 
    Document   : view_customer
    Created on : 03-Apr-2023, 11:58:55 pm
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>CodePen - Student Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

        <style>
            .student-profile .card {
                border-radius: 10px;

            }
            .student-profile .card .card-header .profile_img {

                width: 150px;
                height: 150px;

                object-fit: cover;
                margin: 10px auto;

                border: 10px solid #ccc;
                border-radius: 50%;
            }
            .student-profile .card h3 {
                font-size: 20px;
                font-weight: 700;
            }
            .student-profile .card p {
                font-size: 16px;
                color: #000;
            }

            .student-profile .table th,
            .student-profile .table td {
                font-size: 14px;
                padding: 5px 10px;
                color: #000;
            }
            .button-67 {
                align-items: center;
                background: #CCD1D1;

                /*background: #f5f5fa;*/
                border: 0;
                border-radius: 8px;
                box-shadow: -10px -10px 30px 0 #fff,10px 10px 30px 0 #1d0dca17;
                box-sizing: border-box;
                color: #2a1f62;
                cursor: pointer;
                display: flex;
                font-family: Cascadia Code,Consolas,Monaco,Andale Mono,Ubuntu Mono,monospace;
                font-size: 1rem;
                justify-content: center;
                line-height: 1.5rem;
                padding: 15px;
                position: relative;
                text-align: left;
                transition: .2s;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
                white-space: pre;
                width: max-content;
                word-break: normal;
                word-spacing: normal;
            }
            .button-67:hover {
                background: #f8f8ff;
                box-shadow: -15px -15px 30px 0 #fff, 15px 15px 30px 0 #1d0dca17;
            }

            @media (min-width: 768px) {
                .button-67 {

                    padding: 24px;
                }
            }

        </style>
    </head>
    <body>
        <c:if test="${customerprofile != null}">
            <!-- Student Profile -->
            <div class="student-profile py-4">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card shadow-sm">
                                <div class="card-header bg-transparent text-center">
                                    <img class="profile_img" src="https://placeimg.com/640/480/arch/any" alt="image">
                                    <h3>${customer.name}</h3>
                                </div>
                                <div class="card-bo
                                     <p class="mb-0"><strong class="pr-1">Customer ID:</strong>${customer.id}</p>
                                    <p class="mb-0"><strong class="pr-1">Status:</strong>${customer.status ? "Active" : "InActive"}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card shadow-sm">
                                <div class="card-header bg-transparent border-0">
                                    <h3 class="mb-0"><i class="far fa-clone pr-1"></i>General Information</h3>
                                </div>
                                <div class="card-body pt-0">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th width="30%">Phone no</th>
                                            <td width="2%">:</td>
                                            <td>${customer.phone}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">Aadhaar No	</th>
                                            <td width="2%">:</td>
                                            <td>${customer.aadhaar}</td>
                                        </tr>
                                        <!--                                    <tr>
                                                                                <th width="30%">Gender</th>
                                                                                <td width="2%">:</td>
                                                                                <td>Male
                                                                            </tr>-->
                                        <tr>
                                            <th width="30%">Debt Balance</th>
                                            <td width="2%">:</td>
                                            <td id = "debt-amount">${customer.debtBalance}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">Wallet Balance</th>
                                            <td width="2%">:</td>
                                            <td>${customer.walletBalance}</td>
                                        </tr>
                                    </table>
                                    <div class="card-header bg-transparent border-0">
                                        <h3 class="mb-0"><i class="far fa-clone pr-1"></i>Address</h3>
                                    </div>
                                    <table class="table table-bordered">
                                        <tr>
                                            <th width="30%">Door/House no</th>
                                            <td width="2%">:</td>
                                            <td>${customer.address.houseNo}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">Street</th>
                                            <td width="2%">:</td>
                                            <td>${customer.address.street}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">Distric</th>
                                            <td width="2%">:</td>
                                            <td>${customer.address.distric}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">State</th>
                                            <td width="2%">:</td>
                                            <td>${customer.address.state}</td>
                                        </tr>
                                        <tr>
                                            <th width="30%">Pincode</th>
                                            <td width="2%">:</td>
                                            <td>${customer.address.pincode}</td>
                                        </tr>
                                    </table>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${customerprofile != null}">
                <form name = "paydebt" action = "paydebt?id=${customer.id}" method = "post">
                    <label for='amount'>Debt Amount</label>
                    <input id = "amount"  onchange="return debtAmountValidation()"  name = "amount" type='text'required /><br />
                    <input onclick="debtAmountonClickValidation()" type = 'submit' value = 'Pay Debt' id = "debt-input"/>
                </form>
                <label> delete button</label>
                <a href = "deletecustomer?id=${customer.id}" onclick = "return checkDebt()" onclickclass=w3-button w3-black><button class=w3-button w3-black>delete</button></a><br/><br/>
                <div id = "message"></div>
            </c:if>

            <script>
                function checkDebt() {
                    let debtAmount = document.getElementById("debt-amount").innerHTML;
                    console.log(`inside checkDebt()${debtAmount}`);
                    console.log(debtAmount);
                    if (debtAmount == 0) {
                        return confirm("Confirm your account and Press ok button");
                    } else if (debtAmount > 0) {
                        document.getElementById("message").insertAdjacentHTML("afterBegin", `<h3 align="center" style = "color:red">
                 Sorry customer have debt balance Rs.${debtAmount}\n Pay debt balance to delete account</h3>`);
                        return false;
                    }




                }
                //        document.getElementById("debt-input").addEventListener('change', (event) => {
                //
                //            let debtInput = document.getElementById("debt-input").value;
                //            let debtAmount = document.getElementById("debt-amount").value;
                //            if (debtInput <= debtAmount) {
                //                document.body.insertAdjacentElement(`<h3 align="center" style = "color:red">Entered Amount is higher than debt amount</h3>`);
                //                return false;
                //            } else if (debtInput == 0) {
                //                document.body.insertAdjacentElement(`<h3 align="center" style = "color:red">Entered Amount is Rs.0</h3>`);
                //                return false;
                //            }
                //            return true;
                //        });

                function debtAmountValidation() {
                    console.log(`inside debtAmountValidation()`);

                    let debtInput = document.getElementById("debt-input").value;
                    let debtAmount = document.getElementById("debt-amount").value;
                    if (debtInput <= debtAmount) {
                        document.body.insertAdjacentElement(`<h3 align="center" style = "color:red">Entered Amount is higher than debt amount</h3>`);
                        return false;
                    } else if (debtInput == 0) {
                        document.body.insertAdjacentElement(`<h3 align="center" style = "color:red">Entered Amount is Rs.0</h3>`);
                        return false;
                    }
                    return true;
                }

                function debtAmountonClickValidation() {
                    console.log(`inside debtAmountonClick()`);

                    let debtInput = document.getElementById("debt-input").value;
                    let debtAmount = document.getElementById("debt-amount").value;
                    if (debtInput <= debtAmount || debtInput == 0) {
                        document.body.insertAdjacentElement(`<h3 align="center" style = "color:red">Entered valid Amount debt amount</h3>`);

                        return fasle;

                    }
                    return true;
                }
            </script>
    </body> 
</html>

