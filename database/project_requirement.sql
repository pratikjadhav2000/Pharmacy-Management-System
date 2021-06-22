-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement` (
  `Complaint_no` int(11) NOT NULL AUTO_INCREMENT,
  `Drug_id` int(11) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Complaint_no`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES (27,34,'Expired : Sopramycin '),(28,37,'Expired : Miconazole '),(29,34,'Expired : Sopramycin '),(30,37,'Expired : Miconazole '),(31,34,'Expired : Sopramycin '),(32,37,'Expired : Miconazole '),(33,34,'Expired : Sopramycin '),(34,37,'Expired : Miconazole '),(35,34,'Expired : Sopramycin '),(36,37,'Expired : Miconazole '),(37,34,'Expired : Sopramycin '),(38,37,'Expired : Miconazole '),(39,34,'Expired : Sopramycin '),(40,37,'Expired : Miconazole '),(41,34,'Expired : Sopramycin '),(42,37,'Expired : Miconazole '),(43,34,'Expired : Sopramycin '),(44,37,'Expired : Miconazole '),(45,35,'Out of Stock: Aspirine '),(46,34,'Expired : Sopramycin '),(47,37,'Expired : Miconazole '),(48,34,'Expired : Sopramycin '),(49,37,'Expired : Miconazole '),(50,34,'Expired : Sopramycin '),(51,37,'Expired : Miconazole '),(52,38,'Out of Stock: Xynax '),(53,34,'Expired : Sopramycin '),(54,37,'Expired : Miconazole '),(55,34,'Expired : Sopramycin '),(56,37,'Expired : Miconazole '),(57,34,'Expired : Sopramycin '),(58,37,'Expired : Miconazole '),(59,34,'Expired : Sopramycin '),(60,37,'Expired : Miconazole '),(61,34,'Expired : Sopramycin '),(62,37,'Expired : Miconazole '),(63,34,'Expired : Sopramycin '),(64,37,'Expired : Miconazole '),(65,34,'Expired : Sopramycin '),(66,37,'Expired : Miconazole '),(67,34,'Expired : Sopramycin '),(68,37,'Expired : Miconazole '),(69,34,'Expired : Sopramycin '),(70,37,'Expired : Miconazole '),(71,34,'Expired : Sopramycin '),(72,37,'Expired : Miconazole '),(73,34,'Expired : Sopramycin '),(74,37,'Expired : Miconazole '),(75,34,'Expired : Sopramycin '),(76,37,'Expired : Miconazole '),(77,31,'Out of Stock: Paracitemol '),(78,34,'Expired : Sopramycin '),(79,37,'Expired : Miconazole '),(80,34,'Expired : Sopramycin '),(81,37,'Expired : Miconazole '),(82,34,'Expired : Sopramycin '),(83,37,'Expired : Miconazole '),(84,34,'Expired : Sopramycin '),(85,37,'Expired : Miconazole '),(86,34,'Expired : Sopramycin '),(87,37,'Expired : Miconazole '),(88,33,'Expired : Gocan150 '),(89,34,'Expired : Sopramycin '),(90,37,'Expired : Miconazole '),(91,33,'Expired : Gocan150 '),(92,34,'Expired : Sopramycin '),(93,37,'Expired : Miconazole '),(94,33,'Expired : Gocan150 '),(95,34,'Expired : Sopramycin '),(96,37,'Expired : Miconazole '),(97,33,'Expired : Gocan150 '),(98,34,'Expired : Sopramycin '),(99,37,'Expired : Miconazole '),(100,33,'Expired : Gocan150 '),(101,34,'Expired : Sopramycin '),(102,37,'Expired : Miconazole '),(103,33,'Expired : Gocan150 '),(104,34,'Expired : Sopramycin '),(105,37,'Expired : Miconazole '),(106,33,'Expired : Gocan150 '),(107,34,'Expired : Sopramycin '),(108,37,'Expired : Miconazole '),(109,33,'Expired : Gocan150 '),(110,34,'Expired : Sopramycin '),(111,37,'Expired : Miconazole '),(112,33,'Expired : Gocan150 '),(113,34,'Expired : Sopramycin '),(114,37,'Expired : Miconazole '),(115,33,'Expired : Gocan150 '),(116,34,'Expired : Sopramycin '),(117,37,'Expired : Miconazole '),(118,33,'Expired : Gocan150 '),(119,34,'Expired : Sopramycin '),(120,37,'Expired : Miconazole '),(121,33,'Expired : Gocan150 '),(122,34,'Expired : Sopramycin '),(123,37,'Expired : Miconazole '),(124,33,'Expired : Gocan150 '),(125,34,'Expired : Sopramycin '),(126,37,'Expired : Miconazole '),(127,33,'Expired : Gocan150 '),(128,34,'Expired : Sopramycin '),(129,37,'Expired : Miconazole '),(130,33,'Expired : Gocan150 '),(131,34,'Expired : Sopramycin '),(132,37,'Expired : Miconazole '),(133,33,'Expired : Gocan150 '),(134,34,'Expired : Sopramycin '),(135,37,'Expired : Miconazole '),(136,29,'Expired : Olsar20 '),(137,30,'Expired : Crocin '),(138,31,'Expired : Paracitemol '),(139,33,'Expired : Gocan150 '),(140,34,'Expired : Sopramycin '),(141,35,'Expired : Aspirine '),(142,37,'Expired : Miconazole '),(143,39,'Expired : Disprin '),(144,29,'Expired : Olsar20 '),(145,30,'Expired : Crocin '),(146,31,'Expired : Paracitemol '),(147,33,'Expired : Gocan150 '),(148,34,'Expired : Sopramycin '),(149,35,'Expired : Aspirine '),(150,37,'Expired : Miconazole '),(151,39,'Expired : Disprin '),(152,29,'Expired : Olsar20 '),(153,30,'Expired : Crocin '),(154,31,'Expired : Paracitemol '),(155,33,'Expired : Gocan150 '),(156,34,'Expired : Sopramycin '),(157,35,'Expired : Aspirine '),(158,37,'Expired : Miconazole '),(159,39,'Expired : Disprin '),(160,29,'Expired : Olsar20 '),(161,30,'Expired : Crocin '),(162,31,'Expired : Paracitemol '),(163,33,'Expired : Gocan150 '),(164,34,'Expired : Sopramycin '),(165,35,'Expired : Aspirine '),(166,37,'Expired : Miconazole '),(167,39,'Expired : Disprin '),(168,29,'Expired : Olsar20 '),(169,30,'Expired : Crocin '),(170,31,'Expired : Paracitemol '),(171,33,'Expired : Gocan150 '),(172,34,'Expired : Sopramycin '),(173,35,'Expired : Aspirine '),(174,37,'Expired : Miconazole '),(175,39,'Expired : Disprin ');
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 13:46:53
