<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8" indent="yes"/>
<!-- the starting tage from moodle -->

<!--<xsl:output method="html"/>-->

  <xsl:template match="/">
  <!--The / is an XPath expression that references a node set from the source document -->
  <!-- starting html -->
    <html>
      <head>
        <title>Product Information</title>
        <!-- linking the main.js here -->
        <script src="main.js"></script>
        <!--linking the css styling sheet here -->
        <link rel="stylesheet" href="style.css"></link>
        <!-- for the tabe icon -->
        <link rel="website icon" href="https://moonbeam.network/wp-content/uploads/2020/10/rotating-ethereum-logo.gif"></link>
      </head>
      <body>
        <img src="https://moonbeam.network/wp-content/uploads/2020/10/rotating-ethereum-logo.gif" style="padding-left:1%; width:2%; height:8%;" alt="Logo"></img>
        <input type="checkbox" name="checkbox" class="switch" id="darkModeCheckbox"></input>
    
        <script>
            // Check if dark mode is enabled and apply the appropriate styles
            var darkModeEnabled = false;
            if (darkModeEnabled) {
            applyDarkMode();
            } else {
            applyLightMode();
            }
            // Add an event listener to the checkbox to call the toggleDarkMode function when it's clicked
            document.getElementById("darkModeCheckbox").addEventListener("click", toggleDarkMode);
        </script>

        <!-- marquee here -->
        <marquee>Discover Innovation Unfolding – Where Quality Meets Technology!</marquee>
        <!-- I will use <br><hr></hr></br> to create a simple space -->
        <br><hr></hr></br><div style="padding-bottom:.1%;"></div>
        <!-- nav bar here -->
        <div class="topnav">
          <a href="http://localhost/test/XML.xml">Product Search</a>
          <a href="productList.html">Product List</a>
          <a href="contactUs.html">Contact Us</a>
          <a href="feedback.html" class="split">Feedback</a>
        </div>
        <h1>Product Search</h1>

        <!-- displaying the button and the searching bar as block -->
        <div style="display:block;">
          <div class="form-control">
            <!-- taking user input -->
            <input class="input input-alt" type="text" id="searchInput" placeholder="Search for products..."></input>
            <span class="input-border input-border-alt"></span>
          </div>
          
          <!-- Button starts here -->
          <button class="Btn" onclick="filterProducts()">
    
            <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
            
            <div class="text">Search</div>
          </button>
        </div>

        <br><hr></hr></br>

        <!-- table of the contents starts here -->
        <table id="customers">
          <tr>
            <th>Code</th>
            <th>Category</th>
            <th>Name</th>
            <th>Description</th>
            <th>Size</th>
            <th>Color</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Discount</th>
          </tr>

          <!-- in case one of the elements are not available in the search the paragraph should pop up -->
          <p class="informUser">Not available</p>
          <!-- to access the node from the root to the parent to the child by "/" expression -->
          <xsl:apply-templates select="company/products/product"/>
        </table>
        <br></br><hr></hr>
    <!-- Footer section -->
    <footer>
        <div>
            <!--Social media icons -->
            <ul style="display:flex;">
                <a href="https://www.facebook.com" style="padding:3%; padding-left: 38.555555%; color:aqua;">
                    <svg xmlns="http://www.w3.org/2000/svg" class="iconsblog"
                    id="fb-ico" width="2rem" height="2rem" fill="currentColor" viewBox="0 0 16  16">
                    <path
                        d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
                    </svg>
                </a>
                <a href="https://www.linkedin.com" style="padding:3%; color:aqua;">
                    <svg xmlns="http://www.w3.org/2000/svg" class="iconsblog"
                    id="li-ico" width="2rem" height="2rem" fill="currentColor" viewBox="0 0 16  16">
                    <path
                        d="M0 1.146C0 .513.526 0 1.175 0h13.65C15.474 0 16 .513 16 1.146v13.708c0 .633-.526 1.146-1.175 1.146H1.175C.526 16 0 15.487 0 14.854V1.146zm4.943 12.248V6.169H2.542v7.225h2.401zm-1.2-8.212c.837 0 1.358-.554 1.358-1.248-.015-.709-.52-1.248-1.342-1.248-.822 0-1.359.54-1.359 1.248 0 .694.521 1.248 1.327 1.248h.016zm4.908 8.212V9.359c0-.216.016-.432.08-.586.173-.431.568-.878 1.232-.878.869 0 1.216.662 1.216 1.634v3.865h2.401V9.25c0-2.22-1.184-3.252-2.764-3.252-1.274 0-1.845.7-2.165 1.193v.025h-.016a5.54 5.54 0 0 1 .016-.025V6.169h-2.4c.03.678 0 7.225 0 7.225h2.4z"></path>
                    </svg>
                </a>
                <a href="https://www.twitter.com" style="padding:3%; color:aqua;">
                    <svg xmlns="http://www.w3.org/2000/svg" class="iconsblog"
                    id="tw-ico" width="2rem" height="2rem" fill="currentColor" viewBox="0 0 16 16">
                    <path
                        d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
                    </svg>
                </a>
            </ul>
        </div>
        <p style="color: aqua;">2023 IT company for electronics
        <br></br>
        Developing, maintaining, and updating a third-party company's web application by <strong>Eskandar Atrakchi</strong> 
        </p>
    </footer>

    <!--Arrow to go up -->
    <a href="#top">
        <h1><img src="https://archive.org/download/arrowup/arrowup.gif" style="width:3%; height:6%; float:right;" alt="IMG-HERE"></img></h1>
    </a>
      </body>
    </html>
  </xsl:template>

  <!-- if the template maches the artibute or element tag then render its values on the table accordingly -->
  <xsl:template match="product">
    <tr>
      <td><xsl:value-of select="@code"/></td>
      <td><xsl:value-of select="category"/></td>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="description"/></td>
      <td><xsl:value-of select="size"/></td>
      <td><xsl:value-of select="color"/></td>
      <td><xsl:value-of select="quantity"/></td>
      <td><xsl:value-of select="unit_price"/> $</td>
      <td><xsl:value-of select="discount"/></td>
    </tr>
  </xsl:template>
</xsl:stylesheet>
