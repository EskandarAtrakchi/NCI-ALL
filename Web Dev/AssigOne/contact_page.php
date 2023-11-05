<?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $to = "x23137517@gmail.com";
            $subject = "Contact Form Submission";

            $message = "First Name: " . $_POST["fname"] . "\n";
            $message .= "Last Name: " . $_POST["surname"] . "\n";
            $message .= "Contacting Us For: " . $_POST["contactus"] . "\n";
            $message .= "Subject: " . $_POST["subject"] . "\n";

            $headers = "From: " . $_POST["fname"] . " " . $_POST["surname"] . "\r\n";

            mail($to, $subject, $message, $headers);
        }
    ?>
    