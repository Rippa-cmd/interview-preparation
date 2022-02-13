--
-- Table structure for table `day_multiplier`
--

DROP TABLE IF EXISTS `day_multiplier`;
CREATE TABLE `day_multiplier` (
  `id_day_multiplier` int NOT NULL AUTO_INCREMENT,
  `day` varchar(10) NOT NULL,
  `day_multiplier` float NOT NULL,
  PRIMARY KEY (`id_day_multiplier`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `day_multiplier`
--

LOCK TABLES `day_multiplier` WRITE;
INSERT INTO `day_multiplier` VALUES (1,'Sunday',2),(2,'Monday',1.5),(3,'Tuesday',1),(4,'Wednesday',0.7),(5,'Thursday',0.9),(6,'Friday',1.4),(7,'Saturday',2.5);
UNLOCK TABLES;

--
-- Table structure for table `film_duration`
--

DROP TABLE IF EXISTS `film_duration`;
CREATE TABLE `film_duration` (
  `id_duration` int NOT NULL AUTO_INCREMENT,
  `film_duration` int NOT NULL,
  PRIMARY KEY (`id_duration`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `film_duration`
--

LOCK TABLES `film_duration` WRITE;
INSERT INTO `film_duration` VALUES (1,60),(2,90),(3,120);
UNLOCK TABLES;

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;
CREATE TABLE `films` (
  `id_film` int NOT NULL AUTO_INCREMENT,
  `film_name` varchar(45) NOT NULL,
  `id_duration` int NOT NULL,
  `def_cost` int NOT NULL,
  PRIMARY KEY (`id_film`),
  KEY `film-duration_idx` (`id_duration`),
  CONSTRAINT `film-duration` FOREIGN KEY (`id_duration`) REFERENCES `film_duration` (`id_duration`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `films`
--

LOCK TABLES `films` WRITE;
INSERT INTO `films` VALUES (1,'Avatar',3,200),(2,'Moon',2,150),(3,'Nut',2,170),(4,'Banana',1,90),(5,'Harry Potter',3,300);
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
CREATE TABLE `tickets` (
  `id_ticket` int NOT NULL AUTO_INCREMENT,
  `id_timetable` int NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `ticket-timetable_frk_idx` (`id_timetable`),
  CONSTRAINT `ticket-timetable_frk` FOREIGN KEY (`id_timetable`) REFERENCES `timetable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
INSERT INTO `tickets` VALUES (1,1),(3,1),(32,1),
(45,1),(46,1),(4,2),(15,2),(31,2),(44,2),(48,2),
(5,3),(10,3),(12,3),(23,3),(30,3),(49,3),(50,3),
(6,4),(14,4),(17,4),(22,4),(33,4),(43,4),(51,4),
(29,5),(34,5),(42,5),(52,5),(53,5),(8,6),(13,6),
(18,6),(24,6),(38,6),(54,6),(55,6),(9,7),(25,7),
(28,7),(35,7),(41,7),(56,7),(2,8),(19,8),(26,8),
(36,8),(39,8),(40,8),(27,9),(37,9),(58,9),(16,10),
(59,10),(20,11),(21,11),(47,11),(7,12),(11,12),(57,12);
UNLOCK TABLES;

--
-- Table structure for table `time_multiplier`
--

DROP TABLE IF EXISTS `time_multiplier`;
CREATE TABLE `time_multiplier` (
  `id_multiplier` int NOT NULL AUTO_INCREMENT,
  `time_from` time NOT NULL,
  `time_to` time NOT NULL,
  `mutliplier` float NOT NULL,
  PRIMARY KEY (`id_multiplier`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `time_multiplier`
--

LOCK TABLES `time_multiplier` WRITE;
INSERT INTO `time_multiplier` VALUES (1,'09:00:00','12:00:00',1),(2,'12:00:00','15:00:00',1.5),(3,'15:00:00','19:00:00',2),(4,'19:00:00','21:00:00',1.9),(5,'21:00:00','23:00:00',1),(6,'23:00:00','24:00:00',1.2),(8,'00:00:00','09:00:00',0.5);
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `id_film` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `timetable-film_foreignt_idx` (`id_film`),
  CONSTRAINT `timetable-film_foreignt` FOREIGN KEY (`id_film`) REFERENCES `films` (`id_film`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
INSERT INTO `timetable` VALUES (1,'2008-10-23 10:30:00',1),
(2,'2008-10-23 19:00:00',1),(3,'2008-10-23 21:20:00',3),
(4,'2008-10-23 18:50:00',2),(5,'2008-10-23 07:30:00',4),
(6,'2008-10-23 01:10:00',3),(7,'2008-10-23 13:00:00',5),
(8,'2008-10-23 16:35:00',1),(9,'2008-10-23 23:00:00',4),
(10,'2008-10-23 09:40:00',2),(11,'2008-10-23 12:00:00',5),
(12,'2008-10-23 14:27:00',3);
UNLOCK TABLES;
