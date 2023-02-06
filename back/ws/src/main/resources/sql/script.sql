-- CREATE TABLE --



-- ALTER TABLE --
ALTER TABLE public.recipe ADD id_user int4 default 1;
ALTER TABLE public.shopping_list ADD id_user int4 default 1;
ALTER TABLE public.recipe ADD CONSTRAINT fk_recipe_user FOREIGN KEY (id_user) REFERENCES public."user"(id);
ALTER TABLE public.shopping_list ADD CONSTRAINT fk_shopping_list_user FOREIGN KEY (id_user) REFERENCES public."user"(id);


-- INSERT DATA --



-- UPDATE DATA --
