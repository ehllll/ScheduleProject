CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          content VARCHAR(255) NOT NULL,
                          writer VARCHAR(100) NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          created_at DATETIME NOT NULL,
                          modified_at DATETIME NOT NULL
);
