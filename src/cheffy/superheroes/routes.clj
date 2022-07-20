(ns cheffy.superheroes.routes
  (:require [ring.util.response :as rr]
            [cheffy.superheroes.db :as superheroes-db]))

(defn get-all [db]
  (fn [req]
    (rr/response (superheroes-db/get-all db))))

(defn routes
  [env]
  ["/superheroes" {:get {:handler (get-all (:db env))}}])
