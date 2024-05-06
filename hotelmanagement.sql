-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 11:08 PM
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

CREATE TABLE IF NOT EXISTS `cenovnik` (
                                          `ID_Cenovnika` int(11) NOT NULL AUTO_INCREMENT,
                                          `Cena_Po_Noci` decimal(10,2) DEFAULT NULL,
                                          PRIMARY KEY (`ID_Cenovnika`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cenovnik`
--

INSERT INTO `cenovnik` (`ID_Cenovnika`, `Cena_Po_Noci`) VALUES
                                                            (1, '100.00'),
                                                            (2, '120.00'),
                                                            (3, '150.00'),
                                                            (4, '90.00'),
                                                            (5, '110.00'),
                                                            (7, '200.00');

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE IF NOT EXISTS `gost` (
                                      `ID_Gosta` int(11) NOT NULL AUTO_INCREMENT,
                                      `Ime` varchar(50) DEFAULT NULL,
                                      `Prezime` varchar(50) DEFAULT NULL,
                                      `Datum_Dolaska` date DEFAULT NULL,
                                      `Datum_Odlaska` date DEFAULT NULL,
                                      `Tip_Gosta` varchar(10) DEFAULT NULL,
                                      PRIMARY KEY (`ID_Gosta`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

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

CREATE TABLE IF NOT EXISTS `recepcioner` (
                                             `ID_Recepcionera` int(11) NOT NULL AUTO_INCREMENT,
                                             `Ime` varchar(50) DEFAULT NULL,
                                             `Prezime` varchar(50) DEFAULT NULL,
                                             `Korisnicko_Ime` varchar(50) DEFAULT NULL,
                                             `Lozinka` varchar(255) DEFAULT NULL,
                                             `Profilna_Slika` varchar(255) DEFAULT NULL,
                                             `Role` varchar(50) NOT NULL DEFAULT 'USER',
                                             PRIMARY KEY (`ID_Recepcionera`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recepcioner`
--

INSERT INTO `recepcioner` (`ID_Recepcionera`, `Ime`, `Prezime`, `Korisnicko_Ime`, `Lozinka`, `Profilna_Slika`, `Role`) VALUES
                                                                                                                           (1, 'Stefan', 'Stefanović', 'stefan123', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'ADMIN'),
                                                                                                                           (2, 'Jelena', 'Jelenić', 'jelena456', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER'),
                                                                                                                           (3, 'Marko', 'Marković', 'marko789', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER'),
                                                                                                                           (4, 'Ana', 'Anić', 'anaanica', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER'),
                                                                                                                           (5, 'Nikola', 'Nikolić', 'nikolanik', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER'),
                                                                                                                           (6, 'Uros', 'Mirkovic', 'uros', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'ADMIN'),
                                                                                                                           (9, 'Uros', 'Mirkovic', 'UrosAdmin', '$2a$10$Mrawk7jWNJaDqDOEd4//Rupte6wFfP4F2Gl3XXXCdUYig7Aiet8S2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'ADMIN'),
                                                                                                                           (10, 'Uros', 'Mirkovic', 'UrosUser', '$2a$10$JpLiwI40prZITGxFRDM8rec7sMpYbfDXUvcNN6M2SmkwF9OgJO0..', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER'),
                                                                                                                           (13, 'Test', 'Test', 'Test', '$2a$10$HKMfsUcEZDFVhdU0e.TpmObxAeBuXs1zlCWR2U0Q/XN8jYBq/5ccy', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE IF NOT EXISTS `rezervacija` (
                                             `ID_Rezervacije` int(11) NOT NULL AUTO_INCREMENT,
                                             `ID_Gosta` int(11) DEFAULT NULL,
                                             `ID_Sobe` int(11) DEFAULT NULL,
                                             `ID_Recepcioner` int(11) NOT NULL,
                                             `Datum_Rezervacije` date DEFAULT NULL,
                                             `Duzina_Boravka` int(11) NOT NULL,
                                             PRIMARY KEY (`ID_Rezervacije`),
                                             KEY `rezervacija_ibfk_4` (`ID_Gosta`),
                                             KEY `rezervacija_ibfk_1` (`ID_Sobe`),
                                             KEY `rezervacija_ibfk_2` (`ID_Recepcioner`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`ID_Rezervacije`, `ID_Gosta`, `ID_Sobe`, `ID_Recepcioner`, `Datum_Rezervacije`, `Duzina_Boravka`) VALUES
                                                                                                                                 (1, 1, 2, 2, '2024-04-12', 3),
                                                                                                                                 (2, 2, 3, 1, '2024-04-13', 3),
                                                                                                                                 (3, 3, 4, 3, '2024-04-14', 2),
                                                                                                                                 (4, 4, 1, 4, '2024-04-15', 5),
                                                                                                                                 (5, 5, 5, 5, '2024-04-16', 2);

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE IF NOT EXISTS `soba` (
                                      `ID_Sobe` int(11) NOT NULL AUTO_INCREMENT,
                                      `Broj_Kreveta` int(11) DEFAULT NULL,
                                      `Tip_Kreveta` varchar(50) DEFAULT NULL,
                                      `Klima` tinyint(1) DEFAULT NULL,
                                      `ID_Cenovnik` int(11) NOT NULL,
                                      PRIMARY KEY (`ID_Sobe`),
                                      KEY `fk_soba_cenovnik` (`ID_Cenovnik`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`ID_Sobe`, `Broj_Kreveta`, `Tip_Kreveta`, `Klima`, `ID_Cenovnik`) VALUES
                                                                                          (1, 1, 'Single', 1, 1),
                                                                                          (2, 2, 'Double', 0, 2),
                                                                                          (3, 2, 'Double', 1, 3),
                                                                                          (4, 3, 'Triple', 1, 4),
                                                                                          (5, 1, 'Single', 0, 5);

-- --------------------------------------------------------

--
-- Table structure for table `soba_slika`
--

CREATE TABLE IF NOT EXISTS `soba_slika` (
                                            `id` int(11) NOT NULL AUTO_INCREMENT,
                                            `Slika_Url` varchar(255) NOT NULL,
                                            `Id_Soba` int(11) NOT NULL,
                                            PRIMARY KEY (`id`),
                                            KEY `fk_soba_slika` (`Id_Soba`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba_slika`
--

INSERT INTO `soba_slika` (`id`, `Slika_Url`, `Id_Soba`) VALUES
                                                            (1, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 2),
                                                            (2, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 3),
                                                            (3, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 3),
                                                            (4, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 4),
                                                            (5, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 1),
                                                            (6, 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fdemo.goodlayers.com%2Fhotelmaster%2Fwp-content%2Fuploads%2F2015%2F03%2Fphotodune-3973289-hotel-room-m.jpg&f=1&nofb=1&ipt=6cc42ec04233973c4c802080b840ff9a2c5608562fe5fa3d0e0fdef26e9db287&ipo=images', 5);

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE IF NOT EXISTS `transport` (
                                           `ID_Transporta` int(11) NOT NULL AUTO_INCREMENT,
                                           `ID_Gosta` int(11) DEFAULT NULL,
                                           `Vrsta_Transporta` varchar(50) DEFAULT NULL,
                                           `Vreme_Narucivanja` datetime DEFAULT NULL,
                                           PRIMARY KEY (`ID_Transporta`),
                                           KEY `fk1` (`ID_Gosta`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

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
-- Constraints for dumped tables
--

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
    ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`ID_Sobe`) REFERENCES `soba` (`ID_Sobe`),
    ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`ID_Recepcioner`) REFERENCES `recepcioner` (`ID_Recepcionera`),
    ADD CONSTRAINT `rezervacija_ibfk_4` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`);

--
-- Constraints for table `soba`
--
ALTER TABLE `soba`
    ADD CONSTRAINT `fk_soba_cenovnik` FOREIGN KEY (`ID_Cenovnik`) REFERENCES `cenovnik` (`ID_Cenovnika`);

--
-- Constraints for table `soba_slika`
--
ALTER TABLE `soba_slika`
    ADD CONSTRAINT `fk_soba_slika` FOREIGN KEY (`Id_Soba`) REFERENCES `soba` (`ID_Sobe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transport`
--
ALTER TABLE `transport`
    ADD CONSTRAINT `fk1` FOREIGN KEY (`ID_Gosta`) REFERENCES `gost` (`ID_Gosta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
