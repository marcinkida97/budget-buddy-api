--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1 (Debian 16.1-1.pgdg120+1)
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: super_admin
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO super_admin;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: super_admin
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: budget_entities; Type: TABLE; Schema: public; Owner: super_admin
--

CREATE TABLE public.budget_entities (
    entity_id uuid NOT NULL,
    amount real,
    budget_id uuid NOT NULL,
    category character varying(255),
    date date,
    type character varying(255)
);


ALTER TABLE public.budget_entities OWNER TO super_admin;

--
-- Name: budgets; Type: TABLE; Schema: public; Owner: super_admin
--

CREATE TABLE public.budgets (
    budget_id uuid NOT NULL,
    budget_constraints_id uuid,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.budgets OWNER TO super_admin;

--
-- Name: budgets_constraints; Type: TABLE; Schema: public; Owner: super_admin
--

CREATE TABLE public.budgets_constraints (
    budget_constraint_id uuid NOT NULL,
    budget_id uuid,
    is_primary boolean
);


ALTER TABLE public.budgets_constraints OWNER TO super_admin;

--
-- Name: budgets_users; Type: TABLE; Schema: public; Owner: super_admin
--

CREATE TABLE public.budgets_users (
    budget_users_ids uuid NOT NULL,
    users_budgets_ids uuid NOT NULL
);


ALTER TABLE public.budgets_users OWNER TO super_admin;

--
-- Name: users; Type: TABLE; Schema: public; Owner: super_admin
--

CREATE TABLE public.users (
    user_id uuid NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);


ALTER TABLE public.users OWNER TO super_admin;

--
-- Data for Name: budget_entities; Type: TABLE DATA; Schema: public; Owner: super_admin
--

COPY public.budget_entities (entity_id, amount, budget_id, category, date, type) FROM stdin;
99af2ce2-a7e5-41c6-a12d-b0e0a5eb5aaf	5000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Salary	2024-01-10	Income
56b71f4f-86ef-4549-b872-a060115bfb45	5000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Salary	2023-12-08	Income
94e3eb33-623f-498f-9a27-ef0ff935ce70	5000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Salary	2023-11-10	Income
f8f7633a-3bfc-4423-9fb5-63e3eb2732ae	5000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Salary	2023-10-10	Income
a117ab13-4cdb-4033-805b-7834be30066f	5000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Salary	2023-09-08	Income
1be715d0-4021-4dc2-bdab-4972d872293c	2000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Rent	2023-09-11	Expense
271fc3eb-0d83-4d7e-a009-268ce391bc53	2000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Rent	2023-10-11	Expense
f6a16a5a-aa7a-42df-ae44-9fd2b60cc7a5	2000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Rent	2023-11-13	Expense
adbc693c-3000-4882-93d3-6e11a646fc67	2000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Rent	2023-12-11	Expense
04e550dd-a50f-4cc5-a1ad-66c67905c865	2000	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Rent	2024-01-11	Expense
7d3199c7-a340-4c56-9e07-4ae3f3a03996	254	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Groceries	2024-01-27	Expense
f898d115-ff40-46f2-a383-4a2ef9b7486a	1	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Other	2024-02-01	Income
be10836c-9bd9-4d3f-8e1e-f40a6d82c4a5	50	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Cinema	2024-01-15	Expense
afe76b70-a040-47d9-927c-abfada374119	500	93a5a36e-3eeb-47d9-b78b-8da8ce912c46	Xmass gifts	2024-02-22	Expense
\.


--
-- Data for Name: budgets; Type: TABLE DATA; Schema: public; Owner: super_admin
--

COPY public.budgets (budget_id, budget_constraints_id, description, name) FROM stdin;
93a5a36e-3eeb-47d9-b78b-8da8ce912c46	13d28535-3567-42a4-b88e-f17b8135418d	My primary budget	My budget
\.


--
-- Data for Name: budgets_constraints; Type: TABLE DATA; Schema: public; Owner: super_admin
--

COPY public.budgets_constraints (budget_constraint_id, budget_id, is_primary) FROM stdin;
13d28535-3567-42a4-b88e-f17b8135418d	\N	t
\.


--
-- Data for Name: budgets_users; Type: TABLE DATA; Schema: public; Owner: super_admin
--

COPY public.budgets_users (budget_users_ids, users_budgets_ids) FROM stdin;
59ed0bbb-29bb-4478-866d-686f818cfbfd	93a5a36e-3eeb-47d9-b78b-8da8ce912c46
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: super_admin
--

COPY public.users (user_id, email, first_name, last_name, password, role) FROM stdin;
59ed0bbb-29bb-4478-866d-686f818cfbfd	mk@email.com	Marcin	Kida	$2a$10$YeHiLVqwf1o27iuodrhtVexLg3YFnZu0zThzKHhoed8sGizsxtklC	USER
\.


--
-- Name: budget_entities budget_entities_pkey; Type: CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budget_entities
    ADD CONSTRAINT budget_entities_pkey PRIMARY KEY (entity_id, budget_id);


--
-- Name: budgets_constraints budgets_constraints_pkey; Type: CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budgets_constraints
    ADD CONSTRAINT budgets_constraints_pkey PRIMARY KEY (budget_constraint_id);


--
-- Name: budgets budgets_pkey; Type: CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budgets
    ADD CONSTRAINT budgets_pkey PRIMARY KEY (budget_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: budgets_users fkdtcc8udpa9603kiwaip84219w; Type: FK CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budgets_users
    ADD CONSTRAINT fkdtcc8udpa9603kiwaip84219w FOREIGN KEY (budget_users_ids) REFERENCES public.users(user_id);


--
-- Name: budget_entities fkggc2hp6a97tbqblghss2dj2gi; Type: FK CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budget_entities
    ADD CONSTRAINT fkggc2hp6a97tbqblghss2dj2gi FOREIGN KEY (budget_id) REFERENCES public.budgets(budget_id);


--
-- Name: budgets_users fko7u4fq9t44wofd5tofdu8qda4; Type: FK CONSTRAINT; Schema: public; Owner: super_admin
--

ALTER TABLE ONLY public.budgets_users
    ADD CONSTRAINT fko7u4fq9t44wofd5tofdu8qda4 FOREIGN KEY (users_budgets_ids) REFERENCES public.budgets(budget_id);


--
-- PostgreSQL database dump complete
--

