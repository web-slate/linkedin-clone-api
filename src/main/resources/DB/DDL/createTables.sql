
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