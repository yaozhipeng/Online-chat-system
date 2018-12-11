show tables;

create table user (
  id       VARCHAR(50) NOT NULL, -- 用户ID
  email    VARCHAR(50), -- 用户邮箱
  password VARCHAR(50), -- 用户用MD5计算散列后的密码
  PRIMARY KEY (id)       -- 设置主键
);


create table information (
  user_id VARCHAR(50),
  name    VARCHAR(100), -- 昵称
  gender  INT, -- 0女 1男 否则其他
  motto   VARCHAR(200), -- 个性签名
  school  VARCHAR(50), -- 学校
  phone   VARCHAR(20), -- 电话
  PRIMARY KEY (user_id) -- 设置主键
);

create table relation (
  to_id   VARCHAR(50) NOT NULL,
  from_id VARCHAR(50) NOT NULL, -- from_id有to_id的好友
  state   INT, -- 0未验证 --1已验证
  PRIMARY KEY (to_id, from_id)
);

create table message (
  to_id   VARCHAR(50) NOT NULL,
  from_id VARCHAR(50) NOT NULL,  -- from_id向to_id发送消息
  content VARCHAR(300),           -- 消息内容
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