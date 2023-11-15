drop database if exists spring_mvc_db;
create database spring_mvc_db;
use spring_mvc_db;

create table category
(
    id int primary key auto_increment,
    name varchar(255) not null
)
;

create table product
(
    id          int primary key auto_increment,
    name        varchar(255) not null,
    price       float        not null,
    description text,
    category_id int          not null,
    constraint fk_ci_product foreign key (category_id) references category (id),
    status bit(1) not null
);

insert into category (name) values ('Thực phẩm'), ('Trang phục'), ('Đồ gia dụng'), ('Thiết bị điện tử');

insert into product (name, price, description, category_id, status) values
('Thịt ba chỉ', 100000, 'Thịt lợn sạch CP', 1, 1),
('Rau muống VietGAP', 10000, 'Rau trồng theo tiêu chuẩn VietGAP', 1, 0),
('Quần kaki', 230000, 'Sản phẩm của nhà may Viettien', 2, 1),
('Áo Hoodie', 450000, 'Hàng nội địa Trung Quốc', 2, 0),
('Đế hâm nóng đồ uống', 150000, 'Giữ đồ uống luôn ở 55 độ C', 3, 0),
('Tăm nước', 95000, 'Tặng kèm 4 đầu tăm', 4, 1)                 ;

# get all product
delimiter //
create procedure getAllProduct()
begin
    select * from product;
end //
delimiter ;

# add product
delimiter //
create procedure addProduct(pName varchar(255), pPrice float, pDescription text, pCategoryId int, pStatus bit(1))
begin
    insert into product (name, price, description, category_id, status) VALUES (pName, pPrice, pDescription, pCategoryId, pStatus);
end //
delimiter ;

# get product by id
delimiter //
create procedure getProductById(pId int)
begin
    select * from product where id = pId;
end //
delimiter ;

# update product
delimiter //
create procedure updateProductById(pName varchar(255), pPrice float, pDescription text, pCategoryId int, pStatus bit(1), pId int)
begin
    update product set name = pName, price = pPrice, description = pDescription, category_id = pCategoryId, status = pStatus where id = pId;
end //
delimiter ;

# update product
delimiter //
create procedure deleteProductById(pId int)
begin
    delete from product where id = pId;
end //
delimiter ;