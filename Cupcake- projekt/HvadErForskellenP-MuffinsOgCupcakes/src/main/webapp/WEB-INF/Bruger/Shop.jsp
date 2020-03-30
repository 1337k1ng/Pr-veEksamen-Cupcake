<%@include file="/includes/headerLoggetInd.inc"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /*position skal være "relative" for campatibilty med slærmstørrelser.*/
        .shop-select {
            position: relative;
            font-family: Arial;
        }

        .shop-select select {
            display: none; /*Skuler det originale element*/
        }

        .select-selected {
            background-color: #3C1460;
        }

        /*styling af pilen inde i baren*/
        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*Skifter position på pilen når drop down menuen er åben*/
        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*styling af items i selctionen*/
        .select-items div,.select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/
        .select-items {
            position: absolute;
            background-color: #3C1460;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*Skjuler items når select baren er lukket*/
        .select-hide {
            display: none;
        }

        .select-items div:hover, .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
        }
    </style>
</head>

<div class="bod">
    <div style="margin-left: 1%;">
        <h2 style="padding-top: 20px; font-family: Futura">De bedste muffins man kan forestille sig, er blot et enkelt klik væk:</h2>
        <form action="FrontController" method="post" style="text-align:center">
            <input type="hidden" name="target" value="muffin" >

            <img src="resources/Topping.png" alt="Cinque Terre" width="150" height="150">
            <div style="font-family: Futura">
                <!--<label style="font-family: Futura">Vælg topping:</label>-->
                <div class="shop-select" style="width:200px; margin-left: auto; margin-right: auto">
                    <select name="top">
                        <option value = "">Vælg Topping</option>
                        <option value = "chokolade">Chokolade, 5.00 kr</option>
                        <option value = "blaabaer">Blåbær, 5.00 kr</option>
                        <option value = "hindbaer">Hindbær, 6.00 kr</option>
                        <option value = "kiks">Kiks, 6.00 kr</option>
                        <option value = "jordbaer">Jordbær, 6.00 kr</option>
                        <option value = "rum">Rum og rosin, 7.00 kr</option>
                        <option value = "appelsin">Appelsin, 8.00 kr</option>
                        <option value = "citron">Citron, 8.00 kr</option>
                        <option value = "blaaOst">Blå ost, 9.00 kr</option>
                    </select>
                </div>

                <br>
                <img src="resources/CupcakeButtom.png" alt="Cinque Terre" width="150" height="150">
            </div>
            <div style="display: inline;">
                <!--<label style="font-family: Futura">Muffin bund:</label>-->
                <div class="shop-select" style="width:200px;margin-left: auto; margin-right: auto">
                    <select name="bund">
                        <option value = "">Vælg Bund</option>
                        <option value = "chokoladeBund">Chokolade, 5.00 kr</option>
                        <option value = "vaniljeBund">Vanilje, 5.00 kr</option>
                        <option value = "muskatBund">Muskatnød, 5.00 kr</option>
                        <option value = "pistacieBund">Pistacie, 6.00 kr</option>
                        <option value = "mandelBund">Mandel, 7.00 kr</option>
                    </select>
                </div>
                <br>
                <br>
            </div>
            <input class="button" type="submit" value="Submit">
        </form>
        <h4 class="custom-header">TODO: Denne side burde kun vises hvis man er logget ind!</h4>
    </div>
</div>



<body>

<script>
    var x, i, j, selElmnt, a, b, c;
    /*look for any elements with the class "shop-select":*/
    x = document.getElementsByClassName("shop-select");
    for (i = 0; i < x.length; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 1; j < selElmnt.length; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function(e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                h = this.parentNode.previousSibling;
                for (i = 0; i < s.length; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        for (k = 0; k < y.length; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function(e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        for (i = 0; i < y.length; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < x.length; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }
    /*if the user clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);
</script>

</body>

<%@include file="/includes/footer.inc"%>
