create table role
(
    id integer not null
        constraint role_pkey
            primary key,
    name varchar(255)
);

create table subject
(
    id integer not null
        constraint subject_pkey
            primary key,
    name varchar(255)
);

create table users
(
    id integer not null
        constraint users_pkey
            primary key,
    email varchar(255),
    name varchar(255),
    password varchar(255)
);

create table student
(
    id integer not null
        constraint student_pkey
            primary key,
    form varchar(255),
    user_id integer
        constraint fkk0thg920a3xk3v59yjbsatw1l
            references users
);

create table mark
(
    id integer not null
        constraint mark_pkey
            primary key,
    mark integer,
    date_time timestamp(6),
    student_id integer
        constraint fkcwocngy0rfmqdhqwm3qlrfamx
            references student,
    subject_id integer
        constraint fkt6kc1aolba30ld4m8fqmcrt1q
            references subject
);

create table homework
(
    id integer not null
        constraint homework_pkey
            primary key,
    form varchar(255),
    mark_id integer
        constraint fk9loexjg4kpmrm66kg1ww03pea
            references mark,
    student_id integer
        constraint fkj2kmp9xbvs3l61bya88ljudfe
            references student,
    subject_id integer
        constraint fk2kd5kaavry4vb9t349g82pab1
            references subject
);

create table teacher
(
    id integer not null
        constraint teacher_pkey
            primary key,
    user_id integer
        constraint fkcp1vpkh4bh0qux9vtvs0fkwrn
            references users
);

create table lesson
(
    id integer not null
        constraint lesson_pkey
            primary key,
    end_time timestamp(6),
    start_time timestamp(6),
    topic varchar(255),
    week_day integer,
    homework_id integer
        constraint fkp5jd2e9wphyhlq9r6xlqy140l
            references homework,
    subject_id integer
        constraint fk7ydr23s8y9j6lip5qrngoymx4
            references subject,
    teacher_id integer
        constraint fk9yhaoqrjxt5gwmn6icp1lf35n
            references teacher
);

create table teacher_subjects
(
    teacher_id integer not null
        constraint fkjkx6egayo8f0yrpjb1fychxbq
            references teacher,
    subjects_id integer not null
        constraint fk590r5o8kjhiwyp96jylu9yw3o
            references subject
);

