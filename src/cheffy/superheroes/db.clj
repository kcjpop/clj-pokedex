(ns cheffy.superheroes.db
  (:require [next.jdbc.sql :as sql]))

(defn get-all [db]
  (let [all (sql/query db ["select * from superheroes limit 10"])]
    all))
