CREATE DATABASE `animalshelter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
SELECT * FROM animalshelter.customer;
CREATE TABLE `customer` (
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `customerEmailID_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dog` (
  `dogID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `weight` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `breed` varchar(45) NOT NULL,
  `fee` varchar(45) NOT NULL,
  PRIMARY KEY (`dogID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `health` (
  `healthID` int NOT NULL AUTO_INCREMENT,
  `dogID` int NOT NULL,
  `diseaseType` varchar(45) NOT NULL,
  `dateContracted` varchar(45) NOT NULL,
  `needMedication` varchar(45) NOT NULL,
  PRIMARY KEY (`healthID`),
  KEY `health_dogID_idx` (`dogID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medicalhistory` (
  `medicalHistoryID` int NOT NULL AUTO_INCREMENT,
  `dogID` int NOT NULL,
  `microchip` varchar(45) NOT NULL,
  `dateReceived` varchar(45) NOT NULL,
  `vaccinated` varchar(45) NOT NULL,
  PRIMARY KEY (`medicalHistoryID`),
  KEY `medicalHistory_dogID_idx` (`dogID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `appointment` (
  `appointmentID` int NOT NULL AUTO_INCREMENT,
  `dogID` int NOT NULL,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `reason` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`appointmentID`),
  KEY `appointment_dogID_idx` (`dogID`),
  KEY `customerEmailID_idx` (`email`),
  CONSTRAINT `dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`),
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `customer` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


