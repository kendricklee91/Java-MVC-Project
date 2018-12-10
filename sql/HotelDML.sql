-- room_type insert[객실 유형 저장]
insert into room_type values(1, ‘스탠다드 더블룸’);
insert into room_type values(2, ‘프리미어 스위트’);
insert into room_type values(3, ‘로얄 스위트’);

-- room insert[객실 저장] insert into room values
insert into room values(101, ‘30000’, ‘yes’, 1, ‘SH’);
insert into room values(111, ‘30000’, ‘no’, 1, ‘SH’);
insert into room values(102, ‘40000’, ‘no’, 2, ‘SH’);
insert into room values(103, ‘50000’, ‘no’, 3, ‘SH’);
insert into room values(113, ‘50000’, ‘no’, 3, ‘SH’);

insert into room values(201, ‘10000’, ‘yes’, 1, ‘LO’);
insert into room values(211, ‘10000’, ‘no’, 1, ‘LO’);
insert into room values(202, ‘20000’, ‘no’, 2, ‘LO’);
insert into room values(203, ‘30000’, ‘no’, 3, ‘LO’);

insert into room values(301, ‘20000’, ‘yes’, 1, ‘HH’);
insert into room values(311, ‘20000’, ‘no’, 1, ‘HH’);
insert into room values(302, ‘30000’, ‘no’, 2, ‘HH’);
insert into room values(303, ‘40000’, ‘no’, 3, ‘HH’);

insert into room values(401, ‘30000’, ‘yes’, 1, ‘PR’);
insert into room values(411, ‘30000’, ‘no’, 1, ‘PR’);
insert into room values(402, ‘40000’, ‘no’, 2, ‘PR’);
insert into room values(403, ‘50000’, ‘no’, 3, ‘PR’);
insert into room values(413, ‘50000’, ‘no’, 3, ‘PR’);

-- hotel insert[호텔 저장]
insert into hotel values(‘SH’, ‘신라호텔’, 5, ‘서귀포’, ‘064-1234-5678’);
insert into hotel values(‘LO’, ‘롯데호텔’, 3, ‘서울’, ‘02-1234-5678’);
insert into hotel values(‘HH’, ‘한화리조트해운대’, 4, ‘부산’, ‘051-1234-5678’);
insert into hotel values(‘PR’, ‘파라다이스 시티’ , 5, ‘인천’, ‘032-1234-5678’);

-- reserve insert[예약 저장] insert into reserve values
insert into reserve values(1, 2, ‘3일’, ‘완료’, ‘90000’, ‘SH’, 10001, 101);
insert into reserve values(2, 2, ‘2일’, ‘완료’, ‘20000’, ‘LO’, 10101, 201);
insert into reserve values(3, 2, ‘3일’, ‘완료’, ‘60000’, ‘HH’, 11111, 301);
insert into reserve values(4, 2, ‘2일’, ‘완료’, ‘60000’, ‘PR’, 11011, 401);

-- member insert[회원 저장] insert into member values
insert into member values(10001, ‘SMITH’, ‘010-1234-5678’);
insert into member values(10101, ‘BLAKE’, ‘010-2345-6781’);
insert into member values(11111, ‘FORD’, ‘010-3456-7812’);
insert into member values(11011, ‘JAMES’, ‘010-4567-8123’);

commit;
