(ns cheffy.router
  (:require [reitit.ring :as ring]
            [cheffy.manga.routes :as manga]))

(defn routes
  [env]
  (ring/ring-handler
   (ring/router
    [(manga/routes env)])))
