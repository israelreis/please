CREATE DATABASE  IF NOT EXISTS `lanche_facil` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lanche_facil`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: lanche_facil
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bebida` (
  `id_bebida` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` decimal(19,4) NOT NULL,
  PRIMARY KEY (`id_bebida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (1,'Suco de Laranja',2.5000),(2,'Suce de Uva',2.5000),(3,'Refrigerante 600ml',3.0000),(4,'Refrigerante 2l',6.0000);
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bebida_has_pedido`
--

DROP TABLE IF EXISTS `bebida_has_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bebida_has_pedido` (
  `bebida_id_bebida` int(11) NOT NULL,
  `pedido_id_pedido` int(11) NOT NULL,
  PRIMARY KEY (`bebida_id_bebida`,`pedido_id_pedido`),
  KEY `fk_bebida_has_pedido_pedido1_idx` (`pedido_id_pedido`),
  KEY `fk_bebida_has_pedido_bebida1_idx` (`bebida_id_bebida`),
  CONSTRAINT `fk_bebida_has_pedido_bebida1` FOREIGN KEY (`bebida_id_bebida`) REFERENCES `bebida` (`id_bebida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bebida_has_pedido_pedido1` FOREIGN KEY (`pedido_id_pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida_has_pedido`
--

LOCK TABLES `bebida_has_pedido` WRITE;
/*!40000 ALTER TABLE `bebida_has_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `bebida_has_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lanche`
--

DROP TABLE IF EXISTS `lanche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lanche` (
  `id_lanche` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `preco` decimal(19,4) NOT NULL,
  `ingredientes` text,
  PRIMARY KEY (`id_lanche`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lanche`
--

LOCK TABLES `lanche` WRITE;
/*!40000 ALTER TABLE `lanche` DISABLE KEYS */;
INSERT INTO `lanche` VALUES (1,'Paxtel de Carne',4.2500,'Carne, Ovo'),(2,'Paxtel de Queijo',4.2500,'Queijo'),(3,'Paxtel de Nada',2.5000,'Nada');
/*!40000 ALTER TABLE `lanche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `id_mesa` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id_mesa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,1,'Disponível'),(2,2,'Disponível'),(3,3,'Disponível'),(4,4,'Disponível'),(5,5,'Disponível'),(6,6,'Disponível');
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `lanches` text,
  `bebidas` text,
  `data` date DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `mesa_id_mesa` int(11) NOT NULL,
  `preco` decimal(19,4) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `fk_pedido_usuario_idx` (`usuario_id_usuario`),
  KEY `fk_pedido_mesa1_idx` (`mesa_id_mesa`),
  CONSTRAINT `fk_pedido_mesa1` FOREIGN KEY (`mesa_id_mesa`) REFERENCES `mesa` (`id_mesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_has_lanche`
--

DROP TABLE IF EXISTS `pedido_has_lanche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_has_lanche` (
  `pedido_id_pedido` int(11) NOT NULL,
  `lanche_id_lanche` int(11) NOT NULL,
  PRIMARY KEY (`pedido_id_pedido`,`lanche_id_lanche`),
  KEY `fk_pedido_has_lanche_lanche1_idx` (`lanche_id_lanche`),
  KEY `fk_pedido_has_lanche_pedido1_idx` (`pedido_id_pedido`),
  CONSTRAINT `fk_pedido_has_lanche_lanche1` FOREIGN KEY (`lanche_id_lanche`) REFERENCES `lanche` (`id_lanche`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_lanche_pedido1` FOREIGN KEY (`pedido_id_pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_has_lanche`
--

LOCK TABLES `pedido_has_lanche` WRITE;
/*!40000 ALTER TABLE `pedido_has_lanche` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_has_lanche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nome_usuario` varchar(45) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Garçom Biruleibe','biruleibe','123'),(2,'Outro Garçom','babebabe','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-04 23:50:01
