-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2020 at 02:50 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tabel_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `animasi`
--

CREATE TABLE `animasi` (
  `id` int(11) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `gambar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `animasi`
--

INSERT INTO `animasi` (`id`, `judul`, `deskripsi`, `gambar`) VALUES
(1, 'Tipe Laptop', 'Spesifikasi', '11785117751584534128.jpeg'),
(2, 'Tipe Laptopnsksk', 'Spesifikasi', '4358512331584535240.jpeg'),
(3, 'judul', 'deskripsi', '10899919551584540321.jpeg'),
(4, 'Kama', 'SNa', '1214246171584547589.jpeg'),
(5, 'Kama', 'SNa', '9520053721584547594.jpeg'),
(6, 'Sampah', 'Bersih', '6483455221584548204.jpeg'),
(7, 'Tipe Laptop', 'Spesifikasi', '16516419541584590570.jpeg'),
(8, 'Tipe Laptop', 'Spesifikasi', '20691372981584970476.jpeg'),
(9, 'Tipe Laptop', 'Spesifikasi', '14475192021584970698.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animasi`
--
ALTER TABLE `animasi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animasi`
--
ALTER TABLE `animasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
