<%-- 
    Document   : shopping
    Created on : 13-Jun-2023, 12:01:59 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
        <!--<link rel="stylesheet" href="style.css">-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

        <style>

            .navbar {
                background-color: #212529;
                color: white;
                display: flex;
                justify-content: space-between;
                padding: 25px;
                margin-bottom: 70px;

            }
            .store-name {
                color: white;
                margin-top: 13px;
                margin-bottom: 10px;
                font-size: 25px;
                cursor: pointer;

            }
            .cart {
                background-color: white;
                border-radius: 4px;
                padding: 7px 7px;
                color: black;
                font-size: 25px;
                position: relative;
                cursor: pointer;
            }
            .cart-amount {
                position: absolute;
                background-color: red;
                padding: 3px 3px;
                color: white;
                border-radius: 4px;
                font-size: 18px;
                top: -10px;
                right: -10px;
            }
            .bi-dash-lg {
                color: orangered;
                cursor: pointer;
            }

            .bi-plus-lg {
                color: green;
                cursor: pointer;
            }
            .product-quantity{
                display: inline;
            }
            .div {

                display:flex;
                flex-direction: row;
                justify-content: space-between;
                width: 100px;
                /*flex-wrap: wrap;*/
            }
            .cart-items {

                /*display: none;*/
            }

        </style>
    </head>


    <body>
        <div class="navbar">

            <h2 class="store-name">Insta-Mart</h2>
            <div class="cart">
                <button form="cart-items" type="submit" onclick=" return generateCartItems()"> <i class="bi bi-cart2"></i></button>


                <div id="cart-amount" class="cart-amount">0</div>
            </div>
        </div>

        <section style="background-color: #eee;">
            <div class="container py-5">


                <c:forEach items = "${products}" var="product">
                    <c:if test="${product.quantity > 0 && product.status}" >
                        <div class="row justify-content-center mb-3">
                            <div class="col-md-12 col-xl-10">
                                <div class="card shadow-0 border rounded-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Product/img%20(4).webp"
                                                         alt ="PRODUCT" class="w-100" />
                                                    <a href="#!">
                                                        <div class="hover-overlay">
                                                            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);">
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 col-xl-6">
                                                <h5>${product.name}</h5>
                                                <h5>${product.weight}</h5>
                                                <div class="d-flex flex-row">
                                                    <div class="text-danger mb-1 me-2">
                                                        <i class="bi bi-star-fill"></i>
                                                        <i class="bi bi-star-fill"></i>
                                                        <i class="bi bi-star-fill"></i>
                                                        <i class="bi bi-star-fill"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                                <div class="d-flex flex-row align-items-center mb-1">
                                                    <h4 class="mb-1 me-1">&#x20b9;${product.price}</h4>
                                                </div>
                                                <div class="d-flex mt-4 div" id = "div-${product.id}">
                                                    <button class="btn btn-primary btn-sm" id = "button-${product.id}" type="button" onclick="addToCart(${product.quantity},${product.id},${product.price}, '${product.name}')">Add to Cart</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>

            </div>
        </section>


        <form action = "check-out" id = "cart-items" name = "cart-items" method = "post">
            <table>
                <thead>
                    <tr>
                        <td>id<td>
                        <td>quantity<td>
                        <td>price<td>
                        <td>name<td>
                    </tr>
                </thead>
                <tbody id = "tbody">

                </tbody>

            </table>
        </form>

        <script>

            var cart = [];

            function addToCart(quantity, id, price, productName) {

                console.log("quantity" + quantity + ", productId" + id);
                let findProduct = cart.find(product => product.id == id);
                if (findProduct != undefined) {

                    findProduct.quantity = findProduct.quantity + 1;
                    document.getElementById('quantity-' + id).innerText = findProduct.quantity;
                } else {
                    cart.push({id: id,
                        quantity: 1,
                        price: price,
                        name: productName});

                    let htmlElement = "<i class='bi bi-dash-lg remove' onclick ='removeFromCart(" + quantity + "," + id + "," + price + ",\"" + productName + "\"  )'></i> \n\
                       <p class = 'remove' id = 'quantity-" + id + "'>1</p>\n\
                        <i class='bi bi-plus-lg remove' onclick='addToCart(" + quantity + "," + id + "," + price + ",\"" + productName + "\" )'></i> ";

                    document.getElementById("button-" + id).remove();
                    document.getElementById('div-' + id)
                            .insertAdjacentHTML("afterbegin",
                                    htmlElement);
                }
                updateCartQuantity();
                console.log(cart);
            }

            function removeFromCart(quantity, id, price, productName) {

                console.log("inside removeFromCart()" + quantity + id);
                let product = cart.find(product => product.id == id);
                let buttonHtmlElement = "<button class='btn btn-primary btn-sm'\n\
                 id = 'button-" + id + "' type = 'button' onclick='addToCart(" + quantity + "," + id + "," + price + ",\"" + productName + "\" )'>\n\
                  Add to Cart</button>";
                if (product !== undefined) {
                    if (product.quantity == 1) {
                        console.log(`inside if condition`);
                        cart = cart.filter(item => item.id !== id); // removing the data
                        let parentDiv = document.getElementById("div-" + id);
                        while (parentDiv.firstChild) {
                            parentDiv.removeChild(parentDiv.firstChild);
                        }
                        document.getElementById("div-" + id).insertAdjacentHTML("afterbegin", buttonHtmlElement);
                    } else if (product !== undefined && product.quantity > 1) {
                        product.quantity = product.quantity - 1;
                        document.getElementById("quantity-" + id).innerText = product.quantity;
                    }
                }
                updateCartQuantity();
                console.log(cart);
            }

            // add product to form 
            var generateCartItems = () => {
                console.log("inside generateCartItems");

                if (cart.length > 0) {
                    cart.map((product) => {
                        document.getElementById("tbody").insertAdjacentHTML("afterbegin", " <tr> \n\
         <td><input name = 'id' value =" + product.id + " /></td> \n\
<td><input name = 'quantity' value = " + product.quantity + " /></td>\n\
<td><input name = 'price' value = " + product.price + " /></td>\n\
<td><input name = 'name' value = \"" + product.name + "\"/></td></tr>");
                    });
                } else if (cart.length == 0) {
                    confirm(`Your cart is empty please add item to cart and proceed`);
                    return false;
                }

            };

            function updateCartQuantity() {
                document.getElementById("cart-amount").innerText = cart.length;

            }

        </script>

    </body>

</html>
