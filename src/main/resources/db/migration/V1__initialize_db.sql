CREATE TABLE "role" (
  "id" uuid PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL
);

CREATE TABLE "user" (
  "id" uuid PRIMARY KEY,
  "first_name" varchar NOT NULL,
  "last_name" varchar,
  "middle_name" varchar,
  "role_id" uuid NOT NULL,
  "created_at" timestamp NOT NULL,
  "phone" integer NOT NULL,
  "email" varchar NOT NULL
);

CREATE TABLE "phone" (
  "id" uuid PRIMARY KEY,
  "model_id" uuid NOT NULL
);

CREATE TABLE "phone_mark" (
  "id" uuid PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL
);

CREATE TABLE "phone_model" (
  "id" uuid PRIMARY KEY,
  "mark_id" uuid NOT NULL,
  "name" varchar UNIQUE NOT NULL
);

CREATE TABLE "specific_phone" (
  "id" uuid PRIMARY KEY,
  "phone_id" uuid NOT NULL,
  "inventory_number" varchar UNIQUE NOT NULL
);

CREATE TABLE "specific_phone_book" (
  "id" uuid PRIMARY KEY,
  "specific_phone_id" uuid NOT NULL,
  "created_at" timestamp NOT NULL,
  "returned_at" timestamp,
  "user_id" uuid NOT NULL
);

CREATE TABLE "technology_to_phone" (
  "phone_id" uuid NOT NULL,
  "technology_id" uuid NOT NULL
);

CREATE TABLE "band_to_phone" (
  "phone_id" uuid NOT NULL,
  "band_id" uuid NOT NULL
);

CREATE TABLE "band" (
  "id" uuid PRIMARY KEY,
  "name" varchar NOT NULL,
  "sub_name" varchar NOT NULL,
  "channel" varchar NOT NULL
);

CREATE TABLE "technology" (
  "id" uuid PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL
);

ALTER TABLE "phone" ADD FOREIGN KEY ("model_id") REFERENCES "phone_model" ("id");

ALTER TABLE "phone_model" ADD FOREIGN KEY ("mark_id") REFERENCES "phone_mark" ("id");

ALTER TABLE "user" ADD FOREIGN KEY ("role_id") REFERENCES "role" ("id");

ALTER TABLE "specific_phone" ADD FOREIGN KEY ("phone_id") REFERENCES "phone" ("id");

ALTER TABLE "specific_phone_book" ADD FOREIGN KEY ("specific_phone_id") REFERENCES "specific_phone" ("id");

ALTER TABLE "specific_phone_book" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "technology_to_phone" ADD FOREIGN KEY ("phone_id") REFERENCES "phone" ("id");

ALTER TABLE "technology_to_phone" ADD FOREIGN KEY ("technology_id") REFERENCES "technology" ("id");

ALTER TABLE "band_to_phone" ADD FOREIGN KEY ("phone_id") REFERENCES "phone" ("id");

ALTER TABLE "band_to_phone" ADD FOREIGN KEY ("band_id") REFERENCES "band" ("id");