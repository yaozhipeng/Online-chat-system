show tables;

create table user (
  userid       VARCHAR(50) NOT NULL, -- 用户ID
  email    VARCHAR(50), -- 用户邮箱
  password VARCHAR(50), -- 用户用MD5计算散列后的密码
  PRIMARY KEY (id)       -- 设置主键
);


create table information (
  userId VARCHAR(50) PRIMARY KEY ,
  name    VARCHAR(100), -- 名字
  gender  INT, -- 0女 1男
  habit VARCHAR(200), -- 签名
  address  VARCHAR(50), -- 学校
  phone   VARCHAR(20) -- 电话

);

create table relation (
  relationId INT PRIMARY KEY AUTO_INCREMENT,
  to_id   VARCHAR(50) NOT NULL,
  from_id VARCHAR(50) NOT NULL, -- from_id有to_id的好友
  state   INT -- 0未验证 --1已验证
  -- PRIMARY KEY (to_id, from_id)
);

create table message (
  to_id   VARCHAR(50) NOT NULL,
  from_id VARCHAR(50) NOT NULL,  -- from_id向to_id发送消息
  content VARCHAR(3000),           -- 消息内容
  time    TIMESTAMP   NOT NULL,  -- 消息的时间
  PRIMARY KEY (to_id, from_id, time)
);

create table impression (
  to_id       VARCHAR(50) NOT NULL,
  from_id     VARCHAR(50) NOT NULL,  -- from_id对to_id的印象评价
  description VARCHAR(100),           -- 印象内容
  PRIMARY KEY (to_id, from_id)
);


drop table user;
drop table information;
drop table relation;
drop table message;
drop table impression;