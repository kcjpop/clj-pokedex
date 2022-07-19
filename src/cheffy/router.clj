(ns cheffy.router
  (:require [reitit.ring :as ring]
            [reitit.ring.middleware.muuntaja :as mw-muuntaja]
            [muuntaja.core :as m]
            [cheffy.manga.routes :as manga]
            [cheffy.superheroes.routes :as superheroes]))

(def router-config
  {:data {:muuntaja m/instance
          :middleware [mw-muuntaja/format-middleware]}})

(defn routes
  [env]
  (ring/ring-handler
   (ring/router
    [(manga/routes env)
     (superheroes/routes env)]
    router-config)))
