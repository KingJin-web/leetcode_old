create table A
(
    ACCT_MONTH       varchar(6) not null comment '出帐月',
    USER_NO          int(15)    not null comment '用户编码',
    TELE_TYPE        varchar(6) comment '业务类型',
    TOTAL_CHARGE     int comment '合计',
    CALL_FEE         int comment '通话费',
    RENT_FEE         int comment '月租费',
    MOBILE_FEE       int comment '本地移动费',
    LONG_FEE         int comment '长话费',
    INTLONG_FEE      int comment '国际长途费',
    ROAM_FEE         int comment '漫游费',
    ROAM_INTLONG_FEE int comment '漫游国际长途费',
    ROAM_LONG_FEE    int comment '漫游国内长途费',
    DATA_FEE         int comment '数据费',
    INCREMENT_FEE    int comment '增值业务费',
    SMS_FEE          int comment '短信费',
    SPECIAL_FEE      int comment '特服费',
    MON_FEE          int comment '包月费',
    OTHER_FEE        int comment '其他费',
    SP_FEE           int comment 'SP费',
    CONSENT_FEE      int comment '承诺费'
);

create table B
(
    ACCT_MONTH    varchar(6) not null comment '出帐月',
    USER_NO       int(15)    not null comment '用户编码',
    TOTAL_CHARGE  int comment '总费用',
    TELE_TYPE     varchar(6) comment '业务类型',
    CDR_NUM       int comment '话单数',
    CALL_DURATION int comment '通话时长',
    IS_ZERO_CALL  char(1) comment '是否零通话标志'

);

2.	定义
?	出账用户
每月末合账时，产生费用的用户。

?	未出账用户
每月末合账时，未产生费用的用户，该类用户不会在表中出现。

?	零通话
用户在当月未产生语音通话。

?	非零通话
用户在当月有语音通话。

?	正常出账用户
用户在当月是出账用户并且是非零通话。

?	非正常出账用户
用户在当月是未出账用户，或者用户在当月是出账用户但是零通话。

?	流失用户
用户在上月是正常出账用户，但在当月是非正常出账用户。

