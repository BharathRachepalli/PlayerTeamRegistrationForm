<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<title>Home</title>
</head>
<body>

	<form action="Home">
	<input type="hidden" name="command" value="AddPlayer"/><br><br>
		<div class="mb-3">
			<label for="formGroupExampleInput" class="form-label">ID :</label> <input
				type="text" class="form-control" id="formGroupExampleInput" name="id"
				placeholder="Enter ID">
		</div>
		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Name :</label>
			<input type="text" class="form-control" id="formGroupExampleInput2" name="name"
				placeholder="Enter Name">
		</div>

		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Age :</label>
			<input type="number" class="form-control" id="formGroupExampleInput2" name="age"
				placeholder="Enter Age">
		</div>
		
		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Team :</label>
			<input type="text" class="form-control" id="formGroupExampleInput2" name="team"
				placeholder="Enter Team">
		</div>

		<select class="form-select" aria-label="Default select example" name="gender"> 
			<option selected>Select Gender</option>
			<option value="male">male</option>
			<option value="female">female</option>
			<option value="others">others</option>
		</select>

		<button type="submit" class="btn btn-primary">Submit</button>

	</form>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
</body>
</html>