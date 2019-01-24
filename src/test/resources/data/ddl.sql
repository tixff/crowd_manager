CREATE TABLE `item` (
  `id`                   int(11) NOT NULL                     AUTO_INCREMENT
  COMMENT '项目id',
  `uid`                  int(11)                              DEFAULT NULL
  COMMENT '联系人id',
  `cid`                  int(11)                              DEFAULT NULL
  COMMENT '类目id',
  `name`                 varchar(255)                         DEFAULT NULL
  COMMENT '项目名称',
  `intro`                varchar(255)                         DEFAULT NULL
  COMMENT '项目简介',
  `short_title`          varchar(255)                         DEFAULT NULL
  COMMENT '短标题',
  `current_money`        double                               DEFAULT NULL
  COMMENT '当前筹集资金',
  `raise_money`          double                               DEFAULT NULL
  COMMENT '筹款金额',
  `financing_days`       int(5)                               DEFAULT NULL
  COMMENT '筹款时间',
  `image`                varchar(255)                         DEFAULT NULL
  COMMENT '图片',
  `contribute_num`       int(10)                              DEFAULT NULL
  COMMENT '贡献人数',
  `linkman_name`         varchar(255)                         DEFAULT NULL,
  `linkman_introduction` varchar(255)
                                                              DEFAULT NULL
  COMMENT '自我介绍',
  `linkman_email`        varchar(255)                         DEFAULT NULL,
  `linkman_phone`        varchar(255)
                                                              DEFAULT NULL
  COMMENT '联系电话',
  `linkman_qr_code`      varchar(255)
                                                              DEFAULT NULL
  COMMENT '收款二维码',
  `create_time`          datetime                             DEFAULT NULL,
  `update_time`          datetime                             DEFAULT NULL,
  `status`               int(5)                               DEFAULT NULL
  COMMENT '项目状态（0:正常 1:删除）',
  PRIMARY KEY (`id`)
);
