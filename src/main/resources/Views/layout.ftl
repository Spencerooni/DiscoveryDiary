<#macro layout>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->

    <title>Kainos Media Library</title>
      <!-- Bootstrap core CSS -->
        <link href="/assets/css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
         <link href="/assets/css/layout.css" rel="stylesheet">
         <link href="/assets/css/responsive.css" rel="stylesheet">
         <link href="/assets/fonts/fonts.css" rel="stylesheet">


  </head>
  <body>

	<header>
    	<div class="container">
        	<div class="row">
            	<div class="col-lg-4 col-sm-4 col-md-4 logo" >
                	<a href="/media"><img src="/assets/images/logo.png" alt="logo" height="75" style="padding:20px"></a>
                	<a href="/media/add"><img src="/assets/images/addIcon.png" alt="addbOOK" height="20" style="padding:20px"></a>
                </div>
            </div>
        </div>
    </header>
<section class="search-bar-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 col-md-12">
                <div class="search-area">
                    <form action="/media/search" method="get">
                        <input name="searchText" value="${userSearchText!}" type="text" placeholder="Search by Title, Author or Location">
                          <input type="submit" value="Search" class="search">
                     <select name="searchOption" value="${userDropDown!}" class="selectpicker">
                                                  <option value ="Title" <#if userDropDown! == "Title">selected</#if>>Title</option>
                                                  <option value ="Year" <#if userDropDown! == "Year">selected</#if>>Year</option>
                      </select>
                      </form>
                  </div>
              </div>
          </div>
      </div>
  </section>



    <div class="container">

      <#nested/>

    </div><!-- /.container -->
  </body>
</html>
</#macro>
