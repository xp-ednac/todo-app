(ns todo.backend.db)

;; -------------------------
;; "Banco de dados" em memória
;; -------------------------
(defonce todos-db (atom []))
(defonce id-counter (atom 0))

;; -------------------------
;; Inicialização do banco
;; -------------------------
(defn initialize-database!
  "Inicializa o banco de dados (em memória por enquanto)."
  []
  (reset! todos-db [])
  (reset! id-counter 0)
  (println "Banco de dados inicializado."))

;; -------------------------
;; Operações
;; -------------------------
(defn get-all-todos []
  @todos-db)

(defn create-todo [todo]
  (let [id (swap! id-counter inc)
        new-todo (assoc todo
                        :id id
                        :completed false)]
    (swap! todos-db conj new-todo)
    new-todo))
