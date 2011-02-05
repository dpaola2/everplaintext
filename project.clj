(defproject everplaintext "1.0.0-SNAPSHOT"
  :description "Evernote-to-plaintext converter"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [enlive "1.0.0-SNAPSHOT"]]
  :aot [everplaintext.core]
  :main everplaintext.core)
