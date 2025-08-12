package com.example.javase11;

public class Exercise02 {

	public static void main(String[] args) {
		var sql = """
				select count(*)
				from countries
				where continent="Asia"
				""";
		var json = """
				{
				  "firstName": "jack",
				  "lastName": "bauer",
				  "salary": 100000,
				  "iban": "tr1"
				}
				""";
		var xml = """
			<?xml var="1.0"?>
			<movies>
			  <movie imdb="tt123456">
			     <title></title>
			     <genres>
			        <genre>Drama</genre>
			     </genres>
			  </movie>
			</movies>	
				""";
	}

}
