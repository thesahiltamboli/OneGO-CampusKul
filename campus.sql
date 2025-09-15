CREATE DATABASE  IF NOT EXISTS `campus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `campus`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: campus
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `alumni_details`
--

DROP TABLE IF EXISTS `alumni_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumni_details` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `alumni_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `college_id` int NOT NULL,
  `alumni_mobile` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alumni_email` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alumni_addr` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alumni_year` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `university` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pincode` varchar(12) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `about` text COLLATE utf8mb4_general_ci,
  `company_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `profilepic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `isMentor` tinyint DEFAULT '0',
  `status` tinyint DEFAULT '1',
  `createdby` int unsigned DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedby` int unsigned DEFAULT NULL,
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_alumni_user` (`user_id`),
  KEY `fk_alumni_college` (`college_id`),
  CONSTRAINT `fk_alumni_college` FOREIGN KEY (`college_id`) REFERENCES `college_details` (`id`),
  CONSTRAINT `fk_alumni_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumni_details`
--

LOCK TABLES `alumni_details` WRITE;
/*!40000 ALTER TABLE `alumni_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumni_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college_details`
--

DROP TABLE IF EXISTS `college_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `branch_id` int DEFAULT NULL,
  `college_name` varchar(260) COLLATE utf8mb4_general_ci NOT NULL,
  `contact_person_name` varchar(260) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `person_post` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact_person_number` bigint DEFAULT NULL,
  `contact_person_email` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `established_year` int DEFAULT NULL,
  `addr1` text COLLATE utf8mb4_general_ci NOT NULL,
  `addr2` text COLLATE utf8mb4_general_ci,
  `addr3` text COLLATE utf8mb4_general_ci,
  `zipcode` int DEFAULT NULL,
  `college_logo` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `college_banner` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `accr_certificate` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `reg_certificate` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `institute_profile` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact_info` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `auth_letter` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `privacy` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `terms` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` int DEFAULT '1',
  `createdby` int DEFAULT NULL,
  `createdate` date NOT NULL,
  `updatedby` int DEFAULT NULL,
  `updatedate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college_details`
--

LOCK TABLES `college_details` WRITE;
/*!40000 ALTER TABLE `college_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `college_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_details`
--

DROP TABLE IF EXISTS `course_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department_id` int NOT NULL,
  `course_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `course_code` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `duration_years` int DEFAULT NULL,
  `credits` int DEFAULT NULL,
  `status` int DEFAULT '1',
  `createdby` int DEFAULT NULL,
  `createdate` date NOT NULL,
  `updatedby` int DEFAULT NULL,
  `updatedate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_department` (`department_id`),
  CONSTRAINT `fk_course_department` FOREIGN KEY (`department_id`) REFERENCES `department_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_details`
--

LOCK TABLES `course_details` WRITE;
/*!40000 ALTER TABLE `course_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_details`
--

DROP TABLE IF EXISTS `department_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `college_id` int NOT NULL,
  `department_name` varchar(120) COLLATE utf8mb4_general_ci NOT NULL,
  `hod_name` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact_number` bigint DEFAULT NULL,
  `contact_email` varchar(120) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` int DEFAULT '1',
  `createdby` int DEFAULT NULL,
  `createdate` date NOT NULL,
  `updatedby` int DEFAULT NULL,
  `updatedate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_department_college` (`college_id`),
  CONSTRAINT `fk_department_college` FOREIGN KEY (`college_id`) REFERENCES `college_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_details`
--

LOCK TABLES `department_details` WRITE;
/*!40000 ALTER TABLE `department_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_details`
--

DROP TABLE IF EXISTS `event_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `event_date` date NOT NULL,
  `event_time` time DEFAULT NULL,
  `venue` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `organizer` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `banner_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_event_post` (`post_id`),
  CONSTRAINT `fk_event_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_details`
--

LOCK TABLES `event_details` WRITE;
/*!40000 ALTER TABLE `event_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'MANAGE_USERS','Create, update, delete user accounts'),(2,'CREATE_POST','Create new posts'),(3,'EDIT_POST','Edit existing posts'),(4,'DELETE_POST','Delete posts'),(5,'VIEW_EVENTS','View event details'),(6,'CREATE_EVENT','Create new events'),(7,'EDIT_EVENT','Edit existing events'),(8,'DELETE_EVENT','Delete events');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_comments`
--

DROP TABLE IF EXISTS `post_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` bigint NOT NULL,
  `comment_text` text COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_comment_post` (`post_id`),
  KEY `fk_comment_user` (`user_id`),
  CONSTRAINT `fk_comment_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_comments`
--

LOCK TABLES `post_comments` WRITE;
/*!40000 ALTER TABLE `post_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_images`
--

DROP TABLE IF EXISTS `post_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `image_url` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `caption` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_image_post` (`post_id`),
  CONSTRAINT `fk_image_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_images`
--

LOCK TABLES `post_images` WRITE;
/*!40000 ALTER TABLE `post_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_likes`
--

DROP TABLE IF EXISTS `post_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_likes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` bigint NOT NULL,
  `reaction_type` enum('LIKE','LOVE','INTERESTED','SUPPORT') COLLATE utf8mb4_general_ci DEFAULT 'LIKE',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_post_user` (`post_id`,`user_id`),
  KEY `fk_like_user` (`user_id`),
  CONSTRAINT `fk_like_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_like_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_likes`
--

LOCK TABLES `post_likes` WRITE;
/*!40000 ALTER TABLE `post_likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `college_id` int DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `content` text COLLATE utf8mb4_general_ci NOT NULL,
  `post_type` enum('GENERAL','NOTICE','EVENT') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'GENERAL',
  `status` int DEFAULT '1',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_posts_user` (`user_id`),
  KEY `fk_posts_college` (`college_id`),
  CONSTRAINT `fk_posts_college` FOREIGN KEY (`college_id`) REFERENCES `college_details` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_posts_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permissions` (
  `role_id` bigint NOT NULL,
  `permission_id` bigint NOT NULL,
  `granted_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `fk_perm_role` (`permission_id`),
  CONSTRAINT `fk_perm_role` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_role_perm` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
INSERT INTO `role_permissions` VALUES (1,1,'2025-08-13 17:49:30'),(1,2,'2025-08-13 17:49:30'),(1,3,'2025-08-13 17:49:30'),(1,4,'2025-08-13 17:49:30'),(1,5,'2025-08-13 17:49:30'),(1,6,'2025-08-13 17:49:30'),(1,7,'2025-08-13 17:49:30'),(1,8,'2025-08-13 17:49:30'),(2,2,'2025-08-13 17:49:30'),(2,5,'2025-08-13 17:49:30'),(3,2,'2025-08-13 17:49:30'),(3,5,'2025-08-13 17:49:30'),(4,5,'2025-08-13 17:49:30'),(4,6,'2025-08-13 17:49:30'),(4,7,'2025-08-13 17:49:30'),(4,8,'2025-08-13 17:49:30');
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN','Full administrative access'),(2,'ROLE_ALUMNI','Alumni user'),(3,'ROLE_STUDENT','Current student'),(4,'ROLE_STAFF','College staff or faculty');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_course_mapping`
--

DROP TABLE IF EXISTS `staff_course_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_course_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` int NOT NULL,
  `course_id` int NOT NULL,
  `assigned_date` date NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_general_ci DEFAULT 'Lecturer',
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_staff_course` (`staff_id`,`course_id`),
  KEY `fk_staff_course_course` (`course_id`),
  CONSTRAINT `fk_staff_course_course` FOREIGN KEY (`course_id`) REFERENCES `course_details` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_staff_course_staff` FOREIGN KEY (`staff_id`) REFERENCES `staff_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_course_mapping`
--

LOCK TABLES `staff_course_mapping` WRITE;
/*!40000 ALTER TABLE `staff_course_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_course_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_details`
--

DROP TABLE IF EXISTS `staff_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `college_id` int NOT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `subject` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `position` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` tinyint DEFAULT '1',
  `createdby` int DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedby` int DEFAULT NULL,
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_faculty_user` (`user_id`),
  KEY `fk_faculty_college` (`college_id`),
  CONSTRAINT `fk_faculty_college` FOREIGN KEY (`college_id`) REFERENCES `college_details` (`id`),
  CONSTRAINT `fk_faculty_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_details`
--

LOCK TABLES `staff_details` WRITE;
/*!40000 ALTER TABLE `staff_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_enrollment`
--

DROP TABLE IF EXISTS `student_course_enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course_enrollment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` bigint NOT NULL,
  `course_id` int NOT NULL,
  `enrollment_date` date NOT NULL,
  `status` int DEFAULT '1',
  `grade` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_student_course` (`student_id`,`course_id`),
  KEY `fk_enrollment_course` (`course_id`),
  CONSTRAINT `fk_enrollment_course` FOREIGN KEY (`course_id`) REFERENCES `course_details` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_enrollment_student` FOREIGN KEY (`student_id`) REFERENCES `student_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_enrollment`
--

LOCK TABLES `student_course_enrollment` WRITE;
/*!40000 ALTER TABLE `student_course_enrollment` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_course_enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `college_id` int NOT NULL,
  `student_mobile` varchar(20) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_addr` varchar(500) DEFAULT NULL,
  `student_dept` varchar(255) DEFAULT NULL,
  `student_year` varchar(50) DEFAULT NULL,
  `passing_year` year DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `country_id` bigint unsigned DEFAULT NULL,
  `state_id` bigint unsigned DEFAULT NULL,
  `city_id` bigint unsigned DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `about` text,
  `mother_name` varchar(255) DEFAULT NULL,
  `profilepic` varchar(255) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `createdby` bigint unsigned DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedby` bigint unsigned DEFAULT NULL,
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_student_user` (`user_id`),
  KEY `fk_student_college` (`college_id`),
  CONSTRAINT `fk_student_college` FOREIGN KEY (`college_id`) REFERENCES `college_details` (`id`),
  CONSTRAINT `fk_student_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_details`
--

LOCK TABLES `student_details` WRITE;
/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  `assigned_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role` (`role_id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,3,'2025-08-15 15:24:04');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `prn_number` varchar(255) DEFAULT NULL,
  `account_status` enum('ACTIVE','INACTIVE','SUSPENDED') DEFAULT 'ACTIVE',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'pritish123','pritish.deshpande@example.com','$2a$10$vZ3T42zekfAw3XQkYz7oBOey25FWryStvhvbJDZZ4za3lydIqFJsC','Pritish','Deshpande','S Deshpande','+91-9876543210','PRN2025001','ACTIVE','2025-08-15 09:54:04','2025-08-15 09:54:04');
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

-- Dump completed on 2025-08-21  9:37:36
