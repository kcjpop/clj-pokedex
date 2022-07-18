(ns user
  (:require [integrant.repl :as ig-repl]
            [integrant.core :as ig]
            [integrant.repl.state :as state]
            [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [cheffy.server]))

(ig-repl/set-prep!
 (fn [] cheffy.server/config))

(def go ig-repl/go)
(def halt ig-repl/halt)
(def reset ig-repl/reset)
(def reset-all ig-repl/reset-all)

(def app (-> state/system :cheffy/app))

(def db (jdbc/get-datasource (:db/sqlite cheffy.server/config)))

(comment
  (app {:request-method :get
        :uri "/manga"})
  (jdbc/execute! db ["select rowid, name from foo limit 10;"])
  (sql/query db ["select rowid, name from foo limit 10;"])
  (sql/find-by-keys db :foo {:rowid 1})
  (go)
  (reset)
  )
