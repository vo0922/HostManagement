-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: hostmanage
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alive`
--

DROP TABLE IF EXISTS `alive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_ping` datetime(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `host_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6btcphrjj7jivfdmdcw9n1dda` (`host_id`),
  CONSTRAINT `FK6btcphrjj7jivfdmdcw9n1dda` FOREIGN KEY (`host_id`) REFERENCES `hosts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alive`
--

LOCK TABLES `alive` WRITE;
/*!40000 ALTER TABLE `alive` DISABLE KEYS */;
INSERT INTO `alive` VALUES (1,'2022-06-23 02:05:19.863498','Reachable',1),(2,'2022-06-23 02:08:27.877544','Reachable',2),(3,'2022-06-23 02:09:39.543497','Unreachable',3),(4,'2022-06-23 02:09:57.076505','Reachable',4),(5,'2022-06-23 02:10:52.048885','Unreachable',9),(6,'2022-06-23 02:10:52.048885','Unreachable',8),(7,'2022-06-23 02:10:52.048885','Unreachable',11),(8,'2022-06-23 02:10:52.049884','Unreachable',10),(9,'2022-06-23 02:10:52.049884','Unreachable',6),(10,'2022-06-23 02:10:52.050886','Unreachable',7),(11,'2022-06-23 02:10:52.049884','Unreachable',12),(12,'2022-06-23 02:10:52.051886','Unreachable',5);
/*!40000 ALTER TABLE `alive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hosts`
--

DROP TABLE IF EXISTS `hosts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime(6) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `lastupdated_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hosts`
--

LOCK TABLES `hosts` WRITE;
/*!40000 ALTER TABLE `hosts` DISABLE KEYS */;
INSERT INTO `hosts` VALUES (1,'2022-06-23 02:05:08.825019','39.116.125.99','2022-06-23 02:05:08.825019','박신욱'),(2,'2022-06-23 02:08:25.721542','192.168.0.10','2022-06-23 02:08:25.721542','Parksinuk'),(3,'2022-06-23 02:09:37.211564','192.168.0.0','2022-06-23 02:09:37.211564','test1'),(4,'2022-06-23 02:09:55.377574','192.168.0.1','2022-06-23 02:09:55.377574','test2'),(5,'2022-06-23 02:10:16.697400','192.168.0.2','2022-06-23 02:10:16.697400','test3'),(6,'2022-06-23 02:10:23.125514','192.168.0.3','2022-06-23 02:10:23.125514','test4'),(7,'2022-06-23 02:10:27.345509','192.168.0.4','2022-06-23 02:10:27.345509','test5'),(8,'2022-06-23 02:10:30.792581','192.168.0.5','2022-06-23 02:10:30.792581','test6'),(9,'2022-06-23 02:10:34.719237','192.168.0.6','2022-06-23 02:10:34.719237','test7'),(10,'2022-06-23 02:10:40.959583','192.168.0.7','2022-06-23 02:10:40.959583','test8'),(11,'2022-06-23 02:10:45.757096','192.168.0.8','2022-06-23 02:10:45.757096','test9'),(12,'2022-06-23 02:10:49.721591','192.168.0.9','2022-06-23 02:10:49.721591','test10');
/*!40000 ALTER TABLE `hosts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23  2:52:47
