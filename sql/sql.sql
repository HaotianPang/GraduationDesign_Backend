drop table if exists data_set_info;

drop table if exists dataset_request_record;

drop table if exists environmental_installation;

drop table if exists field_info;

drop table if exists field_type;

drop table if exists match_method;

drop table if exists platporm_user;

drop table if exists qr_code;

drop table if exists tai_security_user;

drop table if exists user_type;

/*==============================================================*/
/* Table: data_set_info                                         */
/*==============================================================*/
create table data_set_info
(
    id                   bigint unsigned not null default 0 comment '主键id',
    user_id              bigint unsigned not null default 0 comment '主键id',
    dataset_name         varchar(128) not null default "" comment '数据集名称',
    dataset_description  varchar(512) not null default "" comment '数据集描述',
    dataset_tag          varchar(512) not null default "" comment '标签',
    dataset_path         varchar(512) not null default "" comment '文件路径',
    open_to_ttai         bool not null default 0 comment '对平台开放标识，true flase',
    open_to_demand_side  bool not null default 0 comment '对需求方显示，先对平台开放才可以对需求方开放',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table data_set_info comment '数据集信息表';

/*==============================================================*/
/* Table: dataset_request_record                                */
/*==============================================================*/
create table dataset_request_record
(
    id                   bigint unsigned not null default 0 comment '主键id',
    demand_id            bigint unsigned not null default 0 comment '需求方id',
    provider_id          bigint unsigned not null default 0 comment '提供方id',
    dataset_id           bigint unsigned not null default 0 comment '数据集信息表id',
    policy               varchar(512) not null default "" comment '策略',
    dataset_usage        varchar(64) not null default "" comment '数据的用途',
    consent_flag         bool not null default 0 comment '成交标识',
    objection_reason     varbinary(128) not null default "" comment '驳回理由',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table dataset_request_record comment '数据请求记录表（工单）';

/*==============================================================*/
/* Table: environmental_installation                            */
/*==============================================================*/
create table environmental_installation
(
    id                   bigint unsigned not null default 0 comment '主键id',
    user_id              bigint unsigned not null default 0 comment '用户表id',
    terminal_no          varchar(32) not null default "" comment '弱隐私计算环境所在机器的mac地址的MD5值',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table environmental_installation comment '环境表主要作用在于控制用户的终端安装个数，用户在不同机器上安装弱隐私环境需获取许可';

/*==============================================================*/
/* Table: field_info                                            */
/*==============================================================*/
create table field_info
(
    id                   bigint unsigned not null default 0 comment '主键id',
    dataset_id           bigint default 0 comment '数据集信息表主键id',
    match_method_id      bigint default 0 comment '字段匹配算法表主键id',
    result_type_id       bigint unsigned not null default 0 comment '最终结果类型,类型包含原字段、支持隐私计算-差分隐私、不支持隐私计算-MD5、无',
    field_name           varchar(64) default "" comment '字段名',
    field_description    varchar(512) not null default "" comment '描述',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table field_info comment '数据集中字段表';

/*==============================================================*/
/* Table: field_type                                            */
/*==============================================================*/
create table field_type
(
    id                   bigint unsigned not null default 0 comment '主键id',
    type_name            varchar(64) not null default "" comment '类型名字',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table field_type comment '字段最终结果表';

/*==============================================================*/
/* Table: match_method                                          */
/*==============================================================*/
create table match_method
(
    id                   bigint unsigned not null default 0 comment '主键id',
    method_name          varchar(64) not null default "" comment '方法名称',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table match_method comment '字段合法匹配算法表';

/*==============================================================*/
/* Table: platporm_user                                         */
/*==============================================================*/
create table platporm_user
(
    id                   bigint unsigned not null default 0 comment '主键id',
    user_type_id         bigint not null default 0 comment '用户类型（个人，企业）',
    user_name            varchar(64) not null default "" comment '用户名称',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id),
    key AK_Key_1 (id)
);

alter table platporm_user comment '用户表，使用弱隐私计算产品的用户，有个人也有企业还有政府机构等';

/*==============================================================*/
/* Table: qr_code                                               */
/*==============================================================*/
create table qr_code
(
    id                   bigint unsigned not null comment '主键id',
    user_id              bigint unsigned not null default 0 comment '态安全用户id',
    status               boolean not null default 0 comment '二维码状态',
    del_sign             boolean not null default 0 comment '删除标识',
    gmt_create           datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table qr_code comment '二维码表';

/*==============================================================*/
/* Table: tai_security_user                                     */
/*==============================================================*/
create table tai_security_user
(
    id                   bigint unsigned not null auto_increment comment '主键id',
    user_id              bigint unsigned not null default 0 comment '主键id',
    cotp_id              varchar(256) not null default "" comment 'cotp标识',
    cotp                 varchar(600) not null default "" comment 'cotp',
    ttai_account         varchar(11) not null default "" comment '态安全账号',
    ip                   varchar(15) not null default "" comment 'ip地址',
    account_id           varchar(256) not null default "" comment '用户标识',
    is_active            boolean not null default 0 comment '激活标识',
    gmt_create           datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table tai_security_user comment '态安全用户表';

/*==============================================================*/
/* Table: user_type                                             */
/*==============================================================*/
create table user_type
(
    id                   bigint unsigned not null auto_increment comment '主键id',
    type_name            varchar(64) not null default "" comment '用户类型名称',
    comment              varchar(128) not null default "" comment '说明',
    gmt_create           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    gmt_modified         timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table user_type comment '用户类型表';