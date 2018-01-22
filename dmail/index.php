<?php
	
	include('config.php');

	if(isset($_POST["ham"])){
		$goi=$_POST["ham"];
	}
	switch ($goi) {
		case 'getLoaiSanPham':
			getLoaiSanPham();
			break;
		case 'DangKy':
			DangKy();
			break;
		case 'DangNhap':
			DangNhap();
			break;
		
	}



	function DangNhap(){
		global $con;
		if(isset($_POST["email"])||isset($_POST["password"])){
			$tendangnhap=$_POST["email"];
			$matkhau=$_POST["password"];
		}
	
		$query="SELECT * FROM user WHERE email ='".$tendangnhap."' AND password ='".$matkhau."'";
		mysqli_set_charset($con,"utf8");
		$result=mysqli_query($con,$query);

		
		if(!$result){
			die('invalid query');
		}else{
	
		while ($dong=mysqli_fetch_array($result)) {
			$data = array('id' => $dong["id"],'name'=>$dong["name"],'email'=>$dong["email"],'password'=>$dong["password"],'image'=>$dong["image"]);
		}
		$json=json_encode($data,JSON_UNESCAPED_UNICODE);
		echo $json;

	}
}

	function DangKy(){
		global $con;
	
		if(isset($_POST["hoten"])||isset($_POST["email"])||isset($_POST["matkhau"])||isset($_POST["getemail"])){
			$hoten=$_POST["hoten"];
			$email=$_POST["email"];
			$matkhau=$_POST["matkhau"];
			$getemail=$_POST["getemail"];
		}
		
		$query="insert into nhanvien (TenNV,TENDANGNHAP,MATKHAU,GETEMAIL,MALOAINV) values ('".$hoten."','".$email."','".$matkhau."',".$getemail.",1)";
		mysqli_set_charset($con,"utf8");
		$result=mysqli_query($con,$query);
		if($result){
			echo "true";
		}else{
			echo "false";
		}
	}
?>