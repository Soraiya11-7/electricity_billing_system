-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2021 at 02:46 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customers`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers_feedback`
--

CREATE TABLE `customers_feedback` (
  `Service_No` int(10) DEFAULT NULL,
  `Feedback` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers_feedback`
--

INSERT INTO `customers_feedback` (`Service_No`, `Feedback`) VALUES
(111, 'Please check my correct units');

-- --------------------------------------------------------

--
-- Table structure for table `customer_details`
--

CREATE TABLE `customer_details` (
  `Customer_Id` int(10) NOT NULL,
  `Service_No` int(10) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Contact_No` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Bill_Amount` double(10,2) DEFAULT NULL,
  `Month` varchar(50) DEFAULT NULL,
  `Status_Paid_Not_Paid` varchar(30) DEFAULT NULL,
  `Customer_Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_details`
--

INSERT INTO `customer_details` (`Customer_Id`, `Service_No`, `Name`, `Contact_No`, `Address`, `Email`, `Bill_Amount`, `Month`, `Status_Paid_Not_Paid`, `Customer_Password`) VALUES
(1, 111, ' Md. Suhan Rahman', '01734562789', 'Talaimari,Rajshahi', 'suhan23@gmail.com', 870.00, 'November', 'Paid', '123'),
(2, 123, 'Ashraf Ali', '01826543907', 'kajla,rajshahi', 'as@gmail.com', 950.00, 'October', 'Paid', '12#'),
(4, 452, 'Naim Ishlam', '01875634592', 'Rajshahi', 'naim13@gnail.com', 702.00, NULL, NULL, '564'),
(5, 132, 'Sadman Sakib', '01974673429', 'Raninogar,Rajshahi', 'sadman@gmail.com', 810.00, NULL, NULL, '987'),
(7, 323, 'Mt. Ruma', '01836280915', 'Rajshahi', 'ruma@gmail.com', 980.00, NULL, NULL, '678'),
(9, 549, 'Md. Polash', '01874598260', 'Rajshahi', 'polash@gmail.com', NULL, NULL, NULL, '678'),
(13, 298, 'Md.mahin', '01823675430', 'Rajshahi', 'mahin@gmail.com', 1596.00, NULL, NULL, '386');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_details`
--
ALTER TABLE `customer_details`
  ADD PRIMARY KEY (`Customer_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
