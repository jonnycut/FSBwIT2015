<nav>
    Inhaltsverzeichnis

    <ul>
        <?php
        foreach($pages as $key => $value){
            echo "<li><a href='?page=$key'>$value</a></li>"; #generieren der Links. das ? gibt die Variable weiter, mit <ul> und <li> wird eine Liste generiert
        }
        ?>


    </ul>
</nav>