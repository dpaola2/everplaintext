(ns everplaintext.core
    (:require
        [net.cgrand.enlive-html :as html])
    (:gen-class))

(import [java.io File] 
        [java.io StringReader]
        [java.io FileNotFoundException])

(defn resource-from-file [filename] (html/html-resource (StringReader. (slurp filename))))

(defn text-from-html [html-string]
    (first
        ((first 
            (html/select 
                html-string [:body])) 
        :content)))

(defn list-filenames [directory] 
    (map 
        #(.getAbsolutePath %) 
        (filter 
            #(if (.isFile %) 
                true 
                false) 
            (.listFiles (File. directory)))))

(defn -main [& args] 
    (try 
        (map 
            (fn [filename] 
                (do (
                    (println (str "Reading " filename "..."))
                    text-from-html (resource-from-file filename))))
            (list-filenames (first args)))
        (catch FileNotFoundException e (println "File not found."))))
