<?php

  require 'koneksi.php';

  $nama =$_POST["nama"];
  $komentar =$_POST["komentar"];
  $gambar =$_POST["gambar"];
  
  if (isset($nama) && isset($komentar)) {
    // code...

    $target_dir = "img/";
    $randName = rand() . time() . ".jpeg";
    $target_dir = $target_dir . $randName;
    echo $target_dir;
    $response = array();
    $sql = "INSERT INTO feedback (nama, komentar, gambar)
    VALUES ('$nama','$komentar','$randName')";
    $hasil = mysqli_query($conn, $sql);
    if ($hasil) {
      // code...
      if (file_put_contents($target_dir , base64_decode($gambar))) {
        // code...
        $response['code'] =1;
        $response['msg'] ="Sukses";
        echo "Sukses Photo" . $response['msg'];
      } else {
        // code...
        $response['code'] =0;
        $response['msg'] =mysqli_error($conn);
      }
      echo "Sukses";

    } else {
      // code...
      $response['msg'] =mysqli_error($conn);
      echo $response['msg'];
    }
  }
  else {
    // code...
    $response['msg'] =mysqli_error($conn);
    echo $response['msg'];
  }

  // $title = "Test";
  // $spek = "Intel core i3 - 8 GB/128 GB SSD";
  // $rating = "3.3";
  // $price = "2200000";
  // $image = "rog.jpg";







  // if ($hasil) {
  //   // code...
  //   $row = mysqli_num_rows($hasil);
  //   echo "Result set has " . $row;
  // }
//   $response = array();
//


  // if ($hasil) {
  //   // code...
  //   $response['code'] =1;
  //   $response['msg'] ="Sukses";
  //
  // } else {
  //   // code...
  //   $response['code'] =0;
  //   $response['msg'] =mysqli_error($conn);
  // }



?>
