(ns everplaintext.core
    (:require
        [net.cgrand.enlive-html :as html])
    (:gen-class))

(defn resource-from-file [filename] (html/html-resource (java.io.StringReader. (.getAbsolutePath filename))))

(defn text-from-html [filename]
    (first
        ((first 
            (html/select 
                (resource-from-file filename) [:body])) 
        :content)))

(defn -main [& args] 
    (try 
        (loop [file (.listFiles (new java.io.File (first args)))]
            (println (text-from-html file)))
        (catch java.io.FileNotFoundException e (println "File not found."))))
