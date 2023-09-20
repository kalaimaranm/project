<%-- 
    Document   : payment-option
    Created on : 15-Jun-2023, 12:24:14 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                background-color: #ffffff;

            }
            .container{
                width: 600px;
                background-color: #fff;
                padding-top: 100px;
                padding-bottom: 100px;

            }
            .card{
                background-color: #fff;
                width: 300px;
                border-radius: 15px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            .name{
                font-size: 15px;
                color: #403f3f;
                font-weight: bold;
            }
            .cross{
                font-size: 11px;
                color: #b0aeb7;
            }
            .pin{
                font-size: 14px;
                color: #b0aeb7;
            }
            .first{
                border-radius: 8px;
                border: 1.5px solid #78b9ff;
                color: #000;
                background-color: #eaf4ff;
            }
            .second{
                border-radius: 8px;
                border: 1px solid #acacb0;
                color: #000;
                background-color: #fff;
            }
            .dot{

            }
            .head{
                color: #137ff3;
                font-size: 12px;
            }
            .dollar{
                font-size: 18px;
                color: #097bf7;
            }
            .amount{
                color: #007bff;
                font-weight: bold;
                font-size: 18px;

            }
            .form-control{
                font-size: 18px;
                font-weight: bold;
                width: 100px;
                /*width: 60px;*/
                height: 28px;

            }
            .back{
                color: #aba4a4;
                font-size: 15px;
                line-height: 73px;
                font-weight: 400;
            }
            .button{
                width: 150px;
                height: 60px;
                border-radius: 8px;
                font-size: 17px;
            }
        </style>
    </head>

    <body>
        <div class = "alignment" align = "center">
            <div class="container d-flex justify-content-center mt-5">
                <div class="card">



                    <div>
                        <div class="d-flex pt-3 pl-3">

                            <div align = "center" ><img src="https://img.icons8.com/ios-filled/50/000000/visa.png" width="60" height="80" /></div>
                            <div class="mt-3 pl-2"><span class="name">Payment Option</span>
                            </div><br/><br/>

                            <form action = "initiate-payment" name = "payment" method = "post">

                                <div class="py-2  px-3">
                                    <div class="first pl-2 d-flex py-2">
                                        <div class="form-check">
                                            <input  type="radio" onclick="payLater()" id = "pay-later-radio"name="payment-option" value ="pay-later" class="form-check-input mt-3 dot" checked>
                                        </div>
                                        <div class="border-left pl-2"><strong><span class="head">Pay Later</span></strong><div><span class="dollar">&#x20B9;</span><span class="amount" id = "total-amount">${sessionScope.order.total}</span></div></div>

                                    </div>
                                </div>


                                <div class="py-2  px-3">
                                    <div class="second pl-2 d-flex py-2">
                                        <div class="form-check">
                                            <input type="radio" id = "pay-now-radio" onclick= "insertInputTag()" name="payment-option" value ="pay-now" class="form-check-input mt-3 dot">
                                        </div>
                                        <div class="border-left pl-2"  id = "pay-later" ><strong><span class="head">Partial/Full Payment</span></strong><div class="d-flex"><span class="dollar">&#x20B9;</span>
                                            </div></div>

                                    </div> 
                                </div>	


                                <div align = "center" class="d-flex justify-content-between px-3 pt-4 pb-3">
                                    <button type="submit" onclick="return paymentValidation()" class="btn btn-primary button">Pay amount</button>
                                </div>

                            </form>

                        </div>
                    </div>

                </div>
            </div>

            <script>
                var billAmount = document.getElementById('total-amount').innerText;
                function insertInputTag() {
                    let isElementExist = document.getElementById('partial-full-payment-input') || false;
                    if (!isElementExist) {
                        document.getElementById("pay-later").insertAdjacentHTML("beforeend", "<input type = 'number' name = 'amount' id = 'partial-full-payment-input' required value = \"" + billAmount + "\"/>")
                    }


                }
                function payLater() {

                    document.getElementById('partial-full-payment-input').remove();
                }



                function paymentValidation() {
                    console.log("billAmount : " + billAmount);
                    let payLater = document.getElementById('pay-later-radio').checked;
                    let payNow = document.getElementById('pay-now-radio').checked;
                    if (payNow) {

                        let userAmount = Number(document.getElementById('partial-full-payment-input').value).toFixed(1);
                        if (userAmount === billAmount) {
                            console.log("user Amount: " + userAmount + "billAmount : " + billAmount);
                            return true;
                        } else if (userAmount > billAmount || userAmount > billAmount) {

                            console.log("user Amount: " + userAmount + "billAmount : " + billAmount);
                            return confirm("Entered Amount Rs." + userAmount + " is higher than the bill Amount Rs." + billAmount);

                        } else if (userAmount < billAmount) {

                            console.log("user Amount: " + userAmount + "billAmount : " + billAmount);
                            console.log(userAmount);
                            return confirm("Balance Bill Amount will be added to your debt balance press confirm to proceed");
                            console.log("userAmount is smaller tha bilAmount : " + result);
                        }
                    }
                    if (payLater) {

                        return true;
                    }
                }


            </script>
    </body>
</html>

