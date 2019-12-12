-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2019 at 09:17 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lightningpizza`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(7) NOT NULL,
  `city_id` int(7) NOT NULL,
  `address` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `city_id`, `address`) VALUES
(122, 1, 'yamamah center'),
(123, 2, 'prince street'),
(124, 3, 'majid street'),
(126, 1, 'fanteer mall '),
(128, 2, 'dareen mall');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(7) NOT NULL,
  `city_name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `city_name`) VALUES
(1, 'Jubail'),
(2, 'Dammam'),
(3, 'riyadh');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(7) NOT NULL,
  `name` varchar(40) NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `name`, `phone`, `address`, `email`) VALUES
(1, 'Rawyah', 5398765, 'fiha street', 'wawa@gmail.com'),
(2, 'Lama k', 5376219, 'dammam street 5', 'lamaK@outlook.com'),
(3, 'Aseel M', 5392753, 'mijd street 5', 'aseelm@gmail.com'),
(4, 'Waad  N', 53679364, 'fiha 12', 'w1@gmail.com'),
(5, 'Reem M', 58583489, 'damamm st12', 'reem-_-@gmail.com'),
(6, 'Abdulaziz M', 53872190, 'Alolya', 'azooz@gmail.com'),
(7, 'Mona A', 53868573, 'fiyah 12', 'Mona@Gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `menu_items`
--

CREATE TABLE `menu_items` (
  `menu_items_id` int(7) NOT NULL,
  `name_item` varchar(25) NOT NULL,
  `category` varchar(25) NOT NULL,
  `description` varchar(25) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu_items`
--

INSERT INTO `menu_items` (`menu_items_id`, `name_item`, `category`, `description`, `price`) VALUES
(11, 'Pepperoni', 'pizza', 'pepperoni pizza ', 20),
(12, 'Cheese', 'pizza', 'cheese pizza', 20),
(13, 'Vegetable ', 'pizza', 'vegetable pizza', 20),
(14, 'Chicken Wings ', 'sides', 'Chicken Wings with sauce ', 15),
(15, 'Fries', 'sides', 'salted fries', 10),
(16, 'Soda', 'drinks', 'soft drinks', 3.5),
(17, 'Water', 'drinks', 'bottled water', 2.75);

-- --------------------------------------------------------

--
-- Table structure for table `order_in`
--

CREATE TABLE `order_in` (
  `order_in_id` int(7) NOT NULL,
  `order_Placed_id` int(7) NOT NULL,
  `menu_items_id` int(7) NOT NULL,
  `quantity` int(7) NOT NULL,
  `sub_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_in`
--

INSERT INTO `order_in` (`order_in_id`, `order_Placed_id`, `menu_items_id`, `quantity`, `sub_price`) VALUES
(1, 1, 11, 2, 40),
(2, 1, 14, 2, 30),
(3, 1, 15, 1, 10),
(4, 1, 16, 2, 7),
(5, 2, 11, 1, 20),
(6, 2, 12, 1, 20),
(7, 2, 16, 3, 10.5),
(8, 3, 11, 1, 20),
(9, 3, 15, 1, 10),
(10, 3, 17, 1, 2.75),
(11, 4, 11, 1, 20),
(12, 4, 15, 2, 20),
(13, 4, 16, 1, 3.5),
(14, 5, 11, 2, 40),
(15, 5, 15, 1, 10),
(16, 5, 16, 1, 3.5),
(17, 6, 12, 1, 20),
(18, 6, 14, 1, 15),
(19, 6, 15, 1, 10),
(20, 6, 16, 2, 7),
(21, 7, 12, 1, 20),
(22, 7, 17, 1, 2.75);

-- --------------------------------------------------------

--
-- Table structure for table `order_placed`
--

CREATE TABLE `order_placed` (
  `order_placed_id` int(7) NOT NULL,
  `branch_id` int(7) NOT NULL,
  `ordertime` datetime NOT NULL,
  `food_ready` datetime DEFAULT NULL,
  `customer_id` int(7) NOT NULL,
  `delivery_address` varchar(25) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_placed`
--

INSERT INTO `order_placed` (`order_placed_id`, `branch_id`, `ordertime`, `food_ready`, `customer_id`, `delivery_address`, `price`) VALUES
(1, 126, '2019-12-01 03:03:25', '2019-12-10 23:36:20', 1, 'fiha street', 89.61),
(2, 122, '2019-12-01 04:10:16', '2019-12-01 04:50:20', 2, 'dammam street 5', 52.015),
(3, 123, '2019-12-01 12:07:50', '2019-12-01 12:38:20', 3, 'mijd street 5', 33.7325),
(4, 126, '2019-12-04 11:59:12', NULL, 4, 'fiha 12', 44.8),
(5, 123, '2019-12-06 01:56:16', NULL, 5, 'damamm st12', 55.11),
(6, 124, '2019-12-11 00:39:04', NULL, 6, 'Alolya', 53.56),
(7, 126, '2019-12-11 10:41:28', NULL, 7, 'fiyah 12', 23.43);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `menu_items`
--
ALTER TABLE `menu_items`
  ADD PRIMARY KEY (`menu_items_id`);

--
-- Indexes for table `order_in`
--
ALTER TABLE `order_in`
  ADD PRIMARY KEY (`order_in_id`),
  ADD KEY `menu_item_id` (`menu_items_id`),
  ADD KEY `order_Placed_id` (`order_Placed_id`);

--
-- Indexes for table `order_placed`
--
ALTER TABLE `order_placed`
  ADD PRIMARY KEY (`order_placed_id`),
  ADD KEY `order_placed_ibfk_1` (`branch_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `order_in`
--
ALTER TABLE `order_in`
  MODIFY `order_in_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `order_placed`
--
ALTER TABLE `order_placed`
  MODIFY `order_placed_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `branch_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`);

--
-- Constraints for table `order_in`
--
ALTER TABLE `order_in`
  ADD CONSTRAINT `order_in_ibfk_2` FOREIGN KEY (`menu_items_id`) REFERENCES `menu_items` (`menu_items_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_in_ibfk_3` FOREIGN KEY (`order_Placed_id`) REFERENCES `order_placed` (`order_placed_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_placed`
--
ALTER TABLE `order_placed`
  ADD CONSTRAINT `order_placed_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_placed_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
