<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChatRoom</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="socketio/socket.io.js"></script>
<script src="/index.js"></script>
</head>
<body>

 <h1>Welcome to chatroom</h1>		
 <h1 id="eventvalue"></h1>
 
 <button id="login" class="bg-primary" onclick=createLogin()>login</button>
 <button id="logout" class="bg-danger d-none" onclick = doLogout()>logout</button>

</body>
</html>