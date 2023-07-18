-- 차계부
CREATE DATABASE mycarDB;
use mycardb;

CREATE TABLE tbl_carmanager(
	c_seq	BIGINT		PRIMARY KEY,
	c_carnum	VARCHAR(15)	NOT NULL,	
	c_qty	VARCHAR(10)	NOT NULL	,
	c_username	VARCHAR(20)	NOT NULL,	
	c_sdate	VARCHAR(10)	NOT NULL	,
	c_stime	VARCHAR(10)	NOT NULL	,
	c_goal	VARCHAR(30)		,
	c_edate	VARCHAR(10)		,
	c_etime	VARCHAR(10)		,
	c_skm	INT		,
	c_ekm	INT		,
	c_cost	INT		
)