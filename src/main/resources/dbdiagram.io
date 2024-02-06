Table role {
  id uuid [primary key]
  name varchar [not null, unique]
}

Table user {
  id uuid [primary key]
  first_name varchar [not null]
  last_name varchar
  middle_name varchar
  role_id uuid [not null]
  created_at timestamp [not null]
  phone integer [not null]
  email varchar [not null]
}

Table phone {
  id uuid [primary key]
  model_id uuid [not null]
  technology varchar [not null]
}

Table phone_mark {
  id uuid [primary key]
  name varchar [unique, not null]
}

Table phone_model {
  id uuid [primary key]
  phone_mark_id uuid [not null]
  name varchar [unique, not null]
}

Table specific_phone {
  id uuid [primary key]
  phone_id uuid [not null]
  inventory_number varchar [unique, not null]
}

Table specific_phone_book {
  id uuid [primary key]
  specific_phone_id uuid [not null]
  created_at timestamp [not null]
  returned_at timestamp [not null]
  user_id uuid [not null]
}

Table band {
  id uuid [primary key]
  name varchar [not null, unique]
  phone_id uuid [not null]
}

Table channel {
  id uuid [primary key]
  name varchar [not null, unique]
  band_id uuid [not null]
}

Ref: phone.model_id > phone_model.id // many-to-one

Ref: phone_model.phone_mark_id > phone_mark.id // many-to-one

Ref: user.role_id > role.id // many-to-one

Ref: specific_phone.phone_id > phone.id // many-to-one

Ref: specific_phone_book.specific_phone_id > specific_phone.id // many-to-one

Ref: specific_phone_book.user_id > user.id // many-to-one

Ref: band.phone_id > phone.id // many-to-one

Ref: channel.band_id > band.id // many-to-one