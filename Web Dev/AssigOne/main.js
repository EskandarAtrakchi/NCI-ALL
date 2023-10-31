function filterProducts() {
    //Grab the elements from the doucment 
    var input = document.getElementById('searchInput').value.toLowerCase();
    var rows = document.getElementsByTagName('tr');
    var noResultsMessage = document.querySelector('.informUser'); // Get the <p> element
    var hideTheTableHeader = document.getElementById('customers');
    var notFound = true; // Initialize a variable to track if any results are found
    for (var i = 1; i < rows.length; i++) {//i is equal to 1 and not zero 
        var data = rows[i].textContent || rows[i].innerText;// Get the row 
        if (data.toLowerCase().indexOf(input) > -1) {//it is better to use the lowercase built in method here 
            rows[i].style.display = '';//set the display to noting 
            notFound = false; // Set notFound to false if a match is not Found
        } else {
            rows[i].style.display = 'none';//hide the table data 
            //found = false;//This is just a reminder for me that I might need this later
        }
    }//end for loop 
    // Show/hide the "Not available" message based on whether results are found
    if (notFound) {
        noResultsMessage.style.display = 'block';//display the text 
        hideTheTableHeader.style.display = 'none';//an opportunity to hide the header here also 
    } 
    else {
        noResultsMessage.style.display = 'none';//display the text as hidden  
        hideTheTableHeader.style.display = '';//get the table header back to its original css styling 
    }
}//end method here
