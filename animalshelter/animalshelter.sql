CREATE DATABASE `animalshelter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `appointment` (
  `appointmentID` varchar(45) NOT NULL,
  `dogID` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `reason` varchar(45) NOT NULL,
  PRIMARY KEY (`appointmentID`),
  KEY `appointment_dogID_idx` (`dogID`),
  CONSTRAINT `appointment_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `customer` (
  `customerEmailID` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`customerEmailID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `dog` (
  `dogID` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `weight` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `breed` varchar(45) NOT NULL,
  `fee` varchar(45) NOT NULL,
  PRIMARY KEY (`dogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `health` (
  `healthID` int NOT NULL,
  `dogID` varchar(45) NOT NULL,
  `diseaseType` varchar(45) NOT NULL,
  `dateContracted` varchar(45) NOT NULL,
  `needMedication` varchar(45) NOT NULL,
  PRIMARY KEY (`healthID`),
  KEY `health_dogID_idx` (`dogID`),
  CONSTRAINT `health_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `medicalhistory` (
  `medicalHistoryID` int NOT NULL,
  `dogID` varchar(45) NOT NULL,
  `microchip` varchar(45) NOT NULL,
  `dateReceived` varchar(45) NOT NULL,
  `vaccinated` varchar(45) NOT NULL,
  PRIMARY KEY (`medicalHistoryID`),
  KEY `medicalHistory_dogID_idx` (`dogID`),
  CONSTRAINT `medicalHistory_dogID` FOREIGN KEY (`dogID`) REFERENCES `dog` (`dogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;