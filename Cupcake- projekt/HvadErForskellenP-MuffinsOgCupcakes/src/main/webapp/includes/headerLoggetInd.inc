    <html>
        <head>
            <title>Cupcake projekt</title>
            <link rel="stylesheet" type="text/css" href="stylesheets/header.css">

        </head>
        <body>
           <img src="resources/olskercupcakes.png">

           <div class="navigation-bar">


         <a href="FrontController?target=to&to=home" class="navigation-item" >Home</a>
         <a href="FrontController?target=to&to=logout" class="navigation-item" >Log ud</a>
         <a href="FrontController?target=to&to=shop" class="navigation-item">Shop</a>


         <!-- OPS!! Skal have ny css class, hvor så den ikke ligner en knap som de andre -->
        <a class="navigation-item" id="email-item" >  ${sessionScope.email} </a>

         <a href="FrontController?target=to&to=kurv"  id="basket"> <img src="basket.png"></a>




          </div>
        </body>
