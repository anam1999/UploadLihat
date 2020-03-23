<?php

  require 'koneksi.php';

  $sql = "SELECT * FROM animasi";
  $result = mysqli_query($conn, $sql);
  $data = array();

  while ($row = mysqli_fetch_assoc($result)) {
    // code...
    $data[] = $row;
  }
  // $data = mysqli_fetch_row($result);
  $string = json_encode($data);
  echo $string;

  // var_dump($response);

?>
