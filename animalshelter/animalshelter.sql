CREATE DATABASE `animalshelter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `appointment` (
  `appointmentID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `dogID` int NOT NULL,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `reason` varchar(45) NOT NULL,
  PRIMARY KEY (`appointmentID`),
  UNIQUE KEY `appointmentID_UNIQUE` (`appointmentID`),
  KEY `appointment_customerEmail_idx` (`email`),
  KEY `appointment_dogID_idx` (`dogID`),
  CONSTRAINT `appointment_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`),
  CONSTRAINT `appointment_email` FOREIGN KEY (`email`) REFERENCES `customer` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`customerID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `customerID_UNIQUE` (`customerID`),
  KEY `customerEmail` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `health` (
  `healthID` int NOT NULL AUTO_INCREMENT,
  `dogID` int NOT NULL,
  `diseaseType` varchar(45) NOT NULL,
  `dateContracted` varchar(45) NOT NULL,
  `needMedication` varchar(45) NOT NULL,
  PRIMARY KEY (`healthID`),
  KEY `health_dogID_idx` (`dogID`),
  CONSTRAINT `health_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `medicalhistory` (
  `medicalHistoryID` int NOT NULL,
  `dogID` int NOT NULL AUTO_INCREMENT,
  `microchip` varchar(45) NOT NULL,
  `dateReceived` varchar(45) NOT NULL,
  `vaccinated` varchar(45) NOT NULL,
  PRIMARY KEY (`medicalHistoryID`),
  UNIQUE KEY `medicalHistoryID_UNIQUE` (`medicalHistoryID`),
  KEY `medicalhistory_dogID_idx` (`dogID`),
  CONSTRAINT `medicalhistory_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
