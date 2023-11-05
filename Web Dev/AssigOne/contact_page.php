<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get form data
    $fname = $_POST["fname"];
    $surname = $_POST["surname"];
    $contactus = $_POST["contactus"];
    $subject = $_POST["subject"];
    $filename = $_FILES["filename"]["name"];
    
    // Configure email parameters
    $to = "x23137517@student.ncirl.ie"; 
    $subject = "Contact Us Form Submission";
    $message = "First Name: $fname\n";
    $message .= "Last Name: $surname\n";
    $message .= "Contacting Us For: $contactus\n";
    $message .= "Subject: $subject\n";
    
    // Upload file (if provided)
    if ($filename) {
        $uploadsDirectory = "uploads/"; // Create an "uploads" directory to store uploaded files
        move_uploaded_file($_FILES["filename"]["tmp_name"], $uploadsDirectory . $filename);
        $message .= "Attached File: $uploadsDirectory$filename\n";
    }
    
    // Send email
    mail($to, $subject, $message);
    
    // Redirect to a thank you page or back to the form
    header("Location: thank_you.html");  // Create a thank you page or use your own URL
    exit;
}
?>
