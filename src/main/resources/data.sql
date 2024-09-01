-- 1件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('買い物','スーパーで食材を購入する',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
-- 2件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('図書館に行く','本を借りる',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
-- 3件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('ジムに行く','運動する',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


-- 認証用のデータ登録
INSERT INTO apiauth (client_ip, api_key, ninka, start_at, end_at)
VALUES
('10.100.100','abcdefghij','login',TO_TIMESTAMP('2024/04/01 00:00:00','YYYY/MM/DD HH24:MI:SS'),TO_TIMESTAMP('2025/09/10 00:00:00', 'YYYY/MM/DD HH24:MI:SS'));