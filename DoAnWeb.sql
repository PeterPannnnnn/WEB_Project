use WebBanHang;

Create table Products (
	productID nvarchar(50) primary key,
	nameProduct nvarchar(200),
	description nvarchar(500),
	price float,
	imageURL  nvarchar(500),
	categoryID nvarchar(50)
);

Create table Categories(
	categoryID nvarchar(50) primary key,
	nameCategory nvarchar(200)
)

Create table Customers (
	customerID int Identity(1,1) primary key,
	username nvarchar(100),
	password  nvarchar(50),
	nameCustomer nvarchar(100),
	numberPhone varchar(20),
	email nvarchar(50),
	address nvarchar(200)
)
Create table Orders(
	orderID nvarchar(50) primary key,
	customerID int references Customers(customerID),
	orderDate smalldatetime,
	totalAmount float
)

Create table OrderItems(
	orderItemID nvarchar(50) primary key,
	orderID nvarchar(50) references Orders(orderID),
	productID nvarchar(50) references Products(productID),
	quantity smallint
)
alter table products add constraint FK_Product Foreign Key (categoryID) references Categories(categoryID) 

select * from Customers