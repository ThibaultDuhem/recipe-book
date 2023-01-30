-- CREATE TABLE --

CREATE TABLE utensil
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    picture VARCHAR(100)
);

CREATE TABLE "user"
(
    id INT PRIMARY KEY NOT NULL,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    pseudo VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
	birth DATE,
	email VARCHAR(100) NOT NULL
);

CREATE TABLE utensil_recipe
(
    id INT PRIMARY KEY NOT NULL,
    id_utensil INT,
    id_recipe INT
);

CREATE TABLE shopping_list
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    quantity FLOAT
);

CREATE TABLE shopping_list_ingredient
(
    id_ingredient INT NOT NULL,
	id_shopping_list INT NOT NULL
);

CREATE TABLE stock
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
	id_user INT
);

CREATE TABLE stock_ingredient
(
    id_ingredient INT NOT NULL,
	id_stock INT NOT NULL,
	quantity FLOAT
);

CREATE TABLE recipe_book
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    creation_date DATE NOT NULL,
    modification_date DATE NOT NULL
);

CREATE TABLE recipe_book_recipe
(
    id INT PRIMARY KEY NOT NULL,
    id_recipe INT NOT NULL,
	id_recipe_book INT NOT NULL
);

-- ALTER TABLE --

ALTER TABLE recipe ADD steps int NULL;
ALTER TABLE recipe ADD number_persons int NULL;
ALTER TABLE recipe ALTER COLUMN number_persons SET DEFAULT 0;
ALTER TABLE recipe ALTER COLUMN steps SET DEFAULT 0;
ALTER TABLE recipe ALTER COLUMN rating SET DEFAULT 0;
ALTER TABLE recipe ALTER COLUMN preparation_time SET DEFAULT 0;
ALTER TABLE recipe ALTER COLUMN cooking_time SET DEFAULT 0;
ALTER TABLE recipe ALTER COLUMN difficulty SET DEFAULT 0;

-- MAJ Thibault 23/01/2023--
ALTER TABLE ingredient ALTER COLUMN average_price SET DEFAULT 0;
ALTER TABLE recipe_book ALTER COLUMN author SET DEFAULT 0;
ALTER TABLE recipe_book_recipe ALTER COLUMN id_recipe SET DEFAULT 0;
ALTER TABLE recipe_book_recipe ALTER COLUMN id_recipe_book SET DEFAULT 0;
ALTER TABLE recipe_ingredient ALTER COLUMN id_ingredient SET DEFAULT 0;
ALTER TABLE recipe_ingredient ALTER COLUMN id_recipe SET DEFAULT 0;
ALTER TABLE recipe_ingredient ALTER COLUMN quantity SET DEFAULT 0;
ALTER TABLE shopping_list ALTER COLUMN quantity SET DEFAULT 0;
ALTER TABLE shopping_list_ingredient ALTER COLUMN id_ingredient SET DEFAULT 0;
ALTER TABLE shopping_list_ingredient ALTER COLUMN id_shopping_list SET DEFAULT 0;
ALTER TABLE stock ALTER COLUMN id_user SET DEFAULT 0;
ALTER TABLE stock_ingredient ALTER COLUMN quantity SET DEFAULT 0;
ALTER TABLE stock_ingredient ALTER COLUMN id_ingredient SET DEFAULT 0;
ALTER TABLE stock_ingredient ALTER COLUMN id_stock SET DEFAULT 0;
ALTER TABLE utensil_recipe ALTER COLUMN id_utensil SET DEFAULT 0;
ALTER TABLE utensil_recipe ALTER COLUMN id_recipe SET DEFAULT 0;

alter table recipe add constraint pk_recipe primary key (id);
alter table recipe_book add constraint pk_recipe_book primary key (id);
alter table recipe_book_recipe add constraint fk_recipe_book_recipe foreign key (id_recipe) references recipe(id);
alter table recipe_book_recipe add constraint fk_recipe_book_recipe2 foreign key (id_recipe_book) references recipe_book(id);
alter table recipe_book_recipe add constraint pk_recipe_book_recipe primary key (id_recipe,id_recipe_book);
-- INSERT DATA --

-- UPDATE DATA --
UPDATE ingredient                SET average_price    =0 where average_price   = NULL;
UPDATE recipe_book               SET author           =0 where author          = NULL;
UPDATE recipe_book_recipe        SET id_recipe        =0 where id_recipe       = NULL;
UPDATE recipe_book_recipe        SET id_recipe_book   =0 where id_recipe_book  = NULL;
UPDATE recipe_ingredient         SET id_ingredient    =0 where id_ingredient   = NULL;
UPDATE recipe_ingredient         SET id_recipe        =0 where id_recipe       = NULL;
UPDATE recipe_ingredient         SET quantity         =0 where quantity        = NULL;
UPDATE shopping_list             SET quantity         =0 where quantity        = NULL;
UPDATE shopping_list_ingredient  SET id_ingredient    =0 where id_ingredient   = NULL;
UPDATE shopping_list_ingredient  SET id_shopping_list =0 where id_shopping_list= NULL;
UPDATE stock                     SET id_user          =0 where id_user         = NULL;
UPDATE stock_ingredient          SET quantity         =0 where quantity        = NULL;
UPDATE stock_ingredient          SET id_ingredient    =0 where id_ingredient   = NULL;
UPDATE stock_ingredient          SET id_stock         =0 where id_stock        = NULL;
UPDATE utensil_recipe            SET id_utensil       =0 where id_utensil      = NULL;
UPDATE utensil_recipe            SET id_recipe        =0 where id_recipe       = NULL;