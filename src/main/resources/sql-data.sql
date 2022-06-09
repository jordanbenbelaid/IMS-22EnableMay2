INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`items_name`, `price`) VALUES ('iPad', '1000');
INSERT INTO `ims`.`orders` (`fk_id`) VALUES (1);
INSERT INTO `ims`.`orders_items` (`fk_order_id`, `fk_items_id`, `item_quantity`) VALUES ('1', '1','2');
