-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2020 at 04:44 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_buku`
--

CREATE TABLE `db_buku` (
  `id_buku` varchar(10) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `tahun` year(4) NOT NULL,
  `stok` int(10) NOT NULL,
  `dipinjam` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_buku`
--

INSERT INTO `db_buku` (`id_buku`, `judul`, `jenis`, `pengarang`, `penerbit`, `tahun`, `stok`, `dipinjam`) VALUES
('B14', 'Sragentine new', 'Astronomi', 'Elan', 'Elan Production', 2020, 5, 4),
('B15', 'Jihan', 'Biografi', 'Amami', 'Amami Store', 2016, 27, 9),
('B16', 'Al Muyassar', 'Ilmiah', 'At Tamimi', 'Pustaka Ukhuwah', 2008, 54, 4),
('B17', 'Tsalasatul ushul', 'Agama', 'Syeikh Muhammad bin Abdul Wahhab', 'Puskata Ibnu Umar', 2018, 70, 42),
('B18', 'Sholat Nabi', 'Panduan', 'Syeikh Muhammad', 'Pustaka Ibnu Umar', 2019, 40, 6),
('B19', 'Andika', 'Novel', 'Andika Candra', 'Andika Production', 2019, 10, 3),
('B20', 'yaya', 'Novel', 'yaya', 'yaya', 2020, 10, 3),
('B21', 'Mister Z', 'Panduan', 'XXX', 'XZY', 2009, 80, 8);

-- --------------------------------------------------------

--
-- Table structure for table `db_peminjaman`
--

CREATE TABLE `db_peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_buku` varchar(10) NOT NULL,
  `tgl_awal` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `tgl_akhir` date NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_peminjaman`
--

INSERT INTO `db_peminjaman` (`id_peminjaman`, `id_user`, `id_buku`, `tgl_awal`, `tgl_akhir`, `status`) VALUES
(14, 5, 'B14', '2020-06-09 00:33:44', '2020-06-16', 1),
(15, 5, 'B15', '2020-06-09 01:38:11', '2020-06-16', 1),
(16, 3, 'B17', '2020-06-09 02:10:26', '2020-06-16', 1),
(17, 3, 'B18', '2020-06-09 02:12:10', '2020-06-16', 1),
(18, 4, 'B14', '2020-06-09 01:52:00', '2020-06-16', 1),
(19, 7, 'B17', '2020-06-09 02:01:44', '2020-06-16', 1),
(20, 3, 'B15', '2020-06-09 01:53:39', '2020-06-16', 1),
(21, 3, 'B19', '2020-06-09 02:28:26', '2020-06-16', 0),
(22, 3, 'B16', '2020-06-09 02:28:35', '2020-06-16', 0),
(23, 4, 'B15', '2020-06-09 02:28:55', '2020-06-16', 0),
(24, 4, 'B19', '2020-06-09 02:29:07', '2020-06-16', 0),
(25, 4, 'B21', '2020-06-09 02:31:08', '2020-06-16', 1),
(26, 5, 'B18', '2020-06-09 02:37:09', '2020-06-16', 1),
(27, 3, 'B18', '2020-06-09 02:40:17', '2020-06-16', 0);

-- --------------------------------------------------------

--
-- Table structure for table `db_users`
--

CREATE TABLE `db_users` (
  `id_user` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `ttl` date NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `rules` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `db_users`
--

INSERT INTO `db_users` (`id_user`, `name`, `password`, `alamat`, `ttl`, `tempat_lahir`, `rules`) VALUES
(1, 'Ahnaffaiz', 'Ahnaffaiz', 'Surakarta', '2000-03-10', 'Sragen', 'user'),
(2, 'Admin', 'Admin', 'Admin', '2000-03-03', 'Sragen', 'admin'),
(3, 'Faiz', 'Faiz', 'Sragen', '2000-09-09', 'Sragen', 'user'),
(4, 'Jihan', 'Jihan', 'Jihan', '2000-05-26', 'Purworejo', 'user'),
(5, 'Andika', 'Andika', 'Sukoharjo', '2000-06-06', 'Sukoharjo', 'user'),
(6, 'Ahnaf', 'Ahnaf', 'Sragen', '2000-08-08', 'Srageb', 'user'),
(7, 'Putra', 'Putra', 'Sragen', '2000-09-09', 'Sragen', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_buku`
--
ALTER TABLE `db_buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `db_peminjaman`
--
ALTER TABLE `db_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indexes for table `db_users`
--
ALTER TABLE `db_users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_peminjaman`
--
ALTER TABLE `db_peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `db_users`
--
ALTER TABLE `db_users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `db_peminjaman`
--
ALTER TABLE `db_peminjaman`
  ADD CONSTRAINT `db_peminjaman_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `db_users` (`id_user`) ON UPDATE CASCADE,
  ADD CONSTRAINT `db_peminjaman_ibfk_4` FOREIGN KEY (`id_buku`) REFERENCES `db_buku` (`id_buku`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
