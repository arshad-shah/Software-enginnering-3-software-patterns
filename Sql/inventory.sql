
DROP TABLE inventory;

CREATE TABLE `inventory` (
	`itemid` int(11) NOT NULL,
	`ITEM_NAME` varchar(50) NOT NULL,
	`ITEM_DESC` varchar(50) NOT NULL,
	`ITEM_PRICE` int(11) NOT NULL,
	`ITEM_QUANTITY` int(11) NOT NULL,
	`ITEM_CATEGORY` varchar(50) NOT NULL,
	`ITEM_SUPPLIER` varchar(50) NOT NULL,
	PRIMARY KEY (`itemid`)
);
INSERT INTO `inventory` (`itemid`, `ITEM_NAME`, `ITEM_DESC`, `ITEM_PRICE`, `ITEM_QUANTITY`, `ITEM_CATEGORY`, `ITEM_SUPPLIER`) VALUES
(1, 'Coca-Cola', 'Coca-Cola', 2, 100, 'Drinks', 'Coca-Cola'),
(2, 'Sprite', 'Sprite', 2, 100, 'Drinks', 'Coca-Cola'),
(3, 'Pepsi', 'Pepsi', 2, 100, 'Drinks', 'Coca-Cola'),
(4, 'Cadbury', 'Cadbury', 2, 100, 'Sweets', 'Cadbury'),
(5, 'Mars', 'Mars', 2, 100, 'Sweets', 'Mars'),
(6, 'Snickers', 'Snickers', 2, 100, 'Sweets', 'Mars'),
(7, 'M&Ms', 'M&Ms', 2, 100, 'Sweets', 'Mars'),
(8, 'Hershey', 'Hershey', 2, 100, 'Sweets', 'Mars'),
(9, 'Dove', 'Dove', 2, 100, 'Sweets', 'Mars'),
(10, 'KitKat', 'KitKat', 2, 100, 'Sweets', 'Mars'),
(11, 'Twix', 'Twix', 2, 100, 'Sweets', 'Mars'),
(12, 'Nestle', 'Nestle', 2, 100, 'Sweets', 'Mars'),
(13, 'Kinder', 'Kinder', 2, 100, 'Sweets', 'Mars'),
(14, 'Lays', 'Lays', 2, 100, 'Sweets', 'Mars'),
(15, 'Bounty', 'Bounty', 2, 100, 'Sweets', 'Mars'),
(16, 'Bounty', 'Bounty', 2, 100, 'Sweets', 'Mars'),
(17, 'Bounty', 'Bounty', 2, 100, 'Sweets', 'Mars'),
(18, 'Bounty', 'Bounty', 2, 100, 'Sweets', 'Mars');


