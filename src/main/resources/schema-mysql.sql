CREATE TABLE IF NOT EXISTS `customers1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) DEFAULT NULL,
  `order_date` timestamp NULL DEFAULT NULL,
  `movie_code` varchar(45) DEFAULT NULL,
  `ticket_quantity` int DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  `verify` tinyint NOT NULL,
  PRIMARY KEY (`id`)
  );
  
  CREATE TABLE IF NOT EXISTS `movie1` (
  `movie_code` varchar(45) NOT NULL,
  `movie_name` varchar(45) DEFAULT NULL,
  `day` varchar(45) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `price` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `total_ticket` int DEFAULT NULL,
  `ticket_balance` int DEFAULT NULL,
  PRIMARY KEY (`movie_code`)
  );