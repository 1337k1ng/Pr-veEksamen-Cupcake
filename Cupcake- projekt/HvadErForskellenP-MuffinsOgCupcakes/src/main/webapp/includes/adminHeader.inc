<html>
        <head>
            <title>Cupcake projekt</title>
            <link rel="stylesheet" type="text/css" href="stylesheets/header.css">

        </head>
        <body>
           <img src="resources/olskercupcakes.png">

           <div class="navigation-bar">


         <a href="FrontController?target=to&to=adminHome" class="navigation-item">Home</a>
         <a href="FrontController?target=to&to=brugere" class="navigation-item">Brugere</a>
         <a href="FrontController?target=to&to=ordre" class="navigation-item">Ordre</a>
 

         <!-- OPS!! Skal have ny css class, hvor så den ikke ligner en knap som de andre -->
        <a class="navigation-item" id="email-item" >  ${sessionScope.email} </a>

                        
          </div>
        </body>
