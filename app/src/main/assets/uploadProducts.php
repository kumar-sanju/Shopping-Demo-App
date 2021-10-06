<?php

include('db_connect.php');

	if($_SERVER['REQUEST_METHOD']=='POST')
	{
        
        $allowedExts = array("jpg","jpeg","png","gif");
        $temp = explode(".", $_FILES["image"]["name"]);
        $extension = end($temp);
        $image=$_FILES["image"]["name"];
        move_uploaded_file($_FILES["image"]["tmp_name"],"images/" . $_FILES["image"]["name"]);
        $imageUrl="https://6c45-45-114-49-188.ngrok.io/mobileApp/images/";
        $resultURL=$imageUrl.$image;
        
        $rating=$_POST['rating'];
        $price=$_POST['price'];
        $title=mysqli_real_escape_string($conn, $_POST['title']);

        $sql=mysqli_query($conn,"INSERT INTO `products`(`image`,`rating`,`price`,`title`)
                    VALUES('".$resultURL."','$rating','$price','$title')");
        if($sql){
            echo mysqli_insert_id($conn);
            echo "Data Submit Successful";
        }
        else{
            echo "Data Submit Error!!";
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
      	
	}
?>
