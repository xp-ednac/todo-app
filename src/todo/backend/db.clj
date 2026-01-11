(ns todo.backend.db
  (:require
   [next.jdbc :as jdbc]
   [next.jdbc.sql :as sql]))

;; -------------------------
;; Configuração do banco
;; -------------------------
(def db-spec
  {:dbtype "sqlite"
   :dbname "prod.db"})

(def datasource
  (jdbc/get-datasource db-spec))

;; -------------------------
;; Inicialização do banco
;; -------------------------
(defn initialize-database! []
  (jdbc/execute!
   datasource
   ["CREATE TABLE IF NOT EXISTS todos (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      title TEXT NOT NULL,
      description TEXT,
      completed INTEGER DEFAULT 0,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )"])
  (println "Banco SQLite inicializado (prod.db)."))

;; -------------------------
;; Operações
;; -------------------------
(defn get-all-todos []
  (sql/query datasource ["SELECT * FROM todos"]))

(defn create-todo [{:keys [title description]}]
  (sql/insert!
   datasource
   :todos
   {:title title
    :description description
    :completed 0}))

(defn toggle-todo! [id]
  (jdbc/execute!
   datasource
   ["UPDATE todos
     SET completed = CASE completed WHEN 0 THEN 1 ELSE 0 END
     WHERE id = ?"
    id]))
