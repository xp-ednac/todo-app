(ns todo.backend.core
  (:require
   [ring.adapter.jetty :as jetty]
   [reitit.ring :as ring]
   [todo.backend.handler :as handler]

   [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
   [ring.middleware.keyword-params :refer [wrap-keyword-params]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.middleware.cors :refer [wrap-cors]])
  (:gen-class))

;; -------------------------
;; 1. Definição das Rotas
;; -------------------------
(def app-routes
  (ring/router
   ["/api"
    ["/hello"
     {:get {:handler handler/hello-handler}}]

    ["/todos"
     {:get  {:handler handler/list-todos-handler}
      :post {:handler handler/create-todo-handler}}]]))

;; -------------------------
;; 2. Aplicação Ring
;; -------------------------
(def app
  (ring/ring-handler
   app-routes
   (ring/create-default-handler)
   {:middleware [;; --- ADICIONE ESTE VETOR ---
                 ;; Ele deve ser o primeiro da lista
                 [wrap-cors :access-control-allow-origin [#"http://localhost:8000"]
                            :access-control-allow-methods [:get :post :put :delete]]

                 ;; O resto dos middlewares...
                 wrap-json-response
                 [wrap-json-body {:keywords? true}]
                 wrap-params
                 wrap-keyword-params
                ]}))

;; -------------------------
;; 3. Inicialização do servidor
;; -------------------------
(defn start-server [port]
  (println (str "Servidor iniciado na porta " port))
  (jetty/run-jetty #'app {:port port :join? false}))

;; -------------------------
;; 4. Função principal
;; -------------------------
(defn -main [& args]
  (let [port (Integer/parseInt (or (first args) "3000"))]
    (start-server port)))
