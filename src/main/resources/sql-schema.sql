drop schema IF EXISTS ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `items_id` INT(11) NOT NULL AUTO_INCREMENT,
    `items_name` VARCHAR(40) NOT NULL,

    `price` DEC(10, 2) NOT NULL,
    PRIMARY KEY (`items_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
      fk_id INT NOT NULL,
      order_id INT(11) NOT NULL AUTO_INCREMENT,
      PRIMARY KEY (order_id, fk_id),
      FOREIGN KEY (fk_id) REFERENCES customers(id) ON DELETE CASCADE
);

 CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
      orderitems_id INT(11) NOT NULL AUTO_INCREMENT,
      fk_order_id INT NOT NULL,
      fk_items_id INT NOT NULL, 
      item_quantity INT(50) NOT NULL,

	      
      PRIMARY KEY (orderitems_id),
      FOREIGN KEY (fk_order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
      FOREIGN KEY (fk_items_id) REFERENCES items(items_id) ON DELETE CASCADE
);