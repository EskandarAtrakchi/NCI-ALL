<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8" indent="yes"/>
<!-- the starting tage from moodle -->

  <xsl:template match="/">
  <!--The / is an XPath expression that references a node set from the source document -->
  <!-- starting html -->
    <html>
      <head>
        <title>Home</title>
        <!-- linking the main.js here -->
        <script src="main.js"></script>
        <!--linking the css styling sheet here -->
        <link rel="stylesheet" href="style.css"></link>
      </head>
      <body>
        <!-- marquee here -->
        <marquee>Discover Innovation Unfolding – Where Quality Meets Technology!</marquee>
        <!-- I will use <br><hr></hr></br> to create a simple space -->
        <br><hr></hr></br>
        <!-- nav bar here -->
        <div class="topnav">
          <a class="active" href="#home">Home</a>
          <a href="#something">Something</a>
          <a href="#contact">Contact</a>
          <a href="#about" class="split">Help</a>
        </div>
        <h1>Product List</h1>

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
      <td><xsl:value-of select="unit_price"/></td>
      <td><xsl:value-of select="discount"/></td>
    </tr>
  </xsl:template>
</xsl:stylesheet>
