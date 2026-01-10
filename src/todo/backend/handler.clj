(ns todo.backend.handler
  "Este namespace define nossas 'funções de resposta' (Handlers)."
  (:require [todo.backend.db :as db]
            [clojure.string :as str]))

;; -------------------------
;; Handler já existente
;; -------------------------
(defn hello-handler
  "Nosso primeiro handler. Ele apenas diz 'Olá, Mundo!'"
  [_request]
  {:status 200
   :body "Hello, World!"})

;; -------------------------
;; NOVOS HANDLERS
;; -------------------------

;; --- Handler para Listar Todos ---
(defn list-todos-handler
  "Handler para a rota GET /api/todos."
  [_request]
  {:status 200
   :body {:todos (db/get-all-todos)}})

;; --- Handler para Criar um Todo ---
(defn create-todo-handler
  "Handler para a rota POST /api/todos."
  [request]
  (let [todo-data (:body request)
        title (:title todo-data)]

    (if (and title (not (str/blank? title)))
      ;; Sucesso
      (let [new-todo (db/create-todo todo-data)]
        {:status 201
         :body new-todo})

      ;; Erro de validação
      {:status 400
       :body {:error "O 'título' (title) é obrigatório"}})))
