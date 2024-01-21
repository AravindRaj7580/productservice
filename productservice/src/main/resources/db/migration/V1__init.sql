CREATE TABLE category
(
    id          BINARY(16) NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    name        VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch VARCHAR(255) NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id         BIGINT NOT NULL,
    start_time VARCHAR(255) NULL,
    end_time   VARCHAR(255) NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch VARCHAR(255) NULL,
    CONSTRAINT pk_msc_student PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    start_time VARCHAR(255) NULL,
    end_time   VARCHAR(255) NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id          BINARY(16) NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE price
(
    id          BINARY(16) NOT NULL,
    created_at  datetime NULL,
    modified_at datetime NULL,
    currency    VARCHAR(255) NULL,
    title       VARCHAR(255) NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16) NOT NULL,
    created_at    datetime NULL,
    modified_at   datetime NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    category_id   BINARY(16) NULL,
    image         VARCHAR(255) NULL,
    price_id      BINARY(16) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE products_orders
(
    orders_id   BINARY(16) NOT NULL,
    products_id BINARY(16) NOT NULL
);

CREATE TABLE st_user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_type  INT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch      VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    start_time VARCHAR(255) NULL,
    end_time   VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    start_time VARCHAR(255) NULL,
    end_time   VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_order FOREIGN KEY (orders_id) REFERENCES orders (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_product FOREIGN KEY (products_id) REFERENCES product (id);