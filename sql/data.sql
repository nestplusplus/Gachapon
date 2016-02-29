insert into 
	account (user_name, mailaddress, password, location, registered_date, modified_date, super_flag, resign_flag)
	values ('一般ユーザー','user@com','1234','渋谷','2015-11-20','2015-11-21',FALSE, FALSE)
	, ('スーパーユーザー','superuser@com','1234','新宿','2015-11-22','2015-11-23',TRUE, FALSE);
	
insert into
	account (user_name, mailaddress, password, location, registered_date, modified_date, super_flag, resign_flag)
	values ('一般ユーザー','user@com','1234','渋谷','2015-11-20','2015-11-21',FALSE, FALSE)
	, ('スーパーユーザー','superuser@com','1234','新宿','2015-11-22','2015-11-23',TRUE, FALSE);
	
﻿insert into 
	account (user_name, mailaddress, password, location, registered_date, modified_date, super_flag, resign_flag)
	values ('aaa','aaa@com','1234','渋谷','2015-11-20','2015-11-21',FALSE, FALSE)
	, ('bbb','bbb@com','1234','新宿','2015-11-22','2015-11-23',TRUE, FALSE);
	
insert into
	company (company_name, location, image_path, intro, registered_date, modified_date, delete_flag)
	values ('aaa', '新宿', '/img/aaa.png', 'おいしいaaa', '2015-11-20', '2015-11-21', FALSE)
	, ('渋谷  bazz', '渋谷', '/img/sibuya_bazz_1.png', '渋谷最安値！完全個室で個室でお昼のカラオケ歌い放題＆飲み放題、最大6時間1680円～', '2015-12-9', '2015-2-1', FALSE)
	, ('新鮮食材と美食ダイニング　膳', '神楽坂', '/img/zenn_1.png', '歓迎会、送別会に！２H飲み放題2480～', '2015-11-20', '2015-11-21', FALSE);

insert into
	company_user (company_id, user_name, mailaddress, password, registered_date, modified_date, resign_flag)
	values (1, 'aaa', 'aaa@com', '12345', '2015-11-20', '2015-11-21', FALSE)
	, (2, 'おくむられお', 'okumura@com', '12345', '2015-11-20', '2015-11-21', FALSE)
	, (3, 'たなかあつし', 'tanaka@com', '12345', '2015-12-20', '2016-1-21', FALSE);
	
insert into
	offer_gacha (company_id, registered_by, name, image_path, content, rate, period, registered_date, modified_date, delete_flag)
	values (1, 1, 'aaa', '/img/gacha1.png', 'ドリンク1杯無料', 0.8, '2016-3-21', '2016-2-10','2016-2-10', FALSE)
	, (2, 2, 'ドリンクサービス', '/img/gacha2.png', 'こちらのガチャクーポンをご来店時に提示していただくと、ドリンク1杯無料でサービスいたします！', 0.8, '2016-3-21', '2016-2-10','2016-2-10', FALSE)
	, (2, 2, 'おつまみ一品サービス', '/img/gacha3.png', 'こちらのガチャクーポンをご来店時に提示していただくと、お好きなおつまみを1品無料でサービスいたします！', 0.5, '2016-3-21', '2016-2-10','2016-2-10', FALSE)
	, (3, 3, 'ドリンクサービス', '/img/gacha4.png', 'こちらのガチャクーポンをご注文時に提示していただくと、ドリンク1杯無料でサービスいたします！', 0.6, '2016-3-21', '2016-2-19','2016-2-19', FALSE)
	, (3, 3, 'お通しサービス', '/img/gacha5.png', 'こちらのガチゃクーポンをご来店時に提示で、お通し無料サービス！', 0.7, '2016-4-21', '2016-2-18','2016-2-18', FALSE)	;

insert into 
	possesion_gacha (user_id, gacha_id, registered_date, modified_date, use_flag)
	values (1, 1, '2016-2-20', '2016-2-20', FALSE)
	,(1, 2, '2016-2-20', '2016-2-20', TRUE)
	,(1, 2, '2016-2-20', '2016-2-20', FALSE)
	,(2, 3, '2016-2-20', '2016-2-20', FALSE)
	,(2, 4, '2016-2-20', '2016-2-20', TRUE);
