(ns cheffy.superheroes.routes
  (:require [cheffy.superheroes.db :as superheroes-db]))

(defn get-all [db]
  (fn [req]
    {:status 200
     :body (superheroes-db/get-all db)}))

(defn routes
  [env]
  ["/superheroes" {:get {:handler (get-all (:db env))}}])
