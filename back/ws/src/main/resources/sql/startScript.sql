-- CREATE TABLE --
CREATE TABLE public.ingredient (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	picture varchar NULL,
	average_price float4 DEFAULT 0,
	description varchar NULL,
    CONSTRAINT pk_ingredient PRIMARY KEY (id)
);

CREATE TABLE public.recipe (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	"type" varchar NOT NULL,
	rating int4 DEFAULT 0,
	preparation_time int4 DEFAULT 0,
	cooking_time int4 DEFAULT 0,
	difficulty int4 DEFAULT 0,
	picture varchar NULL,
	"comment" varchar NULL,
	steps int4 DEFAULT 0,
	number_persons int4 DEFAULT 0,
	id_user int4 DEFAULT 1,
	CONSTRAINT pk_recipe PRIMARY KEY (id),
	CONSTRAINT fk_recipe_user FOREIGN KEY (id_user) REFERENCES public."user"(id)
);

CREATE TABLE public."user" (

	id serial4 NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	pseudo varchar(100) NOT NULL,
	"password" varchar(100) NOT NULL,
	birth date NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE public.recipe_book (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	creation_date date NOT NULL,
	modification_date date NOT NULL,
	id_user int4 NOT NULL DEFAULT 1,
	CONSTRAINT pk_recipe_book PRIMARY KEY (id),
	CONSTRAINT fk_recipe_book_user FOREIGN KEY (id_user) REFERENCES public."user"(id),
);

CREATE TABLE public.recipe_book_recipe (
	id_recipe int4 NOT NULL DEFAULT 0,
	id_recipe_book int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_recipe_book_recipe PRIMARY KEY (id_recipe, id_recipe_book),
	CONSTRAINT fk_recipe_book_recipe FOREIGN KEY (id_recipe) REFERENCES public.recipe(id),
	CONSTRAINT fk_recipe_book_recipe2 FOREIGN KEY (id_recipe_book) REFERENCES public.recipe_book(id)
);

CREATE TABLE public.recipe_ingredient (
	id_recipe int4 NOT NULL DEFAULT 0,
	id_ingredient int4 NOT NULL DEFAULT 0,
	quantity int4 DEFAULT 0,
	CONSTRAINT pk_recipe_ingredient PRIMARY KEY (id_recipe, id_ingredient),
	CONSTRAINT fk_recipe_ingredient FOREIGN KEY (id_recipe) REFERENCES public.recipe(id),
	CONSTRAINT fk_recipe_ingredient2 FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id)
);

CREATE TABLE public.shopping_list (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	id_user int4 DEFAULT 1,
	CONSTRAINT pk_shopping_list PRIMARY KEY (id),
	CONSTRAINT fk_shopping_list_user FOREIGN KEY (id_user) REFERENCES public."user"(id)
);

CREATE TABLE public.shopping_list_ingredient (
	id_ingredient int4 NOT NULL DEFAULT 0,
	id_shopping_list int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_shopping_list_ingredient PRIMARY KEY (id_shopping_list, id_ingredient),
	CONSTRAINT fk_shopping_list_ingredient FOREIGN KEY (id_shopping_list) REFERENCES public.shopping_list(id),
	CONSTRAINT fk_shopping_list_ingredient2 FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id)
);

CREATE TABLE public.stock (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	id_user int4 DEFAULT 1,
	CONSTRAINT pk_stock PRIMARY KEY (id),
	CONSTRAINT fk_stock_user FOREIGN KEY (id_user) REFERENCES public."user"(id)
);

CREATE TABLE public.stock_ingredient (
	id_ingredient int4 NOT NULL DEFAULT 0,
	id_stock int4 NOT NULL DEFAULT 0,
	quantity float8 DEFAULT 0,
	CONSTRAINT pk_stock_ingredient PRIMARY KEY (id_stock, id_ingredient),
	CONSTRAINT fk_stock_ingredient FOREIGN KEY (id_stock) REFERENCES public.stock(id),
	CONSTRAINT fk_stock_ingredient2 FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id)
);

CREATE TABLE public.utensil (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	picture varchar(100) NULL,
	CONSTRAINT ustensile_pkey PRIMARY KEY (id)
);

CREATE TABLE public.utensil_recipe (
	id_utensil int4 NOT NULL DEFAULT 0,
	id_recipe int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_utensil_recipe PRIMARY KEY (id_recipe, id_utensil),
	CONSTRAINT fk_utensil_recipe FOREIGN KEY (id_recipe) REFERENCES public.recipe(id),
	CONSTRAINT fk_utensil_recipe2 FOREIGN KEY (id_utensil) REFERENCES public.utensil(id)
);


-- INSERT DATA --

INSERT INTO ingredient ("name") VALUES ('Tomate');
INSERT INTO ingredient ("name") VALUES ('Ail');
INSERT INTO ingredient ("name") VALUES ('Oeufs');

INSERT INTO recipe (name, type) VALUES ('Recette 1', 'Type1');
INSERT INTO recipe (name, type) VALUES ('Recette 2', 'Type1');
INSERT INTO recipe (name, type) VALUES ('Recette 3', 'Type2');

INSERT INTO "user" (pseudo, "password", email) VALUES ('Toto', 'toto', 'toto@gmail.com');

INSERT INTO recipe_book (name, creation_date, modification_date, id_user) VALUES ('Livre 1', current_timestamp, current_timestamp, 1);
INSERT INTO recipe_book (name, creation_date, modification_date, id_user) VALUES ('Livre 2', current_timestamp, current_timestamp, 1);

INSERT INTO recipe_book_recipe (id_recipe, id_recipe_book) VALUES (1, 2);
INSERT INTO recipe_book_recipe (id_recipe, id_recipe_book) VALUES (2, 2);

INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES (1, 1, 2);
INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES (1, 2, 1);
INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES (1, 3, 6);
INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES (2, 3, 20);

INSERT INTO shopping_list (name) VALUES ('Ma liste de course');

INSERT INTO shopping_list_ingredient (id_shopping_list, id_ingredient) VALUES (1, 1);
INSERT INTO shopping_list_ingredient (id_shopping_list, id_ingredient) VALUES (1, 2);
INSERT INTO shopping_list_ingredient (id_shopping_list, id_ingredient) VALUES (1, 3);

INSERT INTO stock ("name", id_user) VALUES ('Stock 1',1);

INSERT INTO stock_ingredient (id_stock, id_ingredient, quantity) VALUES (1, 1, 5);
INSERT INTO stock_ingredient (id_stock, id_ingredient, quantity) VALUES (1, 2, 3);
INSERT INTO stock_ingredient (id_stock, id_ingredient, quantity) VALUES (1, 3, 50);

INSERT INTO utensil ("name") VALUES ('Spatule');
INSERT INTO utensil ("name") VALUES ('Casserole');
INSERT INTO utensil ("name") VALUES ('Couteau');

INSERT INTO utensil_recipe (id_recipe, id_utensil) VALUES (1, 1);
INSERT INTO utensil_recipe (id_recipe, id_utensil) VALUES (1, 2);
INSERT INTO utensil_recipe (id_recipe, id_utensil) VALUES (1, 3);
INSERT INTO utensil_recipe (id_recipe, id_utensil) VALUES (2, 3);
INSERT INTO utensil_recipe (id_recipe, id_utensil) VALUES (3, 3);