USE mycardb;
ALTER TABLE tbl_carmanager;
ALTER TABLE tbl_carmanager MODIFY c_seq INT NOT NULL AUTO_INCREMENT;
SELECT * FROM tbl_carmanager;

INSERT INTO tbl_carmanager(c_carnum, c_qty, c_username, c_sdate, c_stime, c_skm)
VALUES ('002', '출근', 'elquineas', '2023-07-18', '07:30:00', '0');

UPDATE tbl_carmanager
   SET c_qty = '출장'
 WHERE c_seq = 1;
