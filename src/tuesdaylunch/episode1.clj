(ns tuesdaylunch.episode1
  (:use [clojure.string :only [join]]))
 
(defn -main [& args]
  (println (str "hello worlds: " (join ", " args))))
  