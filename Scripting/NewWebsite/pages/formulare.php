
<form action="" method="post">
    <input type="text" placeholder="name" name="login"><br>
    <input type="password" placeholder="password" name="password"><br>
    <button type="submit">Anmelden</button>
    <input type="reset" value="Reset">
    <input type="hidden" name="page" value="formulare">
</form>
    <?php

    if (isset($_POST['login']) && isset($_POST['password'])) {
        echo $_POST['login'] . ': ' . $_POST['password'];
    }else{
        echo "nix";
    }
    ?>




<!--<form action="" method="post"> <!--"get" ist Standard, muss nicht extra geschrieben werde-->
<!--Nur bei "post"-Methoden erforderlich -->
<!---->
<!--    <input type="text" placeholder="name" name="login"><br>-->
<!--    <!-- "name" (hier: login) wird der key, unter dem der Nutzername im '$_GET' - Array gespeichert wird -->
<!--    <!-- "text" => sorgt dafuer, dass der Name als Text angezeigt wird -->
<!--    <!-- "placeholder" => Text der im Feld vorgedruckt ist...verschwidet beim Klick ins Feld -->
<!--    <input type="password" placeholder="password" name="password"><br>-->
<!--    <!-- "password" => sorgt dafuer, dass das Password nur als Sterne dargestellt wird -->
<!--    <!-- "name" (password: login) wird der key, unter dem der Nutzername im '$_GET' - Array gespeichert wird -->
<!--    <button type="submit">Anmelden</button>-->
<!--    <!-- <input type="hidden" name="page" value="formulare">-->
<!--    <!-- <input type="submit" value="Anmelden">--
<!--    <input type="reset" value="Reset">-->
<!---->
<!---->
<!--</form>-->

