-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2024 at 06:10 PM
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

CREATE TABLE `cenovnik` (
                            `ID_Cenovnika` int(11) NOT NULL,
                            `ID_Sobe` int(11) DEFAULT NULL,
                            `Cena_Po_Noci` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cenovnik`
--

INSERT INTO `cenovnik` (`ID_Cenovnika`, `ID_Sobe`, `Cena_Po_Noci`) VALUES
                                                                       (1, 1, '100.00'),
                                                                       (2, 2, '120.00'),
                                                                       (3, 3, '150.00'),
                                                                       (4, 4, '90.00'),
                                                                       (5, 5, '110.00');

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE `gost` (
                        `ID_Gosta` int(11) NOT NULL,
                        `Ime` varchar(50) DEFAULT NULL,
                        `Prezime` varchar(50) DEFAULT NULL,
                        `Datum_Dolaska` date DEFAULT NULL,
                        `Datum_Odlaska` date DEFAULT NULL,
                        `Tip_Gosta` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gost`
--

INSERT INTO `gost` (`ID_Gosta`, `Ime`, `Prezime`, `Datum_Dolaska`, `Datum_Odlaska`, `Tip_Gosta`) VALUES
                                                                                                     (1, 'Marko', 'Marković', '2024-04-15', '2024-04-20', 'Regular'),
                                                                                                     (2, 'Ana', 'Anić', '2024-04-16', '2024-04-22', 'VIP'),
                                                                                                     (3, 'Jovan', 'Jovanović', '2024-04-18', '2024-04-25', 'Regular'),
                                                                                                     (4, 'Milica', 'Milivojević', '2024-04-20', '2024-04-24', 'VIP'),
                                                                                                     (5, 'Nikola', 'Nikolić', '2024-04-22', '2024-04-26', 'Regular');

-- --------------------------------------------------------

--
-- Table structure for table `recepcioner`
--

CREATE TABLE `recepcioner` (
                               `ID_Recepcionera` int(11) NOT NULL,
                               `Ime` varchar(50) DEFAULT NULL,
                               `Prezime` varchar(50) DEFAULT NULL,
                               `Korisnicko_Ime` varchar(50) DEFAULT NULL,
                               `Lozinka` varchar(50) DEFAULT NULL,
                               `Role` varchar(10) NOT NULL DEFAULT 'User'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recepcioner`
--

INSERT INTO `recepcioner` (`ID_Recepcionera`, `Ime`, `Prezime`, `Korisnicko_Ime`, `Lozinka`, `Role`) VALUES
                                                                                                         (1, 'Stefan', 'Stefanović', 'stefan123', '123456', 'ADMIN'),
                                                                                                         (2, 'Jelena', 'Jelenić', 'jelena456', 'pass123', 'USER'),
                                                                                                         (3, 'Marko', 'Marković', 'marko789', 'pwd456', 'USER'),
                                                                                                         (4, 'Ana', 'Anić', 'anaanica', 'secret', 'USER'),
                                                                                                         (5, 'Nikola', 'Nikolić', 'nikolanik', 'secure', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
                               `ID_Rezervacije` int(11) NOT NULL,
                               `ID_Gosta` int(11) DEFAULT NULL,
                               `ID_Sobe` int(11) DEFAULT NULL,
                               `ID_Recepcioner` int(11) NOT NULL,
                               `Datum_Rezervacije` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`ID_Rezervacije`, `ID_Gosta`, `ID_Sobe`, `ID_Recepcioner`, `Datum_Rezervacije`) VALUES
                                                                                                               (1, 1, 2, 2, '2024-04-12'),
                                                                                                               (2, 2, 3, 1, '2024-04-13'),
                                                                                                               (3, 3, 4, 3, '2024-04-14'),
                                                                                                               (4, 4, 1, 4, '2024-04-15'),
                                                                                                               (5, 5, 5, 5, '2024-04-16');

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE `soba` (
                        `ID_Sobe` int(11) NOT NULL,
                        `Broj_Kreveta` int(11) DEFAULT NULL,
                        `Tip_Kreveta` varchar(50) DEFAULT NULL,
                        `Klima` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID_Sobe`, `Broj_Kreveta`, `Tip_Kreveta`, `Klima`) VALUES
                                                                           (1, 1, 'Single', 1),
                                                                           (2, 2, 'Double', 0),
                                                                           (3, 2, 'Double', 1),
                                                                           (4, 3, 'Triple', 1),
                                                                           (5, 1, 'Single', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE `transport` (
                             `ID_Transporta` int(11) NOT NULL,
                             `ID_Gosta` int(11) DEFAULT NULL,
                             `Vrsta_Transporta` varchar(50) DEFAULT NULL,
                             `Vreme_Narucivanja` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transport`
--

INSERT INTO `transport` (`ID_Transporta`, `ID_Gosta`, `Vrsta_Transporta`, `Vreme_Narucivanja`) VALUES
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
    ADD KEY `ID_Sobe` (`ID_Sobe`) USING BTREE;

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
    ADD KEY `rezervacija_ibfk_4` (`ID_Gosta`),
    ADD KEY `rezervacija_ibfk_1` (`ID_Sobe`),
    ADD KEY `rezervacija_ibfk_2` (`ID_Recepcioner`);

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
    ADD KEY `fk1` (`ID_Gosta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cenovnik`
--
ALTER TABLE `cenovnik`
    MODIFY `ID_Cenovnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `gost`
--
ALTER TABLE `gost`
    MODIFY `ID_Gosta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `recepcioner`
--
ALTER TABLE `recepcioner`
    MODIFY `ID_Recepcionera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
    MODIFY `ID_Rezervacije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `soba`
--
ALTER TABLE `soba`
    MODIFY `ID_Sobe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cenovnik`
--
ALTER TABLE `cenovnik`
    ADD CONSTRAINT `fk5` FOREIGN KEY (`ID_Sobe`) REFERENCES `soba` (`ID_Sobe`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
    ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`ID_Sobe`) REFERENCES `soba` (`ID_Sobe`),
    ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`ID_Recepcioner`) REFERENCES `recepcioner` (`ID_Recepcionera`),
    ADD CONSTRAINT `rezervacija_ibfk_4` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`);

--
-- Constraints for table `transport`
--
ALTER TABLE `transport`
    ADD CONSTRAINT `fk1` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
