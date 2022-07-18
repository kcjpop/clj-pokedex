(ns cheffy.manga.routes)

(defn get-all-manga [req]
  {:status 200
   :body "Hello Manga"})

(defn routes
  [env]
  ["/manga" {:get {:handler get-all-manga}}])
