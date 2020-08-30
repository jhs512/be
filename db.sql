# 데이터베이스 생성
DROP DATABASE IF EXISTS be;
CREATE DATABASE be;
USE be;

# 회원 테이블 생성
CREATE TABLE `member` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(40) NOT NULL,
    loginPw VARCHAR(150) NOT NULL,
    `name` CHAR(20) NOT NULL,
    nickname CHAR(20) NOT NULL
);

# 관리자 회원 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`name` = '관리자',
nickname = '관리자';

# 일반회원 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
`name` = '유저2',
nickname = '유저2';

# 게시물 테이블 생성
CREATE TABLE `article` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` LONGTEXT NOT NULL
);

# 임시 게시물 생성
INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
title = '제목1',
`body` = '내용1';

# 임시 게시물 생성
INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
title = '제목2',
`body` = '내용2';

# 임시 게시물 생성
INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
title = '제목3',
`body` = '내용3';

# 게시판 테이블 추가
CREATE TABLE `board` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `code` CHAR(20) UNIQUE NOT NULL,
    `name` CHAR(20) UNIQUE NOT NULL
);

# 공지 게시판 추가
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지';

# 자유 게시판 추가
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유';

# 게시물 테이블에 게시판 번호 추가
ALTER TABLE article ADD COLUMN boardId INT(10) UNSIGNED NOT NULL AFTER updateDate;

# 기존 미분류 게시물들을 자유게시판으로 설정
UPDATE article
SET boardId = 2
WHERE boardId = 0;

# 게시물 테이블에서 게시판 별 분류를 빠르게 하기 위해 인덱스 걸기
ALTER TABLE `article` ADD INDEX (`boardId`); 
