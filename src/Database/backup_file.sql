-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: admin
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `chuho`
--

DROP TABLE IF EXISTS `chuho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuho` (
  `maNhanKhau` int NOT NULL,
  `maHoKhau` int NOT NULL,
  PRIMARY KEY (`maNhanKhau`,`maHoKhau`),
  KEY `maHoKhau` (`maHoKhau`),
  CONSTRAINT `chuho_ibfk_1` FOREIGN KEY (`maNhanKhau`) REFERENCES `nhankhau` (`maNhanKhau`),
  CONSTRAINT `chuho_ibfk_2` FOREIGN KEY (`maHoKhau`) REFERENCES `hokhau` (`maHoKhau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuho`
--

LOCK TABLES `chuho` WRITE;
/*!40000 ALTER TABLE `chuho` DISABLE KEYS */;
INSERT INTO `chuho` VALUES (111,2),(3,3),(9,7),(2323,23);
/*!40000 ALTER TABLE `chuho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hokhau`
--

DROP TABLE IF EXISTS `hokhau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hokhau` (
  `maHoKhau` int NOT NULL,
  `soThanhVien` int NOT NULL,
  `diaChi` varchar(100) NOT NULL,
  PRIMARY KEY (`maHoKhau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hokhau`
--

LOCK TABLES `hokhau` WRITE;
/*!40000 ALTER TABLE `hokhau` DISABLE KEYS */;
INSERT INTO `hokhau` VALUES (2,4,'Hoằng Giang'),(3,4,'Thanh Hóa'),(7,4,'Thanh Hóa'),(23,6,'Hà Nội');
/*!40000 ALTER TABLE `hokhau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoanthu`
--

DROP TABLE IF EXISTS `khoanthu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoanthu` (
  `maKhoanthu` int NOT NULL,
  `tenkhoanthu` varchar(50) NOT NULL,
  `sotiennop` double NOT NULL,
  `loaikhoanthu` tinyint(1) NOT NULL,
  PRIMARY KEY (`maKhoanthu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoanthu`
--

LOCK TABLES `khoanthu` WRITE;
/*!40000 ALTER TABLE `khoanthu` DISABLE KEYS */;
INSERT INTO `khoanthu` VALUES (1,'Phí dịch vụ chung cư',10000,1),(2,'Phí quản lý chung cư',7000,1),(3,'Phí gửi xe ô tô',1200000,1),(4,'Phí gửi xe máy',70000,1),(5,'Phí dịch vụ sinh hoạt',300000,1);
/*!40000 ALTER TABLE `khoanthu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhankhau`
--

DROP TABLE IF EXISTS `nhankhau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhankhau` (
  `maNhanKhau` int NOT NULL,
  `hoTen` varchar(50) DEFAULT NULL,
  `soCMND` char(11) NOT NULL,
  `ngaySinh` date DEFAULT NULL,
  `SDT` char(11) NOT NULL,
  PRIMARY KEY (`maNhanKhau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhankhau`
--

LOCK TABLES `nhankhau` WRITE;
/*!40000 ALTER TABLE `nhankhau` DISABLE KEYS */;
INSERT INTO `nhankhau` VALUES (3,'Trịnh Huyền My','1233445','2003-01-15','3243432'),(9,'Cao Minh Đức','1233445','2003-01-15','3243432'),(111,'Nguyễn Thị Chính','132234','1975-10-05','23434234'),(1232,'Đạt 09','123455','2003-01-01','123466755'),(1234,'Đạt 09','123455','2003-01-01','123466755'),(2323,'Lê Tuấn Phi','12231321','2003-10-10','12123123');
/*!40000 ALTER TABLE `nhankhau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noptien`
--

DROP TABLE IF EXISTS `noptien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noptien` (
  `maNhanKhau` int NOT NULL,
  `maKhoanthu` int NOT NULL,
  `ngayThu` date DEFAULT NULL,
  `soTienNop` double DEFAULT NULL,
  PRIMARY KEY (`maNhanKhau`,`maKhoanthu`),
  KEY `maKhoanthu` (`maKhoanthu`),
  CONSTRAINT `noptien_ibfk_1` FOREIGN KEY (`maNhanKhau`) REFERENCES `nhankhau` (`maNhanKhau`),
  CONSTRAINT `noptien_ibfk_2` FOREIGN KEY (`maKhoanthu`) REFERENCES `khoanthu` (`maKhoanthu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noptien`
--

LOCK TABLES `noptien` WRITE;
/*!40000 ALTER TABLE `noptien` DISABLE KEYS */;
INSERT INTO `noptien` VALUES (3,5,'2023-12-08',NULL),(9,1,'2023-12-09',NULL),(111,3,'2024-01-05',NULL),(1232,1,'2023-12-10',NULL),(1234,5,'2023-12-28',NULL),(2323,5,'2024-01-04',NULL);
/*!40000 ALTER TABLE `noptien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanhe`
--

DROP TABLE IF EXISTS `quanhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanhe` (
  `maHoKhau` int NOT NULL,
  `maNhanKhau` int NOT NULL,
  `quanHe` varchar(50) NOT NULL,
  PRIMARY KEY (`maHoKhau`,`maNhanKhau`),
  KEY `maNhanKhau` (`maNhanKhau`),
  CONSTRAINT `quanhe_ibfk_1` FOREIGN KEY (`maHoKhau`) REFERENCES `hokhau` (`maHoKhau`),
  CONSTRAINT `quanhe_ibfk_2` FOREIGN KEY (`maNhanKhau`) REFERENCES `nhankhau` (`maNhanKhau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanhe`
--

LOCK TABLES `quanhe` WRITE;
/*!40000 ALTER TABLE `quanhe` DISABLE KEYS */;
/*!40000 ALTER TABLE `quanhe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13 16:30:29
