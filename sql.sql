-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: determine_bone_diseases
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disease` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `cure_method` varchar(225) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease`
--

LOCK TABLES `disease` WRITE;
/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` VALUES (1,'Viêm khớp dạng thấp','Dùng thuốc, nghỉ ngơi, tập thể dục và phẫu thuật nhằm khắc phục tổn thương khớp'),(2,'Viêm khớp cột sống','Điều trị bằng nội khoa, vật lý trị liệu, phẫu thuật'),(3,'Gout cấp','Điều trị nội khoa, điều trị ngoại khoa'),(4,'Gout mãn','Sử dụng thuốc, thiết lập và duy trì chế độ ăn uống phù hợp, can thiệp và phẫu thuật'),(5,'Loãng xương','Điều trị bằng chế độ ăn uồng, chế độ sinh hoạt, tập thể dục ngoài trời'),(6,'Thoái hóa khớp','Phẫu thuật nội soi làm sạch, phẫu thuật nội soi tạo tổn thương dưới sụn, ghép tế bào sụn tự thân, ghép xương sụn tự thân hoặc đồng loại'),(7,'Lupus','Thuốc ức chế miễn dịch, Glucocorticoid, thuốc chống sốt rét chloroquin');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptom`
--

DROP TABLE IF EXISTS `symptom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `symptom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptom`
--

LOCK TABLES `symptom` WRITE;
/*!40000 ALTER TABLE `symptom` DISABLE KEYS */;
INSERT INTO `symptom` VALUES (1,'Khởi phát từ từ (55-65%): sưng khớp'),(2,'Thường ảnh hưởng tại các khớp nhỏ'),(3,'Cứng khớp buổi sáng (≥30-45ph)'),(4,'Mệt mỏi, chán ăn'),(5,'Hiếm khi triệu chứng tại khớp mất hoàn toàn'),(6,'Khởi phát trước 45t'),(7,'Đau hơn 3 tháng'),(8,'Đau lưng vùng thấp, đau mông'),(9,'Thức giấc do đau lưng, thường từ nửa đêm'),(10,'Cứng lưng buổi sáng ít nhất 30ph'),(11,'Khởi phát âm ỉ'),(12,'Cải thiện với vận động, không cải thiện khi'),(13,'Đáp ứng với NSAIDs'),(14,'Đau ngực'),(15,'Đau mông'),(16,'Viêm màng bồ đào trước cấp tính'),(17,'Viêm màng hoạt dịch (thường chi dưới, ko đối xứng)'),(18,'Viêm điểm bám gân (gân gót, cân gan chân)'),(19,'Tiền căn gia đình'),(20,'Viêm ruột mạn tính'),(21,'Vẩy nến'),(22,'Vị trí: đa số bắt đầu ở khớp bàn ngón chân I hoặc khớp cổ chân'),(23,'Tính chất của cơn viêm khớp cấp: đột ngột đau dữ dội kèm sưng tấy, nóng, đỏ, sung huyết…ở 1 khớp, không đối xứng, thường xảy ra về đêm'),(24,'Triệu chứng viêm khớp tăng tối đa trong 12-24 giờ và kéo dài từ vài ngày đến vài tuần rồi có thể tự khỏi hoàn toàn'),(25,'Tophy (+)'),(26,'Các đợt viêm khớp diễn ra thường xuyên và kéo dài hơn'),(27,'Giữa các đợt viêm, các khớp vẫn có thể có tình trạng viêm nhẹ'),(28,'Thường không có biểu hiện gì cho đến khi có biến chứng gãy xương'),(29,'Biến chứng LX: đau kéo dài do chèn ép TK, gù vẹo CS, biến dạng lồng ngực, gãy xương cổ tay, CXĐ, xẹp đốt sống, giảm khả năng VĐ'),(30,'Thường ảnh hưởng: gối, bàn tay, háng, cột sống'),(31,'Đau khớp, cột sống, tăng khi vận động, giảm khi nghỉ ngơi, cứng khớp buổi sáng <30ph'),(32,'Phì đại xương, kêu lụp cụp khi khám, giảm ROM'),(33,'± tràn dịch'),(34,'Là bệnh lý hệ thống tổn thương nhiều cơ quan'),(35,'Tổn thương nội tạng, ban da, loét miệng, viêm đa khớp, nhạy cảm ánh sáng và viêm thanh mạc'),(36,'Biểu hiện lâm sàng đa dạng, tiên lượng bệnh thay đổi nhiều');
/*!40000 ALTER TABLE `symptom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weight`
--

DROP TABLE IF EXISTS `weight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `weight` double NOT NULL,
  `id_disease` int NOT NULL,
  `id_symptom` int NOT NULL,
  PRIMARY KEY (`id`,`id_disease`,`id_symptom`),
  KEY `fk_weight_disease_idx` (`id_disease`),
  KEY `fk_weight_symptom1_idx` (`id_symptom`),
  CONSTRAINT `fk_weight_disease` FOREIGN KEY (`id_disease`) REFERENCES `disease` (`id`),
  CONSTRAINT `fk_weight_symptom1` FOREIGN KEY (`id_symptom`) REFERENCES `symptom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight`
--

LOCK TABLES `weight` WRITE;
/*!40000 ALTER TABLE `weight` DISABLE KEYS */;
INSERT INTO `weight` VALUES (1,10,1,1),(2,10,1,2),(3,10,1,3),(4,10,1,4),(5,10,1,5),(6,10,2,6),(7,10,2,7),(8,10,2,8),(9,10,2,9),(10,10,2,10),(11,10,2,11),(12,10,2,12),(13,10,2,13),(14,5,2,14),(15,5,2,15),(16,5,2,16),(17,5,2,17),(18,5,2,18),(19,5,2,19),(20,5,2,20),(21,5,2,21),(22,10,3,22),(23,10,3,23),(24,10,3,24),(25,10,4,25),(26,10,4,26),(27,10,4,27),(28,10,5,28),(29,10,5,29),(30,10,6,30),(31,10,6,31),(32,10,6,32),(33,10,6,33),(34,10,7,34),(35,10,7,35),(36,10,7,36);
/*!40000 ALTER TABLE `weight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-16  7:05:29
