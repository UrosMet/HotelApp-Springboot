-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2024 at 08:54 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelmanagement`
--
CREATE DATABASE IF NOT EXISTS `hotelmanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hotelmanagement`;

-- --------------------------------------------------------

--
-- Table structure for table `cenovnik`
--

DROP TABLE IF EXISTS `cenovnik`;
CREATE TABLE `cenovnik` (
  `ID_Cenovnika` int(11) NOT NULL,
  `ID_Sobe` int(11) DEFAULT NULL,
  `CenaPoNoci` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cenovnik`
--

INSERT INTO `cenovnik` (`ID_Cenovnika`, `ID_Sobe`, `CenaPoNoci`) VALUES
(1, 1, '100.00'),
(2, 2, '120.00'),
(3, 3, '150.00'),
(4, 4, '90.00'),
(5, 5, '110.00');

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

DROP TABLE IF EXISTS `gost`;
CREATE TABLE `gost` (
  `ID_Gosta` int(11) NOT NULL,
  `Ime` varchar(50) DEFAULT NULL,
  `Prezime` varchar(50) DEFAULT NULL,
  `DatumDolaska` date DEFAULT NULL,
  `DatumOdlaska` date DEFAULT NULL,
  `TipGosta` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gost`
--

INSERT INTO `gost` (`ID_Gosta`, `Ime`, `Prezime`, `DatumDolaska`, `DatumOdlaska`, `TipGosta`) VALUES
(1, 'Marko', 'Marković', '2024-04-15', '2024-04-20', 'Regular'),
(2, 'Ana', 'Anić', '2024-04-16', '2024-04-22', 'VIP'),
(3, 'Jovan', 'Jovanović', '2024-04-18', '2024-04-25', 'Regular'),
(4, 'Milica', 'Milivojević', '2024-04-20', '2024-04-24', 'VIP'),
(5, 'Nikola', 'Nikolić', '2024-04-22', '2024-04-26', 'Regular');

-- --------------------------------------------------------

--
-- Table structure for table `recepcioner`
--

DROP TABLE IF EXISTS `recepcioner`;
CREATE TABLE `recepcioner` (
  `ID_Recepcionera` int(11) NOT NULL,
  `Ime` varchar(50) DEFAULT NULL,
  `Prezime` varchar(50) DEFAULT NULL,
  `KorisnickoIme` varchar(50) DEFAULT NULL,
  `Lozinka` varchar(50) DEFAULT NULL,
  `Admin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recepcioner`
--

INSERT INTO `recepcioner` (`ID_Recepcionera`, `Ime`, `Prezime`, `KorisnickoIme`, `Lozinka`, `Admin`) VALUES
(1, 'Stefan', 'Stefanović', 'stefan123', '123456', 0),
(2, 'Jelena', 'Jelenić', 'jelena456', 'pass123', 0),
(3, 'Marko', 'Marković', 'marko789', 'pwd456', 0),
(4, 'Ana', 'Anić', 'anaanica', 'secret', 0),
(5, 'Nikola', 'Nikolić', 'nikolanik', 'secure', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

DROP TABLE IF EXISTS `rezervacija`;
CREATE TABLE `rezervacija` (
  `ID_Rezervacije` int(11) NOT NULL,
  `ID_Gosta` int(11) DEFAULT NULL,
  `ID_Sobe` int(11) DEFAULT NULL,
  `ID_Recepcioner` int(11) NOT NULL,
  `DatumRezervacije` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`ID_Rezervacije`, `ID_Gosta`, `ID_Sobe`, `ID_Recepcioner`, `DatumRezervacije`) VALUES
(1, 1, 2, 2, '2024-04-12'),
(2, 2, 3, 1, '2024-04-13'),
(3, 3, 4, 3, '2024-04-14'),
(4, 4, 1, 4, '2024-04-15'),
(5, 5, 5, 5, '2024-04-16');

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

DROP TABLE IF EXISTS `soba`;
CREATE TABLE `soba` (
  `ID_Sobe` int(11) NOT NULL,
  `BrojKreveta` int(11) DEFAULT NULL,
  `TipKreveta` varchar(50) DEFAULT NULL,
  `Klima` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID_Sobe`, `BrojKreveta`, `TipKreveta`, `Klima`) VALUES
(1, 1, 'Single', 1),
(2, 2, 'Double', 0),
(3, 2, 'Double', 1),
(4, 3, 'Triple', 1),
(5, 1, 'Single', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
CREATE TABLE `transport` (
  `ID_Transporta` int(11) NOT NULL,
  `ID_Gosta` int(11) DEFAULT NULL,
  `VrstaTransporta` varchar(50) DEFAULT NULL,
  `VremeNarucivanja` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transport`
--

INSERT INTO `transport` (`ID_Transporta`, `ID_Gosta`, `VrstaTransporta`, `VremeNarucivanja`) VALUES
(1, 1, 'Taxi', '2024-04-15 10:00:00'),
(2, 2, 'Shuttle', '2024-04-16 11:30:00'),
(3, 3, 'Limuzina', '2024-04-17 09:15:00'),
(4, 4, 'Rent-a-car', '2024-04-18 08:45:00'),
(5, 5, 'Taxi', '2024-04-19 07:30:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cenovnik`
--
ALTER TABLE `cenovnik`
  ADD PRIMARY KEY (`ID_Cenovnika`),
  ADD KEY `ID_Sobe` (`ID_Sobe`);

--
-- Indexes for table `gost`
--
ALTER TABLE `gost`
  ADD PRIMARY KEY (`ID_Gosta`);

--
-- Indexes for table `recepcioner`
--
ALTER TABLE `recepcioner`
  ADD PRIMARY KEY (`ID_Recepcionera`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`ID_Rezervacije`),
  ADD KEY `ID_Gosta` (`ID_Gosta`),
  ADD KEY `ID_Sobe` (`ID_Sobe`),
  ADD KEY `rezervacija_ibfk_3` (`ID_Recepcioner`);

--
-- Indexes for table `soba`
--
ALTER TABLE `soba`
  ADD PRIMARY KEY (`ID_Sobe`);

--
-- Indexes for table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`ID_Transporta`),
  ADD KEY `ID_Gosta` (`ID_Gosta`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cenovnik`
--
ALTER TABLE `cenovnik`
  ADD CONSTRAINT `cenovnik_ibfk_1` FOREIGN KEY (`ID_Sobe`) REFERENCES `soba` (`ID_Sobe`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`ID_Sobe`) REFERENCES `soba` (`ID_Sobe`),
  ADD CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`ID_Recepcioner`) REFERENCES `recepcioner` (`ID_Recepcionera`);

--
-- Constraints for table `transport`
--
ALTER TABLE `transport`
  ADD CONSTRAINT `transport_ibfk_1` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
