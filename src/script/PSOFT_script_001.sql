-- Ser executado somente se não tiver sido criado o usuario 'postgres' 
CREATE USER postgres WITH PASSWORD 'postgres';
-- 

-- criacao da DATABASE necessária para a aplicação
CREATE DATABASE "trabalhoPSOFT"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;