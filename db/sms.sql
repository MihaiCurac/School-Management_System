-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sms
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `schoolinfo`
--

DROP TABLE IF EXISTS `schoolinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schoolinfo` (
  `SchoolName` varchar(80) DEFAULT NULL,
  `SchoolAddress` varchar(80) DEFAULT NULL,
  `classAvailable` varchar(20) DEFAULT NULL,
  `schoolType` varchar(50) DEFAULT NULL,
  `postalCode` varchar(10) NOT NULL,
  `dateOfEstd` date DEFAULT NULL,
  `schoolID` varchar(30) NOT NULL,
  `nameOfPrincipal` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolinfo`
--

LOCK TABLES `schoolinfo` WRITE;
/*!40000 ALTER TABLE `schoolinfo` DISABLE KEYS */;
INSERT INTO `schoolinfo` VALUES ('Gheorghe Sincai National College','Sincai Gheorghe 25, Baia Mare','8','Public day high school','430311','1919-07-12','12345','Leonard Mardar');
/*!40000 ALTER TABLE `schoolinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `empNo` varchar(10) NOT NULL,
  `teacherName` varchar(60) DEFAULT NULL,
  `taughtSubject` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT '-',
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`empNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('101','Aysha Hudson','Mathematics ','1965-06-17','Female','ayshahud@gmail.com','0783242934','Unirii 85, Cluj-Napoca'),('102','Nicolas Gardner','Programming','1985-10-08','Male','nicgardner@gmail.com','0723765913','Mihai Viteazu 190, Baia Mare'),('103','Katelyn Lester','Biology','1979-09-10','Female','katelester@gmail.com','0711345678','Independentei 63, Brasov'),('104','Alessandra Beck','History','1990-02-02','Female','alessandrabeck@gmail.com','0788123453','Aleea Neptun 90, Cluj-Napoca'),('105','Jimmy Spence','Chemistry','1989-01-01','Male','jimmyspence@gmail.com','0789991233','Aristotel 9, Iasi'),('106','Lisa-Marie Jones','English','1969-03-04','Female','lisamarie@gmail.com','0712812932','Belis 8, Baia Mare'),('107','Lucas Dalton','Physics','1980-04-05','Male','daltonlucas@gmail.com','0792341243','Victor Babes 1, Cluj-Napoca'),('108','Jarod Davison','Geography','1991-03-20','Male','jaroddavid@gmail.com','0745234134','George Bacovia 41, Ploiesti'),('109','Isabell Thomson','German','1982-10-10','Female','isabellthomson@gmail.com','0732823843','Ion Creanga 48, Timisoara'),('110','Michael Stuart','Mathematics','1978-09-29','Male','mikestuart@gmail.com','0739224334','Iuliu Maniu 2, Cluj-Napoca');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `adNo` int NOT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `yearofstudy` varchar(3) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`adNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (10,'Jason Medrano','5','2001-05-11','Male','0747345923','Iuliu Maniu 1, Cluj-Napoca'),(11,'Claire Kim','5','2002-07-03','Female','0793425245','Independentei 8, Brasov'),(12,'Jarrod Savage','5','2000-10-28','Male','0724534524','Vasile Lucaciu 99, Baia Mare'),(19,'Chelsey Mitchell','7','2003-12-12','Female','0134235233','Wolfgang Goethe 20, Cluj-Napoca'),(18,'Nathan Dyer','7','2004-09-11','Male','0324235233','Sindicatelor 1, Sibiu'),(17,'Cari Joseph','7','2005-09-24','Female','0342345322','Sighisoarei 10, Timisoara'),(16,'Sophie Rodgers','6','2005-07-20','Female','0423523523','Robert Schumann 91, Baia Mare'),(15,'Edgar Cousins','6','2007-02-03','Male','0324324523','Oltului 19, Pitesti'),(14,'Timothy Archer','6','2006-04-09','Male','0732423553','Mihail Eminescu 87, Constanta'),(13,'Riccardo Solomon','6','2005-08-10','Male','0372846235','Liviu Rebreanu 33, Cluj-Napoca'),(20,'Tony Clarke','7','2004-11-30','Male','0324235222','Traian Vuia 20, Cluj-Napoca'),(21,'Franklin Ashley','7','2004-01-19','Male','0342523532','Tipografiei 13, Craiova'),(22,'Thiago Flynn','8','2002-05-05','Male','0231242353','Somesului 2, Galati'),(23,'Joanna Ashton','8','2002-10-01','Female','0542345232','Soporului 24, Cluj-Napoca'),(24,'Molly Lane','8','2003-09-04','Female','0432525233','Radu Tudoran 3, Oradea'),(25,'Clayton Cooper','9','2001-05-28','Male','0432523523','Rahovei 5, Braila'),(26,'Chanel Ryder','9','2001-07-18','Female','0342352452','Gheorghe Marinescu 18, Arad'),(27,'Tyrell Woodward','9','2001-04-11','Male','0852352355','Napoca 90, Bacau'),(28,'Jillian Ramsey','10','2000-03-20','Female','0342452352','Mihail Kogalniceanu 13, Baia Mare'),(29,'Ho Bridges','10','2000-09-10','Female','0742343243','Luncii 28, Targu Mures'),(30,'Dora Bradshaw','10','2001-08-14','Female','0243124233','Jiului 1, Botosani'),(31,'Tobi Sweeney','11','1999-04-30','Male','0852353253','Henri Coanda 30, Cluj-Napoca'),(32,'Luther Lister','11','1998-10-23','Male','0423423532','Gheorghe Dima 18, Satu Mare'),(33,'Daniella Peterson','12','1997-09-01','Female','0842343252','Emil Racovita 77, Suceava'),(34,'Angela Atkins','12','1996-11-07','Female','0723425322','Cezar Petrescu 21, Cluj-Napoca');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin123'),('teacher','teacher123'),('student','student123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-09 19:18:24
