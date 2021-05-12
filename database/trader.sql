-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2019 at 06:32 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trader`
--

-- --------------------------------------------------------

--
-- Table structure for table `item_detail`
--

CREATE TABLE `item_detail` (
  `item_detail_id` int(20) NOT NULL,
  `item_detail_name` varchar(500) NOT NULL,
  `item_detail_description` varchar(5000) NOT NULL,
  `item_detail_change_by` varchar(100) NOT NULL,
  `item_detail_date` varchar(20) NOT NULL,
  `item_detail_time` varchar(20) NOT NULL,
  `item_detail_img` varchar(1000) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item_detail`
--

INSERT INTO `item_detail` (`item_detail_id`, `item_detail_name`, `item_detail_description`, `item_detail_change_by`, `item_detail_date`, `item_detail_time`, `item_detail_img`, `username`) VALUES
(1, 'iphone11', 'iphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะiphone11 นะจ๊ะ', 'รถยนต์', '10/11/2019', '06:29', 'https://www.att.com/catalog/en/idse/Apple/Apple%20iPhone%2011%20Pro/Midnight%20Green-hero-zoom.png', 'bonus1234'),
(2, 'กีต้าร์', ' แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ แต้วๆๆแต้วๆๆ', 'เงิน 500 บาท', '11/11/2019', '11:20', 'https://www.musicarms.net/wp-content/uploads/2019/03/IMG_0553-1024x683.jpg', 'bank1234'),
(3, 'กระเป๋า freitag', 'สวยมาก สวยมากสวยมากสวยมากสวยมากสวยมากสวยมากสวยมากสวยมากสวยมากสวยมาก', 'อะไรก็ได้', '11/11/2019', '12:00', 'https://i.ytimg.com/vi/t1my-uveAF0/maxresdefault.jpg', 'niab1234'),
(29, 'จักรยานสุดเท่', 'สนใจติดต่อมาครับ', 'บิ๊กไบค์', '12/11/2019', '12:30', 'https://i0.wp.com/www.central.co.th/e-shopping/wp-content/uploads/2017/04/%E0%B9%80%E0%B8%A5%E0%B8%B7%E0%B8%AD%E0%B8%81%E0%B8%88%E0%B8%B1%E0%B8%81%E0%B8%A3%E0%B8%A2%E0%B8%B2%E0%B8%99%E0%B9%83%E0%B8%AB%E0%B9%89%E0%B9%80%E0%B8%AB%E0%B8%A1%E0%B8%B2%E0%B8%B0%E0%B8%81%E0%B8%B1%E0%B8%9A%E0%B8%99%E0%B8%B1%E0%B8%81%E0%B8%9B%E0%B8%B1%E0%B9%88%E0%B8%99.jpg?resize=750%2C500&ssl=1', 'niab1234');

-- --------------------------------------------------------

--
-- Table structure for table `item_type`
--

CREATE TABLE `item_type` (
  `item_type_id` int(20) NOT NULL,
  `item_type_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item_type`
--

INSERT INTO `item_type` (`item_type_id`, `item_type_name`) VALUES
(1, 'สมาร์ทโฟน'),
(2, 'เครื่องดนตรี'),
(3, 'กระเป๋า');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `line_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `username`, `password`, `line_id`) VALUES
(1, 'Bonus Thitipong', 'bonus1234', 'bonus1234', 'thitipong.s'),
(2, 'Bank Chanthachot', 'bank1234', 'bank1234', 'bankchanthachot'),
(3, 'Niab Phongrawee', 'niab1234', 'niab1234', 'niab.zaza'),
(9, 'Aom Kes', 'aomkes', 'aomkes', 'aomkes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_detail`
--
ALTER TABLE `item_detail`
  ADD PRIMARY KEY (`item_detail_id`);

--
-- Indexes for table `item_type`
--
ALTER TABLE `item_type`
  ADD PRIMARY KEY (`item_type_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item_detail`
--
ALTER TABLE `item_detail`
  MODIFY `item_detail_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `item_type`
--
ALTER TABLE `item_type`
  MODIFY `item_type_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
