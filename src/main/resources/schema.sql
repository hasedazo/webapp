-- テーブルが存在したら削除する
DROP TABLE IF EXISTS todos;

-- テーブルの作成
CREATE TABLE todos (
 --id(することID):PK
 id serial PRIMARY KEY,
 --todo(すること): Not NULL
 todo varchar(255) NOT NULL,
 --detail(説明)
 detail text,
 --create_at(作成日)
 created_at timestamp without time zone,
 --update_at(更新日)
 updated_at timestamp without time zone
); 

--ログイン用
-- テーブルが存在したら削除する
DROP TABLE IF EXISTS apiauth;
-- テーブルの作成
CREATE TABLE apiauth (
 --client_ip(クライアントIPアドレス):PK
 client_ip varchar(10),
 --api_key(APIキー): PK
 api_key varchar(10),
 --ninka(認可対象業務)
 ninka varchar(10),
 --start_at(開始日)
 start_at timestamp without time zone,
 --end_at(終了日)
 end_at timestamp without time zone,
 --primaryキーの設定
 primary key(client_ip, api_key)
 );
