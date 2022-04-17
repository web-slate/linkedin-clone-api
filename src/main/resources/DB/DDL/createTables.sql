
CREATE TABLE public.t_user_feed (
    user_id varchar NOT NULL,
    legalname varchar NULL,
    occupation varchar NULL,
    companyname varchar NULL,
    feedmsg varchar NULL,
    totallike varchar NULL,
    totalcomment varchar NULL,
    "comment" varchar NULL,
    connectiontype varchar NULL,
    feed_id int4 NOT NULL GENERATED ALWAYS AS IDENTITY
);


CREATE TABLE public.t_login (
    user_id varchar NOT NULL,
    "password" varchar NOT NULL,
    CONSTRAINT login_pk PRIMARY KEY (user_id)
);

CREATE TABLE public.t_user_profile (
    user_id varchar NOT NULL,
    first_name varchar NULL,
    last_name varchar NULL,
    profile_id int4 NOT NULL GENERATED ALWAYS AS IDENTITY
);

CREATE TABLE public.t_experience (
    user_id varchar NOT NULL,
    title varchar NULL,
    employment_type varchar NULL,
    company_name varchar NULL,
    location varchar NULL,
    active varchar NULL,
    start_date varchar NULL,
    end_date varchar NULL,
    description varchar NULL,
    experience_id int4 NOT NULL GENERATED ALWAYS AS IDENTITY
);