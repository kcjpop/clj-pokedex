(ns cheffy.router
  (:require [reitit.ring :as ring]
            [cheffy.manga.routes :as manga]
            [cheffy.superheroes.routes :as superheroes]))

(defn routes
  [env]
  (ring/ring-handler
   (ring/router
    [(manga/routes env)
     (superheroes/routes env)])))
