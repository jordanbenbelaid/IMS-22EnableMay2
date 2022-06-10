SELECT * FROM ims.items;
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('James', 'Harris'), ('Megan', 'Marsh');
INSERT INTO `items` (`items_name`, `price`) VALUES ('chocolate bar', 0.99), ('apple juice', 0.85);
INSERT INTO `orders` (`fk_id`, `order_id`) VALUES (1,2);
INSERT INTO `orders_items` (`fk_order_id`, `fk_items_id`, `item_quantity`) VALUES (1,1,2);
