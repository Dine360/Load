-- Table: public.loads

-- DROP TABLE IF EXISTS public.loads;

CREATE TABLE IF NOT EXISTS public.loads
(
    id integer NOT NULL,
    loading_point text COLLATE pg_catalog."default",
    unloading_point text COLLATE pg_catalog."default",
    product_type text COLLATE pg_catalog."default",
    truck_type text COLLATE pg_catalog."default",
    no_of_truck integer,
    weight double precision,
    date_of_booking date,
    comments text COLLATE pg_catalog."default",
    shipper_id uuid,
    CONSTRAINT "Id" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.loads
    OWNER to postgres;