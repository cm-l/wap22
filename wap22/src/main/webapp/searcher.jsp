<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Login Page</title>
</head>
<body>
<div class="wrap">
<!-- refer to this stylesheet for a cool magnifying glass icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<form action="SearchResultsServlet" method="GET">
   <div class="search">
      <input type="text" name="searchTerm" class="searchTerm" placeholder="What photo would you like to find?">
      <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>
    
     
   </div>
   Please, specify search criteria:
   </br>
          <input type="radio" id="title" name="criteria" value="title" checked>
  <label for="title">Title</label><br>
  <input type="radio" id="author" name="criteria" value="pk_user">
  <label for="author">Author</label><br>
  <input type="radio" id="description" name="criteria" value="description">
  <label for="description">Description</label> </br> <br>
 <label for="sorting">Sort by:</label>
  <select name="sorting" id="sorting">
    <option value="title">Title</option>
    <option value="pk_user">Author</option>
    <option value="dateofupload">Date of Upload</option> </br>
    <input type="radio" id="descending" name="ascdesc" value="DESC" checked>
  <label for="title">Descending ↓</label>
  <input type="radio" id="ascending" name="ascdesc" value="ASC">
  <label for="title">Ascending ↑</label>
  </select>
</div>
</form>
</body>
<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #00B4CC;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #00B4CC;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

.wrap{
  width: 30%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>