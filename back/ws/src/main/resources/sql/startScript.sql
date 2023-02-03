-- CREATE TABLE --
CREATE TABLE public.ingredient (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	picture varchar NULL,
	average_price float4 NULL DEFAULT 0,
	description varchar NULL
);
CREATE UNIQUE INDEX ingredient_id_idx ON public.ingredient USING btree (id);

CREATE TABLE public.recipe (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	"type" varchar NOT NULL,
	rating int4 NULL DEFAULT 0,
	preparation_time int4 NULL DEFAULT 0,
	cooking_time int4 NULL DEFAULT 0,
	difficulty int4 NULL DEFAULT 0,
	picture varchar NULL,
	"comment" varchar NULL,
	steps int4 NULL DEFAULT 0,
	number_persons int4 NULL DEFAULT 0,
	CONSTRAINT pk_recipe PRIMARY KEY (id)
);
CREATE UNIQUE INDEX recipe_id_idx ON public.recipe USING btree (id);

CREATE TABLE public.recipe_book (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	creation_date date NOT NULL,
	modification_date date NOT NULL,
	author int4 NULL DEFAULT 0,
	CONSTRAINT recipe_book_pkey PRIMARY KEY (id)
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
	quantity int4 NULL DEFAULT 0,
	CONSTRAINT pk_recipe_ingredient PRIMARY KEY (id_recipe, id_ingredient),
	CONSTRAINT fk_recipe_ingredient FOREIGN KEY (id_recipe) REFERENCES public.recipe(id),
	CONSTRAINT fk_recipe_ingredient2 FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id)
);

CREATE TABLE public.shopping_list (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT shopping_list_pkey PRIMARY KEY (id)
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
	id_user int4 NULL DEFAULT 0,
	CONSTRAINT stock_pkey PRIMARY KEY (id)
);

CREATE TABLE public.stock_ingredient (
	id_ingredient int4 NOT NULL DEFAULT 0,
	id_stock int4 NOT NULL DEFAULT 0,
	quantity float8 NULL DEFAULT 0,
	CONSTRAINT pk_stock_ingredient PRIMARY KEY (id_stock, id_ingredient),
	CONSTRAINT fk_stock_ingredient FOREIGN KEY (id_stock) REFERENCES public.stock(id),
	CONSTRAINT fk_stock_ingredient2 FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id)
);

CREATE TABLE public."user" (

	id serial4 NOT NULL,
	firstname varchar(100) NULL,
	lastname varchar(100) NULL,
	pseudo varchar(100) NOT NULL,
	"password" varchar(100) NOT NULL,
	birth date NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
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