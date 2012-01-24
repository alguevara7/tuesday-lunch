(ns tuesdaylunch.episode1
  (:use [clojure.string :only [join]]))
 
(defn -main [& args]
  (println (str "hello worlds: " (join ", " args))))

; from REPL
(-main "Frogstar World A" "Frogstar B" "Frogstar World C")

(if true :truthy :falsey)
(if [] :truthy :falsey)
(if nil :truthy :falsey)
(if false :truthy :falsey)