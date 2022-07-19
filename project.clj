(defproject cheffy "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[clj-http "3.10.0"]
                 [environ "1.2.0"]
                 [hashp "0.2.1"]
                 [integrant "0.8.0"]
                 [metosin/reitit "0.5.5"]
                 [ring "1.8.1"]
                 [seancorfield/next.jdbc "1.2.659"]
                 [sqlitejdbc "0.5.6"]
                 [org.clojure/clojure "1.11.1"]]
  :injections [(require 'hashp.core)]
  :main ^:skip-aot cheffy.server
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:source-paths ["dev/src"]
                   :resource-paths ["dev/resources"]
                   :dependencies [[integrant/repl "0.3.2"]]}})
