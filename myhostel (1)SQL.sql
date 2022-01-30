-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2022 at 02:03 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myhostel`
--

-- --------------------------------------------------------

--
-- Table structure for table `hostel_admin`
--

CREATE TABLE `hostel_admin` (
  `id` int(255) NOT NULL,
  `username` varchar(1000) NOT NULL,
  `password` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostel_admin`
--

INSERT INTO `hostel_admin` (`id`, `username`, `password`) VALUES
(1, 'hostel@admin.com', 'e10adc3949ba59abbe56e057f20f883e');

-- --------------------------------------------------------

--
-- Table structure for table `hostel_menu`
--

CREATE TABLE `hostel_menu` (
  `id` int(255) NOT NULL,
  `day_name` varchar(1000) NOT NULL,
  `breakfast` varchar(1000) NOT NULL,
  `lunch` varchar(1000) NOT NULL,
  `dinner` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostel_menu`
--

INSERT INTO `hostel_menu` (`id`, `day_name`, `breakfast`, `lunch`, `dinner`) VALUES
(1, 'Friday', 'Bred Tea', 'Rice', 'Qorma'),
(2, 'Saturday', 'Free Air', 'Boiled Rice', 'Boiled Egg');

-- --------------------------------------------------------

--
-- Table structure for table `hostel_rooms`
--

CREATE TABLE `hostel_rooms` (
  `id` int(255) NOT NULL,
  `room_no` int(255) NOT NULL,
  `room_capacity` int(255) NOT NULL,
  `free_space` int(255) NOT NULL,
  `bed_rent` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostel_rooms`
--

INSERT INTO `hostel_rooms` (`id`, `room_no`, `room_capacity`, `free_space`, `bed_rent`) VALUES
(4, 324, 3, 3, '7000');

-- --------------------------------------------------------

--
-- Table structure for table `paid_fee`
--

CREATE TABLE `paid_fee` (
  `id` int(255) NOT NULL,
  `std_id` int(255) NOT NULL,
  `paid_month` int(255) NOT NULL,
  `paid_day` int(255) NOT NULL,
  `paid_year` int(255) NOT NULL,
  `paid_amount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paid_fee`
--

INSERT INTO `paid_fee` (`id`, `std_id`, `paid_month`, `paid_day`, `paid_year`, `paid_amount`) VALUES
(1, 1, 1, 22, 2022, 7000),
(2, 1, 1, 22, 2022, 7000);

-- --------------------------------------------------------

--
-- Table structure for table `paid_pay`
--

CREATE TABLE `paid_pay` (
  `id` int(255) NOT NULL,
  `staff_id` int(255) NOT NULL,
  `paid_month` int(255) NOT NULL,
  `paid_day` int(255) NOT NULL,
  `paid_year` int(255) NOT NULL,
  `paid_amount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paid_pay`
--

INSERT INTO `paid_pay` (`id`, `staff_id`, `paid_month`, `paid_day`, `paid_year`, `paid_amount`) VALUES
(1, 1, 1, 22, 2022, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(255) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `phone` varchar(1000) NOT NULL,
  `work_nature` varchar(1000) NOT NULL,
  `joining_date` varchar(1000) NOT NULL,
  `monthly_pay` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `name`, `phone`, `work_nature`, `joining_date`, `monthly_pay`) VALUES
(2, 'tanzeel', '03415908146', 'Chef', '2022/01/22 04:24:54', 18000);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `phone` varchar(1000) NOT NULL,
  `cnic` varchar(1000) NOT NULL,
  `emergency_no` varchar(1000) NOT NULL,
  `start_date` varchar(1000) NOT NULL,
  `end_date` varchar(1000) NOT NULL,
  `room_no` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `phone`, `cnic`, `emergency_no`, `start_date`, `end_date`, `room_no`) VALUES
(1, 'rehman', '03415908146', '111112222223', '03075897216', '2022/01/22 02:36:45', '0', 324),
(2, 'dfddfffdf', '334344342', 'd2343444342343', '323423424', '2022/01/22 18:00:23', '0', 324);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hostel_admin`
--
ALTER TABLE `hostel_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hostel_menu`
--
ALTER TABLE `hostel_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hostel_rooms`
--
ALTER TABLE `hostel_rooms`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `room_no` (`room_no`);

--
-- Indexes for table `paid_fee`
--
ALTER TABLE `paid_fee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paid_pay`
--
ALTER TABLE `paid_pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hostel_admin`
--
ALTER TABLE `hostel_admin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hostel_menu`
--
ALTER TABLE `hostel_menu`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hostel_rooms`
--
ALTER TABLE `hostel_rooms`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `paid_fee`
--
ALTER TABLE `paid_fee`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `paid_pay`
--
ALTER TABLE `paid_pay`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
