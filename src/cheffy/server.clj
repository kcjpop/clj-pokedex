(ns cheffy.server
  (:require [ring.adapter.jetty :as jetty]
            [integrant.core :as ig]
            [cheffy.router :as router])
  (:gen-class))


(defn app
  [env]
  (router/routes env))

(def config
  {:server/jetty {:handler (ig/ref :cheffy/app)
                  :port 5000}
   :cheffy/app {:jdbc-url (ig/ref :db/sqlite)}
   :db/sqlite {:dbtype "sqlite" :dbname "resources/test.db"}})

(defmethod ig/init-key
  :server/jetty
  [_ {:keys [handler port]}]
  (println (str "Server running at http://localhost:" port))
  (jetty/run-jetty handler {:port port :join? false}))

(defmethod ig/init-key :cheffy/app
  [_ config]
  (app config))

(defmethod ig/init-key :db/sqlite
  [_ config]
  (:jdbc-url config))

(defmethod ig/halt-key! :server/jetty
  [_ jetty]
  (.stop jetty))

(defn -main
  []
  (ig/init config))
