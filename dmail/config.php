<?php
	define("DBsever","localhost");
	define("DBusername","root");
	define("DBpassword","");
	define("DBname", "dmail");

	$con=mysqli_connect(DBsever,DBusername,DBpassword,DBname);
	if(!$con){
		die('Connect false' .sqli_connect_errno());
	}

?>