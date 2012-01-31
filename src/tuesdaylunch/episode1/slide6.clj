(ns tuesdaylunch.episode1.slide6
  (:use [clojure.string :only [join]]))
 
(defn -main [& args]
  (println (str "hello worlds: " (join ", " args))))

; from REPL
; (use 'tuesdaylunch.episode1.slide6)
; (-main "Frogstar World A" "Frogstar B" "Frogstar World C")


