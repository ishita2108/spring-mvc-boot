<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>First JSP</title></head>
<body>
	Welcome to our website
	
	<!--<form action="add">
		Enter 1st number : <input type="text" name="num1"><br/>
		Enter 2nd number : <input type="text" name="num2"><br/>
		<input type="submit">
	</form>-->
	<form action="addAlien" method="post">
			Enter your id : <input type="text" name="aid"><br/>
			Enter your name : <input type="text" name="aname"><br/>
			<input type="submit">
		</form>
		
		<hr>
		
		<form action="getAlien" method="get">
					Enter your id : <input type="text" name="aid"><br/>
					<input type="submit">
				</form>
				
				<hr>
				<form action="getAlienByName" method="get">
									Enter your name : <input type="text" name="aname"><br/>
									<input type="submit">
								</form>
		
</body>
</html>
	