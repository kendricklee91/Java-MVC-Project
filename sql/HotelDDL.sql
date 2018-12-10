-- 객실유형
DROP TABLE room_type cascade constraint;

-- 객실
DROP TABLE room cascade constraint;

-- 호텔
DROP TABLE hotel cascade constraint;

-- 예약
DROP TABLE reserve cascade constraint;

-- 회원
DROP TABLE member cascade constraint;


CREATE TABLE room_type(
 room_type NUMBER(2) PRIMARY KEY,
 room_desc VARCHAR2(30));

CREATE TABLE room(
 room_id NUMBER(3) PRIMARY KEY,
 room_price VARCHAR2(10),
 room_check VARCHAR2(10),
 room_type NUMBER(2) NOT NULL,
 hotel_id VARCHAR2(5) NOT NULL);

CREATE TABLE hotel(
 hotel_id VARCHAR2(5) PRIMARY KEY,
 hotel_name VARCHAR2(30) NOT NULL,
 hotel_grade NUMBER(1) NOT NULL,
 hotel_location VARCHAR2(10),
 hotel_phone VARCHAR2(20));
	
CREATE TABLE reserve(
 reserve_no NUMBER(5) PRIMARY KEY,
 people_count NUMBER(2),
 stay_period VARCHAR2(5),
 reserve_check VARCHAR2(10),
 reserve_cost VARCHAR2(30),
 hotel_id VARCHAR2(5) NOT NULL,
 member_id NUMBER(5) NOT NULL,
 room_id NUMBER(3) NOT NULL);
	
CREATE TABLE member(
 member_id NUMBER(5) PRIMARY KEY,
 member_name VARCHAR2(5) NOT NULL,
 member_mobile VARCHAR2(20));


ALTER TABLE room ADD FOREIGN KEY (room_type) REFERENCES room_type (room_type);

ALTER TABLE room ADD FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id);

ALTER TABLE reserve ADD FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id);

ALTER TABLE reserve ADD FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE reserve ADD FOREIGN KEY (room_id) REFERENCES room (room_id);